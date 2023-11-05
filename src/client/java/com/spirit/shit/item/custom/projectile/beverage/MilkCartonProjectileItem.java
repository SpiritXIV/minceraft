package com.spirit.shit.item.custom.projectile.beverage;

import com.spirit.shit.common.BeverageProjectileItem;
import com.spirit.shit.entity.custom.projectile.beverage.MilkCartonProjectileEntity;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class MilkCartonProjectileItem extends BeverageProjectileItem {
    private static final SoundEvent THROW_SOUND = ShitSounds.GLASS_BOTTLE_THROWN;
    public MilkCartonProjectileItem(Item.Settings settings) {
        super(settings, THROW_SOUND);
    }

    @Override
    public MilkCartonProjectileEntity createProjectileEntity(World world, PlayerEntity user) {
        return new MilkCartonProjectileEntity(world, user);
    }
}