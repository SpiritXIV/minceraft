package com.spirit.shit.global.block;

import com.spirit.Main;
import com.spirit.shit.global.block.custom.*;
import com.spirit.shit.global.block.custom.plush.*;
import com.spirit.shit.global.block.custom.SuitCaseBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShitBlocks {
    public static final Block CRACKLIN_BOX = new CracklinBoxBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0F).requiresTool());
    public static final Block GAS_CAN = new GasCanBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block GAS_CANISTER = new GasCanisterBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block TOILET = new ToiletBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block WORLD_BOMB = new WorldBombBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));

    public static final Block MODEM = new ModemBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block COMPUTER_MOUSE = new ComputerMouseBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block OLD_COMPUTER = new OldComputerBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block RADIO = new RadioBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));

    //POSTERS
    public static final Block ULTRAKILL_POSTER = new UltraKillPosterBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));

    //BACKROOMS LEVEL 0
    public static final Block BACKROOMS_LIGHT = new BackroomsLightBlock(FabricBlockSettings.copy(Blocks.SEA_LANTERN).sounds(BlockSoundGroup.GLASS).strength(-1.0F, 3600000.0F).luminance((state) -> 9));
    public static final Block BACKROOMS_LIGHT_OFF = new BackroomsBrokenLightBlock(FabricBlockSettings.copy(Blocks.SEA_LANTERN).sounds(BlockSoundGroup.GLASS).strength(-1.0F, 3600000.0F).luminance((state) -> 0));
    public static final Block BACKROOMS_FLOOR = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.MUD).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_FLOOR_TELEPORT = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.MUD).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_WALLPAPER = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_WALLPAPER_LIP = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CEILING = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CEILING_VENT = new BackroomsVentBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    //BACKROOMS LEVEL 1
    public static final Block BACKROOMS_CONCRETE_FLOOR = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_WALLS = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_WALLS_TUBES = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP = new BackroomsConcreteLightBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> 8));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> 8));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP_OFF = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM_OFF = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_WALLS_PAINTED = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_CEILING = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_CEILING_PAINTED = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT = new BackroomsConcreteLightBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F).luminance((state) -> 8));
    public static final Block BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT_OFF = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));

    //BACKROOMS LEVEL 2
    public static final Block BACKROOMS_PIPE_LARGE = new BackroomsPipeLargeBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_PIPE_SMALL = new BackroomsPipeLargeBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_WETTED_CONCRETE_FLOOR = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_WETTED_CONCRETE_WALL = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_WETTED_CONCRETE_CEILING = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(-1.0F, 3600000.0F));
    public static final Block BACKROOMS_INDUSTRIAL_LIGHT = new BackroomsIndustrialLightBlock(FabricBlockSettings.copy(Blocks.SEA_LANTERN).sounds(BlockSoundGroup.GLASS).strength(-1.0F, 3600000.0F).luminance((state) -> 9));
    public static final Block BACKROOMS_INDUSTRIAL_LIGHT_SHATTERED = new BackroomsIndustrialBrokenLightBlock(FabricBlockSettings.copy(Blocks.SEA_LANTERN).sounds(BlockSoundGroup.GLASS).strength(-1.0F, 3600000.0F).luminance((state) -> 0));

    //PLUSHES
    public static final Block ALPHA_PLUSH = new AlphaPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CATLOVE_PLUSH = new CatlovePlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CHEFINSANITY_PLUSH = new ChefInsanityPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block COMPUTER_PLUSH = new ComputerPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block ERIS_PLUSH = new ComputerPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block JARGEDES_PLUSH = new JargedesPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block JBIRD_PLUSH = new JbirdPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block KINGZHARA_PLUSH = new KingZharaPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block MCFELLA_PLUSH = new McFellaPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block MILKYFUR_PLUSH = new MilkyFurPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block SIERRA_PLUSH = new SierraPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block SLAZER_PLUSH = new SlazerPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block SPIRIT_PLUSH = new SpiritPlushBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));

    //WARZONE
    public static final Block LAND_MINE = new LandMineBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));

    //OTHER BLOCKS
    public static final Block CUBE_BLUE = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_GRAY = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_GREEN = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_LIGHTBLUE = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_ORANGE = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_PEACH = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_PINK = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_PURPLE = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_RED = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_RUSTY = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_WHITE = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));
    public static final Block CUBE_YELLOW = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));

    //ORES
    public static final Block BAUXITE_ORE = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).requiresTool().strength(2.0F));
    public static final Block DEEPSLATE_BAUXITE_ORE = new Block(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).requiresTool().strength(2.0F));

    //MONEY
    public static final Block ONE_MOMEN_STACK = new MomenBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).ticksRandomly().dropsNothing().burnable().strength(-1.0F, 3600000.0F), 9);
    public static final Block FIVE_MOMEN_STACK = new MomenBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).ticksRandomly().dropsNothing().burnable().strength(-1.0F, 3600000.0F), 45);
    public static final Block TEN_MOMEN_STACK = new MomenBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).ticksRandomly().dropsNothing().burnable().strength(-1.0F, 3600000.0F), 90);
    public static final Block TWENTY_MOMEN_STACK = new MomenBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).ticksRandomly().dropsNothing().burnable().strength(-1.0F, 3600000.0F), 180);
    public static final Block FIFTY_MOMEN_STACK = new MomenBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).ticksRandomly().dropsNothing().burnable().strength(-1.0F, 3600000.0F), 450);
    public static final Block ONEHUNDRED_MOMEN_STACK = new MomenBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).ticksRandomly().dropsNothing().burnable().strength(-1.0F, 3600000.0F), 900);
    public static final Block FIVEHUNDRED_MOMEN_STACK = new MomenBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).ticksRandomly().dropsNothing().burnable().strength(-1.0F, 3600000.0F), 4500);
    public static final Block SUITCASE = new SuitCaseBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).requiresTool().strength(2.0F));

    static Map<String, Object> BLOCKS = Stream.of(new Object[][] {
            {"cracklin_box", CRACKLIN_BOX},
            {"gas_can", GAS_CAN},
            {"gas_canister", GAS_CANISTER},
            {"toilet", TOILET},
            {"modem", MODEM},
            {"computer_mouse", COMPUTER_MOUSE},
            {"old_computer", OLD_COMPUTER},
            {"90s_radio", RADIO},
            {"poster_ultrakill", ULTRAKILL_POSTER},
            {"backrooms_light", BACKROOMS_LIGHT},
            {"backrooms_light_off", BACKROOMS_LIGHT_OFF},
            {"backrooms_floor", BACKROOMS_FLOOR},
            {"backrooms_floor_teleport", BACKROOMS_FLOOR_TELEPORT},
            {"backrooms_wallpaper", BACKROOMS_WALLPAPER},
            {"backrooms_wallpaper_lip", BACKROOMS_WALLPAPER_LIP},
            {"backrooms_ceiling", BACKROOMS_CEILING},
            {"backrooms_ceiling_vent", BACKROOMS_CEILING_VENT},
            {"backrooms_concrete_floor", BACKROOMS_CONCRETE_FLOOR},
            {"backrooms_concrete_walls", BACKROOMS_CONCRETE_WALLS},
            {"backrooms_concrete_walls_tubes", BACKROOMS_CONCRETE_WALLS_TUBES},
            {"backrooms_concrete_wall_pillar", BACKROOMS_CONCRETE_WALL_PILLAR},
            {"backrooms_concrete_wall_pillar_light_top", BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP},
            {"backrooms_concrete_wall_pillar_light_bottom", BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM},
            {"backrooms_concrete_wall_pillar_light_top_off", BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP_OFF},
            {"backrooms_concrete_wall_pillar_light_bottom_off", BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM_OFF},
            {"backrooms_concrete_walls_painted", BACKROOMS_CONCRETE_WALLS_PAINTED},
            {"backrooms_concrete_ceiling", BACKROOMS_CONCRETE_CEILING},
            {"backrooms_concrete_ceiling_painted", BACKROOMS_CONCRETE_CEILING_PAINTED},
            {"backrooms_concrete_ceiling_painted_light", BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT},
            {"backrooms_concrete_ceiling_painted_light_off", BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT_OFF},
            {"backrooms_pipe_large", BACKROOMS_PIPE_LARGE},
            {"backrooms_pipe_small", BACKROOMS_PIPE_SMALL},
            {"backrooms_wetted_concrete_floor", BACKROOMS_WETTED_CONCRETE_FLOOR},
            {"backrooms_wetted_concrete_wall", BACKROOMS_WETTED_CONCRETE_WALL},
            {"backrooms_wetted_concrete_ceiling", BACKROOMS_WETTED_CONCRETE_CEILING},
            {"backrooms_industrial_light", BACKROOMS_INDUSTRIAL_LIGHT},
            {"backrooms_industrial_light_shattered", BACKROOMS_INDUSTRIAL_LIGHT_SHATTERED},

            {"alpha_plush", ALPHA_PLUSH},
            {"catlove_plush", CATLOVE_PLUSH},
            {"chefinsanity_plush", CHEFINSANITY_PLUSH},
            {"computer_plush", COMPUTER_PLUSH},
            {"eris_plush", ERIS_PLUSH},
            {"jargedes_plush", JARGEDES_PLUSH},
            {"jbird_plush", JBIRD_PLUSH},
            {"kingzhara_plush", KINGZHARA_PLUSH},
            {"mcfella_plush", MCFELLA_PLUSH},
            {"milkyfur_plush", MILKYFUR_PLUSH},
            {"sierra_plush", SIERRA_PLUSH},
            {"slazer_plush", SLAZER_PLUSH},
            {"spirit_plush", SPIRIT_PLUSH},
            {"land_mine", LAND_MINE},
            {"cube_blue", CUBE_BLUE},
            {"cube_gray", CUBE_GRAY},
            {"cube_green", CUBE_GREEN},
            {"cube_lightblue", CUBE_LIGHTBLUE},
            {"cube_orange", CUBE_ORANGE},
            {"cube_peach", CUBE_PEACH},
            {"cube_pink", CUBE_PINK},
            {"cube_purple", CUBE_PURPLE},
            {"cube_red", CUBE_RED},
            {"cube_rusty", CUBE_RUSTY},
            {"cube_white", CUBE_WHITE},
            {"cube_yellow", CUBE_YELLOW},
            {"bauxite_ore", BAUXITE_ORE},
            {"deepslate_bauxite_ore", DEEPSLATE_BAUXITE_ORE},

            {"1_momen_stack", ONE_MOMEN_STACK},
            {"5_momen_stack", FIVE_MOMEN_STACK},
            {"10_momen_stack", TEN_MOMEN_STACK},
            {"20_momen_stack", TWENTY_MOMEN_STACK},
            {"50_momen_stack", FIFTY_MOMEN_STACK},
            {"100_momen_stack", ONEHUNDRED_MOMEN_STACK},
            {"500_momen_stack", FIVEHUNDRED_MOMEN_STACK},
            {"suitcase", SUITCASE}

    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));

    public static void registerAll() {
        for (Map.Entry<String, Object> entry : BLOCKS.entrySet()) {
            String key = entry.getKey();
            Block value = (Block) entry.getValue();

            registerBlock(key, value);
        }
        registerBlockWithoutBlockItem("world_bomb", WORLD_BOMB);
    }

    private static void registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Registry.register(Registries.BLOCK, new Identifier(Main.SHIT_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Main.SHIT_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static void registerBlockWithoutBlockItem(String name, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(Main.SHIT_ID, name), block);
    }
}
