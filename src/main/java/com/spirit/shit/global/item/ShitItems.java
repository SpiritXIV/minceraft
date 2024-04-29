package com.spirit.shit.global.item;

import com.spirit.Main;
import com.spirit.shit.global.item.custom.*;
import com.spirit.shit.global.item.custom.gun.*;
import com.spirit.shit.global.item.custom.projectile.TrashCanProjectileItem;
import com.spirit.shit.global.item.custom.projectile.bullet.BulletItem;
import com.spirit.shit.global.item.custom.projectile.bullet.RifleBulletItem;
import com.spirit.shit.global.item.custom.projectile.bullet.ShellItem;
import com.spirit.shit.global.item.custom.projectile.bullet.SlugItem;
import com.spirit.shit.global.item.material.CatcornMaterial;
import com.spirit.shit.global.item.material.GiantLolipopMaterial;
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
    public static final Item TRASH_CAN = new TrashCanProjectileItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item BANANA = new Item(new FabricItemSettings().food(ShitFoodComponents.BANANA).maxCount(64).rarity(Rarity.COMMON));
    public static final Item POCKY_STICK = new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICK).maxCount(64).rarity(Rarity.COMMON));
    public static final Item POCKY_STICKS = new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICKS).maxCount(32).rarity(Rarity.COMMON));
    public static final Item POCKY_STICK_BOX = new Item(new FabricItemSettings().food(ShitFoodComponents.POCKY_STICK_BOX).maxCount(16).rarity(Rarity.COMMON));
    public static final Item URANIUM_DUST = new UraniumItem(new FabricItemSettings().food(ShitFoodComponents.URANIUM_DUST).maxCount(64).rarity(Rarity.COMMON));
    public static final Item PEEP_YELLOW = new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP).maxCount(1).rarity(Rarity.COMMON));
    public static final Item PEEP_CYAN = new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP).maxCount(1).rarity(Rarity.COMMON));
    public static final Item PEEP_PINK = new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP).maxCount(1).rarity(Rarity.COMMON));
    public static final Item PEEP_PURPLE = new PeepsItem(new FabricItemSettings().food(ShitFoodComponents.PEEP).maxCount(1).rarity(Rarity.COMMON));
    public static final Item BEER = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item BONK_ATOMIC_PUNCH = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item BOTTLE = new BottleItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON));
    public static final Item BUD_LIGHT = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CHAMPAGNE = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CHUG_JUG = new Item(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COCA_COLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COKE_ZERO = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COKE_HEART_THROB = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CRITA_COLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item DR_PEPPER = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item DR_PEPPER_DIET = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item FANTA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item FLASK = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.FLASK).maxCount(16).rarity(Rarity.COMMON));
    public static final Item LAGAR = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MILK_CARTON = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MOUNTAIN_DEW = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item COFFEE = new Item(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MUG_ROOT_BEER = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_DARK = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_QUANTUM = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_CHERRY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_CIDE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_GRAPE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_LOVE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_ORANGE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_QUARTZ = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_VICTORY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item NUKA_COLA_WILD = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PRIME_ENERGY_BLUERASPBERRY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PRIME_ENERGY_LEMONLIME = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PRIME_ENERGY_ORANGEMANGO = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PRIME_ENERGY_STRAWBERRYWATERMELON = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PRIME_ENERGY_TROPICALPUNCH = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item MONSTER_ENERGY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item REDBULL = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PEEPS_PEPSI = new PeepsPepsiItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item PEPSI = new PepsiItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item RUM = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_BLUEBERRYTART = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_BLUSHINGROSE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CANADASHY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CHEEKYBITOPUD = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_CHERRYPOP = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_COLDBEETSTEW = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_ELDERFLOWER = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FACTORYRUST = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FOURCHEESE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FRENCHVANILLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_FULMEDAMES = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_GAMERENERGY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_JELLYBEAN = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_JUICYMELON = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LEMONPARTY = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LIGHT = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_LIQUORLISIOUS = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_MAYONNAISE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_MUSTARD = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_ORIGINAL = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_PINEAPPLEPIZZA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_RAWMEAT = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_SARDINESURPRISE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_STRAWBERRYKIWI = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TANGYKETCHUP = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TAROTEASE = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_THIRSTBORN = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TIRAMISU = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_TROPICALSTORM = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SHIZE_VEGGIEBROTH = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item STRAWBERRY_MILK_CARTON = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item VODKA = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item WINE = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item WINE_GLASS = new AlcoholicBeveragesItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item SPEED_COLA = new SodaItem(new FabricItemSettings().food(ShitFoodComponents.SODA).maxCount(16).rarity(Rarity.COMMON));
    public static final Item CHOCOLATE_OREO_SHAKE = new ChocolateOreoShakeItem(new FabricItemSettings().food(ShitFoodComponents.PEEP).maxCount(1).rarity(Rarity.COMMON));
    public static final Item GRIMACE_SHAKE = new ChocolateOreoShakeItem(new FabricItemSettings().food(ShitFoodComponents.PEEP).maxCount(1).rarity(Rarity.COMMON));
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
    public static final Item COSCO_BIG_LONG_DOG = new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON));
    public static final Item COSCO_BIG_LONG_DOG_MUSTARD = new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON));
    public static final Item COSCO_BIG_LONG_DOG_KETCHUP = new CoscoBigLongDogItem(new FabricItemSettings().food(ShitFoodComponents.COSCO_BIG_DOG).maxCount(1).rarity(Rarity.COMMON));
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
    public static final Item ONE_MOMEN = new MomenItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON), 1);
    public static final Item FIVE_MOMEN = new MomenItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON), 5);
    public static final Item TEN_MOMEN = new MomenItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON), 10);
    public static final Item TWENTY_MOMEN = new MomenItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON), 20);
    public static final Item FIFTY_MOMEN = new MomenItem(new FabricItemSettings().maxCount(64).rarity(Rarity.RARE), 50);
    public static final Item ONEHUNDRED_MOMEN = new MomenItem(new FabricItemSettings().maxCount(64).rarity(Rarity.EPIC), 100);
    public static final Item FIVEHUNDRED_MOMEN = new MomenItem(new FabricItemSettings().maxCount(64).rarity(Rarity.EPIC), 500);
    public static final Item WALLET = new WalletItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item TAKI_BLUE_HEAT = new TakisItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item TAKI_FUEGO = new TakisItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item TAKI_NACHO_CHEESE = new TakisItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item TAKI_NITRO = new TakisItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item TAKI_ZOMBIE = new TakisItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_BASIL = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_BBQ = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_CHOCOLATE = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_FISH = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_GOLDEN = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_MISSING = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_MYSTERY_MEAT = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_MYSTERY_MEAT_2 = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_PLAIN = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_SHINY = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_SLIMY = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_SOUR_CREAM_ONION = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHIP_STALE = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item NACHO_DORITO_CHIP = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item RANCH_DORITO_CHIP = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BBQ_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BIG_BITES = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item BLUE_HEAT_TAKI_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item CHOCO_CRUNCH = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item DIVINE_BLISS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item FISHERMEN = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item FLAVOR_WAVE = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item FUEGO_TAKI_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item LUCKY_SEVENS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item MEAT_TORNADO = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item MIRACLE_MAKER = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item NACHO_DORITOS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item NACHO_TAKI_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item NAN_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item NITRO_TAKI_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item NY_CRISPIES = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item PLAIN_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item POLISHED_CRISPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item POPEM = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item RANCH_DORITOS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SALTY_OASIS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SOUR_CREAM_ONION_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item SPUD_LITE = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item STOKED_SMOKED = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item USA_OVEN_BAKED = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item YUMYUM = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item ZOMBIE_TAKI_CHIPS = new ChipsItem(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item ALMOND_WATER = new SodaItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));
    public static final Item CASHEW_WATER = new SodaItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON));

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
            {"trash_can", TRASH_CAN},
            {"banana", BANANA},
            {"pocky_stick", POCKY_STICK},
            {"pocky_sticks", POCKY_STICKS},
            {"pocky_stick_box", POCKY_STICK_BOX},
            {"uranium_dust", URANIUM_DUST},
            {"peep_yellow", PEEP_YELLOW},
            {"peep_cyan", PEEP_CYAN},
            {"peep_pink", PEEP_PINK},
            {"peep_purple", PEEP_PURPLE},
            {"beer", BEER},
            {"bonk_atomic_punch", BONK_ATOMIC_PUNCH},
            {"bottle", BOTTLE},
            {"bud_light", BUD_LIGHT},
            {"champagne", CHAMPAGNE},
            {"chug_jug", CHUG_JUG},
            {"coca_cola", COCA_COLA},
            {"coke_zero", COKE_ZERO},
            {"coke_heart_throb", COKE_HEART_THROB},
            {"crita_cola", CRITA_COLA},
            {"dr_pepper", DR_PEPPER},
            {"dr_pepper_diet", DR_PEPPER_DIET},
            {"fanta", FANTA},
            {"flask", FLASK},
            {"lagar", LAGAR},
            {"milk_carton", MILK_CARTON},
            {"mountain_dew", MOUNTAIN_DEW},
            {"coffee", COFFEE},
            {"mug_root_beer", MUG_ROOT_BEER},
            {"nuka_cola", NUKA_COLA},
            {"nuka_cola_dark", NUKA_COLA_DARK},
            {"nuka_cola_quantum", NUKA_COLA_QUANTUM},
            {"nuka_cola_cherry", NUKA_COLA_CHERRY},
            {"nuka_cola_cide", NUKA_COLA_CIDE},
            {"nuka_cola_grape", NUKA_COLA_GRAPE},
            {"nuka_cola_love", NUKA_COLA_LOVE},
            {"nuka_cola_orange", NUKA_COLA_ORANGE},
            {"nuka_cola_quartz", NUKA_COLA_QUARTZ},
            {"nuka_cola_victory", NUKA_COLA_VICTORY},
            {"nuka_cola_wild", NUKA_COLA_WILD},
            {"prime_energy_blueraspberry", PRIME_ENERGY_BLUERASPBERRY},
            {"prime_energy_lemonlime", PRIME_ENERGY_LEMONLIME},
            {"prime_energy_orangemango", PRIME_ENERGY_ORANGEMANGO},
            {"prime_energy_strawberrywatermelon", PRIME_ENERGY_STRAWBERRYWATERMELON},
            {"prime_energy_tropicalpunch", PRIME_ENERGY_TROPICALPUNCH},
            {"monster_energy", MONSTER_ENERGY},
            {"redbull", REDBULL},
            {"peeps_pepsi", PEEPS_PEPSI},
            {"pepsi", PEPSI},
            {"rum", RUM},
            {"shize_blueberrytart", SHIZE_BLUEBERRYTART},
            {"shize_blushingrose", SHIZE_BLUSHINGROSE},
            {"shize_canadashy", SHIZE_CANADASHY},
            {"shize_cheekybitopud", SHIZE_CHEEKYBITOPUD},
            {"shize_cherrypop", SHIZE_CHERRYPOP},
            {"shize_coldbeetstew", SHIZE_COLDBEETSTEW},
            {"shize_elderflower", SHIZE_ELDERFLOWER},
            {"shize_factoryrust", SHIZE_FACTORYRUST},
            {"shize_fourcheese", SHIZE_FOURCHEESE},
            {"shize_frenchvanilla", SHIZE_FRENCHVANILLA},
            {"shize_fulmedames", SHIZE_FULMEDAMES},
            {"shize_gamerenergy", SHIZE_GAMERENERGY},
            {"shize_jellybean", SHIZE_JELLYBEAN},
            {"shize_juicymelon", SHIZE_JUICYMELON},
            {"shize_lemonparty", SHIZE_LEMONPARTY},
            {"shize_light", SHIZE_LIGHT},
            {"shize_liquorlisious", SHIZE_LIQUORLISIOUS},
            {"shize_mayonnaise", SHIZE_MAYONNAISE},
            {"shize_mustard", SHIZE_MUSTARD},
            {"shize_original", SHIZE_ORIGINAL},
            {"shize_pineapplepizza", SHIZE_PINEAPPLEPIZZA},
            {"shize_rawmeat", SHIZE_RAWMEAT},
            {"shize_sardinesurprise", SHIZE_SARDINESURPRISE},
            {"shize_strawberrykiwi", SHIZE_STRAWBERRYKIWI},
            {"shize_tangyketchup", SHIZE_TANGYKETCHUP},
            {"shize_tarotease", SHIZE_TAROTEASE},
            {"shize_thirstborn", SHIZE_THIRSTBORN},
            {"shize_tiramisu", SHIZE_TIRAMISU},
            {"shize_tropicalstorm", SHIZE_TROPICALSTORM},
            {"shize_veggiebroth", SHIZE_VEGGIEBROTH},
            {"strawberry_milk_carton", STRAWBERRY_MILK_CARTON},
            {"vodka", VODKA},
            {"wine", WINE},
            {"wine_glass", WINE_GLASS},
            {"speed_cola", SPEED_COLA},
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
            {"cosco_big_long_dog", COSCO_BIG_LONG_DOG},
            {"cosco_big_long_dog_mustard", COSCO_BIG_LONG_DOG_MUSTARD},
            {"cosco_big_long_dog_ketchup", COSCO_BIG_LONG_DOG_KETCHUP},
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
            {"1_momen", ONE_MOMEN},
            {"5_momen", FIVE_MOMEN},
            {"10_momen", TEN_MOMEN},
            {"20_momen", TWENTY_MOMEN},
            {"50_momen", FIFTY_MOMEN},
            {"100_momen", ONEHUNDRED_MOMEN},
            {"500_momen", FIVEHUNDRED_MOMEN},
            {"wallet", WALLET},
            {"taki_blue_heat", TAKI_BLUE_HEAT},
            {"taki_fuego", TAKI_FUEGO},
            {"taki_nacho_cheese", TAKI_NACHO_CHEESE},
            {"taki_nitro", TAKI_NITRO},
            {"taki_zombie", TAKI_ZOMBIE},
            {"chip_basil", CHIP_BASIL},
            {"chip_bbq", CHIP_BBQ},
            {"chip_chocolate", CHIP_CHOCOLATE},
            {"chip_fish", CHIP_FISH},
            {"chip_golden", CHIP_GOLDEN},
            {"chip_missing", CHIP_MISSING},
            {"chip_mystery_meat", CHIP_MYSTERY_MEAT},
            {"chip_mystery_meat_2", CHIP_MYSTERY_MEAT_2},
            {"chip_plain", CHIP_PLAIN},
            {"chip_shiny", CHIP_SHINY},
            {"chip_slimy", CHIP_SLIMY},
            {"chip_sour_cream_onion", CHIP_SOUR_CREAM_ONION},
            {"bbq_chips", BBQ_CHIPS},
            {"big_bites", BIG_BITES},
            {"blue_heat_taki_chips", BLUE_HEAT_TAKI_CHIPS},
            {"choco_crunch", CHOCO_CRUNCH},
            {"divine_bliss", DIVINE_BLISS},
            {"fishermen", FISHERMEN},
            {"flavor_wave", FLAVOR_WAVE},
            {"fuego_taki_chips", FUEGO_TAKI_CHIPS},
            {"lucky_sevens", LUCKY_SEVENS},
            {"meat_tornado", MEAT_TORNADO},
            {"miracle_maker", MIRACLE_MAKER},
            {"nacho_doritos", NACHO_DORITOS},
            {"nacho_taki_chips", NACHO_TAKI_CHIPS},
            {"nan_chips", NAN_CHIPS},
            {"nitro_taki_chips", NITRO_TAKI_CHIPS},
            {"ny_crispies", NY_CRISPIES},
            {"plain_chips", PLAIN_CHIPS},
            {"polished_crisps", POLISHED_CRISPS},
            {"popem", POPEM},
            {"ranch_doritos", RANCH_DORITOS},
            {"ranch_dorito_chip", RANCH_DORITO_CHIP},
            {"nacho_dorito_chip", NACHO_DORITO_CHIP},
            {"salty_oasis", SALTY_OASIS},
            {"sour_cream_onion_chips", SOUR_CREAM_ONION_CHIPS},
            {"spud_lite", SPUD_LITE},
            {"stoked_smoked", STOKED_SMOKED},
            {"usa_oven_baked", USA_OVEN_BAKED},
            {"yumyum", YUMYUM},
            {"zombie_taki_chips", ZOMBIE_TAKI_CHIPS},
            {"almond_water", ALMOND_WATER},
            {"cashew_water", CASHEW_WATER},

    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));


    public static void registerAll() {
        for (Map.Entry<String, Object> entry : ITEMS.entrySet()) {
            String key = entry.getKey();
            Item value = (Item) entry.getValue();

            registerItem(key, value);
        }
        registerToolItem("giant_lollipop", GIANT_LOLLIPOP);
        registerToolItem("catcorn", CATCORN);
    }


    //REGISTRY
    private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.SHIT_ID, name), item);
    }
    private static void registerToolItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.SHIT_ID, name), item);
    }
}
