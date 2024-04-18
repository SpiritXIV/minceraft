package com.spirit.shit.global.item.custom.projectile.beverage;

import com.spirit.shit.data.common.BeverageProjectileItem;
import com.spirit.shit.global.entity.custom.projectile.beverage.PepsiCanProjectileEntity;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class PepsiCanProjectileItem extends BeverageProjectileItem {
    private static final SoundEvent THROW_SOUND = ShitSounds.GLASS_BOTTLE_THROWN;
    public PepsiCanProjectileItem(Item.Settings settings) {
        super(settings, THROW_SOUND);
    }

    @Override
    public PepsiCanProjectileEntity createProjectileEntity(World world, PlayerEntity user) {
        return new PepsiCanProjectileEntity(world, user);
    }
}