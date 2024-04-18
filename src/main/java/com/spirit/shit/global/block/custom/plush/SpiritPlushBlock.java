package com.spirit.shit.global.block.custom.plush;

import com.spirit.shit.data.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class SpiritPlushBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 15, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(12, 3.75, 6.75, 13, 6.25, 9.25),
            Block.createCuboidShape(13, 6, 8, 14, 7, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(3, 3.75, 6.75, 4, 6.25, 9.25),
            Block.createCuboidShape(2, 6, 8, 3, 7, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Block.createCuboidShape(8.75, 5.25, 5.5, 9.75, 7.25, 6.5),
            Block.createCuboidShape(6.25, 5.25, 5.5, 7.25, 7.25, 6.5),
            Block.createCuboidShape(5.5, 6, 10, 10.5, 7, 11),
            Stream.of(
                    Block.createCuboidShape(6.25, 13, 3.75, 9.25, 15, 4.75),
                    Block.createCuboidShape(7.25, 11.5, 3, 9.25, 13.5, 4),
                    Block.createCuboidShape(7.25, 10.5, 3, 8.25, 11.5, 4),
                    Block.createCuboidShape(8.5, 13.75, 9.75, 12.5, 14.75, 10.75),
                    Block.createCuboidShape(8.5, 13.75, 8.75, 11.5, 14.75, 9.75),
                    Block.createCuboidShape(3.5, 15.75, 10.75, 5.5, 16.75, 11.75)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Block.createCuboidShape(5.25, 5.17388, 10.61732, 7.25, 9.17388, 11.61732),
            Block.createCuboidShape(8.75, 5.25, 11.25, 10.75, 9.25, 12.25),
            Block.createCuboidShape(5.75, 4.5, 10.5, 6.75, 5.5, 11.5),
            Block.createCuboidShape(9.25, 4.5, 10.5, 10.25, 5.5, 11.5),
            Block.createCuboidShape(5.75, 8.61523, 11.57246, 6.75, 9.61523, 12.57246),
            Block.createCuboidShape(9.25, 8.6152, 11.5725, 10.25, 9.6152, 12.5725),
            Block.createCuboidShape(9, 3.5, 5.75, 10, 5.5, 6.75),
            Block.createCuboidShape(6, 3.5, 5.75, 7, 5.5, 6.75),
            Block.createCuboidShape(9.25, -0.25, 4.75, 11.75, 2.25, 5.75),
            Block.createCuboidShape(4.25, -0.25, 4.75, 6.75, 2.25, 5.75)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public SpiritPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

