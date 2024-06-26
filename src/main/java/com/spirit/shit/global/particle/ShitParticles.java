package com.spirit.shit.global.particle;

import com.spirit.Main;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShitParticles {

    public static final DefaultParticleType PLAYER_ENTITY_PARTICLE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType ZOMBIE_ENTITY_PARTICLE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType SKELETON_ENTITY_PARTICLE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType CREEPER_ENTITY_PARTICLE = FabricParticleTypes.simple(true);

    private static void registerParticle(DefaultParticleType particleType, String name) {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Main.SHIT_ID, name), particleType);
    }

    public static void registerParticles() {
        registerParticle(PLAYER_ENTITY_PARTICLE, "player_entity_particle");
        registerParticle(ZOMBIE_ENTITY_PARTICLE, "zombie_entity_particle");
        registerParticle(SKELETON_ENTITY_PARTICLE, "skeleton_entity_particle");
        registerParticle(CREEPER_ENTITY_PARTICLE, "creeper_entity_particle");
    }
}