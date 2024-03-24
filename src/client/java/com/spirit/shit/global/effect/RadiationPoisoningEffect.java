package com.spirit.shit.global.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

public class RadiationPoisoningEffect extends StatusEffect {
    protected RadiationPoisoningEffect() {
        super(StatusEffectCategory.HARMFUL, 5149489);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        if (!entity.getWorld().isClient()) {

            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 9999999, 9));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 9999999, 0));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 9999999, 14));
            entity.setOnFireFor(1000000000);
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

            entity.removeStatusEffect(StatusEffects.NAUSEA);
            entity.removeStatusEffect(StatusEffects.POISON);
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            //Death Message
            entity.damage(new DamageSource(RegistryEntry.of(new DamageType("radiation_poisoned", 1))), health);
        }
    }
}