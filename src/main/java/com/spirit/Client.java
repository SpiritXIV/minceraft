package com.spirit;

import com.spirit.gamblic.GamblicClientMod;
import com.spirit.ignite.IgniteClientMod;
import com.spirit.shit.ShitClientMod;
import com.spirit.tdbtd.TDBTDClientMod;
import com.spirit.koil.render.IrisConfigModifier;
import net.fabricmc.api.ClientModInitializer;

public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Client.checkShitpostClientMod();
        ShitClientMod.registerShitpostClientMod();
        Client.checkTDBTDClientMod();
        TDBTDClientMod.registerTDBTDClientMod();
        Client.checkIgniteClientMod();
        IgniteClientMod.registerIgniteClientMod();
        Client.checkGamblicClientMod();
        GamblicClientMod.registerGamblicClientMod();

        Client.registerClient();
        IrisConfigModifier.haveInitializeClient();
    }

    public static void checkShitpostClientMod() {
        Main.LOGGER.info("> --Checked || minceraft/src/main/java/com/spirit/shit/ShitClientMod");
    }
    public static void checkTDBTDClientMod() {
        Main.LOGGER.info("> --Checked || minceraft/src/main/java/com/spirit/tdbtd/TDBTDClientMod");
    }
    public static void checkIgniteClientMod() {
        Main.LOGGER.info("> --Checked || minceraft/src/main/java/com/spirit/ignite/IgniteClientMod");
    }
    public static void checkGamblicClientMod() {
        Main.LOGGER.info("> --Checked || minceraft/src/main/java/com/spirit/gamblic/GamblicClientMod");
    }
    public static void registerClient() {
        Main.LOGGER.info("> --Loaded || minceraft/src/main/java/com/spirit/... ~ client");
    }
}