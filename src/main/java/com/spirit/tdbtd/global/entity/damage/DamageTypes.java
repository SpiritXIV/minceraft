package com.spirit.tdbtd.global.entity.damage;

import com.spirit.Main;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public interface DamageTypes {
    RegistryKey<DamageType> DIMENTED_SERPENT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(Main.TDBTD_ID, "dimented_serpent"));
    RegistryKey<DamageType> DIMENTED_SHOT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(Main.TDBTD_ID, "dimented_shot"));
    RegistryKey<DamageType> DIMENTED_LIFESHOT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(Main.TDBTD_ID, "dimented_lifeshot"));
    RegistryKey<DamageType> FISH_BITE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(Main.TDBTD_ID, "fish_bite"));
    RegistryKey<DamageType> SCULK_HURT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(Main.TDBTD_ID, "sculk_hurt"));

    static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}