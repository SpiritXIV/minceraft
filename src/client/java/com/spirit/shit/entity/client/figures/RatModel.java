package com.spirit.shit.entity.client.figures;

import com.spirit.shit.entity.custom.RatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class RatModel<T extends RatEntity> extends SinglePartEntityModel<T> {
private final ModelPart root;
public RatModel(ModelPart root) {
        this.root = root.getChild("root");
        }
public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -1.0F, -4.0F, 5.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 2.0F));

        ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(6, 16).cuboid(-1.0F, 2.0F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 1.0F, -3.0F));

        ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(6, 16).mirrored().cuboid(-1.0F, 2.0F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.5F, 1.0F, -3.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(12, 10).cuboid(-1.5F, 0.0F, -4.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, -4.0F));

        ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -1.0F, 0.0F));

        ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.5F, 0.0F, 0.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 21).cuboid(-0.5F, 2.0F, 0.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 2.0F));

        ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(5, 11).cuboid(0.0F, 0.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
        .uv(6, 14).cuboid(0.0F, 2.0F, -4.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -2.0F, 4.0F));

        ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(4, 14).cuboid(0.0F, 2.0F, -4.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -2.0F, 4.0F));

        ModelPartData left_leg_r1 = left_leg.addChild("left_leg_r1", ModelPartBuilder.create().uv(8, 11).cuboid(-4.5F, -2.0F, -4.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 2.0F, -4.0F, 0.0F, 3.1416F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
        }

@Override
public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        }

@Override
public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

        }


@Override
public ModelPart getPart() {
        return root;
        }
        }