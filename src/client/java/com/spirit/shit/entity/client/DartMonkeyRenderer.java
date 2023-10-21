package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.DartMonkeyEntity;
import com.spirit.shit.entity.custom.FreddyFazBearEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DartMonkeyRenderer extends GeoEntityRenderer<DartMonkeyEntity> {
    public static final Identifier TEXTURE = new Identifier(ShitMod.MOD_ID, "textures/entity/dart_monkey.png");

    public DartMonkeyRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new DartMonkeyModel());
    }

    @Override
    public Identifier getTextureLocation(DartMonkeyEntity instance) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/dart_monkey.png");
    }

    @Override
    public void render(DartMonkeyEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
