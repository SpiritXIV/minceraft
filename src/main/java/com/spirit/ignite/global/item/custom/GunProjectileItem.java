package com.spirit.ignite.global.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class GunProjectileItem extends Item {
    public GunProjectileItem(Settings settings) {
        super(settings);
    }

    public abstract void fire(World world, PlayerEntity player, double velocityModifier, ItemStack bulletItem, double damage);
}