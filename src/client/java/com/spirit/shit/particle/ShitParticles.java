package com.spirit.shit.particle;

import com.spirit.shit.ShitMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShitParticles {

    public static final DefaultParticleType SCHIZO_EYE_PARTICLE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType PLAYER_ENTITY_PARTICLE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType ZOMBIE_ENTITY_PARTICLE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType SKELETON_ENTITY_PARTICLE = FabricParticleTypes.simple(true);
    public static final DefaultParticleType CREEPER_ENTITY_PARTICLE = FabricParticleTypes.simple(true);


    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShitMod.MOD_ID, "schizo_eye_particle"),
                SCHIZO_EYE_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShitMod.MOD_ID, "player_entity_particle"),
                PLAYER_ENTITY_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShitMod.MOD_ID, "zombie_entity_particle"),
                ZOMBIE_ENTITY_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShitMod.MOD_ID, "skeleton_entity_particle"),
                SKELETON_ENTITY_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShitMod.MOD_ID, "creeper_entity_particle"),
                CREEPER_ENTITY_PARTICLE);
    }
}
