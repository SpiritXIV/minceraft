package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.SlimShadyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SlimShadyRenderer extends GeoEntityRenderer<SlimShadyEntity> {
    public static final Identifier TEXTURE = new Identifier(ShitMod.MOD_ID, "textures/entity/capybara.png");

    public SlimShadyRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SlimShadyModel());
    }

    @Override
    public Identifier getTextureLocation(SlimShadyEntity instance) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/slim_shady.png");
    }

    @Override
    public void render(SlimShadyEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
