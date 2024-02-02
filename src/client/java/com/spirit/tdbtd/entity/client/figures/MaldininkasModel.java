package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.MaldininkasAnimations;
import com.spirit.tdbtd.entity.custom.MaldininkasEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class MaldininkasModel<T extends MaldininkasEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public MaldininkasModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body_base = root.addChild("body_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData thorax = body_base.addChild("thorax", ModelPartBuilder.create().uv(38, 0).cuboid(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -20.0F, -4.0F));

        ModelPartData leg_base = thorax.addChild("leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_leg = leg_base.addChild("right_leg", ModelPartBuilder.create().uv(0, 53).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 24.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 2).cuboid(-2.0F, 22.0F, -5.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -2.0F, -2.0F));

        ModelPartData right_leg2 = leg_base.addChild("right_leg2", ModelPartBuilder.create().uv(0, 53).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 24.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 2).cuboid(-2.0F, 22.0F, -1.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -2.0F, 3.0F));

        ModelPartData left_leg = leg_base.addChild("left_leg", ModelPartBuilder.create().uv(0, 53).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 24.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 2).mirrored().cuboid(-2.0F, 22.0F, -5.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -2.0F, -2.0F));

        ModelPartData left_leg2 = leg_base.addChild("left_leg2", ModelPartBuilder.create().uv(0, 53).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 24.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(14, 2).mirrored().cuboid(-2.0F, 22.0F, -1.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -2.0F, 3.0F));

        ModelPartData neck = thorax.addChild("neck", ModelPartBuilder.create().uv(72, 0).cuboid(-2.0F, -19.0F, -1.0F, 4.0F, 19.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, -5.0F));

        ModelPartData arm_base = neck.addChild("arm_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.0F, -5.0F));

        ModelPartData right_upper_arm = arm_base.addChild("right_upper_arm", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -2.0F, 2.0F, 14.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -1.0F, 5.0F));

        ModelPartData right_lower_arm = right_upper_arm.addChild("right_lower_arm", ModelPartBuilder.create().uv(28, 23).cuboid(-1.0F, -1.0F, -15.0F, 2.0F, 3.0F, 16.0F, new Dilation(0.08F))
                .uv(31, 32).cuboid(0.0F, -1.0F, -15.0F, 0.0F, 7.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

        ModelPartData right_arm_claw = right_lower_arm.addChild("right_arm_claw", ModelPartBuilder.create().uv(8, 53).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 13.0F, 3.0F, new Dilation(0.0F))
                .uv(28, 17).cuboid(0.0F, 4.0F, -3.0F, 0.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -15.0F));

        ModelPartData left_upper_arm = arm_base.addChild("left_upper_arm", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 2.0F, 14.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, -1.0F, 5.0F));

        ModelPartData left_lower_arm = left_upper_arm.addChild("left_lower_arm", ModelPartBuilder.create().uv(28, 23).mirrored().cuboid(-1.0F, -1.0F, -15.0F, 2.0F, 3.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(31, 32).cuboid(0.0F, -1.0F, -15.0F, 0.0F, 7.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

        ModelPartData left_arm_claw = left_lower_arm.addChild("left_arm_claw", ModelPartBuilder.create().uv(8, 53).mirrored().cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 13.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(28, 17).mirrored().cuboid(0.0F, 4.0F, -3.0F, 0.0F, 12.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, -15.0F));

        ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(48, 23).cuboid(-3.0F, -4.0F, -4.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.04F))
                .uv(18, 53).cuboid(-5.0F, -5.0F, -3.0F, 2.0F, 6.0F, 3.0F, new Dilation(0.0F))
                .uv(18, 53).mirrored().cuboid(3.0F, -5.0F, -3.0F, 2.0F, 6.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -20.0F, 2.0F));

        ModelPartData right_antennae = head.addChild("right_antennae", ModelPartBuilder.create().uv(0, 28).cuboid(-10.0F, -10.0F, 0.0F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 1.0F));

        ModelPartData left_antennae = head.addChild("left_antennae", ModelPartBuilder.create().uv(0, 28).mirrored().cuboid(0.0F, -10.0F, 0.0F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 0.0F, 1.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(MaldininkasEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(MaldininkasAnimations.MALDININKAS_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, MaldininkasAnimations.MALDININKAS_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, MaldininkasAnimations.MALDININKAS_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}