package com.spirit.tdbtd.global.world.gen;

import com.spirit.tdbtd.global.world.TDBTDPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class TDBTDDiskGeneration {
    public static void generateDisk() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.RAW_GENERATION, TDBTDPlacedFeatures.DIMENTED_GRAVEL_DISC_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.RAW_GENERATION, TDBTDPlacedFeatures.DIMENTED_GRASS_DISC_PLACED_KEY);


        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.RAW_GENERATION, TDBTDPlacedFeatures.INFURTRINATED_DEEPSLATE_DISC_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
                GenerationStep.Feature.RAW_GENERATION, TDBTDPlacedFeatures.INFURTRINATED_TUFF_DISC_PLACED_KEY);
    }
}