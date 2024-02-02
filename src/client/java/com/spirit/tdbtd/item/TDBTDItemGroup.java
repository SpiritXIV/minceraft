package com.spirit.tdbtd.item;

import com.spirit.Main;
import com.spirit.tdbtd.block.TDBTDBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TDBTDItemGroup {
    public static final ItemGroup TDBTD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.TDBTD_ID, "tdbtd_item_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.tdbtditem"))
                    .icon(() -> new ItemStack(TDBTDItems.DIMENTEDHELMET))
                    .entries((displayContext, entries) -> {
                        entries.add(TDBTDItems.INFURTRINATED_FRAGMENT);
                        entries.add(TDBTDItems.INFURTRINATED_INGOT);
                        entries.add(TDBTDItems.DIMENTEDSTEM);
                        entries.add(TDBTDItems.DIMENTEDPETAL);
                        entries.add(TDBTDItems.DIMENTEDPETALALLOY);
                        entries.add(TDBTDItems.DIMENTEDFLOWER);
                        entries.add(TDBTDItems.SOUL_ESSENCE);
                        entries.add(TDBTDItems.LOST_SOUL);
                        entries.add(TDBTDItems.DIMENTEDHELMET);
                        entries.add(TDBTDItems.DIMENTEDCHESTPLATE);
                        entries.add(TDBTDItems.DIMENTEDLEGGINGS);
                        entries.add(TDBTDItems.DIMENTEDBOOTS);
                        entries.add(TDBTDItems.DIMENTED_SWORD);
                        entries.add(TDBTDItems.DIMENTED_PICKAXE);
                        entries.add(TDBTDItems.DIMENTED_AXE);
                        entries.add(TDBTDItems.DIMENTED_SHOVEL);
                        entries.add(TDBTDItems.DIMENTED_HOE);
                        entries.add(TDBTDItems.DIMENTEDSCYTHE);
                        entries.add(TDBTDItems.SCULKBOW);
                        entries.add(TDBTDItems.DIMENTEDSERPENT);
                        entries.add(TDBTDItems.DIMENTEDTHORN);
                        entries.add(TDBTDItems.SOULSHRIEKER);
                        entries.add(TDBTDItems.SHRIEKER_MUSIC_DISC);
                        entries.add(TDBTDItems.THE_WARDEN_MUSIC_DISC);
                        entries.add(TDBTDItems.WARDEN_RUN_MUSIC_DISC);
                        entries.add(TDBTDItems.TENEBROUS_NIBBLER_SPAWN_EGG);
                        entries.add(TDBTDItems.APERTURENTEETH_SPAWN_EGG);
                        entries.add(TDBTDItems.CODELAING_SPAWN_EGG);
                        entries.add(TDBTDItems.PERICARPIUM_SPAWN_EGG);
                        entries.add(TDBTDItems.SCUTLEON_SPAWN_EGG);
                        entries.add(TDBTDItems.NIDIVER_SPAWN_EGG);
                        entries.add(TDBTDItems.CURATOR_SPAWN_EGG);
                        entries.add(TDBTDItems.MIJAPENDRA_SPAWN_EGG);
                        entries.add(TDBTDItems.CONTRIVANCEPOLLOONE_SPAWN_EGG);
                        entries.add(TDBTDItems.CONTRIVANCEPOLLA_SPAWN_EGG);
                        entries.add(TDBTDItems.ABYSSOFIN_SPAWN_EGG);
                        entries.add(TDBTDItems.STURGO_SPAWN_EGG);
                        entries.add(TDBTDItems.ENGUIA_SPAWN_EGG);
                        entries.add(TDBTDItems.MALDININKAS_SPAWN_EGG);
                        entries.add(TDBTDItems.DEVASTADOR_HOUND_SPAWN_EGG);
                        entries.add(TDBTDItems.DEVASTADOR_CUR_SPAWN_EGG);
                        entries.add(TDBTDItems.DEVASTADOR_PUP_SPAWN_EGG);
                        entries.add(TDBTDItems.KREDA_SPAWN_EGG);
                    }).build());

    public static final ItemGroup TDBTD_FOOD_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.TDBTD_ID, "tdbtd_food_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.tdbtdfood"))
                    .icon(() -> new ItemStack(TDBTDItems.APPLE))
                    .entries((displayContext, entries) -> {
                        entries.add(TDBTDItems.APPLE);
                        entries.add(TDBTDItems.BAKED_POTATO);
                        entries.add(TDBTDItems.BEEF);
                        entries.add(TDBTDItems.BEETROOT);
                        entries.add(TDBTDItems.BREAD);
                        entries.add(TDBTDItems.CARROT);
                        entries.add(TDBTDItems.GLOW_BERRY);
                        entries.add(TDBTDItems.CHICKEN);
                        entries.add(TDBTDItems.COD);
                        entries.add(TDBTDItems.MUTTON);
                        entries.add(TDBTDItems.PORKCHOP);
                        entries.add(TDBTDItems.RABBIT);
                        entries.add(TDBTDItems.SALMON);
                        entries.add(TDBTDItems.TROPICAL_FISH);
                        entries.add(TDBTDItems.COOKED_BEEF);
                        entries.add(TDBTDItems.COOKED_CHICKEN);
                        entries.add(TDBTDItems.COOKED_COD);
                        entries.add(TDBTDItems.COOKED_MUTTON);
                        entries.add(TDBTDItems.COOKED_PORKCHOP);
                        entries.add(TDBTDItems.COOKED_RABBIT);
                        entries.add(TDBTDItems.COOKED_SALMON);
                        entries.add(TDBTDItems.PUFFERFISH);
                        entries.add(TDBTDItems.COOKIE);
                        entries.add(TDBTDItems.PUMPKIN_PIE);
                        entries.add(TDBTDItems.DRIED_KELP);
                        entries.add(TDBTDItems.ENCHANTED_GOLDEN_APPLE);
                        entries.add(TDBTDItems.GOLDEN_APPLE);
                        entries.add(TDBTDItems.GOLDEN_CARROT);
                        entries.add(TDBTDItems.MELON_SLICE);
                        entries.add(TDBTDItems.POISONOUS_POTATO);
                        entries.add(TDBTDItems.POTATO);
                        entries.add(TDBTDItems.ROTTEN_FLESH);
                        entries.add(TDBTDItems.SPIDER_EYE);
                    }).build());

    public static final ItemGroup TDBTD_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.TDBTD_ID, "tdbtd_block_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.tdbtdblock"))
                    .icon(() -> new ItemStack(TDBTDItems.APPLE))
                    .entries((displayContext, entries) -> {
                        entries.add(TDBTDBlocks.INFURTRINATED_BLOCK);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_ORE);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_PLANKS);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_SAPLING);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_LOG);
                        entries.add(TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
                        entries.add(TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_WOOD);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_FLOWER_LEAVES);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_SLAB);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_FENCE);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_FENCE_GATE);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_STAIRS);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_BUTTON);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_PRESSURE_PLATE);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_DOOR);
                        entries.add(TDBTDBlocks.CRITERIC_CHARRED_TRAPDOOR);
                        entries.add(TDBTDBlocks.DIMENTED_GRASS_BLOCK);
                        entries.add(TDBTDBlocks.DIMENTED_DIRT);
                        entries.add(TDBTDBlocks.DIMENTED_FARMLAND);
                        entries.add(TDBTDBlocks.DIMENTED_PODZOL);
                        entries.add(TDBTDBlocks.DIMENTED_ROOTED_DIRT);
                        entries.add(TDBTDBlocks.DIMENTED_COARSE_DIRT);
                        entries.add(TDBTDBlocks.DIMENTED_GRAVEL);
                        entries.add(TDBTDBlocks.DIMENTED_SAND);
                        entries.add(TDBTDBlocks.INFURTRINATED_CHAIN);
                        entries.add(TDBTDBlocks.INFURTRINATED_ANDESITE);
                        entries.add(TDBTDBlocks.INFURTRINATED_CALCITE);
                        entries.add(TDBTDBlocks.INFURTRINATED_COBBLED_DEEPSLATE);
                        entries.add(TDBTDBlocks.INFURTRINATED_COBBLESTONE);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE);
                        entries.add(TDBTDBlocks.INFURTRINATED_DIORITE);
                        entries.add(TDBTDBlocks.INFURTRINATED_GRANITE);
                        entries.add(TDBTDBlocks.INFURTRINATED_SMOOTH_BASALT);
                        entries.add(TDBTDBlocks.INFURTRINATED_STONE);
                        entries.add(TDBTDBlocks.INFURTRINATED_TUFF);
                        entries.add(TDBTDBlocks.INFURTRINATED_BLACKSTONE);
                        entries.add(TDBTDBlocks.INFURTRINATED_BASALT);
                        entries.add(TDBTDBlocks.INFURTRINATED_COBBLED_DEEPSLATE_SLAB);
                        entries.add(TDBTDBlocks.INFURTRINATED_COBBLED_DEEPSLATE_STAIRS);
                        entries.add(TDBTDBlocks.INFURTRINATED_COBBLED_DEEPSLATE_WALL);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_BRICKS);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_BRICKS_SLAB);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_BRICKS_STAIRS);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_BRICKS_WALL);
                        entries.add(TDBTDBlocks.CRACKED_INFURTRINATED_DEEPSLATE_BRICKS);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_TILES);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_TILES_SLAB);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_TILES_STAIRS);
                        entries.add(TDBTDBlocks.INFURTRINATED_DEEPSLATE_TILES_WALL);
                        entries.add(TDBTDBlocks.CRACKED_INFURTRINATED_DEEPSLATE_TILES);
                        entries.add(TDBTDBlocks.INFURTRINATED_STONE_BRICKS);
                        entries.add(TDBTDBlocks.INFURTRINATED_STONE_BRICKS_SLAB);
                        entries.add(TDBTDBlocks.INFURTRINATED_STONE_BRICKS_STAIRS);
                        entries.add(TDBTDBlocks.INFURTRINATED_STONE_BRICKS_WALL);
                        entries.add(TDBTDBlocks.CRACKED_INFURTRINATED_STONE_BRICKS);
                        entries.add(TDBTDBlocks.INFURTRINATED_COBBLESTONE_BRICKS_SLAB);
                        entries.add(TDBTDBlocks.INFURTRINATED_COBBLESTONE_BRICKS_STAIRS);
                        entries.add(TDBTDBlocks.INFURTRINATED_COBBLESTONE_BRICKS_WALL);
                        entries.add(TDBTDBlocks.SCULK_TEETH);
                        entries.add(TDBTDBlocks.SCULK_RIBS);
                        entries.add(TDBTDBlocks.SCULK_TENVINES);
                        entries.add(TDBTDBlocks.SCULK_FERN);
                        entries.add(TDBTDBlocks.LARGE_SCULK_FERN);
                        entries.add(TDBTDBlocks.SCULK_LOTUS);
                        entries.add(TDBTDBlocks.SCULK_FOUNTAIN_SHROOM);
                        entries.add(TDBTDBlocks.SCULK_SHROOM);
                        entries.add(TDBTDBlocks.SCULK_BUD);
                        entries.add(TDBTDBlocks.SCULK_GROWTH);
                        entries.add(TDBTDBlocks.SCULK_TENDRIL);
                        entries.add(TDBTDBlocks.SCULK_TAIL);
                        entries.add(TDBTDBlocks.SCULK_SPIKE);
                        entries.add(TDBTDBlocks.SCULK_WEB);
                        entries.add(TDBTDBlocks.SCULK_BONESHAFT);
                        entries.add(TDBTDBlocks.SCULK_THORNS);
                        entries.add(TDBTDBlocks.SCULK_EMITTER);
                        entries.add(TDBTDBlocks.SCULK_SHAKER);
                        entries.add(TDBTDBlocks.SCULK_MAW);
                        entries.add(TDBTDBlocks.CRITERIC_MOSS_BLOCK);
                        entries.add(TDBTDBlocks.CRITERIC_MOSS_CARPET);


                        entries.add(TDBTDBlocks.BEDEVIL_BOOKSHELF);
                        entries.add(TDBTDBlocks.BEDEVIL_WELL);
                        entries.add(TDBTDBlocks.CHISELED_INFURTRINATED_BONED_BLOCK);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_BLOCK);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_BULBLIGHT);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_BULB);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_CAGE);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_VERTEBRAE);
                        entries.add(TDBTDBlocks.PILLARED_INFURTRINATED_BONED_VERTEBRAE);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_BRICKED_BLOCK);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_BARS);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_DOOR);
                        entries.add(TDBTDBlocks.INFURTRINATED_BONED_TRAPDOOR);

                        entries.add(TDBTDBlocks.LAYERED_SCULK);
                        entries.add(TDBTDBlocks.FRAMED_SCULK);
                        entries.add(TDBTDBlocks.DEEPSLATE_VASE);
                        entries.add(TDBTDBlocks.UNLIT_LANTERN);

                        entries.add(TDBTDBlocks.ECHOING_AMETHYST);
                        entries.add(TDBTDBlocks.BUDDING_ECHOING_AMETHYST);
                        entries.add(TDBTDBlocks.SMALL_ECHOING_AMETHYST_BUD);
                        entries.add(TDBTDBlocks.MEDIUM_ECHOING_AMETHYST_BUD);
                        entries.add(TDBTDBlocks.LARGE_ECHOING_AMETHYST_BUD);
                        entries.add(TDBTDBlocks.ECHOING_AMETHYST_CLUSTER);

                    }).build());

    public static void register() {}
}

