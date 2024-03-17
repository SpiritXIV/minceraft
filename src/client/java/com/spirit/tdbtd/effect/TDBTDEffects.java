package com.spirit.tdbtd.effect;

import com.spirit.Main;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TDBTDEffects {
    public static StatusEffect INFIRMA;
    public static StatusEffect TUMULTEIC;


    public static StatusEffect registerInfirmaPoisoningEffect (String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.TDBTD_ID, name),
                new InfirmaEffect());
    }
    public static StatusEffect registerTumulteicEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.TDBTD_ID, name),
                new TumulteicEffect());
    }

    public static void registerEffects() {
        INFIRMA = registerInfirmaPoisoningEffect("infirma");
        TUMULTEIC = registerTumulteicEffect("tumulteic");
    }
}
