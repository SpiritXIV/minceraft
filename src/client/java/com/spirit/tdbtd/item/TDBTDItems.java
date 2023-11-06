package com.spirit.tdbtd.item;

import com.spirit.Main;
import com.spirit.tdbtd.block.TDBTDBlocks;
import com.spirit.tdbtd.entity.TDBTDEntities;
import com.spirit.tdbtd.item.custom.*;
import com.spirit.tdbtd.sound.TDBTDSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TDBTDItems {

    //Items
    public static final Item INFURTRINATED_FRAGMENT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item INFURTRINATED_INGOT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));

    public static final Item DIMENTEDSTEM = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.RARE));
    public static final Item DIMENTEDPETAL = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.RARE));
    public static final Item DIMENTEDPETALALLOY = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.RARE));
    public static final Item DIMENTEDFLOWER = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.EPIC));
    public static final Item SOUL_ESSENCE = new Item(new FabricItemSettings().maxCount(16).rarity(Rarity.RARE));
    public static final Item LOST_SOUL = new Item(new FabricItemSettings().maxCount(16).rarity(Rarity.RARE));

    //ARMOR
    public static final Item DIMENTEDHELMET = new ArmorItem(ArmorMaterials.DIMENTED, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE));
    public static final Item DIMENTEDCHESTPLATE = new ArmorItem(ArmorMaterials.DIMENTED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE));
    public static final Item DIMENTEDLEGGINGS = new ArmorItem(ArmorMaterials.DIMENTED, ArmorItem.Type.LEGGINGS, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE));
    public static final Item DIMENTEDBOOTS = new ArmorItem(ArmorMaterials.DIMENTED, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE));

    //TOOLS
    public static final Item DIMENTED_SWORD = new SwordItem(TDBTDToolMaterial.INSTANCE, 9, -0F,
        new FabricItemSettings().rarity(Rarity.RARE));
    public static ToolItem DIMENTED_PICKAXE = new TDBTDPickaxeItem(TDBTDToolMaterial.INSTANCE, 8, -2.8F,
        new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item DIMENTED_AXE = new TDBTDAxeItem(TDBTDToolMaterial.INSTANCE, 11, -3.2F,
        new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item DIMENTED_SHOVEL =
new TDBTDShovelItem(TDBTDToolMaterial.INSTANCE, 7, -3.0F,
        new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item DIMENTED_HOE =
new TDBTDHoeItem(TDBTDToolMaterial.INSTANCE, 2, -3.2F,
        new FabricItemSettings().rarity(Rarity.RARE));

    //SCYTHE
    public static final Item DIMENTEDSCYTHE =
new DimentedScytheItem(TDBTDAdvanceToolMaterial.DIMENTED, 17, -1F,
        new FabricItemSettings().rarity(Rarity.EPIC));
    //RANGED
    public static final Item SCULKBOW =
new TDBTDBowItem(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1).maxDamage(600));
    public static final Item DIMENTEDSERPENT =
new TDBTDShriekbowItem(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1).maxDamage(1200));
    public static final Item DIMENTEDTHORN =
new SoulShriekerItem(TDBTDAdvanceToolMaterial.DIMENTED, 8, 1F,
        new FabricItemSettings().rarity(Rarity.EPIC));

    //OTHER UNIQUE WEPONDS
    public static final Item SOULSHRIEKER =
new SoulShriekerItem(TDBTDAdvanceToolMaterial.DIMENTED, 8, 1F,
        new FabricItemSettings().rarity(Rarity.EPIC));

    //FOOD
    public static final Item APPLE =
new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_APPLE));
    public static final Item BAKED_POTATO =
new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_BAKED_POTATO));
    public static final Item BEEF =
new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_BEEF));
    public static final Item BEETROOT =
