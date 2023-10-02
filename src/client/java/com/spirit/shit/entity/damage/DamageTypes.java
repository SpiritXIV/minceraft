package com.spirit.shit.entity.damage;

import net.minecraft.entity.damage.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public interface DamageTypes {
    RegistryKey<DamageType> MUGGED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("shit", "got_mugged"));

    static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}