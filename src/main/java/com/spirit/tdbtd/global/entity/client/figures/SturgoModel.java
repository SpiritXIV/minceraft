package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.tdbtd.global.entity.animation.entities.SturgoAnimations;
import com.spirit.tdbtd.global.entity.custom.SturgoEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SturgoModel<T extends SturgoEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public SturgoModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -10.0F, -17.0F, 14.0F, 10.0F, 30.0F, new Dilation(0.0F))
                .uv(12, 98).cuboid(-8.0F, -6.0F, -17.0F, 1.0F, 0.0F, 30.0F, new Dilation(0.0F))
                .uv(12, 98).mirrored().cuboid(7.0F, -6.0F, -17.0F, 1.0F, 0.0F, 30.0F, new Dilation(0.0F)).mirrored(false)
                .uv(52, 81).cuboid(0.0F, -12.0F, -17.0F, 0.0F, 2.0F, 30.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData body_fin_base = body.addChild("body_fin_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_front_fin = body_fin_base.addChild("right_front_fin", ModelPartBuilder.create().uv(0, 0).cuboid(-11.0F, 0.0F, -3.0F, 11.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -3.0F, -11.0F));

        ModelPartData left_front_fin = body_fin_base.addChild("left_front_fin", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, 0.0F, -3.0F, 11.0F, 0.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(7.0F, -3.0F, -11.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(58, 0).cuboid(-6.0F, -6.0F, -11.0F, 12.0F, 9.0F, 11.0F, new Dilation(0.03F))
                .uv(68, 67).cuboid(-5.0F, -4.0F, -21.0F, 10.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -17.0F));

        ModelPartData right_barbels = head.addChild("right_barbels", ModelPartBuilder.create().uv(2, 86).cuboid(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 3.0F, -17.0F));

        ModelPartData left_barbels = head.addChild("left_barbels", ModelPartBuilder.create().uv(2, 86).mirrored().cuboid(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 3.0F, -17.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 40).cuboid(-5.0F, -5.0F, 0.0F, 10.0F, 8.0F, 29.0F, new Dilation(0.0F))
                .uv(7, 99).cuboid(-6.0F, -2.0F, 0.0F, 1.0F, 0.0F, 29.0F, new Dilation(0.0F))
                .uv(7, 99).mirrored().cuboid(5.0F, -2.0F, 0.0F, 1.0F, 0.0F, 29.0F, new Dilation(0.0F)).mirrored(false)
                .uv(69, 105).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 13.0F));

        ModelPartData tail_fin_base = tail.addChild("tail_fin_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_back_fin = tail_fin_base.addChild("right_back_fin", ModelPartBuilder.create().uv(0, 8).cuboid(-7.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 2.0F, 9.0F));

        ModelPartData left_back_fin = tail_fin_base.addChild("left_back_fin", ModelPartBuilder.create().uv(0, 8).mirrored().cuboid(0.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(5.0F, 2.0F, 9.0F));

        ModelPartData Back_dorsal_fin = tail_fin_base.addChild("Back_dorsal_fin", ModelPartBuilder.create().uv(0, 7).cuboid(0.0F, -8.0F, -2.0F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 18.0F));

        ModelPartData tail_fin = tail_fin_base.addChild("tail_fin", ModelPartBuilder.create().uv(49, 24).cuboid(0.0F, -14.0F, 0.0F, 0.0F, 18.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 29.0F));

        ModelPartData bottom_fin = tail_fin_base.addChild("bottom_fin", ModelPartBuilder.create().uv(16, 9).cuboid(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, 21.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(SturgoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(SturgoAnimations.STURGO_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, SturgoAnimations.STURGO_IDLE, ageInTicks, 1f);
        //this.updateAnimation(entity.attackAnimationState, SturgoAnimations.APERTURENTEETH_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}