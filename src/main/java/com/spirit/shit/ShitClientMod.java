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
import com.spirit.tdbtd.global.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.global.entity.client.figures.*;
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
import static com.spirit.tdbtd.global.block.TDBTDBlocks.*;
import static com.spirit.tdbtd.global.entity.TDBTDEntities.*;
import static com.spirit.tdbtd.global.entity.TDBTDEntities.KREDA;


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
        EntityRendererRegistry.register(TENEBROUS_NIBBLER, TenebrousNibblerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.TENEBROUS_NIBBLER, TenebrousNibblerModel::getTexturedModelData);
        EntityRendererRegistry.register(APERTURENTEETH, AperturenteethRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.APERTURENTEETH, AperturenteethModel::getTexturedModelData);
        EntityRendererRegistry.register(CODELAING, CodelaingRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.CODELAING, CodelaingModel::getTexturedModelData);
        EntityRendererRegistry.register(PERICARPIUM, PericarpiumRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.PERICARPIUM, PericarpiumModel::getTexturedModelData);
        EntityRendererRegistry.register(SCUTLEON, ScutleonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.SCUTLEON, ScutleonModel::getTexturedModelData);
        EntityRendererRegistry.register(NIDIVER, NidiverRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.NIDIVER, NidiverModel::getTexturedModelData);
        EntityRendererRegistry.register(CURATOR, CuratorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.CURATOR, CuratorModel::getTexturedModelData);
        EntityRendererRegistry.register(MIJAPENDRA, MijapendraRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.MIJAPENDRA, MijapendraModel::getTexturedModelData);
        EntityRendererRegistry.register(CONTRIVANCEPOLLOONE, ContrivancePolloOneRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.CONTRIVANCEPOLLOONE, ContrivancePolloOneModel::getTexturedModelData);
        EntityRendererRegistry.register(CONTRIVANCEPOLLA, ContrivancePollaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.CONTRIVANCEPOLLA, ContrivancePollaModel::getTexturedModelData);
        EntityRendererRegistry.register(ABYSSOFIN, AbyssofinRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.ABYSSOFIN, AbyssofinModel::getTexturedModelData);
        EntityRendererRegistry.register(STURGO, SturgoRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.STURGO, SturgoModel::getTexturedModelData);
        EntityRendererRegistry.register(ENGUIA, EnguiaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.ENGUIA, EnguiaModel::getTexturedModelData);
        EntityRendererRegistry.register(MALDININKAS, MaldininkasRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.MALDININKAS, MaldininkasModel::getTexturedModelData);
        EntityRendererRegistry.register(DEVASTADOR_HOUND, DevastadorHoundRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.DEVASTADOR_HOUND, DevastadorHoundModel::getTexturedModelData);
        EntityRendererRegistry.register(DEVASTADOR_CUR, DevastadorCurRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.DEVASTADOR_CUR, DevastadorCurModel::getTexturedModelData);
        EntityRendererRegistry.register(DEVASTADOR_PUP, DevastadorPupRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.DEVASTADOR_PUP, DevastadorPupModel::getTexturedModelData);
        EntityRendererRegistry.register(KREDA, KredaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TDBTDModelLayers.KREDA, KredaModel::getTexturedModelData);

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
        EntityRendererRegistry.register(TrashCanProjectileEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BulletProjectileEntityType, BulletEntityRenderer::new);
    }

    private void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(PLAYER_ENTITY_PARTICLE, PlayerEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ZOMBIE_ENTITY_PARTICLE, ZombieEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SKELETON_ENTITY_PARTICLE, SkeletonEntityParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(CREEPER_ENTITY_PARTICLE, CreeperEntityParticle.Factory::new);
    }


    private void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                CRITERIC_CHARRED_DOOR,
                CRITERIC_CHARRED_TRAPDOOR,
                CRITERIC_CHARRED_LEAVES,
                CRITERIC_CHARRED_FLOWER_LEAVES,
                CRITERIC_CHARRED_SAPLING,
                CRITERIC_CHARRED_ROOTS,
                CRITERIC_VINES_BODY,
                CRITERIC_VINES_HEAD,
                SCULK_TEETH,
                SCULK_RIBS,
                SCULK_TENVINES,
                SCULK_TENVINES_PLANT,
                SCULK_FERN,
                LARGE_SCULK_FERN,
                SCULK_LOTUS,
                SCULK_FOUNTAIN_SHROOM,
                SCULK_SHROOM,
                SCULK_BUD,
                SCULK_GROWTH,
                SCULK_TAIL,
                SCULK_SPIKE,
                SCULK_WEB,
                SCULK_BONESHAFT,
                SCULK_THORNS,
                SCULK_EMITTER,
                SCULK_SHAKER,
                SCULK_MAW,
                SCULK_TENDRIL,
                SCULK_WEED,
                UNLIT_LANTERN,
                INFURTRINATED_CHAIN,
                INFURTRINATED_BONED_BARS,
                INFURTRINATED_BONED_DOOR,
                INFURTRINATED_BONED_TRAPDOOR,
                SMALL_ECHOING_AMETHYST_BUD,
                MEDIUM_ECHOING_AMETHYST_BUD,
                LARGE_ECHOING_AMETHYST_BUD,
                ECHOING_AMETHYST_CLUSTER,
                ALPHA_PLUSH,
                CATLOVE_PLUSH,
                CHEFINSANITY_PLUSH,
                COMPUTER_PLUSH,
                ERIS_PLUSH,
                JARGEDES_PLUSH,
                JBIRD_PLUSH,
                KINGZHARA_PLUSH,
                MCFELLA_PLUSH,
                MILKYFUR_PLUSH,
                SIERRA_PLUSH,
                SLAZER_PLUSH,
                SPIRIT_PLUSH

        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                INFURTRINATED_BONED_CAGE
        );

    }

    public static void registerShitpostClientMod() {
        Main.SHITLOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/shit/ShitClientMod");
    }
}