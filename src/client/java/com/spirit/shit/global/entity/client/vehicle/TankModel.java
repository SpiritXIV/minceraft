package com.spirit.shit.global.entity.client.vehicle;

import com.spirit.shit.global.entity.custom.SlimShadyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class TankModel<T extends SlimShadyEntity> extends SinglePartEntityModel<T> {
    private final ModelPart body;

    public TankModel(ModelPart root) {
        this.body = root.getChild("body");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(30.0F, 7.0F, -62.0F));

        ModelPartData mainframe = body.addChild("mainframe", ModelPartBuilder.create().uv(-40, -40).cuboid(-60.0F, -70.0F, -41.0F, 20.0F, 8.0F, 42.0F, new Dilation(0.0F))
                .uv(-6, -6).cuboid(-40.0F, -84.0F, -41.0F, 80.0F, 17.0F, 8.0F, new Dilation(0.0F))
                .uv(-44, -44).cuboid(-60.0F, -70.0F, -87.0F, 120.0F, 8.0F, 46.0F, new Dilation(0.0F))
                .uv(-97, -97).cuboid(-60.0F, -70.0F, 44.0F, 120.0F, 8.0F, 99.0F, new Dilation(0.0F))
                .uv(-41, -41).mirrored().cuboid(-60.0F, -70.0F, 1.0F, 25.0F, 8.0F, 43.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-41, -41).cuboid(35.0F, -70.0F, 1.0F, 25.0F, 8.0F, 43.0F, new Dilation(0.0F))
                .uv(-28, -28).cuboid(-17.0F, -71.0F, -98.0F, 30.0F, 4.0F, 30.0F, new Dilation(0.0F))
                .uv(-40, -40).cuboid(-60.0F, -62.0F, -41.0F, 20.0F, 13.0F, 42.0F, new Dilation(0.0F))
                .uv(-40, -40).cuboid(40.0F, -62.0F, -41.0F, 20.0F, 13.0F, 42.0F, new Dilation(0.0F))
                .uv(0, 0).mirrored().cuboid(-40.0F, -88.0F, 1.0F, 21.0F, 26.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).cuboid(19.0F, -88.0F, 1.0F, 21.0F, 26.0F, 2.0F, new Dilation(0.0F))
                .uv(-2, -2).cuboid(-40.0F, -65.0F, -41.0F, 80.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(-39, -39).cuboid(28.0F, -75.0F, 3.0F, 6.0F, 17.0F, 41.0F, new Dilation(0.0F))
                .uv(-32, -32).mirrored().cuboid(-40.0F, -75.0F, -33.0F, 12.0F, 17.0F, 34.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-32, -32).cuboid(28.0F, -75.0F, -33.0F, 12.0F, 17.0F, 34.0F, new Dilation(0.0F))
                .uv(-40, -40).cuboid(-40.0F, -59.0F, -41.0F, 80.0F, 10.0F, 42.0F, new Dilation(0.0F))
                .uv(-46, -46).mirrored().cuboid(-60.0F, -62.0F, 1.0F, 16.0F, 13.0F, 48.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-46, -46).cuboid(44.0F, -62.0F, 1.0F, 16.0F, 13.0F, 48.0F, new Dilation(0.0F))
                .uv(-46, -46).cuboid(-44.0F, -62.0F, 1.0F, 88.0F, 13.0F, 48.0F, new Dilation(0.0F))
                .uv(-100, -100).cuboid(-60.0F, -62.0F, 49.0F, 120.0F, 13.0F, 102.0F, new Dilation(0.0F))
                .uv(-95, -95).cuboid(-60.0F, -62.0F, -138.0F, 120.0F, 13.0F, 97.0F, new Dilation(0.0F))
                .uv(-262, -262).cuboid(-26.0F, -31.0F, -120.0F, 52.0F, 20.0F, 264.0F, new Dilation(0.0F))
                .uv(-262, -262).cuboid(-60.0F, -49.0F, -120.0F, 120.0F, 18.0F, 264.0F, new Dilation(0.0F))
                .uv(-39, -39).mirrored().cuboid(-34.0F, -75.0F, 3.0F, 6.0F, 17.0F, 41.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-40, -40).cuboid(40.0F, -70.0F, -41.0F, 20.0F, 8.0F, 42.0F, new Dilation(0.0F)), ModelTransform.pivot(-30.0F, 8.0F, 62.0F));

        ModelPartData cube_r1 = mainframe.addChild("cube_r1", ModelPartBuilder.create().uv(-40, -40).cuboid(-90.0F, 11.0F, -101.0F, 120.0F, 8.0F, 42.0F, new Dilation(0.0F))
                .uv(-12, -12).cuboid(-90.0F, 4.0F, -77.0F, 120.0F, 7.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(30.0F, -8.0F, -62.0F, -0.6981F, 0.0F, 0.0F));

        ModelPartData cube_r2 = mainframe.addChild("cube_r2", ModelPartBuilder.create().uv(-58, -58).cuboid(-90.0F, 56.0F, 19.0F, 120.0F, 8.0F, 60.0F, new Dilation(0.0F)), ModelTransform.of(30.0F, -8.0F, -62.0F, -3.0543F, 0.0F, 0.0F));

        ModelPartData stearing = mainframe.addChild("stearing", ModelPartBuilder.create().uv(0, 0).cuboid(5.0F, -15.0F, -16.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -17.0F, -16.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(10.0F, -17.0F, -14.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).mirrored().cuboid(0.0F, -17.0F, -14.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-6.0F, -53.0F, -16.0F));

        ModelPartData chair = mainframe.addChild("chair", ModelPartBuilder.create().uv(-10, -10).cuboid(-17.0F, -126.0F, -11.0F, 24.0F, 2.0F, 12.0F, new Dilation(0.0F))
                .uv(-1, -1).cuboid(-17.0F, -138.0F, -2.0F, 24.0F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 65.0F, -16.0F));

        ModelPartData chair4 = mainframe.addChild("chair4", ModelPartBuilder.create().uv(-10, -10).mirrored().cuboid(-7.0F, -126.0F, -11.0F, 32.0F, 2.0F, 12.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-1, -1).mirrored().cuboid(-7.0F, -138.0F, -2.0F, 32.0F, 12.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(27.0F, 62.0F, 30.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData chair3 = mainframe.addChild("chair3", ModelPartBuilder.create().uv(-10, -10).cuboid(-25.0F, -126.0F, -11.0F, 32.0F, 2.0F, 12.0F, new Dilation(0.0F))
                .uv(-1, -1).cuboid(-25.0F, -138.0F, -2.0F, 32.0F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-27.0F, 62.0F, 30.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(-28, -28).cuboid(10.0F, -1.0F, 1.0F, 30.0F, 4.0F, 30.0F, new Dilation(0.0F))
                .uv(-6, -6).mirrored().cuboid(-45.0F, 1.0F, 42.0F, 8.0F, 4.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).cuboid(40.0F, -49.0F, 45.0F, 2.0F, 50.0F, 2.0F, new Dilation(0.0F))
                .uv(-6, -6).cuboid(37.0F, 1.0F, 42.0F, 8.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(-38, -38).cuboid(-37.0F, -1.0F, -8.0F, 40.0F, 4.0F, 40.0F, new Dilation(0.0F))
                .uv(-58, -58).cuboid(-50.0F, 3.0F, -3.0F, 12.0F, 26.0F, 60.0F, new Dilation(0.0F))
                .uv(-58, -58).cuboid(38.0F, 3.0F, -3.0F, 12.0F, 26.0F, 60.0F, new Dilation(0.0F))
                .uv(-15, -15).cuboid(-50.0F, 3.0F, 40.0F, 100.0F, 26.0F, 17.0F, new Dilation(0.0F))
                .uv(-10, -10).mirrored().cuboid(-21.0F, 3.0F, -76.0F, 44.0F, 6.0F, 12.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-18, -18).cuboid(-46.0F, 3.0F, -65.0F, 94.0F, 26.0F, 20.0F, new Dilation(0.0F))
                .uv(0, 0).mirrored().cuboid(-42.0F, -49.0F, 45.0F, 2.0F, 50.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-40, -40).cuboid(-43.0F, 3.0F, -45.0F, 86.0F, 8.0F, 42.0F, new Dilation(0.0F))
                .uv(-41, -41).cuboid(-38.0F, 3.0F, -3.0F, 80.0F, 6.0F, 43.0F, new Dilation(0.0F)), ModelTransform.pivot(-30.0F, -89.0F, 66.0F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(-72, -72).mirrored().cuboid(-86.0F, -86.0F, -7.0F, 12.0F, 24.0F, 74.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(30.0F, 89.0F, -66.0F, 0.0F, 0.0873F, 0.0F));

        ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(-72, -72).cuboid(14.0F, -86.0F, -2.0F, 12.0F, 24.0F, 74.0F, new Dilation(0.0F)), ModelTransform.of(30.0F, 89.0F, -66.0F, 0.0F, -0.0873F, 0.0F));

        ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(-14, -14).cuboid(-23.9F, -59.0F, -63.0F, 40.0F, 19.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-30.0F, 89.0F, -66.0F, -0.7445F, 0.2776F, -0.0137F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(-16.1F, -59.0F, -63.0F, 40.0F, 19.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(30.0F, 89.0F, -66.0F, -0.7445F, -0.2776F, 0.0137F));

        ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(-14, -14).cuboid(9.1F, -57.0F, -65.0F, 42.0F, 19.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-30.0F, 89.0F, -66.0F, -0.7445F, 0.0F, 0.0F));

        ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(-10, -10).cuboid(42.0F, -86.0F, -23.0F, 40.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-30.0F, 89.0F, -66.0F, 0.0F, -0.2776F, 0.0F));

        ModelPartData cube_r9 = head.addChild("cube_r9", ModelPartBuilder.create().uv(-10, -10).mirrored().cuboid(-82.0F, -86.0F, -23.0F, 40.0F, 6.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(30.0F, 89.0F, -66.0F, 0.0F, 0.2776F, 0.0F));

        ModelPartData cube_r10 = head.addChild("cube_r10", ModelPartBuilder.create().uv(-29, -29).cuboid(-80.0F, 20.0F, 118.0F, 100.0F, 22.0F, 31.0F, new Dilation(0.0F)), ModelTransform.of(30.0F, 89.0F, -66.0F, 0.7418F, 0.0F, 0.0F));

        ModelPartData thirtycalone = head.addChild("30calone", ModelPartBuilder.create().uv(-34, -34).cuboid(-2.0F, -17.0F, -67.0F, 4.0F, 4.0F, 36.0F, new Dilation(0.0F))
                .uv(-13, -13).cuboid(-7.0F, -2.0F, -8.0F, 15.0F, 5.0F, 15.0F, new Dilation(0.0F))
                .uv(-8, -8).cuboid(-5.0F, -12.0F, -5.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F))
                .uv(-6, -6).cuboid(-4.0F, -19.0F, -4.0F, 8.0F, 22.0F, 8.0F, new Dilation(0.0F))
                .uv(-8, -8).cuboid(-1.0F, -19.0F, -42.0F, 2.0F, 2.0F, 10.0F, new Dilation(0.0F))
                .uv(-26, -26).cuboid(-3.0F, -18.0F, -31.0F, 6.0F, 6.0F, 28.0F, new Dilation(0.0F))
                .uv(-8, -8).cuboid(-3.0F, -16.0F, 4.0F, 6.0F, 4.0F, 10.0F, new Dilation(0.0F))
                .uv(-6, -6).cuboid(-2.0F, -12.0F, -29.0F, 4.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-17.0F, -4.0F, 12.0F));

        ModelPartData thirtycaltwo = head.addChild("30caltwo", ModelPartBuilder.create().uv(-12, -12).cuboid(-1.0F, -18.0F, -32.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F))
                .uv(-13, -13).cuboid(-7.0F, -3.0F, -8.0F, 15.0F, 5.0F, 15.0F, new Dilation(0.0F))
                .uv(-8, -8).cuboid(-5.0F, -9.0F, -5.0F, 10.0F, 11.0F, 10.0F, new Dilation(0.0F))
                .uv(-6, -6).cuboid(-4.0F, -19.0F, -4.0F, 8.0F, 21.0F, 8.0F, new Dilation(0.0F))
                .uv(-2, -2).cuboid(-1.0F, -19.0F, -32.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(-12, -12).cuboid(-2.0F, -18.0F, -18.0F, 4.0F, 4.0F, 14.0F, new Dilation(0.0F))
                .uv(-8, -8).cuboid(-3.0F, -17.0F, 4.0F, 6.0F, 4.0F, 10.0F, new Dilation(0.0F))
                .uv(-4, -4).cuboid(-2.0F, -14.0F, -18.0F, 4.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(24.0F, -3.0F, 17.0F));

        ModelPartData barrel = head.addChild("barrel", ModelPartBuilder.create().uv(-102, -102).cuboid(-6.0F, -6.0F, -100.0F, 12.0F, 12.0F, 104.0F, new Dilation(0.0F))
                .uv(-102, -102).cuboid(-5.0F, -5.0F, -203.0F, 10.0F, 10.0F, 104.0F, new Dilation(0.0F))
                .uv(-16, -16).cuboid(-2.0F, -9.0F, -201.0F, 4.0F, 4.0F, 18.0F, new Dilation(0.0F))
                .uv(-24, -24).cuboid(-8.0F, -7.0F, -74.0F, 14.0F, 14.0F, 26.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 13.0F, -80.0F));

        ModelPartData treads = body.addChild("treads", ModelPartBuilder.create().uv(-232, -232).cuboid(-76.0F, 10.0F, -158.0F, 25.0F, 3.0F, 234.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.0F, 1.0F, 101.0F));

        ModelPartData cube_r11 = treads.addChild("cube_r11", ModelPartBuilder.create().uv(-18, -18).cuboid(-77.0F, 187.0F, 9.0F, 25.0F, 3.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -20.0F, -78.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r12 = treads.addChild("cube_r12", ModelPartBuilder.create().uv(-18, -18).cuboid(-77.0F, 187.0F, -32.0F, 25.0F, 3.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -20.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r13 = treads.addChild("cube_r13", ModelPartBuilder.create().uv(-53, -53).cuboid(-77.0F, 136.0F, 74.0F, 25.0F, 3.0F, 55.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -20.0F, -78.0F, 0.8727F, 0.0F, 0.0F));

        ModelPartData cube_r14 = treads.addChild("cube_r14", ModelPartBuilder.create().uv(-53, -53).cuboid(-77.0F, 146.0F, -119.0F, 25.0F, 3.0F, 55.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -20.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

        ModelPartData tire = treads.addChild("tire", ModelPartBuilder.create().uv(-14, -14).cuboid(-8.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-65.0F, -9.0F, 58.0F));

        ModelPartData cube_r15 = tire.addChild("cube_r15", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-73.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r16 = tire.addChild("cube_r16", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r17 = tire.addChild("cube_r17", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r18 = tire.addChild("cube_r18", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r19 = tire.addChild("cube_r19", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire2 = treads.addChild("tire2", ModelPartBuilder.create().uv(-14, -14).cuboid(-8.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-65.0F, -9.0F, 10.0F));

        ModelPartData cube_r20 = tire2.addChild("cube_r20", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-73.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r21 = tire2.addChild("cube_r21", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r22 = tire2.addChild("cube_r22", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r23 = tire2.addChild("cube_r23", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r24 = tire2.addChild("cube_r24", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire3 = treads.addChild("tire3", ModelPartBuilder.create().uv(-14, -14).cuboid(-8.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-65.0F, -9.0F, -38.0F));

        ModelPartData cube_r25 = tire3.addChild("cube_r25", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-73.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r26 = tire3.addChild("cube_r26", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r27 = tire3.addChild("cube_r27", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r28 = tire3.addChild("cube_r28", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r29 = tire3.addChild("cube_r29", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire4 = treads.addChild("tire4", ModelPartBuilder.create().uv(-14, -14).cuboid(-8.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-65.0F, -9.0F, -86.0F));

        ModelPartData cube_r30 = tire4.addChild("cube_r30", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-73.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r31 = tire4.addChild("cube_r31", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r32 = tire4.addChild("cube_r32", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r33 = tire4.addChild("cube_r33", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r34 = tire4.addChild("cube_r34", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire5 = treads.addChild("tire5", ModelPartBuilder.create().uv(-14, -14).cuboid(-8.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-65.0F, -9.0F, -134.0F));

        ModelPartData cube_r35 = tire5.addChild("cube_r35", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-73.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r36 = tire5.addChild("cube_r36", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r37 = tire5.addChild("cube_r37", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r38 = tire5.addChild("cube_r38", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r39 = tire5.addChild("cube_r39", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire6 = treads.addChild("tire6", ModelPartBuilder.create().uv(-14, -14).cuboid(-8.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-8.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-65.0F, -38.0F, 90.0F));

        ModelPartData cube_r40 = tire6.addChild("cube_r40", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-73.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r41 = tire6.addChild("cube_r41", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r42 = tire6.addChild("cube_r42", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r43 = tire6.addChild("cube_r43", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r44 = tire6.addChild("cube_r44", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire7 = treads.addChild("tire7", ModelPartBuilder.create().uv(-14, -14).cuboid(-6.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-6.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-6.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-65.0F, -37.0F, -167.0F));

        ModelPartData cube_r45 = tire7.addChild("cube_r45", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(-14, -14).cuboid(-73.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(67.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r46 = tire7.addChild("cube_r46", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(67.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r47 = tire7.addChild("cube_r47", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(67.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r48 = tire7.addChild("cube_r48", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(67.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r49 = tire7.addChild("cube_r49", ModelPartBuilder.create().uv(-14, -14).cuboid(-73.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(67.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData treads2 = body.addChild("treads2", ModelPartBuilder.create().uv(-232, -232).mirrored().cuboid(51.0F, 10.0F, -158.0F, 25.0F, 3.0F, 234.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-51.0F, 1.0F, 101.0F));

        ModelPartData cube_r50 = treads2.addChild("cube_r50", ModelPartBuilder.create().uv(-18, -18).mirrored().cuboid(52.0F, 187.0F, 9.0F, 25.0F, 3.0F, 20.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, -20.0F, -78.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r51 = treads2.addChild("cube_r51", ModelPartBuilder.create().uv(-18, -18).mirrored().cuboid(52.0F, 187.0F, -32.0F, 25.0F, 3.0F, 20.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, -20.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r52 = treads2.addChild("cube_r52", ModelPartBuilder.create().uv(-53, -53).mirrored().cuboid(52.0F, 136.0F, 74.0F, 25.0F, 3.0F, 55.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, -20.0F, -78.0F, 0.8727F, 0.0F, 0.0F));

        ModelPartData cube_r53 = treads2.addChild("cube_r53", ModelPartBuilder.create().uv(-53, -53).mirrored().cuboid(52.0F, 146.0F, -119.0F, 25.0F, 3.0F, 55.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, -20.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

        ModelPartData tire8 = treads2.addChild("tire8", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(-13.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(65.0F, -9.0F, 58.0F));

        ModelPartData cube_r54 = tire8.addChild("cube_r54", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(52.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r55 = tire8.addChild("cube_r55", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r56 = tire8.addChild("cube_r56", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r57 = tire8.addChild("cube_r57", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r58 = tire8.addChild("cube_r58", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire9 = treads2.addChild("tire9", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(-13.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(65.0F, -9.0F, 10.0F));

        ModelPartData cube_r59 = tire9.addChild("cube_r59", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(52.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r60 = tire9.addChild("cube_r60", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r61 = tire9.addChild("cube_r61", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r62 = tire9.addChild("cube_r62", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r63 = tire9.addChild("cube_r63", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire10 = treads2.addChild("tire10", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(-13.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(65.0F, -9.0F, -38.0F));

        ModelPartData cube_r64 = tire10.addChild("cube_r64", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(52.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r65 = tire10.addChild("cube_r65", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r66 = tire10.addChild("cube_r66", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r67 = tire10.addChild("cube_r67", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r68 = tire10.addChild("cube_r68", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire11 = treads2.addChild("tire11", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(-13.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(65.0F, -9.0F, -86.0F));

        ModelPartData cube_r69 = tire11.addChild("cube_r69", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(52.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r70 = tire11.addChild("cube_r70", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r71 = tire11.addChild("cube_r71", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r72 = tire11.addChild("cube_r72", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r73 = tire11.addChild("cube_r73", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire12 = treads2.addChild("tire12", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(-13.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(65.0F, -9.0F, -134.0F));

        ModelPartData cube_r74 = tire12.addChild("cube_r74", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(52.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r75 = tire12.addChild("cube_r75", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r76 = tire12.addChild("cube_r76", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r77 = tire12.addChild("cube_r77", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r78 = tire12.addChild("cube_r78", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire13 = treads2.addChild("tire13", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(-13.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-13.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(65.0F, -38.0F, 90.0F));

        ModelPartData cube_r79 = tire13.addChild("cube_r79", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(52.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r80 = tire13.addChild("cube_r80", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r81 = tire13.addChild("cube_r81", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r82 = tire13.addChild("cube_r82", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r83 = tire13.addChild("cube_r83", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-65.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData tire14 = treads2.addChild("tire14", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(-15.0F, -20.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-15.0F, 14.0F, -8.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(-15.0F, -8.0F, -8.0F, 21.0F, 16.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(65.0F, -37.0F, -167.0F));

        ModelPartData cube_r84 = tire14.addChild("cube_r84", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 72.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
                .uv(-14, -14).mirrored().cuboid(52.0F, 38.0F, -19.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-67.0F, -11.0F, -58.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r85 = tire14.addChild("cube_r85", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 63.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-67.0F, -11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r86 = tire14.addChild("cube_r86", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -19.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-67.0F, -11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r87 = tire14.addChild("cube_r87", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, 13.0F, 41.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-67.0F, 11.0F, -58.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r88 = tire14.addChild("cube_r88", ModelPartBuilder.create().uv(-14, -14).mirrored().cuboid(52.0F, -69.0F, 25.0F, 21.0F, 6.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-67.0F, 11.0F, -58.0F, -0.7854F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 256, 256);
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