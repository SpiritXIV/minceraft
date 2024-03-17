package com.spirit.tdbtd.block.custom;

import com.spirit.tdbtd.block.TDBTDBlocks;
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
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class SculkShakerBlock extends PlantBlock {
    private final Supplier<Block> groundd;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SculkShakerBlock(Settings settings, Supplier<Block> ground) {
        super(settings);
        this.groundd = ground;
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(0, 0, 0, 0, 15, 16),
            Block.createCuboidShape(16, 0, 0, 16, 15, 16),
            Block.createCuboidShape(0, 0, 16, 16, 15, 16),
            Block.createCuboidShape(0, 0, 0, 16, 15, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(0, 0, 0, 0, 15, 16),
            Block.createCuboidShape(16, 0, 0, 16, 15, 16),
            Block.createCuboidShape(0, 0, 16, 16, 15, 16),
            Block.createCuboidShape(0, 0, 0, 16, 15, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(0, 0, 0, 0, 15, 16),
            Block.createCuboidShape(16, 0, 0, 16, 15, 16),
            Block.createCuboidShape(0, 0, 16, 16, 15, 16),
            Block.createCuboidShape(0, 0, 0, 16, 15, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(0, 0, 0, 0, 15, 16),
            Block.createCuboidShape(16, 0, 0, 16, 15, 16),
            Block.createCuboidShape(0, 0, 16, 16, 15, 16),
            Block.createCuboidShape(0, 0, 0, 16, 15, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> SHAPE_N;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
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
                    Block block = currentState.getBlock();

                    if (block == Blocks.GRASS) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.TALL_GRASS) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.FERN) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.LARGE_FERN) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.DANDELION) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.POPPY) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.BLUE_ORCHID) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.ALLIUM) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.AZURE_BLUET) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.RED_TULIP) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.ORANGE_TULIP) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.WHITE_TULIP) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.PINK_TULIP) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.OXEYE_DAISY) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.CORNFLOWER) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.LILY_OF_THE_VALLEY) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.TORCHFLOWER) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.WITHER_ROSE) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.PINK_PETALS) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.DANDELION) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.LILAC) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.ROSE_BUSH) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.PEONY) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }
                    if (block == Blocks.PITCHER_CROP) {
                        replaceBlockAsync(world, offsetPos, Blocks.AIR.getDefaultState());
                    }


                    if (block == Blocks.STONE) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.INFURTRINATED_STONE.getDefaultState());
                    }
                    if (block == Blocks.DEEPSLATE) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.INFURTRINATED_DEEPSLATE.getDefaultState());
                    }
                    if (block == Blocks.GRANITE) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.INFURTRINATED_GRANITE.getDefaultState());
                    }
                    if (block == Blocks.DIORITE) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.INFURTRINATED_DIORITE.getDefaultState());
                    }
                    if (block == Blocks.ANDESITE) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.INFURTRINATED_ANDESITE.getDefaultState());
                    }
                    if (block == Blocks.CALCITE) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.INFURTRINATED_CALCITE.getDefaultState());
                    }
                    if (block == Blocks.TUFF) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.INFURTRINATED_TUFF.getDefaultState());
                    }

                    if (block == Blocks.GRASS_BLOCK) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.DIMENTED_GRASS_BLOCK.getDefaultState());
                    }
                    if (block == Blocks.PODZOL) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.DIMENTED_PODZOL.getDefaultState());
                    }
                    if (block == Blocks.DIRT) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.DIMENTED_DIRT.getDefaultState());
                    }
                    if (block == Blocks.COARSE_DIRT) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.DIMENTED_COARSE_DIRT.getDefaultState());
                    }
                    if (block == Blocks.GRAVEL) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.DIMENTED_GRAVEL.getDefaultState());
                    }
                    if (block == Blocks.SAND) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.DIMENTED_SAND.getDefaultState());
                    }
                    if (block == Blocks.ROOTED_DIRT) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.DIMENTED_ROOTED_DIRT.getDefaultState());
                    }


                    if (block == Blocks.OAK_LEAVES) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LEAVES.getDefaultState());
                    }
                    if (block == Blocks.OAK_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_OAK_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.OAK_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_OAK_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.SPRUCE_LEAVES) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LEAVES.getDefaultState());
                    }
                    if (block == Blocks.SPRUCE_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_SPRUCE_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.SPRUCE_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_SPRUCE_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.BIRCH_LEAVES) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LEAVES.getDefaultState());
                    }
                    if (block == Blocks.BIRCH_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_BIRCH_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.BIRCH_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_BIRCH_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.JUNGLE_LEAVES) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LEAVES.getDefaultState());
                    }
                    if (block == Blocks.JUNGLE_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_JUNGLE_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.JUNGLE_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_JUNGLE_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.ACACIA_LEAVES) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LEAVES.getDefaultState());
                    }
                    if (block == Blocks.ACACIA_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_ACACIA_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.ACACIA_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_ACACIA_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.DARK_OAK_LEAVES) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LEAVES.getDefaultState());
                    }
                    if (block == Blocks.DARK_OAK_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_DARK_OAK_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.DARK_OAK_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_DARK_OAK_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.MANGROVE_LEAVES) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LEAVES.getDefaultState());
                    }
                    if (block == Blocks.MANGROVE_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_MANGROVE_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.MANGROVE_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_MANGROVE_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.CHERRY_LEAVES) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LEAVES.getDefaultState());
                    }
                    if (block == Blocks.CHERRY_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_CHERRY_LOG) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_LOG.getDefaultState());
                    }
                    if (block == Blocks.CHERRY_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.CRITERIC_CHARRED_WOOD.getDefaultState());
                    }
                    if (block == Blocks.STRIPPED_CHERRY_WOOD) {
                        replaceBlockAsync(world, offsetPos, TDBTDBlocks.STRIPPED_CRITERIC_CHARRED_WOOD.getDefaultState());
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