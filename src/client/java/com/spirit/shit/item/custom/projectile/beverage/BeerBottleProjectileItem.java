package com.spirit.shit.item.custom.projectile.beverage;

import com.spirit.shit.common.BeverageProjectileEntity;
import com.spirit.shit.common.BeverageProjectileItem;
import com.spirit.shit.entity.ShitEntities;
import com.spirit.shit.entity.custom.projectile.beverage.BeerBottleProjectileEntity;
import com.spirit.shit.entity.custom.projectile.beverage.MugProjectileEntity;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BeerBottleProjectileItem extends BeverageProjectileItem {
    private static final SoundEvent THROW_SOUND = ShitSounds.GLASS_BOTTLE_THROWN;
    public BeerBottleProjectileItem(Item.Settings settings) {
        super(settings, THROW_SOUND);
    }

    @Override
    public BeerBottleProjectileEntity createProjectileEntity(World world, PlayerEntity user) {
        return new BeerBottleProjectileEntity(world, user);
    }
}