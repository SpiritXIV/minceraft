package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.KredaAnimations;
import com.spirit.tdbtd.entity.custom.KredaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class KredaModel<T extends KredaEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public KredaModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(29, 19).cuboid(-5.0F, -8.0F, -16.0F, 10.0F, 9.0F, 20.0F, new Dilation(0.03F)), ModelTransform.pivot(0.0F, -17.0F, 3.0F));

        ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(102, 101).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -1.0F, -13.0F));

        ModelPartData right_hand = right_arm.addChild("right_hand", ModelPartBuilder.create().uv(93, 120).mirrored().cuboid(-1.0F, 0.0F, 1.0F, 5.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(85, 120).cuboid(-1.0F, 0.0F, -2.0F, 5.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(88, 120).mirrored().cuboid(-1.0F, 2.0F, -2.0F, 5.0F, 0.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(82, 121).cuboid(-1.0F, 0.0F, -2.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(90, 123).cuboid(4.0F, 0.0F, -2.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 1.0F));

        ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(102, 101).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(5.0F, -1.0F, -13.0F));

        ModelPartData left_hand = left_arm.addChild("left_hand", ModelPartBuilder.create().uv(81, 120).mirrored().cuboid(-4.0F, 0.0F, -2.0F, 5.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(93, 120).cuboid(-4.0F, 0.0F, 1.0F, 5.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(90, 120).cuboid(-4.0F, 2.0F, -2.0F, 5.0F, 0.0F, 3.0F, new Dilation(0.0F))
                .uv(90, 123).cuboid(-4.0F, 0.0F, -2.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(82, 121).cuboid(1.0F, 0.0F, -2.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 1.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 39).cuboid(-2.0F, -3.0F, 0.0F, 4.0F, 5.0F, 19.0F, new Dilation(0.0F))
                .uv(0, 18).cuboid(-7.0F, -1.0F, 13.0F, 14.0F, 0.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 4.0F));

        ModelPartData right_front_wing = body.addChild("right_front_wing", ModelPartBuilder.create().uv(59, 48).cuboid(-16.0F, -1.0F, -2.0F, 16.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(17, 48).cuboid(-16.0F, 0.0F, 6.0F, 16.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -3.0F, -12.0F));

        ModelPartData right_front_wingtip = right_front_wing.addChild("right_front_wingtip", ModelPartBuilder.create().uv(-18, 97).cuboid(-21.0F, 0.0F, -2.0F, 21.0F, 0.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(-16.0F, 0.0F, 0.0F));

        ModelPartData left_front_wing = body.addChild("left_front_wing", ModelPartBuilder.create().uv(59, 48).mirrored().cuboid(0.0F, -1.0F, -2.0F, 16.0F, 2.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
                .uv(17, 48).mirrored().cuboid(0.0F, 0.0F, 6.0F, 16.0F, 0.0F, 10.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(5.0F, -3.0F, -12.0F));

        ModelPartData left_front_wingtip = left_front_wing.addChild("left_front_wingtip", ModelPartBuilder.create().uv(-18, 97).mirrored().cuboid(0.0F, 0.0F, -2.0F, 21.0F, 0.0F, 18.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(16.0F, 0.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 63).cuboid(-3.0F, -9.0F, -4.0F, 6.0F, 12.0F, 6.0F, new Dilation(0.0F))
                .uv(69, 27).cuboid(-3.0F, -9.0F, -9.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.05F))
                .uv(69, 16).cuboid(-2.0F, -8.0F, -16.0F, 4.0F, 4.0F, 7.0F, new Dilation(0.04F))
                .uv(97, 16).cuboid(-2.0F, -4.0F, -16.0F, 4.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, -15.0F));

        ModelPartData mouth = head.addChild("mouth", ModelPartBuilder.create().uv(72, 58).cuboid(-3.0F, 0.0F, -5.0F, 6.0F, 2.0F, 5.0F, new Dilation(0.03F))
                .uv(65, 70).cuboid(-2.0F, 0.0F, -12.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.02F))
                .uv(92, 71).cuboid(-2.0F, -1.0F, -12.0F, 4.0F, 1.0F, 7.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, -4.0F, -4.0F));

        ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(24, 63).cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(46, 45).cuboid(0.0F, -2.0F, 3.0F, 0.0F, 19.0F, 13.0F, new Dilation(0.0F))
                .uv(12, 15).cuboid(2.0F, 14.0F, -1.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(-2.0F, 17.0F, -1.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
                .uv(12, 4).mirrored().cuboid(-2.0F, 7.0F, 3.0F, 4.0F, 10.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-5.0F, -17.0F, 4.0F));

        ModelPartData right_leg_wing = right_leg.addChild("right_leg_wing", ModelPartBuilder.create().uv(43, 0).cuboid(-18.0F, 0.0F, 0.0F, 18.0F, 0.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 17.0F, 2.0F));

        ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(24, 63).mirrored().cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 9.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
                .uv(46, 45).cuboid(0.0F, -2.0F, 3.0F, 0.0F, 19.0F, 13.0F, new Dilation(0.0F))
                .uv(12, 15).cuboid(-2.0F, 14.0F, -1.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(12, 0).cuboid(-2.0F, 17.0F, -1.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
                .uv(12, 4).cuboid(-2.0F, 7.0F, 3.0F, 4.0F, 10.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -17.0F, 4.0F));

        ModelPartData left_leg_wing = left_leg.addChild("left_leg_wing", ModelPartBuilder.create().uv(43, 0).mirrored().cuboid(0.0F, 0.0F, 0.0F, 18.0F, 0.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 17.0F, 2.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(KredaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(KredaAnimations.KREDA_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, KredaAnimations.KREDA_STANDING_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, KredaAnimations.KREDA_ATTACK, ageInTicks, 1f);
        this.updateAnimation(entity.flyingAnimationState, KredaAnimations.KREDA_FLYING_IDLE, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}