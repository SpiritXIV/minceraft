package com.spirit.tdbtd.world.gen;

import com.spirit.tdbtd.world.TDBTDPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class TDBTDOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.UNDERGROUND_ORES, TDBTDPlacedFeatures.INFURTRINATED_ORE_PLACED_KEY);
    }
}