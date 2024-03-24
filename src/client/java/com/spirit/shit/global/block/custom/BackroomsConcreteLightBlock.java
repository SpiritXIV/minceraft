package com.spirit.shit.global.block.custom;

import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BackroomsConcreteLightBlock extends Block {
    public BackroomsConcreteLightBlock(Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            if (random.nextInt(5) == 0) {
                world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, ShitSounds.LIGHT_BUZZING, SoundCategory.BLOCKS, 0.5F + random.nextFloat(),  0.6F, true);
        }
    }
}
