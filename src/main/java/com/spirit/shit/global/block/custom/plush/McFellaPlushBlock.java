package com.spirit.shit.global.block.custom.plush;

import com.spirit.shit.data.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class McFellaPlushBlock extends AbstractShitBlock {

    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 15, 12),
            Block.createCuboidShape(8.5, 9, 3.5, 11.5, 11, 4.5),
            Block.createCuboidShape(4.5, 9, 3.5, 7.5, 11, 4.5),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(13, 6, 8, 14, 7, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(2, 6, 8, 3, 7, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Stream.of(
                    Block.createCuboidShape(6.75, 12.5, 3, 9.75, 14.5, 4),
                    Block.createCuboidShape(5.75, 12.75, 3, 6.75, 13.75, 4),
                    Block.createCuboidShape(11.25, 6, 9.5, 12.25, 7, 11.5),
                    Block.createCuboidShape(3.75, 6, 8.5, 4.75, 7, 11.5),
                    Block.createCuboidShape(6, 6, 11.25, 9, 7, 12.25),
                    Block.createCuboidShape(3.75, 6, 6.25, 4.75, 7, 7.25),
                    Block.createCuboidShape(11.25, 6, 7.25, 12.25, 7, 8.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public McFellaPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

