package com.spirit.tdbtd.global.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class TDBTDFoodComponents {
    public static final FoodComponent SCULK_APPLE = new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_BAKED_POTATO = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_BEEF = new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_BEETROOT = new FoodComponent.Builder().hunger(3).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_BREAD = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_CARROT = new FoodComponent.Builder().hunger(5).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_CHICKEN = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_COD = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_COOKED_BEEF = new FoodComponent.Builder().hunger(10).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_COOKED_CHICKEN = new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_COOKED_COD = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_COOKED_MUTTON = new FoodComponent.Builder().hunger(8).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_COOKED_PORKCHOP = new FoodComponent.Builder().hunger(10).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_COOKED_RABBIT = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_COOKED_SALMON = new FoodComponent.Builder().hunger(8).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_COOKIE = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_DRIED_KELP = new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).snack().build();
    public static final FoodComponent SCULK_ENCHANTED_GOLDEN_APPLE = new FoodComponent.Builder().hunger(6).saturationModifier(1.4f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7000, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7000, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3500, 3), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 80, 0), 1.0f).alwaysEdible().build();
    public static final FoodComponent SCULK_GOLDEN_APPLE = new FoodComponent.Builder().hunger(6).saturationModifier(1.4f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3400, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 80, 0), 1.0f).alwaysEdible().build();
    public static final FoodComponent SCULK_GOLDEN_CARROT = new FoodComponent.Builder().hunger(8).saturationModifier(1.4f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_MELON_SLICE = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_MUTTON = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_POISONOUS_POTATO = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 0.6f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0), 1.0f).build();
    public static final FoodComponent SCULK_PORKCHOP = new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_POTATO = new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_PUFFERFISH = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 1200, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 2), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1.0f).build();
    public static final FoodComponent SCULK_PUMPKIN_PIE = new FoodComponent.Builder().hunger(10).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_RABBIT = new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_ROTTEN_FLESH = new FoodComponent.Builder().hunger(6).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.8f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 600, 0), 1.0f).meat().build();
    public static final FoodComponent SCULK_SALMON = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_SPIDER_EYE = new FoodComponent.Builder().hunger(4).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0), 1.0f).build();
    public static final FoodComponent SCULK_SWEET_BERRIES = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_GLOW_BERRIES = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
    public static final FoodComponent SCULK_TROPICAL_FISH = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0), 1.0f).build();
}
