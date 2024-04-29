package com.spirit.shit.global.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ShitFoodComponents {
    @SuppressWarnings("unused")
    public static final FoodComponent TEST = new FoodComponent.Builder().hunger(4).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0), 1.0f).build();

    //FOODS
    @SuppressWarnings("unused")
    public static final FoodComponent OAT = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build();
    public static final FoodComponent BANANA = new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build();
    public static final FoodComponent POCKY_STICK = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).build();
    public static final FoodComponent POCKY_STICKS = new FoodComponent.Builder().hunger(8).saturationModifier(1.0f).build();
    public static final FoodComponent POCKY_STICK_BOX = new FoodComponent.Builder().hunger(16).saturationModifier(3.0f).build();
    public static final FoodComponent COSCO_BIG_DOG = new FoodComponent.Builder().hunger(1000).saturationModifier(100.0f).build();

    //FOODS | WILL KILL YOU
    public static final FoodComponent PEEP = new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build();
    public static final FoodComponent URANIUM_DUST = new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build();


    //DRINKS
    public static final FoodComponent SODA = new FoodComponent.Builder().hunger(3).saturationModifier(1.0f).build();

    //DRINKS | WILL GIVE A GOOD TIME
    // @SuppressWarnings("unused") // THESE ARE ALREADY DEFINED!
    // public static final FoodComponent BEER = new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build();
    // public static final FoodComponent WINE = new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build();
    public static final FoodComponent FLASK = new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build();


    public static final FoodComponent NOTHING = new FoodComponent.Builder().hunger(0).saturationModifier(0f).build();

}
