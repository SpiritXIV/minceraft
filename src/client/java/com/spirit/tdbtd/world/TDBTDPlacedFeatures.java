package com.spirit.tdbtd.world;

import com.spirit.Main;
import com.spirit.tdbtd.block.TDBTDBlocks;
import com.spirit.tdbtd.world.feature.TDBTDOrePlacement;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

import static com.spirit.tdbtd.world.TDBTDConfiguredFeatures.*;

public class TDBTDPlacedFeatures {
        public static final RegistryKey<PlacedFeature> CRITERIC_CHARRED_PLACED_KEY = registerKey("criteric_charred_placed");
        public static final RegistryKey<PlacedFeature> INFURTRINATED_ORE_PLACED_KEY = registerKey("infurtrinated_ore_placed");


        public static void bootstrap(Registerable<PlacedFeature> context) {
            var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

            register(context, CRITERIC_CHARRED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(CRITERIC_CHARRED_KEY),
                    VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), TDBTDBlocks.CRITERIC_CHARRED_SAPLING));

            register(context, INFURTRINATED_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(INFURTRINATED_ORE_KEY),
                    TDBTDOrePlacement.modifiersWithCount(16, // Veins per Chunk
                            HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        }

        public static RegistryKey<PlacedFeature> registerKey(String name) {
            return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Main.TDBTD_ID, name));
        }

        private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                     List<PlacementModifier> modifiers) {
            context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
        }

        private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                       RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                       PlacementModifier... modifiers) {
            register(context, key, configuration, List.of(modifiers));
        }


    /*
    //GEODE
    public static final RegistryEntry<PlacedFeature> DIMENTED_GEODE_PLACED = PlacedFeatures.register("dimented_geode_placed",
            DIMENTED_GEODE, RarityFilterPlacementModifier.of(500),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)),
            BiomePlacementModifier.of());

    //GRASS WHEN BONEMEAL
    public static final RegistryEntry<PlacedFeature> DIMENTED_GRASS_BONEMEAL_PLACED = PlacedFeatures.register("dimented_grass_bonemeal_placed",
            DIMENTED_GRASS_BONEMEAL, PlacedFeatures.isAir());

    //PILES
    public static final RegistryEntry<PlacedFeature> PILE_SCULK_RIBS = PlacedFeatures.register("pile_sculk_ribs_placed",
            PILE_SCULK_RIBS, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(6), YOffset.aboveBottom(50)));

    public static final RegistryEntry<PlacedFeature> PILE_SCULK_TEETH = PlacedFeatures.register("pile_sculk_teeth_placed",
            PILE_SCULK_TEETH, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(6), YOffset.aboveBottom(50)));

    public static final RegistryEntry<PlacedFeature> PILE_SCULK_FERN = PlacedFeatures.register("pile_sculk_fern_placed",
            PILE_SCULK_FERN, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(6), YOffset.aboveBottom(50)));


    //DISKS
    public static final RegistryEntry<PlacedFeature> DISK_TD_PLACED = PlacedFeatures.register("disk_td",
            DISK_TD, CountPlacementModifier.of(4), SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)), BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> DISK_CD_PLACED = PlacedFeatures.register("disk_cd",
            DISK_CD, CountPlacementModifier.of(5), SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)), BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> DISK_GD_PLACED = PlacedFeatures.register("disk_gd",
            DISK_GD, CountPlacementModifier.of(2), SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)), BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> DISK_TREE_PLACED = PlacedFeatures.register("disk_tree",
            DISK_TREE, CountPlacementModifier.of(4), SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)), BiomePlacementModifier.of());

    //TENVINES
    public static final RegistryEntry<PlacedFeature> SCULK_TENVINES_PLACED = PlacedFeatures.register("sculk_tenvines_placed",
            SCULK_TENVINES, CountPlacementModifier.of(10), SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)), BiomePlacementModifier.of());

    //CAVE VINES
    public static final RegistryEntry<PlacedFeature> SCULK_CAVE_VINES = PlacedFeatures.register("sculk_cave_vines",
            SCULK_CAVE_VINES, CountPlacementModifier.of(10), SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)), BiomePlacementModifier.of());

    //PATCH
    public static final RegistryEntry<PlacedFeature> PATCH_LOTUS_PLACED= PlacedFeatures.register("patch_lotus",
            PATCH_LOTUS, CountPlacementModifier.of(4), SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)), BiomePlacementModifier.of());

     */
}
