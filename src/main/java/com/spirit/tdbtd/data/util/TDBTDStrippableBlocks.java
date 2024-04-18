package com.spirit.tdbtd.data.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

import static com.spirit.tdbtd.global.block.TDBTDBlocks.*;

public class TDBTDStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(CRITERIC_CHARRED_LOG, STRIPPED_CRITERIC_CHARRED_LOG);
        StrippableBlockRegistry.register(CRITERIC_CHARRED_WOOD, STRIPPED_CRITERIC_CHARRED_WOOD);
    }
    public static void registerUtil() {}

}
