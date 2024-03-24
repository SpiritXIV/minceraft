package com.spirit.tdbtd.data.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

import static com.spirit.tdbtd.global.block.TDBTDBlocks.*;


public class TDBTDFlammableBlocks {
    public static void registerFlammableBlock() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(CRITERIC_CHARRED_LOG, 0, 0);
        instance.add(STRIPPED_CRITERIC_CHARRED_LOG, 0, 0);
        instance.add(CRITERIC_CHARRED_WOOD, 0, 0);
        instance.add(STRIPPED_CRITERIC_CHARRED_WOOD, 0, 0);
        instance.add(CRITERIC_CHARRED_PLANKS, 0, 0);
        instance.add(CRITERIC_CHARRED_LEAVES, 0, 0);
        instance.add(CRITERIC_CHARRED_FLOWER_LEAVES, 0, 0);
        //instance.add(CRITERIC_CHARRED_SAPLING, 0, 0);
        instance.add(CRITERIC_CHARRED_SLAB, 0, 0);
        instance.add(CRITERIC_CHARRED_FENCE, 0, 0);
        instance.add(CRITERIC_CHARRED_STAIRS, 0, 0);
        instance.add(CRITERIC_CHARRED_BUTTON, 0, 0);
        instance.add(CRITERIC_CHARRED_PRESSURE_PLATE, 0, 0);
        //instance.add(CRITERIC_CHARRED_DOOR, 0, 0);
        instance.add(CRITERIC_CHARRED_TRAPDOOR, 0, 0);
        instance.add(CRITERIC_CHARRED_FENCE_GATE, 0, 0);
    }

    public static void registerUtil() {}
}
