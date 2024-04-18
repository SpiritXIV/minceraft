package com.spirit.shit.global.block.custom;

import com.spirit.shit.data.common.AbstractShitBlock;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class BackroomsIndustrialLightBlock extends AbstractShitBlock {

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

    public BackroomsIndustrialLightBlock(Settings settings) {
        super(settings, SHAPE);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            if (random.nextInt(5) == 0) {
                world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, ShitSounds.LIGHT_BUZZING, SoundCategory.BLOCKS, 0.5F + random.nextFloat(),  1F, true);
        }
    }
}
