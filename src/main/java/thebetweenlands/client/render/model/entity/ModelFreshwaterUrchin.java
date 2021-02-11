package thebetweenlands.client.render.model.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.CullFace;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thebetweenlands.client.render.model.MowzieModelBase;
import thebetweenlands.client.render.model.MowzieModelRenderer;
import thebetweenlands.common.entity.mobs.EntityFreshwaterUrchin;

@SideOnly(Side.CLIENT)
public class ModelFreshwaterUrchin extends MowzieModelBase {
    MowzieModelRenderer base;
    MowzieModelRenderer anal_sac;
    MowzieModelRenderer spike_rotationpoint;
    MowzieModelRenderer spike_f2;
    MowzieModelRenderer spike_l2;
    MowzieModelRenderer spike_r2;
    MowzieModelRenderer spike_b2;
    MowzieModelRenderer spike_f4;
    MowzieModelRenderer spike_l4;
    MowzieModelRenderer spike_r4;
    MowzieModelRenderer spike_b4;
    MowzieModelRenderer spike_f1;
    MowzieModelRenderer spike_l1;
    MowzieModelRenderer spike_r1;
    MowzieModelRenderer spike_b1;
    MowzieModelRenderer spike_f3;
    MowzieModelRenderer spike_l3;
    MowzieModelRenderer spike_r3;
    MowzieModelRenderer spike_b3;
    MowzieModelRenderer spike_f5;
    MowzieModelRenderer spike_l5;
    MowzieModelRenderer spike_r5;
    MowzieModelRenderer spike_b5;

