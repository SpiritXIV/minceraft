package com.spirit.shit.block.custom.plush;

import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class ZarshPlushBlock extends AbstractPlush {
    private static final VoxelShape SHAPE = Stream.of(
            Stream.of(
                    Block.createCuboidShape(5.25, 13, 3, 10.75, 15, 5),
                    Block.createCuboidShape(10, 12.5, 2.75, 12, 14.5, 4.75),
                    Block.createCuboidShape(10.5, 10.5, 2.75, 12.25, 12.5, 4.75),
                    Block.createCuboidShape(11, 8.5, 2.75, 12.75, 10.5, 4.75),
                    Block.createCuboidShape(10.5, 6.75, 2.75, 12.25, 8.5, 4.75),
                    Block.createCuboidShape(4, 12.5, 2.75, 6, 14.5, 4.75),
                    Block.createCuboidShape(3.75, 10.5, 2.75, 5.5, 12.5, 4.75),
                    Block.createCuboidShape(3.25, 8.5, 2.75, 5, 10.5, 4.75),
                    Block.createCuboidShape(3.75, 6.75, 2.75, 5.5, 8.5, 4.75),
                    Block.createCuboidShape(6, 10.5, 11.5, 10, 13.5, 12.5),
                    Block.createCuboidShape(6.5, 11, 12, 9.5, 13, 13),
                    Block.createCuboidShape(7, 11, 13, 9, 12, 14),
                    Block.createCuboidShape(7.5, 10.75, 14, 8.5, 11.75, 15)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Block.createCuboidShape(6, 6.25, 4.25, 10, 7.25, 5.25),
            Block.createCuboidShape(4, 7, 4, 12, 14, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(13, 6, 8, 14, 7, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(2, 6, 8, 3, 7, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Block.createCuboidShape(9, 4.75, 5.25, 10, 6.75, 6.25),
            Block.createCuboidShape(6, 4.75, 5.25, 7, 6.75, 6.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public ZarshPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

