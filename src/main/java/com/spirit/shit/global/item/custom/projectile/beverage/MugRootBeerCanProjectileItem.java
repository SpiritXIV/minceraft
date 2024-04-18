package com.spirit.shit.global.item.custom.projectile.beverage;

import com.spirit.shit.data.common.BeverageProjectileItem;
import com.spirit.shit.global.entity.custom.projectile.beverage.MugRootBeerCanProjectileEntity;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class MugRootBeerCanProjectileItem extends BeverageProjectileItem {
    private static final SoundEvent THROW_SOUND = ShitSounds.GLASS_BOTTLE_THROWN;
    public MugRootBeerCanProjectileItem(Item.Settings settings) {
        super(settings, THROW_SOUND);
    }

    @Override
    public MugRootBeerCanProjectileEntity createProjectileEntity(World world, PlayerEntity user) {
        return new MugRootBeerCanProjectileEntity(world, user);
    }
}