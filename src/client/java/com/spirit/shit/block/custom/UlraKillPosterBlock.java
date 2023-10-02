package com.spirit.shit.block.custom;

import com.spirit.shit.block.custom.plush.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class UlraKillPosterBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 2.5, 15.99, 14, 15.5, 15.99), Block.createCuboidShape(2, 3.33311, 14.23299, 14, 5.33311, 14.23299), BooleanBiFunction.OR);

    public UlraKillPosterBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

