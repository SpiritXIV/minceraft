package com.spirit.tdbtd.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.spirit.Main;
import com.spirit.tdbtd.block.TDBTDBlocks;
import com.spirit.tdbtd.block.custom.TDBTDCaveVinesBodyBlock;
import com.spirit.tdbtd.block.custom.TDBTDCaveVinesHeadBlock;
import net.minecraft.block.*;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.root.AboveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.PredicatedStateProvider;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;

public class TDBTDConfiguredFeatures {
    private static final BeehiveTreeDecorator BEES_001 = new BeehiveTreeDecorator(0.01f);
    public static final RegistryKey<ConfiguredFeature<?, ?>> INFURTRINATED_ORE_KEY = registerKey("infurtrinated_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRITERIC_CHARRED_KEY = registerKey("criteric_charred");
    public static final RegistryKey<ConfiguredFeature<?, ?>> INFURTRINATED_GEODE_KEY = registerKey("infurtrinated_geode_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> INFURTRINATED_BONNED_FOSSIL_KEY = registerKey("infurtrinated_bonned_fossil_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRITERIC_VINES_KEY = registerKey("criteric_vines_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRITERIC_MOSS_PATCH_KEY = registerKey("criteric_moss_patch_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRITERIC_MOSS_PATCH_CEILING_KEY = registerKey("criteric_moss_patch_ceiling_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRITERIC_MOSS_VEGETATION_KEY = registerKey("criteric_moss_vegetation_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIMENTED_GRAVEL_DISC_KEY = registerKey("dimented_gravel_disc_key");


    public static final RegistryKey<ConfiguredFeature<?, ?>> INFURTRINATED_DEEPSLATE_DISC_KEY = registerKey("infurtrinated_deepslate_disc_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> INFURTRINATED_TUFF_DISC_KEY = registerKey("infurtrinated_tuff_disc_key");

    public static <T extends IntProvider> Codec<T> createValidatingCodec(int min, int max, Codec<T> providerCodec) {
        return Codecs.validate(providerCodec, (provider) -> {
            if (provider.getMin() < min) {
                return DataResult.error(() -> {
                    return "Value provider too low: " + min + " [" + provider.getMin() + "-" + provider.getMax() + "]";
                });
            } else {
                return provider.getMax() > max ? DataResult.error(() -> {
                    return "Value provider too high: " + max + " [" + provider.getMin() + "-" + provider.getMax() + "]";
                }) : DataResult.success(provider);
            }
        });
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryEntryLookup<StructureProcessorList> registryEntryLookup = context.getRegistryLookup(RegistryKeys.PROCESSOR_LIST);

        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldInfurtrinatedeOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, TDBTDBlocks.INFURTRINATED_DEEPSLATE_ORE.getDefaultState()));


        register(context, INFURTRINATED_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldInfurtrinatedeOres, 12));


        register(context, CRITERIC_CHARRED_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(TDBTDBlocks.CRITERIC_CHARRED_LOG),
                new UpwardsBranchingTrunkPlacer(4, 5, 9, UniformIntProvider.create(5, 9), 0.6f,
                        UniformIntProvider.create(1, 3), Registries.BLOCK.getOrCreateEntryList(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)),
                BlockStateProvider.of(Blocks.MANGROVE_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 70), Optional.of(
                new MangroveRootPlacer(UniformIntProvider.create(3, 7), BlockStateProvider.of(TDBTDBlocks.CRITERIC_CHARRED_LOG), Optional.of(
                        new AboveRootPlacement(BlockStateProvider.of(TDBTDBlocks.CRITERIC_MOSS_CARPET), 0.5F)),
                        new MangroveRootPlacement(Registries.BLOCK.getOrCreateEntryList(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), RegistryEntryList.of(Block::getRegistryEntry, TDBTDBlocks.DIMENTED_GRASS_BLOCK, TDBTDBlocks.DIMENTED_DIRT),
                                BlockStateProvider.of(TDBTDBlocks.DIMENTED_DIRT), 10, 12, 0.58f))),
                new TwoLayersFeatureSize(7, 1, 4)).decorators(List.of(
                        new LeavesVineTreeDecorator(1f), new AttachedToLeavesTreeDecorator(0.9f, 1, 0,
                                new RandomizedIntBlockStateProvider(BlockStateProvider.of(TDBTDBlocks.CRITERIC_CHARRED_FLOWER_LEAVES.getDefaultState()),
                                        PropaguleBlock.AGE, (IntProvider) UniformIntProvider.create(0, 4)), 1, List.of(Direction.DOWN)), BEES_001)).forceDirt().ignoreVines()
                .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(TDBTDBlocks.DIMENTED_GRASS_BLOCK)))).build());


        register(context, INFURTRINATED_GEODE_KEY, Feature.GEODE, new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                BlockStateProvider.of(TDBTDBlocks.ECHOING_AMETHYST),
                BlockStateProvider.of(TDBTDBlocks.BUDDING_ECHOING_AMETHYST),
                BlockStateProvider.of(TDBTDBlocks.INFURTRINATED_CALCITE),
                BlockStateProvider.of(TDBTDBlocks.INFURTRINATED_SMOOTH_BASALT),
                List.of(TDBTDBlocks.ECHOING_AMETHYST_CLUSTER.getDefaultState()),
                BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                new GeodeLayerThicknessConfig(1.7D, 2.2D, 2.5D, 3.5D),
                new GeodeCrackConfig(0.25D, 1.5D, 1),
                0.5D, 0.1D,
                true, UniformIntProvider.create(3, 8),
                UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                -18, 18, 0.075D, 1));


        List<Identifier> list = List.of(new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/bone_"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/bone_2"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/bone_3"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/bone_4"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/bone_5"), new Identifier("Main.TDBTD_ID, infurtrinated_bonned_fossil/bone_6"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/bone_7"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/bone_8"));
        List<Identifier> list2 = List.of(new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/frag_1"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/frag_2"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/frag_3"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/frag_4"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/frag_5"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/frag_6"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/frag_7"), new Identifier(Main.TDBTD_ID, "infurtrinated_bonned_fossil/frag_8"));
        RegistryEntry<StructureProcessorList> registryEntry = registryEntryLookup.getOrThrow(StructureProcessorLists.FOSSIL_ROT);
        register(context, INFURTRINATED_BONNED_FOSSIL_KEY, Feature.FOSSIL, new FossilFeatureConfig(list, list2, registryEntry, registryEntryLookup.getOrThrow(StructureProcessorLists.FOSSIL_COAL), 4));

        WeightedBlockStateProvider weightedBlockStateProvider = new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                .add(TDBTDBlocks.CRITERIC_VINES_HEAD.getDefaultState(), 4).add((BlockState) TDBTDBlocks.CRITERIC_VINES_HEAD.getDefaultState().with(TDBTDCaveVinesHeadBlock.BERRIES, false), 1).build());

        RandomizedIntBlockStateProvider randomizedIntBlockStateProvider = new RandomizedIntBlockStateProvider(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(TDBTDBlocks.CRITERIC_VINES_BODY.getDefaultState(), 4).add((BlockState) TDBTDBlocks.CRITERIC_VINES_BODY.getDefaultState().with(TDBTDCaveVinesBodyBlock.BERRIES, false), 1).build()
                ), CaveVinesHeadBlock.AGE, UniformIntProvider.create(23, 25));

        register(context, CRITERIC_VINES_KEY, Feature.BLOCK_COLUMN, new BlockColumnFeatureConfig(
                List.of(BlockColumnFeatureConfig.createLayer(
                        new WeightedListIntProvider(DataPool.<IntProvider>builder()
                                .add(UniformIntProvider.create(0, 19), 2).add(UniformIntProvider.create(0, 2), 3).add(UniformIntProvider.create(0, 6), 10).build()),
                        weightedBlockStateProvider), BlockColumnFeatureConfig.createLayer(ConstantIntProvider.create(1),
                        randomizedIntBlockStateProvider)), Direction.DOWN, BlockPredicate.IS_AIR, true));

        register(context, CRITERIC_MOSS_VEGETATION_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                .add(Blocks.FLOWERING_AZALEA.getDefaultState(), 4).add(Blocks.AZALEA.getDefaultState(), 7).add(TDBTDBlocks.CRITERIC_MOSS_CARPET.getDefaultState(), 25)
                .add(Blocks.GRASS.getDefaultState(), 50).add(Blocks.TALL_GRASS.getDefaultState(), 10).build())));

        RegistryEntry<ConfiguredFeature<?, ?>> mossVegetationEntry = (RegistryEntry<ConfiguredFeature<?, ?>>) registerKey("criteric_moss_vegetation_key").getRegistry();
        register(context, CRITERIC_MOSS_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.of(Blocks.MOSS_BLOCK), PlacedFeatures.createEntry(mossVegetationEntry), VerticalSurfaceType.FLOOR, ConstantIntProvider.create(1),
                        0.0F, 5, 0.8F, UniformIntProvider.create(4, 7), 0.3F));


        register(context, DIMENTED_GRAVEL_DISC_KEY, Feature.DISK, new DiskFeatureConfig(PredicatedStateProvider.of(TDBTDBlocks.DIMENTED_GRAVEL), BlockPredicate.matchingBlocks(List.of(Blocks.GRAVEL, Blocks.GRAVEL)), UniformIntProvider.create(2, 5), 2));


        register(context, INFURTRINATED_DEEPSLATE_DISC_KEY, Feature.DISK, new DiskFeatureConfig(PredicatedStateProvider.of(TDBTDBlocks.INFURTRINATED_DEEPSLATE), BlockPredicate.matchingBlocks(List.of(Blocks.DEEPSLATE, Blocks.DEEPSLATE)), UniformIntProvider.create(2, 5), 2));
        register(context, INFURTRINATED_TUFF_DISC_KEY, Feature.DISK, new DiskFeatureConfig(PredicatedStateProvider.of(TDBTDBlocks.INFURTRINATED_TUFF), BlockPredicate.matchingBlocks(List.of(Blocks.TUFF, Blocks.TUFF)), UniformIntProvider.create(2, 5), 2));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Main.TDBTD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    /*

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
