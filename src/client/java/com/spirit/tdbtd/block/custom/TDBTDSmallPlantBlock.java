package com.spirit.tdbtd.block.custom;

import com.spirit.tdbtd.block.TDBTDBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.function.Supplier;

public class TDBTDSmallPlantBlock extends PlantBlock implements Fertilizable {
    private final Supplier<Block> ground;
    protected static final float field_31261 = 6.0f;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    public TDBTDSmallPlantBlock(Settings settings, Supplier<Block> ground) {
        super(settings);
        this.ground = ground;
    }


    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SCULK);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        TallPlantBlock tallPlantBlock = (TallPlantBlock)(state.isOf(TDBTDBlocks.SCULK_FERN) ? TDBTDBlocks.LARGE_SCULK_FERN : TDBTDBlocks.LARGE_SCULK_FERN);
        if (tallPlantBlock.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
            TallPlantBlock.placeAt(world, tallPlantBlock.getDefaultState(), pos, 2);
        }
    }
}
