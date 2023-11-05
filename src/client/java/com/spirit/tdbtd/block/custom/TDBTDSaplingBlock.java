package com.spirit.tdbtd.block.custom;

import com.spirit.tdbtd.world.feature.tree.SculkCharredSaplingGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.function.Supplier;


public class TDBTDSaplingBlock extends SaplingBlock {
    private final Supplier<Block> ground;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    public TDBTDSaplingBlock(SculkCharredSaplingGenerator generator, Settings settings, Supplier<Block> ground) {
        super(generator, settings);
        this.ground = ground;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ground.get());
    }
}
