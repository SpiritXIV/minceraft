package com.spirit.tdbtd.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class TumulteicEffect extends StatusEffect {
    protected TumulteicEffect() {
        super(StatusEffectCategory.HARMFUL, 3124687);
    }

    int effectNum = 39;

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            ServerWorld world = (ServerWorld) entity.getWorld();
            executeStopSound(world, entity);

        }

        super.applyUpdateEffect(entity, amplifier);
    }

    private void executeStopSound(ServerWorld world, LivingEntity entity) {
        if (entity.hasStatusEffect(StatusEffect.byRawId(effectNum))) {

            world.getServer().getCommandManager().executeWithPrefix(world.getServer().getCommandSource(), "stopsound @a[nbt={ActiveEffects:[{Id:" + effectNum + "}]}]");
        }
    }


    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
