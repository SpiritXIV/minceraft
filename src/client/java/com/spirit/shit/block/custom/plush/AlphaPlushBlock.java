package com.spirit.shit.block.custom.plush;

import com.spirit.shit.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class AlphaPlushBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(4, 7, 4, 12, 15, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(13.5, 6, 8, 14.5, 7, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(1.5, 6, 8, 2.5, 7, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Stream.of(
                    Block.createCuboidShape(3, 12.5, 3, 13, 13.5, 13),
                    Block.createCuboidShape(13, 6.5, 6, 13, 12.5, 13),
                    Block.createCuboidShape(3, 8.5, 13, 13, 12.5, 13),
                    Block.createCuboidShape(3, 6.5, 13, 7, 8.5, 13),
                    Block.createCuboidShape(9, 6.5, 13, 13, 8.5, 13),
                    Block.createCuboidShape(3, 6.5, 6, 3, 12.5, 13),
                    Block.createCuboidShape(3, 8.5, 3, 3, 12.5, 6),
                    Block.createCuboidShape(13, 8.5, 3, 13, 12.5, 6),
                    Block.createCuboidShape(10, 9.5, 3, 13, 12.5, 3)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8.34776, 1.76537, 10.32, 11.34776, 6.76537, 10.32),
                    Block.createCuboidShape(4.65224, 1.76537, 10.32, 7.65224, 6.76537, 10.32),
                    BooleanBiFunction.OR)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
  
    public AlphaPlushBlock(Settings settings) {
        super(settings, SHAPE);
    }
}

