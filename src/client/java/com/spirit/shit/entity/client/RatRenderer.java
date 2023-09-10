package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.RatEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RatRenderer extends GeoEntityRenderer<RatEntity> {
    public static final Identifier TEXTURE = new Identifier(ShitMod.MOD_ID, "textures/entity/capybara.png");

    public RatRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RatModel());
    }

    @Override
    public Identifier getTextureLocation(RatEntity instance) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/rat.png");
    }

    @Override
    public void render(RatEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
