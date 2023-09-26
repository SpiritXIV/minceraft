package com.spirit.shit.mixin.client;

import net.minecraft.entity.damage.DamageTypes;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DamageTypes.class)
public class CustomDamageTypeRegistration {/*
    @Inject(method = "bootstrap", at = @At("HEAD"))
    private static void injectBootstrap(Registerable<DamageType> damageTypeRegisterable, CallbackInfo ci) {
        RegistryKey<DamageType> MUGSHOT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("shit", "got_mugged"));
        RegistryKey<DamageType> HIT_WITH_BOTTLE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("shit", "cracked_by_bottle"));
        RegistryKey<DamageType> SHOT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("shit", "shot"));

        damageTypeRegisterable.register(SHOT, new DamageType("shot", 0.1f));
        damageTypeRegisterable.register(MUGSHOT, new DamageType("got_mugged", 0.1f));
        damageTypeRegisterable.register(HIT_WITH_BOTTLE, new DamageType("cracked_by_bottle", 0.1f));
    }*/
}
