package com.spirit.shit.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CigarItem extends Item {
    private static final int MAX_USE_TIME = 1800;
    private static final double DAMPENING_FACTOR = (double) 1 / 7;  // Adjust this value as needed, uses the same factor you used before

    public CigarItem(Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(ItemStack stack) {
        return MAX_USE_TIME;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            if (!serverPlayerEntity.getAbilities().creativeMode) {
                stack.decrement(1);
            }

            // Common code for calculating direction vector based on pitch and yaw
            double[] directionVector = calculateDirectionVector(user);

            // Generate particles when the item is finished using
            for (int i = 0; i < 3; i++) {
                user.getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, user.getX(), user.getY() + 1.5, user.getZ(), directionVector[0], directionVector[1], directionVector[2]);
            }

            float health = user.getHealth();
            user.damage(new DamageSource(RegistryEntry.of(new DamageType("smoked_to_much", 1))), health);
        }
        return stack;
    }
    public TypedActionResult<ItemStack> use(ItemStack stack, World world, PlayerEntity user, Hand hand) {
        // Common code for calculating direction vector based on pitch and yaw
        double[] directionVector = calculateDirectionVector(user);

        // Fire the particle 3 times
        for (int i = 0; i < 3; i++) {
            user.getWorld().addParticle(ParticleTypes.SMOKE, user.getX(), user.getY() + 1.5, user.getZ(), directionVector[0], directionVector[1], directionVector[2]);
        }

        user.getItemCooldownManager().set(this, 15);
        stack.damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        // Common code for calculating direction vector based on pitch and yaw
        double[] directionVector = calculateDirectionVector(user);

        for (int i = 0; i < 4; i++) {
            user.getWorld().addParticle(ParticleTypes.SMOKE, user.getX(), user.getY() + 1.5, user.getZ(), directionVector[0], directionVector[1], directionVector[2]);
        }
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        // Common code for calculating direction vector based on pitch and yaw
        double[] directionVector = calculateDirectionVector(user);

        for (int i = 0; i < 4; i++) {
            user.getWorld().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, user.getX(), user.getY() + 1.5, user.getZ(), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, user.getX(), user.getY() + 1.5, user.getZ(), directionVector[0], directionVector[1], directionVector[2]);
        }
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
}

