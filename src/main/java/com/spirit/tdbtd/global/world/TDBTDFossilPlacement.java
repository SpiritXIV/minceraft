package com.spirit.tdbtd.global.world;

import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class TDBTDFossilPlacement {
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, SquarePlacementModifier square, HeightRangePlacementModifier uniform, BiomePlacementModifier biome) {
        return List.of(countModifier, square, uniform, biome);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, SquarePlacementModifier square, HeightRangePlacementModifier uniform, BiomePlacementModifier biome) {
        return modifiers(RarityFilterPlacementModifier.of(chance), square, uniform, biome);
    }
}
