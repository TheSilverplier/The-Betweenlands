package thebetweenlands.client.render.particle.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import thebetweenlands.client.event.handler.FogHandler;
import thebetweenlands.client.render.particle.ParticleFactory;

public class ParticleThem extends Particle {
	public static final ResourceLocation TEXTURE = new ResourceLocation("thebetweenlands:textures/particle/them.png");
	public static final float TEXTURE_HEIGHT = 0.1279F;
	public static final int TEXTURE_COUNT = 5;

	private double startY;
	private float textureStart;

	public ParticleThem(World world, double x, double y, double z, float scale, int texture) {
		super(world, x, y, z, 0, 0, 0);
		this.posX = this.prevPosX = x;
		this.posY = this.prevPosY = y;
		this.posZ = this.prevPosZ = z;
		this.motionX = this.motionY = this.motionZ = 0.0D;
		this.particleMaxAge = (int)500;
		this.field_190017_n = false;
		this.particleScale = scale;
		this.startY = this.posY;
		this.textureStart = texture / (float) TEXTURE_COUNT;
	}

	@Override
	public void renderParticle(VertexBuffer vertexBuffer, Entity entity, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);

		float umin = 0;
		float umax = 1;
		float vmin = this.textureStart;
		float vmax = this.textureStart + TEXTURE_HEIGHT;
		float scale = this.particleScale;

