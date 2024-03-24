package com.spirit.shit.global.block.custom;

import com.spirit.shit.data.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class BackroomsIndustrialBrokenLightBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 11, 7.5, 3, 15, 8.5), Block.createCuboidShape(13, 11, 7.5, 14, 15, 8.5), BooleanBiFunction.OR),
            Stream.of(
            Block.createCuboidShape(0, 10, 6, 16, 11, 10),
            Block.createCuboidShape(0, 9, 5, 16, 10, 11),
            Block.createCuboidShape(0, 6, 10, 16, 9, 11),
            Block.createCuboidShape(0, 6, 5, 16, 9, 6),
            Block.createCuboidShape(0, 6, 6, 1, 9, 10),
            Block.createCuboidShape(15, 6, 6, 16, 9, 10)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Block.createCuboidShape(1, 6.5, 7, 15, 8.5, 9)
                    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public BackroomsIndustrialBrokenLightBlock(Settings settings) {
        super(settings, SHAPE);
    }
}