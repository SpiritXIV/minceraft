package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.tdbtd.global.entity.animation.entities.AbyssofinAnimations;
import com.spirit.tdbtd.global.entity.custom.AbyssofinEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class AbyssofinModel<T extends AbyssofinEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public AbyssofinModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(35, 13).cuboid(-5.0F, -5.0F, -6.0F, 10.0F, 9.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

        ModelPartData right_fin = body.addChild("right_fin", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -3.0F, 0.0F, 8.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 0.0F, -4.0F));

        ModelPartData left_fin = body.addChild("left_fin", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, -3.0F, 0.0F, 8.0F, 7.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(5.0F, 0.0F, -4.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -6.0F));

        ModelPartData upper_jaw = head.addChild("upper_jaw", ModelPartBuilder.create().uv(0, 44).cuboid(-4.0F, -4.0F, -14.0F, 8.0F, 4.0F, 14.0F, new Dilation(0.06F))
                .uv(30, 52).cuboid(-4.0F, 0.0F, -14.0F, 8.0F, 2.0F, 14.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData eyes = upper_jaw.addChild("eyes", ModelPartBuilder.create().uv(0, 26).cuboid(-5.0F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.12F))
                .uv(0, 26).mirrored().cuboid(2.0F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.12F)).mirrored(false), ModelTransform.pivot(0.0F, -1.0F, -5.0F));

        ModelPartData lower_jaw = head.addChild("lower_jaw", ModelPartBuilder.create().uv(0, 26).cuboid(-5.0F, 0.0F, -15.0F, 10.0F, 3.0F, 15.0F, new Dilation(0.06F))
                .uv(35, 35).cuboid(-5.0F, -2.0F, -15.0F, 10.0F, 2.0F, 15.0F, new Dilation(0.04F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 7.0F, 19.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 7.0F));

        ModelPartData dorsal_fin = tail.addChild("dorsal_fin", ModelPartBuilder.create().uv(0, 51).cuboid(0.0F, -6.0F, -1.0F, 0.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 1.0F));

        ModelPartData tail_fin = tail.addChild("tail_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -5.0F, 0.0F, 0.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 19.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(AbyssofinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(AbyssofinAnimations.ABYSSOFIN_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, AbyssofinAnimations.ABYSSOFIN_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, AbyssofinAnimations.ABYSSOFIN_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}