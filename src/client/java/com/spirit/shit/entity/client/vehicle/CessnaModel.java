package com.spirit.shit.entity.client.vehicle;

import com.spirit.shit.entity.custom.SlimShadyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CessnaModel<T extends SlimShadyEntity> extends SinglePartEntityModel<T> {
    private final ModelPart body;
    public CessnaModel(ModelPart root) {
        this.body = root.getChild("body");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(-46, -46).cuboid(-10.0F, -6.0F, -20.0F, 20.0F, 4.0F, 48.0F, new Dilation(0.0F))
                .uv(-10, -10).cuboid(-10.0F, -28.0F, 4.0F, 20.0F, 2.0F, 12.0F, new Dilation(0.0F))
                .uv(-22, -22).cuboid(-12.0F, -31.0F, -20.0F, 24.0F, 4.0F, 24.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 15.0F, 0.0F));

        ModelPartData wings = body.addChild("wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData front = wings.addChild("front", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -29.0F, -10.0F));

        ModelPartData leftbar_r1 = front.addChild("leftbar_r1", ModelPartBuilder.create().uv(0, 0).cuboid(8.0F, -27.0F, -5.0F, 2.0F, 36.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, 13.0F, -5.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData leftfront = front.addChild("leftfront", ModelPartBuilder.create().uv(-16, -16).cuboid(12.0F, -32.0F, -15.0F, 32.0F, 4.0F, 18.0F, new Dilation(0.0F))
                .uv(-4, -4).cuboid(44.0F, -31.0F, 3.0F, 26.0F, 3.0F, 6.0F, new Dilation(0.0F))
                .uv(-16, -16).cuboid(44.0F, -32.0F, -13.0F, 26.0F, 4.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 30.0F, 5.0F));

        ModelPartData fin2 = leftfront.addChild("fin2", ModelPartBuilder.create().uv(-6, -6).cuboid(-32.0F, 0.0F, -4.0F, 32.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(44.0F, -31.0F, 5.0F));

        ModelPartData rightfront = front.addChild("rightfront", ModelPartBuilder.create().uv(-16, -16).cuboid(-44.0F, -32.0F, -15.0F, 32.0F, 4.0F, 18.0F, new Dilation(0.0F))
                .uv(-4, -4).cuboid(-70.0F, -31.0F, 3.0F, 26.0F, 3.0F, 6.0F, new Dilation(0.0F))
                .uv(-16, -16).cuboid(-70.0F, -32.0F, -13.0F, 26.0F, 4.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 30.0F, 5.0F));

        ModelPartData rightbar_r1 = rightfront.addChild("rightbar_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -25.0F, -5.0F, 2.0F, 36.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -17.0F, -10.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData fin = rightfront.addChild("fin", ModelPartBuilder.create().uv(-6, -6).cuboid(0.0F, 0.0F, -4.0F, 32.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-44.0F, -31.0F, 5.0F));

        ModelPartData back = wings.addChild("back", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData leftback = back.addChild("leftback", ModelPartBuilder.create().uv(-8, -8).cuboid(22.0F, -18.0F, 73.0F, 16.0F, 4.0F, 10.0F, new Dilation(0.0F))
                .uv(-8, -8).cuboid(6.0F, -18.0F, 71.0F, 16.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData fin3 = leftback.addChild("fin3", ModelPartBuilder.create().uv(-2, -2).cuboid(0.0F, 0.0F, -1.0F, 16.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(-4, -4).cuboid(-16.0F, 0.0F, -3.0F, 16.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(22.0F, -17.0F, 82.0F));

        ModelPartData rightback = back.addChild("rightback", ModelPartBuilder.create().uv(-8, -8).cuboid(-22.0F, -18.0F, 71.0F, 16.0F, 4.0F, 10.0F, new Dilation(0.0F))
                .uv(-8, -8).cuboid(-38.0F, -18.0F, 73.0F, 16.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData fin4 = rightback.addChild("fin4", ModelPartBuilder.create().uv(-2, -2).cuboid(-16.0F, 0.0F, -1.0F, 16.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(-4, -4).cuboid(0.0F, 0.0F, -3.0F, 16.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-22.0F, -17.0F, 82.0F));

        ModelPartData tail2 = wings.addChild("tail2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData wing = tail2.addChild("wing", ModelPartBuilder.create().uv(-12, -12).cuboid(-2.0F, -36.0F, 66.0F, 4.0F, 18.0F, 14.0F, new Dilation(0.0F))
                .uv(-8, -8).cuboid(-1.0F, -50.0F, 70.0F, 2.0F, 14.0F, 10.0F, new Dilation(0.0F))
                .uv(-2, -2).cuboid(-1.0F, -50.0F, 80.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(-12, -12).cuboid(-1.0F, -24.0F, 52.0F, 2.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tailfin = tail2.addChild("tailfin", ModelPartBuilder.create().uv(-2, -2).cuboid(-1.0F, -12.0F, 0.0F, 2.0F, 30.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -36.0F, 80.0F));

        ModelPartData cockpit = body.addChild("cockpit", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftside = cockpit.addChild("leftside", ModelPartBuilder.create().uv(-4, -4).cuboid(8.0F, -28.0F, -20.0F, 2.0F, 22.0F, 6.0F, new Dilation(0.0F))
                .uv(-10, -10).cuboid(8.0F, -26.0F, 4.0F, 2.0F, 20.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftdoor = leftside.addChild("leftdoor", ModelPartBuilder.create().uv(-16, -16).cuboid(8.0F, -28.0F, -14.0F, 2.0F, 22.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightside = cockpit.addChild("rightside", ModelPartBuilder.create().uv(-10, -10).cuboid(-10.0F, -26.0F, 4.0F, 2.0F, 20.0F, 12.0F, new Dilation(0.0F))
                .uv(-4, -4).cuboid(-10.0F, -28.0F, -20.0F, 2.0F, 22.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightdoor = rightside.addChild("rightdoor", ModelPartBuilder.create().uv(-16, -16).cuboid(-10.0F, -28.0F, -14.0F, 2.0F, 22.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(-44, -44).cuboid(-8.0F, -18.0F, 16.0F, 16.0F, 12.0F, 46.0F, new Dilation(0.0F))
                .uv(-2, -2).cuboid(-8.0F, -26.0F, 16.0F, 16.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(-22, -22).cuboid(-6.0F, -18.0F, 62.0F, 12.0F, 6.0F, 24.0F, new Dilation(0.0F))
                .uv(-22, -22).cuboid(8.0F, -16.0F, 16.0F, 2.0F, 10.0F, 24.0F, new Dilation(0.0F))
                .uv(-22, -22).cuboid(-10.0F, -16.0F, 16.0F, 2.0F, 10.0F, 24.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tracks = body.addChild("tracks", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData tires = tracks.addChild("tires", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -16.0F, -30.0F));

        ModelPartData fronttire = tires.addChild("fronttire", ModelPartBuilder.create().uv(-4, -4).cuboid(-3.0F, 5.0F, -6.0F, 4.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData fronttirebar_r1 = fronttire.addChild("fronttirebar_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData tire = fronttire.addChild("tire", ModelPartBuilder.create().uv(-1, -1).cuboid(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 7.5F, -3.5F));

        ModelPartData lefttire = tires.addChild("lefttire", ModelPartBuilder.create().uv(-6, -6).cuboid(0.0F, 5.0F, -4.0F, 4.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 0.0F, 40.0F));

        ModelPartData lefttirebar_r1 = lefttire.addChild("lefttirebar_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, -1.5708F, 0.0F));

        ModelPartData tire2 = lefttire.addChild("tire2", ModelPartBuilder.create().uv(-1, -1).cuboid(-1.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 7.5F, -1.5F));

        ModelPartData righttire = tires.addChild("righttire", ModelPartBuilder.create().uv(-6, -6).cuboid(-5.0F, 5.0F, -4.0F, 4.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.0F, 0.0F, 40.0F));

        ModelPartData righttirebar_r1 = righttire.addChild("righttirebar_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -3.0F, -2.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 1.5708F, 0.0F));

        ModelPartData tire3 = righttire.addChild("tire3", ModelPartBuilder.create().uv(-1, -1).cuboid(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 7.5F, -1.5F));

        ModelPartData bar = tracks.addChild("bar", ModelPartBuilder.create().uv(-38, -38).cuboid(23.0F, -4.0F, -2.0F, 2.0F, 2.0F, 40.0F, new Dilation(0.0F))
                .uv(-38, -38).cuboid(-3.0F, -4.0F, -2.0F, 2.0F, 2.0F, 40.0F, new Dilation(0.0F)), ModelTransform.pivot(-11.0F, -13.0F, -15.0F));

        ModelPartData middlebarback_r1 = bar.addChild("middlebarback_r1", ModelPartBuilder.create().uv(-22, -22).cuboid(30.0F, -6.0F, -23.0F, 2.0F, 4.0F, 24.0F, new Dilation(0.0F))
                .uv(-22, -22).cuboid(2.0F, -6.0F, -23.0F, 2.0F, 4.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData chair = body.addChild("chair", ModelPartBuilder.create().uv(-10, -10).cuboid(-7.0F, -24.0F, -11.0F, 14.0F, 2.0F, 12.0F, new Dilation(0.0F))
                .uv(-1, -1).cuboid(-7.0F, -36.0F, -2.0F, 14.0F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData stearing = chair.addChild("stearing", ModelPartBuilder.create().uv(-3, -3).cuboid(-6.0F, -12.0F, -21.0F, 12.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.0F, 0.0F));

        ModelPartData axil = stearing.addChild("axil", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -12.5674F, -12.5576F));

        ModelPartData axil_r1 = axil.addChild("axil_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.2744F, -1.2764F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

        ModelPartData handel = stearing.addChild("handel", ModelPartBuilder.create(), ModelTransform.of(0.0F, -13.0F, -12.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData righthandel_r1 = handel.addChild("righthandel_r1", ModelPartBuilder.create().uv(-2, -2).cuboid(-4.0F, -3.0F, -23.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-4.0F, -3.0F, -19.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(-2, -2).cuboid(2.0F, -3.0F, -23.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 14.4326F, 13.4424F, -0.6981F, 0.0F, 0.0F));

        ModelPartData turbine = body.addChild("turbine", ModelPartBuilder.create().uv(-12, -12).cuboid(-8.0F, -16.0F, -34.0F, 16.0F, 14.0F, 14.0F, new Dilation(0.0F))
                .uv(-4, -4).cuboid(-8.0F, -27.0F, -26.0F, 16.0F, 11.0F, 6.0F, new Dilation(0.0F))
                .uv(-2, -2).cuboid(-5.0F, -14.0F, -38.0F, 10.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(-2, -2).cuboid(-2.5F, -12.0F, -42.0F, 5.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData propellers = turbine.addChild("propellers", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -9.0F, -1.0F, 4.0F, 7.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.0F, -16.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, -39.0F));

        ModelPartData propellertwobottom_r1 = propellers.addChild("propellertwobottom_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -9.0F, -1.0F, 4.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData propellertwotop_r1 = propellers.addChild("propellertwotop_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -15.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }


    @Override
    public ModelPart getPart() {
        return body;
    }
}