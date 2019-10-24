package thebetweenlands.common.entity.mobs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import thebetweenlands.common.registries.LootTableRegistry;

public class EntityTinySludgeWormHelper extends EntityTinySludgeWorm {
	public EntityTinySludgeWormHelper(World world) {
		super(world, false);
		experienceValue = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
		tasks.addTask(2, new EntityAIAttackMelee(this, 1, false));
		tasks.addTask(3, new EntityAIWander(this, 0.8D, 1));
		targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget<>(this, EntityLivingBase.class, 2, true, true, entity -> entity instanceof IMob));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}

	@Override
	protected ResourceLocation getLootTable() {
		return LootTableRegistry.TINY_SLUDGE_WORM_HELPER;
	}

	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> entity) {
		return !EntityTinySludgeWormHelper.class.isAssignableFrom(entity);
	}
}
