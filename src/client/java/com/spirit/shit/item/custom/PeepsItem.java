package com.spirit.shit.item.custom;

import com.spirit.shit.effect.ShitEffects;
import com.spirit.shit.item.ShitItems;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.UUID;

import static net.minecraft.util.TypedActionResult.fail;
import static net.minecraft.util.TypedActionResult.pass;
import static org.apache.http.util.EntityUtils.consume;

public class PeepsItem extends Item {
    private static final int MAX_USE_TIME = 10;

    public PeepsItem(Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 10;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            if (!((ServerPlayerEntity) user).getAbilities().creativeMode) {
                stack.decrement(1);
            }
            user.addStatusEffect(new StatusEffectInstance(ShitEffects.PEEPS_SPEED, 400, 0));
        }
        return stack;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_EAT;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}

