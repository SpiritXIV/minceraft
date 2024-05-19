package com.spirit.ignite.global.entity.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public interface DamageTypes {
    RegistryKey<DamageType> SHOT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("ignite", "shot"));
    RegistryKey<DamageType> BLEW_SELF = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("ignite", "blew_self"));
    RegistryKey<DamageType> GRENADED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("ignite", "grenaded"));

    static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}