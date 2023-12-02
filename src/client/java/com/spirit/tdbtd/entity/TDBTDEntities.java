package com.spirit.tdbtd.entity;

import com.spirit.Main;
import com.spirit.tdbtd.entity.custom.*;
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


@SuppressWarnings("typo")
public class TDBTDEntities {

    private static final Set<EntityType<?>> ENTITY_ENTRIES = new HashSet<>();
    private static final Identifier TDBTD_ID = new Identifier(Main.TDBTD_ID);


    public static final EntityType<TenebrousNibblerEntity> TENEBROUS_NIBBLER = registerEntity("tenebrous_nibbler", SpawnGroup.MONSTER, TenebrousNibblerEntity::new, 1f, 2f);
    public static final EntityType<AperturenteethEntity> APERTURENTEETH = registerEntity("aperturenteeth", SpawnGroup.MONSTER, AperturenteethEntity::new, 0.5f, 0.4f);
    public static final EntityType<CodelaingEntity> CODELAING = registerEntity("codelaing", SpawnGroup.MONSTER, CodelaingEntity::new, 1f, 1f);
    public static final EntityType<PericarpiumEntity> PERICARPIUM = registerEntity("pericarpium", SpawnGroup.MONSTER, PericarpiumEntity::new, 1f, 2f);
    public static final EntityType<ScutleonEntity> SCUTLEON = registerEntity("scutleon", SpawnGroup.MONSTER, ScutleonEntity::new, 1f, 2f);
    public static final EntityType<NidiverEntity> NIDIVER = registerEntity("nidiver", SpawnGroup.MONSTER, NidiverEntity::new, 1f, 0.6f);
    public static final EntityType<CuratorEntitySpare> CURATOR = registerEntity("curator", SpawnGroup.MONSTER, CuratorEntitySpare::new, 1f, 0.6f);
    public static final EntityType<MijapendraEntity> MIJAPENDRA = registerEntity("mijapendra", SpawnGroup.MONSTER, MijapendraEntity::new, 1f, 0.6f);
    public static final EntityType<ContrivancePolloOneEntity> CONTRIVANCEPOLLOONE = registerEntity("contrivancepolloone", SpawnGroup.MONSTER, ContrivancePolloOneEntity::new, 1f, 6f);
    public static final EntityType<ContrivancePollaEntity> CONTRIVANCEPOLLA = registerEntity("contrivancepolla", SpawnGroup.MONSTER, ContrivancePollaEntity::new, 1f, 0.6f);
    public static final EntityType<AbyssofinEntity> ABYSSOFIN = registerEntity("abyssofin", SpawnGroup.MONSTER, AbyssofinEntity::new, 1f, 0.6f);
    public static final EntityType<SturgoEntity> STURGO = registerEntity("sturgo", SpawnGroup.MONSTER, SturgoEntity::new, 1f, 0.6f);
    public static final EntityType<EnguiaEntity> ENGUIA = registerEntity("enguia", SpawnGroup.MONSTER, EnguiaEntity::new, 1f, 0.6f);
    public static final EntityType<MaldininkasEntity> MALDININKAS = registerEntity("maldininkas", SpawnGroup.MONSTER, MaldininkasEntity::new, 1f, 0.6f);
    public static final EntityType<DevastadorHoundEntity> DEVASTADOR_HOUND = registerEntity("devastador_hound", SpawnGroup.MONSTER, DevastadorHoundEntity::new, 1f, 0.6f);
    public static final EntityType<DevastadorCurEntity> DEVASTADOR_CUR = registerEntity("devastador_cur", SpawnGroup.MONSTER, DevastadorCurEntity::new, 1f, 0.6f);
    public static final EntityType<DevastadorPupEntity> DEVASTADOR_PUP = registerEntity("devastador_pup", SpawnGroup.MONSTER, DevastadorPupEntity::new, 1f, 0.6f);
    public static final EntityType<KredaEntity> KREDA = registerEntity("kreda", SpawnGroup.MONSTER, KredaEntity::new, 1f, 0.6f);

    private static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup spawnGroup, EntityType.EntityFactory<T> factory, float width, float height) {
        Identifier entityId = new Identifier(Main.TDBTD_ID, name);
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