		float ipx = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)partialTicks - interpPosX);
		float ipy = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)partialTicks - interpPosY);
		float ipz = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)partialTicks - interpPosZ);
		int brightness = this.getBrightnessForRender(partialTicks);
		int lightmapX = brightness >> 16 & 65535;
		int lightmapY = brightness & 65535;
		Vec3d[] rotation = new Vec3d[] {new Vec3d((double)(-rotationX * scale - rotationXY * scale), (double)(-rotationZ * scale), (double)(-rotationYZ * scale - rotationXZ * scale)), new Vec3d((double)(-rotationX * scale + rotationXY * scale), (double)(rotationZ * scale), (double)(-rotationYZ * scale + rotationXZ * scale)), new Vec3d((double)(rotationX * scale + rotationXY * scale), (double)(rotationZ * scale), (double)(rotationYZ * scale + rotationXZ * scale)), new Vec3d((double)(rotationX * scale - rotationXY * scale), (double)(-rotationZ * scale), (double)(rotationYZ * scale - rotationXZ * scale))};

		if (this.field_190014_F != 0.0F) {
			float interpolatedRoll = this.field_190014_F + (this.field_190014_F - this.field_190015_G) * partialTicks;
			float cos = MathHelper.cos(interpolatedRoll * 0.5F);
			float lookX = MathHelper.sin(interpolatedRoll * 0.5F) * (float)field_190016_K.xCoord;
			float lookY = MathHelper.sin(interpolatedRoll * 0.5F) * (float)field_190016_K.yCoord;
			float lookZ = MathHelper.sin(interpolatedRoll * 0.5F) * (float)field_190016_K.zCoord;
			Vec3d look = new Vec3d((double)lookX, (double)lookY, (double)lookZ);

			for (int l = 0; l < 4; ++l) {
				rotation[l] = look.scale(2.0D * rotation[l].dotProduct(look)).add(rotation[l].scale((double)(cos * cos) - look.dotProduct(look))).add(look.crossProduct(rotation[l]).scale((double)(2.0F * cos)));
			}
		}

		Vec3d look = new Vec3d(field_190016_K.xCoord, field_190016_K.yCoord, field_190016_K.zCoord).normalize();
		Vec3d diff = new Vec3d(this.posX - interpPosX, this.posY - interpPosY, this.posZ - interpPosZ).normalize();
		float angle = (float) Math.toDegrees(Math.acos(look.dotProduct(diff)));

		float fogEnd = FogHandler.getCurrentFogEnd();
		float fogStart = FogHandler.getCurrentFogEnd();
		float particleDist = (float)Minecraft.getMinecraft().getRenderViewEntity().getDistance(this.posX, this.posY, this.posZ);
		float fadeStart = Math.max(fogStart + (fogEnd - fogStart) / 3.0F, 12.0F);
		float fadeEnd = 8.0F;

		float alpha = 1.0F;

		if(particleDist < fadeStart) {
			alpha = Math.max(1.0F - (fadeStart - particleDist) / (fadeStart - fadeEnd), 0.0F);
		}

		if(this.particleAge < 40) {
			alpha *= this.particleAge / 40.0F;
		} else if(this.particleAge > this.particleMaxAge - 40) {
			alpha *= (this.particleMaxAge - this.particleAge) / 40.0F;
		}

		alpha = Math.min(alpha * 1.75F, 1.0F);

		if(angle < 20.0F) {
			alpha *= Math.pow((angle / 20.0F), 2);
		}

		GlStateManager.alphaFunc(GL11.GL_GREATER, 0);
		GlStateManager.depthMask(false);
		GlStateManager.enableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

		vertexBuffer.begin(GL11.GL_QUADS, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
		vertexBuffer.pos((double)ipx + rotation[0].xCoord, (double)ipy + rotation[0].yCoord * 1.8F, (double)ipz + rotation[0].zCoord).tex((double)umax, (double)vmax).color(this.particleRed, this.particleGreen, this.particleBlue, alpha).lightmap(lightmapX, lightmapY).endVertex();
		vertexBuffer.pos((double)ipx + rotation[1].xCoord, (double)ipy + rotation[1].yCoord * 1.8F, (double)ipz + rotation[1].zCoord).tex((double)umax, (double)vmin).color(this.particleRed, this.particleGreen, this.particleBlue, alpha).lightmap(lightmapX, lightmapY).endVertex();
		vertexBuffer.pos((double)ipx + rotation[2].xCoord, (double)ipy + rotation[2].yCoord * 1.8F, (double)ipz + rotation[2].zCoord).tex((double)umin, (double)vmin).color(this.particleRed, this.particleGreen, this.particleBlue, alpha).lightmap(lightmapX, lightmapY).endVertex();
		vertexBuffer.pos((double)ipx + rotation[3].xCoord, (double)ipy + rotation[3].yCoord * 1.8F, (double)ipz + rotation[3].zCoord).tex((double)umin, (double)vmax).color(this.particleRed, this.particleGreen, this.particleBlue, alpha).lightmap(lightmapX, lightmapY).endVertex();
		Tessellator.getInstance().draw();

		GlStateManager.disableBlend();
		GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		this.setPosition(this.posX, this.startY + Math.sin(this.particleAge / 150.0f) / 1.5F, this.posZ);

		Entity renderView = Minecraft.getMinecraft().getRenderViewEntity();
		if(renderView != null) {
			Vec3d diff = renderView.getPositionVector().subtract(this.posX, this.posY - renderView.getEyeHeight(), this.posZ);
			if(diff.lengthVector() < 2.0F) {
				this.setExpired();
			}
			Vec3d dir = diff.normalize();
			this.motionX = dir.xCoord * 0.05D;
			this.motionY = dir.yCoord * 0.05D;
			this.motionZ = dir.zCoord * 0.05D;
		}

		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.startY += this.motionY;

		this.motionX *= 0.96D;
		this.motionZ *= 0.96D;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setExpired();
		}
	}

	@Override
	public int getFXLayer() {
		return 3;
	}

	@Override
	public boolean isTransparent() {
		return true;
	}

	public static final class Factory extends ParticleFactory<Factory, ParticleThem> {
		public Factory() {
			super(ParticleThem.class);
		}

		@Override
		public ParticleThem createParticle(ImmutableParticleArgs args) {
			return new ParticleThem(args.world, args.x, args.y, args.z, args.scale, args.data.getInt(0));
		}

		@Override
		protected void setBaseArguments(ParticleArgs<?> args) {
			args.withScale(0.8F).withData(0);
		}

		@Override
		protected void setDefaultArguments(World world, double x, double y, double z, ParticleArgs<?> args) {
			args.withData(world.rand.nextInt(TEXTURE_COUNT));
		}
	}
}
