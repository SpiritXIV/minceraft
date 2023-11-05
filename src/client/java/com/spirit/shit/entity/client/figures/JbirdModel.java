package com.spirit.shit.entity.client.figures;

import com.spirit.shit.entity.custom.JbirdEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class JbirdModel<T extends JbirdEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Jbird;

	public JbirdModel(ModelPart root) {
		this.Jbird = root.getChild("Jbird");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Jbird = modelPartData.addChild("Jbird", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Head = Jbird.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
				.uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.2F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData Body = Jbird.addChild("Body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
				.uv(16, 32).cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData Arms = Jbird.addChild("Arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData RightArm = Arms.addChild("RightArm", ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
				.uv(40, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

		ModelPartData LeftArm = Arms.addChild("LeftArm", ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(40, 32).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

		ModelPartData Legs = Jbird.addChild("Legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData LeftLegs = Legs.addChild("LeftLegs", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		ModelPartData RightLegs = Legs.addChild("RightLegs", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Jbird.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}


	@Override
	public ModelPart getPart() {
		return Jbird;
	}
}