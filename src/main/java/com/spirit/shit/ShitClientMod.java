package com.spirit.shit;

import com.spirit.Main;
import com.spirit.shit.global.entity.client.ShitModelLayers;
import com.spirit.shit.global.entity.client.figures.*;
import com.spirit.shit.data.event.KeyInputHandler;
import com.spirit.shit.global.particle.custom.CreeperEntityParticle;
import com.spirit.shit.global.particle.custom.PlayerEntityParticle;
import com.spirit.shit.global.particle.custom.SkeletonEntityParticle;
import com.spirit.shit.global.particle.custom.ZombieEntityParticle;
import com.spirit.shit.data.render.BulletEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

import static com.spirit.shit.global.block.ShitBlocks.*;
import static com.spirit.shit.global.entity.ShitEntities.*;
import static com.spirit.shit.global.particle.ShitParticles.*;
import static com.spirit.shit.ShitMod.*;


public class ShitClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerEntityRenderers();
        registerProjectiles();
        registerParticles();
        registerBlockRenderLayers();
        KeyInputHandler.register();
    }

    private void registerEntityRenderers() {
        EntityRendererRegistry.register(JBRID, JbirdRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.JBIRD, JbirdModel::getTexturedModelData);
        EntityRendererRegistry.register(RAT_BOMB, RatBombRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.RAT_BOMB, RatBombModel::getTexturedModelData);
        EntityRendererRegistry.register(RAT, RatRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.RAT, RatModel::getTexturedModelData);
        EntityRendererRegistry.register(CAPYBARA, CapybaraRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.CAPYBARA, CapybaraModel::getTexturedModelData);
        EntityRendererRegistry.register(SLIM_SHADY, SlimShadyRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.SLIM_SHADY, SlimShadyModel::getTexturedModelData);
        /*EntityRendererRegistry.register(YIPPEE, YippeeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.YIPPEE, YippeeModel::getTexturedModelData);*/
        EntityRendererRegistry.register(DART_MONKEY, DartMonkeyRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.DART_MONKEY, DartMonkeyModel::getTexturedModelData);
        /*EntityRendererRegistry.register(CESSNA, CapybaraRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.CESSNA, CapybaraModel::getTexturedModelData);
        EntityRendererRegistry.register(ABRAMS_TANK, TankRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ShitModelLayers.ABRAMS_TANK, TankModel::getTexturedModelData);*/

    }

    private void registerProjectiles() {
        EntityRendererRegistry.register(RedBrickProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BlueBrickProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TrashCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(OatProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BulletProjectileEntityType, BulletEntityRenderer::new);

        EntityRendererRegistry.register(BeerBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BonkAtomicPunchProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BudLightCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ChampagneBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ChugJugProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(CocaColaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(CokeZeroCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(CritaColaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(DrPepperCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(FantaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(FlaskProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(GlassJarProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(LagarBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MilkCartonProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MountainDewCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MugProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MugRootBeerCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(NukaColaBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(NukaColaDarkBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(NukaColaQuantumBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(PeepsPepsiCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(PepsiCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(RumBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeBlueBerryTartCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeBlushingRoseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeCanadaShyCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeCheekyBitoPudCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeCherryPopCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeColdBeetStewCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeElderFlowerCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeFactoryRustCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeFourCheeseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeFrenchVanillaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeFulmedamesCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeGamerEnergyCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeJellyBeanCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeJuicyMelonCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeLemonPartyCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeLightCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeLiquorLisiousCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeMayonnaiseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeMustardCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeOriginalCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizePineapplePizzaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeRawMeatCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeSardineSurpriseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(StrawBerryMilkCartonProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeTangyKetchupCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeTaroTeaseCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeThirstBornCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeTiramisuCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ShizeVeggieBrothCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(VodkaBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(WineBottleProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(WineGlassProjectileEntityType, FlyingItemEntityRenderer::new);

        EntityRendererRegistry.register(SpeedColaCanProjectileEntityType, FlyingItemEntityRenderer::new);

        /*EntityRendererRegistry.register(DeadShotDaiquiriCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(DoubleTapRootBeerCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(JuggernogCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MuleKickCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(PHDFlopperCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(QuickReviveCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(SpeedColaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(StaminUpCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TombStoneSodaCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(VultureAidCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(WhosWhoCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(WidowsWineCanProjectileEntityType, FlyingItemEntityRenderer::new); */
    }

    private void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(PLAYER_ENTITY_PARTICLE, PlayerEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ZOMBIE_ENTITY_PARTICLE, ZombieEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SKELETON_ENTITY_PARTICLE, SkeletonEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(CREEPER_ENTITY_PARTICLE, CreeperEntityParticle.Factory::new);
    }


    private void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ALPHA_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CATLOVE_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CHEFINSANITY_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(COMPUTER_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ERIS_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JARGEDES_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JBIRD_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(KINGZHARA_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MCFELLA_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MILKYFUR_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SIERRA_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SLAZER_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SPIRIT_PLUSH, RenderLayer.getCutout());
    }

    public static void registerShitpostClientMod() {
        Main.SHITLOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/shit/ShitClientMod");
    }
}