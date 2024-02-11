package com.spirit.tdbtd.block;

import com.spirit.Main;
import com.spirit.tdbtd.block.custom.*;
import com.spirit.tdbtd.world.tree.SculkCharredSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TDBTDBlocks {
    //EXTRA BLOCKS
    public static final Block INFURTRINATED_BLOCK = new PillarBlock(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.SCULK_SHRIEKER).strength(5f).requiresTool());

    //SCULK ORES
    public static final Block INFURTRINATED_DEEPSLATE_ORE = new Block(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.DEEPSLATE).strength(5f).requiresTool());
    //SCULK CHARRED WOOD
    public static final Block CRITERIC_CHARRED_PLANKS = new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.BASALT).requiresTool());
    public static final Block CRITERIC_CHARRED_SAPLING = new TDBTDSaplingBlock(new SculkCharredSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SCULK_VEIN).nonOpaque(), () -> TDBTDBlocks.DIMENTED_GRASS_BLOCK);
    public static final Block CRITERIC_CHARRED_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool());
    public static final Block STRIPPED_CRITERIC_CHARRED_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool());
    public static final Block STRIPPED_CRITERIC_CHARRED_WOOD = new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool());
    public static final Block CRITERIC_CHARRED_WOOD = new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool());
    public static final Block CRITERIC_CHARRED_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.AZALEA_LEAVES).sounds(BlockSoundGroup.SCULK_VEIN).nonOpaque().requiresTool());
    public static final Block CRITERIC_CHARRED_FLOWER_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.FLOWERING_AZALEA_LEAVES).sounds(BlockSoundGroup.SCULK_VEIN).nonOpaque().requiresTool());
    public static final Block CRITERIC_CHARRED_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool());
    public static final Block CRITERIC_CHARRED_FENCE = new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool());
    public static final Block CRITERIC_CHARRED_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool(), /*TEMP*/WoodType.WARPED);
    public static final Block CRITERIC_CHARRED_STAIRS = new StairsBlock(TDBTDBlocks.CRITERIC_CHARRED_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool());
    public static final Block CRITERIC_CHARRED_BUTTON = new ButtonBlock(FabricBlockSettings.copy(Blocks.STONE_BUTTON).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool().noCollision(), /*TEMP*/BlockSetType.WARPED, 5, false);

    public static final Block CRITERIC_CHARRED_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.STONE_BUTTON).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool(), /*TEMP*/BlockSetType.WARPED);

    public static final Block CRITERIC_CHARRED_DOOR = new DoorBlock(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool().nonOpaque(), /*TEMP*/BlockSetType.WARPED);
    public static final Block CRITERIC_CHARRED_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool().nonOpaque(), /*TEMP*/BlockSetType.WARPED);

    /*public static final Block CRITERIC_CHARRED_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("criteric_charred_wall_sign",
        new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), TDBTDSignTypes.CRITERIC_CHARRED));
    public static final Block CRITERIC_CHARRED_SIGN_BLOCK = registerBlock("criteric_charred_sign",
        new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), TDBTDSignTypes.CRITERIC_CHARRED));

OTHER
    public static final Block SCULK_RAILS = registerBlock("sculk_rails",
        new RailBlock(FabricBlockSettings.copy(Blocks.ACTIVATOR_RAIL).sounds(BlockSoundGroup.SCULK_CATALYST).strength(4.0F).requiresTool()));
     */

    //DIMENTED
    public static final Block DIMENTED_GRASS_BLOCK = new TDBTDGrassBlock(AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool());
    public static final Block DIMENTED_DIRT = new Block(AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool().ticksRandomly());

    public static final Block DIMENTED_FARMLAND = new TDBTDFarmlandBlock(FabricBlockSettings.copy(Blocks.FARMLAND).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool().ticksRandomly());

