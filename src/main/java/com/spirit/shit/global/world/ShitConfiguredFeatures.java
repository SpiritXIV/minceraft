package com.spirit.shit.global.world;

import com.spirit.Main;
import com.spirit.shit.global.block.ShitBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ShitConfiguredFeatures {
        public static final RegistryKey<ConfiguredFeature<?, ?>> BAUXITE_ORE_KEY = registerKey("bauxite_ore");


        public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
            RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
            RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

            List<OreFeatureConfig.Target> overworldBauxiteOres =
                    List.of(OreFeatureConfig.createTarget(stoneReplaceables, ShitBlocks.BAUXITE_ORE.getDefaultState()),
                            OreFeatureConfig.createTarget(deepslateReplaceables, ShitBlocks.DEEPSLATE_BAUXITE_ORE.getDefaultState()));

            register(context, BAUXITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBauxiteOres, 12));
        }

        public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
            return RegistryKey.of((RegistryKey<? extends Registry<ConfiguredFeature<?, ?>>>) ConfiguredFeature.REGISTRY_CODEC, new Identifier(Main.SHIT_ID, name));
        }

        private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                       RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
            context.register(key, new ConfiguredFeature<>(feature, configuration));
        }
}
