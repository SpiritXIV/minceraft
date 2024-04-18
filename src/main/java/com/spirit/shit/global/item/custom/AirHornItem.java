package com.spirit.shit.global.item.custom;

import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class AirHornItem extends Item {
    private final ItemBar itemBar;
    private boolean isUsing = false;

    public AirHornItem(Settings settings) {
        super(settings);
        this.itemBar = new ItemBar(300, 2);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!world.isClient) {
            if (!isUsing && itemBar.consume()) {
                world.playSoundFromEntity(null, player, ShitSounds.AIRHORN_START, SoundCategory.PLAYERS, 10, 1);
                player.emitGameEvent(GameEvent.INSTRUMENT_PLAY);
                isUsing = true;
            } else if (isUsing && itemBar.getCurrentFill() != itemBar.getMaxCapacity() && itemBar.consume()) {
                world.playSoundFromEntity(null, player, ShitSounds.AIRHORN_LOOP, SoundCategory.PLAYERS, 10, 1);
                player.emitGameEvent(GameEvent.INSTRUMENT_PLAY);
                player.getItemCooldownManager().set(this, 25);
            } else {
                world.playSoundFromEntity(null, player, ShitSounds.AIRHORN_REFILL, SoundCategory.PLAYERS, 1, 1);
                player.emitGameEvent(GameEvent.INSTRUMENT_PLAY);
                player.getItemCooldownManager().set(this, 120);
                isUsing = false;
            }
        }
        return TypedActionResult.success(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && selected) {
            if (isUsing && itemBar.consume()) {
            } else {
                itemBar.refill();
            }
        }
    }

static class ItemBar {
        private final int maxCapacity;
        private int currentFill;
        private final int fillRate;

        public ItemBar(int maxCapacity, int fillRate) {
            this.maxCapacity = maxCapacity;
            this.currentFill = maxCapacity;
            this.fillRate = fillRate;
        }

        public boolean consume() {
            if (currentFill > 0) {
                currentFill -= fillRate;
                return true;
            } else {
                return false;
            }
        }

        public void refill() {
            if (currentFill < maxCapacity) {
                currentFill += fillRate * 2;
            }
        }

        public int getCurrentFill() {
            return currentFill;
        }
        public int getMaxCapacity() {
            return maxCapacity;
        }
    }
}
