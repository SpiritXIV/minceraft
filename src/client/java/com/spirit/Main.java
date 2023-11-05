/*
    $/ A K F I I J L M P Q $ I L \$
    |  F $ N R P T K D Q W V J N
    |
    |
    |
    |
    #\
 */

package com.spirit;
import com.spirit.shit.ShitMod;
import com.spirit.tdbtd.TDBTDMod;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
    // Commented as a node of how to make a custom registry
    //public static final RegistryKey<Registry<DamageType>> CUSTOM_DAMAGE_TYPE_KEY = RegistryKey.ofRegistry(new Identifier("shit", "damage_type"));
    //public static final SimpleRegistry<DamageType> CUSTOM_DAMAGE_TYPE_REGISTRY = new SimpleRegistry<>(CUSTOM_DAMAGE_TYPE_KEY, Lifecycle.stable(), true);
    
    public static final String MAIN_ID = "Koil Connector - Spirit";
    public static final String SHIT_ID = "shit";
    public static final String TDBTD_ID = "tdbtd";
    public static final Logger LOGGER = LogManager.getLogger(MAIN_ID);
    public static final Logger SHITLOGGER = LogManager.getLogger(SHIT_ID);
    public static final Logger TDBTDLOGGER = LogManager.getLogger(TDBTD_ID);



    @Override
    public void onInitialize() {
        Main.checkShitpostMod();
        ShitMod.registerShitpostMod();
        Main.checkTDBTDMod();
        TDBTDMod.registerTDBTDMod();
        Main.registerMain();
    }


    public static void checkShitpostMod() {
        Main.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/ShitMod");
    }
    public static void checkTDBTDMod() {
        Main.LOGGER.info("> --Checked || the-shit-of-crypt/src/main/java/com/spirit/tdbtd/TDBTDMod");
    }
    public static void registerMain() {
        Main.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/... ~ main");
    }
}


