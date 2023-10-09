package com.spirit.shit.item.custom.projectile.beverage;

import com.spirit.shit.common.BeverageProjectileItem;
import com.spirit.shit.entity.custom.projectile.beverage.GlassJarProjectileEntity;
import com.spirit.shit.entity.custom.projectile.beverage.GlassJarProjectileEntity;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GlassJarProjectileItem extends BeverageProjectileItem {
    private static final SoundEvent THROW_SOUND = ShitSounds.GLASS_BOTTLE_THROWN;
    public GlassJarProjectileItem(Item.Settings settings) {
        super(settings, THROW_SOUND);
    }

    @Override
    public GlassJarProjectileEntity createProjectileEntity(World world, PlayerEntity user) {
        return new GlassJarProjectileEntity(world, user);
    }
}