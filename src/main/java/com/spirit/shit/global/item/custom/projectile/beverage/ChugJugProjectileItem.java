package com.spirit.shit.global.item.custom.projectile.beverage;

import com.spirit.shit.data.common.BeverageProjectileItem;
import com.spirit.shit.global.entity.custom.projectile.beverage.ChugJugProjectileEntity;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class ChugJugProjectileItem extends BeverageProjectileItem {
    private static final SoundEvent THROW_SOUND = ShitSounds.GLASS_BOTTLE_THROWN;
    public ChugJugProjectileItem(Item.Settings settings) {
        super(settings, THROW_SOUND);
    }

    @Override
    public ChugJugProjectileEntity createProjectileEntity(World world, PlayerEntity user) {
        return new ChugJugProjectileEntity(world, user);
    }
}