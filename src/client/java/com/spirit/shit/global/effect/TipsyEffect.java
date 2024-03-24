package com.spirit.shit.global.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class TipsyEffect extends StatusEffect {
    protected TipsyEffect() {
        super(StatusEffectCategory.HARMFUL, 15259508);
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
            //entity.damage(new DamageSource("energized_by_peep_low_health"), health / 3);
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
            //entity.damage(new DamageSource("energized_by_peep_two"), health);
        }
    }
}