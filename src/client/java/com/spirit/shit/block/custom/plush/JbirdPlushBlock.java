package com.spirit.shit.block.custom.plush;

import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class JbirdPlushBlock extends AbstractShitBlock {
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
            Block.createCuboidShape(5.5, 5.75, 9.5, 10.5, 6.75, 10.5),
            Stream.of(
                    Block.createCuboidShape(11.5, 3, 4.75, 14.5, 7, 7.75),
                    Block.createCuboidShape(12, 6.25, 5.25, 14, 7.25, 7.25),
                    Block.createCuboidShape(12, 2.75, 5.25, 14, 3.75, 7.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(9.75, 13.75, 3.5, 10.75, 14.75, 4.5),
            Block.createCuboidShape(9, 11.75, 3.25, 12, 13.75, 4.25),
            Block.createCuboidShape(9.75, 10.75, 3.25, 11.75, 11.75, 4.25),
            Block.createCuboidShape(10.75, 8.75, 3.25, 11.75, 10.75, 4.25),
            Block.createCuboidShape(5.25, 13.75, 3.5, 6.25, 14.75, 4.5),
            Block.createCuboidShape(4, 11.75, 3.25, 7, 13.75, 4.25),
            Block.createCuboidShape(4.25, 10.75, 3.25, 6.25, 11.75, 4.25),
            Block.createCuboidShape(4.25, 8.75, 3.25, 5.25, 10.75, 4.25),
            Block.createCuboidShape(6, 12, 2.75, 10, 15, 4),
            Block.createCuboidShape(7, 11, 2.75, 9, 12, 3.75),
            Block.createCuboidShape(7, 10, 2.75, 8, 11, 3.75),
            Block.createCuboidShape(5, 6, 11.25, 11, 8, 12.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public JbirdPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

