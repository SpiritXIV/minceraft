package com.spirit.shit;

import com.spirit.shit.block.ShitBlocks;
import com.spirit.shit.entity.ShitEntities;
import com.spirit.shit.entity.client.*;
import com.spirit.shit.event.KeyInputHandler;
import com.spirit.shit.particle.ShitParticles;
import com.spirit.shit.particle.custom.*;
import com.spirit.shit.sound.ShitSounds;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class ShitClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ShitSounds.registerShitSounds();

        EntityRendererRegistry.register(ShitEntities.JBIRD, JbirdRenderer::new);
        EntityRendererRegistry.register(ShitEntities.RAT_BOMB, RatBombRenderer::new);
        EntityRendererRegistry.register(ShitEntities.RAT, RatRenderer::new);
        EntityRendererRegistry.register(ShitEntities.CAPYBARA, CapybaraRenderer::new);
        EntityRendererRegistry.register(ShitEntities.FREDDYFAZBEAR, FreddyFazBearRenderer::new);
        EntityRendererRegistry.register(ShitEntities.SLIM_SHADY, SlimShadyRenderer::new);
        EntityRendererRegistry.register(ShitEntities.YIPPEE, YippeeRenderer::new);

        EntityRendererRegistry.register(ShitMod.RedBrickProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.BlueBrickProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.TrashCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.OatProjectileEntityType, FlyingItemEntityRenderer::new);

        EntityRendererRegistry.register(ShitMod.BulletProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.RifleBulletProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShellProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.SlugProjectileEntityType, FlyingItemEntityRenderer::new);


        EntityRendererRegistry.register(ShitMod.BeerBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.BonkAtomicPunchProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.BottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.BudLightCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ChampagneBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ChugJugProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.CocaColaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.CokeZeroCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.CritaColaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.DrPepperCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.FantaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.FlaskProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.GlassJarProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.LagarBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.MilkCartonProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.MountainDewCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.MugProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.MugRootBeerCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.NukaColaBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.NukaColaDarkBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.NukaColaQuantumBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.PeepsPepsiCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.PepsiCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.RumBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeBlueBerryTartCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeBlushingRoseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeCanadaShyCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeCheekyBitoPudCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeCherryPopCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeColdBeetStewCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeElderFlowerCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeFactoryRustCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeFourCheeseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeFrenchVanillaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeFulmedamesCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeGamerEnergyCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeJellyBeanCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeJuicyMelonCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeLemonPartyCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeLightCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeLiquroLisiousCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeMayonnaiseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeMustardCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeOriginalCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizePineapplePizzaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeRawMeatCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeSardineSurpriseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.StrawBerryMilkCartonProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeTangyKetchupCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeTaroTeaseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeThirstBornCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeTiramisuCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.ShizeVeggieBrothCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.SpeedColaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.VodkaBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.WineBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShitMod.WineGlassProjectileEntityType, FlyingItemEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ShitParticles.SCHIZO_EYE_PARTICLE, SchizoEyeParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ShitParticles.PLAYER_ENTITY_PARTICLE, PlayerEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ShitParticles.ZOMBIE_ENTITY_PARTICLE, ZombieEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ShitParticles.SKELETON_ENTITY_PARTICLE, SkeletonEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ShitParticles.CREEPER_ENTITY_PARTICLE, CreeperEntityParticle.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.ALPHA_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.CATLOVE_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.CHEFINSANITY_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.JARGEDES_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.JBIRD_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.MCFELLA_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.MILKYFUR_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.SIERRA_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.SLAZER_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.SPIRIT_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.TALON_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ShitBlocks.ZARSH_PLUSH, RenderLayer.getCutout());

        KeyInputHandler.register();
    }

    public static void registerShitClient() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/ShitClientMod");
    }
}