package thebetweenlands.tileentities;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import thebetweenlands.TheBetweenlands;
import thebetweenlands.blocks.BLBlockRegistry;
import thebetweenlands.items.BLItemRegistry;
import thebetweenlands.items.SwampTalisman.TALISMAN;
import thebetweenlands.network.packet.AltarCraftingProgressMessage;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityDruidAltar extends TileEntityBasicInventory  {

	@SideOnly(Side.CLIENT)
	public float rotation;
	@SideOnly(Side.CLIENT)
	public float renderRotation;
	@SideOnly(Side.CLIENT)
	public float renderYOffset;
	@SideOnly(Side.CLIENT)
	private static final float ROTATION_SPEED = 2.0F;

	public int craftingProgress = 0;

	//11 seconds crafting time
	public static final int CRAFTING_TIME = 20*11;

	public TileEntityDruidAltar() {
		super(5, "druidAltar");
	}

	@Override
	public void updateEntity() {
		if (worldObj.isRemote) {
			rotation += ROTATION_SPEED;
			if (rotation >= 360.0F) {
				rotation -= 360.0F;
				renderRotation -= 360.0F;
			}
			if(craftingProgress != 0) {
				++craftingProgress;
			}
		} else {
			if(craftingProgress != 0) {
				//Sync clients every second
				if(this.craftingProgress % 20 == 0 || this.craftingProgress == 1) {
					sendCraftingProgressPacket();
				}
				++craftingProgress;

				//TODO Temporary fix
				int slot1 = 0, slot2 = 0, slot3 = 0, slot4 = 0;
				if (inventory[1] != null) {
					slot1 = getStackInSlot(1).getItemDamage();
				}
				if (inventory[2] != null) {
					slot2 = getStackInSlot(2).getItemDamage();
				}
				if (inventory[3] != null) {
					slot3 = getStackInSlot(3).getItemDamage();
				}
				if (inventory[4] != null) {
					slot4 = getStackInSlot(4).getItemDamage();
				}
				if (slot1 + slot2 + slot3 + slot4 != 10 || inventory[0] != null)  {
					if(this.craftingProgress != 0) {
						this.stopCraftingProcess();
					}
				}

				if(craftingProgress >= CRAFTING_TIME) {
					ItemStack stack = new ItemStack(BLItemRegistry.swampTalisman, 1, TALISMAN.swampTalisman.ordinal());
					setInventorySlotContents(1, null);
					setInventorySlotContents(2, null);
					setInventorySlotContents(3, null);
					setInventorySlotContents(4, null);
					setInventorySlotContents(0, stack);
					this.stopCraftingProcess();
					this.removeSpawner();
				}
			}
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	private void removeSpawner() {
		if(worldObj.getBlock(xCoord, yCoord - 1, zCoord) == BLBlockRegistry.druidSpawner)
			worldObj.setBlock(xCoord, yCoord - 1, zCoord, Blocks.grass);
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack is) {
		inventory[slot] = is;
		if (is != null && is.stackSize > getInventoryStackLimit()) {
			is.stackSize = getInventoryStackLimit();
		}
		int slot1 = 0, slot2 = 0, slot3 = 0, slot4 = 0;
		if (inventory[1] != null) {
			slot1 = getStackInSlot(1).getItemDamage();
		}
		if (inventory[2] != null) {
			slot2 = getStackInSlot(2).getItemDamage();
		}
		if (inventory[3] != null) {
			slot3 = getStackInSlot(3).getItemDamage();
		}
		if (inventory[4] != null) {
			slot4 = getStackInSlot(4).getItemDamage();
		}
		if(slot1 + slot2 + slot3 + slot4 == 10 && is != null) {
			if(inventory[0] == null) {
				if(!worldObj.isRemote) {
					if(craftingProgress == 0) {
						this.startCraftingProcess();
					}
				}
			}
		}
	}

	private void startCraftingProcess() {
		World world = this.getWorldObj();
		int dim = 0;
		if(world instanceof WorldServer) {
			dim = ((WorldServer)world).provider.dimensionId;
		}
		craftingProgress = 1;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 2);
		//Packet to start sound
		TheBetweenlands.networkWrapper.sendToAllAround(new AltarCraftingProgressMessage(xCoord, yCoord, zCoord, -1), new TargetPoint(dim, xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, 64D));
		//Sets client crafting progress to 1
		TheBetweenlands.networkWrapper.sendToAllAround(new AltarCraftingProgressMessage(xCoord, yCoord, zCoord, 1), new TargetPoint(dim, xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, 64D));
	}

	private void stopCraftingProcess() {
		World world = this.getWorldObj();
		int dim = 0;
		if(world instanceof WorldServer) {
			dim = ((WorldServer)world).provider.dimensionId;
		}
		craftingProgress = 0;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 2);
		//Packet to cancel sound
		TheBetweenlands.networkWrapper.sendToAllAround(new AltarCraftingProgressMessage(xCoord, yCoord, zCoord, -2), new TargetPoint(dim, xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, 64D));
		//Sets client crafting progress to 0
		TheBetweenlands.networkWrapper.sendToAllAround(new AltarCraftingProgressMessage(xCoord, yCoord, zCoord, 0), new TargetPoint(dim, xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, 64D));
	}

	public void sendCraftingProgressPacket() {
		World world = this.getWorldObj();
		int dim = 0;
		if(world instanceof WorldServer) {
			dim = ((WorldServer)world).provider.dimensionId;
		}
		TheBetweenlands.networkWrapper.sendToAllAround(new AltarCraftingProgressMessage(xCoord, yCoord, zCoord, craftingProgress), new TargetPoint(dim, xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, 64D));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord, zCoord - 1, xCoord + 2, yCoord + 3, zCoord + 2);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		if (packet.func_148853_f() == 0)
			readFromNBT(packet.func_148857_g());
	}

}
