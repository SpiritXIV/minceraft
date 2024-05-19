package com.spirit.ignite;

import com.spirit.Main;
import com.spirit.ignite.global.particle.custom.FlashBangParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

import static com.spirit.ignite.IgniteMod.GrenadeProjectileEntityType;
import static com.spirit.ignite.global.particle.IgniteParticles.FLASH_BANG_PARTICLE;


public class IgniteClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(FLASH_BANG_PARTICLE, FlashBangParticle.Factory::new);

        registerProjectiles();
    }

    private void registerProjectiles() {
        EntityRendererRegistry.register(GrenadeProjectileEntityType, FlyingItemEntityRenderer::new);
    }

    public static void registerIgniteClientMod() {
        Main.IGNITELOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/ignite/IgniteClientMod");
    }
}