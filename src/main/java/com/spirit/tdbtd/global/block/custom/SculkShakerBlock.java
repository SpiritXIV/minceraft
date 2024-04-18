package com.spirit.tdbtd.global.block.custom;

import com.spirit.tdbtd.global.block.TDBTDBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class SculkShakerBlock extends PlantBlock {
    private final Supplier<Block> groundd;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final Map<Direction, VoxelShape> SHAPES = new HashMap<>();

    public static final Map<Block, Block> SCULK_SHAKER_MAP = new HashMap<>();

    static {
            SCULK_SHAKER_MAP.put(Blocks.GRASS, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.TALL_GRASS, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.FERN, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.LARGE_FERN, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.DANDELION, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.POPPY, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.BLUE_ORCHID, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.ALLIUM, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.AZURE_BLUET, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.RED_TULIP, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.ORANGE_TULIP, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.WHITE_TULIP, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.PINK_TULIP, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.OXEYE_DAISY, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.CORNFLOWER, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.LILY_OF_THE_VALLEY, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.TORCHFLOWER, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.WITHER_ROSE, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.PINK_PETALS, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.LILAC, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.ROSE_BUSH, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.PEONY, Blocks.AIR);
            SCULK_SHAKER_MAP.put(Blocks.PITCHER_CROP, Blocks.AIR);

            SCULK_SHAKER_MAP.put(Blocks.STONE, TDBTDBlocks.INFURTRINATED_STONE);
            SCULK_SHAKER_MAP.put(Blocks.DEEPSLATE, TDBTDBlocks.INFURTRINATED_DEEPSLATE);
            SCULK_SHAKER_MAP.put(Blocks.GRANITE, TDBTDBlocks.INFURTRINATED_GRANITE);
            SCULK_SHAKER_MAP.put(Blocks.DIORITE, TDBTDBlocks.INFURTRINATED_DIORITE);
            SCULK_SHAKER_MAP.put(Blocks.ANDESITE, TDBTDBlocks.INFURTRINATED_ANDESITE);
            SCULK_SHAKER_MAP.put(Blocks.CALCITE, TDBTDBlocks.INFURTRINATED_CALCITE);
            SCULK_SHAKER_MAP.put(Blocks.TUFF, TDBTDBlocks.INFURTRINATED_TUFF);

            SCULK_SHAKER_MAP.put(Blocks.GRASS_BLOCK, TDBTDBlocks.DIMENTED_GRASS_BLOCK);
            SCULK_SHAKER_MAP.put(Blocks.PODZOL, TDBTDBlocks.DIMENTED_PODZOL);
            SCULK_SHAKER_MAP.put(Blocks.DIRT, TDBTDBlocks.DIMENTED_DIRT);
            SCULK_SHAKER_MAP.put(Blocks.COARSE_DIRT, TDBTDBlocks.DIMENTED_COARSE_DIRT);
            SCULK_SHAKER_MAP.put(Blocks.GRAVEL, TDBTDBlocks.DIMENTED_GRAVEL);
            SCULK_SHAKER_MAP.put(Blocks.SAND, TDBTDBlocks.DIMENTED_SAND);
            SCULK_SHAKER_MAP.put(Blocks.ROOTED_DIRT, TDBTDBlocks.DIMENTED_ROOTED_DIRT);

            SCULK_SHAKER_MAP.put(Blocks.OAK_LEAVES, TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
            SCULK_SHAKER_MAP.put(Blocks.OAK_LOG, TDBTDBlocks.CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_OAK_LOG, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.OAK_WOOD, TDBTDBlocks.CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_OAK_WOOD, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.SPRUCE_LEAVES, TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
            SCULK_SHAKER_MAP.put(Blocks.SPRUCE_LOG, TDBTDBlocks.CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_SPRUCE_LOG, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.SPRUCE_WOOD, TDBTDBlocks.CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_SPRUCE_WOOD, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.BIRCH_LEAVES, TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
            SCULK_SHAKER_MAP.put(Blocks.BIRCH_LOG, TDBTDBlocks.CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_BIRCH_LOG, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.BIRCH_WOOD, TDBTDBlocks.CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_BIRCH_WOOD, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.JUNGLE_LEAVES, TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
            SCULK_SHAKER_MAP.put(Blocks.JUNGLE_LOG, TDBTDBlocks.CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_JUNGLE_LOG, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.JUNGLE_WOOD, TDBTDBlocks.CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_JUNGLE_WOOD, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.ACACIA_LEAVES, TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
            SCULK_SHAKER_MAP.put(Blocks.ACACIA_LOG, TDBTDBlocks.CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_ACACIA_LOG, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.ACACIA_WOOD, TDBTDBlocks.CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_ACACIA_WOOD, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.DARK_OAK_LEAVES, TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
            SCULK_SHAKER_MAP.put(Blocks.DARK_OAK_LOG, TDBTDBlocks.CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_DARK_OAK_LOG, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.DARK_OAK_WOOD, TDBTDBlocks.CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_DARK_OAK_WOOD, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.MANGROVE_LEAVES, TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
            SCULK_SHAKER_MAP.put(Blocks.MANGROVE_LOG, TDBTDBlocks.CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_MANGROVE_LOG, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.MANGROVE_WOOD, TDBTDBlocks.CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_MANGROVE_WOOD, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.CHERRY_LEAVES, TDBTDBlocks.CRITERIC_CHARRED_LEAVES);
            SCULK_SHAKER_MAP.put(Blocks.CHERRY_LOG, TDBTDBlocks.CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_CHERRY_LOG, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG);
            SCULK_SHAKER_MAP.put(Blocks.CHERRY_WOOD, TDBTDBlocks.CRITERIC_CHARRED_WOOD);
            SCULK_SHAKER_MAP.put(Blocks.STRIPPED_CHERRY_WOOD, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD);
    }

    static {
        SHAPES.put(Direction.NORTH, createShape());
        SHAPES.put(Direction.EAST, createShape());
        SHAPES.put(Direction.SOUTH, createShape());
        SHAPES.put(Direction.WEST, createShape());
    }

    public SculkShakerBlock(Settings settings, Supplier<Block> ground) {
        super(settings);
        this.groundd = ground;
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    private static VoxelShape createShape() {
        return Stream.of(
                Block.createCuboidShape(0, 0, 0, 16, 5, 16),
                Block.createCuboidShape(0, 0, 0, 0, 15, 16),
                Block.createCuboidShape(16, 0, 0, 16, 15, 16),
                Block.createCuboidShape(0, 0, 16, 16, 15, 16),
                Block.createCuboidShape(0, 0, 0, 16, 15, 0)
        ).reduce(VoxelShapes.empty(), VoxelShapes::union);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(Properties.HORIZONTAL_FACING);
        return SHAPES.get(facing);
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SCULK);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, net.minecraft.entity.LivingEntity placer, net.minecraft.item.ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        // Replace the initial block with honey
        replaceBlock(world, pos);

        // Spread honey to nearby blocks
        spreadHoney(world, pos, 16);
    }

    private void replaceBlock(World world, BlockPos pos) {
        world.setBlockState(pos, TDBTDBlocks.SCULK_SHAKER.getDefaultState());

        // Spawn particle at the replaced block position
        spawnParticle(world, pos);
    }

    private void spreadHoney(World world, BlockPos pos, int radius) {
        Random random = world.getRandom();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos offsetPos = pos.add(x, y, z);
                    BlockState currentState = world.getBlockState(offsetPos);
                    Block replacementBlock = SCULK_SHAKER_MAP.get(currentState.getBlock());
                    if (replacementBlock != null) {
                        replaceBlockAsync(world, offsetPos, replacementBlock.getDefaultState());
                    }
                }
            }
        }
    }



    //pirate (jar) :down_arrow:
    private void replaceBlockAsync(World world, BlockPos pos, BlockState replacementState) {
        MinecraftServer server = world.getServer();
        if (server != null) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                server.execute(() -> {
                    world.setBlockState(pos, replacementState);
                    spawnParticle(world, pos);
                });
            });
        }
    }



    private void spawnParticle(World world, BlockPos pos) {
        Random random = world.getRandom();
        for (int i = 0; i < 10; i++) {
            double xOffset = random.nextGaussian() * 0.02D;
            double yOffset = random.nextGaussian() * 0.02D;
            double zOffset = random.nextGaussian() * 0.02D;
            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, xOffset, yOffset, zOffset);
        }
    }
}