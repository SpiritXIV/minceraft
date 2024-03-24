package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.tdbtd.global.entity.animation.entities.CuratorAnimations;
import com.spirit.tdbtd.global.entity.custom.CuratorEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CuratorModel<T extends CuratorEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public CuratorModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(16, 0).cuboid(-3.0F, -11.0F, -3.0F, 6.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -28.0F, 0.0F));

        ModelPartData right_ribcage = body.addChild("right_ribcage", ModelPartBuilder.create().uv(0, 34).cuboid(0.0F, -4.0F, -2.0F, 3.0F, 8.0F, 2.0F, new Dilation(0.02F)), ModelTransform.pivot(-3.0F, -7.0F, -1.0F));

        ModelPartData left_ribcage = body.addChild("left_ribcage", ModelPartBuilder.create().uv(0, 34).mirrored().cuboid(-3.0F, -4.0F, -2.0F, 3.0F, 8.0F, 2.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.pivot(3.0F, -7.0F, -1.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(16, 16).cuboid(-3.0F, -10.0F, -3.0F, 6.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -11.0F, 0.0F));

        ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(44, 3).cuboid(-10.0F, -8.0F, 0.0F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -4.0F, 0.0F));

        ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(44, 3).mirrored().cuboid(0.0F, -8.0F, 0.0F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, -4.0F, 0.0F));

        ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 28.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -10.0F, 0.0F));

        ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 28.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -10.0F, 0.0F));

        ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(8, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 28.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -28.0F, -1.0F));

        ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(8, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 28.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, -28.0F, -1.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(CuratorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(CuratorAnimations.CURATOR_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, CuratorAnimations.CURATOR_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, CuratorAnimations.CURATOR_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}