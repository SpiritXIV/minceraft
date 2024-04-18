package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.tdbtd.global.entity.animation.entities.NidiverAnimations;
import com.spirit.tdbtd.global.entity.custom.NidiverEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class NidiverModel<T extends NidiverEntity> extends SinglePartEntityModel<T> {

    private final ModelPart cephalothorax;
    public NidiverModel(ModelPart root) {
        this.cephalothorax = root.getChild("cephalothorax");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData cephalothorax = modelPartData.addChild("cephalothorax", ModelPartBuilder.create().uv(40, 48).cuboid(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        ModelPartData right_fang = cephalothorax.addChild("right_fang", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(12, 5).cuboid(-1.0F, 3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 2.0F, -4.0F));

        ModelPartData left_fang = cephalothorax.addChild("left_fang", ModelPartBuilder.create().uv(12, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(12, 5).mirrored().cuboid(-1.0F, 3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.0F, 2.0F, -4.0F));

        ModelPartData leg_base = cephalothorax.addChild("leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0F, -2.0F));

        ModelPartData right_upper_leg = leg_base.addChild("right_upper_leg", ModelPartBuilder.create().uv(0, 48).cuboid(-23.0F, -1.0F, -1.0F, 23.0F, 2.0F, 2.0F, new Dilation(0.02F)), ModelTransform.pivot(-2.0F, -1.0F, 0.0F));

        ModelPartData right_lower_leg = right_upper_leg.addChild("right_lower_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -1.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-22.0F, 1.0F, 0.0F));

        ModelPartData right_upper_leg2 = leg_base.addChild("right_upper_leg2", ModelPartBuilder.create().uv(0, 48).cuboid(-23.0F, -1.0F, -1.0F, 23.0F, 2.0F, 2.0F, new Dilation(0.02F)), ModelTransform.pivot(-2.0F, -1.0F, 2.0F));

        ModelPartData right_lower_leg2 = right_upper_leg2.addChild("right_lower_leg2", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -1.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-22.0F, 1.0F, 0.0F));

        ModelPartData right_upper_leg3 = leg_base.addChild("right_upper_leg3", ModelPartBuilder.create().uv(0, 48).cuboid(-23.0F, -1.0F, -1.0F, 23.0F, 2.0F, 2.0F, new Dilation(0.02F)), ModelTransform.pivot(-2.0F, -1.0F, 4.0F));

        ModelPartData right_lower_leg3 = right_upper_leg3.addChild("right_lower_leg3", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -1.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-22.0F, 1.0F, 0.0F));

        ModelPartData right_upper_leg4 = leg_base.addChild("right_upper_leg4", ModelPartBuilder.create().uv(0, 48).cuboid(-23.0F, -1.0F, -1.0F, 23.0F, 2.0F, 2.0F, new Dilation(0.02F)), ModelTransform.pivot(-2.0F, -1.0F, 6.0F));

        ModelPartData right_lower_leg4 = right_upper_leg4.addChild("right_lower_leg4", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -1.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-22.0F, 1.0F, 0.0F));

        ModelPartData left_upper_leg = leg_base.addChild("left_upper_leg", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(0.0F, -1.0F, -1.0F, 23.0F, 2.0F, 2.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.pivot(2.0F, -1.0F, 0.0F));

        ModelPartData left_lower_leg = left_upper_leg.addChild("left_lower_leg", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -1.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(22.0F, 1.0F, 0.0F));

        ModelPartData left_upper_leg2 = leg_base.addChild("left_upper_leg2", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(0.0F, -1.0F, -1.0F, 23.0F, 2.0F, 2.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.pivot(2.0F, -1.0F, 2.0F));

        ModelPartData left_lower_leg2 = left_upper_leg2.addChild("left_lower_leg2", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -1.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(22.0F, 1.0F, 0.0F));

        ModelPartData left_upper_leg3 = leg_base.addChild("left_upper_leg3", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(0.0F, -1.0F, -1.0F, 23.0F, 2.0F, 2.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.pivot(2.0F, -1.0F, 4.0F));

        ModelPartData left_lower_leg3 = left_upper_leg3.addChild("left_lower_leg3", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -1.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(22.0F, 1.0F, 0.0F));

        ModelPartData left_upper_leg4 = leg_base.addChild("left_upper_leg4", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(0.0F, -1.0F, -1.0F, 23.0F, 2.0F, 2.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.pivot(2.0F, -1.0F, 6.0F));

        ModelPartData left_lower_leg4 = left_upper_leg4.addChild("left_lower_leg4", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -1.0F, 0.0F, 6.0F, 17.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(22.0F, 1.0F, 0.0F));

        ModelPartData abdomen = cephalothorax.addChild("abdomen", ModelPartBuilder.create().uv(0, 20).cuboid(-8.0F, -5.0F, 0.0F, 16.0F, 10.0F, 18.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-14.0F, 0.0F, 12.0F, 28.0F, 0.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 6.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        cephalothorax.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(NidiverEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(NidiverAnimations.NIDIVER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, NidiverAnimations.NIDIVER_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, NidiverAnimations.NIDIVER_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return cephalothorax;
    }
}