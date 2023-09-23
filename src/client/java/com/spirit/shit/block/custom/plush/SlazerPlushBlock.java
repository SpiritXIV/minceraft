package com.spirit.shit.block.custom.plush;

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

import java.util.stream.Stream;

public class SlazerPlushBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SlazerPlushBlock(Settings settings) {
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
            Block.createCuboidShape(5.25, 6, 9.5, 10.75, 7, 10.5),
            Stream.of(
                    Block.createCuboidShape(5, 0, 6, 5, 1, 10),
                    Block.createCuboidShape(11, 0, 6, 11, 1, 10),
                    Block.createCuboidShape(5, 0, 10, 11, 1, 10)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(11, 6.25, 6.75, 13, 7.25, 9.25), Block.createCuboidShape(3, 6.25, 6.75, 5, 7.25, 9.25), BooleanBiFunction.OR),
            Block.createCuboidShape(4.5, 4, 5.5, 11.5, 5, 6.5),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5.75, 1.5, 9.5, 7.75, 5.5, 11.5), Stream.of(
            Block.createCuboidShape(9.75, 3, 9.5, 11.75, 4, 10.5),
            Block.createCuboidShape(3.75, 3, 9.5, 4.75, 4, 10.5),
            Block.createCuboidShape(4.75, 2.75, 9.5, 8.75, 4.25, 10.5),
            Block.createCuboidShape(8.75, 2.5, 9.5, 9.75, 4.5, 10.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(), BooleanBiFunction.OR),
            Stream.of(
            Block.createCuboidShape(10, 13.5, 3.5, 13, 15.5, 5.5),
            Block.createCuboidShape(11.75, 12.5, 3.5, 12.75, 13.5, 4.5),
            Block.createCuboidShape(9, 13.25, 3.75, 10, 15.25, 4.75),
            Block.createCuboidShape(11.13635, 9.25, 3.92179, 12.13635, 11.25, 5.92179),
            Block.createCuboidShape(11.13635, 8.25, 4.67179, 12.13635, 9.25, 5.67179),
            Block.createCuboidShape(3, 13.5, 3.5, 6, 15.5, 5.5),
            Block.createCuboidShape(3.25, 12.5, 3.5, 4.25, 13.5, 4.5),
            Block.createCuboidShape(6, 13.25, 3.75, 7, 15.25, 4.75),
            Block.createCuboidShape(3.86365, 9.25, 3.92179, 4.86365, 11.25, 5.92179),
            Block.createCuboidShape(3.86365, 8.25, 4.67179, 4.86365, 9.25, 5.67179),
            Block.createCuboidShape(11.38635, 11, 10.42179, 12.38635, 12, 11.42179),
            Block.createCuboidShape(11.63635, 9.25, 8.92179, 12.63635, 11.25, 10.92179),
            Block.createCuboidShape(11.38635, 8.25, 8.67179, 12.38635, 9.25, 9.67179),
            Block.createCuboidShape(3.61365, 11, 10.42179, 4.61365, 12, 11.42179),
            Block.createCuboidShape(3.36365, 9.25, 8.92179, 4.36365, 11.25, 10.92179),
            Block.createCuboidShape(3.61365, 8.25, 8.67179, 4.61365, 9.25, 9.67179)
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

