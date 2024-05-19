package com.spirit.ignite.global.entity;

import com.spirit.Main;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class IgniteEntities {

    private static final Set<EntityType<?>> ENTITY_ENTRIES = new HashSet<>();
    private static final Identifier IGNITE_ID = new Identifier(Main.IGNITE_ID);


    private static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup spawnGroup, EntityType.EntityFactory<T> factory, float width, float height) {
        Identifier entityId = new Identifier(Main.IGNITE_ID, name);
        EntityType<T> entityType = Registry.register(
                Registries.ENTITY_TYPE, entityId,
                FabricEntityTypeBuilder.create(spawnGroup, factory)
                        .dimensions(EntityDimensions.fixed(width, height))
                        .build()
        );
        ENTITY_ENTRIES.add(entityType);
        return entityType;
    }
}