package com.spirit.tdbtd.global.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.event.GameEvent;

public class DimentedScytheItem extends SwordItem {
    public DimentedScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      //target.addStatusEffect(new StatusEffectInstance(TDBTDEffects.TUMULTEIC, 250, 0), attacker);
        target.playSound(SoundEvents.ENTITY_PLAYER_BREATH, 1.0f, 0.6f);
        target.playSound(SoundEvents.ENTITY_ZOGLIN_ANGRY, 1.0f, 0.0f);
        target.playSound(SoundEvents.ENTITY_VEX_DEATH, 1.0f, 0.2f);
        target.playSound(SoundEvents.ENTITY_RAVAGER_STUNNED, 1.0f, 0.6f);
        target.playSound(SoundEvents.PARTICLE_SOUL_ESCAPE, 1.0f, 0.0f);
        target.playSound(SoundEvents.BLOCK_SCULK_CATALYST_BLOOM, 1.0f, 0.2f);
        target.emitGameEvent(GameEvent.ENTITY_ROAR);
        target.emitGameEvent(GameEvent.SHRIEK);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 250, 0), attacker);
        return super.postHit(stack, target, attacker);
    }
}

