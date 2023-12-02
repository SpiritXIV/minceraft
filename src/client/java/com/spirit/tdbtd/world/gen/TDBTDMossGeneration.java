package com.spirit.tdbtd.world.gen;

import com.spirit.tdbtd.world.TDBTDPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class TDBTDMossGeneration {
    public static void generateMoss() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.UNDERGROUND_DECORATION, TDBTDPlacedFeatures.CRITERIC_MOSS_PATCH_PLACED_KEY);
    }
}