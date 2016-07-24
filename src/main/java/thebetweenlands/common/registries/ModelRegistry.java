package thebetweenlands.common.registries;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import thebetweenlands.client.render.model.baked.ModelBlank;
import thebetweenlands.client.render.model.baked.ModelCombined;
import thebetweenlands.client.render.model.baked.ModelFromModelBase;
import thebetweenlands.client.render.model.baked.ModelLifeCrystalStalactite;
import thebetweenlands.client.render.model.baked.ModelRoot;
import thebetweenlands.client.render.model.baked.ModelStalactite;
import thebetweenlands.client.render.model.baked.modelbase.ModelBlackHatMushroom1;
import thebetweenlands.client.render.model.baked.modelbase.ModelBlackHatMushroom2;
import thebetweenlands.client.render.model.baked.modelbase.ModelBlackHatMushroom3;
import thebetweenlands.client.render.model.baked.modelbase.ModelBulbCappedMushroom;
import thebetweenlands.client.render.model.baked.modelbase.ModelFlatHeadMushroom1;
import thebetweenlands.client.render.model.baked.modelbase.ModelFlatHeadMushroom2;
import thebetweenlands.client.render.model.baked.modelbase.ModelPitcherPlant;
import thebetweenlands.client.render.model.baked.modelbase.ModelSundew;
import thebetweenlands.client.render.model.baked.modelbase.ModelSwampPlant;
import thebetweenlands.client.render.model.baked.modelbase.ModelVenusFlyTrap;
import thebetweenlands.client.render.model.baked.modelbase.ModelVolarpad;
import thebetweenlands.client.render.model.baked.modelbase.ModelWeepingBlue;
import thebetweenlands.client.render.model.loader.CustomModelManager;
import thebetweenlands.common.lib.ModInfo;

public class ModelRegistry {
	//Generic
	public static final IModel BLANK = new ModelBlank();
	public static final IModel MODEL_COMBINED = new ModelCombined();

	//Plant models
	public static final IModel PITCHER_PLANT = new ModelFromModelBase(new ModelPitcherPlant(), new ResourceLocation("thebetweenlands:blocks/pitcher_plant"), 128, 128);
	public static final IModel BLACK_HAT_MUSHROOM_1 = new ModelFromModelBase(new ModelBlackHatMushroom1(), new ResourceLocation("thebetweenlands:blocks/black_hat_mushroom_1"), 64, 64);
	public static final IModel BLACK_HAT_MUSHROOM_2 = new ModelFromModelBase(new ModelBlackHatMushroom2(), new ResourceLocation("thebetweenlands:blocks/black_hat_mushroom_2"), 64, 64);
	public static final IModel BLACK_HAT_MUSHROOM_3 = new ModelFromModelBase(new ModelBlackHatMushroom3(), new ResourceLocation("thebetweenlands:blocks/black_hat_mushroom_3"), 64, 64);
	public static final IModel BULB_CAPPED_MUSHROOM = new ModelFromModelBase(new ModelBulbCappedMushroom(), new ResourceLocation("thebetweenlands:blocks/bulb_capped_mushroom"), 64, 64);
	public static final IModel FLAT_HEAD_MUSHROOM_1 = new ModelFromModelBase(new ModelFlatHeadMushroom1(), new ResourceLocation("thebetweenlands:blocks/flat_head_mushroom_1"), 64, 64);
	public static final IModel FLAT_HEAD_MUSHROOM_2 = new ModelFromModelBase(new ModelFlatHeadMushroom2(), new ResourceLocation("thebetweenlands:blocks/flat_head_mushroom_2"), 64, 64);
	public static final IModel SUNDEW = new ModelFromModelBase(new ModelSundew(), new ResourceLocation("thebetweenlands:blocks/sundew"), 128, 128);
	public static final IModel VENUS_FLY_TRAP = new ModelFromModelBase(new ModelVenusFlyTrap(), new ResourceLocation("thebetweenlands:blocks/venus_fly_trap"), 64, 64);
	public static final IModel VENUS_FLY_TRAP_BLOOMING = new ModelFromModelBase(new ModelVenusFlyTrap(), new ResourceLocation("thebetweenlands:blocks/venus_fly_trap_blooming"), 64, 64);
	public static final IModel VOLARPAD_1 = new ModelFromModelBase(new ModelVolarpad(), new ResourceLocation("thebetweenlands:blocks/volarpad_1"), 256, 256);
	public static final IModel VOLARPAD_2 = new ModelFromModelBase(new ModelVolarpad(), new ResourceLocation("thebetweenlands:blocks/volarpad_2"), 256, 256);
	public static final IModel VOLARPAD_3 = new ModelFromModelBase(new ModelVolarpad(), new ResourceLocation("thebetweenlands:blocks/volarpad_3"), 256, 256);
	public static final IModel WEEPING_BLUE = new ModelFromModelBase(new ModelWeepingBlue(), new ResourceLocation("thebetweenlands:blocks/weeping_blue"), 64, 64);
	public static final IModel SWAMP_PLANT = new ModelFromModelBase(new ModelSwampPlant(), new ResourceLocation("thebetweenlands:blocks/swamp_plant"), 64, 64);

	//Misc
	public static final IModel LIFE_CRYSTAL_STALACTITE = new ModelLifeCrystalStalactite();
	public static final IModel STALACTITE = new ModelStalactite();
	public static final IModel ROOT = new ModelRoot();

	public final static List<IModel> MODELS = new ArrayList<IModel>();

	private final ICustomRegistrar defaultRegistrar = new DefaultRegistrar(CustomModelManager.INSTANCE);

	public static interface ICustomRegistrar {
		/**
		 * Called when this model is registered.
		 * Can be used to register additional models or
		 * to override the default registering.
		 * @param model Model to register
		 * @param location Resource location of the model
		 * @return Return true to cancel default registering
		 */
		default boolean registerModel(IModel model, ResourceLocation location) {
			return false;
		}
	}

	public static final class DefaultRegistrar implements ICustomRegistrar {
		private CustomModelManager manager;

		private DefaultRegistrar(CustomModelManager manager) {
			this.manager = manager;
		}

		@Override
		public boolean registerModel(IModel model, ResourceLocation location) {
			this.manager.registerModel(location, model);
			return true;
		}
	}

	public void preInit() {
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				if (field.getType().isAssignableFrom(IModel.class)) {
					IModel model = (IModel) field.get(this);
					MODELS.add(model);
					ResourceLocation blockLocation = new ResourceLocation(ModInfo.ID, "models/block/internal/" + field.getName().toLowerCase(Locale.ENGLISH));
					ResourceLocation itemLocation = new ResourceLocation(ModInfo.ID, "models/item/internal/" + field.getName().toLowerCase(Locale.ENGLISH));
					this.registerModel(model, blockLocation);
					this.registerModel(model, itemLocation);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void registerModel(IModel model, ResourceLocation location) {
		if(model instanceof ICustomRegistrar == false || !((ICustomRegistrar)model).registerModel(model, location)) {
			this.defaultRegistrar.registerModel(model, location);
		}
	}
}
