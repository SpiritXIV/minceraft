package com.spirit.tdbtd.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;

public class TumulteicEffect extends StatusEffect {
    protected TumulteicEffect() {
        super(StatusEffectCategory.HARMFUL, 3124687);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            stopAllSounds((ServerPlayerEntity) entity);
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    private static void stopAllSounds(ServerPlayerEntity target) {
        StopSoundS2CPacket stopSoundS2CPacket = new StopSoundS2CPacket(null, null);
        target.networkHandler.sendPacket(stopSoundS2CPacket);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}