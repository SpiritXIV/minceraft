package com.spirit.ignite.global.particle;

import com.spirit.Main;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IgniteParticles {

    public static final DefaultParticleType FLASH_BANG_PARTICLE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType FLASH = FabricParticleTypes.simple(true);

    private static void registerParticle(DefaultParticleType particleType, String name) {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Main.IGNITE_ID, name), particleType);
    }

    public static void registerParticles() {
        registerParticle(FLASH_BANG_PARTICLE, "flash_bang_particle");
    }
}