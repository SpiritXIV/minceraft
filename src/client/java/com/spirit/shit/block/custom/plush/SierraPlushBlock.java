package com.spirit.shit.block.custom.plush;

import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class SierraPlushBlock extends AbstractPlush {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 14, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Block.createCuboidShape(5.5, 4, 5.5, 7.5, 5, 6.5),
            Block.createCuboidShape(5.25, 5, 6, 7.25, 6, 6),
            Stream.of(
                    Block.createCuboidShape(6, 8.25, 3, 10, 9.25, 4),
                    Block.createCuboidShape(8.75, 7.25, 3, 10.75, 8.25, 4),
                    Block.createCuboidShape(5.25, 7.25, 3, 7.25, 8.25, 4),
                    Block.createCuboidShape(3, 12, 3, 8, 15, 7),
                    Block.createCuboidShape(5, 11, 3, 7, 12, 4),
                    Block.createCuboidShape(3.5, 11, 6.25, 4.5, 12, 8.25),
                    Block.createCuboidShape(10.5, 11, 2.75, 12.5, 12, 5.75),
                    Block.createCuboidShape(10, 12, 2.75, 13, 15, 7.75),
                    Block.createCuboidShape(7, 12.75, 3.75, 9, 14.75, 6.75),
                    Block.createCuboidShape(9, 12.5, 3.5, 10, 14.5, 6.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(1.25, 3.75, 6, 3.25, 5.75, 8), Block.createCuboidShape(2, 5.75, 6.75, 3, 6.75, 7.75), BooleanBiFunction.OR)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public SierraPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

