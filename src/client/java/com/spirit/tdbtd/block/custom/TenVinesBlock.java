package com.spirit.tdbtd.block.custom;

import com.spirit.tdbtd.block.TDBTDBlocks;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineLogic;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;

import java.util.function.Supplier;

public class TenVinesBlock extends AbstractPlantStemBlock {
    private final Supplier<Block> ground;
    public static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 15.0, 12.0);

    public TenVinesBlock(Settings settings, Supplier<Block> ground) {
        super(settings, Direction.UP, SHAPE, false, 0.1);
        this.ground = ground;
    }

    @Override
    protected int getGrowthLength(Random random) {
        return VineLogic.getGrowthLength(random);
    }

    @Override
    protected Block getPlant() {
        return TDBTDBlocks.SCULK_TENVINES_PLANT;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return VineLogic.isValidForWeepingStem(state);
    }
}

