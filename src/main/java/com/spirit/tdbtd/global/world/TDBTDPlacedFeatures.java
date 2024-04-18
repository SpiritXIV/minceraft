package com.spirit.tdbtd.global.world;

import com.spirit.Main;
import com.spirit.tdbtd.global.block.TDBTDBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class TDBTDPlacedFeatures {
    public static final RegistryKey<PlacedFeature> INFURTRINATED_ORE_PLACED_KEY = registerKey("infurtrinated_ore_placed");
    public static final RegistryKey<PlacedFeature> CRITERIC_CHARRED_PLACED_KEY = registerKey("criteric_charred_placed");
    public static final RegistryKey<PlacedFeature> INFURTRINATED_GEODE_PLACED_KEY = registerKey("infurtrinated_geode_placed");
    public static final RegistryKey<PlacedFeature> INFURTRINATED_BONNED_FOSSIL_PLACED_KEY = registerKey("infurtrinated_bonned_fossil_placed");
    public static final RegistryKey<PlacedFeature> CRITERIC_VINES_PLACED_KEY = registerKey("criteric_vines_placed");
    public static final RegistryKey<PlacedFeature> CRITERIC_MOSS_PATCH_PLACED_KEY = registerKey("criteric_moss_patch_placed");
    public static final RegistryKey<PlacedFeature> CRITERIC_MOSS_PATCH_CEILING_PLACED_KEY = registerKey("criteric_moss_patch_ceiling_placed");
    public static final RegistryKey<PlacedFeature> DIMENTED_GRAVEL_DISC_PLACED_KEY = registerKey("dimented_gravel_disk_placed");
    public static final RegistryKey<PlacedFeature> DIMENTED_GRASS_DISC_PLACED_KEY = registerKey("dimented_grass_disk_placed");

    public static final RegistryKey<PlacedFeature> INFURTRINATED_DEEPSLATE_DISC_PLACED_KEY = registerKey("infurtrinated_deepslate_disc_placed");
    public static final RegistryKey<PlacedFeature> INFURTRINATED_TUFF_DISC_PLACED_KEY = registerKey("infurtrinated_tuff_disc_placed");

    public static final RegistryKey<PlacedFeature> SCULK_TENVINES_PLACED_KEY = registerKey("sculk_tenvines_placed");

    public static final RegistryKey<PlacedFeature> REPLACE_GRASS_BLOCK_PLACED_KEY = registerKey("dimented_grass_patch_placed");
    public static final RegistryKey<PlacedFeature> REPLACE_DIRT_PLACED_KEY = registerKey("dimented_dirt_patch_placed");


    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, INFURTRINATED_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.INFURTRINATED_ORE_KEY),
                TDBTDOrePlacement.modifiersWithCount(2, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(0))));


        register(context, CRITERIC_CHARRED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.CRITERIC_CHARRED_KEY),
                /*IMPORTANT (VegetationPlacedFeatures)*/ VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        TDBTDBlocks.CRITERIC_CHARRED_SAPLING));

        register(context, INFURTRINATED_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.CRITERIC_CHARRED_KEY),
                TDBTDGeodePlacement.modifiersWithRarity(24, SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.fixed(30)), BiomePlacementModifier.of()));

        register(context, INFURTRINATED_BONNED_FOSSIL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.INFURTRINATED_BONNED_FOSSIL_KEY),
                TDBTDFossilPlacement.modifiersWithRarity(24, SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.fixed(30)), BiomePlacementModifier.of()));

        register(context, CRITERIC_VINES_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.CRITERIC_VINES_KEY),
                TDBTDVinesPlacement.modifiersWithCount(188, SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, EnvironmentScanPlacementModifier.of(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.IS_AIR, 12)));

        register(context, CRITERIC_MOSS_PATCH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.CRITERIC_MOSS_PATCH_KEY),
                TDBTDMossPatchPlacement.modifiersWithCount(125, SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, EnvironmentScanPlacementModifier.of(Direction.DOWN,
                        BlockPredicate.solid(), BlockPredicate.IS_AIR, 12), RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1)), BiomePlacementModifier.of()));

        register(context, CRITERIC_MOSS_PATCH_CEILING_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.CRITERIC_MOSS_PATCH_CEILING_KEY),
                TDBTDMossPatchCeilingPlacement.modifiersWithCount(125, SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, EnvironmentScanPlacementModifier.of(Direction.UP,
                        BlockPredicate.solid(), BlockPredicate.IS_AIR, 12), RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(-1)), BiomePlacementModifier.of()));

        register(context, DIMENTED_GRAVEL_DISC_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.DIMENTED_GRAVEL_DISC_KEY),
                TDBTDDiskPlacement.modifiersWithCount(SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BlockFilterPlacementModifier.of(BlockPredicate.matchingFluids(Fluids.EMPTY)), BiomePlacementModifier.of()));
        register(context, DIMENTED_GRASS_DISC_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.DIMENTED_GRASS_DISC_KEY),
                TDBTDDiskPlacement.modifiersWithCount(SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BlockFilterPlacementModifier.of(BlockPredicate.matchingFluids(Fluids.EMPTY)), BiomePlacementModifier.of()));
        register(context, INFURTRINATED_DEEPSLATE_DISC_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.INFURTRINATED_DEEPSLATE_DISC_KEY),
                TDBTDDiskPlacement.modifiersWithCount(SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingFluids(Fluids.WATER)), BiomePlacementModifier.of()));
        register(context, INFURTRINATED_TUFF_DISC_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.INFURTRINATED_TUFF_DISC_KEY),
                TDBTDDiskPlacement.modifiersWithCount(SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingFluids(Fluids.WATER)), BiomePlacementModifier.of()));

        register(context, SCULK_TENVINES_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.SCULK_TENVINES_KEY),
                TDBTDVinesPlacement.modifiersWithCount(188, SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, EnvironmentScanPlacementModifier.of(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.IS_AIR, 12)));

        register(context, REPLACE_GRASS_BLOCK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.REPLACE_GRASS_BLOCK_KEY),
                TDBTDReplacePlacement.modifiersWithCount(188, SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, EnvironmentScanPlacementModifier.of(Direction.DOWN,
                        BlockPredicate.alwaysTrue(), BlockPredicate.matchingBlocks(Blocks.AIR, Blocks.WATER, Blocks.SCULK_VEIN, TDBTDBlocks.CRITERIC_MOSS_CARPET), 24), RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(10)), BiomePlacementModifier.of()));
        register(context, REPLACE_DIRT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TDBTDConfiguredFeatures.REPLACE_DIRT_KEY),
                TDBTDReplacePlacement.modifiersWithCount(188, SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, EnvironmentScanPlacementModifier.of(Direction.DOWN,
                        BlockPredicate.alwaysTrue(), BlockPredicate.matchingBlocks(Blocks.AIR, Blocks.WATER, Blocks.SCULK_VEIN, TDBTDBlocks.CRITERIC_MOSS_CARPET, TDBTDBlocks.CRITERIC_MOSS_BLOCK, TDBTDBlocks.CRITERIC_MOSS_CARPET, Blocks.SCULK_VEIN, Blocks.SCULK), 24), RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(10)), BiomePlacementModifier.of()));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Main.TDBTD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
