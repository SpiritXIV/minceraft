package com.spirit.tdbtd.global.world.gen;

import com.spirit.tdbtd.global.world.TDBTDPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class TDBTDReplaceGeneration {
    public static void generateReplace() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.UNDERGROUND_DECORATION, TDBTDPlacedFeatures.REPLACE_GRASS_BLOCK_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.UNDERGROUND_DECORATION, TDBTDPlacedFeatures.REPLACE_DIRT_PLACED_KEY);
    }
}