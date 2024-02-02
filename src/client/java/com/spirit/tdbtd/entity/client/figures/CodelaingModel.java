package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.ApertureTeethAnimations;
import com.spirit.tdbtd.entity.animation.entities.CodelaingAnimations;
import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import com.spirit.tdbtd.entity.custom.CodelaingEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CodelaingModel<T extends CodelaingEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public CodelaingModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -6.0F, -8.0F, 8.0F, 8.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.0F, 0.0F));

        ModelPartData body_fin_base = root.addChild("body_fin_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0F, 0.0F));

        ModelPartData Right_front_fin = body_fin_base.addChild("Right_front_fin", ModelPartBuilder.create().uv(18, 51).cuboid(-7.0F, 0.0F, -2.0F, 7.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -1.0F, -4.0F));

        ModelPartData Left_front_fin = body_fin_base.addChild("Left_front_fin", ModelPartBuilder.create().uv(18, 51).mirrored().cuboid(0.0F, 0.0F, -2.0F, 7.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -1.0F, -4.0F));

        ModelPartData front_dorsal_fin = body_fin_base.addChild("front_dorsal_fin", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -5.0F, -2.0F, 1.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 3.0F));

        ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(30, 42).cuboid(-3.0F, -3.0F, -6.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.14F))
                .uv(0, 59).cuboid(-3.0F, 0.0F, -6.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.14F)), ModelTransform.pivot(0.0F, -2.0F, -8.0F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(32, 0).cuboid(-3.0F, -1.0F, -11.0F, 6.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, -6.0F));

        ModelPartData mouth = head.addChild("mouth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.0F, 0.0F));

        ModelPartData upper_jaw = mouth.addChild("upper_jaw", ModelPartBuilder.create().uv(48, 13).cuboid(-3.0F, 0.0F, -6.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData lower_jaw = upper_jaw.addChild("lower_jaw", ModelPartBuilder.create().uv(48, 45).cuboid(-3.0F, 0.0F, -6.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.06F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = root.addChild("tail", ModelPartBuilder.create().uv(28, 24).cuboid(-3.0F, -4.0F, 0.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 8.0F));

        ModelPartData tail_fin_base = tail.addChild("tail_fin_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData back_dorsal_fin = tail_fin_base.addChild("back_dorsal_fin", ModelPartBuilder.create().uv(32, 0).cuboid(-0.5F, -3.0F, -1.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 4.0F));

        ModelPartData tail_fin = tail_fin_base.addChild("tail_fin", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 11.0F));

        ModelPartData tail_fin_r1 = tail_fin.addChild("tail_fin_r1", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -4.0F, -2.0F, 0.0F, 8.0F, 20.0F, new Dilation(0.0F))
                .uv(0, 32).cuboid(-0.5F, -4.0F, -2.0F, 1.0F, 4.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.3054F, 0.0F, 0.0F));

        ModelPartData bottom_tail_fin = tail_fin_base.addChild("bottom_tail_fin", ModelPartBuilder.create().uv(0, 32).cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 7.0F));

        ModelPartData back_right_fin = tail_fin_base.addChild("back_right_fin", ModelPartBuilder.create().uv(0, 11).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 1.0F, 3.0F));

        ModelPartData back_left_fin = tail_fin_base.addChild("back_left_fin", ModelPartBuilder.create().uv(0, 11).mirrored().cuboid(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 1.0F, 3.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(CodelaingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(CodelaingAnimations.CODELAING_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, CodelaingAnimations.CODELAING_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, CodelaingAnimations.CODELAING_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}