    public ModelFreshwaterUrchin() {
        textureWidth = 64;
        textureHeight = 64;
        spike_b1 = new MowzieModelRenderer(this, 45, 29);
        spike_b1.setRotationPoint(0.0F, -4.0F, 1.0F);
        spike_b1.addBox(-3.0F, -3.0F, 0.0F, 6, 3, 0, 0.0F);
        setRotateAngle(spike_b1, -0.40980330836826856F, 0.0F, 0.0F);
        spike_r3 = new MowzieModelRenderer(this, 30, 29);
        spike_r3.setRotationPoint(-1.0F, -2.5F, 0.0F);
        spike_r3.addBox(0.0F, -6.0F, -3.5F, 0, 6, 7, 0.0F);
        setRotateAngle(spike_r3, 0.0F, 0.0F, -1.2747884856566583F);
        spike_r1 = new MowzieModelRenderer(this, 30, 23);
        spike_r1.setRotationPoint(-1.0F, -4.0F, 0.0F);
        spike_r1.addBox(0.0F, -3.0F, -3.0F, 0, 3, 6, 0.0F);
        setRotateAngle(spike_r1, 0.0F, 0.0F, -0.40980330836826856F);
        spike_f1 = new MowzieModelRenderer(this, 0, 29);
        spike_f1.setRotationPoint(0.0F, -4.0F, -1.0F);
        spike_f1.addBox(-3.0F, -3.0F, 0.0F, 6, 3, 0, 0.0F);
        setRotateAngle(spike_f1, 0.40980330836826856F, 0.0F, 0.0F);
        spike_r2 = new MowzieModelRenderer(this, 30, 27);
        spike_r2.setRotationPoint(-3.0F, -4.0F, 0.0F);
        spike_r2.addBox(0.0F, -2.0F, -3.0F, 0, 2, 6, 0.0F);
        setRotateAngle(spike_r2, 0.0F, 0.0F, -0.7853981633974483F);
        base = new MowzieModelRenderer(this, 0, 0);
        base.setRotationPoint(0.0F, 24.0F, 0.0F);
        base.addBox(-3.0F, -4.0F, -3.0F, 6, 4, 6, 0.0F);
        spike_f2 = new MowzieModelRenderer(this, 0, 33);
        spike_f2.setRotationPoint(0.0F, -4.0F, 3.0F);
        spike_f2.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 0, 0.0F);
        setRotateAngle(spike_f2, -0.7853981633974483F, 0.0F, 0.0F);
        spike_l1 = new MowzieModelRenderer(this, 15, 23);
        spike_l1.setRotationPoint(1.0F, -4.0F, 0.0F);
        spike_l1.addBox(0.0F, -3.0F, -3.0F, 0, 3, 6, 0.0F);
        setRotateAngle(spike_l1, 0.0F, 0.0F, 0.40980330836826856F);
        spike_b3 = new MowzieModelRenderer(this, 45, 36);
        spike_b3.setRotationPoint(0.0F, -2.5F, 1.0F);
        spike_b3.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 0, 0.0F);
        setRotateAngle(spike_b3, -1.2747884856566583F, 0.0F, 0.0F);
        spike_l5 = new MowzieModelRenderer(this, 15, 39);
        spike_l5.setRotationPoint(1.0F, -1.5F, 0.0F);
        spike_l5.addBox(0.0F, -6.0F, -3.5F, 0, 6, 7, 0.0F);
        setRotateAngle(spike_l5, 0.0F, 0.0F, 1.6845917940249266F);
        spike_r5 = new MowzieModelRenderer(this, 30, 39);
        spike_r5.setRotationPoint(0.0F, -1.5F, 0.0F);
        spike_r5.addBox(0.0F, -6.0F, -3.5F, 0, 6, 7, 0.0F);
        setRotateAngle(spike_r5, 0.0F, 0.0F, -1.6845917940249266F);
        spike_b5 = new MowzieModelRenderer(this, 45, 46);
        spike_b5.setRotationPoint(0.0F, -1.5F, 1.0F);
        spike_b5.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 0, 0.0F);
        setRotateAngle(spike_b5, -1.6845917940249266F, 0.0F, 0.0F);
        spike_f4 = new MowzieModelRenderer(this, 0, 43);
        spike_f4.setRotationPoint(0.0F, -2.0F, -3.0F);
        spike_f4.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 0, 0.0F);
        setRotateAngle(spike_f4, 1.4570008595648662F, 0.0F, 0.0F);
        spike_r4 = new MowzieModelRenderer(this, 30, 37);
        spike_r4.setRotationPoint(-3.0F, -2.0F, 0.0F);
        spike_r4.addBox(0.0F, -2.0F, -3.0F, 0, 2, 6, 0.0F);
        setRotateAngle(spike_r4, 0.0F, 0.0F, -1.4570008595648662F);
        spike_f5 = new MowzieModelRenderer(this, 0, 46);
        spike_f5.setRotationPoint(0.0F, -1.5F, -1.0F);
        spike_f5.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 0, 0.0F);
        setRotateAngle(spike_f5, 1.6845917940249266F, 0.0F, 0.0F);
        spike_l2 = new MowzieModelRenderer(this, 15, 27);
        spike_l2.setRotationPoint(3.0F, -4.0F, 0.0F);
        spike_l2.addBox(0.0F, -2.0F, -3.0F, 0, 2, 6, 0.0F);
        setRotateAngle(spike_l2, 0.0F, 0.0F, 0.7853981633974483F);
        spike_f3 = new MowzieModelRenderer(this, 0, 36);
        spike_f3.setRotationPoint(0.0F, -2.5F, -1.0F);
        spike_f3.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 0, 0.0F);
        setRotateAngle(spike_f3, 1.2747884856566583F, 0.0F, 0.0F);
        spike_rotationpoint = new MowzieModelRenderer(this, 0, 0);
        spike_rotationpoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        spike_rotationpoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        setRotateAngle(spike_rotationpoint, 0.0F, 0.7853981633974483F, 0.0F);
        anal_sac = new MowzieModelRenderer(this, 0, 11);
        anal_sac.setRotationPoint(0.0F, -4.0F, 0.0F);
        anal_sac.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3, 0.0F);
        setRotateAngle(anal_sac, 0.0F, 0.18203784098300857F, 0.0F);
        spike_b4 = new MowzieModelRenderer(this, 45, 43);
        spike_b4.setRotationPoint(0.0F, -2.0F, 3.0F);
        spike_b4.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 0, 0.0F);
        setRotateAngle(spike_b4, -1.4570008595648662F, 0.0F, 0.0F);
        spike_b2 = new MowzieModelRenderer(this, 45, 33);
        spike_b2.setRotationPoint(0.0F, -4.0F, -3.0F);
        spike_b2.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 0, 0.0F);
        setRotateAngle(spike_b2, 0.7853981633974483F, 0.0F, 0.0F);
        spike_l4 = new MowzieModelRenderer(this, 15, 37);
        spike_l4.setRotationPoint(3.0F, -2.0F, 0.0F);
        spike_l4.addBox(0.0F, -2.0F, -3.0F, 0, 2, 6, 0.0F);
        setRotateAngle(spike_l4, 0.0F, 0.0F, 1.4570008595648662F);
        spike_l3 = new MowzieModelRenderer(this, 15, 29);
        spike_l3.setRotationPoint(1.0F, -2.5F, 0.0F);
        spike_l3.addBox(0.0F, -6.0F, -3.5F, 0, 6, 7, 0.0F);
        setRotateAngle(spike_l3, 0.0F, 0.0F, 1.2747884856566583F);
        spike_rotationpoint.addChild(spike_b1);
        spike_rotationpoint.addChild(spike_r3);
        spike_rotationpoint.addChild(spike_r1);
        spike_rotationpoint.addChild(spike_f1);
        base.addChild(spike_r2);
        base.addChild(spike_f2);
        spike_rotationpoint.addChild(spike_l1);
        spike_rotationpoint.addChild(spike_b3);
        spike_rotationpoint.addChild(spike_l5);
        spike_rotationpoint.addChild(spike_r5);
        spike_rotationpoint.addChild(spike_b5);
        base.addChild(spike_f4);
        base.addChild(spike_r4);
        spike_rotationpoint.addChild(spike_f5);
        base.addChild(spike_l2);
        spike_rotationpoint.addChild(spike_f3);
        base.addChild(spike_rotationpoint);
        base.addChild(anal_sac);
        base.addChild(spike_b4);
        base.addChild(spike_b2);
        base.addChild(spike_l4);
        spike_rotationpoint.addChild(spike_l3);
        setInitPose();
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    	EntityFreshwaterUrchin urchin = (EntityFreshwaterUrchin) entity;
    	float scaleSpikes = 1F/80F * urchin.getSpikeTimer();
    	float pulse = MathHelper.sin((ageInTicks) * 0.0625F) * 0.125F;
    	GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        GlStateManager.cullFace(CullFace.FRONT);
        spike_f2.showModel = false;
        spike_l2.showModel = false;
        spike_r2.showModel = false;
        spike_b2.showModel = false;
        spike_f4.showModel = false;
        spike_l4.showModel = false;
        spike_r4.showModel = false;
        spike_b4.showModel = false;
        spike_f1.showModel = false;
        spike_l1.showModel = false;
        spike_r1.showModel = false;
        spike_b1.showModel = false;
        spike_f3.showModel = false;
        spike_l3.showModel = false;
        spike_r3.showModel = false;
        spike_b3.showModel = false;
        spike_f5.showModel = false;
        spike_l5.showModel = false;
        spike_r5.showModel = false;
        spike_b5.showModel = false;
        base.render(scale);
        anal_sac.showModel = false;
        spike_rotationpoint.showModel  = false;
        GlStateManager.cullFace(CullFace.BACK);
        base.render(scale);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0F, 1.5F, 0F);
        GlStateManager.scale(0.75F + pulse, 1F + pulse * 0.25F, 0.75F + pulse);
        anal_sac.showModel = true;
        anal_sac.render(0.0625F);
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        GlStateManager.translate(0F, 1.5F, 0F);
        GlStateManager.scale(scaleSpikes, scaleSpikes, scaleSpikes);
        spike_l2.showModel = true;
        spike_r2.showModel = true;
        spike_b2.showModel = true;
        spike_f4.showModel = true;
        spike_l4.showModel = true;
        spike_r4.showModel = true;
        spike_b4.showModel = true;
        spike_f1.showModel = true;
        spike_l1.showModel = true;
        spike_r1.showModel = true;
        spike_b1.showModel = true;
        spike_f3.showModel = true;
        spike_l3.showModel = true;
        spike_r3.showModel = true;
        spike_b3.showModel = true;
        spike_f5.showModel = true;
        spike_l5.showModel = true;
        spike_r5.showModel = true;
        spike_b5.showModel = true;
        spike_rotationpoint.showModel = true;
        GlStateManager.cullFace(CullFace.BACK);
        spike_rotationpoint.render(0.0625F);
        GlStateManager.popMatrix();
        
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entity, float swing, float speed, float partialRenderTicks) {
    	setToInitPose();
        EntityFreshwaterUrchin urchin = (EntityFreshwaterUrchin) entity;
        float pulse = MathHelper.sin((urchin.ticksExisted + partialRenderTicks) * 0.125F) * 0.03125F;

        spike_f2.rotateAngleY += pulse;
        spike_l2.rotateAngleY += pulse;
        spike_r2.rotateAngleY += pulse;
        spike_b2.rotateAngleY += pulse;
        spike_f4.rotateAngleY += pulse;
        spike_l4.rotateAngleY += pulse;
        spike_r4.rotateAngleY += pulse;
        spike_b4.rotateAngleY += pulse;
        spike_f1.rotateAngleY += pulse;
        spike_l1.rotateAngleY += pulse;
        spike_r1.rotateAngleY += pulse;
        spike_b1.rotateAngleY += pulse;
        spike_f3.rotateAngleY += pulse;
        spike_l3.rotateAngleY += pulse;
        spike_r3.rotateAngleY += pulse;
        spike_b3.rotateAngleY += pulse;
        spike_f5.rotateAngleY += pulse;
        spike_l5.rotateAngleY += pulse;
        spike_r5.rotateAngleY += pulse;
        spike_b5.rotateAngleY += pulse;
        
        spike_f2.rotateAngleX += pulse;
        spike_l2.rotateAngleX += pulse;
        spike_r2.rotateAngleX += pulse;
        spike_b2.rotateAngleX += pulse;
        spike_f4.rotateAngleX += pulse;
        spike_l4.rotateAngleX += pulse;
        spike_r4.rotateAngleX += pulse;
        spike_b4.rotateAngleX += pulse;
        spike_f1.rotateAngleX += pulse;
        spike_l1.rotateAngleX += pulse;
        spike_r1.rotateAngleX += pulse;
        spike_b1.rotateAngleX += pulse;
        spike_f3.rotateAngleX += pulse;
        spike_l3.rotateAngleX += pulse;
        spike_r3.rotateAngleX += pulse;
        spike_b3.rotateAngleX += pulse;
        spike_f5.rotateAngleX += pulse;
        spike_l5.rotateAngleX += pulse;
        spike_r5.rotateAngleX += pulse;
        spike_b5.rotateAngleX += pulse;
    }

    public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
