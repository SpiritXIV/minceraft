package com.spirit.tdbtd.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.entity.EntityChangeListener;
import net.minecraft.world.event.GameEvent;

public class TumulteicEffect extends StatusEffect {
    protected TumulteicEffect() {
        super(StatusEffectCategory.HARMFUL, 3124687);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            double s = pLivingEntity.getX();
            double y = pLivingEntity.getY();
            double z = pLivingEntity.getZ();

            pLivingEntity.emitGameEvent(GameEvent.SCULK_SENSOR_TENDRILS_CLICKING);
            pLivingEntity.emitGameEvent(GameEvent.SHRIEK);
        }

        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }


    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifer) {
        return true;
    }
}