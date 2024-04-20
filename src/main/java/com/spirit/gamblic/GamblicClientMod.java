package com.spirit.gamblic;

import com.spirit.Main;
import net.fabricmc.api.ClientModInitializer;


public class GamblicClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
    }

    public static void registerGamblicClientMod() {
        Main.GAMBLICLOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/gamblic/GamblicClientMod");
    }
}