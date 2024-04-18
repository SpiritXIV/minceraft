package com.spirit.tdbtd.global.world;

import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class TDBTDMossPatchPlacement {
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, SquarePlacementModifier modifier, PlacementModifier bottomTo120Range, EnvironmentScanPlacementModifier environmentScanPlacementModifier, RandomOffsetPlacementModifier vertically, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
