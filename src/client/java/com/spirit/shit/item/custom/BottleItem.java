package com.spirit.shit.item.custom;

import com.spirit.shit.effect.ShitEffects;
import com.spirit.shit.item.ShitItems;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BottleItem extends Item {
    private static final int MAX_USE_TIME = 10;

    public BottleItem(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(ShitItems.PEPSI_CAN);
        } else {
            if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                ItemStack itemStack = new ItemStack(ShitItems.PEPSI_CAN);
                PlayerEntity playerEntity = (PlayerEntity)user;
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, false);
                }
            }

            return stack;
        }
    }

    public int getMaxUseTime(ItemStack stack) {
        return 10;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getDrinkSound() {
        return ShitSounds.SODA;
    }

    public SoundEvent getEatSound() {
        return ShitSounds.NOTHING;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}

