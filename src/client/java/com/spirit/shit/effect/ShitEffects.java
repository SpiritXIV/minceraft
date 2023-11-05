package com.spirit.shit.effect;

import com.spirit.Main;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShitEffects {
    public static StatusEffect RADIATION_POISONING;
    public static StatusEffect PEEPS_SPEED;
    public static StatusEffect SCHIZOPHRENIC;
    public static StatusEffect TIPSY;


    public static StatusEffect registerRadiationPoisoningEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.SHIT_ID, name),
                new RadiationPoisoningEffect().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                        "91AEAA56-376B-4498-935B-2F7F68070635", -0.5f,
                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }
    public static StatusEffect registerPeepSpeedEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.SHIT_ID, name),
                new PeepSpeedEffect()
                        .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                "91AEAA56-376B-4498-935B-2F7F68070635", 10.0f,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }
    public static StatusEffect registerSchizophrenicEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.SHIT_ID, name),
                new SchizophrenicEffect());

    }
    public static StatusEffect registerTipsyEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.SHIT_ID, name),
                new TipsyEffect().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                        "91AEAA56-376B-4498-935B-2F7F68070635", -0.01f,
                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
}
    public static void registerEffects() {
        RADIATION_POISONING = registerRadiationPoisoningEffect("radiation_poisoning");
        PEEPS_SPEED = registerPeepSpeedEffect("peep_speed");
        SCHIZOPHRENIC = registerSchizophrenicEffect("schizophrenic");
        TIPSY = registerTipsyEffect("tipsy_effect");
    }
}
