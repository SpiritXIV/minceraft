package com.spirit.tdbtd.global.world.gen;

import com.spirit.tdbtd.global.world.TDBTDPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class TDBTDFossilGeneration {
    public static void generateFossil() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.UNDERGROUND_DECORATION, TDBTDPlacedFeatures.INFURTRINATED_BONNED_FOSSIL_PLACED_KEY);
    }
}
