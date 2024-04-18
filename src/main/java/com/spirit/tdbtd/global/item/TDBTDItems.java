package com.spirit.tdbtd.global.item;

import com.spirit.Main;
import com.spirit.tdbtd.global.block.TDBTDBlocks;
import com.spirit.tdbtd.global.entity.TDBTDEntities;
import com.spirit.tdbtd.global.item.custom.*;
import com.spirit.tdbtd.global.sound.TDBTDSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TDBTDItems {
    public static final Item INFURTRINATED_FRAGMENT = createItem(Rarity.COMMON, 64);
    public static final Item INFURTRINATED_INGOT = createItem(Rarity.COMMON, 64);
    public static final Item DIMENTED_STEM = createItem(Rarity.RARE, 64);
    public static final Item DIMENTED_PETAL = createItem(Rarity.RARE, 64);
    public static final Item DIMENTED_PETAL_ALLOY = createItem(Rarity.RARE, 64);
    public static final Item DIMENTED_FLOWER = createItem(Rarity.EPIC, 64);
    public static final Item SOUL_ESSENCE = createItem(Rarity.RARE, 16);
    public static final Item LOST_SOUL = createItem(Rarity.RARE, 16);
    public static final Item DIMENTED_HELMET = createArmorItem(ArmorMaterials.DIMENTED, ArmorItem.Type.HELMET, Rarity.RARE, 1);
    public static final Item DIMENTED_CHESTPLATE = createArmorItem(ArmorMaterials.DIMENTED, ArmorItem.Type.CHESTPLATE, Rarity.RARE, 1);
    public static final Item DIMENTED_LEGGINGS = createArmorItem(ArmorMaterials.DIMENTED, ArmorItem.Type.LEGGINGS, Rarity.RARE, 1);
    public static final Item DIMENTED_BOOTS = createArmorItem(ArmorMaterials.DIMENTED, ArmorItem.Type.BOOTS, Rarity.RARE, 1);
    public static final Item DIMENTED_SWORD = new SwordItem(TDBTDToolMaterial.INSTANCE, 8, -2.4F, new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item DIMENTED_PICKAXE = new TDBTDPickaxeItem(TDBTDToolMaterial.INSTANCE, 6, -2.8F, new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item DIMENTED_AXE = new TDBTDAxeItem(TDBTDToolMaterial.INSTANCE, 10, -3F, new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item DIMENTED_SHOVEL = new TDBTDShovelItem(TDBTDToolMaterial.INSTANCE, 7, -3.0F, new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item DIMENTED_HOE = new TDBTDHoeItem(TDBTDToolMaterial.INSTANCE, 0, -0F, new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item DIMENTED_SCYTHE = new DimentedScytheItem(TDBTDAdvanceToolMaterial.DIMENTED, 13, -3.5F, new FabricItemSettings().rarity(Rarity.EPIC));
    public static final Item DIMENTED_BOW = new TDBTDBowItem(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1).maxDamage(600));
  //public static final Item DIMENTED_SERPENT = new TDBTDSculkSerpentItem(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1).maxDamage(1200));
    public static final Item DIMENTED_THORN = new SoulShriekerItem(TDBTDAdvanceToolMaterial.DIMENTED, 8, 1F, new FabricItemSettings().rarity(Rarity.EPIC));
    public static final Item SOUL_SHRIEKER = new SoulShriekerItem(TDBTDAdvanceToolMaterial.DIMENTED, 15, -3.7F, new FabricItemSettings().rarity(Rarity.EPIC));
    public static final Item APPLE = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_APPLE);
    public static final Item BAKED_POTATO = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_BAKED_POTATO);
    public static final Item BEEF = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_BEEF);
    public static final Item BEETROOT = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_BEETROOT);
    public static final Item BREAD = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_BREAD);
    public static final Item CARROT = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_CARROT);
  //public static final Item SWEET_BERRY = new AliasedBlockItem(TDBTDBlocks.CRITERIC_VINES_BODY, new FabricItemSettings().food(TDBTDFoodComponents.SCULK_SWEET_BERRIES));
    public static final Item GLOW_BERRY = new AliasedBlockItem(TDBTDBlocks.CRITERIC_VINES_HEAD, new FabricItemSettings().food(TDBTDFoodComponents.SCULK_GLOW_BERRIES));
    public static final Item CHICKEN = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_CHICKEN);
    public static final Item COD = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COD);
    public static final Item MUTTON = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_MUTTON);
    public static final Item PORKCHOP = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_PORKCHOP);
    public static final Item RABBIT = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_RABBIT);
    public static final Item SALMON = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_SALMON);
    public static final Item TROPICAL_FISH = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_TROPICAL_FISH);
    public static final Item COOKED_BEEF = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COOKED_BEEF);
    public static final Item COOKED_CHICKEN = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COOKED_CHICKEN);
    public static final Item COOKED_COD = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COOKED_COD);
    public static final Item COOKED_MUTTON = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COOKED_MUTTON);
    public static final Item COOKED_PORKCHOP = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COOKED_PORKCHOP);
    public static final Item COOKED_RABBIT = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COOKED_RABBIT);
    public static final Item COOKED_SALMON = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COOKED_SALMON);
    public static final Item PUFFERFISH = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_PUFFERFISH);
    public static final Item COOKIE = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_COOKIE);
    public static final Item PUMPKIN_PIE = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_PUMPKIN_PIE);
    public static final Item DRIED_KELP = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_DRIED_KELP);
    public static final Item ENCHANTED_GOLDEN_APPLE = createFoodItem(Rarity.EPIC, TDBTDFoodComponents.SCULK_ENCHANTED_GOLDEN_APPLE);
    public static final Item GOLDEN_APPLE = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_GOLDEN_APPLE);
    public static final Item GOLDEN_CARROT = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_GOLDEN_CARROT);
    public static final Item MELON_SLICE = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_MELON_SLICE);
    public static final Item POISONOUS_POTATO = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_POISONOUS_POTATO);
    public static final Item POTATO = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_POTATO);
    public static final Item ROTTEN_FLESH = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_ROTTEN_FLESH);
    public static final Item SPIDER_EYE = createFoodItem(Rarity.COMMON, TDBTDFoodComponents.SCULK_SPIDER_EYE);
    public static final Item EVILFROMTHEWASTES = createMusicDiscItem(TDBTDSounds.EVILFROMTHEWASTES, Rarity.RARE, 129);
    public static final Item FINDINGAWAYOUT = createMusicDiscItem(TDBTDSounds.FINDINGAWAYOUT, Rarity.RARE, 107);
    public static final Item SCULKINGAROUND = createMusicDiscItem(TDBTDSounds.SCULKINGAROUND, Rarity.RARE, 187);
    public static final Item TENEBROUS_NIBBLER_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.TENEBROUS_NIBBLER, 37525, 338482);
    public static final Item APERTURENTEETH_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.APERTURENTEETH, 1121057, 13751990);
    public static final Item CODELAING_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.CODELAING, 477271, 37525);
    public static final Item PERICARPIUM_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.PERICARPIUM, 12305307, 1121057);
    public static final Item SCUTLEON_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.SCUTLEON, 405047, 856599);
    public static final Item NIDIVER_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.NIDIVER, 213328, 4216684);
    public static final Item CURATOR_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.CURATOR, 1121057, 37525);
    public static final Item MIJAPENDRA_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.MIJAPENDRA, 4216684, 856599);
    public static final Item CONTRIVANCEPOLLOONE_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.CONTRIVANCEPOLLOONE, 856599, 4216684);
    public static final Item CONTRIVANCEPOLLA_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.CONTRIVANCEPOLLA, 856599, 13751990);
    public static final Item ABYSSOFIN_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.ABYSSOFIN, 856599, 1121057);
    public static final Item STURGO_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.STURGO, 213328, 8493448);
    public static final Item ENGUIA_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.ENGUIA, 338482, 2744299);
    public static final Item MALDININKAS_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.MALDININKAS, 7239035, 2744299);
    public static final Item DEVASTADOR_HOUND_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.DEVASTADOR_HOUND, 213328, 352861);
    public static final Item DEVASTADOR_CUR_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.DEVASTADOR_CUR, 13751990, 10661766);
    public static final Item DEVASTADOR_PUP_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.DEVASTADOR_PUP, 213328, 10661766);
    public static final Item KREDA_SPAWN_EGG = createSpawnEggItem(TDBTDEntities.KREDA, 213328, 10661766);

    public static Item createItem(Rarity rarity, int maxCount) {
        return new Item(new FabricItemSettings().maxCount(maxCount).rarity(rarity));
    }

    public static Item createArmorItem(ArmorMaterial material, ArmorItem.Type type, Rarity rarity, int maxCount) {
        return new ArmorItem(material, type, new FabricItemSettings().maxCount(maxCount).rarity(rarity));
    }

    public static Item createMusicDiscItem(SoundEvent soundEvent, Rarity rarity, int comparatorOutput) {
        return new TDBTDMusicDiscItem(7, soundEvent, new FabricItemSettings().maxCount(1).rarity(rarity), comparatorOutput);
    }

    public static Item createFoodItem(Rarity rarity, FoodComponent foodComponent) {
        return new Item(new FabricItemSettings().rarity(rarity).food(foodComponent));
    }

    public static Item createSpawnEggItem(EntityType<?> entityType, int primaryColor, int secondaryColor) {
        return new SpawnEggItem((EntityType<? extends MobEntity>) entityType, primaryColor, secondaryColor, new FabricItemSettings());
    }

    static Map<String, Object> ITEMS = Stream.of(new Object[][]{
            {"infurtrinated_fragment", INFURTRINATED_FRAGMENT},
            {"infurtrinated_ingot", INFURTRINATED_INGOT},
            {"dimented_stem", DIMENTED_STEM},
            {"dimented_petal", DIMENTED_PETAL},
            {"dimented_petal_alloy", DIMENTED_PETAL_ALLOY},
            {"dimented_flower", DIMENTED_FLOWER},
            {"soul_essence", SOUL_ESSENCE},
            {"lost_soul", LOST_SOUL},
            {"dimented_helmet", DIMENTED_HELMET},
            {"dimented_chestplate", DIMENTED_CHESTPLATE},
            {"dimented_leggings", DIMENTED_LEGGINGS},
            {"dimented_boots", DIMENTED_BOOTS},
            {"sculk_apple", APPLE},
            {"sculk_baked_potato", BAKED_POTATO},
            {"sculk_beef", BEEF},
            {"sculk_beetroot", BEETROOT},
            {"sculk_bread", BREAD},
            {"sculk_carrot", CARROT},
            {"sculk_glow_berry", GLOW_BERRY},
            {"sculk_chicken", CHICKEN},
            {"sculk_cod", COD},
            {"sculk_mutton", MUTTON},
            {"sculk_porkchop", PORKCHOP},
            {"sculk_rabbit", RABBIT},
            {"sculk_salmon", SALMON},
            {"sculk_tropical_fish", TROPICAL_FISH},
            {"sculk_cooked_beef", COOKED_BEEF},
            {"sculk_cooked_chicken", COOKED_CHICKEN},
            {"sculk_cooked_cod", COOKED_COD},
            {"sculk_cooked_mutton", COOKED_MUTTON},
            {"sculk_cooked_porkchop", COOKED_PORKCHOP},
            {"sculk_cooked_rabbit", COOKED_RABBIT},
            {"sculk_cooked_salmon", COOKED_SALMON},
            {"sculk_pufferfish", PUFFERFISH},
            {"sculk_cookie", COOKIE},
            {"sculk_pumpkin_pie", PUMPKIN_PIE},
            {"sculk_dried_kelp", DRIED_KELP},
            {"sculk_enchanted_golden_apple", ENCHANTED_GOLDEN_APPLE},
            {"sculk_golden_apple", GOLDEN_APPLE},
            {"sculk_golden_carrot", GOLDEN_CARROT},
            {"sculk_melon_slice", MELON_SLICE},
            {"sculk_poisonous_potato", POISONOUS_POTATO},
            {"sculk_potato", POTATO},
            {"sculk_rotten_flesh", ROTTEN_FLESH},
            {"sculk_spider_eye", SPIDER_EYE},
            {"evilfromthewastes", TDBTDItems.EVILFROMTHEWASTES},
            {"findingawayout", TDBTDItems.FINDINGAWAYOUT},
            {"sculkingaround", TDBTDItems.SCULKINGAROUND},
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
            {"devastador_hound_spawn_egg", DEVASTADOR_HOUND_SPAWN_EGG},
            {"devastador_cur_spawn_egg", DEVASTADOR_CUR_SPAWN_EGG},
            {"devastador_pup_spawn_egg", DEVASTADOR_PUP_SPAWN_EGG},
            {"kreda_spawn_egg", KREDA_SPAWN_EGG}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Object) data[1]));

    public static void registerAllItems() {
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
        registerToolItem("dimented_scythe", DIMENTED_SCYTHE);
        registerToolItem("dimented_bow", DIMENTED_BOW);
        //registerToolItem("dimented_serpent", DIMENTED_SERPENT);
        registerToolItem("dimented_thorn", DIMENTED_THORN);
        registerToolItem("soul_shrieker", SOUL_SHRIEKER);
    }

    private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.TDBTD_ID, name), item);
    }

    private static void registerToolItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.TDBTD_ID, name), item);
    }
}

