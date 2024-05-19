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

import com.mojang.serialization.Lifecycle;
import com.spirit.gamblic.GamblicMod;
import com.spirit.ignite.IgniteMod;
import com.spirit.ignite.global.block.IgniteBlocks;
import com.spirit.ignite.global.item.IgniteItemGroup;
import com.spirit.ignite.global.item.IgniteItems;
import com.spirit.ignite.global.item.custom.GunItem;
import com.spirit.ignite.global.particle.IgniteParticles;
import com.spirit.ignite.global.sound.IgniteSounds;
import com.spirit.koil.api.json.JsonBlockMaker;
import com.spirit.koil.api.json.JsonItemMaker;
import com.spirit.koil.util.PacketIDs;
import com.spirit.shit.ShitMod;
import com.spirit.shit.global.block.ShitBlockEntities;
import com.spirit.shit.global.block.ShitBlocks;
import com.spirit.shit.global.effect.ShitEffects;
import com.spirit.shit.global.entity.ShitEntities;
import com.spirit.shit.global.entity.custom.*;
import com.spirit.shit.global.item.ShitItemGroup;
import com.spirit.shit.global.item.ShitItems;
import com.spirit.shit.global.painting.ShitPaintings;
import com.spirit.shit.global.particle.ShitParticles;
import com.spirit.shit.global.potion.ShitPotions;
import com.spirit.shit.global.sound.ShitSounds;
import com.spirit.tdbtd.TDBTDMod;
import com.spirit.tdbtd.data.util.TDBTDLootTableModifiers;
import com.spirit.tdbtd.global.block.TDBTDBlocks;
import com.spirit.tdbtd.global.block.entity.TDBTDBlockEntities;
import com.spirit.tdbtd.global.effect.TDBTDEffects;
import com.spirit.tdbtd.global.entity.custom.*;
import com.spirit.tdbtd.global.item.TDBTDItemGroup;
import com.spirit.tdbtd.global.item.TDBTDItems;
import com.spirit.tdbtd.global.potion.TDBTDPotions;
import com.spirit.tdbtd.global.sound.TDBTDSounds;
import com.spirit.tdbtd.global.world.gen.TDBTDWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.concurrent.TimeUnit;

import static com.spirit.tdbtd.global.entity.TDBTDEntities.*;

public class Main implements ModInitializer {
    public static final RegistryKey<Registry<DamageType>> CUSTOM_DAMAGE_TYPE_KEY = RegistryKey.ofRegistry(new Identifier("shit", "damage_type"));
    public static final SimpleRegistry<DamageType> CUSTOM_DAMAGE_TYPE_REGISTRY = new SimpleRegistry<>(CUSTOM_DAMAGE_TYPE_KEY, Lifecycle.stable(), true);
    public static StringBuilder blockTextBuilder = new StringBuilder();

    public static final String MAIN_ID = "minceraft";
    public static final String KOIL_ID = "koil";
    public static final String SHIT_ID = "shit";
    public static final String TDBTD_ID = "tdbtd";
    public static final String IGNITE_ID = "ignite";
    public static final String GAMBLIC_ID = "gamblic";
    public static final Logger LOGGER = LogManager.getLogger(MAIN_ID);
    public static final Logger KOIL_LOGGER = LogManager.getLogger(KOIL_ID);
    public static final Logger SHITLOGGER = LogManager.getLogger(SHIT_ID);
    public static final Logger TDBTDLOGGER = LogManager.getLogger(TDBTD_ID);
    public static final Logger IGNITELOGGER = LogManager.getLogger(IGNITE_ID);
    public static final Logger GAMBLICLOGGER = LogManager.getLogger(GAMBLIC_ID);

