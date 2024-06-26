package com.spirit.shit.global.block.custom;

import com.spirit.shit.data.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class OldComputerBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(2, 0, 1, 14, 1, 6),
            Block.createCuboidShape(2.5, 0.5, 1.5, 13.5, 1.5, 4.5),
            Block.createCuboidShape(2, 0, 7, 14, 4, 15),
            Block.createCuboidShape(5, 3.5, 8.5, 11, 4.5, 14.5),
            Block.createCuboidShape(3, 4.5, 8.5, 13, 12.5, 15.5),
            Block.createCuboidShape(3, 11.5, 7.5, 13, 12.5, 8.5),
            Block.createCuboidShape(3, 4.5, 7.5, 13, 5.5, 8.5),
            Block.createCuboidShape(12, 5.5, 7.5, 13, 11.5, 8.5),
            Block.createCuboidShape(3, 5.5, 7.5, 4, 11.5, 8.5),
            Block.createCuboidShape(11, 0, 6, 15, 1, 7),
            Block.createCuboidShape(14.5, 0, 7, 15.5, 1, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public OldComputerBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

