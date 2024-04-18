package com.spirit.shit.data.common;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public abstract class BeverageProjectileEntity extends ThrownItemEntity {
    private final SoundEvent collisionSound;
    private final DamageSource DamageSource;

    public BeverageProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world, SoundEvent collisionSound, DamageSource DamageSource) {
        super(entityType, world);
        this.collisionSound = collisionSound;
        this.DamageSource = DamageSource;
    }

    public BeverageProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner, SoundEvent collisionSound, DamageSource DamageSource) {
        super(entityType, owner, world);
        this.collisionSound = collisionSound;
        this.DamageSource = DamageSource;
    }

    public BeverageProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world, double x, double y, double z, SoundEvent collisionSound, DamageSource DamageSource) {
        super(entityType, x, y, z, world);
        this.collisionSound = collisionSound;
        this.DamageSource = DamageSource;
    }


    protected abstract Item getDefaultItem();

    @Environment(EnvType.CLIENT)
    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getItem();
        return itemStack.isEmpty() ? ParticleTypes.CRIT : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack);
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for(int i = 0; i < 8; ++i) {
                this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.damage(DamageSource, 5.0f);
            Common.applyKnockback(this, livingEntity, 0.5f);
        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.playSound(collisionSound, 10F, 1);
            this.kill();
        }
    }
}
