package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.ApertureTeethAnimations;
import com.spirit.tdbtd.entity.animation.entities.MijiapendraAnimations;
import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import com.spirit.tdbtd.entity.custom.MijapendraEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class MijapendraModel<T extends MijapendraEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public MijapendraModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData lower_body = body.addChild("lower_body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, 4.0F));

        ModelPartData lower_body_segment = lower_body.addChild("lower_body_segment", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -4.0F, -4.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 4.0F));

        ModelPartData lower_right_leg = lower_body_segment.addChild("lower_right_leg", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

        ModelPartData lower_left_leg = lower_body_segment.addChild("lower_left_leg", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

        ModelPartData lower_body_segment2 = lower_body_segment.addChild("lower_body_segment2", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -4.0F, -4.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 9.0F));

        ModelPartData lower_right_leg2 = lower_body_segment2.addChild("lower_right_leg2", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

        ModelPartData lower_left_leg2 = lower_body_segment2.addChild("lower_left_leg2", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

        ModelPartData lower_body_segment3 = lower_body_segment2.addChild("lower_body_segment3", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -4.0F, -4.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 9.0F));

        ModelPartData lower_right_leg3 = lower_body_segment3.addChild("lower_right_leg3", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

        ModelPartData lower_left_leg3 = lower_body_segment3.addChild("lower_left_leg3", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

        ModelPartData lower_body_segment4 = lower_body_segment3.addChild("lower_body_segment4", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -4.0F, -4.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 9.0F));

        ModelPartData lower_right_leg4 = lower_body_segment4.addChild("lower_right_leg4", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));

        ModelPartData lower_left_leg4 = lower_body_segment4.addChild("lower_left_leg4", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, 0.0F));

        ModelPartData tail = lower_body_segment4.addChild("tail", ModelPartBuilder.create().uv(0, 32).cuboid(-6.0F, -3.0F, 0.0F, 12.0F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.0F));

        ModelPartData lower_right_leg5 = tail.addChild("lower_right_leg5", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, 4.0F));

        ModelPartData lower_left_leg5 = tail.addChild("lower_left_leg5", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, 4.0F));

        ModelPartData right_tail_leg = tail.addChild("right_tail_leg", ModelPartBuilder.create().uv(33, 5).cuboid(0.0F, -5.0F, -1.0F, 0.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 10.0F));

        ModelPartData left_tail_leg = tail.addChild("left_tail_leg", ModelPartBuilder.create().uv(33, 5).cuboid(0.0F, -5.0F, -1.0F, 0.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.0F, 10.0F));

        ModelPartData upper_body = body.addChild("upper_body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, 4.0F));

        ModelPartData upper_body_segment = upper_body.addChild("upper_body_segment", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -4.0F, -9.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData upper_right_leg = upper_body_segment.addChild("upper_right_leg", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, -5.0F));

        ModelPartData upper_left_leg = upper_body_segment.addChild("upper_left_leg", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, -5.0F));

        ModelPartData upper_body_segment2 = upper_body_segment.addChild("upper_body_segment2", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -4.0F, -9.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -9.0F));

        ModelPartData upper_right_leg2 = upper_body_segment2.addChild("upper_right_leg2", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, -5.0F));

        ModelPartData upper_left_leg2 = upper_body_segment2.addChild("upper_left_leg2", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, -5.0F));

        ModelPartData upper_body_segment3 = upper_body_segment2.addChild("upper_body_segment3", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -4.0F, -9.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -9.0F));

        ModelPartData upper_right_leg3 = upper_body_segment3.addChild("upper_right_leg3", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, -5.0F));

        ModelPartData upper_left_leg3 = upper_body_segment3.addChild("upper_left_leg3", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, -5.0F));

        ModelPartData upper_body_segment4 = upper_body_segment3.addChild("upper_body_segment4", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, -4.0F, -9.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -9.0F));

        ModelPartData upper_right_leg4 = upper_body_segment4.addChild("upper_right_leg4", ModelPartBuilder.create().uv(33, 32).cuboid(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 0.0F, -5.0F));

        ModelPartData upper_left_leg4 = upper_body_segment4.addChild("upper_left_leg4", ModelPartBuilder.create().uv(33, 32).mirrored().cuboid(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(5.0F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, 0.0F, -5.0F));

        ModelPartData head = upper_body_segment4.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -5.0F, -9.0F, 12.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, -9.0F));

        ModelPartData right_antennae = head.addChild("right_antennae", ModelPartBuilder.create().uv(42, 6).cuboid(-10.0F, -7.0F, 0.0F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -3.0F, -5.0F));

        ModelPartData left_antennae = head.addChild("left_antennae", ModelPartBuilder.create().uv(42, 6).mirrored().cuboid(0.0F, -7.0F, 0.0F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.0F, -3.0F, -5.0F));

        ModelPartData right_mandible = head.addChild("right_mandible", ModelPartBuilder.create().uv(27, 0).cuboid(-2.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 0.0F, -7.0F));

        ModelPartData left_mandible = head.addChild("left_mandible", ModelPartBuilder.create().uv(27, 0).mirrored().cuboid(-5.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(5.0F, 0.0F, -7.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(MijapendraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(MijiapendraAnimations.MIJAPENDRA_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, MijiapendraAnimations.MIJAPENDRA_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, MijiapendraAnimations.MIJAPENDRA_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}