new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_BEETROOT));
    public static final Item BREAD = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_BREAD));
    public static final Item CARROT = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_CARROT));
    //public static final Item SWEET_BERRY =     //        new AliasedBlockItem(TDBTDBlocks.CRITERIC_VINES_BODY, new FabricItemSettings().food(TDBTDFoodComponents.SCULK_SWEET_BERRIES));
    public static final Item GLOW_BERRY = new AliasedBlockItem(TDBTDBlocks.CRITERIC_VINES_HEAD, new FabricItemSettings().food(TDBTDFoodComponents.SCULK_GLOW_BERRIES));

    public static final Item CHICKEN = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_CHICKEN));
    public static final Item COD = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COD));
    public static final Item MUTTON = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_MUTTON));
    public static final Item PORKCHOP = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_PORKCHOP));
    public static final Item RABBIT = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_RABBIT));
    public static final Item SALMON = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_SALMON));
    public static final Item TROPICAL_FISH = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_TROPICAL_FISH));

    public static final Item COOKED_BEEF = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COOKED_BEEF));
    public static final Item COOKED_CHICKEN = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COOKED_CHICKEN));
    public static final Item COOKED_COD = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COOKED_COD));
    public static final Item COOKED_MUTTON = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COOKED_MUTTON));
    public static final Item COOKED_PORKCHOP = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COOKED_PORKCHOP));
    public static final Item COOKED_RABBIT = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COOKED_RABBIT));
    public static final Item COOKED_SALMON = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COOKED_SALMON));
    public static final Item PUFFERFISH = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_PUFFERFISH));

    public static final Item COOKIE = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_COOKIE));
    public static final Item PUMPKIN_PIE = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_PUMPKIN_PIE));
    public static final Item DRIED_KELP = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_DRIED_KELP));
    public static final Item ENCHANTED_GOLDEN_APPLE = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_ENCHANTED_GOLDEN_APPLE).rarity(Rarity.EPIC));
    public static final Item GOLDEN_APPLE = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_GOLDEN_APPLE));
    public static final Item GOLDEN_CARROT = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_GOLDEN_CARROT));
    public static final Item MELON_SLICE = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_MELON_SLICE));
    public static final Item POISONOUS_POTATO = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_POISONOUS_POTATO));
    public static final Item POTATO = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_POTATO));
    public static final Item ROTTEN_FLESH = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_ROTTEN_FLESH));
    public static final Item SPIDER_EYE = new Item(new FabricItemSettings().food(TDBTDFoodComponents.SCULK_SPIDER_EYE));

    //MUSIC DISCS
    public static final Item SHRIEKER_MUSIC_DISC = new TDBTDMusicDiscItem(7, TDBTDSounds.SHRIEKER,
        new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 129);
    public static final Item THE_WARDEN_MUSIC_DISC = new TDBTDMusicDiscItem(7, TDBTDSounds.THE_WARDEN,
        new FabricItemSettings().maxCount(1).rarity(Rarity.RARE),107);
    public static final Item WARDEN_RUN_MUSIC_DISC = new TDBTDMusicDiscItem(7, TDBTDSounds.WARDEN_RUN,
        new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 187);

    //SPAWN EGGS
    public static final Item TENEBROUS_NIBBLER_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.TENEBROUS_NIBBLER, 37525, 338482,
        new FabricItemSettings());

    public static final Item APERTURENTEETH_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.APERTURENTEETH, 1121057, 13751990,
        new FabricItemSettings());

    public static final Item CODELAING_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.CODELAING, 477271, 37525,
        new FabricItemSettings());

    public static final Item PERICARPIUM_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.PERICARPIUM, 12305307, 1121057,
        new FabricItemSettings());

    public static final Item SCUTLEON_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.SCUTLEON, 405047, 856599,
        new FabricItemSettings());

    public static final Item NIDIVER_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.NIDIVER, 213328, 4216684,
        new FabricItemSettings());

    public static final Item CURATOR_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.CURATOR, 1121057, 37525,
        new FabricItemSettings());

    public static final Item MIJAPENDRA_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.MIJAPENDRA, 4216684, 856599,
        new FabricItemSettings());

    public static final Item CONTRIVANCEPOLLOONE_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.CONTRIVANCEPOLLOONE, 	856599, 4216684,
        new FabricItemSettings());

    public static final Item CONTRIVANCEPOLLA_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.CONTRIVANCEPOLLA, 856599, 13751990,
        new FabricItemSettings());

    public static final Item ABYSSOFIN_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.ABYSSOFIN, 856599, 1121057,
        new FabricItemSettings());

    public static final Item STURGO_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.STURGO, 213328, 8493448,
        new FabricItemSettings());

    public static final Item ENGUIA_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.ENGUIA, 338482, 2744299,
        new FabricItemSettings());

    public static final Item MALDININKAS_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.MALDININKAS, 7239035, 2744299,
        new FabricItemSettings());

    public static final Item DEVASTADOR_HOUND_SPAWNEGG = new SpawnEggItem(TDBTDEntities.DEVASTADOR_HOUND, 	213328, 352861,
        new FabricItemSettings());

    public static final Item DEVASTADOR_CUR_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.DEVASTADOR_CUR, 13751990, 10661766,
        new FabricItemSettings());

    public static final Item DEVASTADOR_PUP_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.DEVASTADOR_PUP, 213328, 10661766,
        new FabricItemSettings());

    public static final Item KREDA_SPAWN_EGG = new SpawnEggItem(TDBTDEntities.KREDA, 213328, 10661766,
        new FabricItemSettings());


    static Map<String, Object> ITEMS = Stream.of(new Object[][] {
            {"infurtrinated_fragment", INFURTRINATED_FRAGMENT},
            {"infurtrinated_ingot", INFURTRINATED_INGOT},
            {"dimented_stem", DIMENTEDSTEM},
            {"dimented_petal", DIMENTEDPETAL},
            {"dimented_petal_alloy", DIMENTEDPETALALLOY},
            {"dimented_flower", DIMENTEDFLOWER},
            {"soul_essence", SOUL_ESSENCE},
            {"lost_soul", LOST_SOUL},
            {"dimented_helmet", DIMENTEDHELMET},
            {"dimented_chestplate", DIMENTEDCHESTPLATE},
            {"dimented_leggings", DIMENTEDLEGGINGS},
            {"dimented_boots", DIMENTEDBOOTS},
            {"apple", APPLE},
            {"baked_potato", BAKED_POTATO},
            {"beef", BEEF},
            {"beetroot", BEETROOT},
            {"bread", BREAD},
            {"carrot", CARROT},
            {"glow_berry", GLOW_BERRY},
            {"chicken", CHICKEN},
            {"cod", COD},
            {"mutton", MUTTON},
            {"porkchop", PORKCHOP},
            {"rabbit", RABBIT},
            {"salmon", SALMON},
            {"tropical_fish", TROPICAL_FISH},
            {"cooked_beef", COOKED_BEEF},
            {"cooked_chicken", COOKED_CHICKEN},
            {"cooked_cod", COOKED_COD},
            {"cooked_mutton", COOKED_MUTTON},
            {"cooked_porkchop", COOKED_PORKCHOP},
            {"cooked_rabbit", COOKED_RABBIT},
            {"cooked_salmon", COOKED_SALMON},
            {"pufferfish", PUFFERFISH},
            {"cookie", COOKIE},
            {"pumpkin_pie", PUMPKIN_PIE},
            {"dried_kelp", DRIED_KELP},
            {"enchanted_golden_apple", ENCHANTED_GOLDEN_APPLE},
            {"golden_apple", GOLDEN_APPLE},
            {"golden_carrot", GOLDEN_CARROT},
            {"melon_slice", MELON_SLICE},
            {"poisonous_potato", POISONOUS_POTATO},
            {"potato", POTATO},
            {"rotten_flesh", ROTTEN_FLESH},
            {"spider_eye", SPIDER_EYE},
            {"shrieker_music_disc", SHRIEKER_MUSIC_DISC},
            {"the_warden_music_disc", THE_WARDEN_MUSIC_DISC},
            {"warden_run_music_disc", WARDEN_RUN_MUSIC_DISC},
            {"tenebrous_nibbler_spawn_egg", TENEBROUS_NIBBLER_SPAWN_EGG},
            {"aperturenteeth_spawn_egg", APERTURENTEETH_SPAWN_EGG},
            {"codelaing_spawn_egg", CODELAING_SPAWN_EGG},
            {"pericarpium_spawn_egg", PERICARPIUM_SPAWN_EGG},
            {"scutleon_spawn_egg", SCUTLEON_SPAWN_EGG},
            {"nidiver_spawn_egg", NIDIVER_SPAWN_EGG},
            {"curator_spawn_egg", CURATOR_SPAWN_EGG},
            {"mijapendra_spawn_egg", MIJAPENDRA_SPAWN_EGG},
            {"contrivancepolloone_spawn_egg", CONTRIVANCEPOLLOONE_SPAWN_EGG},
            {"contrivancepolla_spawn_egg", CONTRIVANCEPOLLA_SPAWN_EGG},
            {"abyssofin_spawn_egg", ABYSSOFIN_SPAWN_EGG},
            {"sturgo_spawn_egg", STURGO_SPAWN_EGG},
            {"enguia_spawn_egg", ENGUIA_SPAWN_EGG},
            {"maldininkas_spawn_egg", MALDININKAS_SPAWN_EGG},
            {"devastador_hound_spawnegg", DEVASTADOR_HOUND_SPAWNEGG},
            {"devastador_cur_spawn_egg", DEVASTADOR_CUR_SPAWN_EGG},
            {"devastador_pup_spawn_egg", DEVASTADOR_PUP_SPAWN_EGG},
            {"kreda_spawn_egg", KREDA_SPAWN_EGG}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Object) data[1]));

    public static void registerAll() {
        for (Map.Entry<String, Object> entry : ITEMS.entrySet()) {
String key = entry.getKey();
Item value = (Item) entry.getValue();

registerItem(key, value);
        }

                registerToolItem("dimented_sword", DIMENTED_SWORD);
                registerToolItem("dimented_pickaxe", DIMENTED_PICKAXE);
                registerToolItem("dimented_axe", DIMENTED_AXE);
                registerToolItem("dimented_shovel", DIMENTED_SHOVEL);
                registerToolItem("dimented_hoe", DIMENTED_HOE);
                registerToolItem("dimented_scythe", DIMENTEDSCYTHE);
                registerToolItem("sculk_bow", SCULKBOW);
                registerToolItem("dimented_serpent", DIMENTEDSERPENT);
                registerToolItem("dimented_thorn", DIMENTEDTHORN);
                registerToolItem("soul_shrieker", SOULSHRIEKER);
    }


    // Dont suppress, this is actually a valid warning
    //private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    //    entries.add(RED_BRICK);
    //    entries.add(BLUE_BRICK);
    // }


    //REGISTRY
    private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.TDBTD_ID, name), item);
    }
    private static void registerToolItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.TDBTD_ID, name), item);
    }
}

