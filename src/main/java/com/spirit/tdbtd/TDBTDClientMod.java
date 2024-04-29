package com.spirit.tdbtd;

import com.spirit.Main;
import com.spirit.tdbtd.data.util.TDBTDModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.FogShape;
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

    public static void registerTDBTDClientMod() {
        Main.TDBTDLOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/tdbtd/TDBTDClientMod");
    }

    private static <T extends Entity> EntityType<T> registerEntityType(String name, SpawnGroup group, EntityType.EntityFactory<T> entityFactory, float width, float height) {
        Identifier entityId = new Identifier(Main.TDBTD_ID, name);
        FabricEntityTypeBuilder<T> entityTypeBuilder = FabricEntityTypeBuilder.create(group, entityFactory)
                .dimensions(EntityDimensions.fixed(width, height))
                .trackRangeBlocks(4).trackedUpdateRate(10);
        return Registry.register(Registries.ENTITY_TYPE, entityId, entityTypeBuilder.build());
    }
}