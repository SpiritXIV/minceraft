package com.spirit.shit.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;

public class SchizophrenicEffect extends StatusEffect {
    protected SchizophrenicEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        if (!entity.getWorld().isClient()) {
            float health = entity.getHealth();
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();

            //Death Message
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (!entity.getWorld().isClient()) {
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            float health = entity.getHealth();
            float speed = entity.speed;
            float damage = (speed/25);
            boolean fire = entity.isOnFire();
            //Death Message
        }
    }
}