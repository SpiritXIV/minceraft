package com.spirit.shit.block.custom.plush;

import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class ErisPlushBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 15, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(13, 6, 8, 14, 7, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(2, 6, 8, 3, 7, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(10.25, 13.5, 4.75, 13.25, 16.5, 6.75), Block.createCuboidShape(2.75, 13.5, 4.75, 5.75, 16.5, 6.75), BooleanBiFunction.OR),
            Stream.of(
                    Block.createCuboidShape(3.5, 6.5, 3.5, 12.5, 8.5, 12.5),
                    Block.createCuboidShape(4.5, 6, 5, 11.5, 7, 6),
                    Block.createCuboidShape(5, 4, 5, 7, 6, 6),
                    Block.createCuboidShape(4.25, 2, 5.25, 6.25, 4, 6.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Block.createCuboidShape(7, 1.75, 9.25, 9, 3.75, 11.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public ErisPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

