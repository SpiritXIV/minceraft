package com.spirit.tdbtd.global.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundEvents;
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
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SculkPutsBlock extends PlantBlock {
    private final Supplier<Block> ground;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SculkPutsBlock(Settings settings, Supplier<Block> ground) {
        super(settings);
        this.ground = ground;
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(7, 0, 3, 11, 5, 3),
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(8, 0, 4, 8, 5, 8),
            Block.createCuboidShape(8, 0, 4, 8, 5, 8),
            Block.createCuboidShape(13, 0, 11, 13, 5, 15),
            Block.createCuboidShape(13, 0, 2, 13, 5, 6),
            Block.createCuboidShape(0, 0, 13, 4, 5, 13),
            Block.createCuboidShape(2, 0, 9, 6, 5, 9),
            Block.createCuboidShape(1, 0, 3, 5, 5, 3),
            Block.createCuboidShape(13, 0, 11, 13, 5, 15),
            Block.createCuboidShape(13, 0, 2, 13, 5, 6),
            Block.createCuboidShape(0, 0, 13, 4, 5, 13),
            Block.createCuboidShape(7, 0, 12, 11, 5, 12),
            Block.createCuboidShape(9, 0, 10, 9, 5, 14),
            Block.createCuboidShape(4, 0, 7, 4, 5, 11),
            Block.createCuboidShape(3, 0, 1, 3, 5, 5),
            Block.createCuboidShape(9, 0, 1, 9, 5, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(7, 0, 3, 11, 5, 3),
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(8, 0, 4, 8, 5, 8),
            Block.createCuboidShape(8, 0, 4, 8, 5, 8),
            Block.createCuboidShape(13, 0, 11, 13, 5, 15),
            Block.createCuboidShape(13, 0, 2, 13, 5, 6),
            Block.createCuboidShape(0, 0, 13, 4, 5, 13),
            Block.createCuboidShape(2, 0, 9, 6, 5, 9),
            Block.createCuboidShape(1, 0, 3, 5, 5, 3),
            Block.createCuboidShape(13, 0, 11, 13, 5, 15),
            Block.createCuboidShape(13, 0, 2, 13, 5, 6),
            Block.createCuboidShape(0, 0, 13, 4, 5, 13),
            Block.createCuboidShape(7, 0, 12, 11, 5, 12),
            Block.createCuboidShape(9, 0, 10, 9, 5, 14),
            Block.createCuboidShape(4, 0, 7, 4, 5, 11),
            Block.createCuboidShape(3, 0, 1, 3, 5, 5),
            Block.createCuboidShape(9, 0, 1, 9, 5, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(7, 0, 3, 11, 5, 3),
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(8, 0, 4, 8, 5, 8),
            Block.createCuboidShape(8, 0, 4, 8, 5, 8),
            Block.createCuboidShape(13, 0, 11, 13, 5, 15),
            Block.createCuboidShape(13, 0, 2, 13, 5, 6),
            Block.createCuboidShape(0, 0, 13, 4, 5, 13),
            Block.createCuboidShape(2, 0, 9, 6, 5, 9),
            Block.createCuboidShape(1, 0, 3, 5, 5, 3),
            Block.createCuboidShape(13, 0, 11, 13, 5, 15),
            Block.createCuboidShape(13, 0, 2, 13, 5, 6),
            Block.createCuboidShape(0, 0, 13, 4, 5, 13),
            Block.createCuboidShape(7, 0, 12, 11, 5, 12),
            Block.createCuboidShape(9, 0, 10, 9, 5, 14),
            Block.createCuboidShape(4, 0, 7, 4, 5, 11),
            Block.createCuboidShape(3, 0, 1, 3, 5, 5),
            Block.createCuboidShape(9, 0, 1, 9, 5, 5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(7, 0, 3, 11, 5, 3),
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(8, 0, 4, 8, 5, 8),
            Block.createCuboidShape(8, 0, 4, 8, 5, 8),
            Block.createCuboidShape(13, 0, 11, 13, 5, 15),
            Block.createCuboidShape(13, 0, 2, 13, 5, 6),
            Block.createCuboidShape(0, 0, 13, 4, 5, 13),
            Block.createCuboidShape(2, 0, 9, 6, 5, 9),
            Block.createCuboidShape(1, 0, 3, 5, 5, 3),
            Block.createCuboidShape(13, 0, 11, 13, 5, 15),
            Block.createCuboidShape(13, 0, 2, 13, 5, 6),
            Block.createCuboidShape(0, 0, 13, 4, 5, 13),
            Block.createCuboidShape(7, 0, 12, 11, 5, 12),
            Block.createCuboidShape(9, 0, 10, 9, 5, 14),
            Block.createCuboidShape(4, 0, 7, 4, 5, 11),
            Block.createCuboidShape(3, 0, 1, 3, 5, 5),
            Block.createCuboidShape(9, 0, 1, 9, 5, 5)
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
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.playSound(SoundEvents.BLOCK_SCULK_CATALYST_BLOOM, 1, 1);
        entity.setVelocity(0,-0.2,0);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }


    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SCULK);
    }
}
