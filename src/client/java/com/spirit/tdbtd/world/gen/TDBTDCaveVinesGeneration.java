package com.spirit.tdbtd.world.gen;

import com.spirit.tdbtd.world.TDBTDPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class TDBTDCaveVinesGeneration {
 public static void generateVines() {
  BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
          GenerationStep.Feature.UNDERGROUND_DECORATION, TDBTDPlacedFeatures.CRITERIC_VINES_PLACED_KEY);
 }

 public static void generateTenvines() {
  BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
          GenerationStep.Feature.UNDERGROUND_DECORATION, TDBTDPlacedFeatures.SCULK_TENVINES_PLACED_KEY);
 }
}