    @Override
    public void onInitialize() {

        //Koil Bridges:
        //Main.bridgeStart();
        //String DIRECTORY = "./mods/";
        //Bukkit.logBukkitBridge(String.valueOf(FileSystems.getDefault().getPath(DIRECTORY).toAbsolutePath()));
        //Quilt.logQuiltBridge(String.valueOf(FileSystems.getDefault().getPath(DIRECTORY).toAbsolutePath()));
        //Main.bridgeEnd();
        //System.out.println("INIT - BULLET" + ShitItems.BULLET);
        Main.checkMain();
        Main.checkTDBTDMod();
        Main.checkShitpostMod();
        Main.checkIgniteMod();
        Main.checkGamblicMod();
        Main.checkBranches();

        JsonItemMaker.makeTheJsonItem();
        JsonItemMaker.registerItemsFromJson();
        JsonBlockMaker.makeTheJsonBlocks();
        JsonBlockMaker.registerBlocksFromJson();

        TDBTDItems.registerAllItems();
        ShitItems.registerAll();
        IgniteItems.registerAll();

        TDBTDBlocks.registerAllBlocks();
        ShitBlocks.registerAll();
        IgniteBlocks.registerAll();

        TDBTDLootTableModifiers.modifyLootTables();

        TDBTDSounds.registerAll();
        ShitSounds.registerAll();
        IgniteSounds.registerAll();

        TDBTDBlockEntities.registerBlockEntities();
        ShitBlockEntities.registerBlockEntities();

        ShitParticles.registerParticles();
        IgniteParticles.registerParticles();

        TDBTDEffects.registerEffects();
        ShitEffects.registerEffects();
        TDBTDPotions.registerPotions();
        ShitPotions.registerPotions();
        ShitPaintings.registerPaintings();

        TDBTDWorldGeneration.generateTDBTDWorldGen();
        TDBTDWorldGeneration.registerWorldGenFeat();


        FabricDefaultAttributeRegistry.register(TENEBROUS_NIBBLER, TenebrousNibblerEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(APERTURENTEETH, AperturenteethEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CODELAING, CodelaingEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(PERICARPIUM, PericarpiumEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(SCUTLEON, ScutleonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(NIDIVER, NidiverEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CURATOR, CuratorEntity.addAttributes());
        FabricDefaultAttributeRegistry.register(MIJAPENDRA, MijapendraEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CONTRIVANCEPOLLOONE, ContrivancePolloOneEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CONTRIVANCEPOLLA, ContrivancePollaEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ABYSSOFIN, AbyssofinEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(STURGO, SturgoEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ENGUIA, EnguiaEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MALDININKAS, MaldininkasEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(DEVASTADOR_HOUND, DevastadorHoundEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(DEVASTADOR_CUR, DevastadorCurEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(DEVASTADOR_PUP, DevastadorPupEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(KREDA, KredaEntity.setAttributes());

        FabricDefaultAttributeRegistry.register(ShitEntities.JBRID, JbirdEntity.creatorJbirdAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.RAT_BOMB, RatBombEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.RAT, RatEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.CAPYBARA, CapybaraEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.SLIM_SHADY, SlimShadyEntity.setAttributes());
        //FabricDefaultAttributeRegistry.register(ShitEntities.YIPPEE, YippeeEntity.setAttributes());

        //Registry.register(Registries.ITEM_GROUP, new Identifier("shit", "booletgroup"), BULLET_ITEM_GROUP);

        //PACKETS
        ServerPlayNetworking.registerGlobalReceiver(PacketIDs.FIRE_GUN_PACKET, (server, player, handler, buf, responseSender) -> {
            int hand = buf.readInt(); // Read data sent from the client
            server.execute(() -> { // Switch to the main server thread before modifying the game
                ItemStack itemStack = player.getStackInHand(Hand.values()[hand]);
                if (itemStack.getItem() instanceof GunItem) {
                    ((GunItem) itemStack.getItem()).handleLeftClick(itemStack, player, player.getWorld());
                }
            });
        });
        ServerPlayNetworking.registerGlobalReceiver(PacketIDs.ZOOM_GUN_PACKET, (server, player, handler, buf, responseSender) -> {
            int hand = buf.readInt(); // Read data sent from the client
            server.execute(() -> { // Switch to the main server thread before modifying the game
                ItemStack itemStack = player.getStackInHand(Hand.values()[hand]);
                if (itemStack.getItem() instanceof GunItem) {
                    ((GunItem) itemStack.getItem()).handleRightClick(itemStack, player, player.getWorld());
                }
            });
        });

        //COMMANDS
        //DETONATION COMMAND
        /*
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("explode")
                .executes(context -> {
                    if (!Objects.requireNonNull(context.getSource().getPlayer()).getWorld().isClient()) {
                        double x = context.getSource().getPlayer().getX();
                        double y = context.getSource().getPlayer().getY();
                        double z = context.getSource().getPlayer().getZ();
                        float xp = context.getSource().getPlayer().experienceLevel;
                        boolean fire = context.getSource().getPlayer().isOnFire();
                        context.getSource().getWorld().createExplosion(context.getSource().getPlayer(), new DamageSource(RegistryEntry.of(new DamageType("bombed_self", 1))), new ExplosionBehavior(), x, y + 1, z, xp/4, fire, World.ExplosionSourceType.BLOCK, true);
                        context.getSource().getPlayer().damage(new DamageSource(RegistryEntry.of(new DamageType("bombed_self", 1))), xp);
                        context.getSource().getPlayer().setExperienceLevel(0);
                        context.getSource().getPlayer().setExperiencePoints(0);
                        context.getSource().getPlayer().playSound(ShitSounds.EXPLODE_SOUND_COMMAND, SoundCategory.PLAYERS, 1, 1);
                    }
                    return 1;
                })));
         */

        //CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
        //    SimpleCommandMap.BukkitCommand.register(dispatcher);
        //});

        Main.registerMain();
    }


    private static void checkBranches() {
        File modsFolder = new File(String.valueOf(FileSystems.getDefault().getPath("./mods/").toAbsolutePath()));
        File[] modFiles = modsFolder.listFiles();

        if (modFiles != null) {
            for (File modFile : modFiles) {
                if (modFile.getName().endsWith(".jar")) {
                    if (modFile.getName().startsWith("tdbtd")) {
                        TDBTDMod.registerTDBTDMod();
                        TDBTDItemGroup.register();
                    }
                    if (modFile.getName().startsWith("shitpost")) {
                        ShitMod.registerShitpostMod();
                        ShitItemGroup.register();
                    }
                    if (modFile.getName().startsWith("ignite")) {
                        IgniteMod.registerIgniteMod();
                        IgniteItemGroup.register();
                    }
                    if (modFile.getName().startsWith("gamblic")) {
                        GamblicMod.registerGamblicMod();
                    }
                }
            }
        }
    }


    public static void checkMain() {
        Main.LOGGER.info("> --Checking || minceraft/src/main/java/com/spirit/... ~ main");
    }

    public static void checkShitpostMod() {
        Main.LOGGER.info("> --Checked || minceraft/src/main/java/com/spirit/shit/ShitMod");
    }
    public static void checkTDBTDMod() {
        Main.LOGGER.info("> --Checked || minceraft/src/main/java/com/spirit/tdbtd/TDBTDMod");
    }
    public static void checkIgniteMod() {
        Main.LOGGER.info("> --Checked || minceraft/src/main/java/com/spirit/ignite/IgniteMod");
    }
    public static void checkGamblicMod() {
        Main.LOGGER.info("> --Checked || minceraft/src/main/java/com/spirit/gamblic/GamblicMod");
    }
    public static void registerMain() {
        Main.LOGGER.info("> --Loaded || minceraft/src/main/java/com/spirit/... ~ main");
    }

    public static void bridgeStart() {
        blockTextBuilder.append("""
            
            ====================================================================================================================================================================
            Beginning Bridging...
            Bridges (2):
            | Bukkit (dysfunctional)
            | Quilt (in progress)
            ====================================================================================================================================================================
            """);
    }
    public static void bridgeEnd() {
        blockTextBuilder.append("""
            Loaders Bridged!
            Continuing Loading Minecraft...
            ====================================================================================================================================================================           
            """);
        System.out.println(blockTextBuilder.toString());
    }


    public static String formatTime(long millis) {
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        long milliseconds = millis % 1000;
        if (hours > 0) {
            return String.format("%02d:%02d:%02d.%03d hr", hours, minutes, seconds, milliseconds);
        } else if (minutes > 0) {
            return String.format("%02d:%02d.%03d min", minutes, seconds, milliseconds);
        } else if (seconds > 0) {
            return String.format("%02d.%03d s", seconds, milliseconds);
        } else {
            return String.format("%d ms", milliseconds);
        }
    }

    public static String formatFileSize(double size) {
        if (size < 1024) {
            return String.format("%.2f bytes", size);
        } else if (size < 1024 * 1024) {
            return String.format("%.2f KB", size / 1024);
        } else if (size < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", size / (1024 * 1024));
        } else {
            return String.format("%.2f GB", size / (1024 * 1024 * 1024));
        }
    }
}