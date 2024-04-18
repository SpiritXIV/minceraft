package com.spirit.shit.global.block.custom.plush;

import com.spirit.shit.data.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class CatlovePlushBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 15, 12),
            Block.createCuboidShape(5, 2, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Stream.of(
                    Block.createCuboidShape(3.75, 13.75, 5.25, 6.75, 15.75, 6.25),
                    Block.createCuboidShape(4.75, 15.75, 5, 5.75, 16.75, 6),
                    Block.createCuboidShape(10.25, 15.75, 5, 11.25, 16.75, 6),
                    Block.createCuboidShape(9.25, 13.75, 5.25, 12.25, 15.75, 6.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(4.75, 5, 5, 6.75, 7, 6),
            Block.createCuboidShape(9.25, 4, 5, 11.25, 7, 6),
            Block.createCuboidShape(11.25, 3.5, 4.75, 12.25, 4.5, 5.75),
            Block.createCuboidShape(4.5, 4.5, 4.75, 5.5, 5.5, 5.75),
            Block.createCuboidShape(5, 13.25, 11, 7, 15.25, 13),
            Block.createCuboidShape(4.75, 10, 12, 6.75, 14, 13),
            Block.createCuboidShape(3.75, 9, 12, 4.75, 13, 13),
            Block.createCuboidShape(4.75, 8, 12, 5.75, 10, 13),
            Block.createCuboidShape(9, 13.25, 11, 11, 15.25, 13),
            Block.createCuboidShape(9.25, 10, 12, 11.25, 14, 13),
            Block.createCuboidShape(11.25, 9, 12, 12.25, 13, 13),
            Block.createCuboidShape(10.25, 8, 12, 11.25, 10, 13),
            Block.createCuboidShape(4.5, 3, 11, 11.5, 7, 12),
            Block.createCuboidShape(5, 2, 11, 11, 3, 12),
            Block.createCuboidShape(6, 12.75, 3.5, 10, 13.75, 4.5),
            Block.createCuboidShape(5, 11.75, 3.25, 11, 12.75, 4.25),
            Block.createCuboidShape(7, 10.75, 3.25, 9, 11.75, 4.25),
            Block.createCuboidShape(9.75, 10.75, 3.25, 11.75, 11.75, 4.25),
            Block.createCuboidShape(11.25, 7.75, 3.5, 12.25, 10.75, 4.5),
            Block.createCuboidShape(10.75, 6.75, 3.25, 11.75, 7.75, 4.25),
            Block.createCuboidShape(4.25, 10.75, 3.25, 6.25, 11.75, 4.25),
            Block.createCuboidShape(3.75, 7.75, 3.5, 4.75, 10.75, 4.5),
            Block.createCuboidShape(4.25, 6.75, 3.25, 5.25, 7.75, 4.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(4, 1.5, 5, 12, 2.5, 11),
            Block.createCuboidShape(4, 0.5, 5, 4, 1.5, 11),
            Block.createCuboidShape(12, 0.5, 5, 12, 1.5, 11),
            Block.createCuboidShape(4, 0.5, 11, 12, 1.5, 11),
            Block.createCuboidShape(4, 0.5, 5, 12, 1.5, 5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(5.25, 13, 13, 6.25, 14, 14),
            Block.createCuboidShape(6.25, 12.25, 12.75, 7.25, 14.25, 13.75),
            Block.createCuboidShape(4.25, 12.25, 12.75, 5.25, 14.25, 13.75),
            Block.createCuboidShape(10.75, 12.25, 12.75, 11.75, 14.25, 13.75),
            Block.createCuboidShape(9.75, 13, 13, 10.75, 14, 14),
            Block.createCuboidShape(8.75, 12.25, 12.75, 9.75, 14.25, 13.75)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public CatlovePlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

