package com.spirit.ignite.global.item;

import com.spirit.Main;
import com.spirit.ignite.global.item.custom.explosive.FlashBangItem;
import com.spirit.ignite.global.item.custom.explosive.GrenadeItem;
import com.spirit.ignite.global.item.custom.explosive.IncGrenadeItem;
import com.spirit.ignite.global.item.custom.explosive.PipeBombItem;
import com.spirit.ignite.global.item.custom.gun.*;
import com.spirit.ignite.global.item.custom.gun.bullet.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IgniteItems {

    public static final Item BULLET = new BulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item BULLET_GOLD = new BulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item BULLET_IRON = new BulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item BULLET_INCENDIARY = new BulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item BULLET_EXPLOSIVE = new BulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item RIFLE_BULLET = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item RIFLE_BULLET_GOLD = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item RIFLE_BULLET_IRON = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item RIFLE_BULLET_INCENDIARY = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item RIFLE_BULLET_EXPLOSIVE = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item HIGH_CALIBER_BULLET = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item HIGH_CALIBER_BULLET_GOLD = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item HIGH_CALIBER_BULLET_IRON = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item HIGH_CALIBER_BULLET_INCENDIARY = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item HIGH_CALIBER_BULLET_EXPLOSIVE = new RifleBulletItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SHELL = new ShellItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SHELL_MAGNUM = new ShellItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SHELL_SHORTY = new ShellItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SLUG = new SlugItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SLUG_HEAVY = new SlugItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SLUG_INCENDIARY = new SlugItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item SLUG_EXPLOSIVE = new SlugItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item MUSKET_BALL = new MuskeBalltItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(64));
    public static final Item AK47 = new AK47Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item AWP = new AWPItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item DOUBLE_BARREL = new DoubleBarrelItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item FNP90 = new FNP90Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item FNP90SCOPE = new FNP90Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item GLOCK17 = new Glock17Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item M16 = new M16Item(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item M1_GARAND = new M1Garand(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item REVOLVER = new Revolver(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item GOLDEN_REVOLVER = new Revolver(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item SAWED_OFF = new SawedOffItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item SMOOTHBORE = new SmoothBoreItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item STRIKER_12 = new Striker12(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item FLAME_THROWER = new FlameThrower(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item MUSKET = new Musket(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item STEYR_SCOUT_ELITE = new SteyrScoutEliteItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1).maxDamage(600));
    public static final Item GRENADE = new GrenadeItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1));
    public static final Item INCGRENADE = new IncGrenadeItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1));
    public static final Item FLASH_BANG = new FlashBangItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1));
    public static final Item PIPE_BOMB = new PipeBombItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1));
    public static final Item SMOKE_BOMB = new PipeBombItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(1));

    static Map<String, Object> ITEMS = Stream.of(new Object[][]{
            {"bullet", BULLET},
            {"bullet_gold", BULLET_GOLD},
            {"bullet_iron", BULLET_IRON},
            {"bullet_incendiary", BULLET_INCENDIARY},
            {"bullet_explosive", BULLET_EXPLOSIVE},
            {"rifle_bullet", RIFLE_BULLET},
            {"rifle_bullet_gold", RIFLE_BULLET_GOLD},
            {"rifle_bullet_iron", RIFLE_BULLET_IRON},
            {"rifle_bullet_incendiary", RIFLE_BULLET_INCENDIARY},
            {"rifle_bullet_explosive", RIFLE_BULLET_EXPLOSIVE},
            {"high_caliber_bullet", HIGH_CALIBER_BULLET},
            {"high_caliber_bullet_gold", HIGH_CALIBER_BULLET_GOLD},
            {"high_caliber_bullet_iron", HIGH_CALIBER_BULLET_IRON},
            {"high_caliber_bullet_incendiary", HIGH_CALIBER_BULLET_INCENDIARY},
            {"high_caliber_bullet_explosive", HIGH_CALIBER_BULLET_EXPLOSIVE},
            {"shell", SHELL},
            {"shell_magnum", SHELL_MAGNUM},
            {"shell_shorty", SHELL_SHORTY},
            {"slug", SLUG},
            {"slug_heavy", SLUG_HEAVY},
            {"slug_incendiary", SLUG_INCENDIARY},
            {"slug_explosive", SLUG_EXPLOSIVE},
            {"musket_ball", MUSKET_BALL},
            {"ak47", AK47},
            {"awp", AWP},
            {"double_barrel", DOUBLE_BARREL},
            {"fnp_90", FNP90},
            {"fnp_90_scope", FNP90SCOPE},
            {"glock_17", GLOCK17},
            {"m16", M16},
            {"m1_garand", M1_GARAND},
            {"revolver", REVOLVER},
            {"revolver_golden", GOLDEN_REVOLVER},
            {"sawed_off", SAWED_OFF},
            {"smoothbore", SMOOTHBORE},
            {"striker_12", STRIKER_12},
            {"flame_thrower", FLAME_THROWER},
            {"musket", MUSKET},
            {"steyr_scout_elite", STEYR_SCOUT_ELITE},
            {"grenade", GRENADE},
            {"incgrenade", INCGRENADE},
            {"flash_bang", FLASH_BANG},
            {"pipe_bomb", PIPE_BOMB},
            {"smoke_bomb", SMOKE_BOMB},

    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));


public static void registerAll() {
        for (Map.Entry<String, Object> entry : ITEMS.entrySet()) {
        String key = entry.getKey();
        Item value = (Item) entry.getValue();

        registerItem(key, value);
        }
        }


//REGISTRY
private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.IGNITE_ID, name), item);
        }
private static void registerToolItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.IGNITE_ID, name), item);
        }
}
