package com.spirit.shit.global.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import net.minecraft.world.explosion.ExplosionBehavior;

public class PeepSpeedEffect extends StatusEffect {
    protected PeepSpeedEffect() {
        super(StatusEffectCategory.HARMFUL, 14270531);
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
            entity.damage(new DamageSource(RegistryEntry.of(new DamageType("energized_by_peep_low_health", 1))), health / 3);
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

            entity.getWorld().createExplosion(entity, new DamageSource(RegistryEntry.of(new DamageType("gas_can_bomb",1 ))), new ExplosionBehavior(), x, y + 1, z, 10, true, World.ExplosionSourceType.TNT);
            //Death Message
            entity.damage(new DamageSource(RegistryEntry.of(new DamageType("energized_by_peep", 1))), health);
        }
    }
}