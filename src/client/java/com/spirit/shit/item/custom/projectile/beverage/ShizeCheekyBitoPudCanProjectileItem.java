package com.spirit.shit.item.custom.projectile.beverage;

import com.spirit.shit.common.BeverageProjectileItem;
import com.spirit.shit.entity.custom.projectile.beverage.ShizeCheekyBitoPudCanProjectileEntity;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class ShizeCheekyBitoPudCanProjectileItem extends BeverageProjectileItem {
    private static final SoundEvent THROW_SOUND = ShitSounds.GLASS_BOTTLE_THROWN;
    public ShizeCheekyBitoPudCanProjectileItem(Item.Settings settings) {
        super(settings, THROW_SOUND);
    }

    @Override
    public ShizeCheekyBitoPudCanProjectileEntity createProjectileEntity(World world, PlayerEntity user) {
        return new ShizeCheekyBitoPudCanProjectileEntity(world, user);
    }
}