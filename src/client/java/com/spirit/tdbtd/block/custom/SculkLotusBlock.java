package com.spirit.tdbtd.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class SculkLotusBlock extends PlantBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SculkLotusBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 0, 16),
            Block.createCuboidShape(3, 0, 3, 13, 4, 13),
            Block.createCuboidShape(7, 0, 7, 9, 3, 9),
            Block.createCuboidShape(5, 1, 3, 11, 1, 7),
            Block.createCuboidShape(3, 1, 5, 7, 1, 11),
            Block.createCuboidShape(5, 1, 9, 11, 1, 13),
            Block.createCuboidShape(9, 1, 5, 13, 1, 11),
            Block.createCuboidShape(3, -0, 8, 13, -0, 15),
            Block.createCuboidShape(0, -0, 3, 7, -0, 13),
            Block.createCuboidShape(3, -0, 0, 13, -0, 7),
            Block.createCuboidShape(8, -0, 3, 15, -0, 13),
            Block.createCuboidShape(8, -0, 3, 15, -0, 13),
            Block.createCuboidShape(3, -0, 8, 13, -0, 15),
            Block.createCuboidShape(0, -0, 3, 7, -0, 13),
            Block.createCuboidShape(3, -0, 0, 13, -0, 7),
            Block.createCuboidShape(0, -10, 8, 16, 0, 8),
            Block.createCuboidShape(8, -10, 0, 8, 0, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 0, 16),
            Block.createCuboidShape(3, 0, 3, 13, 4, 13),
            Block.createCuboidShape(7, 0, 7, 9, 3, 9),
            Block.createCuboidShape(5, 1, 3, 11, 1, 7),
            Block.createCuboidShape(3, 1, 5, 7, 1, 11),
            Block.createCuboidShape(5, 1, 9, 11, 1, 13),
            Block.createCuboidShape(9, 1, 5, 13, 1, 11),
            Block.createCuboidShape(3, -0, 8, 13, -0, 15),
            Block.createCuboidShape(0, -0, 3, 7, -0, 13),
            Block.createCuboidShape(3, -0, 0, 13, -0, 7),
            Block.createCuboidShape(8, -0, 3, 15, -0, 13),
            Block.createCuboidShape(8, -0, 3, 15, -0, 13),
            Block.createCuboidShape(3, -0, 8, 13, -0, 15),
            Block.createCuboidShape(0, -0, 3, 7, -0, 13),
            Block.createCuboidShape(3, -0, 0, 13, -0, 7),
            Block.createCuboidShape(0, -10, 8, 16, 0, 8),
            Block.createCuboidShape(8, -10, 0, 8, 0, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 0, 16),
            Block.createCuboidShape(3, 0, 3, 13, 4, 13),
            Block.createCuboidShape(7, 0, 7, 9, 3, 9),
            Block.createCuboidShape(5, 1, 3, 11, 1, 7),
            Block.createCuboidShape(3, 1, 5, 7, 1, 11),
            Block.createCuboidShape(5, 1, 9, 11, 1, 13),
            Block.createCuboidShape(9, 1, 5, 13, 1, 11),
            Block.createCuboidShape(3, -0, 8, 13, -0, 15),
            Block.createCuboidShape(0, -0, 3, 7, -0, 13),
            Block.createCuboidShape(3, -0, 0, 13, -0, 7),
            Block.createCuboidShape(8, -0, 3, 15, -0, 13),
            Block.createCuboidShape(8, -0, 3, 15, -0, 13),
            Block.createCuboidShape(3, -0, 8, 13, -0, 15),
            Block.createCuboidShape(0, -0, 3, 7, -0, 13),
            Block.createCuboidShape(3, -0, 0, 13, -0, 7),
            Block.createCuboidShape(0, -10, 8, 16, 0, 8),
            Block.createCuboidShape(8, -10, 0, 8, 0, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 0, 16),
            Block.createCuboidShape(3, 0, 3, 13, 4, 13),
            Block.createCuboidShape(7, 0, 7, 9, 3, 9),
            Block.createCuboidShape(5, 1, 3, 11, 1, 7),
            Block.createCuboidShape(3, 1, 5, 7, 1, 11),
            Block.createCuboidShape(5, 1, 9, 11, 1, 13),
            Block.createCuboidShape(9, 1, 5, 13, 1, 11),
            Block.createCuboidShape(3, -0, 8, 13, -0, 15),
            Block.createCuboidShape(0, -0, 3, 7, -0, 13),
            Block.createCuboidShape(3, -0, 0, 13, -0, 7),
            Block.createCuboidShape(8, -0, 3, 15, -0, 13),
            Block.createCuboidShape(8, -0, 3, 15, -0, 13),
            Block.createCuboidShape(3, -0, 8, 13, -0, 15),
            Block.createCuboidShape(0, -0, 3, 7, -0, 13),
            Block.createCuboidShape(3, -0, 0, 13, -0, 7),
            Block.createCuboidShape(0, -10, 8, 16, 0, 8),
            Block.createCuboidShape(8, -10, 0, 8, 0, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
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

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        double d = (double)i + random.nextDouble();
        double e = (double)j + 0.7;
        double f = (double)k + random.nextDouble();
        world.addParticle(ParticleTypes.SCULK_CHARGE_POP, d, e, f, 0.0, 0.0, 0.0);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int l = 0; l < 14; ++l) {
            mutable.set(i + MathHelper.nextInt(random, -10, 10), j - random.nextInt(10), k + MathHelper.nextInt(random, -10, 10));
            BlockState blockState = world.getBlockState(mutable);
            if (blockState.isFullCube(world, mutable)) continue;
            world.addParticle(ParticleTypes.SCULK_CHARGE_POP, (double)mutable.getX() + random.nextDouble(), (double)mutable.getY() + random.nextDouble(), (double)mutable.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);
        FluidState fluidState2 = world.getFluidState(pos.up());
        return (fluidState.getFluid() == Fluids.WATER || floor.getBlock() instanceof IceBlock) && fluidState2.getFluid() == Fluids.EMPTY;
    }
}
