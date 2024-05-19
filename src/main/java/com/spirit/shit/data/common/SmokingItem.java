package com.spirit.shit.data.common;

import com.spirit.ignite.data.common.Common;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public abstract class SmokingItem extends Item {
    private static final int MAX_USE_TIME = 1800;
    private static final double DAMPENING_FACTOR = (double) 1 / 7;  // Adjust this value as needed, uses the same factor you used before

    public SmokingItem(Settings settings) {
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
            double[] directionVector = Common.calculateDirectionVector(user, DAMPENING_FACTOR);

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
        double[] directionVector = Common.calculateDirectionVector(user, DAMPENING_FACTOR);

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
        double[] directionVector = Common.calculateDirectionVector(user, DAMPENING_FACTOR);

        for (int i = 0; i < 4; i++) {
            user.getWorld().addParticle(ParticleTypes.SMOKE, user.getX(), user.getY() + 1.5, user.getZ(), directionVector[0], directionVector[1], directionVector[2]);
        }
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        // Common code for calculating direction vector based on pitch and yaw
        double[] directionVector = Common.calculateDirectionVector(user, DAMPENING_FACTOR);

        for (int i = 0; i < 4; i++) {
            user.getWorld().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, user.getX(), user.getY() + 1.5, user.getZ(), directionVector[0], directionVector[1], directionVector[2]);
            user.getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, user.getX(), user.getY() + 1.5, user.getZ(), directionVector[0], directionVector[1], directionVector[2]);
        }
    }
}

