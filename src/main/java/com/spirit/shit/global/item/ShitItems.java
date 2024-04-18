package com.spirit.shit.global.item;

import com.spirit.Main;
import com.spirit.shit.global.item.custom.*;
import com.spirit.shit.global.item.custom.gun.*;
import com.spirit.shit.global.item.custom.projectile.*;
import com.spirit.shit.global.item.custom.projectile.beverage.*;
import com.spirit.shit.global.item.custom.projectile.beverage.BottleItem;
import com.spirit.shit.global.item.custom.projectile.bullet.BulletItem;
import com.spirit.shit.global.item.custom.projectile.bullet.RifleBulletItem;
import com.spirit.shit.global.item.custom.projectile.bullet.ShellItem;
import com.spirit.shit.global.item.custom.projectile.bullet.SlugItem;
import com.spirit.shit.global.item.material.CatcornMaterial;
import com.spirit.shit.global.item.material.GiantLolipopMaterial;
import com.spirit.shit.global.item.material.ZarshScytheMaterial;
import com.spirit.shit.global.sound.ShitSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ShitItems {

    //UNSORTED
    public static final Item RAW_BAUXITE = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));

    public static final Item ALUMINUM_INGOT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item ALUMINUM_NUGGET = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BOLT_BRONZE = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BOLT_GOLDEN = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BOLT_IRON = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BROKEN_ITEM = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BRONZE_INGOT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BRONZE_NUGGET = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHEMICAL_FLUID = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DOORKNOB_COPPER = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DOORKNOB_DIAMOND = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DOORKNOB_EMERALD = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DOORKNOB_GOLD = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DOORKNOB_IRON = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DOORKNOB_RUSTY = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DOORKNOB_STEEL = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DOORKNOB = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item GEARS = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item LEAD_INGOT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item LEAD_NUGGET = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item METAL_FRAGMENTS = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SAW_BRONZE = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SAW_CASTIRON = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SAW_GOLDEN = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SAW_IRON = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SCRAP = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SEPARATING_AGENT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SILICON = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SILVER_INGOT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SILVER_NUGGET = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item STRONG_CHEMICAL_FLUID = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item TARP = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item TECH_TRASH = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item WORN_TARP = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CLOTH_ROLL = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item PLASTIC_ROLL = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item RUBBER_ROLL = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BLACK_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item BLUE_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item BROWN_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item CYAN_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item GRAY_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item GREEN_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item LIGHT_BLUE_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item LIGHT_GRAY_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item LIME_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item MAGENTA_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item ORANGE_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item PINK_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item PURPLE_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item RED_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item WHITE_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item YELLOW_GROAN_TUBE = new GroanTubeItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item RUBBER_CHICKEN = new RubberChickenItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item AIR_HORN = new AirHornItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item BIKE_HORN = new BikeHornItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item CLOWN_HORN = new ClownHornItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));

    public static final Item RED_BRICK = new RedBrickProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item BLUE_BRICK = new BlueBrickProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item TRASH_CAN = new TrashCanProjectileItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item OAT = new OatProjectileItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BANANA = new Item(new FabricItemSettings().food(ShitFoodComponents.BANANA).maxCount(64).rarity(Rarity.COMMON));
    public static final Item POCKY_STICK = new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICK).maxCount(64).rarity(Rarity.COMMON));
    public static final Item POCKY_STICKS = new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICKS).maxCount(32).rarity(Rarity.COMMON));
    public static final Item POCKY_STICK_BOX = new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICK_BOX).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NACHO_DORITOS_CHIP = new DoritosChipItem(new FabricItemSettings().food(ShitFoodComponents.DORITOS_CHIP).maxCount(64).rarity(Rarity.COMMON));
    public static final Item NACHO_DORITOS_BAG = new Item(new FabricItemSettings().food(ShitFoodComponents.DORITOS_BAG).maxCount(64).rarity(Rarity.COMMON));
    public static final Item HORSE_HOOF = new Item(new FabricItemSettings().food(ShitFoodComponents.HORSE_HOOF).maxCount(64).rarity(Rarity.COMMON));
    public static final Item RAW_CHEVALINE = new Item(new FabricItemSettings().food(ShitFoodComponents.RAW_CHEVALINE).maxCount(64).rarity(Rarity.COMMON));
    public static final Item COOKED_CHEVALINE = new Item(new FabricItemSettings().food(ShitFoodComponents.COOKED_CHEVALINE).maxCount(64).rarity(Rarity.COMMON));
    public static final Item TALON_BURGER = new Item(new FabricItemSettings().food(ShitFoodComponents.TALON_BURGER).maxCount(64).rarity(Rarity.COMMON));
    public static final Item URANIUM_DUST = new UraniumItem(new FabricItemSettings().food(ShitFoodComponents.URANIUM_DUST).maxCount(64).rarity(Rarity.COMMON));
    public static final Item PEEP_YELLOW = new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_YELLOW).maxCount(1).rarity(Rarity.COMMON));
    public static final Item PEEP_CYAN = new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_CYAN).maxCount(1).rarity(Rarity.COMMON));
    public static final Item PEEP_PINK = new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_PINK).maxCount(1).rarity(Rarity.COMMON));
    public static final Item PEEP_PURPLE = new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_PURPLE).maxCount(1).rarity(Rarity.COMMON));
    public static final Item BEER = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item BEER_BOTTLE = new BeerBottleProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item BONK_ATOMIC_PUNCH = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item BONK_ATOMIC_PUNCH_PROJECTILE = new BonkAtomicPunchProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item BOTTLE = new BottleItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item BUD_LIGHT = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item BUD_LIGHT_CAN = new BudLightCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CHAMPAGNE = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CHAMPAGNE_BOTTLE = new ChampagneBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CHUG_JUG = new Item(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CHUG_JUG_EMPTY = new ChugJugProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COCA_COLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COCA_COLA_CAN = new CocaColaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COKE_ZERO = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COKE_ZERO_CAN = new CokeZeroCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CRITA_COLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CRITA_COLA_CAN = new CritaColaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item DR_PEPPER = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item DR_PEPPER_CAN = new DrPepperCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item FANTA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item FANTA_CAN = new FantaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item FLASK = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.FLASK).maxCount(16).rarity(Rarity.COMMON));
    public static final Item FLASK_EMPTY = new FlaskProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item GLASS_JAR = new GlassJarProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item LAGAR = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item LAGAR_BOTTLE = new LagarBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MILK_CARTON = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MILK_CARTON_EMPTY = new MilkCartonProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MOUNTAIN_DEW = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MOUNTAIN_DEW_CAN = new MountainDewCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COFFEE = new Item(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MUG = new MugItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item MUG_ROOT_BEER = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MUG_ROOT_BEER_CAN = new MugRootBeerCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_BOTTLE = new NukaColaBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_DARK = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_DARK_BOTTLE = new NukaColaDarkBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_QUANTUM = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_QUANTUM_BOTTLE = new NukaColaQuantumBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PEEPS_PEPSI = new PeepsPepsiItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PEEPS_PEPSI_CAN = new PeepsPepsiCanProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item PEPSI = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PEPSI_CAN = new PepsiCanProjectileItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item RUM = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item RUM_BOTTLE = new RumBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_BLUEBERRYTART = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_BLUEBERRYTART_CAN = new ShizeBlueBerryTartCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_BLUSHINGROSE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_BLUSHINGROSE_CAN = new ShizeBlushingRoseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CANADASHY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CANADASHY_CAN = new ShizeCanadaShyCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CHEEKYBITOPUD = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CHEEKYBITOPUD_CAN = new ShizeCheekyBitoPudCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CHERRYPOP = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CHERRYPOP_CAN = new ShizeCherryPopCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_COLDBEETSTEW = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_COLDBEETSTEW_CAN = new ShizeColdBeetStewCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_ELDERFLOWER = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_ELDERFLOWER_CAN = new ShizeElderFlowerCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FACTORYRUST = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FACTORYRUST_CAN = new ShizeFactoryRustCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FOURCHEESE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FOURCHEESE_CAN = new ShizeFourCheeseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FRENCHVANILLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FRENCHVANILLA_CAN = new ShizeFrenchVanillaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FULMEDAMES = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FULMEDAMES_CAN = new ShizeFulmedamesCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_GAMERENERGY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_GAMERENERGY_CAN = new ShizeGamerEnergyCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_JELLYBEAN = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_JELLYBEAN_CAN = new ShizeJellyBeanCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_JUICYMELON = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_JUICYMELON_CAN = new ShizeJuicyMelonCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LEMONPARTY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LEMONPARTY_CAN = new ShizeLemonPartyCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LIGHT = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LIGHT_CAN = new ShizeLightCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LIQUORLISIOUS = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LIQUORLISIOUS_CAN = new ShizeLiquorLisiousCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_MAYONNAISE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_MAYONNAISE_CAN = new ShizeMayonnaiseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_MUSTARD = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_MUSTARD_CAN = new ShizeMustardCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_ORIGINAL = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_ORIGINAL_CAN = new ShizeOriginalCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_PINEAPPLEPIZZA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_PINEAPPLEPIZZA_CAN = new ShizePineapplePizzaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_RAWMEAT = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_RAWMEAT_CAN = new ShizeRawMeatCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_SARDINESURPRISE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_SARDINESURPRISE_CAN = new ShizeSardineSurpriseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_STRAWBERRYKIWI = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_STRAWBERRYKIWI_CAN = new ShizeStrawberryKiwiCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TANGYKETCHUP = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TANGYKETCHUP_CAN = new ShizeTangyKetchupCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TAROTEASE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TAROTEASE_CAN = new ShizeTaroTeaseCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_THIRSTBORN = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_THIRSTBORN_CAN = new ShizeThirstBornCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TIRAMISU = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TIRAMISU_CAN = new ShizeTiramisuCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TROPICALSTORM = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TROPICALSTORM_CAN = new ShizeTropicalStormCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_VEGGIEBROTH = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_VEGGIEBROTH_CAN = new ShizeVeggieBrothCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item STRAWBERRY_MILK_CARTON = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item STRAWBERRY_MILK_CARTON_EMPTY = new StrawberryMilkCartonProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item VODKA = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item VODKA_BOTTLE = new VodkaBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item WINE = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item WINE_BOTTLE = new WineBottleProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item WINE_GLASS = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item WINE_GLASS_EMPTY = new WineGlassProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SPEED_COLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SPEED_COLA_CAN = new SpeedColaCanProjectileItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CHOCOLATE_OREO_SHAKE = new ChocolateOreoShakeItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_YELLOW).maxCount(1).rarity(Rarity.COMMON));
    public static final Item GRIMACE_SHAKE = new ChocolateOreoShakeItem(new FabricItemSettings().food(ShitFoodComponents.PEEP_YELLOW).maxCount(1).rarity(Rarity.COMMON));
    public static final Item BULLET = new BulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item RIFLE_BULLET = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SHELL = new ShellItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SLUG = new SlugItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item AK47 = new AK47Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item DOUBLE_BARREL = new DoubleBarrelItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item FNP90 = new fnp90Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item FNP90SCOPE = new fnp90scopeItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item GLOCK17 = new Glock17Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item M16 = new M16Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item M1_GARAND = new M1GarandItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item REVOLVER = new RevolverItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item GOLDEN_REVOLVER = new GoldenRevolverItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item SAWED_OFF = new SawedOffItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item STRIKER_12 = new Striker12Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item GIANT_LOLLIPOP = new GiantLollipopItem(GiantLolipopMaterial.INSTANCE, 9, -0F, new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item CATCORN = new CatCornItem(CatcornMaterial.INSTANCE, 9, -0F, new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item PIE = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item PIE_DAMAGE = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item PIE_SUS = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item LASER_POINTER = new LaserPointerItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item COSCO_BIG_LONG_DOG = new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON));
    public static final Item COSCO_BIG_LONG_DOG_MUSTARD = new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON));
    public static final Item COSCO_BIG_LONG_DOG_KETCHUP = new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON));
    public static final Item BRASS_KNUCKLES = new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item SAIS = new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item ZARSH_SCYTHE = new ZarshScytheItem(ZarshScytheMaterial.INSTANCE, 9, -0F, new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item SOUND_BOARD = new SoundBoardItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item MUSTARD = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item KETCHUP = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item TIN_FOIL = new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item SILENT_HOUSES_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.SILENT_HOUSES, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 143);
    public static final Item FREE_BIRD_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.FREE_BIRD_DISC, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 546);
    public static final Item AFTER_PARTY_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.AFTER_PARTY_DISC, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 168);
    public static final Item VILLAGER_AFTERPARTY_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_AFTERPARTY, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 166);
    public static final Item VILLAGER_ALLSTAR_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_ALLSTAR, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 197);
    public static final Item VILLAGER_BALLIN_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_BALLIN, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 180);
    public static final Item VILLAGER_BEGGIN_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_BEGGIN, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 213);
    public static final Item VILLAGER_BILLIEJEAN_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_BILLIEJEAN, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 315);
    public static final Item VILLAGER_BUDDYHOLLY_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_BUDDYHOLLY, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 159);
    public static final Item VILLAGER_CUPID_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_CUPID, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 173);
    public static final Item VILLAGER_DONTSTOPMENOW_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_DONTSTOPMENOW, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 209);
    public static final Item VILLAGER_FIREFLIES_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_FIREFLIES, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 229);
    public static final Item VILLAGER_FLYMETOTHEMOON_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_FLYMETOTHEMOON, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 149);
    public static final Item VILLAGER_FNAF_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_FNAF, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 170);
    public static final Item VILLAGER_FREEBIRD_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_FREEBIRD, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 55);
    public static final Item VILLAGER_GANGSTAPARADISE_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_GANGSTAPARADISE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 231);
    public static final Item VILLAGER_GOLDENHOUR_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_GOLDENHOUR, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 209);
    public static final Item VILLAGER_HARDERBETTER_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_HARDERBETTER, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 226);
    public static final Item VILLAGER_HISWORLD_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_HISWORLD, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 279);
    public static final Item VILLAGER_HOWBADCANIBE_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_HOWBADCANIBE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 168);
    public static final Item VILLAGER_LIFECOULDBEDREAMS_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_LIFECOULDBEDREAMS, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 145);
    public static final Item VILLAGER_MONSTER_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_MONSTER, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 177);
    public static final Item VILLAGER_MYWAY_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_MYWAY, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 276);
    public static final Item VILLAGER_OPPENGANGNAMSTYLE_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_OPPENGANGNAMSTYLE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 249);
    public static final Item VILLAGER_PEACHES_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_PEACHES, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 93);
    public static final Item VILLAGER_SCATMANSWORLD_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_WHATISLOVE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 240);
    public static final Item VILLAGER_SMOOTHCRIMINAL_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_SMOOTHCRIMINAL, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 251);
    public static final Item VILLAGER_SOMEBODYIUSETOKNOW_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_SOMEBODYIUSETOKNOW, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 244);
    public static final Item VILLAGER_TAKEONME_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_TAKEONME, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 231);
    public static final Item VILLAGER_WHATISLOVE_MUSIC_DISC = new MusicDiscItem(7, ShitSounds.VILLAGER_WHATISLOVE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 240);
    public static final Item CIGAR = new CigarItem(new FabricItemSettings().food(ShitFoodComponents.NOTHING).maxCount(1).rarity(Rarity.COMMON).maxDamage(12));
    public static final Item CIGARETTE = new CigaretteItem(new FabricItemSettings().food(ShitFoodComponents.NOTHING).maxCount(1).rarity(Rarity.COMMON).maxDamage(12));
    public static final Item CAMEL_BOX = new SmokesPackItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item MARLBORO_BOX = new SmokesPackItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item NEWPORT_BOX = new SmokesPackItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));

    static Map<String, Object> ITEMS = Stream.of(new Object[][] {

            //UNSORTED
            {"raw_bauxite", RAW_BAUXITE},



            {"aluminum_ingot", ALUMINUM_INGOT},
            {"aluminum_nugget", ALUMINUM_NUGGET},
            {"bolt_bronze", BOLT_BRONZE},
            {"bolt_golden", BOLT_GOLDEN},
            {"bolt_iron", BOLT_IRON},
            {"broken_item", BROKEN_ITEM},
            {"bronze_ingot", BRONZE_INGOT},
            {"bronze_nugget", BRONZE_NUGGET},
            {"chemical_fluid", CHEMICAL_FLUID},
            {"doorknob_copper", DOORKNOB_COPPER},
            {"doorknob_diamond", DOORKNOB_DIAMOND},
            {"doorknob_emerald", DOORKNOB_EMERALD},
            {"doorknob_gold", DOORKNOB_GOLD},
            {"doorknob_iron", DOORKNOB_IRON},
            {"doorknob_rusty", DOORKNOB_RUSTY},
            {"doorknob_steel", DOORKNOB_STEEL},
            {"doorknob", DOORKNOB},
            {"gears", GEARS},
            {"lead_ingot", LEAD_INGOT},
            {"lead_nugget", LEAD_NUGGET},
            {"metal_fragments", METAL_FRAGMENTS},
            {"saw_bronze", SAW_BRONZE},
            {"saw_castiron", SAW_CASTIRON},
            {"saw_golden", SAW_GOLDEN},
            {"saw_iron", SAW_IRON},
            {"scrap", SCRAP},
            {"separating_agent", SEPARATING_AGENT},
            {"silicon", SILICON},
            {"silver_ingot", SILVER_INGOT},
            {"silver_nugget", SILVER_NUGGET},
            {"strong_chemical_fluid", STRONG_CHEMICAL_FLUID},
            {"tarp", TARP},
            {"tech_trash", TECH_TRASH},
            {"worn_tarp", WORN_TARP},
            {"cloth_roll", CLOTH_ROLL},
            {"plastic_roll", PLASTIC_ROLL},
            {"rubber_roll", RUBBER_ROLL},
            {"groan_tube_black", BLACK_GROAN_TUBE},
            {"groan_tube_blue", BLUE_GROAN_TUBE},
            {"groan_tube_brown", BROWN_GROAN_TUBE},
            {"groan_tube_cyan", CYAN_GROAN_TUBE},
            {"groan_tube_gray", GRAY_GROAN_TUBE},
            {"groan_tube_green", GREEN_GROAN_TUBE},
            {"groan_tube_light_blue", LIGHT_BLUE_GROAN_TUBE},
            {"groan_tube_light_gray", LIGHT_GRAY_GROAN_TUBE},
            {"groan_tube_lime", LIME_GROAN_TUBE},
            {"groan_tube_magenta", MAGENTA_GROAN_TUBE},
            {"groan_tube_orange", ORANGE_GROAN_TUBE},
            {"groan_tube_pink", PINK_GROAN_TUBE},
            {"groan_tube_purple", PURPLE_GROAN_TUBE},
            {"groan_tube_red", RED_GROAN_TUBE},
            {"groan_tube_white", WHITE_GROAN_TUBE},
            {"groan_tube_yellow", YELLOW_GROAN_TUBE},
            {"rubber_chicken", RUBBER_CHICKEN},
            {"air_horn", AIR_HORN},
            {"bike_horn", BIKE_HORN},
            {"clown_horn", CLOWN_HORN},
            {"red_brick", RED_BRICK},
            {"blue_brick", BLUE_BRICK},
            {"trash_can", TRASH_CAN},
            {"oat", OAT},
            {"banana", BANANA},
            {"pocky_stick", POCKY_STICK},
            {"pocky_sticks", POCKY_STICKS},
            {"pocky_stick_box", POCKY_STICK_BOX},
            {"nacho_dorito_chip", NACHO_DORITOS_CHIP},
            {"nacho_dorito_bag", NACHO_DORITOS_BAG},
            {"horse_hoof", HORSE_HOOF},
            {"raw_chevaline", RAW_CHEVALINE},
            {"cooked_chevaline", COOKED_CHEVALINE},
            {"talon_burger", TALON_BURGER},
            {"uranium_dust", URANIUM_DUST},
            {"peep_yellow", PEEP_YELLOW},
            {"peep_cyan", PEEP_CYAN},
            {"peep_pink", PEEP_PINK},
            {"peep_purple", PEEP_PURPLE},
            {"beer", BEER},
            {"beer_bottle", BEER_BOTTLE},
            {"bonk_atomic_punch", BONK_ATOMIC_PUNCH},
            {"bonk_atomic_punch_projectile", BONK_ATOMIC_PUNCH_PROJECTILE},
            {"bottle", BOTTLE},
            {"bud_light", BUD_LIGHT},
            {"bud_light_can", BUD_LIGHT_CAN},
            {"champagne", CHAMPAGNE},
            {"champagne_bottle", CHAMPAGNE_BOTTLE},
            {"chug_jug", CHUG_JUG},
            {"chug_jug_empty", CHUG_JUG_EMPTY},
            {"coca_cola", COCA_COLA},
            {"coca_cola_can", COCA_COLA_CAN},
            {"coke_zero", COKE_ZERO},
            {"coke_zero_can", COKE_ZERO_CAN},
            {"crita_cola", CRITA_COLA},
            {"crita_cola_can", CRITA_COLA_CAN},
            {"dr_pepper", DR_PEPPER},
            {"dr_pepper_can", DR_PEPPER_CAN},
            {"fanta", FANTA},
            {"fanta_can", FANTA_CAN},
            {"flask", FLASK},
            {"flask_empty", FLASK_EMPTY},
            {"glass_jar", GLASS_JAR},
            {"lagar", LAGAR},
            {"lagar_bottle", LAGAR_BOTTLE},
            {"milk_carton", MILK_CARTON},
            {"milk_carton_empty", MILK_CARTON_EMPTY},
            {"mountain_dew", MOUNTAIN_DEW},
            {"mountain_dew_can", MOUNTAIN_DEW_CAN},
            {"coffee", COFFEE},
            {"mug", MUG},
            {"mug_root_beer", MUG_ROOT_BEER},
            {"mug_root_beer_can", MUG_ROOT_BEER_CAN},
            {"nuka_cola", NUKA_COLA},
            {"nuka_cola_bottle", NUKA_COLA_BOTTLE},
            {"nuka_cola_dark", NUKA_COLA_DARK},
            {"nuka_cola_dark_bottle", NUKA_COLA_DARK_BOTTLE},
            {"nuka_cola_quantum", NUKA_COLA_QUANTUM},
            {"nuka_cola_quantum_bottle", NUKA_COLA_QUANTUM_BOTTLE},
            {"peeps_pepsi", PEEPS_PEPSI},
            {"peeps_pepsi_can", PEEPS_PEPSI_CAN},
            {"pepsi", PEPSI},
            {"pepsi_can", PEPSI_CAN},
            {"rum", RUM},
            {"rum_bottle", RUM_BOTTLE},
            {"shize_blueberrytart", SHIZE_BLUEBERRYTART},
            {"shize_blueberrytart_can", SHIZE_BLUEBERRYTART_CAN},
            {"shize_blushingrose", SHIZE_BLUSHINGROSE},
            {"shize_blushingrose_can", SHIZE_BLUSHINGROSE_CAN},
            {"shize_canadashy", SHIZE_CANADASHY},
            {"shize_canadashy_can", SHIZE_CANADASHY_CAN},
            {"shize_cheekybitopud", SHIZE_CHEEKYBITOPUD},
            {"shize_cheekybitopud_can", SHIZE_CHEEKYBITOPUD_CAN},
            {"shize_cherrypop", SHIZE_CHERRYPOP},
            {"shize_cherrypop_can", SHIZE_CHERRYPOP_CAN},
            {"shize_coldbeetstew", SHIZE_COLDBEETSTEW},
            {"shize_coldbeetstew_can", SHIZE_COLDBEETSTEW_CAN},
            {"shize_elderflower", SHIZE_ELDERFLOWER},
            {"shize_elderflower_can", SHIZE_ELDERFLOWER_CAN},
            {"shize_factoryrust", SHIZE_FACTORYRUST},
            {"shize_factoryrust_can", SHIZE_FACTORYRUST_CAN},
            {"shize_fourcheese", SHIZE_FOURCHEESE},
            {"shize_fourcheese_can", SHIZE_FOURCHEESE_CAN},
            {"shize_frenchvanilla", SHIZE_FRENCHVANILLA},
            {"shize_frenchvanilla_can", SHIZE_FRENCHVANILLA_CAN},
            {"shize_fulmedames", SHIZE_FULMEDAMES},
            {"shize_fulmedames_can", SHIZE_FULMEDAMES_CAN},
            {"shize_gamerenergy", SHIZE_GAMERENERGY},
            {"shize_gamerenergy_can", SHIZE_GAMERENERGY_CAN},
            {"shize_jellybean", SHIZE_JELLYBEAN},
            {"shize_jellybean_can", SHIZE_JELLYBEAN_CAN},
            {"shize_juicymelon", SHIZE_JUICYMELON},
            {"shize_juicymelon_can", SHIZE_JUICYMELON_CAN},
            {"shize_lemonparty", SHIZE_LEMONPARTY},
            {"shize_lemonparty_can", SHIZE_LEMONPARTY_CAN},
            {"shize_light", SHIZE_LIGHT},
            {"shize_light_can", SHIZE_LIGHT_CAN},
            {"shize_liquorlisious", SHIZE_LIQUORLISIOUS},
            {"shize_liquorlisious_can", SHIZE_LIQUORLISIOUS_CAN},
            {"shize_mayonnaise", SHIZE_MAYONNAISE},
            {"shize_mayonnaise_can", SHIZE_MAYONNAISE_CAN},
            {"shize_mustard", SHIZE_MUSTARD},
            {"shize_mustard_can", SHIZE_MUSTARD_CAN},
            {"shize_original", SHIZE_ORIGINAL},
            {"shize_original_can", SHIZE_ORIGINAL_CAN},
            {"shize_pineapplepizza", SHIZE_PINEAPPLEPIZZA},
            {"shize_pineapplepizza_can", SHIZE_PINEAPPLEPIZZA_CAN},
            {"shize_rawmeat", SHIZE_RAWMEAT},
            {"shize_rawmeat_can", SHIZE_RAWMEAT_CAN},
            {"shize_sardinesurprise", SHIZE_SARDINESURPRISE},
            {"shize_sardinesurprise_can", SHIZE_SARDINESURPRISE_CAN},
            {"shize_strawberrykiwi", SHIZE_STRAWBERRYKIWI},
            {"shize_strawberrykiwi_can", SHIZE_STRAWBERRYKIWI_CAN},
            {"shize_tangyketchup", SHIZE_TANGYKETCHUP},
            {"shize_tangyketchup_can", SHIZE_TANGYKETCHUP_CAN},
            {"shize_tarotease", SHIZE_TAROTEASE},
            {"shize_tarotease_can", SHIZE_TAROTEASE_CAN},
            {"shize_thirstborn", SHIZE_THIRSTBORN},
            {"shize_thirstborn_can", SHIZE_THIRSTBORN_CAN},
            {"shize_tiramisu", SHIZE_TIRAMISU},
            {"shize_tiramisu_can", SHIZE_TIRAMISU_CAN},
            {"shize_tropicalstorm", SHIZE_TROPICALSTORM},
            {"shize_tropicalstorm_can", SHIZE_TROPICALSTORM_CAN},
            {"shize_veggiebroth", SHIZE_VEGGIEBROTH},
            {"shize_veggiebroth_can", SHIZE_VEGGIEBROTH_CAN},
            {"strawberry_milk_carton", STRAWBERRY_MILK_CARTON},
            {"strawberry_milk_carton_empty", STRAWBERRY_MILK_CARTON_EMPTY},
            {"vodka", VODKA},
            {"vodka_bottle", VODKA_BOTTLE},
            {"wine", WINE},
            {"wine_bottle", WINE_BOTTLE},
            {"wine_glass", WINE_GLASS},
            {"wine_glass_empty", WINE_GLASS_EMPTY},
            {"speed_cola", SPEED_COLA},
            {"speed_cola_can", SPEED_COLA_CAN},
            {"chocolate_oreo_shake", CHOCOLATE_OREO_SHAKE},
            {"grimace_shake", GRIMACE_SHAKE},
            {"bullet", BULLET},
            {"rifle_bullet", RIFLE_BULLET},
            {"shell", SHELL},
            {"slug", SLUG},
            {"ak47", AK47},
            {"double_barrel", DOUBLE_BARREL},
            {"fnp_90", FNP90},
            {"fnp_90_scope", FNP90SCOPE},
            {"glock_17", GLOCK17},
            {"m16", M16},
            {"m1_garand", M1_GARAND},
            {"revolver", REVOLVER},
            {"revolver_golden", GOLDEN_REVOLVER},
            {"sawed_off", SAWED_OFF},
            {"striker_12", STRIKER_12},
            {"pie", PIE},
            {"pie_damage", PIE_DAMAGE},
            {"pie_sus", PIE_SUS},
            {"laser_pointer", LASER_POINTER},
            {"cosco_big_long_dog", COSCO_BIG_LONG_DOG},
            {"cosco_big_long_dog_mustard", COSCO_BIG_LONG_DOG_MUSTARD},
            {"cosco_big_long_dog_ketchup", COSCO_BIG_LONG_DOG_KETCHUP},
            {"brass_knuckles", BRASS_KNUCKLES},
            {"sais", SAIS},
            {"sound_board", SOUND_BOARD},
            {"mustard", MUSTARD},
            {"ketchup", KETCHUP},
            {"tin_foil", TIN_FOIL},
            {"silent_houses_disc", SILENT_HOUSES_MUSIC_DISC},
            {"free_bird_disc", FREE_BIRD_MUSIC_DISC},
            {"after_party", AFTER_PARTY_MUSIC_DISC},
            {"villager_afterparty", VILLAGER_AFTERPARTY_MUSIC_DISC},
            {"villager_allstar", VILLAGER_ALLSTAR_MUSIC_DISC},
            {"villager_ballin", VILLAGER_BALLIN_MUSIC_DISC},
            {"villager_beggin", VILLAGER_BEGGIN_MUSIC_DISC},
            {"villager_billiejean", VILLAGER_BILLIEJEAN_MUSIC_DISC},
            {"villager_buddyholly", VILLAGER_BUDDYHOLLY_MUSIC_DISC},
            {"villager_cupid", VILLAGER_CUPID_MUSIC_DISC},
            {"villager_dontstopmenow", VILLAGER_DONTSTOPMENOW_MUSIC_DISC},
            {"villager_fireflies", VILLAGER_FIREFLIES_MUSIC_DISC},
            {"villager_flymetothemoon", VILLAGER_FLYMETOTHEMOON_MUSIC_DISC},
            {"villager_fnaf", VILLAGER_FNAF_MUSIC_DISC},
            {"villager_freebird", VILLAGER_FREEBIRD_MUSIC_DISC},
            {"villager_gangstaparadise", VILLAGER_GANGSTAPARADISE_MUSIC_DISC},
            {"villager_goldenhour", VILLAGER_GOLDENHOUR_MUSIC_DISC},
            {"villager_harderbetter", VILLAGER_HARDERBETTER_MUSIC_DISC},
            {"villager_hisworld", VILLAGER_HISWORLD_MUSIC_DISC},
            {"villager_howbadcanibe", VILLAGER_HOWBADCANIBE_MUSIC_DISC},
            {"villager_lifecouldbedreams", VILLAGER_LIFECOULDBEDREAMS_MUSIC_DISC},
            {"villager_monster", VILLAGER_MONSTER_MUSIC_DISC},
            {"villager_myway", VILLAGER_MYWAY_MUSIC_DISC},
            {"villager_oppengangnamstyle", VILLAGER_OPPENGANGNAMSTYLE_MUSIC_DISC},
            {"villager_peaches", VILLAGER_PEACHES_MUSIC_DISC},
            {"villager_scatmansworld", VILLAGER_SCATMANSWORLD_MUSIC_DISC},
            {"villager_smoothcriminal", VILLAGER_SMOOTHCRIMINAL_MUSIC_DISC},
            {"villager_somebodyiusetoknow", VILLAGER_SOMEBODYIUSETOKNOW_MUSIC_DISC},
            {"villager_takeonme", VILLAGER_TAKEONME_MUSIC_DISC},
            {"villager_whatislove", VILLAGER_WHATISLOVE_MUSIC_DISC},
            {"cigar", CIGAR},
            {"cigarette", CIGARETTE},
            {"camel_box", CAMEL_BOX},
            {"marlboro_box", MARLBORO_BOX},
            {"newport_box", NEWPORT_BOX},
    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));


    public static void registerAll() {
        for (Map.Entry<String, Object> entry : ITEMS.entrySet()) {
            String key = entry.getKey();
            Item value = (Item) entry.getValue();

            registerItem(key, value);
        }
        registerToolItem("giant_lollipop", GIANT_LOLLIPOP);
        registerToolItem("catcorn", CATCORN);
        registerToolItem("zarsh_scythe", ZARSH_SCYTHE);
    }


    // Don't suppress, this is actually a valid warning
    //private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    //    entries.add(RED_BRICK);
    //    entries.add(BLUE_BRICK);
   // }

    //REGISTRY
    private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.SHIT_ID, name), item);
    }
    private static void registerToolItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.SHIT_ID, name), item);
    }
}
