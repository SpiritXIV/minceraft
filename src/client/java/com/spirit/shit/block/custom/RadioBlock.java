package com.spirit.shit.block.custom;

import com.spirit.shit.common.AbstractShitBlock;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.stream.Stream;

public class RadioBlock extends AbstractShitBlock {
    private final SoundEvent RADIO_SOUND = ShitSounds.RADIO_TUNE;

    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(2.5, 0, 6, 13.5, 6, 10),
            Block.createCuboidShape(4, 5.5, 8, 6, 6.5, 9),
            Block.createCuboidShape(7, 4, 5.5, 9, 5, 6.5),
            Block.createCuboidShape(9.5, 2.5, 5.5, 12.5, 5.5, 6.5),
            Block.createCuboidShape(3.5, 2.5, 5.5, 6.5, 5.5, 6.5),
            Block.createCuboidShape(5, 0.5, 5.5, 6, 1.5, 6.5),
            Block.createCuboidShape(10, 0.5, 5.5, 11, 1.5, 6.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public RadioBlock(Settings settings) {
        super(settings, SHAPE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(null, pos, ShitSounds.RADIO_TUNE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(user, GameEvent.BLOCK_ACTIVATE, pos);
        }
        return ActionResult.PASS;
    }

    private void spawnNoteParticle(World world, BlockPos pos) {
        if (world instanceof ServerWorld serverWorld) {
            float f = (float)world.getRandom().nextInt(4) / 24.0F;
            serverWorld.spawnParticles(ParticleTypes.NOTE, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, f, 0.0, 0.0, 1.0);
        }

    }


    private void tick(World world, BlockPos pos) {
        this.spawnNoteParticle(world, pos);
    }

    public static void tick(World world, BlockPos pos, RadioBlock block) {
        block.tick(world, pos);
    }
}

