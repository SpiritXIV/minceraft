package com.spirit.shit.block.custom.plush;

import com.spirit.shit.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class KingZharaPlushBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 15, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(13.25, 3.5, 6.5, 14.75, 6.5, 9.5),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(9, 4, 5.5, 10, 7, 6.5),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(3, 3.5, 6.5, 4.5, 6.5, 9.5),
            Block.createCuboidShape(2, 6, 8, 3, 7, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Block.createCuboidShape(6, 5, 5.5, 7, 7, 6.5),
            Block.createCuboidShape(5.5, 6, 10, 10.5, 7, 11),
            Stream.of(
                    Block.createCuboidShape(10, 15.5, 6, 15, 17.5, 7),
                    Block.createCuboidShape(10, 17.5, 6, 11, 18.5, 7),
                    Block.createCuboidShape(12, 17.5, 6, 13, 18.5, 7),
                    Block.createCuboidShape(14, 17.5, 6, 15, 18.5, 7),
                    Block.createCuboidShape(14, 17.5, 10, 15, 18.5, 11),
                    Block.createCuboidShape(14, 17.5, 8, 15, 18.5, 9),
                    Block.createCuboidShape(10, 17.5, 8, 11, 18.5, 9),
                    Block.createCuboidShape(10, 17.5, 10, 11, 18.5, 11),
                    Block.createCuboidShape(12, 17.5, 10, 13, 18.5, 11),
                    Block.createCuboidShape(10, 15.5, 10, 15, 17.5, 11),
                    Block.createCuboidShape(10, 15.5, 7, 11, 17.5, 10),
                    Block.createCuboidShape(14, 15.5, 7, 15, 17.5, 10)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(1.25, 0, 7.25, 2.25, 11, 8.25),
            Block.createCuboidShape(0.75, 11, 6.75, 2.75, 13, 8.75),
            Block.createCuboidShape(2.25, 11.5, 7.25, 3.25, 12.5, 8.25),
            Block.createCuboidShape(1.25, 11.5, 8.25, 2.25, 12.5, 9.25),
            Block.createCuboidShape(0.25, 11.5, 7.25, 1.25, 12.5, 8.25),
            Block.createCuboidShape(1.25, 11.5, 6.25, 2.25, 12.5, 7.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(10.75, 10.25, 3.5, 12.75, 12.25, 4.5),
            Block.createCuboidShape(4, 10, 3.25, 5, 12, 4.25),
            Block.createCuboidShape(3.5, 9, 3.5, 4.5, 10, 4.5),
            Block.createCuboidShape(7.75, 11.25, 3.25, 11.75, 13.25, 4.25),
            Block.createCuboidShape(4.25, 11.25, 3.25, 6.25, 13.25, 4.25),
            Block.createCuboidShape(5, 12.25, 3, 11, 14.25, 4)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(8.5, 6.5, 11.5, 9.5, 11.5, 12.5),
            Block.createCuboidShape(6.5, 9.5, 11.5, 7.5, 11.5, 12.5),
            Block.createCuboidShape(6.25, 6.5, 11.5, 7.25, 9.5, 12.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public KingZharaPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

