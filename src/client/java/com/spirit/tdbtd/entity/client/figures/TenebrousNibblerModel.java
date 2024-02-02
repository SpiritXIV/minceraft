package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.ApertureTeethAnimations;
import com.spirit.tdbtd.entity.animation.entities.TeneboursNibblerAnimations;
import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import com.spirit.tdbtd.entity.custom.TenebrousNibblerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class TenebrousNibblerModel<T extends TenebrousNibblerEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public TenebrousNibblerModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 6.0F, new Dilation(-0.02F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData dorsal_fin = body.addChild("dorsal_fin", ModelPartBuilder.create().uv(10, 13).cuboid(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 2.0F));

        ModelPartData mouth = body.addChild("mouth", ModelPartBuilder.create().uv(0, 11).cuboid(-1.0F, -4.0F, -3.0F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F))
                .uv(10, 11).cuboid(-1.0F, -4.0F, 0.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.02F))
                .uv(10, 11).cuboid(1.0F, -4.0F, 0.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.02F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail_fin = body.addChild("tail_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 4.0F));

        ModelPartData right_fin = body.addChild("right_fin", ModelPartBuilder.create().uv(7, 9).cuboid(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, 0.0F));

        ModelPartData left_fin = body.addChild("left_fin", ModelPartBuilder.create().uv(7, 9).cuboid(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(TenebrousNibblerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(TeneboursNibblerAnimations.TENEBROUS_NIBBLER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, TeneboursNibblerAnimations.TENEBROUS_NIBBLER_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, TeneboursNibblerAnimations.TENEBROUS_NIBBLER_ATTACK, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}