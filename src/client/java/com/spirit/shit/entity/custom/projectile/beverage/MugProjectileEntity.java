package com.spirit.shit.entity.custom.projectile.beverage;

import com.spirit.shit.ShitMod;
import com.spirit.shit.common.BeverageProjectileEntity;
import com.spirit.shit.entity.damage.DamageTypes;
import com.spirit.shit.item.ShitItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class MugProjectileEntity extends BeverageProjectileEntity {
    public MugProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world, SoundEvents.BLOCK_GLASS_BREAK, DamageTypes.of(world, DamageTypes.MUGGED));
    }

    public MugProjectileEntity(World world, LivingEntity owner) {
        super(ShitMod.MugProjectileEntityType, world, owner, SoundEvents.BLOCK_GLASS_BREAK, DamageTypes.of(world, DamageTypes.MUGGED));
    }

    public MugProjectileEntity(World world, double x, double y, double z) {
        super(ShitMod.MugProjectileEntityType, world, x, y, z, SoundEvents.BLOCK_GLASS_BREAK, DamageTypes.of(world, DamageTypes.MUGGED));
    }

    @Override
    protected Item getDefaultItem() {
        return ShitItems.MUG;
    }
}
