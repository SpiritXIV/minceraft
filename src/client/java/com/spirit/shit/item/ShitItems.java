package com.spirit.shit.item;

import com.spirit.shit.ShitMod;
import com.spirit.shit.item.custom.*;
import com.spirit.shit.item.custom.guns.*;
import com.spirit.shit.item.custom.projectile.*;
import com.spirit.shit.item.custom.DoritosChipItem;
import com.spirit.shit.item.custom.projectile.beverage.*;
import com.spirit.shit.item.custom.projectile.beverage.BottleItem;
import com.spirit.shit.item.custom.SmokesPackItem;
import com.spirit.shit.item.material.CatcornMaterial;
import com.spirit.shit.item.material.GiantLolipopMaterial;
import com.spirit.shit.item.material.ZarshScytheMaterial;
import com.spirit.shit.sound.ShitSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ShitItems {


    //Items
    public static final Item ALUMINUM_INGOT = registerItem("aluminum_ingot", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item ALUMINUM_NUGGET = registerItem("aluminum_nugget", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item BOLT_BRONZE = registerItem("bolt_bronze", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item BOLT_GOLDEN = registerItem("bolt_golden", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item BOLT_IRON = registerItem("bolt_iron", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item BROKEN_ITEM = registerItem("broken_item", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item CHEMICAL_FLUID = registerItem("chemical_fluid", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item DOORKNOB_COPPER = registerItem("doorknob_copper", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item DOORKNOB_DIAMOND = registerItem("doorknob_diamond", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item DOORKNOB_EMERALD = registerItem("doorknob_emerald", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item DOORKNOB_GOLD = registerItem("doorknob_gold", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item DOORKNOB_IRON = registerItem("doorknob_iron", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item DOORKNOB_RUSTY = registerItem("doorknob_rusty", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item DOORKNOB_STEEL = registerItem("doorknob_steel", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item DOORKNOB = registerItem("doorknob", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item GEARS = registerItem("gears", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item LEAD_INGOT = registerItem("lead_ingot", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item LEAD_NUGGET = registerItem("lead_nugget", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item METAL_FRAGMENTS = registerItem("metal_fragments", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SAW_BRONZE = registerItem("saw_bronze", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SAW_CASTIRON = registerItem("saw_castiron", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SAW_GOLDEN = registerItem("saw_golden", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SAW_IRON = registerItem("saw_iron", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SCRAP = registerItem("scrap", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SEPARATING_AGENT = registerItem("separating_agent", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SILICON = registerItem("silicon", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item SILVER_NUGGET = registerItem("silver_nugget", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item STRONG_CHEMICAL_FLUID = registerItem("strong_chemical_fluid", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item TARP = registerItem("tarp", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item TECH_TRASH = registerItem("tech_trash", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item WORN_TARP = registerItem("worn_tarp", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));




    public static final Item RED_BRICK = registerItem("red_brick", new RedBrickProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));
    public static final Item BLUE_BRICK = registerItem("blue_brick", new BlueBrickProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));
    public static final Item TRASH_CAN = registerItem("trash_can", new TrashCanProjectileItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));

    //FOODS@SuppressWarnings("unused")
    public static final Item OAT = registerItem("oat", new OatProjectileItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item BANANA = registerItem("banana", new Item(new FabricItemSettings().food(ShitFoodComponents.BANANA).maxCount(64).rarity(Rarity.COMMON)));
    public static final Item POCKY_STICK = registerItem("pocky_stick", new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICK).maxCount(64).rarity(Rarity.COMMON)));
    public static final Item POCKY_STICKS = registerItem("pocky_sticks", new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICKS).maxCount(32).rarity(Rarity.COMMON)));
    public static final Item POCKY_STICK_BOX = registerItem("pocky_stick_box", new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICK_BOX).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item NACHO_DORITOS_CHIP = registerItem("nacho_dorito_chip", new DoritosChipItem(new FabricItemSettings().food(ShitFoodComponents.DORITOS_CHIP).maxCount(64).rarity(Rarity.COMMON)));
    public static final Item NACHO_DORITOS_BAG = registerItem("nacho_dorito_bag", new Item(new FabricItemSettings().food(ShitFoodComponents.DORITOS_BAG).maxCount(64).rarity(Rarity.COMMON)));
    public static final Item HORSE_HOOF = registerItem("horse_hoof", new Item(new FabricItemSettings().food(ShitFoodComponents.HORSE_HOOF).maxCount(64).rarity(Rarity.COMMON)));
    public static final Item RAW_CHEVALINE = registerItem("raw_chevaline", new Item(new FabricItemSettings().food(ShitFoodComponents.RAW_CHEVALINE).maxCount(64).rarity(Rarity.COMMON)));
    public static final Item COOKED_CHEVALINE = registerItem("cooked_chevaline", new Item(new FabricItemSettings().food(ShitFoodComponents.COOKED_CHEVALINE).maxCount(64).rarity(Rarity.COMMON)));
    public static final Item TALON_BURGER = registerItem("talon_burger", new Item(new FabricItemSettings().food(ShitFoodComponents.TALON_BURGER).maxCount(64).rarity(Rarity.COMMON)));
    //FOODS | WILL KILL YOU
    public static final Item URANIUM_DUST = registerItem("uranium_dust", new UraniumItem(new FabricItemSettings().food(ShitFoodComponents.URANIUM_DUST).maxCount(64).rarity(Rarity.COMMON)));
    public static final Item PEEP_YELLOW = registerItem("peep_yellow", new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_YELLOW).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item PEEP_CYAN = registerItem("peep_cyan", new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_CYAN).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item PEEP_PINK = registerItem("peep_pink", new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_PINK).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item PEEP_PURPLE = registerItem("peep_purple", new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_PURPLE).maxCount(1).rarity(Rarity.COMMON)));

    //DRINKS
    public static final Item BEER = registerItem("beer", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item BEER_BOTTLE = registerItem("beer_bottle", new BeerBottleProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));

    public static final Item BONK_ATOMIC_PUNCH = registerItem("bonk_atomic_punch", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item BONK_ATOMIC_PUNCH_PROJECTILE = registerItem("bonk_atomic_punch_projectile", new BonkAtomicPunchProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item BOTTLE = registerItem("bottle", new BottleItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));
    public static final Item BUD_LIGHT = registerItem("bud_light", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item BUD_LIGHT_CAN = registerItem("bud_light_can", new BudLightCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item CHAMPAGNE = registerItem("champagne", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item CHAMPAGNE_BOTTLE = registerItem("champagne_bottle", new ChampagneBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item CHUG_JUG = registerItem("chug_jug", new Item(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item CHUG_JUG_EMPTY = registerItem("chug_jug_empty", new ChugJugProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));

    public static final Item COCA_COLA = registerItem("coca_cola", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item COCA_COLA_CAN = registerItem("coca_cola_can", new CocaColaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item COKE_ZERO = registerItem("coke_zero", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item COKE_ZERO_CAN = registerItem("coke_zero_can", new CokeZeroCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item CRITA_COLA = registerItem("crita_cola", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item CRITA_COLA_CAN = registerItem("crita_cola_can", new CritaColaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item DR_PEPPER = registerItem("dr_pepper", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item DR_PEPPER_CAN = registerItem("dr_pepper_can", new DrPepperCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item FANTA = registerItem("fanta", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item FANTA_CAN = registerItem("fanta_can", new FantaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item FLASK = registerItem("flask", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.FLASK).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item FLASK_EMPTY = registerItem("flask_empty", new FlaskProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));
    public static final Item GLASS_JAR = registerItem("glass_jar", new GlassJarProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));
    public static final Item LAGAR = registerItem("lagar", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item LAGAR_BOTTLE = registerItem("lagar_bottle", new LagarBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item MILK_CARTON = registerItem("milk_carton", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item MILK_CARTON_EMPTY = registerItem("milk_carton_empty", new MilkCartonProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item MOUNTAIN_DEW = registerItem("mountain_dew", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item MOUNTAIN_DEW_CAN = registerItem("mountain_dew_can", new MountainDewCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item COFFEE = registerItem("coffee", new Item(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item MUG = registerItem("mug", new MugItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));
    public static final Item MUG_ROOT_BEER = registerItem("mug_root_beer", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item MUG_ROOT_BEER_CAN = registerItem("mug_root_beer_can", new MugRootBeerCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item NUKA_COLA = registerItem("nuka_cola", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item NUKA_COLA_BOTTLE = registerItem("nuka_cola_bottle", new NukaColaBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item NUKA_COLA_DARK = registerItem("nuka_cola_dark", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item NUKA_COLA_DARK_BOTTLE = registerItem("nuka_cola_dark_bottle", new NukaColaDarkBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item NUKA_COLA_QUANTUM = registerItem("nuka_cola_quantum", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item NUKA_COLA_QUANTUM_BOTTLE = registerItem("nuka_cola_quantum_bottle", new NukaColaQuantumBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item PEEPS_PEPSI = registerItem("peeps_pepsi", new PeepsPepsiItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item PEEPS_PEPSI_CAN = registerItem("peeps_pepsi_can", new PeepsPepsiCanProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));
    public static final Item PEPSI = registerItem("pepsi", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item PEPSI_CAN = registerItem("pepsi_can", new PepsiCanProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));
    public static final Item RUM = registerItem("rum", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item RUM_BOTTLE = registerItem("rum_bottle", new RumBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_BLUEBERRYTART = registerItem("shize_blueberrytart", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_BLUEBERRYTART_CAN = registerItem("shize_blueberrytart_can", new ShizeBlueBerryTartCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_BLUSHINGROSE = registerItem("shize_blushingrose", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_BLUSHINGROSE_CAN = registerItem("shize_blushingrose_can", new ShizeBlushingRoseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_CANADASHY = registerItem("shize_canadashy", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_CANADASHY_CAN = registerItem("shize_canadashy_can", new ShizeCanadaShyCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_CHEEKYBITOPUD = registerItem("shize_cheekybitopud", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_CHEEKYBITOPUD_CAN = registerItem("shize_cheekybitopud_can", new ShizeCheekyBitoPudCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_CHERRYPOP = registerItem("shize_cherrypop", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_CHERRYPOP_CAN = registerItem("shize_cherrypop_can", new ShizeCherryPopCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_COLDBEETSTEW = registerItem("shize_coldbeetstew", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_COLDBEETSTEW_CAN = registerItem("shize_coldbeetstew_can", new ShizeColdBeetStewCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_ELDERFLOWER = registerItem("shize_elderflower", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_ELDERFLOWER_CAN = registerItem("shize_elderflower_can", new ShizeElderFlowerCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_FACTORYRUST = registerItem("shize_factoryrust", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_FACTORYRUST_CAN = registerItem("shize_factoryrust_can", new ShizeFactoryRustCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_FOURCHEESE = registerItem("shize_fourcheese", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_FOURCHEESE_CAN = registerItem("shize_fourcheese_can", new ShizeFourCheeseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_FRENCHVANILLA = registerItem("shize_frenchvanilla", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_FRENCHVANILLA_CAN = registerItem("shize_frenchvanilla_can", new ShizeFrenchVanillaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_FULMEDAMES = registerItem("shize_fulmedames", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_FULMEDAMES_CAN = registerItem("shize_fulmedames_can", new ShizeFulmedamesCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_GAMERENERGY = registerItem("shize_gamerenergy", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_GAMERENERGY_CAN = registerItem("shize_gamerenergy_can", new ShizeGamerEnergyCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_JELLYBEAN = registerItem("shize_jellybean", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_JELLYBEAN_CAN = registerItem("shize_jellybean_can", new ShizeJellyBeanCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_JUICYMELON = registerItem("shize_juicymelon", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_JUICYMELON_CAN = registerItem("shize_juicymelon_can", new ShizeJuicyMelonCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_LEMONPARTY = registerItem("shize_lemonparty", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_LEMONPARTY_CAN = registerItem("shize_lemonparty_can", new ShizeLemonPartyCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_LIGHT = registerItem("shize_light", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_LIGHT_CAN = registerItem("shize_light_can", new ShizeLightCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));

    public static final Item SHIZE_LIQUORLISIOUS = registerItem("shize_liquorlisious", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_LIQUORLISIOUS_CAN = registerItem("shize_liquorlisious_can", new ShizeLiquorLisiousCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_MAYONNAISE = registerItem("shize_mayonnaise", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_MAYONNAISE_CAN = registerItem("shize_mayonnaise_can", new ShizeMayonnaiseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_MUSTARD = registerItem("shize_mustard", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_MUSTARD_CAN = registerItem("shize_mustard_can", new ShizeMustardCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_ORIGINAL = registerItem("shize_original", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_ORIGINAL_CAN = registerItem("shize_original_can", new ShizeOriginalCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_PINEAPPLEPIZZA = registerItem("shize_pineapplepizza", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_PINEAPPLEPIZZA_CAN = registerItem("shize_pineapplepizza_can", new ShizePineapplePizzaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_RAWMEAT = registerItem("shize_rawmeat", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_RAWMEAT_CAN = registerItem("shize_rawmeat_can", new ShizeRawMeatCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_SARDINESURPRISE = registerItem("shize_sardinesurprise", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_SARDINESURPRISE_CAN = registerItem("shize_sardinesurprise_can", new ShizeSardineSurpriseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_STRAWBERRYKIWI = registerItem("shize_strawberrykiwi", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_STRAWBERRYKIWI_CAN = registerItem("shize_strawberrykiwi_can", new ShizeStrawberryKiwiCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_TANGYKETCHUP = registerItem("shize_tangyketchup", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_TANGYKETCHUP_CAN = registerItem("shize_tangyketchup_can", new ShizeTangyKetchupCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_TAROTEASE = registerItem("shize_tarotease", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_TAROTEASE_CAN = registerItem("shize_tarotease_can", new ShizeTaroTeaseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_THIRSTBORN = registerItem("shize_thirstborn", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_THIRSTBORN_CAN = registerItem("shize_thirstborn_can", new ShizeThirstBornCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_TIRAMISU = registerItem("shize_tiramisu", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_TIRAMISU_CAN = registerItem("shize_tiramisu_can", new ShizeTiramisuCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_TROPICALSTORM = registerItem("shize_tropicalstorm", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_TROPICALSTORM_CAN = registerItem("shize_tropicalstorm_can", new ShizeTropicalStormCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_VEGGIEBROTH = registerItem("shize_veggiebroth", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SHIZE_VEGGIEBROTH_CAN = registerItem("shize_veggiebroth_can", new ShizeVeggieBrothCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item STRAWBERRY_MILK_CARTON = registerItem("strawberry_milk_carton", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item STRAWBERRY_MILK_CARTON_EMPTY = registerItem("strawberry_milk_carton_empty", new StrawberryMilkCartonProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item VODKA = registerItem("vodka", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item VODKA_BOTTLE = registerItem("vodka_bottle", new VodkaBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item WINE = registerItem("wine", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item WINE_BOTTLE = registerItem("wine_bottle", new WineBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item WINE_GLASS = registerItem("wine_glass", new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item WINE_GLASS_EMPTY = registerItem("wine_glass_empty", new WineGlassProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    //DRINKS | COD PERKS
    public static final Item SPEED_COLA = registerItem("speed_cola", new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));
    public static final Item SPEED_COLA_CAN = registerItem("speed_cola_can", new SpeedColaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON)));

    //DRINKS | WILL KILL YOU
    public static final Item CHOCOLATE_OREO_SHAKE = registerItem("chocolate_oreo_shake", new ChocolateOreoShakeItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_YELLOW).maxCount(1).rarity(Rarity.COMMON)));

    //WEAPONS
    //GUNS

    public static final Item AK47 = registerItem("ak47", new AK47Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item DOUBLE_BARREL = registerItem("double_barrel", new DoubleBarrelItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item FNP90 = registerItem("fnp_90", new fnp90Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item FNP90SCOPE = registerItem("fnp_90_scope", new fnp90scopeItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item GLOCK17 = registerItem("glock_17", new Glock17Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item M16 = registerItem("m16", new M16Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item M1_GARAND = registerItem("m1_garand", new RevolverItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item REVOLVER = registerItem("revolver", new RevolverItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item GOLDEN_REVOLVER = registerItem("revolver_golden", new GoldenRevolverItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item SAWED_OFF = registerItem("sawed_off", new SawedOffItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));
    public static final Item STRIKER_12 = registerItem("striker_12", new Striker12Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600)));



    //iron bullets are only a bullet your guns can shoot them, but you can not have tipped iron bullets, nor can you have tipped incendiary bullets
    //gold bullets are spectral bullets, no this also can have any tipped varients, it will only give you glowing when hit,
    //so the only bullets that should have a tipped varient are the bullet itself, the rifle bullet, the shell, and the slug


    public static final Item IRON_BULLET = registerItem("bullet_iron", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item IRON_BULLET_ENTITY = registerItem("bullet_iron_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    public static final Item BULLET = registerItem("bullet", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item BULLET_ENTITY = registerItem("bullet_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    public static final Item GOLD_BULLET = registerItem("bullet_gold", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item GOLD_BULLET_ENTITY = registerItem("bullet_gold_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
   // public static final Item INCENDIARY_BULLET = registerItem("bullet_incendiary", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
   // public static final Item INCENDIARY_BULLET_ENTITY = registerItem("bullet_incendiary_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));


    public static final Item IRON_RIFLE_BULLET = registerItem("rifle_bullet_iron", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item IRON_RIFLE_BULLET_ENTITY = registerItem("rifle_bullet_iron_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    public static final Item RIFLE_BULLET = registerItem("rifle_bullet", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item RIFLE_BULLET_ENTITY = registerItem("rifle_bullet_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    public static final Item GOLD_RIFLE_BULLET = registerItem("rifle_bullet_gold", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item GOLD_RIFLE_BULLET_ENTITY = registerItem("rifle_bullet_gold_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    //public static final Item RIFLE_INCENDIARY_BULLET = registerItem("rifle_bullet_incendiary", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    //public static final Item RIFLE_INCENDIARY_BULLET_ENTITY = registerItem("rifle_bullet_incendiary_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));


    public static final Item SHELL = registerItem("shell", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item SHELL_ENTITY = registerItem("shell_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    //the magnum just moves faster while dealing the same damage as the slugs
    public static final Item MAGNUM_SHELL = registerItem("shell_magnum", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item MAGNUM_SHELL_ENTITY = registerItem("shell_magnum_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    //the shorty shells move much slower, deal less damage, unless up close
    public static final Item SHORTY_SHELL = registerItem("shell_shorty", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item SHORTY_SHELL_ENTITY = registerItem("shell_shorty_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));

    //the slugs deal more damage moves abit slower
    public static final Item SLUG = registerItem("slug", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item SLUG_ENTITY = registerItem("slug_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    //heavy slugs move farther than slugs but do a bunch of damage (there used for long ranged hunting)
    public static final Item HEAVY_SLUG = registerItem("slug_heavy", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    public static final Item HEAVY_SLUG_ENTITY = registerItem("slug_heavy_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));
    //public static final Item INCENDIARY_SLUG = registerItem("slug_incendiary", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64)));
    //public static final Item INCENDIARY_SLUG_ENTITY = registerItem("slug_incendiary_entity", new BulletProjectileItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1)));

    //SPECIAL
    public static final Item GIANT_LOLLIPOP = registerToolItem("giant_lollipop", new GiantLollipopItem(GiantLolipopMaterial.INSTANCE, 9, -0F,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item CATCORN = registerToolItem("catcorn", new CatCornItem(CatcornMaterial.INSTANCE, 9, -0F,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item PIE = registerItem("pie", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item PIE_DAMAGE = registerItem("pie_damage", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item PIE_SUS = registerItem("pie_sus", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item LASER_POINTER_OFF = registerItem("laser_pointer_off", new LaserPointerItemOff(new FabricItemSettings().food(ShitFoodComponents.NOTHING).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item LASER_POINTER_ON = registerItem("laser_pointer_on", new LaserPointerItemOn(new FabricItemSettings().food(ShitFoodComponents.NOTHING).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item COSCO_BIG_LONG_DOG = registerItem("cosco_big_long_dog", new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item COSCO_BIG_LONG_DOG_MUSTARD = registerItem("cosco_big_long_dog_mustard", new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item COSCO_BIG_LONG_DOG_KETCHUP = registerItem("cosco_big_long_dog_ketchup", new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item BRASS_KNUCKLES = registerItem("brass_knuckles", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item SAIS = registerItem("sais", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item ZARSH_SCYTHE = registerToolItem("zarsh_scythe", new ZarshScytheItem(ZarshScytheMaterial.INSTANCE, 9, -0F, new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));

    //OTHER SHIT ITEMS
    public static final Item SOUND_BOARD = registerItem("sound_board", new SoundBoardItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON)));

    public static final Item MUSTARD = registerItem("mustard", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item KETCHUP = registerItem("ketchup", new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final Item COMPUTER_MOUSE = registerItem("computer_mouse", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item MASTERCARD_COMPUTER_MOUSE = registerItem("mastarcard_computer_mouse", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item TIN_FOIL = registerItem("tin_foil", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));

    //MUSIC DISCS
    public static final Item SILENT_HOUSES_MUSIC_DISC = registerItem("silent_houses_disc", new ShitMusicDiscItem(7, ShitSounds.SILENT_HOUSES, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 143));
    public static final Item FREE_BIRD_MUSIC_DISC = registerItem("free_bird_disc", new ShitMusicDiscItem(7, ShitSounds.FREE_BIRD_DISC, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 546));
    public static final Item AFTER_PARTY_MUSIC_DISC = registerItem("after_party", new ShitMusicDiscItem(7, ShitSounds.AFTER_PARTY_DISC, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 168));


    public static final Item VILLAGER_AFTERPARTY_MUSIC_DISC = registerItem("villager_afterparty", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_AFTERPARTY, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 166));
    public static final Item VILLAGER_ALLSTAR_MUSIC_DISC = registerItem("villager_allstar", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_ALLSTAR, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 197));
    public static final Item VILLAGER_BALLIN_MUSIC_DISC = registerItem("villager_ballin", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_BALLIN, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 180));
    public static final Item VILLAGER_BEGGIN_MUSIC_DISC = registerItem("villager_beggin", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_BEGGIN, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 213));
    public static final Item VILLAGER_BILLIEJEAN_MUSIC_DISC = registerItem("villager_billiejean", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_BILLIEJEAN, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 315));
    public static final Item VILLAGER_BUDDYHOLLY_MUSIC_DISC = registerItem("villager_buddyholly", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_BUDDYHOLLY, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 159));
    public static final Item VILLAGER_CUPID_MUSIC_DISC = registerItem("villager_cupid", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_CUPID, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 173));
    public static final Item VILLAGER_DONTSTOPMENOW_MUSIC_DISC = registerItem("villager_dontstopmenow", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_DONTSTOPMENOW, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 209));
    public static final Item VILLAGER_FIREFLIES_MUSIC_DISC = registerItem("villager_fireflies", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_FIREFLIES, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 229));
    public static final Item VILLAGER_FLYMETOTHEMOON_MUSIC_DISC = registerItem("villager_flymetothemoon", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_FLYMETOTHEMOON, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 149));
    public static final Item VILLAGER_FNAF_MUSIC_DISC = registerItem("villager_fnaf", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_FNAF, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 170));
    public static final Item VILLAGER_FREEBIRD_MUSIC_DISC = registerItem("villager_freebird", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_FREEBIRD, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 550));
    public static final Item VILLAGER_GANGSTAPARADISE_MUSIC_DISC = registerItem("villager_gangstaparadise", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_GANGSTAPARADISE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 231));
    public static final Item VILLAGER_GOLDENHOUR_MUSIC_DISC = registerItem("villager_goldenhour", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_GOLDENHOUR, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 209));
    public static final Item VILLAGER_HARDERBETTER_MUSIC_DISC = registerItem("villager_harderbetter", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_HARDERBETTER, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 226));
    public static final Item VILLAGER_HISWORLD_MUSIC_DISC = registerItem("villager_hisworld", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_HISWORLD, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 279));
    public static final Item VILLAGER_HOWBADCANIBE_MUSIC_DISC = registerItem("villager_howbadcanibe", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_HOWBADCANIBE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 168));
    public static final Item VILLAGER_LIFECOULDBEDREAMS_MUSIC_DISC = registerItem("villager_lifecouldbedreams", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_LIFECOULDBEDREAMS, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 145));
    public static final Item VILLAGER_MONSTER_MUSIC_DISC = registerItem("villager_monster", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_MONSTER, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 177));
    public static final Item VILLAGER_MYWAY_MUSIC_DISC = registerItem("villager_myway", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_MYWAY, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 276));
    public static final Item VILLAGER_OPPENGANGNAMSTYLE_MUSIC_DISC = registerItem("villager_oppengangnamstyle", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_OPPENGANGNAMSTYLE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 249));
    public static final Item VILLAGER_PEACHES_MUSIC_DISC = registerItem("villager_peaches", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_PEACHES, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 93));
    public static final Item VILLAGER_SCATMANSWORLD_MUSIC_DISC = registerItem("villager_scatmansworld", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_WHATISLOVE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 240));

    public static final Item VILLAGER_SMOOTHCRIMINAL_MUSIC_DISC = registerItem("villager_smoothcriminal", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_SMOOTHCRIMINAL, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 251));
    public static final Item VILLAGER_SOMEBODYIUSETOKNOW_MUSIC_DISC = registerItem("villager_somebodyiusetoknow", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_SOMEBODYIUSETOKNOW, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 244));
    public static final Item VILLAGER_TAKEONME_MUSIC_DISC = registerItem("villager_takeonme", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_TAKEONME, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 231));
    public static final Item VILLAGER_WHATISLOVE_MUSIC_DISC = registerItem("villager_whatislove", new ShitMusicDiscItem(7, ShitSounds.VILLAGER_WHATISLOVE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 240));



    //SMOKES
    public static final Item CIGAR = registerItem("cigar", new CigarItem(new FabricItemSettings().food(ShitFoodComponents.NOTHING).maxCount(1).rarity(Rarity.COMMON).maxDamage(12)));
    public static final Item CIGARETTE = registerItem("cigarette", new CigaretteItem(new FabricItemSettings().food(ShitFoodComponents.NOTHING).maxCount(1).rarity(Rarity.COMMON).maxDamage(12)));

    public static final Item CAMEL_BOX = registerItem("camel_box", new SmokesPackItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item MARLBORO_BOX = registerItem("marlboro_box", new SmokesPackItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));
    public static final Item NEWPORT_BOX = registerItem("newport_box", new SmokesPackItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON)));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RED_BRICK);
        entries.add(BLUE_BRICK);
    }


    //REGISTRY
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ShitMod.MOD_ID, name), item);
    }
    private static ToolItem registerToolItem(String name, Item item) {
        return (ToolItem) Registry.register(Registries.ITEM, new Identifier(ShitMod.MOD_ID, name), item);
    }
    public static void registerShitItems() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/item/ShitItems");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ShitItems::addItemsToIngredientItemGroup);
    }
    public static void registerCustomShitItems() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/item/ShitItems>custom");
    }
    public static void registerCustomPShitItems() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/item/ShitItems>custom/projectile");
    }
    public static void registerMaterialShitItems() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/item/ShitItems>material");
    }
}
