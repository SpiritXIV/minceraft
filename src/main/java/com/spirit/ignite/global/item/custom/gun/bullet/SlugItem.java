package com.spirit.ignite.global.item.custom.gun.bullet;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SlugItem extends ShotgunAbstract {
    public SlugItem(Settings settings) {
        super(settings);
    }

    @Override
    public void fire(World world, PlayerEntity player, double velocityModifier, ItemStack bulletItem, double damage) {
    }
}