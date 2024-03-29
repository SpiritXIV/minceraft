package com.spirit.shit.global.entity.custom.projectile.beverage;

import com.spirit.shit.ShitMod;
import com.spirit.shit.data.common.BeverageProjectileEntity;
import com.spirit.shit.global.entity.damage.DamageTypes;
import com.spirit.shit.global.item.ShitItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ShizeGamerEnergyCanProjectileEntity extends BeverageProjectileEntity {
    static EntityType TYPE = ShitMod.ShizeGamerEnergyCanProjectileEntityType;
    public static final SoundEvent SOUND = SoundEvents.BLOCK_GLASS_BREAK;
    public static final Item ITEM = ShitItems.BEER_BOTTLE;

    public ShizeGamerEnergyCanProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world, SOUND, DamageTypes.of(world, DamageTypes.MUGGED));
    }

    public ShizeGamerEnergyCanProjectileEntity(World world, LivingEntity owner) {
        super(TYPE, world, owner, SOUND, DamageTypes.of(world, DamageTypes.MUGGED));
    }

    public ShizeGamerEnergyCanProjectileEntity(World world, double x, double y, double z) {
        super(TYPE, world, x, y, z, SOUND, DamageTypes.of(world, DamageTypes.MUGGED));
    }

    @Override
    protected Item getDefaultItem() {
        return ITEM;
    }
}
