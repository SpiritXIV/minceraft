package com.spirit.shit.global.entity.client.figures;

import com.spirit.shit.global.entity.custom.FreddyFazBearEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class FreddyFazBearModel<T extends FreddyFazBearEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public FreddyFazBearModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -20.0F, -5.0F, 12.0F, 20.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -20.0F, 0.0F));

        ModelPartData mouth = head.addChild("mouth", ModelPartBuilder.create().uv(0, 57).cuboid(-3.5F, -2.0F, -4.0F, 7.0F, 2.0F, 8.0F, new Dilation(0.02F))
                .uv(34, 57).cuboid(-2.5F, -6.0F, -2.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.02F))
                .uv(7, 72).cuboid(-2.5F, -2.0F, -7.0F, 5.0F, 2.0F, 3.0F, new Dilation(0.03F))
                .uv(42, 72).cuboid(-2.5F, -3.0F, -7.0F, 5.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData upper_jaw = mouth.addChild("upper_jaw", ModelPartBuilder.create().uv(22, 30).cuboid(-3.5F, -7.0F, -8.0F, 7.0F, 7.0F, 8.0F, new Dilation(0.0F))
                .uv(34, 0).cuboid(-2.5F, -3.0F, -11.0F, 5.0F, 3.0F, 3.0F, new Dilation(0.04F))
                .uv(66, 72).cuboid(-2.5F, 0.0F, -11.0F, 5.0F, 1.0F, 3.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, -2.0F, 4.0F));

        ModelPartData right_ear = upper_jaw.addChild("right_ear", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -5.0F, -4.0F));

        ModelPartData left_ear = upper_jaw.addChild("left_ear", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -5.0F, -4.0F));

        ModelPartData hat = upper_jaw.addChild("hat", ModelPartBuilder.create().uv(59, 27).cuboid(-2.5F, -1.0F, -3.0F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(70, 37).cuboid(-1.5F, -3.0F, -2.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, -4.0F));

        ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(0, 30).cuboid(-3.0F, -1.0F, -3.0F, 5.0F, 17.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -18.0F, 0.0F));

        ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(0, 30).mirrored().cuboid(-2.0F, -1.0F, -3.0F, 5.0F, 17.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(8.0F, -18.0F, 0.0F));

        ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(44, 0).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F, new Dilation(0.03F)), ModelTransform.pivot(-3.0F, -13.0F, 0.0F));

        ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(44, 0).mirrored().cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(3.0F, -13.0F, 0.0F));
        return TexturedModelData.of(modelData, 84, 84);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}