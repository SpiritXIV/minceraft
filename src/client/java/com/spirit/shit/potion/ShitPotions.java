package com.spirit.shit.potion;

import com.spirit.Main;
import com.spirit.shit.effect.ShitEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShitPotions {
    public static Potion RADIATION_POISONING;
    public static Potion PEEPS_SPEED;

    private static Potion registerPotion(String name, StatusEffectInstance effectInstance) {
        return Registry.register(Registries.POTION, new Identifier(Main.SHIT_ID, name), new Potion(effectInstance));
    }

    public static void registerPotions() {
        RADIATION_POISONING = registerPotion("radiation_poisoning", new StatusEffectInstance(ShitEffects.RADIATION_POISONING, 200, 0));
        PEEPS_SPEED = registerPotion("peeps_speed", new StatusEffectInstance(ShitEffects.PEEPS_SPEED, 200, 0));
    }
}