package com.spirit.shit.potion;

import com.spirit.shit.ShitMod;
import com.spirit.shit.effect.ShitEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShitPotions {
    public static Potion RADIATION_POISONING;
    public static Potion PEEPS_SPEED;

    public static Potion registerRadiationPoisoningPotion(String name) {
        return Registry.register(Registries.POTION, new Identifier(ShitMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(ShitEffects.RADIATION_POISONING, 200, 0)));
    }
    public static Potion registerPeepSpeedPotion(String name) {
        return Registry.register(Registries.POTION, new Identifier(ShitMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(ShitEffects.PEEPS_SPEED, 200, 0)));
    }

    public static void registerPotions() {
        RADIATION_POISONING = registerRadiationPoisoningPotion("radiation_poisoning");
        PEEPS_SPEED = registerPeepSpeedPotion("peeps_speed");
    }
    public static void registerShitPotions() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/potion/ShitPotion");
    }
}