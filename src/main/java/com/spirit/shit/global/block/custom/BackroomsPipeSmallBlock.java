package com.spirit.shit.global.block.custom;

import com.spirit.shit.data.common.AbstractShitBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class BackroomsPipeSmallBlock extends AbstractShitBlock {

    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(0, 1, 0, 16, 6, 5),
            Block.createCuboidShape(0, 8.25, 0, 16, 11.25, 3),
            Block.createCuboidShape(0, 11.75, 0, 16, 15.75, 4),
            Block.createCuboidShape(1, 7, 0, 8, 8, 2),
            Block.createCuboidShape(2, 5.5, 0.25, 3, 7.5, 1.25),
            Block.createCuboidShape(6, 5.5, 0.25, 7, 7.5, 1.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public BackroomsPipeSmallBlock(Settings settings) {
        super(settings, SHAPE);
    }
    @Override
    @SuppressWarnings("deprecation")
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(50) == 0) {
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, 0.01F , 0.1F, true);
        }
    }
}
