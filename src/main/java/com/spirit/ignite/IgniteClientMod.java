package com.spirit.ignite;

import com.spirit.Main;
import net.fabricmc.api.ClientModInitializer;


public class IgniteClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
    }

    public static void registerIgniteClientMod() {
        Main.IGNITELOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/ignite/IgniteClientMod");
    }
}