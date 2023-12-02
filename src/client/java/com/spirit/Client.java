package com.spirit;

import com.spirit.shit.ShitClientMod;
import com.spirit.tdbtd.TDBTDClientMod;
import net.fabricmc.api.ClientModInitializer;

public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Client.checkShitpostClientMod();
        ShitClientMod.registerShitpostClientMod();
        Client.checkTDBTDClientMod();
        TDBTDClientMod.registerTDBTDClientMod();
        Client.registerClient();
        IrisConfigModifier.haveInitializeClient();
    }

    public static void checkShitpostClientMod() {
        Main.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/ShitClientMod");
    }
    public static void checkTDBTDClientMod() {
        Main.LOGGER.info("> --Checked || the-shit-of-crypt/src/main/java/com/spirit/tdbtd/TDBTDClientMod");
    }
    public static void registerClient() {
        Main.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/... ~ client");
    }
}