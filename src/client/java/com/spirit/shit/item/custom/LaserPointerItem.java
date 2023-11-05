package com.spirit.shit.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LaserPointerItem extends Item {
    private static final String TAG_ACTIVE = "active";

    public LaserPointerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        NbtCompound tag = itemStack.getOrCreateNbt();

        if (hand == Hand.MAIN_HAND) {
            // Check if the laser is currently active
            boolean isActive = tag.getBoolean(TAG_ACTIVE);

            // Toggle the laser effect or perform the "AHHH" action
            if (isActive) {
                // Laser is currently active, turn it off
                tag.putBoolean(TAG_ACTIVE, false);
                // Perform "AHHH" action when turning off
            } else {
                // Laser is currently inactive, turn it on
                tag.putBoolean(TAG_ACTIVE, true);
                // Perform "AHHH" action when turning on
            }
        }

        return TypedActionResult.success(itemStack);
    }
}
