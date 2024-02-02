package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.ApertureTeethAnimations;
import com.spirit.tdbtd.entity.animation.entities.DevastadorPupAnimations;
import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import com.spirit.tdbtd.entity.custom.DevastadorPupEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class DevastadorPupModel<T extends DevastadorPupEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public DevastadorPupModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 38).cuboid(-2.0F, -3.0F, -5.0F, 4.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(7, 13).cuboid(-3.0F, -3.0F, -16.0F, 6.0F, 5.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 10.0F));

        ModelPartData ribcage = body.addChild("ribcage", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -11.0F));

        ModelPartData right_ribs = ribcage.addChild("right_ribs", ModelPartBuilder.create().uv(33, 81).cuboid(0.0F, 0.0F, -6.0F, 2.0F, 4.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(-3.0F, 0.0F, 1.0F));

        ModelPartData left_ribs = ribcage.addChild("left_ribs", ModelPartBuilder.create().uv(33, 81).cuboid(-2.0F, 0.0F, -6.0F, 2.0F, 4.0F, 10.0F, new Dilation(0.1F)), ModelTransform.pivot(3.0F, 0.0F, 1.0F));

        ModelPartData back_spine_base = body.addChild("back_spine_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, -12.0F));

        ModelPartData back_sensor = back_spine_base.addChild("back_sensor", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

        ModelPartData back_sensor2 = back_spine_base.addChild("back_sensor2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 2.0F));

        ModelPartData back_sensor3 = back_spine_base.addChild("back_sensor3", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 5.0F));

        ModelPartData neck = body.addChild("neck", ModelPartBuilder.create().uv(0, 30).cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -17.0F));

        ModelPartData antennae = neck.addChild("antennae", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0F, -3.0F));

        ModelPartData right_antennae = antennae.addChild("right_antennae", ModelPartBuilder.create().uv(42, 1).cuboid(-10.0F, -8.0F, 0.0F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, 0.0F));

        ModelPartData left_antennae = antennae.addChild("left_antennae", ModelPartBuilder.create().uv(42, 1).mirrored().cuboid(0.0F, -8.0F, 0.0F, 10.0F, 10.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, -2.0F, 0.0F));

        ModelPartData head = neck.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -4.0F));

        ModelPartData jaws = head.addChild("jaws", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData upper_jaw = jaws.addChild("upper_jaw", ModelPartBuilder.create().uv(33, 29).cuboid(-3.0F, -3.0F, -8.0F, 6.0F, 3.0F, 8.0F, new Dilation(0.08F))
                .uv(11, 62).cuboid(-2.0F, 0.0F, -8.0F, 4.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData lower_jaw = jaws.addChild("lower_jaw", ModelPartBuilder.create().uv(47, 19).cuboid(-3.0F, 0.0F, -8.0F, 6.0F, 2.0F, 8.0F, new Dilation(0.06F))
                .uv(87, 4).cuboid(-2.0F, -1.0F, -8.0F, 4.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Right_arm = body.addChild("Right_arm", ModelPartBuilder.create().uv(67, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.03F)), ModelTransform.pivot(-4.0F, -1.0F, -13.0F));

        ModelPartData Left_arm = body.addChild("Left_arm", ModelPartBuilder.create().uv(67, 0).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(4.0F, -1.0F, -13.0F));

        ModelPartData Right_leg = root.addChild("Right_leg", ModelPartBuilder.create().uv(67, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.03F)), ModelTransform.pivot(-3.0F, -12.0F, 10.0F));

        ModelPartData Left_leg = root.addChild("Left_leg", ModelPartBuilder.create().uv(67, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(3.0F, -12.0F, 10.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(DevastadorPupEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(DevastadorPupAnimations.DEVASTADOR_PUP_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, DevastadorPupAnimations.DEVASTADOR_PUP_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, DevastadorPupAnimations.DEVASTADOR_PUP_IDLE, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}