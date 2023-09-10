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

public class JargedesPlushBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public JargedesPlushBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 15, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(5, 0, 10, 11, 1, 10),
            Block.createCuboidShape(11, 0, 6, 11, 1, 10),
            Block.createCuboidShape(5, 0, 6, 5, 1, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(12.75, 3.75, 6.75, 13.75, 6.25, 9.25),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(2.25, 3.75, 6.75, 3.25, 6.25, 9.25),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Block.createCuboidShape(7, 2, 5.75, 9, 3, 6.75),
            Block.createCuboidShape(10.5, 0.75, 6.5, 11.5, 2.75, 9.5),
            Stream.of(
                    Block.createCuboidShape(9.5, 12.75, 3.5, 11.5, 15.75, 4.5),
                    Block.createCuboidShape(4.5, 12.75, 3.5, 6.5, 15.75, 4.5),
                    Block.createCuboidShape(8.5, 13.25, 3.5, 9.5, 15.25, 4.5),
                    Block.createCuboidShape(6.5, 13.25, 3.5, 7.5, 15.25, 4.5),
                    Block.createCuboidShape(7.5, 13.75, 3.5, 8.5, 15.25, 4.5),
                    Block.createCuboidShape(11.5, 13.25, 3.5, 12.5, 15.25, 4.5),
                    Block.createCuboidShape(3.5, 13.25, 3.5, 4.5, 15.25, 4.5),
                    Block.createCuboidShape(11.5, 13.5, 9.5, 12.5, 14.5, 13.5),
                    Block.createCuboidShape(4.5, 13.25, 12.75, 11.5, 14.25, 13.75),
                    Block.createCuboidShape(11.5, 13.75, 4.5, 12.5, 14.75, 9.5),
                    Block.createCuboidShape(3.5, 13.75, 4.5, 4.5, 14.75, 9.5),
                    Block.createCuboidShape(3.5, 13.5, 9.5, 4.5, 14.5, 13.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(4.25, 4.25, 11.25, 7.25, 7.25, 12.25),
            Block.createCuboidShape(4.5, 3.25, 11, 6.5, 4.25, 12),
            Block.createCuboidShape(4.25, 0.75, 11, 6.25, 1.75, 12),
            Block.createCuboidShape(5, 1.75, 11.25, 7, 3.25, 12.25),
            Block.createCuboidShape(8.75, 4.25, 11.25, 11.75, 7.25, 12.25),
            Block.createCuboidShape(9.5, 3.25, 11, 11.5, 4.25, 12),
            Block.createCuboidShape(9.75, 0.75, 11, 11.75, 1.75, 12),
            Block.createCuboidShape(9, 1.75, 11.25, 11, 3.25, 12.25),
            Block.createCuboidShape(7, 10.75, 3.25, 9, 11.75, 4.25),
            Block.createCuboidShape(6.75, 11.75, 3.25, 9.25, 14, 4.25),
            Block.createCuboidShape(9.25, 11.5, 3.25, 11.25, 13.5, 4.25),
            Block.createCuboidShape(4.75, 11.5, 3.25, 6.75, 13.5, 4.25),
            Block.createCuboidShape(3.75, 10.5, 3.25, 4.75, 13.5, 4.25),
            Block.createCuboidShape(11.25, 10.5, 3.25, 12.25, 13.5, 4.25),
            Block.createCuboidShape(3.75, 11, 4.25, 4.75, 13, 5.25),
            Block.createCuboidShape(11.25, 11, 4.25, 12.25, 13, 5.25),
            Block.createCuboidShape(11.25, 6.75, 3.75, 12.25, 8.75, 4.75),
            Block.createCuboidShape(11.25, 6.75, 7, 12.25, 10.75, 9),
            Block.createCuboidShape(9.25, 6.75, 10.25, 12.25, 9.75, 12.25),
            Block.createCuboidShape(3.75, 6.75, 3.75, 4.75, 8.75, 4.75),
            Block.createCuboidShape(7, 9.75, 3.25, 8, 10.75, 4.25),
            Block.createCuboidShape(3.75, 6.75, 7, 4.75, 10.75, 9),
            Block.createCuboidShape(3.75, 6.75, 10.25, 6.75, 9.75, 12.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(8.91, 3.41, 5.66, 9.59, 7.09, 6.34),
            Block.createCuboidShape(9.59, 1.41, 5.66, 10.27, 4.09, 6.34),
            Block.createCuboidShape(9.59, 4.41, 5.66, 10.27, 5.09, 6.34),
            Block.createCuboidShape(9.59, 5.41, 5.66, 10.27, 6.09, 6.34),
            Block.createCuboidShape(6.4, 3.4, 5.65, 7.1, 7.1, 6.35),
            Block.createCuboidShape(5.73, 1.41, 5.66, 6.41, 4.09, 6.34),
            Block.createCuboidShape(5.73, 4.41, 5.66, 6.41, 5.09, 6.34),
            Block.createCuboidShape(5.73, 5.41, 5.66, 6.41, 6.09, 6.34)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();



    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            default:
                return SHAPE_N;
        }
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

