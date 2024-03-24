package com.spirit.shit.global.world.gen;

import com.spirit.shit.global.world.ShitPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ShitOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ShitPlacedFeatures.BAUXITE_ORE_PLACED_KEY);
    }
}
