package com.spirit.shit.block.custom;

import com.spirit.shit.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class CracklinBoxBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = java.util.Optional.of(Block.createCuboidShape(3, 0, 7, 14, 15, 10)).get();

    public CracklinBoxBlock(Settings settings) {
        super(settings, SHAPE);
    }


}