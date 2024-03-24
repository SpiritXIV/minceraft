package com.spirit.tdbtd.global.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class InfirmaEffect extends StatusEffect {
    protected InfirmaEffect() {
        super(StatusEffectCategory.HARMFUL, 3124687);
    }


    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            double m = pLivingEntity.getMovementSpeed();
            double j = pLivingEntity.getJumpBoostVelocityModifier();
            double a = pLivingEntity.getArmor();
            double h = pLivingEntity.getHealth();
            double head = pLivingEntity.getHeadYaw();
            double body = pLivingEntity.getBodyYaw();
            double arrow = pLivingEntity.getStuckArrowCount();
            double sting = pLivingEntity.getStingerCount();
            double xp = pLivingEntity.getXpToDrop();

            pLivingEntity.setMovementSpeed((float) ((float) h - m));
            pLivingEntity.setSprinting(false);
            pLivingEntity.setAbsorptionAmount((float) ((float) arrow + head));
            pLivingEntity.setHealth((float) ((float)  m + xp));
            pLivingEntity.setHeadYaw((float) ((float) j + a));
            pLivingEntity.setBodyYaw((float) h);
            pLivingEntity.setPitch((float) sting);
            pLivingEntity.setSwimming(false);
            pLivingEntity.setYaw((float) arrow);
        }

        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }


    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifer) {
        return true;
    }
}
