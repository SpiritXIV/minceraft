package com.spirit.shit.global.block.custom;

import com.spirit.shit.data.common.AbstractShitBlock;
import com.spirit.shit.data.common.Common;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.stream.Stream;

public class ModemBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(6.5, 0.15, 4, 9.5, 9.15, 12),
            Block.createCuboidShape(8.75, 0, 4, 9.75, 9, 12),
            Block.createCuboidShape(6.25, 0, 4, 7.25, 9, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final double DAMPENING_FACTOR = (double) 1 / 2;

    public ModemBlock(Settings settings) {
        super(settings, SHAPE);
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hit) {
        double[] directionVector = Common.calculateDirectionVector(user, DAMPENING_FACTOR);

        user.getWorld().disconnect();

        // leave this alone, its just particles but still leave it. NO
        // By the way, these particles are client side. I can implement it server side too if u want.

        ParticleType<?>[] particleTypes = new ParticleType<?>[]{
                ParticleTypes.END_ROD,
                ParticleTypes.SQUID_INK,
                ParticleTypes.SNOWFLAKE,
                ParticleTypes.CLOUD,
                ParticleTypes.POOF,
                ParticleTypes.MYCELIUM,
                ParticleTypes.LARGE_SMOKE,
                ParticleTypes.SMOKE,
                ParticleTypes.SCULK_CHARGE_POP,
                ParticleTypes.TOTEM_OF_UNDYING
        };

        addParticles(user, world, particleTypes, directionVector);

        for (int i = 0; i < 2; i++) { // Spawn 2 of each particle
            user.getWorld().addParticle(ParticleTypes.CRIMSON_SPORE, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.WARPED_SPORE, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.ASH, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.WHITE_ASH, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.TOTEM_OF_UNDYING, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
        }
        user.getWorld().addParticle(ParticleTypes.FLASH, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);

        // I need to add a sound for this
        user.playSound(ShitSounds.MICROWAVE_BEEP, SoundCategory.BLOCKS, 1, 1);
        user.sendMessage(Text.of("[!] | incomplete"));
        return ActionResult.PASS;
    }
    // Helper method to add particles

    private void addParticles(PlayerEntity user, World world, ParticleType<?>[] particleTypes, double[] directionVector) {
        for (ParticleType<?> particleType : particleTypes) {
            double xOffset, yOffset = user.getY() + (world.getRandom().nextFloat() * -2F + 2F), zOffset;
            for (int i = 0; i < 2; i++) {
                xOffset = user.getX() + (world.getRandom().nextFloat() * (i == 0 ? -0.2F : 0.2F));
                zOffset = user.getZ() + (world.getRandom().nextFloat() * (i == 0 ? -0.2F : 0.2F));
                user.getWorld().addParticle((ParticleEffect) particleType, xOffset, yOffset, zOffset, directionVector[0], directionVector[1], directionVector[2]);
            }
        }
    }
    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }
}

