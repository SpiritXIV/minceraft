package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.JbirdEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class JbirdRenderer extends GeoEntityRenderer<JbirdEntity> {
    public static final Identifier TEXTURE = new Identifier(ShitMod.MOD_ID, "textures/entity/capybara.png");

    public JbirdRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new JbirdModel());
    }

    @Override
    public Identifier getTextureLocation(JbirdEntity instance) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/jbird.png");
    }

    @Override
    public void render(JbirdEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
