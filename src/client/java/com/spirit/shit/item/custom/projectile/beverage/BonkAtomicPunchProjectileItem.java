package com.spirit.shit.item.custom.projectile.beverage;

import com.spirit.shit.ShitMod;
import com.spirit.shit.common.BeverageProjectileEntity;
import com.spirit.shit.common.BeverageProjectileItem;
import com.spirit.shit.entity.custom.projectile.beverage.BeerBottleProjectileEntity;
import com.spirit.shit.entity.custom.projectile.beverage.BonkAtomicPunchProjectileEntity;
import com.spirit.shit.entity.damage.DamageTypes;
import com.spirit.shit.item.ShitItems;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class BonkAtomicPunchProjectileItem extends BeverageProjectileItem {
    private static final SoundEvent THROW_SOUND = ShitSounds.GLASS_BOTTLE_THROWN;
    public BonkAtomicPunchProjectileItem(Item.Settings settings) {
        super(settings, THROW_SOUND);
    }

    @Override
    public BonkAtomicPunchProjectileEntity createProjectileEntity(World world, PlayerEntity user) {
        return new BonkAtomicPunchProjectileEntity(world, user);
    }
}