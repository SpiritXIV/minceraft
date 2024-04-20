package com.spirit.ignite;

import com.spirit.Main;
import net.fabricmc.api.ModInitializer;

public class IgniteMod implements ModInitializer {
    @Override
    public void onInitialize() {
    }

    public static void registerIgniteMod() {
        Main.IGNITELOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/ignite/IgniteMod");
    }
}