// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class verybadmodel - Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "verybadmodel_- converted"), "main");
	private final ModelPart body_base;
	private final ModelPart legleft_f1;
	private final ModelPart legleft_m1;
	private final ModelPart legleft_b1;
	private final ModelPart legright_f1;
	private final ModelPart legright_m1;
	private final ModelPart legright_b1;
	private final ModelPart armleft1;
	private final ModelPart armright1;

	public verybadmodel - Converted(ModelPart root) {
		this.body_base = root.getChild("body_base");
		this.legleft_f1 = root.getChild("legleft_f1");
		this.legleft_m1 = root.getChild("legleft_m1");
		this.legleft_b1 = root.getChild("legleft_b1");
		this.legright_f1 = root.getChild("legright_f1");
		this.legright_m1 = root.getChild("legright_m1");
		this.legright_b1 = root.getChild("legright_b1");
		this.armleft1 = root.getChild("armleft1");
		this.armright1 = root.getChild("armright1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body_base = partdefinition.addOrReplaceChild("body_base", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.5F, -1.0F, -0.2276F, 0.0F, 0.0F));

		PartDefinition bodyback = body_base.addOrReplaceChild("bodyback", CubeListBuilder.create().texOffs(0, 23).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 3.0F));

		PartDefinition panser1 = body_base.addOrReplaceChild("panser1", CubeListBuilder.create().texOffs(0, 6).addBox(-3.5F, -2.0F, 0.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).addBox(-1.0F, -4.0F, 2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).mirror().addBox(-4.0F, -3.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 28).mirror().addBox(-2.5502F, -4.4156F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 0).mirror().addBox(-3.0F, -6.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 28).addBox(1.0F, -4.0F, 3.8F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 28).mirror().addBox(-2.0F, -4.0F, 5.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.5F, 1.0F, -0.1367F, 0.0F, 0.0F));

		PartDefinition panser2 = panser1.addOrReplaceChild("panser2", CubeListBuilder.create().texOffs(0, 13).addBox(-3.5F, -2.0F, -2.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.5F, 1.0F, -0.182F, 0.0F, 0.0F));

		PartDefinition panser3 = panser1.addOrReplaceChild("panser3", CubeListBuilder.create().texOffs(0, 18).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2731F, 0.0F, 0.0F));

		PartDefinition legleft_f1 = partdefinition.addOrReplaceChild("legleft_f1", CubeListBuilder.create().texOffs(23, 0).addBox(-0.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 21.0F, 0.0F, -0.3643F, 0.182F, -0.3187F));

		PartDefinition legleft_f2 = legleft_f1.addOrReplaceChild("legleft_f2", CubeListBuilder.create().texOffs(23, 3).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));

		PartDefinition legleft_m1 = partdefinition.addOrReplaceChild("legleft_m1", CubeListBuilder.create().texOffs(34, 0).addBox(-0.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 21.0F, 1.0F, 0.0F, -0.1367F, -0.182F));

		PartDefinition legleft_m2 = legleft_m1.addOrReplaceChild("legleft_m2", CubeListBuilder.create().texOffs(34, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3187F));

		PartDefinition legleft_b1 = partdefinition.addOrReplaceChild("legleft_b1", CubeListBuilder.create().texOffs(45, 0).addBox(-0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 21.0F, 2.0F, 0.3643F, -0.4098F, -0.1367F));

		PartDefinition legleft_b2 = legleft_b1.addOrReplaceChild("legleft_b2", CubeListBuilder.create().texOffs(45, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3187F));

		PartDefinition legright_f1 = partdefinition.addOrReplaceChild("legright_f1", CubeListBuilder.create().texOffs(23, 11).addBox(-3.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 21.0F, 0.0F, -0.3643F, -0.182F, 0.3187F));

		PartDefinition legright_f2 = legright_f1.addOrReplaceChild("legright_f2", CubeListBuilder.create().texOffs(23, 14).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0911F));

		PartDefinition legright_m1 = partdefinition.addOrReplaceChild("legright_m1", CubeListBuilder.create().texOffs(34, 11).addBox(-3.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 21.0F, 1.0F, 0.0F, 0.1367F, 0.182F));

		PartDefinition legright_m2 = legright_m1.addOrReplaceChild("legright_m2", CubeListBuilder.create().texOffs(34, 14).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3187F));

		PartDefinition legright_b1 = partdefinition.addOrReplaceChild("legright_b1", CubeListBuilder.create().texOffs(45, 11).addBox(-2.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 21.0F, 2.0F, 0.3643F, 0.4098F, 0.1367F));

		PartDefinition legright_b2 = legright_b1.addOrReplaceChild("legright_b2", CubeListBuilder.create().texOffs(45, 14).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3187F));

		PartDefinition armleft1 = partdefinition.addOrReplaceChild("armleft1", CubeListBuilder.create().texOffs(15, 22).addBox(-0.5F, -0.2F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.7F, -0.5F, -1.5026F, -0.4554F, -0.4554F));

		PartDefinition clawbase1 = armleft1.addOrReplaceChild("clawbase1", CubeListBuilder.create().texOffs(20, 22).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.3187F, 0.0F, 0.4098F));

		PartDefinition snapper1 = clawbase1.addOrReplaceChild("snapper1", CubeListBuilder.create().texOffs(29, 26).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -20.2F, 0.5F, 0.0F, 0.0F, -0.1367F));

		PartDefinition clawtop1 = clawbase1.addOrReplaceChild("clawtop1", CubeListBuilder.create().texOffs(20, 26).addBox(-1.0F, 0.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -20.2F, 0.5F, 0.0F, 0.0F, 0.0456F));

		PartDefinition clawpoint1 = clawtop1.addOrReplaceChild("clawpoint1", CubeListBuilder.create().texOffs(29, 22).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2731F));

		PartDefinition armright1 = partdefinition.addOrReplaceChild("armright1", CubeListBuilder.create().texOffs(36, 22).addBox(-0.5F, -0.2F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 20.7F, -0.5F, -1.5026F, 0.4554F, 0.4554F));

		PartDefinition clawbase2 = armright1.addOrReplaceChild("clawbase2", CubeListBuilder.create().texOffs(41, 22).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.3187F, 0.0F, -0.4098F));

		PartDefinition clawtop2 = clawbase2.addOrReplaceChild("clawtop2", CubeListBuilder.create().texOffs(41, 26).addBox(0.0F, 0.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.0456F));

		PartDefinition clawpoint2 = clawtop2.addOrReplaceChild("clawpoint2", CubeListBuilder.create().texOffs(50, 22).addBox(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -20.7F, 0.5F, 0.0F, 0.0F, -0.2731F));

		PartDefinition snapper2 = clawbase2.addOrReplaceChild("snapper2", CubeListBuilder.create().texOffs(50, 26).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.1367F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body_base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legleft_f1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legleft_m1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legleft_b1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legright_f1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legright_m1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legright_b1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armleft1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armright1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
