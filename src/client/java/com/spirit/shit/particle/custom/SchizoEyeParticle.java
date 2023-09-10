package com.spirit.shit.particle.custom;

import com.spirit.shit.ShitMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Model;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.GhastEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(value=EnvType.CLIENT)
public class SchizoEyeParticle extends SpriteBillboardParticle {
    private static final double MAX_SQUARED_COLLISION_CHECK_DISTANCE = MathHelper.square(100.0);;
    private final Model model;
    private final RenderLayer layer = RenderLayer.getEntityTranslucent(TEXTURE);
    public static final Identifier TEXTURE = new Identifier(ShitMod.MOD_ID, "textures/particle/schizo/giant_eye.png");
    private boolean field_21507;

    SchizoEyeParticle(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteSet, double xx, double yy, double zz) {
        super(clientWorld, x, y, z);
        this.model = new GhastEntityModel<GhastEntity>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.GHAST));
        this.setBoundingBoxSpacing(0.2f, 0.2f);
        this.gravityStrength = 1f;
        this.maxAge = 1;
        this.velocityMultiplier = 0.6F;
        this.x = xx;
        this.y = yy;
        this.z = zz;
        this.scale *= 2F;
        this.setSpriteForAge(spriteSet);
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
        fadeIn();
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)maxAge) * age + 1);
    }
    private void fadeIn() {
        this.alpha = (+(1/(float)maxAge) * age - 1);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }

    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        float f = ((float)this.age + tickDelta) / (float)this.maxAge;
        float g = 0.05f + 0.5f * MathHelper.sin(f * (float)Math.PI);
        MatrixStack matrixStack = new MatrixStack();

        matrixStack.scale(-50.0f, -50.0f, 50.0f);
        matrixStack.translate(0.0f, -1.101f, 3.0f);
        VertexConsumerProvider.Immediate immediate = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        VertexConsumer vertexConsumer2 = immediate.getBuffer(this.layer);
        this.model.render(matrixStack, vertexConsumer2, 0xF000F0, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, g);
        immediate.draw();
    }

    private void model(MatrixStack matrixStack, VertexConsumer vertexConsumer2, int i, int defaultUv, float v, float v1, float v2, float g) {
    }


    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {

        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        @Override
        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld, double x, double y, double z, double xx, double yy, double zz) {
            return new SchizoEyeParticle(clientWorld, x, y, z, this.sprites, xx, yy, zz);
        }
    }
}