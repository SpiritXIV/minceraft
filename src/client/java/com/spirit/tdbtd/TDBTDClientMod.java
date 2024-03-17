package com.spirit.tdbtd;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.client.figures.*;
import com.spirit.tdbtd.util.TDBTDModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.FogShape;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import static com.spirit.tdbtd.block.TDBTDBlocks.*;
import static com.spirit.tdbtd.entity.TDBTDEntities.*;

@SuppressWarnings({"unsued"})

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class TDBTDClientMod implements ClientModInitializer {

    @Environment(EnvType.CLIENT)
    public static class FogData {
        public  final BackgroundRenderer.FogType fogType;
        public static float fogStart;
        public static float fogEnd;
        public FogShape fogShape;

        public FogData(BackgroundRenderer.FogType fogType) {
            this.fogShape = FogShape.SPHERE;
            this.fogType = fogType;
        }
    }

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            PlayerEntity playerEntity = client.player;

            if (playerEntity != null) {
                BlockPos playerPos = playerEntity.getBlockPos();
                ClientWorld world = client.world;

                if (world != null) {
                    Biome currentBiome = world.getBiome(playerPos).value();

                    boolean isInDeepDark = isPlayerInDeepDark(currentBiome, playerEntity);

                    float baseFogDensity = isInDeepDark ? 1.0F : 0.75F;
                    float distanceMultiplier = isInDeepDark ? 0.5F : 1.0F;

                    float fogDensity = baseFogDensity + (playerEntity.distanceTraveled % 100.0F) * distanceMultiplier;

                    FogData.fogStart = 10F;
                    FogData.fogEnd = 10F;

                    if (isInDeepDark) {
                        setRenderDistance(client, 8);
                    } else {
                        // Set the render distance back to the default value
                        setRenderDistance(client, client.options.getViewDistance().getValue());
                    }
                }
            } else {
                applyFog(client.player, BackgroundRenderer.FogType.FOG_SKY, 0.75F, false, 1);
                applyFog(client.player, BackgroundRenderer.FogType.FOG_TERRAIN, 1.0F, false, 1);
                FogData.fogStart = 0.25F;
                FogData.fogEnd = 0;
            }
        });

        registerEntityRenderers();
        registerBlockRenderLayers();
        TDBTDModelPredicateProvider.registerModels();


/*
        WorldRenderEvents.END.register((context) -> {
            if (context.world().getDimension().equals(DimensionTypes.OVERWORLD)) {
                if (!Iris.getIrisConfig().areShadersEnabled() || !Iris.getCurrentPackName().equals("neverend")) {
                    try {
                        Iris.getIrisConfig().setShaderPackName("neverend");
                        Iris.getIrisConfig().setShadersEnabled(true);
                        Iris.getIrisConfig().save();
                        Iris.reload();
                    } catch (Exception var3) {
                    }
                }
            } else if (Iris.getCurrentPackName().equals("neverend")) {
                try {
                    Iris.getIrisConfig().setShaderPackName("");
                    Iris.getIrisConfig().setShadersEnabled(false);
                    Iris.getIrisConfig().save();
                    Iris.reload();
                } catch (Exception var2) {
                }
            }

        });
*/
    }

    private boolean isPlayerInDeepDark(Biome biome, PlayerEntity playerEntity) {
        return playerEntity.getWorld().getBiome(playerEntity.getBlockPos()) == BiomeKeys.DEEP_DARK;
    }

    private void setRenderDistance(MinecraftClient client, int distance) {
    }

    private void applyFog(Entity playerEntity, BackgroundRenderer.FogType fogType, float v, boolean b, int i) {
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
                ECHOING_AMETHYST_CLUSTER);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                INFURTRINATED_BONED_CAGE);

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

    private static <T extends Entity> EntityType<T> registerEntityType(String name, SpawnGroup group, EntityType.EntityFactory<T> entityFactory, float width, float height) {
        Identifier entityId = new Identifier(Main.SHIT_ID, name);
        FabricEntityTypeBuilder<T> entityTypeBuilder = FabricEntityTypeBuilder.create(group, entityFactory)
                .dimensions(EntityDimensions.fixed(width, height))
                .trackRangeBlocks(4).trackedUpdateRate(10);
        return Registry.register(Registries.ENTITY_TYPE, entityId, entityTypeBuilder.build());
    }
}