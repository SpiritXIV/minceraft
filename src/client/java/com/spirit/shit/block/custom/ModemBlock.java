package com.spirit.shit.block.custom;

import com.spirit.shit.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ModemBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static final double DAMPENING_FACTOR = (double) 1 / 2;  // Adjust this value as needed, uses the same factor you used before


    public ModemBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(6.5, 0.15, 4, 9.5, 9.15, 12),
            Block.createCuboidShape(8.75, 0, 4, 9.75, 9, 12),
            Block.createCuboidShape(6.25, 0, 4, 7.25, 9, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_N;
    }

    @Nullable

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hit) {
        double[] directionVector = calculateDirectionVector(user);

        user.getWorld().disconnect();

        //leave this alone, its just particles but still leave it
        for (int i = 0; i < 0.1; i++) {
            user.getWorld().addParticle(ParticleTypes.END_ROD, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.END_ROD, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SQUID_INK, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SQUID_INK, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SQUID_INK, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SQUID_INK, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SNOWFLAKE, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SNOWFLAKE, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.CLOUD, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.CLOUD, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.POOF, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.POOF, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.MYCELIUM, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.MYCELIUM, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SMOKE, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SMOKE, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SCULK_CHARGE_POP, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.SCULK_CHARGE_POP, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.TOTEM_OF_UNDYING, user.getX() + (world.getRandom().nextFloat() * -0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * -0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.TOTEM_OF_UNDYING, user.getX() + (world.getRandom().nextFloat() * 0.2F + 0F), user.getY() + (world.getRandom().nextFloat() * -2F + 2F), user.getZ()  + (world.getRandom().nextFloat() * 0.2F + 0F), directionVector[0], directionVector[1], directionVector[2]);
            
            user.getWorld().addParticle(ParticleTypes.CRIMSON_SPORE, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0,0);
            user.getWorld().addParticle(ParticleTypes.CRIMSON_SPORE, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0,0);
            user.getWorld().addParticle(ParticleTypes.WARPED_SPORE, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0,0);
            user.getWorld().addParticle(ParticleTypes.WARPED_SPORE, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.ASH, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.ASH, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.WHITE_ASH, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.TOTEM_OF_UNDYING, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.WHITE_ASH, pos.getX(), pos.getY(), pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.TOTEM_OF_UNDYING, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);
            user.getWorld().addParticle(ParticleTypes.FLASH, pos.getX(), pos.getY() + 0.3, pos.getZ(), 0, 0, 0);

            //i need to add a sound for this
            user.playSound(ShitSounds.MICROWAVE_BEEP, SoundCategory.BLOCKS, 1, 1);
        }



        return ActionResult.PASS;
    }

    private double[] calculateDirectionVector(LivingEntity user) {
        // Get the pitch and yaw from the player
        float pitch = user.getPitch(1.0F);
        float yaw = user.getYaw(1.0F);

        // Convert pitch and yaw to radians
        double pitchRadians = Math.toRadians(pitch);
        double yawRadians = Math.toRadians(yaw);

        // Calculate direction vector for particles
        double xx = -Math.sin(yawRadians) * Math.cos(pitchRadians);
        double yy = -Math.sin(pitchRadians);
        double zz = Math.cos(yawRadians) * Math.cos(pitchRadians);

        // Apply dampening factor to the direction vector
        xx *= DAMPENING_FACTOR;
        yy *= DAMPENING_FACTOR;
        zz *= DAMPENING_FACTOR;

        return new double[]{xx, yy, zz};
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

