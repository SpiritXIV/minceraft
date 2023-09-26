package com.spirit.shit.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class BackroomsPipeSmallBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public BackroomsPipeSmallBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(0, 1, 0, 16, 6, 5),
            Block.createCuboidShape(0, 8.25, 0, 16, 11.25, 3),
            Block.createCuboidShape(0, 11.75, 0, 16, 15.75, 4),
            Block.createCuboidShape(1, 7, 0, 8, 8, 2),
            Block.createCuboidShape(2, 5.5, 0.25, 3, 7.5, 1.25),
            Block.createCuboidShape(6, 5.5, 0.25, 7, 7.5, 1.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(11, 1, 0, 16, 6, 16),
            Block.createCuboidShape(13, 8.25, 0, 16, 11.25, 16),
            Block.createCuboidShape(12, 11.75, 0, 16, 15.75, 16),
            Block.createCuboidShape(14, 7, 1, 16, 8, 8),
            Block.createCuboidShape(14.75, 5.5, 2, 15.75, 7.5, 3),
            Block.createCuboidShape(14.75, 5.5, 6, 15.75, 7.5, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(0, 1, 11, 16, 6, 16),
            Block.createCuboidShape(0, 8.25, 13, 16, 11.25, 16),
            Block.createCuboidShape(0, 11.75, 12, 16, 15.75, 16),
            Block.createCuboidShape(8, 7, 14, 15, 8, 16),
            Block.createCuboidShape(13, 5.5, 14.75, 14, 7.5, 15.75),
            Block.createCuboidShape(9, 5.5, 14.75, 10, 7.5, 15.75)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 1, 0, 5, 6, 16),
            Block.createCuboidShape(0, 8.25, 0, 3, 11.25, 16),
            Block.createCuboidShape(0, 11.75, 0, 4, 15.75, 16),
            Block.createCuboidShape(0, 7, 8, 2, 8, 15),
            Block.createCuboidShape(0.25, 5.5, 13, 1.25, 7.5, 14),
            Block.createCuboidShape(0.25, 5.5, 9, 1.25, 7.5, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection());
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

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(50) == 0) {
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, 0.01F , 0.1F, true);
        }
    }
}
