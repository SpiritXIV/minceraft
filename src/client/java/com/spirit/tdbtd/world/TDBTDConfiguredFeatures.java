package com.spirit.tdbtd.world;

import com.google.common.collect.ImmutableList;
import com.spirit.Main;
import com.spirit.tdbtd.block.TDBTDBlocks;
import net.minecraft.block.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.root.AboveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;

import java.util.List;
import java.util.Optional;

public class TDBTDConfiguredFeatures {
    private static final BeehiveTreeDecorator BEES_001 = new BeehiveTreeDecorator(0.01f);
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRITERIC_CHARRED_KEY = registerKey("criteric_charred");
    public static final RegistryKey<ConfiguredFeature<?, ?>> INFURTRINATED_ORE_KEY = registerKey("infurtrinated_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldInfurtrinatedeOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, TDBTDBlocks.INFURTRINATED_DEEPSLATE_ORE.getDefaultState()));

        register(context, CRITERIC_CHARRED_KEY, Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(TDBTDBlocks.CRITERIC_CHARRED_LOG),
                new UpwardsBranchingTrunkPlacer(4, 5, 9, UniformIntProvider.create(5, 9), 0.6f,
                        UniformIntProvider.create(1, 3), Registries.BLOCK.getOrCreateEntryList(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)),
                BlockStateProvider.of(TDBTDBlocks.CRITERIC_CHARRED_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), ConstantIntProvider.create(2), 70), Optional.of(
                new MangroveRootPlacer(UniformIntProvider.create(2, 2), BlockStateProvider.of(TDBTDBlocks.CRITERIC_CHARRED_WOOD), Optional.of(
                        new AboveRootPlacement(BlockStateProvider.of(Blocks.SCULK), 0.3f)),
                        new MangroveRootPlacement(Registries.BLOCK.getOrCreateEntryList(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), RegistryEntryList.of(Block::getRegistryEntry, TDBTDBlocks.DIMENTED_GRASS_BLOCK, TDBTDBlocks.DIMENTED_DIRT),
                                BlockStateProvider.of(TDBTDBlocks.DIMENTED_DIRT), 10, 12, 0.58f))),
                new TwoLayersFeatureSize(7, 1, 4)).decorators(List.of(
                        new LeavesVineTreeDecorator(1f), new AttachedToLeavesTreeDecorator(0.9f, 1, 0,
                                new RandomizedIntBlockStateProvider((BlockStateProvider)BlockStateProvider.of((BlockState)TDBTDBlocks.CRITERIC_CHARRED_FLOWER_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true)),
                                        PropaguleBlock.AGE, (IntProvider)UniformIntProvider.create(0, 4)), 1, List.of(Direction.DOWN)), BEES_001)).forceDirt().ignoreVines()
                .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(TDBTDBlocks.DIMENTED_GRASS_BLOCK)))).build());

        register(context, INFURTRINATED_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldInfurtrinatedeOres, 12));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Main.TDBTD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    /*

        //GEODE
        public static final RegistryEntry<ConfiguredFeature<GeodeFeatureConfig, ?>> DIMENTED_GEODE =
                ConfiguredFeatures.register("dimented_geode", Feature.GEODE,
                        new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                                BlockStateProvider.of(Blocks.AMETHYST_BLOCK),
                                BlockStateProvider.of(Blocks.BUDDING_AMETHYST),
                                BlockStateProvider.of(TDBTDBlocks.INFURTRINATED_CALCITE),
                                BlockStateProvider.of(TDBTDBlocks.INFURTRINATED_SMOOTH_BASALT),
                                List.of(Blocks.AMETHYST_CLUSTER.getDefaultState()),
                                BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                                new GeodeLayerThicknessConfig(1.7D, 1.9D, 2.5D, 3.5D),
                                new GeodeCrackConfig(0.25D, 1.5D, 1),
                                0.5D, 0.1D,
                                true, UniformIntProvider.create(3, 8),
                                UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                                -18, 18, 0.075D, 1));


        //GRASS WHEN BONEMEAL
        public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>> DIMENTED_GRASS_BONEMEAL =
                ConfiguredFeatures.register("dimented_grass_bonemeal", Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SCULK_VEIN.getDefaultState())));

       //PILES
        public static final RegistryEntry<ConfiguredFeature<BlockPileFeatureConfig, ?>> PILE_SCULK_RIBS =
                ConfiguredFeatures.register("pile_sculk_ribs", Feature.BLOCK_PILE,
                        new BlockPileFeatureConfig(BlockStateProvider.of(TDBTDBlocks.SCULK_RIBS)));

        public static final RegistryEntry<ConfiguredFeature<BlockPileFeatureConfig, ?>> PILE_SCULK_TEETH =
                ConfiguredFeatures.register("pile_sculk_teeth", Feature.BLOCK_PILE,
                        new BlockPileFeatureConfig(BlockStateProvider.of(TDBTDBlocks.SCULK_TEETH)));

        public static final RegistryEntry<ConfiguredFeature<BlockPileFeatureConfig, ?>> PILE_SCULK_FERN =
                ConfiguredFeatures.register("pile_sculk_fern", Feature.BLOCK_PILE,
                        new BlockPileFeatureConfig(BlockStateProvider.of(TDBTDBlocks.SCULK_FERN)));

        //DISKS
        public static final RegistryEntry<ConfiguredFeature<DiskFeatureConfig, ?>> DISK_TD =
                ConfiguredFeatures.register("disk_td", Feature.DISK,
                        new DiskFeatureConfig(new PredicatedStateProvider(BlockStateProvider.of(TDBTDBlocks.INFURTRINATED_TUFF),
                                List.of(new PredicatedStateProvider.Rule(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.DEEPSLATE),
                                        BlockStateProvider.of(TDBTDBlocks.INFURTRINATED_TUFF)))), BlockPredicate.matchingBlocks(List.of(Blocks.DEEPSLATE, Blocks.DEEPSLATE)),
                                UniformIntProvider.create(1, 5), 2));

        public static final RegistryEntry<ConfiguredFeature<DiskFeatureConfig, ?>> DISK_CD =
                ConfiguredFeatures.register("disk_cd", Feature.DISK,
                        new DiskFeatureConfig(new PredicatedStateProvider(BlockStateProvider.of(TDBTDBlocks.INFURTRINATED_DEEPSLATE),
                                List.of(new PredicatedStateProvider.Rule(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.DEEPSLATE),
                                        BlockStateProvider.of(TDBTDBlocks.INFURTRINATED_DEEPSLATE)))), BlockPredicate.matchingBlocks(List.of(Blocks.DEEPSLATE, Blocks.DEEPSLATE)),
                                UniformIntProvider.create(3, 6), 2));
        public static final RegistryEntry<ConfiguredFeature<DiskFeatureConfig, ?>> DISK_GD =
                ConfiguredFeatures.register("disk_gd", Feature.DISK,
                        new DiskFeatureConfig(new PredicatedStateProvider(BlockStateProvider.of(TDBTDBlocks.DIMENTED_GRAVEL),
                                List.of(new PredicatedStateProvider.Rule(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.DEEPSLATE),
                                        BlockStateProvider.of(TDBTDBlocks.DIMENTED_GRAVEL)))), BlockPredicate.matchingBlocks(List.of(Blocks.DEEPSLATE, Blocks.DEEPSLATE)),
                                UniformIntProvider.create(1, 5), 2));

        public static final RegistryEntry<ConfiguredFeature<DiskFeatureConfig, ?>> DISK_TREE =
                ConfiguredFeatures.register("disk_tree", Feature.DISK,
                        new DiskFeatureConfig(new PredicatedStateProvider(BlockStateProvider.of(TDBTDBlocks.DIMENTED_DIRT),
                                List.of(new PredicatedStateProvider.Rule(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.DEEPSLATE),
                                        BlockStateProvider.of(TDBTDBlocks.DIMENTED_DIRT)))), BlockPredicate.matchingBlocks(List.of(Blocks.DEEPSLATE, Blocks.DEEPSLATE)),
                                UniformIntProvider.create(3, 6), 2));


        //TENVINES
        public static final RegistryEntry<ConfiguredFeature<BlockPileFeatureConfig, ?>> SCULK_TENVINES =
                ConfiguredFeatures.register("sculk_tenvines", Feature.BLOCK_PILE,
                        new BlockPileFeatureConfig(BlockStateProvider.of(TDBTDBlocks.SCULK_TENVINES_PLANT)));

       //CAVE VINES
       public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> SCULK_CAVE_VINES =
               ConfiguredFeatures.register("sculk_cave_vines", TDBTDFeature.SCULK_CAVE_VINES);


       //PATCH
       public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_LOTUS =
               ConfiguredFeatures.register("patch_lotus", Feature.RANDOM_PATCH,
                       new RandomPatchFeatureConfig(10, 7, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                               new SimpleBlockFeatureConfig(BlockStateProvider.of(TDBTDBlocks.SCULK_LOTUS)))));

    */
    //FINAL CONFIG MESSAGE
    public static void registerFeatures() {}
}
