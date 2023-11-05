package com.spirit.shit.entity.client.figures;

import com.spirit.shit.entity.custom.CapybaraEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CapybaraModel<T extends CapybaraEntity> extends SinglePartEntityModel<T> {
    private final ModelPart capybara;

    public CapybaraModel(ModelPart root) {
        this.capybara = root.getChild("capybara");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData capybara = modelPartData.addChild("capybara", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 1.0F));

        ModelPartData body = capybara.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.5F, -6.0F, -14.0F, 9.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 5.0F));

        ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(21, 25).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.02F))
                .uv(32, 26).cuboid(-3.0F, 5.0F, -4.0F, 5.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 4.0F, -11.0F));

        ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(21, 25).mirrored().cuboid(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.02F)).mirrored(false)
                .uv(32, 26).mirrored().cuboid(-2.0F, 5.0F, -4.0F, 5.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, 4.0F, -11.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 25).cuboid(-2.5F, -5.0F, -8.0F, 5.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, -14.0F));

        ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -5.0F, 2.0F));

        ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(0, 9).mirrored().cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.5F, -5.0F, 2.0F));

        ModelPartData right_leg = capybara.addChild("right_leg", ModelPartBuilder.create().uv(20, 10).cuboid(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new Dilation(0.02F))
                .uv(0, 0).cuboid(-2.0F, 3.0F, -1.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.02F))
                .uv(38, 0).cuboid(-3.0F, 9.0F, -3.0F, 5.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -9.0F, 5.0F));

        ModelPartData left_leg = capybara.addChild("left_leg", ModelPartBuilder.create().uv(20, 10).cuboid(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new Dilation(0.02F))
                .uv(0, 0).mirrored().cuboid(-1.0F, 3.0F, -1.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.02F)).mirrored(false)
                .uv(38, 0).mirrored().cuboid(-2.0F, 9.0F, -3.0F, 5.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -9.0F, 5.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        capybara.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }


    @Override
    public ModelPart getPart() {
        return capybara;
    }
}