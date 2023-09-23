package com.spirit.shit.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class OldComputerBlock extends Block {

    public OldComputerBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(2, 0, 1, 14, 1, 6),
            Block.createCuboidShape(2.5, 0.5, 1.5, 13.5, 1.5, 4.5),
            Block.createCuboidShape(2, 0, 7, 14, 4, 15),
            Block.createCuboidShape(5, 3.5, 8.5, 11, 4.5, 14.5),
            Block.createCuboidShape(3, 4.5, 8.5, 13, 12.5, 15.5),
            Block.createCuboidShape(3, 11.5, 7.5, 13, 12.5, 8.5),
            Block.createCuboidShape(3, 4.5, 7.5, 13, 5.5, 8.5),
            Block.createCuboidShape(12, 5.5, 7.5, 13, 11.5, 8.5),
            Block.createCuboidShape(3, 5.5, 7.5, 4, 11.5, 8.5),
            Block.createCuboidShape(11, 0, 6, 15, 1, 7),
            Block.createCuboidShape(14.5, 0, 7, 15.5, 1, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_N;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    }
}

