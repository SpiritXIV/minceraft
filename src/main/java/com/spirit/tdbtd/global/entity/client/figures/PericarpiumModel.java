package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.tdbtd.global.entity.animation.entities.PericarpiumAnimations;
import com.spirit.tdbtd.global.entity.custom.PericarpiumEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PericarpiumModel<T extends PericarpiumEntity> extends SinglePartEntityModel<T> {

    private final ModelPart base;
    public PericarpiumModel(ModelPart root) {
        this.base = root.getChild("base");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = base.addChild("head", ModelPartBuilder.create().uv(12, 17).cuboid(-3.0F, -2.0F, -2.0F, 6.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, -4.0F));

        ModelPartData right_antennae = head.addChild("right_antennae", ModelPartBuilder.create().uv(0, 11).cuboid(0.0F, -7.0F, -3.0F, 0.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, -2.0F));

        ModelPartData left_antennae = head.addChild("left_antennae", ModelPartBuilder.create().uv(0, 11).cuboid(0.0F, -7.0F, -3.0F, 0.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, -2.0F));

        ModelPartData body0 = base.addChild("body0", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

        ModelPartData right_front_flipper = body0.addChild("right_front_flipper", ModelPartBuilder.create().uv(13, 9).cuboid(-7.0F, 0.0F, -1.0F, 7.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, -2.0F));

        ModelPartData left_front_flipper = body0.addChild("left_front_flipper", ModelPartBuilder.create().uv(13, 9).mirrored().cuboid(0.0F, 0.0F, -1.0F, 7.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 0.0F, -2.0F));

        ModelPartData body1 = body0.addChild("body1", ModelPartBuilder.create().uv(0, 9).cuboid(-3.0F, -1.0F, 0.0F, 6.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 2.0F));

        ModelPartData tail = body1.addChild("tail", ModelPartBuilder.create().uv(27, 0).cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.0F));

        ModelPartData right_back_flipper = body1.addChild("right_back_flipper", ModelPartBuilder.create().uv(15, 0).cuboid(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 1.0F, 2.0F));

        ModelPartData left_back_flipper = body1.addChild("left_back_flipper", ModelPartBuilder.create().uv(15, 0).mirrored().cuboid(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 1.0F, 2.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(PericarpiumEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(PericarpiumAnimations.PERICARPIUM_FLY, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, PericarpiumAnimations.PERICARPIUM_IDLE, ageInTicks, 1f);
        //this.updateAnimation(entity.attackAnimationState, PericarpiumAnimations.APERTURENTEETH_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return base;
    }
}