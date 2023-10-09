package com.spirit.shit.entity;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.*;
import com.spirit.shit.entity.custom.vehicle.CropDusterEntity;
import com.spirit.shit.entity.custom.vehicle.TankEntity;
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
public class ShitEntities {

    private static final Set<EntityType<?>> ENTITY_ENTRIES = new HashSet<>();
    private static final Identifier MOD_ID = new Identifier(ShitMod.MOD_ID);

    public static final EntityType<JbirdEntity> JBIRD = registerEntity("jbird", SpawnGroup.CREATURE, JbirdEntity::new, 1f, 2f);
    public static final EntityType<RatBombEntity> RAT_BOMB = registerEntity("rat_bomb", SpawnGroup.MONSTER, RatBombEntity::new, 0.5f, 0.4f);
    public static final EntityType<RatEntity> RAT = registerEntity("rat", SpawnGroup.MONSTER, RatEntity::new, 0.5f, 0.4f);
    public static final EntityType<CapybaraEntity> CAPYBARA = registerEntity("capybara", SpawnGroup.MONSTER, CapybaraEntity::new, 1f, 1f);
    public static final EntityType<FreddyFazBearEntity> FREDDYFAZBEAR = registerEntity("freddy_faz_bear", SpawnGroup.MONSTER, FreddyFazBearEntity::new, 1f, 2f);
    public static final EntityType<SlimShadyEntity> SLIM_SHADY = registerEntity("slim_shady", SpawnGroup.MONSTER, SlimShadyEntity::new, 1f, 2f);
    public static final EntityType<YippeeEntity> YIPPEE = registerEntity("yippee", SpawnGroup.MONSTER, YippeeEntity::new, 1f, 0.6f);
    public static final EntityType<DartMonkeyEntity> DART_MONKEY = registerEntity("dart_monkey", SpawnGroup.MONSTER, DartMonkeyEntity::new, 1f, 0.6f);


    public static final EntityType<CropDusterEntity> CROP_DUSTER = registerEntity("crop_duster", SpawnGroup.MISC, CropDusterEntity::new, 1f, 1f);
    public static final EntityType<TankEntity> ABRAMS_TANK = registerEntity("abrams_tank", SpawnGroup.MISC, TankEntity::new, 1f, 1f);

    private static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup spawnGroup, EntityType.EntityFactory<T> factory, float width, float height) {
        Identifier entityId = new Identifier(ShitMod.MOD_ID, name);
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