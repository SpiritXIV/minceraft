package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.ApertureTeethAnimations;
import com.spirit.tdbtd.entity.animation.entities.EnguiaAnimations;
import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import com.spirit.tdbtd.entity.custom.EnguiaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class EnguiaModel<T extends EnguiaEntity> extends SinglePartEntityModel<T> {

    private final ModelPart base;
    public EnguiaModel(ModelPart root) {
        this.base = root.getChild("base");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body0 = base.addChild("body0", ModelPartBuilder.create().uv(0, 22).cuboid(-4.0F, -6.0F, -7.0F, 8.0F, 6.0F, 16.0F, new Dilation(0.05F))
                .uv(96, 29).cuboid(0.0F, -9.0F, -7.0F, 0.0F, 3.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

        ModelPartData neck0 = body0.addChild("neck0", ModelPartBuilder.create().uv(0, 79).cuboid(-3.5F, -4.0F, -9.0F, 7.0F, 6.0F, 9.0F, new Dilation(0.04F))
                .uv(108, 11).cuboid(0.0F, -7.0F, -9.0F, 0.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, -7.0F));

        ModelPartData neck1 = neck0.addChild("neck1", ModelPartBuilder.create().uv(62, 32).cuboid(-3.0F, -4.0F, -7.0F, 6.0F, 6.0F, 7.0F, new Dilation(0.03F))
                .uv(111, 6).cuboid(0.0F, -7.0F, -7.0F, 0.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -9.0F));

        ModelPartData neck2 = neck1.addChild("neck2", ModelPartBuilder.create().uv(63, 50).cuboid(-3.0F, -4.0F, -7.0F, 6.0F, 6.0F, 7.0F, new Dilation(0.02F))
                .uv(102, 0).cuboid(0.0F, -7.0F, -7.0F, 0.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -7.0F));

        ModelPartData neck3 = neck2.addChild("neck3", ModelPartBuilder.create().uv(62, 7).cuboid(-3.0F, -3.0F, -8.0F, 6.0F, 6.0F, 8.0F, new Dilation(0.01F))
                .uv(92, -8).cuboid(0.0F, -6.0F, -8.0F, 0.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, -7.0F));

        ModelPartData head = neck3.addChild("head", ModelPartBuilder.create().uv(45, 76).cuboid(-3.0F, -5.0F, -8.0F, 6.0F, 4.0F, 8.0F, new Dilation(0.03F))
                .uv(46, 90).cuboid(-2.5F, -5.0F, -16.0F, 5.0F, 4.0F, 8.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, 2.0F, -8.0F));

        ModelPartData mouth = head.addChild("mouth", ModelPartBuilder.create().uv(76, 76).cuboid(-3.0F, 0.0F, -8.0F, 6.0F, 3.0F, 8.0F, new Dilation(0.03F))
                .uv(82, 90).cuboid(-2.5F, -2.0F, -16.0F, 5.0F, 5.0F, 8.0F, new Dilation(0.04F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

        ModelPartData body1 = body0.addChild("body1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 16.0F, new Dilation(0.06F))
                .uv(96, 11).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 3.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 9.0F));

        ModelPartData tail0 = body1.addChild("tail0", ModelPartBuilder.create().uv(0, 99).cuboid(-3.5F, -3.0F, 0.0F, 7.0F, 6.0F, 10.0F, new Dilation(0.02F))
                .uv(108, 40).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 16.0F));

        ModelPartData tail1 = tail0.addChild("tail1", ModelPartBuilder.create().uv(37, 15).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 11.0F, new Dilation(0.0F))
                .uv(99, 25).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 3.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 10.0F));

        ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create().uv(0, 44).cuboid(-3.0F, -2.0F, 0.0F, 6.0F, 5.0F, 10.0F, new Dilation(0.03F))
                .uv(108, 45).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 11.0F));

        ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create().uv(0, 59).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 5.0F, 10.0F, new Dilation(0.03F))
                .uv(67, -10).cuboid(0.0F, -8.0F, 0.0F, 0.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 10.0F));

        ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create().uv(45, 54).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 5.0F, 10.0F, new Dilation(0.02F))
                .uv(94, 45).cuboid(0.0F, -8.0F, 0.0F, 0.0F, 9.0F, 17.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 10.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(EnguiaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(EnguiaAnimations.ENGUIA_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, EnguiaAnimations.ENGUIA_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, EnguiaAnimations.ENGUIA_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return base;
    }
}