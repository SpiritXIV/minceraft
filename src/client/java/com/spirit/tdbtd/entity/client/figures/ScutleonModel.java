package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.ScutleonAnimations;
import com.spirit.tdbtd.entity.custom.ScutleonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ScutleonModel<T extends ScutleonEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public ScutleonModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData thorax = root.addChild("thorax", ModelPartBuilder.create().uv(22, 19).cuboid(-3.0F, -5.0F, -4.0F, 6.0F, 5.0F, 7.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg_base = thorax.addChild("leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_leg_A = leg_base.addChild("right_leg_A", ModelPartBuilder.create().uv(32, 5).cuboid(-7.0F, 0.0F, -3.0F, 7.0F, 0.0F, 4.0F, new Dilation(0.02F)), ModelTransform.pivot(-1.0F, 0.0F, -2.0F));

        ModelPartData left_leg_A = leg_base.addChild("left_leg_A", ModelPartBuilder.create().uv(32, 5).mirrored().cuboid(0.0F, 0.0F, -3.0F, 7.0F, 0.0F, 4.0F, new Dilation(0.02F)).mirrored(false), ModelTransform.pivot(1.0F, 0.0F, -2.0F));

        ModelPartData right_leg_B = leg_base.addChild("right_leg_B", ModelPartBuilder.create().uv(19, 31).cuboid(-9.0F, 0.0F, -2.0F, 9.0F, 0.0F, 3.0F, new Dilation(0.03F)), ModelTransform.pivot(-2.0F, 0.0F, 1.0F));

        ModelPartData left_leg_B = leg_base.addChild("left_leg_B", ModelPartBuilder.create().uv(19, 31).mirrored().cuboid(0.0F, 0.0F, -2.0F, 9.0F, 0.0F, 3.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(2.0F, 0.0F, 1.0F));

        ModelPartData right_leg_C = leg_base.addChild("right_leg_C", ModelPartBuilder.create().uv(31, 0).cuboid(-6.0F, 0.0F, -1.0F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, 3.0F));

        ModelPartData left_leg_C = leg_base.addChild("left_leg_C", ModelPartBuilder.create().uv(31, 0).mirrored().cuboid(0.0F, 0.0F, -1.0F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, 0.0F, 3.0F));

        ModelPartData head = thorax.addChild("head", ModelPartBuilder.create().uv(0, 24).cuboid(-3.0F, -4.0F, -5.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, 0.0F, -4.0F));

        ModelPartData antennae_base = head.addChild("antennae_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

        ModelPartData right_antennae = antennae_base.addChild("right_antennae", ModelPartBuilder.create().uv(1, 46).cuboid(-10.0F, 0.0F, -9.0F, 10.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -2.0F, 0.0F));

        ModelPartData left_antennae = antennae_base.addChild("left_antennae", ModelPartBuilder.create().uv(1, 46).mirrored().cuboid(0.0F, 0.0F, -9.0F, 10.0F, 0.0F, 10.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, -2.0F, 0.0F));

        ModelPartData right_mandible = head.addChild("right_mandible", ModelPartBuilder.create().uv(0, 19).cuboid(-11.0F, 0.0F, -4.0F, 12.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.0F, -5.0F));

        ModelPartData left_mandible = head.addChild("left_mandible", ModelPartBuilder.create().uv(0, 19).mirrored().cuboid(-1.0F, 0.0F, -4.0F, 12.0F, 0.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.0F, -1.0F, -5.0F));

        ModelPartData abdomen = thorax.addChild("abdomen", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -4.0F, 0.0F, 12.0F, 7.0F, 12.0F, new Dilation(-0.02F)), ModelTransform.pivot(0.0F, -3.0F, 3.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(ScutleonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        //this.animateMovement(ScutleonAnimations.APERTURENTEETH_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ScutleonAnimations.SCUTLEON_IDLE, ageInTicks, 1f);
        //this.updateAnimation(entity.attackAnimationState, ScutleonAnimations.APERTURENTEETH_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}