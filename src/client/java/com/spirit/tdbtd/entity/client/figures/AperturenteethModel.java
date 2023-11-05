package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class AperturenteethModel<T extends AperturenteethEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public AperturenteethModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData mouth = root.addChild("mouth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData lower_mouth = mouth.addChild("lower_mouth", ModelPartBuilder.create().uv(0, 17).cuboid(-7.0F, -3.0F, -7.0F, 14.0F, 3.0F, 14.0F, new Dilation(0.04F))
                .uv(0, 34).cuboid(-7.0F, -5.0F, -7.0F, 14.0F, 2.0F, 14.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData upper_mouth = lower_mouth.addChild("upper_mouth", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -3.0F, -14.0F, 14.0F, 3.0F, 14.0F, new Dilation(0.06F))
                .uv(42, 3).cuboid(-7.0F, 0.0F, -14.0F, 14.0F, 2.0F, 14.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, -3.0F, 7.0F));

        ModelPartData leg_base = root.addChild("leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_arm = leg_base.addChild("right_arm", ModelPartBuilder.create().uv(0, 3).cuboid(-5.0F, -1.0F, 0.0F, 5.0F, 3.0F, 0.0F, new Dilation(0.04F))
                .uv(6, 6).cuboid(-7.0F, 2.0F, -1.0F, 3.0F, 0.0F, 2.0F, new Dilation(0.01F)), ModelTransform.pivot(-7.0F, -2.0F, -2.0F));

        ModelPartData left_arm = leg_base.addChild("left_arm", ModelPartBuilder.create().uv(0, 3).mirrored().cuboid(0.0F, -1.0F, 0.0F, 5.0F, 3.0F, 0.0F, new Dilation(0.04F)).mirrored(false)
                .uv(6, 6).mirrored().cuboid(4.0F, 2.0F, -1.0F, 3.0F, 0.0F, 2.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.pivot(7.0F, -2.0F, -2.0F));

        ModelPartData right_leg = leg_base.addChild("right_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -1.0F, 0.0F, 5.0F, 3.0F, 0.0F, new Dilation(0.02F))
                .uv(0, 6).cuboid(-7.0F, 2.0F, -1.0F, 3.0F, 0.0F, 2.0F, new Dilation(0.01F)), ModelTransform.pivot(-5.0F, -2.0F, 7.0F));

        ModelPartData left_leg = leg_base.addChild("left_leg", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, -1.0F, 0.0F, 5.0F, 3.0F, 0.0F, new Dilation(0.02F)).mirrored(false)
                .uv(0, 6).mirrored().cuboid(4.0F, 2.0F, -1.0F, 3.0F, 0.0F, 2.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.pivot(5.0F, -2.0F, 7.0F));
        return TexturedModelData.of(modelData, 128, 128);
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