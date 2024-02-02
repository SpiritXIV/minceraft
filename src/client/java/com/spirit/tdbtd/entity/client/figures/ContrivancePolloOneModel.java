package com.spirit.tdbtd.entity.client.figures;

import com.spirit.tdbtd.entity.animation.entities.ApertureTeethAnimations;
import com.spirit.tdbtd.entity.animation.entities.ContrivancePolloOneAnimations;
import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import com.spirit.tdbtd.entity.custom.ContrivancePolloOneEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ContrivancePolloOneModel<T extends ContrivancePolloOneEntity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    public ContrivancePolloOneModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-40.0F, -20.0F, -39.0F, 80.0F, 20.0F, 79.0F, new Dilation(0.0F))
                .uv(144, 132).cuboid(-24.0F, -41.0F, -24.0F, 48.0F, 21.0F, 48.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -23.0F, 0.0F));

        ModelPartData skeleton = body.addChild("skeleton", ModelPartBuilder.create().uv(0, 180).cuboid(-21.0F, -47.0F, -20.0F, 42.0F, 47.0F, 42.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

        ModelPartData Soul = skeleton.addChild("Soul", ModelPartBuilder.create().uv(356, 78).cuboid(-1.5F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -28.0F, 0.0F));

        ModelPartData spinning_souls = Soul.addChild("spinning_souls", ModelPartBuilder.create().uv(346, 31).cuboid(-17.0F, -16.0F, 1.0F, 34.0F, 34.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = skeleton.addChild("head", ModelPartBuilder.create().uv(0, 99).cuboid(-24.0F, -17.0F, -24.0F, 48.0F, 33.0F, 48.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -48.0F, 0.0F));

        ModelPartData leg_base = root.addChild("leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -31.0F, 0.0F));

        ModelPartData right_leg_base = leg_base.addChild("right_leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_leg0 = right_leg_base.addChild("right_leg0", ModelPartBuilder.create().uv(126, 201).cuboid(-14.0F, -5.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.09F)), ModelTransform.pivot(-40.0F, -5.0F, -35.5F));

        ModelPartData right_leg_sectionA0 = right_leg0.addChild("right_leg_sectionA0", ModelPartBuilder.create().uv(180, 202).cuboid(-15.0F, -4.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.07F)), ModelTransform.pivot(-14.0F, -1.0F, 0.0F));

        ModelPartData right_leg_sectionB0 = right_leg_sectionA0.addChild("right_leg_sectionB0", ModelPartBuilder.create().uv(228, 201).cuboid(-17.0F, -4.0F, -3.5F, 17.0F, 7.0F, 7.0F, new Dilation(0.05F)), ModelTransform.pivot(-15.0F, 0.0F, 0.0F));

        ModelPartData right_leg_sectionC0 = right_leg_sectionB0.addChild("right_leg_sectionC0", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.03F)), ModelTransform.pivot(-14.0F, 3.0F, 0.0F));

        ModelPartData right_leg_sectionD0 = right_leg_sectionC0.addChild("right_leg_sectionD0", ModelPartBuilder.create().uv(0, 28).cuboid(-3.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData right_claw0 = right_leg_sectionD0.addChild("right_claw0", ModelPartBuilder.create().uv(144, 99).cuboid(-4.0F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F, new Dilation(0.03F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData right_pincerA0 = right_claw0.addChild("right_pincerA0", ModelPartBuilder.create().uv(264, 0).cuboid(-14.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData right_pincerB0 = right_claw0.addChild("right_pincerB0", ModelPartBuilder.create().uv(264, 11).cuboid(0.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

        ModelPartData right_pincerC0 = right_claw0.addChild("right_pincerC0", ModelPartBuilder.create().uv(263, 21).cuboid(-1.0F, -2.0F, -15.05F, 2.0F, 4.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

        ModelPartData right_pincerD0 = right_claw0.addChild("right_pincerD0", ModelPartBuilder.create().uv(264, 43).cuboid(-1.0F, -2.0F, -0.05F, 2.0F, 4.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

        ModelPartData right_leg1 = right_leg_base.addChild("right_leg1", ModelPartBuilder.create().uv(126, 201).cuboid(-14.0F, -5.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.09F)), ModelTransform.pivot(-40.0F, -5.0F, 0.5F));

        ModelPartData right_leg_sectionA1 = right_leg1.addChild("right_leg_sectionA1", ModelPartBuilder.create().uv(180, 202).cuboid(-15.0F, -4.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.07F)), ModelTransform.pivot(-14.0F, -1.0F, 0.0F));

        ModelPartData right_leg_sectionB1 = right_leg_sectionA1.addChild("right_leg_sectionB1", ModelPartBuilder.create().uv(228, 201).cuboid(-17.0F, -4.0F, -3.5F, 17.0F, 7.0F, 7.0F, new Dilation(0.05F)), ModelTransform.pivot(-15.0F, 0.0F, 0.0F));

        ModelPartData right_leg_sectionC1 = right_leg_sectionB1.addChild("right_leg_sectionC1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.03F)), ModelTransform.pivot(-14.0F, 3.0F, 0.0F));

        ModelPartData right_leg_sectionD1 = right_leg_sectionC1.addChild("right_leg_sectionD1", ModelPartBuilder.create().uv(0, 28).cuboid(-3.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData right_claw1 = right_leg_sectionD1.addChild("right_claw1", ModelPartBuilder.create().uv(144, 99).cuboid(-4.0F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F, new Dilation(0.03F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData right_pincerA1 = right_claw1.addChild("right_pincerA1", ModelPartBuilder.create().uv(264, 0).cuboid(-14.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData right_pincerB1 = right_claw1.addChild("right_pincerB1", ModelPartBuilder.create().uv(264, 11).cuboid(0.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

        ModelPartData right_pincerC1 = right_claw1.addChild("right_pincerC1", ModelPartBuilder.create().uv(263, 21).cuboid(-1.0F, -2.0F, -15.05F, 2.0F, 4.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

        ModelPartData right_pincerD1 = right_claw1.addChild("right_pincerD1", ModelPartBuilder.create().uv(264, 43).cuboid(-1.0F, -2.0F, -0.05F, 2.0F, 4.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

        ModelPartData right_leg2 = right_leg_base.addChild("right_leg2", ModelPartBuilder.create().uv(126, 201).cuboid(-14.0F, -5.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.09F)), ModelTransform.pivot(-40.0F, -5.0F, 36.5F));

        ModelPartData right_leg_sectionA2 = right_leg2.addChild("right_leg_sectionA2", ModelPartBuilder.create().uv(180, 202).cuboid(-15.0F, -4.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.07F)), ModelTransform.pivot(-14.0F, -1.0F, 0.0F));

        ModelPartData right_leg_sectionB2 = right_leg_sectionA2.addChild("right_leg_sectionB2", ModelPartBuilder.create().uv(228, 201).cuboid(-17.0F, -4.0F, -3.5F, 17.0F, 7.0F, 7.0F, new Dilation(0.05F)), ModelTransform.pivot(-15.0F, 0.0F, 0.0F));

        ModelPartData right_leg_sectionC2 = right_leg_sectionB2.addChild("right_leg_sectionC2", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.03F)), ModelTransform.pivot(-14.0F, 3.0F, 0.0F));

        ModelPartData right_leg_sectionD2 = right_leg_sectionC2.addChild("right_leg_sectionD2", ModelPartBuilder.create().uv(0, 28).cuboid(-3.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData right_claw2 = right_leg_sectionD2.addChild("right_claw2", ModelPartBuilder.create().uv(144, 99).cuboid(-4.0F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F, new Dilation(0.03F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData right_pincerA2 = right_claw2.addChild("right_pincerA2", ModelPartBuilder.create().uv(264, 0).cuboid(-14.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData right_pincerB2 = right_claw2.addChild("right_pincerB2", ModelPartBuilder.create().uv(264, 11).cuboid(0.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

        ModelPartData right_pincerC2 = right_claw2.addChild("right_pincerC2", ModelPartBuilder.create().uv(263, 21).cuboid(-1.0F, -2.0F, -15.05F, 2.0F, 4.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

        ModelPartData right_pincerD2 = right_claw2.addChild("right_pincerD2", ModelPartBuilder.create().uv(264, 43).cuboid(-1.0F, -2.0F, -0.05F, 2.0F, 4.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

        ModelPartData left_leg_base = leg_base.addChild("left_leg_base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData left_leg0 = left_leg_base.addChild("left_leg0", ModelPartBuilder.create().uv(126, 201).mirrored().cuboid(-1.0F, -5.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.09F)).mirrored(false), ModelTransform.pivot(40.0F, -5.0F, -35.5F));

        ModelPartData left_leg_sectionA0 = left_leg0.addChild("left_leg_sectionA0", ModelPartBuilder.create().uv(180, 202).mirrored().cuboid(0.0F, -4.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.07F)).mirrored(false), ModelTransform.pivot(14.0F, -1.0F, 0.0F));

        ModelPartData left_leg_sectionB0 = left_leg_sectionA0.addChild("left_leg_sectionB0", ModelPartBuilder.create().uv(228, 201).mirrored().cuboid(0.0F, -4.0F, -3.5F, 17.0F, 7.0F, 7.0F, new Dilation(0.05F)).mirrored(false), ModelTransform.pivot(15.0F, 0.0F, 0.0F));

        ModelPartData left_leg_sectionC0 = left_leg_sectionB0.addChild("left_leg_sectionC0", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(14.0F, 3.0F, 0.0F));

        ModelPartData left_leg_sectionD0 = left_leg_sectionC0.addChild("left_leg_sectionD0", ModelPartBuilder.create().uv(0, 28).mirrored().cuboid(-4.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData left_claw0 = left_leg_sectionD0.addChild("left_claw0", ModelPartBuilder.create().uv(144, 99).mirrored().cuboid(-5.0F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData left_pincerA0 = left_claw0.addChild("left_pincerA0", ModelPartBuilder.create().uv(264, 0).mirrored().cuboid(0.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 0.0F, 0.0F));

        ModelPartData left_pincerB0 = left_claw0.addChild("left_pincerB0", ModelPartBuilder.create().uv(264, 11).mirrored().cuboid(-14.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

        ModelPartData left_pincerC0 = left_claw0.addChild("left_pincerC0", ModelPartBuilder.create().uv(263, 21).mirrored().cuboid(-1.0F, -2.0F, -15.05F, 2.0F, 4.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

        ModelPartData left_pincerD0 = left_claw0.addChild("left_pincerD0", ModelPartBuilder.create().uv(264, 43).mirrored().cuboid(-1.0F, -2.0F, -0.05F, 2.0F, 4.0F, 14.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

        ModelPartData left_leg1 = left_leg_base.addChild("left_leg1", ModelPartBuilder.create().uv(126, 201).mirrored().cuboid(-1.0F, -5.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.09F)).mirrored(false), ModelTransform.pivot(40.0F, -5.0F, 1.5F));

        ModelPartData left_leg_sectionA1 = left_leg1.addChild("left_leg_sectionA1", ModelPartBuilder.create().uv(180, 202).mirrored().cuboid(0.0F, -4.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.07F)).mirrored(false), ModelTransform.pivot(14.0F, -1.0F, 0.0F));

        ModelPartData left_leg_sectionB1 = left_leg_sectionA1.addChild("left_leg_sectionB1", ModelPartBuilder.create().uv(228, 201).mirrored().cuboid(0.0F, -4.0F, -3.5F, 17.0F, 7.0F, 7.0F, new Dilation(0.05F)).mirrored(false), ModelTransform.pivot(15.0F, 0.0F, 0.0F));

        ModelPartData left_leg_sectionC1 = left_leg_sectionB1.addChild("left_leg_sectionC1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(14.0F, 3.0F, 0.0F));

        ModelPartData left_leg_sectionD1 = left_leg_sectionC1.addChild("left_leg_sectionD1", ModelPartBuilder.create().uv(0, 28).mirrored().cuboid(-4.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData left_claw1 = left_leg_sectionD1.addChild("left_claw1", ModelPartBuilder.create().uv(144, 99).mirrored().cuboid(-5.0F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData left_pincerA1 = left_claw1.addChild("left_pincerA1", ModelPartBuilder.create().uv(264, 0).mirrored().cuboid(0.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 0.0F, 0.0F));

        ModelPartData left_pincerB1 = left_claw1.addChild("left_pincerB1", ModelPartBuilder.create().uv(264, 11).mirrored().cuboid(-14.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

        ModelPartData left_pincerC1 = left_claw1.addChild("left_pincerC1", ModelPartBuilder.create().uv(263, 21).mirrored().cuboid(-1.0F, -2.0F, -15.05F, 2.0F, 4.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

        ModelPartData left_pincerD1 = left_claw1.addChild("left_pincerD1", ModelPartBuilder.create().uv(264, 43).mirrored().cuboid(-1.0F, -2.0F, -0.05F, 2.0F, 4.0F, 14.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

        ModelPartData left_leg2 = left_leg_base.addChild("left_leg2", ModelPartBuilder.create().uv(126, 201).mirrored().cuboid(-1.0F, -5.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.09F)).mirrored(false), ModelTransform.pivot(40.0F, -5.0F, 36.5F));

        ModelPartData left_leg_sectionA2 = left_leg2.addChild("left_leg_sectionA2", ModelPartBuilder.create().uv(180, 202).mirrored().cuboid(0.0F, -4.0F, -3.5F, 15.0F, 7.0F, 7.0F, new Dilation(0.07F)).mirrored(false), ModelTransform.pivot(14.0F, -1.0F, 0.0F));

        ModelPartData left_leg_sectionB2 = left_leg_sectionA2.addChild("left_leg_sectionB2", ModelPartBuilder.create().uv(228, 201).mirrored().cuboid(0.0F, -4.0F, -3.5F, 17.0F, 7.0F, 7.0F, new Dilation(0.05F)).mirrored(false), ModelTransform.pivot(15.0F, 0.0F, 0.0F));

        ModelPartData left_leg_sectionC2 = left_leg_sectionB2.addChild("left_leg_sectionC2", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(14.0F, 3.0F, 0.0F));

        ModelPartData left_leg_sectionD2 = left_leg_sectionC2.addChild("left_leg_sectionD2", ModelPartBuilder.create().uv(0, 28).mirrored().cuboid(-4.0F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData left_claw2 = left_leg_sectionD2.addChild("left_claw2", ModelPartBuilder.create().uv(144, 99).mirrored().cuboid(-5.0F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F, new Dilation(0.03F)).mirrored(false), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData left_pincerA2 = left_claw2.addChild("left_pincerA2", ModelPartBuilder.create().uv(264, 0).mirrored().cuboid(0.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.0F, 0.0F, 0.0F));

        ModelPartData left_pincerB2 = left_claw2.addChild("left_pincerB2", ModelPartBuilder.create().uv(264, 11).mirrored().cuboid(-14.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

        ModelPartData left_pincerC2 = left_claw2.addChild("left_pincerC2", ModelPartBuilder.create().uv(263, 21).mirrored().cuboid(-1.0F, -2.0F, -15.05F, 2.0F, 4.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

        ModelPartData left_pincerD2 = left_claw2.addChild("left_pincerD2", ModelPartBuilder.create().uv(264, 43).mirrored().cuboid(-1.0F, -2.0F, -0.05F, 2.0F, 4.0F, 14.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 3.0F));
        return TexturedModelData.of(modelData, 512, 512);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(ContrivancePolloOneEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(ContrivancePolloOneAnimations.CONTRIVANCEPOLLOONE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ContrivancePolloOneAnimations.CONTRIVANCEPOLLOONE_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ContrivancePolloOneAnimations.CONTRIVANCEPOLLOONE_IDLE, ageInTicks, 1f);
    }


    @Override
    public ModelPart getPart() {
        return root;
    }
}