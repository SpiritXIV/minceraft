package com.spirit.shit.block;

import com.spirit.shit.ShitMod;
import com.spirit.shit.block.custom.*;
import com.spirit.shit.block.custom.plush.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ShitBlocks {
    public static final AbstractBlock.Settings DEFAULT_SETTINGS = FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F);

    // Fields to hold blocks, now not initialized immediately
    public static Block CRACKLIN_BOX;
    public static Block GAS_CAN;
    public static Block GAS_CANISTER;
    public static Block TOILET;
    public static Block WORLD_BOMB;
    public static Block MODEM;
    public static Block COMPUTER_MOUSE;
    public static Block OLD_COMPUTER;
    public static Block RADIO;

    // PLUSHES
    public static Block ALPHA_PLUSH;
    public static Block CATLOVE_PLUSH;
    public static Block CHEFINSANITY_PLUSH;
    public static Block COMPUTER_PLUSH;
    public static Block ERIS_PLUSH;
    public static Block JARGEDES_PLUSH;
    public static Block JBIRD_PLUSH;
    public static Block MCFELLA_PLUSH;
    public static Block MILKYFUR_PLUSH;
    public static Block SIERRA_PLUSH;
    public static Block SLAZER_PLUSH;
    public static Block SPIRIT_PLUSH;
    public static Block TALON_PLUSH;
    public static Block ZARSH_PLUSH;

    //WARZONE
    public static Block LAND_MINE;
    public static Block LAND_MINE_ACTIVE;


    //POSTERS
    public static Block ULTRAKILL_POSTER;

    //BACKROOMS LEVEL 0
    public static Block BACKROOMS_LIGHT;
    public static Block BACKROOMS_LIGHT_OFF;
    public static Block BACKROOMS_FLOOR;
    public static Block BACKROOMS_FLOOR_TELEPORT;
    public static Block BACKROOMS_WALLPAPER;
    public static Block BACKROOMS_WALLPAPER_LIP;
    public static Block BACKROOMS_CEILING;
    public static Block BACKROOMS_CEILING_VENT;
    //BACKROOMS LEVEL 1
    public static Block BACKROOMS_CONCRETE_FLOOR;
    public static Block BACKROOMS_CONCRETE_WALLS;
    public static Block BACKROOMS_CONCRETE_WALLS_TUBES;
    public static Block BACKROOMS_CONCRETE_WALL_PILLAR;
    public static Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP;
    public static Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM;
    public static Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP_OFF;
    public static Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM_OFF;
    public static Block BACKROOMS_CONCRETE_WALLS_PAINTED;
    public static Block BACKROOMS_CONCRETE_CEILING;
    public static Block BACKROOMS_CONCRETE_CEILING_PAINTED;
    public static Block BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT;
    public static Block BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT_OFF;

    //BACKROOMS LEVEL 2
    public static Block BACKROOMS_PIPE_LARGE;
    public static Block BACKROOMS_PIPE_SMALL;
    public static Block BACKROOMS_WETTED_CONCRETE_FLOOR;
    public static Block BACKROOMS_WETTED_CONCRETE_WALL;
    public static Block BACKROOMS_WETTED_CONCRETE_CEILING;

    //OTHER BLOCKS

    public static Block CUBE_BLUE;
    public static Block CUBE_GRAY;
    public static Block CUBE_GREEN;
    public static Block CUBE_LIGHTBLUE;
    public static Block CUBE_ORANGE;
    public static Block CUBE_PEACH;
    public static Block CUBE_PINK;
    public static Block CUBE_PURPLE;
    public static Block CUBE_RED;
    public static Block CUBE_RUSTY;
    public static Block CUBE_WHITE;
    public static Block CUBE_YELLOW;

    // Call this method at the appropriate lifecycle event to initialize and register blocks
    public static void registerAll() {
        CRACKLIN_BOX = registerBlock("cracklin_box", new CracklinBoxBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0F).requiresTool()));
        GAS_CAN = registerBlock("gas_can", new GasCanBlock(DEFAULT_SETTINGS));
        GAS_CANISTER = registerBlock("gas_canister", new GasCanisterBlock(DEFAULT_SETTINGS));
        TOILET = registerBlock("toilet", new ToiletBlock(DEFAULT_SETTINGS));
        WORLD_BOMB = registerBlockWithoutBlockItem("world_bomb", new WorldBombBlock(DEFAULT_SETTINGS));
        MODEM = registerBlock("modem", new ModemBlock(DEFAULT_SETTINGS));
        COMPUTER_MOUSE = registerBlock("computer_mouse", new ComputerMouseBlock(DEFAULT_SETTINGS));
        OLD_COMPUTER = registerBlock("old_computer", new OldComputerBlock(DEFAULT_SETTINGS));
        RADIO = registerBlock("90s_radio", new RadioBlock(DEFAULT_SETTINGS));

        //WARZONE
        LAND_MINE = registerBlock("land_mine", new LandMineBlock(DEFAULT_SETTINGS));
        LAND_MINE_ACTIVE = registerBlock("land_mine_active", new LandMineBlock(DEFAULT_SETTINGS));

        //POSTERS
        ULTRAKILL_POSTER = registerBlock("poster_ultrakill", new UlraKillPosterBlock(DEFAULT_SETTINGS));

        //BACKROOMS LEVEL 0
        BACKROOMS_LIGHT = registerBlock("backrooms_light", new BackroomsLightBlock(FabricBlockSettings.copy(Blocks.SEA_LANTERN).sounds(BlockSoundGroup.GLASS).strength(-1.0F, 3600000.0F).luminance((state) -> 9)));
        BACKROOMS_LIGHT_OFF = registerBlock("backrooms_light_off", new Block(FabricBlockSettings.copy(Blocks.SEA_LANTERN).sounds(BlockSoundGroup.GLASS).strength(-1.0F, 3600000.0F).luminance((state) -> 0)));
        BACKROOMS_FLOOR = registerBlock("backrooms_floor", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.MUD).strength(-1.0F, 3600000.0F)));
        BACKROOMS_FLOOR_TELEPORT = registerBlock("backrooms_floor_teleport", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.MUD).strength(-1.0F, 3600000.0F)));
        BACKROOMS_WALLPAPER = registerBlock("backrooms_wallpaper", new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_WALLPAPER_LIP = registerBlock("backrooms_wallpaper_lip", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CEILING = registerBlock("backrooms_ceiling", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CEILING_VENT = registerBlock("backrooms_ceiling_vent", new BackroomsVentBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));

        //BACKROOMS LEVEL 1
        BACKROOMS_CONCRETE_FLOOR = registerBlock("backrooms_concrete_floor", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_WALLS = registerBlock("backrooms_concrete_walls", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_WALLS_TUBES = registerBlock("backrooms_concrete_walls_tubes", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_WALL_PILLAR = registerBlock("backrooms_concrete_wall_pillar", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP = registerBlock("backrooms_concrete_wall_pillar_light_top", new BackroomsConcreteLightBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> 8)));
        BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM = registerBlock("backrooms_concrete_wall_pillar_light_bottom", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> 8)));
        BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP_OFF = registerBlock("backrooms_concrete_wall_pillar_light_top_off", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM_OFF = registerBlock("backrooms_concrete_wall_pillar_light_bottom_off", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_WALLS_PAINTED = registerBlock("backrooms_concrete_walls_painted", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_CEILING = registerBlock("backrooms_concrete_ceiling", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_CEILING_PAINTED = registerBlock("backrooms_concrete_ceiling_painted", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT = registerBlock("backrooms_concrete_ceiling_painted_light", new BackroomsConcreteLightBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> 8)));
        BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT_OFF = registerBlock("backrooms_concrete_ceiling_painted_light_off", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));

        //BACKROOMS LEVEL 2
        BACKROOMS_PIPE_LARGE = registerBlock("backrooms_pipe_large", new BackroomsPipeLargeBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_PIPE_SMALL = registerBlock("backrooms_pipe_small", new BackroomsPipeLargeBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F)));
        BACKROOMS_WETTED_CONCRETE_FLOOR = registerBlock("backrooms_wetted_concrete_floor", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F)));
        BACKROOMS_WETTED_CONCRETE_WALL = registerBlock("backrooms_wetted_concrete_wall", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F)));
        BACKROOMS_WETTED_CONCRETE_CEILING = registerBlock("backrooms_wetted_concrete_ceiling", new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F)));

        //OTHER BLOCKS

        CUBE_BLUE = registerBlock("cube_blue", new Block(DEFAULT_SETTINGS));
        CUBE_GRAY = registerBlock("cube_gray", new Block(DEFAULT_SETTINGS));
        CUBE_GREEN = registerBlock("cube_green", new Block(DEFAULT_SETTINGS));
        CUBE_LIGHTBLUE = registerBlock("cube_lightblue", new Block(DEFAULT_SETTINGS));
        CUBE_ORANGE = registerBlock("cube_orange", new Block(DEFAULT_SETTINGS));
        CUBE_PEACH = registerBlock("cube_peach", new Block(DEFAULT_SETTINGS));
        CUBE_PINK = registerBlock("cube_pink", new Block(DEFAULT_SETTINGS));
        CUBE_PURPLE = registerBlock("cube_purple", new Block(DEFAULT_SETTINGS));
        CUBE_RED = registerBlock("cube_red", new Block(DEFAULT_SETTINGS));
        CUBE_RUSTY = registerBlock("cube_rusty", new Block(DEFAULT_SETTINGS));
        CUBE_WHITE = registerBlock("cube_white", new Block(DEFAULT_SETTINGS));
        CUBE_YELLOW = registerBlock("cube_yellow", new Block(DEFAULT_SETTINGS));

        // Plushes
        ALPHA_PLUSH = registerBlock("alpha_plush", new AlphaPlushBlock(DEFAULT_SETTINGS));
        CATLOVE_PLUSH = registerBlock("catlove_plush", new CatlovePlushBlock(DEFAULT_SETTINGS));
        CHEFINSANITY_PLUSH = registerBlock("chefinsanity_plush", new ChefInsanityPlushBlock(DEFAULT_SETTINGS));
        COMPUTER_PLUSH = registerBlock("computer_plush", new ComputerPlushBlock(DEFAULT_SETTINGS));
        ERIS_PLUSH = registerBlock("eris_plush", new ComputerPlushBlock(DEFAULT_SETTINGS)); // Note: Should this be ComputerPlushBlock?
        JARGEDES_PLUSH = registerBlock("jargedes_plush", new JargedesPlushBlock(DEFAULT_SETTINGS));
        JBIRD_PLUSH = registerBlock("jbird_plush", new JbirdPlushBlock(DEFAULT_SETTINGS));
        MCFELLA_PLUSH = registerBlock("mcfella_plush", new McFellaPlushBlock(DEFAULT_SETTINGS));
        MILKYFUR_PLUSH = registerBlock("milkyfur_plush", new MilkyFurPlushBlock(DEFAULT_SETTINGS));
        SIERRA_PLUSH = registerBlock("sierra_plush", new SierraPlushBlock(DEFAULT_SETTINGS));
        SLAZER_PLUSH = registerBlock("slazer_plush", new SlazerPlushBlock(DEFAULT_SETTINGS));
        SPIRIT_PLUSH = registerBlock("spirit_plush", new SpiritPlushBlock(DEFAULT_SETTINGS));
        TALON_PLUSH = registerBlock("talon_plush", new TalonPlushBlock(DEFAULT_SETTINGS));
        ZARSH_PLUSH = registerBlock("zarsh_plush", new ZarshPlushBlock(DEFAULT_SETTINGS));
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/block/ShitBlocks");
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ShitMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(ShitMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(ShitMod.MOD_ID, name), block);
    }
}
