package com.spirit.tdbtd;

import com.spirit.Main;
import com.spirit.tdbtd.global.item.TDBTDItems;
import com.spirit.tdbtd.global.item.custom.TDBTDMusicDiscItem;
import com.spirit.tdbtd.global.sound.TDBTDSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
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

import static com.spirit.tdbtd.global.block.TDBTDBlocks.*;
import static com.spirit.tdbtd.global.item.TDBTDItems.*;
import static com.spirit.tdbtd.global.sound.TDBTDSounds.*;

public class TDBTDHelperMethods {

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
        registerToolItem("dimented_serpent", DIMENTED_SERPENT);
        registerToolItem("dimented_thorn", DIMENTED_THORN);
        registerToolItem("soul_shrieker", SOUL_SHRIEKER);
    }

    private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.TDBTD_ID, name), item);
    }

    private static void registerToolItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Main.TDBTD_ID, name), item);
    }

    //Blocks
    public static Map<String, Object> BLOCKS = Stream.of(new Object[][] {
            {"infurtrinated_block", INFURTRINATED_BLOCK},
            {"infurtrinated_deepslate_ore", INFURTRINATED_DEEPSLATE_ORE},
            {"criteric_charred_planks", CRITERIC_CHARRED_PLANKS},
            {"criteric_charred_sapling", CRITERIC_CHARRED_SAPLING},
            {"criteric_charred_log", CRITERIC_CHARRED_LOG},
            {"criteric_charred_roots", CRITERIC_CHARRED_ROOTS},
            {"stripped_criteric_charred_log", STRIPPED_CRITERIC_CHARRED_LOG},
            {"stripped_criteric_charred_wood", STRIPPED_CRITERIC_CHARRED_WOOD},
            {"criteric_charred_wood", CRITERIC_CHARRED_WOOD},
            {"criteric_charred_leaves", CRITERIC_CHARRED_LEAVES},
            {"criteric_charred_flowering_leaves", CRITERIC_CHARRED_FLOWER_LEAVES},
            {"criteric_charred_slab", CRITERIC_CHARRED_SLAB},
            {"criteric_charred_fence", CRITERIC_CHARRED_FENCE},
            {"criteric_charred_fence_gate", CRITERIC_CHARRED_FENCE_GATE},
            {"criteric_charred_stairs", CRITERIC_CHARRED_STAIRS},
            {"criteric_charred_button", CRITERIC_CHARRED_BUTTON},
            {"criteric_charred_pressure_plate", CRITERIC_CHARRED_PRESSURE_PLATE},
            {"criteric_charred_door", CRITERIC_CHARRED_DOOR},
            {"criteric_charred_trapdoor", CRITERIC_CHARRED_TRAPDOOR},
            {"dimented_grass_block", DIMENTED_GRASS_BLOCK},
            {"dimented_dirt", DIMENTED_DIRT},
            {"dimented_farmland", DIMENTED_FARMLAND},
            {"dimented_podzol", DIMENTED_PODZOL},
            {"dimented_rooted_dirt", DIMENTED_ROOTED_DIRT},
            {"dimented_coarse_dirt", DIMENTED_COARSE_DIRT},
            {"dimented_gravel", DIMENTED_GRAVEL},
            {"dimented_sand", DIMENTED_SAND},
            {"infurtrinated_chain", INFURTRINATED_CHAIN},
            {"infurtrinated_andesite", INFURTRINATED_ANDESITE},
            {"infurtrinated_calcite", INFURTRINATED_CALCITE},
            {"infurtrinated_cobbled_deepslate", INFURTRINATED_COBBLED_DEEPSLATE},
            {"infurtrinated_cobblestone", INFURTRINATED_COBBLESTONE},
            {"infurtrinated_deepslate", INFURTRINATED_DEEPSLATE},
            {"infurtrinated_diorite", INFURTRINATED_DIORITE},
            {"infurtrinated_granite", INFURTRINATED_GRANITE},
            {"infurtrinated_smooth_basalt", INFURTRINATED_SMOOTH_BASALT},
            {"infurtrinated_stone", INFURTRINATED_STONE},
            {"infurtrinated_stone_slab", INFURTRINATED_STONE_SLAB},
            {"infurtrinated_tuff", INFURTRINATED_TUFF},
            {"infurtrinated_blackstone", INFURTRINATED_BLACKSTONE},
            {"infurtrinated_basalt", INFURTRINATED_BASALT},
            {"infurtrinated_cobbled_deepslate_slab", INFURTRINATED_COBBLED_DEEPSLATE_SLAB},
            {"infurtrinated_cobbled_deepslate_stairs", INFURTRINATED_COBBLED_DEEPSLATE_STAIRS},
            {"infurtrinated_cobbled_deepslate_wall", INFURTRINATED_COBBLED_DEEPSLATE_WALL},
            {"infurtrinated_deepslate_bricks", INFURTRINATED_DEEPSLATE_BRICKS},
            {"infurtrinated_deepslate_bricks_slab", INFURTRINATED_DEEPSLATE_BRICKS_SLAB},
            {"infurtrinated_deepslate_bricks_stairs", INFURTRINATED_DEEPSLATE_BRICKS_STAIRS},
            {"infurtrinated_deepslate_brick_wall", INFURTRINATED_DEEPSLATE_BRICKS_WALL},
            {"cracked_infurtrinated_deepslate_bricks", CRACKED_INFURTRINATED_DEEPSLATE_BRICKS},
            {"infurtrinated_deepslate_tiles", INFURTRINATED_DEEPSLATE_TILES},
            {"infurtrinated_deepslate_tiles_slab", INFURTRINATED_DEEPSLATE_TILES_SLAB},
            {"infurtrinated_deepslate_tiles_stairs", INFURTRINATED_DEEPSLATE_TILES_STAIRS},
            {"infurtrinated_deepslate_tiles_wall", INFURTRINATED_DEEPSLATE_TILES_WALL},
            {"cracked_infurtrinated_deepslate_tiles", CRACKED_INFURTRINATED_DEEPSLATE_TILES},
            {"infurtrinated_stone_bricks", INFURTRINATED_STONE_BRICKS},
            {"infurtrinated_stone_bricks_slab", INFURTRINATED_STONE_BRICKS_SLAB},
            {"infurtrinated_stone_bricks_stairs", INFURTRINATED_STONE_BRICKS_STAIRS},
            {"infurtrinated_stone_bricks_wall", INFURTRINATED_STONE_BRICKS_WALL},
            {"cracked_infurtrinated_stone_bricks", CRACKED_INFURTRINATED_STONE_BRICKS},
            {"infurtrinated_cobblestone_slab", INFURTRINATED_COBBLESTONE_BRICKS_SLAB},
            {"infurtrinated_cobblestone_stairs", INFURTRINATED_COBBLESTONE_BRICKS_STAIRS},
            {"infurtrinated_cobblestone_wall", INFURTRINATED_COBBLESTONE_BRICKS_WALL},
            {"criteric_vines_top", CRITERIC_VINES_HEAD},
            {"criteric_vines", CRITERIC_VINES_BODY},
            {"sculk_teeth", SCULK_TEETH},
            {"sculk_ribs", SCULK_RIBS},
            {"sculk_tenvines", SCULK_TENVINES},
            {"sculk_tenvines_plant", SCULK_TENVINES_PLANT},
            {"sculk_fern", SCULK_FERN},
            {"large_sculk_fern", LARGE_SCULK_FERN},
            {"sculk_lotus", SCULK_LOTUS},

            {"sculk_tendril", SCULK_TENDRIL},
            {"sculk_fountain_shroom", SCULK_FOUNTAIN_SHROOM},
            {"sculk_shroom", SCULK_SHROOM},
            {"sculk_bud", SCULK_BUD},
            {"sculk_growth", SCULK_GROWTH},
            {"sculk_tail", SCULK_TAIL},
            {"sculk_spike", SCULK_SPIKE},
            {"sculk_web", SCULK_WEB},
            {"sculk_boneshaft", SCULK_BONESHAFT},
            {"sculk_thorns", SCULK_THORNS},
            {"sculk_emitter", SCULK_EMITTER},
            {"sculk_shaker", SCULK_SHAKER},
            {"sculk_maw", SCULK_MAW},
            {"layered_sculk", LAYERED_SCULK},
            {"pulsing_sculk", PULSING_SCULK},
            {"sculk_weed", SCULK_WEED},

            {"framed_sculk", FRAMED_SCULK},

            {"deepslate_vase", DEEPSLATE_VASE},

            {"unlit_lantern", UNLIT_LANTERN},

            {"infurtrinated_boned_block", INFURTRINATED_BONED_BLOCK},
            {"infurtrinated_boned_bulb", INFURTRINATED_BONED_BULB},
            {"infurtrinated_boned_bulblight", INFURTRINATED_BONED_BULBLIGHT},
            {"infurtrinated_boned_cage", INFURTRINATED_BONED_CAGE},
            {"infurtrinated_boned_vertebrae", INFURTRINATED_BONED_VERTEBRAE},
            {"pillared_infurtrinated_boned_vertebrae", PILLARED_INFURTRINATED_BONED_VERTEBRAE},
            {"infurtrinated_boned_bricked_block", INFURTRINATED_BONED_BRICKED_BLOCK},
            {"chiseled_infurtrinated_boned_block", CHISELED_INFURTRINATED_BONED_BLOCK},
            {"bedevil_bookshelf", BEDEVIL_BOOKSHELF},
            {"bedevil_well", BEDEVIL_WELL},

            {"infurtrinated_boned_bars", INFURTRINATED_BONED_BARS},
            {"infurtrinated_boned_door", INFURTRINATED_BONED_DOOR},
            {"infurtrinated_boned_trapdoor", INFURTRINATED_BONED_TRAPDOOR},

            {"criteric_moss_block", CRITERIC_MOSS_BLOCK},
            {"criteric_moss_carpet", CRITERIC_MOSS_CARPET},

            {"echoing_amethyst", ECHOING_AMETHYST},
            {"budding_echoing_amethyst", BUDDING_ECHOING_AMETHYST},
            {"small_echoing_amethyst_bud", SMALL_ECHOING_AMETHYST_BUD},
            {"medium_echoing_amethyst_bud", MEDIUM_ECHOING_AMETHYST_BUD},
            {"large_echoing_amethyst_bud", LARGE_ECHOING_AMETHYST_BUD},
            {"echoing_amethyst_cluster", ECHOING_AMETHYST_CLUSTER},


    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));


    public static void registerAllBlocks() {
        for (Map.Entry<String, Object> entry : BLOCKS.entrySet()) {
            String key = entry.getKey();
            Block value = (Block) entry.getValue();

            registerBlock(key, value);
        }
    }

    private static void registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Registry.register(Registries.BLOCK, new Identifier(Main.TDBTD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Main.TDBTD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static void registerBlockWithoutBlockItem(String name, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(Main.TDBTD_ID, name), block);
    }

    //Sounds
    static Map<String, Object> SOUNDS = Stream.of(new Object[][]{
            {"evilfromthewastes", TDBTDSounds.EVILFROMTHEWASTES},
            {"findingawayout", TDBTDSounds.FINDINGAWAYOUT},
            {"sculkingaround", TDBTDSounds.SCULKINGAROUND},
            {"pollo_one_beam", POLLO_ONE_BEAM},
            {"deep_dark_ambience", DEEP_DARK_AMBIENCE},
            {"dimented_serpent_shoot", DIMENTED_SERPENT_SHOOT},
            {"dimented_serpent_charge", DIMENTED_SERPENT_CHARGE},
            {"codelaing_ambient", CODELAING_AMBIENT},
            {"devastador_ambient", DEVASTADOR_AMBIENT},
            {"devastador_angry", DEVASTADOR_ANGRY},
            {"tenebrous_nibbler_bite", TENEBROUS_NIBBLER_BITE},
            {"entity_water_breath", ENTITY_WATER_BREATH},
    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));

    private static void registerSoundEvent(String name, SoundEvent sound) {
        Identifier id = new Identifier(Main.TDBTD_ID, name);
        Registry.register(Registries.SOUND_EVENT, id, sound);
    }
}
