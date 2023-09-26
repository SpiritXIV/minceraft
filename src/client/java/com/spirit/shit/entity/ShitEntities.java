package com.spirit.shit.entity;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.*;
import com.spirit.shit.entity.custom.projectile.RedBrickProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShitEntities {

    public static final EntityType<JbirdEntity> JBIRD = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShitMod.MOD_ID, "jbird"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JbirdEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());
    public static final EntityType<RatBombEntity> RAT_BOMB = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShitMod.MOD_ID, "rat_bomb"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, RatBombEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());
    public static final EntityType<RatEntity> RAT = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShitMod.MOD_ID, "rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, RatEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());
    public static final EntityType<CapybaraEntity> CAPYBARA = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShitMod.MOD_ID, "capybara"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CapybaraEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
    public static final EntityType<FreddyFazBearEntity> FREDDYFAZBEAR = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShitMod.MOD_ID, "freddy_faz_bear"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FreddyFazBearEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());
    public static final EntityType<SlimShadyEntity> SLIM_SHADY = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShitMod.MOD_ID, "slim_shady"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SlimShadyEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());
    public static final EntityType<YippeeEntity> YIPPEE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ShitMod.MOD_ID, "yippee"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, YippeeEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 0.6f)).build());

    public static void registerShitEntities() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/entity/ShitEntities");
    }
    public static void registerShitEntityAI() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/entity/ShitEntities>ai/goal");
    }
    public static void registerShitCustomEntity() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/entity/ShitEntities>custom");
    }
    public static void registerShitCustomPEntity() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/entity/ShitEntities>custom/projectile");
    }
    public static void registerShitClientEntity() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/entity/ShitEntities>client");
    }
}