package com.spirit.tdbtd.item.custom;

import com.spirit.tdbtd.effect.TDBTDEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.event.GameEvent;

public class SoulShriekerItem extends SwordItem {
    public SoulShriekerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(TDBTDEffects.TUMULTEIC, 500, 0), attacker);
        target.playSound(SoundEvents.ENTITY_PLAYER_BREATH, 1.0f, 0.6f);
        target.playSound(SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 0f);
        target.playSound(SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 1f);
        target.playSound(SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 2f);
        target.playSound(SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 0.6f);
        target.playSound(SoundEvents.BLOCK_SCULK_CATALYST_BLOOM, 1.0f, 0.2f);
        target.setSwimming(true);
        target.emitGameEvent(GameEvent.ENTITY_ROAR);
        target.emitGameEvent(GameEvent.SHRIEK);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 500, 0), attacker);
        return super.postHit(stack, target, attacker);
    }
}

