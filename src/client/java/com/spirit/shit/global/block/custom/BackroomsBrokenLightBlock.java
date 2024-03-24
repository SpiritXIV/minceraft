package com.spirit.shit.global.block.custom;

import com.spirit.shit.global.sound.ShitSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BackroomsBrokenLightBlock extends Block {
    public static final IntProperty LIGHT_LEVEL = IntProperty.of("light_level", 0, 15);

    public BackroomsBrokenLightBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LIGHT_LEVEL, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIGHT_LEVEL);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            int lightLevel = state.get(LIGHT_LEVEL);
            if (lightLevel > 0) {
                playFlickerSound(world, pos);
                world.setBlockState(pos, state.with(LIGHT_LEVEL, lightLevel - 1));
            }
        }
        return ActionResult.SUCCESS;
    }

    public void randomTick(BlockState state, World world, BlockPos pos, java.util.Random random) {
        super.randomTick(state, (ServerWorld) world, pos, (Random) random);

        if (random.nextInt(10) == 0) { // Adjust the chance as needed
            int lightLevel = state.get(LIGHT_LEVEL);
            if (lightLevel < 15) {
                playFlickerSound(world, pos);
                world.setBlockState(pos, state.with(LIGHT_LEVEL, lightLevel + 1));
            }
        }
    }

    private void playFlickerSound(World world, BlockPos pos) {
        world.playSound(null, pos, ShitSounds.LIGHT_FLICKER, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}
