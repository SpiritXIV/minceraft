package com.spirit.tdbtd.global.block.custom;

import com.spirit.tdbtd.global.block.TDBTDBlocks;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.function.Supplier;

public class TenVinesPlantBlock extends AbstractPlantBlock {
    private final Supplier<Block> ground;

    public static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);

    public TenVinesPlantBlock(Settings settings, Supplier<Block> ground) {
        super(settings, Direction.UP, SHAPE, false);
        this.ground = ground;
    }
    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) TDBTDBlocks.SCULK_TENVINES;
    }
}

