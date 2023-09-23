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

public class ChefInsanityPlushBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ChefInsanityPlushBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 14.75, 12),
            Block.createCuboidShape(8.5, 6, 3, 10.5, 9, 5),
            Block.createCuboidShape(5.5, 6, 3, 7.5, 9, 5),
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
                    Block.createCuboidShape(3.5, 14.5, 3.75, 12.5, 17.5, 12.75),
                    Block.createCuboidShape(3.75, 13.5, 4, 12.25, 14.5, 12.5),
                    Block.createCuboidShape(3.5, 13, 3.75, 12.5, 14, 12.75)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(1.25, 4.5, 9.5, 6.25, 5.75, 10.75),
            Block.createCuboidShape(2, 3.5, 10, 7, 4.75, 11.25),
            Block.createCuboidShape(2, 2, 9.5, 7, 3.25, 10.75),
            Block.createCuboidShape(9, 2, 9.5, 14, 3.25, 10.75),
            Block.createCuboidShape(9.75, 4.5, 9.5, 14.75, 5.75, 10.75),
            Block.createCuboidShape(9, 3.5, 10, 14, 4.75, 11.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(6, 10.25, 3.5, 10, 12.25, 4.5),
            Block.createCuboidShape(4.25, 10.25, 3.75, 5.25, 12.25, 4.75),
            Block.createCuboidShape(10.75, 10.25, 3.75, 11.75, 12.25, 4.75),
            Block.createCuboidShape(9.75, 12.5, 3.75, 10.75, 13.5, 4.75),
            Block.createCuboidShape(5.25, 12.5, 3.75, 6.25, 13.5, 4.75)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Block.createCuboidShape(7.25, 4.75, 5.75, 8.25, 5.75, 6.75),
            Block.createCuboidShape(7, 5.75, 5.75, 9, 6.75, 6.75),
            Block.createCuboidShape(8.25, 4, 5.75, 9.25, 5, 6.75),
            Block.createCuboidShape(9.5, 2.75, 5.75, 10.5, 3.75, 6.75)
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

