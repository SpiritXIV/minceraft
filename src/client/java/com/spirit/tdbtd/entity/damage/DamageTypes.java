package com.spirit.tdbtd.entity.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public interface DamageTypes {
    RegistryKey<DamageType> DIMENTED_SERPENT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("tdbtd", "dimented_serpent"));
    RegistryKey<DamageType> DIMENTED_SHOT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("tdbtd", "dimented_shot"));
    RegistryKey<DamageType> FISH_BITE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("tdbtd", "fish_bite"));

    static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}