package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.tdbtd.global.entity.animation.entities.ContrivancePollaAnimations;
import com.spirit.tdbtd.global.entity.custom.ContrivancePollaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ContrivancePollaModel<T extends ContrivancePollaEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public ContrivancePollaModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-11.0F, -6.0F, -11.0F, 22.0F, 7.0F, 22.0F, new Dilation(0.0F))
                .uv(48, 41).cuboid(-8.0F, -13.0F, -8.0F, 16.0F, 7.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

        ModelPartData skeleton = body.addChild("skeleton", ModelPartBuilder.create().uv(0, 57).cuboid(-7.0F, -16.0F, -7.0F, 14.0F, 16.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData head = skeleton.addChild("head", ModelPartBuilder.create().uv(64, 96).cuboid(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

        ModelPartData soul = skeleton.addChild("soul", ModelPartBuilder.create().uv(16, 0).cuboid(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

        ModelPartData leg_base = root.addChild("leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

        ModelPartData right_leg_base = leg_base.addChild("right_leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_leg0 = right_leg_base.addChild("right_leg0", ModelPartBuilder.create().uv(48, 29).cuboid(-17.0F, -2.0F, -2.0F, 18.0F, 4.0F, 4.0F, new Dilation(0.04F)), ModelTransform.pivot(-11.0F, -3.0F, -10.0F));

        ModelPartData right_leg_section0 = right_leg0.addChild("right_leg_section0", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.02F)), ModelTransform.pivot(-15.0F, 2.0F, 0.0F));

        ModelPartData right_claw0 = right_leg_section0.addChild("right_claw0", ModelPartBuilder.create().uv(56, 64).cuboid(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 37).cuboid(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 29).cuboid(-1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(48, 37).cuboid(-9.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

        ModelPartData right_leg1 = right_leg_base.addChild("right_leg1", ModelPartBuilder.create().uv(48, 29).cuboid(-17.0F, -2.0F, -2.0F, 18.0F, 4.0F, 4.0F, new Dilation(0.04F)), ModelTransform.pivot(-11.0F, -3.0F, 10.0F));

        ModelPartData right_leg_section1 = right_leg1.addChild("right_leg_section1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.02F)), ModelTransform.pivot(-15.0F, 2.0F, 0.0F));

        ModelPartData right_claw1 = right_leg_section1.addChild("right_claw1", ModelPartBuilder.create().uv(56, 64).cuboid(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 37).cuboid(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 29).cuboid(-1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(48, 37).cuboid(-9.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

        ModelPartData left_leg_base = leg_base.addChild("left_leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData left_leg0 = left_leg_base.addChild("left_leg0", ModelPartBuilder.create().uv(48, 29).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 18.0F, 4.0F, 4.0F, new Dilation(0.04F)).mirrored(false), ModelTransform.pivot(11.0F, -3.0F, -10.0F));

        ModelPartData left_leg_section0 = left_leg0.addChild("left_leg_section0", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.pivot(15.0F, 2.0F, 0.0F));

        ModelPartData left_claw0 = left_leg_section0.addChild("left_claw0", ModelPartBuilder.create().uv(56, 64).mirrored().cuboid(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 37).mirrored().cuboid(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 29).mirrored().cuboid(-1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(48, 37).mirrored().cuboid(3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 16).mirrored().cuboid(-9.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

        ModelPartData left_leg1 = left_leg_base.addChild("left_leg1", ModelPartBuilder.create().uv(48, 29).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 18.0F, 4.0F, 4.0F, new Dilation(0.04F)).mirrored(false), ModelTransform.pivot(11.0F, -3.0F, 10.0F));

        ModelPartData left_leg_section1 = left_leg1.addChild("left_leg_section1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.pivot(15.0F, 2.0F, 0.0F));

        ModelPartData left_claw1 = left_leg_section1.addChild("left_claw1", ModelPartBuilder.create().uv(56, 64).mirrored().cuboid(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 37).mirrored().cuboid(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 29).mirrored().cuboid(-1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(48, 37).mirrored().cuboid(3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 16).mirrored().cuboid(-9.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 13.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(ContrivancePollaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(ContrivancePollaAnimations.CONTRIVANCEPOLLA_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ContrivancePollaAnimations.CONTRIVANCEPOLLA_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ContrivancePollaAnimations.CONTRIVANCEPOLLA_IDLE, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}