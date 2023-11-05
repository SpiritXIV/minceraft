package com.spirit.tdbtd.potion;

import com.spirit.Main;
import com.spirit.tdbtd.effect.TDBTDEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TDBTDPotions {
    public static Potion INFIRMA;
    public static Potion TUMULTEIC;

    private static Potion registerPotion(String name, StatusEffectInstance effectInstance) {
        return Registry.register(Registries.POTION, new Identifier(Main.TDBTD_ID, name), new Potion(effectInstance));
    }

    public static void registerPotions() {
        INFIRMA = registerPotion("radiation_poisoning",new StatusEffectInstance(TDBTDEffects.INFIRMA, 200, 0));
        TUMULTEIC = registerPotion("tumulteic_potion", new StatusEffectInstance(TDBTDEffects.TUMULTEIC, 200, 0));
    }
}