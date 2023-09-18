package com.spirit.shit.item;

import com.spirit.shit.ShitMod;
import com.spirit.shit.block.ShitBlocks;
import com.spirit.shit.item.custom.projectile.BulletProjectileItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.nbt.NbtCompound;

public class ShitItemGroup {
    @SuppressWarnings("unused")
    public static final ItemGroup KELLOGGS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "kelloggs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kelloggs"))
                    .icon(() -> new ItemStack(ShitItems.OAT)).entries((displayContext, entries) -> {
                        entries.add(ShitItems.OAT);
                        entries.add(ShitBlocks.CRACKLIN_BOX);
                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup SHIT_MAIN_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "shitmain"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.shitmain"))
                    .icon(() -> new ItemStack(ShitItems.PEEP_YELLOW)).entries((displayContext, entries) -> {
                        entries.add(ShitItems.BLUE_BRICK);
                        entries.add(ShitItems.RED_BRICK);
                        entries.add(ShitItems.NACHO_DORITOS_CHIP);
                        entries.add(ShitItems.NACHO_DORITOS_BAG);
                        entries.add(ShitItems.BANANA);
                        entries.add(ShitItems.POCKY_STICK);
                        entries.add(ShitItems.POCKY_STICKS);
                        entries.add(ShitItems.HORSE_HOOF);
                        entries.add(ShitItems.RAW_CHEVALINE);
                        entries.add(ShitItems.COOKED_CHEVALINE);
                        entries.add(ShitItems.TALON_BURGER);

                        // Will kill you
                        entries.add(ShitItems.URANIUM_DUST);
                        entries.add(ShitItems.CHOCOLATE_OREO_SHAKE);
                        entries.add(ShitItems.PEEP_CYAN);
                        entries.add(ShitItems.PEEP_PINK);
                        entries.add(ShitItems.PEEP_PURPLE);

                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup BACKROOMS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "backrooms_item_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.backrooms"))
                    .icon(() -> new ItemStack(ShitBlocks.BACKROOMS_WALLPAPER)).entries((displayContext, entries) -> {
                        entries.add(ShitBlocks.BACKROOMS_CEILING);
                        entries.add(ShitBlocks.BACKROOMS_CEILING_VENT);
                        entries.add(ShitBlocks.BACKROOMS_FLOOR);
                        entries.add(ShitBlocks.BACKROOMS_FLOOR_TELEPORT);
                        entries.add(ShitBlocks.BACKROOMS_LIGHT);
                        entries.add(ShitBlocks.BACKROOMS_LIGHT_OFF);
                        entries.add(ShitBlocks.BACKROOMS_WALLPAPER);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_CEILING);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_CEILING_PAINTED);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT_OFF);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_FLOOR);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_WALLS);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_WALLS_PAINTED);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_WALLS_TUBES);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP_OFF);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM);
                        entries.add(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM_OFF);

                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup SPECIAL_WEAPONS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "special_weapons_item_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.special_weapons"))
                    .icon(() -> new ItemStack(ShitItems.COSCO_BIG_LONG_DOG)).entries((displayContext, entries) -> {
                        entries.add(ShitItems.GIANT_LOLLIPOP);
                        entries.add(ShitItems.COSCO_BIG_LONG_DOG);
                        entries.add(ShitItems.COSCO_BIG_LONG_DOG_KETCHUP);
                        entries.add(ShitItems.COSCO_BIG_LONG_DOG_MUSTARD);
                        entries.add(ShitItems.BRASS_KNUCKLES);
                        entries.add(ShitItems.CATCORN);
                        entries.add(ShitItems.LASER_POINTER_OFF);
                        entries.add(ShitItems.PIE);
                        entries.add(ShitItems.PIE_DAMAGE);
                        entries.add(ShitItems.PIE_SUS);
                        entries.add(ShitItems.SAIS);
                        entries.add(ShitItems.ZARSH_SCYTHE);

                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup GUNS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "guns"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.guns"))
                    .icon(() -> new ItemStack(ShitItems.M16)).entries((displayContext, entries) -> {
                        entries.add(ShitItems.AK47);
                        entries.add(ShitItems.DOUBLE_BARREL);
                        entries.add(ShitItems.FNP90);
                        entries.add(ShitItems.FNP90SCOPE);
                        entries.add(ShitItems.GLOCK17);
                        entries.add(ShitItems.M16);
                        entries.add(ShitItems.REVOLVER);
                        entries.add(ShitItems.GOLDEN_REVOLVER);
                        entries.add(ShitItems.SAWED_OFF);
                        entries.add(ShitItems.STRIKER_12);
                        entries.add(ShitItems.BULLET);
                        entries.add(ShitItems.RIFLE_BULLET);
                        entries.add(ShitItems.SHELL);
                        entries.add(ShitItems.SLUG);

                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup BULLET_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "bullets"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bullets"))
                    .icon(() -> new ItemStack(ShitItems.BULLET))  // Replace with a representative ItemStack for this group
                    .entries((displayContext, entries) -> {
                        // Items to consider
                        BulletProjectileItem[] items = {
                                (BulletProjectileItem) ShitItems.BULLET,
                                (BulletProjectileItem) ShitItems.RIFLE_BULLET,
                                (BulletProjectileItem) ShitItems.SHELL,
                                (BulletProjectileItem) ShitItems.SLUG
                        };

                        for (BulletProjectileItem bulletItem : items) {
                            for (StatusEffect effect : Registries.STATUS_EFFECT) {
                                for (byte isIncendiary : new byte[]{0, 1}) {
                                    for (byte isExplosive : new byte[]{0, 1}) {
                                        for (byte isExtendedDuration : new byte[]{0, 1}) {
                                            ItemStack stack = bulletItem.createItemWithEffects(effect, isIncendiary, isExplosive, isExtendedDuration);

                                            // Add BulletType to NBT data
                                            NbtCompound nbt = stack.getOrCreateNbt();
                                            nbt.putString("BulletType", bulletItem.getName().getString());  // Assuming getName().getString() returns the type like "Bullet", "Rifle Bullet", etc.

                                            // Generate a custom name for this bullet based on its properties.
                                            String customName = bulletItem.generateCustomNameFromNBT(stack);

                                            // Set the custom name to the ItemStack.
                                            stack.setCustomName(Text.translatable(customName));


                                            // Add the customized ItemStack to the entries.
                                            entries.add(stack);
                                        }
                                    }
                                }
                            }
                        }
                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup PLUSHES = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "plushes"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.plushes"))
                    .icon(() -> new ItemStack(ShitBlocks.SPIRIT_PLUSH)).entries((displayContext, entries) -> {
                        entries.add(ShitBlocks.ALPHA_PLUSH);
                        entries.add(ShitBlocks.CATLOVE_PLUSH);
                        entries.add(ShitBlocks.CHEFINSANITY_PLUSH);
                        entries.add(ShitBlocks.JARGEDES_PLUSH);
                        entries.add(ShitBlocks.JBIRD_PLUSH);
                        entries.add(ShitBlocks.MCFELLA_PLUSH);
                        entries.add(ShitBlocks.MILKYFUR_PLUSH);
                        entries.add(ShitBlocks.SIERRA_PLUSH);
                        entries.add(ShitBlocks.SLAZER_PLUSH);
                        entries.add(ShitBlocks.SPIRIT_PLUSH);
                        entries.add(ShitBlocks.TALON_PLUSH);
                        entries.add(ShitBlocks.ZARSH_PLUSH);

                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup DRINKS_SODA = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "drinks_soda"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.drinks_soda"))
                    .icon(() -> new ItemStack(ShitItems.PEPSI)).entries((displayContext, entries) -> {
                        entries.add(ShitItems.BEER);
                        entries.add(ShitItems.BEER_BOTTLE);
                        entries.add(ShitItems.BONK_ATOMIC_PUNCH);
                        entries.add(ShitItems.BONK_ATOMIC_PUNCH_PROJECTILE);
                        entries.add(ShitItems.BOTTLE);
                        entries.add(ShitItems.BUD_LIGHT);
                        entries.add(ShitItems.BUD_LIGHT_CAN);
                        entries.add(ShitItems.CHAMPAGNE);
                        entries.add(ShitItems.CHAMPAGNE_BOTTLE);
                        entries.add(ShitItems.CHUG_JUG);
                        entries.add(ShitItems.CHUG_JUG_EMPTY);
                        entries.add(ShitItems.COCA_COLA);
                        entries.add(ShitItems.COCA_COLA_CAN);
                        entries.add(ShitItems.COKE_ZERO);
                        entries.add(ShitItems.COKE_ZERO_CAN);
                        entries.add(ShitItems.CRITA_COLA);
                        entries.add(ShitItems.CRITA_COLA_CAN);
                        entries.add(ShitItems.DR_PEPPER);
                        entries.add(ShitItems.DR_PEPPER_CAN);
                        entries.add(ShitItems.FANTA);
                        entries.add(ShitItems.FANTA_CAN);
                        entries.add(ShitItems.FLASK);
                        entries.add(ShitItems.FLASK_EMPTY);
                        entries.add(ShitItems.GLASS_JAR);
                        entries.add(ShitItems.LAGAR);
                        entries.add(ShitItems.LAGAR_BOTTLE);
                        entries.add(ShitItems.MILK_CARTON);
                        entries.add(ShitItems.MILK_CARTON_EMPTY);
                        entries.add(ShitItems.MOUNTAIN_DEW);
                        entries.add(ShitItems.MOUNTAIN_DEW_CAN);
                        entries.add(ShitItems.COFFEE);
                        entries.add(ShitItems.MUG);
                        entries.add(ShitItems.MUG_ROOT_BEER);
                        entries.add(ShitItems.MUG_ROOT_BEER_CAN);
                        entries.add(ShitItems.NUKA_COLA);
                        entries.add(ShitItems.NUKA_COLA_BOTTLE);
                        entries.add(ShitItems.NUKA_COLA_DARK);
                        entries.add(ShitItems.NUKA_COLA_DARK_BOTTLE);
                        entries.add(ShitItems.NUKA_COLA_QUANTUM);
                        entries.add(ShitItems.NUKA_COLA_QUANTUM_BOTTLE);
                        entries.add(ShitItems.PEEPS_PEPSI);
                        entries.add(ShitItems.PEEPS_PEPSI_CAN);
                        entries.add(ShitItems.PEPSI);
                        entries.add(ShitItems.PEPSI_CAN);
                        entries.add(ShitItems.RUM);
                        entries.add(ShitItems.RUM_BOTTLE);
                        entries.add(ShitItems.SHIZE_BLUEBERRYTART);
                        entries.add(ShitItems.SHIZE_BLUEBERRYTART_CAN);
                        entries.add(ShitItems.SHIZE_BLUSHINGROSE);
                        entries.add(ShitItems.SHIZE_BLUSHINGROSE_CAN);
                        entries.add(ShitItems.SHIZE_CANADASHY);
                        entries.add(ShitItems.SHIZE_CANADASHY_CAN);
                        entries.add(ShitItems.SHIZE_CHEEKYBITOPUD);
                        entries.add(ShitItems.SHIZE_CHEEKYBITOPUD_CAN);
                        entries.add(ShitItems.SHIZE_CHERRYPOP);
                        entries.add(ShitItems.SHIZE_CHERRYPOP_CAN);
                        entries.add(ShitItems.SHIZE_COLDBEETSTEW);
                        entries.add(ShitItems.SHIZE_COLDBEETSTEW_CAN);
                        entries.add(ShitItems.SHIZE_ELDERFLOWER);
                        entries.add(ShitItems.SHIZE_ELDERFLOWER_CAN);
                        entries.add(ShitItems.SHIZE_FACTORYRUST);
                        entries.add(ShitItems.SHIZE_FACTORYRUST_CAN);
                        entries.add(ShitItems.SHIZE_FOURCHEESE);
                        entries.add(ShitItems.SHIZE_FOURCHEESE_CAN);
                        entries.add(ShitItems.SHIZE_FRENCHVANILLA);
                        entries.add(ShitItems.SHIZE_FRENCHVANILLA_CAN);
                        entries.add(ShitItems.SHIZE_FULMEDAMES);
                        entries.add(ShitItems.SHIZE_FULMEDAMES_CAN);
                        entries.add(ShitItems.SHIZE_GAMERENERGY);
                        entries.add(ShitItems.SHIZE_GAMERENERGY_CAN);
                        entries.add(ShitItems.SHIZE_JELLYBEAN);
                        entries.add(ShitItems.SHIZE_JELLYBEAN_CAN);
                        entries.add(ShitItems.SHIZE_JUICYMELON);
                        entries.add(ShitItems.SHIZE_JUICYMELON_CAN);
                        entries.add(ShitItems.SHIZE_LEMONPARTY);
                        entries.add(ShitItems.SHIZE_LEMONPARTY_CAN);
                        entries.add(ShitItems.SHIZE_LIGHT);
                        entries.add(ShitItems.SHIZE_LIGHT_CAN);
                        entries.add(ShitItems.SHIZE_LIQUORLISIOUS);
                        entries.add(ShitItems.SHIZE_LIQUORLISIOUS_CAN);
                        entries.add(ShitItems.SHIZE_MAYONNAISE);
                        entries.add(ShitItems.SHIZE_MAYONNAISE_CAN);
                        entries.add(ShitItems.SHIZE_MUSTARD);
                        entries.add(ShitItems.SHIZE_MUSTARD_CAN);
                        entries.add(ShitItems.SHIZE_ORIGINAL);
                        entries.add(ShitItems.SHIZE_ORIGINAL_CAN);
                        entries.add(ShitItems.SHIZE_PINEAPPLEPIZZA);
                        entries.add(ShitItems.SHIZE_PINEAPPLEPIZZA_CAN);
                        entries.add(ShitItems.SHIZE_RAWMEAT);
                        entries.add(ShitItems.SHIZE_RAWMEAT_CAN);
                        entries.add(ShitItems.SHIZE_SARDINESURPRISE);
                        entries.add(ShitItems.SHIZE_SARDINESURPRISE_CAN);
                        entries.add(ShitItems.SHIZE_STRAWBERRYKIWI);
                        entries.add(ShitItems.SHIZE_STRAWBERRYKIWI_CAN);
                        entries.add(ShitItems.SHIZE_TANGYKETCHUP);
                        entries.add(ShitItems.SHIZE_TANGYKETCHUP_CAN);
                        entries.add(ShitItems.SHIZE_TAROTEASE);
                        entries.add(ShitItems.SHIZE_TAROTEASE_CAN);
                        entries.add(ShitItems.SHIZE_THIRSTBORN);
                        entries.add(ShitItems.SHIZE_THIRSTBORN_CAN);
                        entries.add(ShitItems.SHIZE_TIRAMISU);
                        entries.add(ShitItems.SHIZE_TIRAMISU_CAN);
                        entries.add(ShitItems.SHIZE_TROPICALSTORM);
                        entries.add(ShitItems.SHIZE_TROPICALSTORM_CAN);
                        entries.add(ShitItems.SHIZE_VEGGIEBROTH);
                        entries.add(ShitItems.SHIZE_VEGGIEBROTH_CAN);
                        entries.add(ShitItems.SPEED_COLA);
                        entries.add(ShitItems.SPEED_COLA_CAN);
                        entries.add(ShitItems.STRAWBERRY_MILK_CARTON);
                        entries.add(ShitItems.STRAWBERRY_MILK_CARTON_EMPTY);
                        entries.add(ShitItems.VODKA);
                        entries.add(ShitItems.VODKA_BOTTLE);
                        entries.add(ShitItems.WINE);
                        entries.add(ShitItems.WINE_BOTTLE);
                        entries.add(ShitItems.WINE_GLASS);
                        entries.add(ShitItems.WINE_GLASS_EMPTY);

                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup FOOD = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "food"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.food"))
                    .icon(() -> new ItemStack(ShitItems.POCKY_STICK_BOX)).entries((displayContext, entries) -> {
                    }).build());

    @SuppressWarnings("unused")
    public static final ItemGroup SOUND = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ShitMod.MOD_ID, "sound"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.sound"))
                    .icon(() -> new ItemStack(ShitItems.SOUND_BOARD)).entries((displayContext, entries) -> entries.add(ShitItems.SOUND_BOARD)).build());
    public static void registerShitItemGroup() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/item/ShitItemGroup");
    }
}
