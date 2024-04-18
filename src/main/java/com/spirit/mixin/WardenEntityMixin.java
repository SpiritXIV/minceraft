package com.spirit.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.HashSet;
import java.util.Set;

@Mixin(WardenEntity.class)
public class WardenEntityMixin extends MobEntity {

    @Unique
    private static final Set<WardenEntityMixin> allWardens = new HashSet<>();

    @Unique
    private LivingEntity lastAttacker;

    protected WardenEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        tickGoal();
        broadcastAttack();
    }

    @Unique
    protected void tickGoal() {
        LivingEntity currentTarget = this.getTarget();

        if (currentTarget == null || !currentTarget.isDead() || currentTarget == this.lastAttacker) {
            if (this.lastAttacker != null && !this.lastAttacker.isDead()) {
                this.setTarget(this.lastAttacker);
            } else {
                double closestDistanceSq = Double.MAX_VALUE;
                LivingEntity newTarget = null;

                for (LivingEntity potentialTarget : this.getAttackerList()) {
                    if (potentialTarget.isDead()) {
                        continue;
                    }

                    double distanceSq = this.squaredDistanceTo(potentialTarget);
                    if (distanceSq < closestDistanceSq) {
                        closestDistanceSq = distanceSq;
                        newTarget = potentialTarget;
                    }
                }

                if (newTarget != null) {
                    this.lastAttacker = newTarget;
                    this.setTarget(newTarget);
                }
            }
        }
    }

    @Unique
    private Iterable<LivingEntity> getAttackerList() {
        return this.getWorld().getEntitiesByClass(LivingEntity.class, this.getBoundingBox().expand(8.0D), (entity) -> entity != this);
    }

    @Unique
    private void broadcastAttack() {
        for (WardenEntityMixin warden : allWardens) {
            if (!warden.isDead() && warden.getTarget() == null) {
                warden.setTarget(this.getTarget());
                warden.getWorld().playSound(null, warden.getBlockPos(), SoundEvents.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM, SoundCategory.HOSTILE, 10.0f, 1.0f);
                warden.getWorld().addParticle(ParticleTypes.EXPLOSION_EMITTER, warden.getX(), warden.getY(), warden.getZ(), 20, 0.5, 0.5);
            }
        }
    }
}
