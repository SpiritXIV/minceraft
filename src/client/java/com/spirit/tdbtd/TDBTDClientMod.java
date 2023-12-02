package com.spirit.tdbtd;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.client.figures.*;
import com.spirit.tdbtd.util.TDBTDModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

import static com.spirit.tdbtd.block.TDBTDBlocks.*;
import static com.spirit.tdbtd.entity.TDBTDEntities.*;


public class TDBTDClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerEntityRenderers();
        registerBlockRenderLayers();
        TDBTDModelPredicateProvider.registerModels();
    }
        private void registerBlockRenderLayers() {
            BlockRenderLayerMap.INSTANCE.putBlock(CRITERIC_CHARRED_DOOR, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(CRITERIC_CHARRED_TRAPDOOR, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(CRITERIC_CHARRED_LEAVES, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(CRITERIC_CHARRED_FLOWER_LEAVES, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(CRITERIC_CHARRED_SAPLING, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(CRITERIC_VINES_BODY, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(CRITERIC_VINES_HEAD, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_TEETH, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_RIBS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_TENVINES, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_TENVINES_PLANT, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_FERN, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LARGE_SCULK_FERN, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_LOTUS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_FOUNTAIN_SHROOM, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_SHROOM, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_BUD, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_GROWTH, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_TAIL, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_SPIKE, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_WEB, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_BONESHAFT, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_THORNS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_EMITTER, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_SHAKER, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(SCULK_MAW, RenderLayer.getCutout());


            BlockRenderLayerMap.INSTANCE.putBlock(UNLIT_LANTERN, RenderLayer.getCutout());


            BlockRenderLayerMap.INSTANCE.putBlock(INFURTRINATED_CHAIN, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(INFURTRINATED_BONED_CAGE, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(INFURTRINATED_BONED_BARS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(INFURTRINATED_BONED_DOOR, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(INFURTRINATED_BONED_TRAPDOOR, RenderLayer.getCutout());


            BlockRenderLayerMap.INSTANCE.putBlock(SMALL_ECHOING_AMETHYST_BUD, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MEDIUM_ECHOING_AMETHYST_BUD, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LARGE_ECHOING_AMETHYST_BUD, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ECHOING_AMETHYST_CLUSTER, RenderLayer.getCutout());

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
        }

    public static void registerTDBTDClientMod() {
        Main.SHITLOGGER.info("> --Connected || the-shit-of-crypt/src/main/java/com/spirit/tdbtd/TDBTDClientMod");
    }
}