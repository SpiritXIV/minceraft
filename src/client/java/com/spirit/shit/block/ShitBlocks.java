package com.spirit.shit.block;

import com.spirit.shit.ShitMod;
import com.spirit.shit.block.custom.*;
import com.spirit.shit.block.custom.plush.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ShitBlocks {
    public static final Block CRACKLIN_BOX = registerBlock("cracklin_box",
            new CracklinBoxBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0F).requiresTool()));
    public static final Block GAS_CAN = registerBlock("gas_can",
            new GasCanBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block GAS_CANISTER = registerBlock("gas_canister",
            new GasCanisterBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block TOILET = registerBlock("toilet",
            new ToiletBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block WORLD_BOMB = registerBlockWithoutBlockItem("world_bomb",
            new WorldBombBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));

    //BACKROOMS LEVEL 0
    public static final Block BACKROOMS_LIGHT = registerBlock("backrooms_light",
            new BackroomsLightBlock(FabricBlockSettings.copy(Blocks.SEA_LANTERN).sounds(BlockSoundGroup.GLASS).strength(-1.0F, 3600000.0F).luminance((state) -> {
                return 9; })));
    public static final Block BACKROOMS_LIGHT_OFF = registerBlock("backrooms_light_off",
            new Block(FabricBlockSettings.copy(Blocks.SEA_LANTERN).sounds(BlockSoundGroup.GLASS).strength(-1.0F, 3600000.0F).luminance((state) -> {
                return 0; })));
    public static final Block BACKROOMS_FLOOR = registerBlock("backrooms_floor",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.MUD).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_FLOOR_TELEPORT = registerBlock("backrooms_floor_teleport",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.MUD).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_WALLPAPER = registerBlock("backrooms_wallpaper",
            new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_WALLPAPER_LIP = registerBlock("backrooms_wallpaper_lip",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CEILING = registerBlock("backrooms_ceiling",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CEILING_VENT = registerBlock("backrooms_ceiling_vent",
            new BackroomsVentBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    //BACKROOMS LEVEL 1
    public static final Block BACKROOMS_CONCRETE_FLOOR = registerBlock("backrooms_concrete_floor",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_WALLS = registerBlock("backrooms_concrete_walls",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_WALLS_TUBES = registerBlock("backrooms_concrete_walls_tubes",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR = registerBlock("backrooms_concrete_wall_pillar",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP = registerBlock("backrooms_concrete_wall_pillar_light_top",
            new BackroomsConcreteLightBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> {
                return 8; })));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM = registerBlock("backrooms_concrete_wall_pillar_light_bottom",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> {
                return 8; })));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP_OFF = registerBlock("backrooms_concrete_wall_pillar_light_top_off",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM_OFF = registerBlock("backrooms_concrete_wall_pillar_light_bottom_off",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_WALLS_PAINTED = registerBlock("backrooms_concrete_walls_painted",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_CEILING = registerBlock("backrooms_concrete_ceiling",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_CEILING_PAINTED = registerBlock("backrooms_concrete_ceiling_painted",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT = registerBlock("backrooms_concrete_ceiling_painted_light",
            new BackroomsConcreteLightBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> {
                return 8; })));
    public static final Block BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT_OFF = registerBlock("backrooms_concrete_ceiling_painted_light_off",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));

    //BACKROOMS LEVEL 2
    public static final Block BACKROOMS_PIPE_LARGE = registerBlock("backrooms_pipe_large",
            new BackroomsPipeLargeBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_PIPE_SMALL = registerBlock("backrooms_pipe_small",
            new BackroomsPipeLargeBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_GREY_BRICK_FLOOR = registerBlock("backrooms_grey_brick_floor",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_MOLDED_WALL = registerBlock("backrooms_molded_wall",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F)));
    public static final Block BACKROOMS_BROWN_CEILING = registerBlock("backrooms_brown_ceiling",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F)));

    //PLUSHES
    public static final Block ALPHA_PLUSH = registerBlock("alpha_plush",
            new AlphaPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CATLOVE_PLUSH = registerBlock("catlove_plush",
            new CatlovePlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CHEFINSANITY_PLUSH = registerBlock("chefinsanity_plush",
            new ChefInsanityPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block JARGEDES_PLUSH = registerBlock("jargedes_plush",
            new JargedesPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block JBIRD_PLUSH = registerBlock("jbird_plush",
            new JbirdPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block MCFELLA_PLUSH = registerBlock("mcfella_plush",
            new McFellaPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block MILKYFUR_PLUSH = registerBlock("milkyfur_plush",
            new MilkyFurPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block SIERRA_PLUSH = registerBlock("sierra_plush",
            new SierraPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block SLAZER_PLUSH = registerBlock("slazer_plush",
            new SlazerPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block SPIRIT_PLUSH = registerBlock("spirit_plush",
            new SpiritPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block TALON_PLUSH = registerBlock("talon_plush",
            new TalonPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block ZARSH_PLUSH = registerBlock("zarsh_plush",
            new ZarshPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));








    //WARZONE
    public static final Block LAND_MINE = registerBlock("land_mine",
            new LandMineBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));

    public static final Block LAND_MINE_ACTIVE = registerBlock("land_mine_active",
            new LandMineBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));

    //OTHER BLOCKS

    public static final Block CUBE_BLUE = registerBlock("cube_blue",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_GRAY = registerBlock("cube_gray",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_GREEN = registerBlock("cube_green",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_LIGHTBLUE = registerBlock("cube_lightblue",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_ORANGE = registerBlock("cube_orange",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_PEACH = registerBlock("cube_peach",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_PINK = registerBlock("cube_pink",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_PURPLE = registerBlock("cube_purple",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_RED = registerBlock("cube_red",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_RUSTY = registerBlock("cube_rusty",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_WHITE = registerBlock("cube_white",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));
    public static final Block CUBE_YELLOW = registerBlock("cube_yellow",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ShitMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ShitMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(ShitMod.MOD_ID, name), block);
    }

    public static void registerShitBlocks() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/block/ShitBlocks");
    }
    public static void registerShitCustomBlocks() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/block/ShitBlocks>custom");
    }
}
