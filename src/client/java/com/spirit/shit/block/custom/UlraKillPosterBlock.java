package com.spirit.shit.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class UlraKillPosterBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public UlraKillPosterBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 2.5, 15.99, 14, 15.5, 15.99), Block.createCuboidShape(2, 3.33311, 14.23299, 14, 5.33311, 14.23299), BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_E = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0.1, 2.5, 2, 0.1, 15.5, 14), Block.createCuboidShape(1.8, 3.33311, 2, 1.8, 5.33311, 14), BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_S = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 2.5, 0.1, 14, 15.5, 0.1), Block.createCuboidShape(2, 3.33311, 1.8, 14, 5.33311, 1.8), BooleanBiFunction.OR);

    private static final VoxelShape SHAPE_W = VoxelShapes.combineAndSimplify(Block.createCuboidShape(15.99, 2.5, 2, 15.99, 15.5, 14), Block.createCuboidShape(14.23299, 3.33311, 2, 14.23299, 5.33311, 14), BooleanBiFunction.OR);

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
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
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
}

