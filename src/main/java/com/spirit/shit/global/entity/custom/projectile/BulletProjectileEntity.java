package com.spirit.shit.global.entity.custom.projectile;

import com.spirit.shit.ShitMod;
import com.spirit.shit.data.common.GunProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class BulletProjectileEntity extends GunProjectileEntity {
    public BulletProjectileEntity(EntityType<? extends GunProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public BulletProjectileEntity(World world, LivingEntity owner, double damage) {
        this(ShitMod.BulletProjectileEntityType, world);  // Replace with the actual class name where BulletProjectileEntityType is defined
        this.setOwner(owner);
        this.setPosition(owner.getX()     , owner.getEyeY() - 0.1, owner.getZ());
        this.setDamage(damage);
    }
}
