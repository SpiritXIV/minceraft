package com.spirit.shit.block.custom.plush;

import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class MilkyFurPlushBlock extends AbstractShitBlock {
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
            Block.createCuboidShape(5.5, 5.75, 9.75, 10.5, 6.75, 10.75),
            Block.createCuboidShape(5.5, 4.75, 5.25, 10.5, 6.75, 7.25),
            Stream.of(
                    Block.createCuboidShape(3.75, 12.25, 3.25, 8.75, 15.25, 6.25),
                    Block.createCuboidShape(9.75, 12.75, 3.25, 12.75, 14.75, 5.25),
                    Block.createCuboidShape(11.75, 11.75, 3, 13.75, 12.75, 4),
                    Block.createCuboidShape(3, 11.25, 2.75, 7, 13.25, 4.75),
                    Block.createCuboidShape(2.5, 11, 3.5, 3.5, 13, 4.5),
                    Block.createCuboidShape(2.5, 12.25, 3.5, 3.5, 13.25, 4.5),
                    Block.createCuboidShape(7.75, 14.5, 8.5, 9.5, 16.25, 9.5),
                    Block.createCuboidShape(11, 7.5, 10.25, 13, 10.5, 12.25),
                    Block.createCuboidShape(12, 6.5, 10.25, 13, 7.5, 12.25),
                    Block.createCuboidShape(13, 8, 10.25, 14, 10, 12.25),
                    Block.createCuboidShape(14, 9, 10.25, 15, 10, 12.25),
                    Block.createCuboidShape(10, 7, 10.75, 11, 9, 11.75),
                    Block.createCuboidShape(5, 7, 10.75, 6, 9, 11.75),
                    Block.createCuboidShape(3, 7.5, 10.25, 5, 10.5, 12.25),
                    Block.createCuboidShape(3, 6.5, 10.25, 4, 7.5, 12.25),
                    Block.createCuboidShape(2, 8, 10.25, 3, 10, 12.25),
                    Block.createCuboidShape(1, 9, 10.25, 2, 10, 12.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(9.5, 15.75, 7, 12.5, 18.75, 9),
            Block.createCuboidShape(8.5, 18.75, 7, 11.5, 19.75, 9),
            Block.createCuboidShape(8.5, 14.75, 7, 9.5, 18.75, 9),
            Block.createCuboidShape(6.5, 14.75, 7, 7.5, 18.75, 9),
            Block.createCuboidShape(3.5, 15.75, 7, 6.5, 18.75, 9),
            Block.createCuboidShape(4.5, 18.75, 7, 7.5, 19.75, 9)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(3.75, 9.75, 3.75, 4.75, 10.75, 4.75), Block.createCuboidShape(11.25, 9.75, 3.75, 12.25, 10.75, 4.75), BooleanBiFunction.OR)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public MilkyFurPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

