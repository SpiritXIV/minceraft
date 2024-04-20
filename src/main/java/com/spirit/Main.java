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
import com.spirit.shit.ShitMod;
import com.spirit.shit.data.common.GunItem;
import com.spirit.shit.data.util.PacketIDs;
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
import com.spirit.tdbtd.global.world.gen.TDBTDWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import static com.spirit.tdbtd.global.entity.TDBTDEntities.*;
import static net.minecraft.server.command.CommandManager.literal;

public class Main implements ModInitializer {
    public static final RegistryKey<Registry<DamageType>> CUSTOM_DAMAGE_TYPE_KEY = RegistryKey.ofRegistry(new Identifier("shit", "damage_type"));
    public static final SimpleRegistry<DamageType> CUSTOM_DAMAGE_TYPE_REGISTRY = new SimpleRegistry<>(CUSTOM_DAMAGE_TYPE_KEY, Lifecycle.stable(), true);

    public static final String MAIN_ID = "minceraft";
    public static final String SHIT_ID = "shit";
    public static final String TDBTD_ID = "tdbtd";
    public static final String IGNITE_ID = "ignite";
    public static final String GAMBLIC_ID = "gamblic";
    public static final Logger LOGGER = LogManager.getLogger(MAIN_ID);
    public static final Logger SHITLOGGER = LogManager.getLogger(SHIT_ID);
    public static final Logger TDBTDLOGGER = LogManager.getLogger(TDBTD_ID);
    public static final Logger IGNITELOGGER = LogManager.getLogger(IGNITE_ID);
    public static final Logger GAMBLICLOGGER = LogManager.getLogger(GAMBLIC_ID);

    @Override
    public void onInitialize() {
        Main.checkShitpostMod();
        //System.out.println("INIT - BULLET" + ShitItems.BULLET);

        ShitItems.registerAll();
        ShitSounds.registerAll();
        ShitParticles.registerParticles();
        ShitEffects.registerEffects();
        ShitPotions.registerPotions();
        ShitBlocks.registerAll();
        ShitItemGroup.register();
        ShitPaintings.registerPaintings();


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
                    // Now this function internally checks for cooldown
                }
            });
        });

        //COMMANDS

        //DETONATION COMMAND
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
        ShitMod.registerShitpostMod();

        Main.checkTDBTDMod();
        TDBTDItemGroup.register();
        TDBTDItems.registerAllItems();
        TDBTDBlocks.registerAllBlocks();
        TDBTDLootTableModifiers.modifyLootTables();
        TDBTDEffects.registerEffects();
        TDBTDPotions.registerPotions();
        TDBTDLootTableModifiers.modifyLootTables();
        TDBTDBlockEntities.registerBlockEntities();
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
        TDBTDWorldGeneration.generateTDBTDWorldGen();
        TDBTDWorldGeneration.registerWorldGenFeat();
        TDBTDMod.registerTDBTDMod();


        Main.checkIgniteMod();

        Main.checkGamblicMod();

        Main.registerMain();

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
}


