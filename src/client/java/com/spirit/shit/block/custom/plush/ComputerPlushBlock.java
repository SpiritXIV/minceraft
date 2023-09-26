package com.spirit.shit.block.custom.plush;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
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

import java.util.stream.Stream;

public class ComputerPlushBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ComputerPlushBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 15, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(13, 6, 8, 14, 7, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(2, 6, 8, 3, 7, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Stream.of(
                    Block.createCuboidShape(4.5, 14.5, 3, 11.5, 15.5, 6),
                    Block.createCuboidShape(11.5, 6.5, 3, 12.5, 15.5, 6),
                    Block.createCuboidShape(3.5, 6.5, 3, 4.5, 15.5, 6),
                    Block.createCuboidShape(4.5, 6.5, 3, 11.5, 7.5, 6)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
                    Block.createCuboidShape(5.25, 5.5, 9.25, 7.25, 7.5, 10.25),
                    Block.createCuboidShape(7.5, 4.5, 9.5, 8.5, 7.5, 10.5),
                    Block.createCuboidShape(10.25, 5.25, 10.25, 11.25, 7.25, 11.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
                    Block.createCuboidShape(11, 0, 6, 11, 1, 10),
                    Block.createCuboidShape(5, 0, 6, 5, 1, 10),
                    Block.createCuboidShape(5, 0, 10, 11, 1, 10)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
                    Block.createCuboidShape(8.75, 1.25, 5.5, 9.75, 6.25, 6.5),
                    Block.createCuboidShape(9.65, 3.75, 5.5, 10.65, 6.75, 6.5),
                    Block.createCuboidShape(6.25, 1.25, 5.5, 7.25, 6.25, 6.5),
                    Block.createCuboidShape(5.35, 3.75, 5.5, 6.35, 6.75, 6.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_N;
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

