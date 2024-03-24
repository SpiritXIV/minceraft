package com.spirit.tdbtd.global.world;

import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class TDBTDDiskPlacement {
    public static List<PlacementModifier> modifiers(SquarePlacementModifier of, PlacementModifier oceanFloorWgHeightmap, BlockFilterPlacementModifier of1, BiomePlacementModifier of2) {
        return List.of(of, SquarePlacementModifier.of(), oceanFloorWgHeightmap, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(SquarePlacementModifier of, PlacementModifier oceanFloorWgHeightmap, BlockFilterPlacementModifier of1, BiomePlacementModifier of2) {
        return modifiers(of, oceanFloorWgHeightmap, of1, of2);
    }
}