//public static final Block DIMENTED_DIRT_PATH = registerBlock("dimented_dirt_path",
//       new TDBTDDirtPathBlock(FabricBlockSettings.copy(Blocks.DIRT_PATH).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool().ticksRandomly()));

    public static final Block DIMENTED_PODZOL = new GrassBlock(FabricBlockSettings.copy(Blocks.PODZOL).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool());
    public static final Block DIMENTED_ROOTED_DIRT = new RootedDirtBlock(FabricBlockSettings.copy(Blocks.ROOTED_DIRT).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool());
    public static final Block DIMENTED_COARSE_DIRT = new Block(FabricBlockSettings.copy(Blocks.COARSE_DIRT).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool());
    public static final Block DIMENTED_GRAVEL = new GravelBlock(FabricBlockSettings.copy(Blocks.GRAVEL).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool());
    public static final Block DIMENTED_SAND = new SandBlock(0, FabricBlockSettings.copy(Blocks.SAND).sounds(BlockSoundGroup.ROOTED_DIRT).strength(2.0F).requiresTool());

    // INFURTRINATED
    public static final Block INFURTRINATED_CHAIN = new TDBTDChainBlock(FabricBlockSettings.copy(Blocks.CHAIN).sounds(BlockSoundGroup.NETHERITE).strength(4.0F).requiresTool().nonOpaque());
    public static final Block INFURTRINATED_ANDESITE = new Block(FabricBlockSettings.copy(Blocks.ANDESITE).sounds(BlockSoundGroup.SCULK_CATALYST).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_CALCITE = new Block(FabricBlockSettings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_COBBLED_DEEPSLATE = new Block(FabricBlockSettings.copy(Blocks.COBBLED_DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_COBBLESTONE = new Block(FabricBlockSettings.copy(Blocks.COBBLESTONE).sounds(BlockSoundGroup.SCULK_CATALYST).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE = new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_DIORITE = new Block(FabricBlockSettings.copy(Blocks.DIORITE).sounds(BlockSoundGroup.SCULK_CATALYST).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_GRANITE = new Block(FabricBlockSettings.copy(Blocks.GRANITE).sounds(BlockSoundGroup.SCULK_CATALYST).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_SMOOTH_BASALT = new Block(FabricBlockSettings.copy(Blocks.SMOOTH_BASALT).sounds(BlockSoundGroup.BASALT).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_STONE = new Block(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.SCULK_CATALYST).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_TUFF = new Block(FabricBlockSettings.copy(Blocks.TUFF).sounds(BlockSoundGroup.TUFF).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_BLACKSTONE = new Block(FabricBlockSettings.copy(Blocks.TUFF).sounds(BlockSoundGroup.STONE).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_BASALT = new Block(FabricBlockSettings.copy(Blocks.TUFF).sounds(BlockSoundGroup.BASALT).strength(2.0F).requiresTool());
    public static final Block INFURTRINATED_COBBLED_DEEPSLATE_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_COBBLED_DEEPSLATE_STAIRS = new StairsBlock(TDBTDBlocks.INFURTRINATED_COBBLED_DEEPSLATE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_COBBLED_DEEPSLATE_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE_BRICKS = new Block(FabricBlockSettings.copy(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE_BRICKS_STAIRS = new StairsBlock(TDBTDBlocks.INFURTRINATED_DEEPSLATE_BRICKS.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE_BRICKS_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block CRACKED_INFURTRINATED_DEEPSLATE_BRICKS = new Block(FabricBlockSettings.copy(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE_TILES = new Block(FabricBlockSettings.copy(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE_TILES_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE_TILES_STAIRS = new StairsBlock(TDBTDBlocks.INFURTRINATED_DEEPSLATE_TILES.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_DEEPSLATE_TILES_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block CRACKED_INFURTRINATED_DEEPSLATE_TILES = new Block(FabricBlockSettings.copy(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_STONE_BRICKS = new Block(FabricBlockSettings.copy(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.STONE).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_STONE_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.STONE).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_STONE_BRICKS_STAIRS = new StairsBlock(TDBTDBlocks.INFURTRINATED_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_STONE_BRICKS_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.STONE).strength(4.0F).requiresTool());
    public static final Block CRACKED_INFURTRINATED_STONE_BRICKS = new Block(FabricBlockSettings.copy(Blocks.STONE_BRICKS).sounds(BlockSoundGroup.STONE).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_COBBLESTONE_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_SLAB).sounds(BlockSoundGroup.STONE).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_COBBLESTONE_BRICKS_STAIRS = new StairsBlock(TDBTDBlocks.INFURTRINATED_COBBLESTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(4.0F).requiresTool());
    public static final Block INFURTRINATED_COBBLESTONE_BRICKS_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.STONE).strength(4.0F).requiresTool());

    //CRITERIC
    public static final Block CRITERIC_VINES_HEAD = new TDBTDCaveVinesHeadBlock(FabricBlockSettings.copy(Blocks.STONE).ticksRandomly().noCollision().luminance(CaveVines.getLuminanceSupplier(3)).breakInstantly().sounds(BlockSoundGroup.SCULK_VEIN).strength(2.0F).requiresTool());

    public static final Block CRITERIC_VINES_BODY = new TDBTDCaveVinesBodyBlock(FabricBlockSettings.copy(Blocks.STONE).noCollision().luminance(CaveVines.getLuminanceSupplier(3)).breakInstantly().sounds(BlockSoundGroup.SCULK_VEIN).strength(2.0F).requiresTool());


    //SPECIAL BLOCKS
    public static final Block SCULK_TEETH = new SculkTeethBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_RIBS = new SculkRibBlock(FabricBlockSettings.copy(Blocks.SCULK_CATALYST).noCollision().sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F), () -> Blocks.SCULK);
    public static final Block SCULK_TENVINES = new TenVinesBlock(FabricBlockSettings.copy(Blocks.TWISTING_VINES).noCollision().sounds(BlockSoundGroup.SCULK_VEIN).nonOpaque().strength(2.0F), () -> Blocks.SCULK);
    public static final Block SCULK_TENVINES_PLANT = new TenVinesPlantBlock(FabricBlockSettings.copy(Blocks.TWISTING_VINES_PLANT).noCollision().sounds(BlockSoundGroup.SCULK_VEIN).nonOpaque().strength(2.0F), () -> Blocks.SCULK);

    public static final Block SCULK_FERN = new TDBTDSmallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);

    public static final Block LARGE_SCULK_FERN = new TDBTDTallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);

    public static final Block SCULK_LOTUS = new SculkLotusBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F).requiresTool());

    public static final Block SCULK_TENDRIL = new SculkTenDrilBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_FOUNTAIN_SHROOM = new TDBTDSmallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_SHROOM = new TDBTDSmallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_BUD = new TDBTDSmallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_GROWTH = new TDBTDSmallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_TAIL = new TDBTDTallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_SPIKE = new TDBTDSmallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_WEB = new TDBTDSmallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_BONESHAFT = new TDBTDSmallPlantBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_THORNS = new SculkThornsBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).noCollision().nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_EMITTER = new SculkEmitterBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_SHAKER = new SculkShakerBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block SCULK_MAW = new SculkMawBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F).requiresTool(), () -> Blocks.SCULK);
    public static final Block LAYERED_SCULK = new SculkBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F).requiresTool());

    public static final Block PULSING_SCULK = new SculkBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK).strength(2.0F).requiresTool());



    public static final Block FRAMED_SCULK = new Block(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F).requiresTool());


    public static final Block DEEPSLATE_VASE = new DeepslateVaseBlock(FabricBlockSettings.copy(Blocks.SCULK).sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque().strength(2.0F).requiresTool());



    //OTHER BLOCKS
    public static final Block UNLIT_LANTERN = new UnlitLanternBlock(FabricBlockSettings.copy(Blocks.LANTERN).sounds(BlockSoundGroup.LANTERN).requiresTool().strength(3.5f).luminance(state -> 0));





    //SCULKED MOD IMPORTS

    public static final Block INFURTRINATED_BONED_BLOCK = new PillarBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block INFURTRINATED_BONED_BULB = new PillarBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block INFURTRINATED_BONED_BULBLIGHT = new Block(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block INFURTRINATED_BONED_CAGE = new Block(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block INFURTRINATED_BONED_VERTEBRAE = new PillarBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block PILLARED_INFURTRINATED_BONED_VERTEBRAE = new PillarBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block INFURTRINATED_BONED_BRICKED_BLOCK = new PillarBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block CHISELED_INFURTRINATED_BONED_BLOCK = new Block(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block BEDEVIL_BOOKSHELF = new Block(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block BEDEVIL_WELL = new Block(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());

    public static final Block INFURTRINATED_BONED_BARS = new PaneBlock(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());

    public static final Block INFURTRINATED_BONED_DOOR = new DoorBlock(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool().nonOpaque(), /*TEMP*/BlockSetType.WARPED);
    public static final Block INFURTRINATED_BONED_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).strength(4.0F).requiresTool().nonOpaque(), /*TEMP*/BlockSetType.WARPED);


    public static final Block CRITERIC_MOSS_CARPET = new CarpetBlock(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());
    public static final Block CRITERIC_MOSS_BLOCK = new TDBTDMossBlock(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.BONE).strength(5f).requiresTool());



    public static final Block ECHOING_AMETHYST = new EchoingAmethystBlock(FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(5f).requiresTool());
    public static final Block BUDDING_ECHOING_AMETHYST = new BuddingEchoingAmethystBlock(FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK).ticksRandomly().sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(5f).requiresTool());
    public static final Block SMALL_ECHOING_AMETHYST_BUD = new EchoingAmethystClusterBlock(3, 4, FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(5f).requiresTool().luminance((state) -> 1));
    public static final Block MEDIUM_ECHOING_AMETHYST_BUD = new EchoingAmethystClusterBlock(4, 3, FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(5f).requiresTool().luminance((state) -> 2));
    public static final Block LARGE_ECHOING_AMETHYST_BUD = new EchoingAmethystClusterBlock(5, 3, FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(5f).requiresTool().luminance((state) -> 4));
    public static final Block ECHOING_AMETHYST_CLUSTER = new EchoingAmethystClusterBlock(7, 3, FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(5f).requiresTool().luminance((state) -> 5));


    public static Map<String, Object> BLOCKS = Stream.of(new Object[][] {
            {"infurtrinated_block", INFURTRINATED_BLOCK},
            {"infurtrinated_deepslate_ore", INFURTRINATED_DEEPSLATE_ORE},
            {"criteric_charred_planks", CRITERIC_CHARRED_PLANKS},
            {"criteric_charred_sapling", CRITERIC_CHARRED_SAPLING},
            {"criteric_charred_log", CRITERIC_CHARRED_LOG},
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



    //REGISTRY
    public static void registerAll() {
        for (Map.Entry<String, Object> entry : BLOCKS.entrySet()) {
            String key = entry.getKey();
            Block value = (Block) entry.getValue();

            registerBlock(key, value);
        }
        //registerBlockWithoutBlockItem("world_bomb", WORLD_BOMB);
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
}
