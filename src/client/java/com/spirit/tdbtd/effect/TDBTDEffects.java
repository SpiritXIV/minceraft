package com.spirit.tdbtd.effect;

import com.spirit.Main;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TDBTDEffects {
    public static StatusEffect INFIRMA;
    public static StatusEffect TUMULTEIC;


    public static StatusEffect registerInfirmaPoisoningEffect (String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.TDBTD_ID, name),
                new InfirmaEffect().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                        "91AEAA56-376B-4498-935B-2F7F68070635", -0.5f,
                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }
    public static StatusEffect registerTumulteicEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.SHIT_ID, name),
                new TumulteicEffect()
                        .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                "91AEAA56-376B-4498-935B-2F7F68070635", 10.0f,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }

    public static void registerEffects() {
        INFIRMA = registerInfirmaPoisoningEffect("infirma");
        TUMULTEIC = registerTumulteicEffect("tumulteic");
    }
}
