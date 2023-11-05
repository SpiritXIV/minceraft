package com.spirit.shit.particle.custom;

import com.spirit.Main;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Model;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CreeperEntityParticle extends SpriteBillboardParticle {

    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/particle/schizo/creeper.png");
    private static final RenderLayer LAYER = RenderLayer.getEntityTranslucent(TEXTURE);
    private static final Model MODEL = new CreeperEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.CREEPER));

    public CreeperEntityParticle(ClientWorld clientWorld, double x, double y, double z) {
        super(clientWorld, x, y, z);
        this.gravityStrength = 0.0F;
        this.maxAge = 30;
        this.velocityX = 0.0;
        this.velocityY = 0.0;
        this.velocityZ = 0.0;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }

    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        float ageFraction = ((float) this.age + tickDelta) / (float) this.maxAge;
        float scale = 0.05F + 0.5F * MathHelper.sin(ageFraction * 3.1415927F);
        MatrixStack matrixStack = new MatrixStack();
        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        matrixStack.translate(0.0F, -1.101F, 1.5F);
        VertexConsumerProvider.Immediate immediate = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        VertexConsumer vertexConsumer2 = immediate.getBuffer(LAYER);
        MODEL.render(matrixStack, vertexConsumer2, 15728880, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, scale);
        immediate.draw();
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {

        public Factory(SpriteProvider ignoredSpriteSet) {
        }

        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new CreeperEntityParticle(clientWorld, x, y, z);
        }
    }
}
