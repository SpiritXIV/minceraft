package com.spirit.shit.item.custom;

import com.spirit.shit.item.ShitItems;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
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

//Alright so for default it needs to be off then when we right-click it, like not in the inv, it needs to turn on, aka the on variant, and when its on it shoots a lazer that deals damage, but also it needs to show where the lazer is going.)


public class LaserPointerItemOn extends Item {

    public LaserPointerItemOn(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(ShitItems.LASER_POINTER_OFF);
        } else {
            if (user instanceof PlayerEntity playerEntity && !((PlayerEntity)user).isCreative()) {
                ItemStack itemStack = new ItemStack(ShitItems.LASER_POINTER_OFF);
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, true);
                }
            }

            return stack;
        }
    }

    public int getMaxUseTime(ItemStack stack) {
        return 2;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }

    public SoundEvent getDrinkSound() {
        return ShitSounds.NOTHING;
    }

    public SoundEvent getEatSound() {
        return ShitSounds.NOTHING;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}

