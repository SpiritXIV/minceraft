package com.spirit.tdbtd;

import com.spirit.Main;
import com.spirit.tdbtd.block.TDBTDBlocks;
import com.spirit.tdbtd.effect.TDBTDEffects;
import com.spirit.tdbtd.entity.custom.*;
import com.spirit.tdbtd.item.TDBTDItemGroup;
import com.spirit.tdbtd.item.TDBTDItems;
import com.spirit.tdbtd.potion.TDBTDPotions;
import com.spirit.tdbtd.util.TDBTDLootTableModifiers;
import com.spirit.tdbtd.world.gen.TDBTDWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.spirit.tdbtd.entity.TDBTDEntities.*;
public class TDBTDMod implements ModInitializer {


    private static <T extends Entity> EntityType<T> registerEntityType(String name, SpawnGroup group, EntityType.EntityFactory<T> entityFactory, float width, float height) {
        Identifier entityId = new Identifier(Main.SHIT_ID, name);
        FabricEntityTypeBuilder<T> entityTypeBuilder = FabricEntityTypeBuilder.create(group, entityFactory)
                .dimensions(EntityDimensions.fixed(width, height))
                .trackRangeBlocks(4).trackedUpdateRate(10);
        return Registry.register(Registries.ENTITY_TYPE, entityId, entityTypeBuilder.build());
    }




    @Override
    public void onInitialize() {
        TDBTDItems.registerAll();
        TDBTDEffects.registerEffects();
        TDBTDPotions.registerPotions();
        TDBTDBlocks.registerAll();
        TDBTDItemGroup.register();
        TDBTDLootTableModifiers.modifyLootTables();


        FabricDefaultAttributeRegistry.register(TENEBROUS_NIBBLER, TenebrousNibblerEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(APERTURENTEETH, AperturenteethEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CODELAING, CodelaingEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(PERICARPIUM, PericarpiumEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(SCUTLEON, ScutleonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(NIDIVER, NidiverEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CURATOR, CuratorEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MIJAPENDRA, MijapendraEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CONTRIVANCEPOLLOONE, ContrivancePolloOneEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CONTRIVANCEPOLLA, ContrivancePollaEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ABYSSOFIN, AbyssofinEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(STURGO, SturgoEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ENGUIA, EnguiaEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(MALDININKAS, MaldininkasEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(DEVASTADOR_HOUND, DevastadorHoundEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(DEVASTADOR_CUR, DevastadorCurEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(DEVASTADOR_PUP, DevastadorPupEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(KREDA, KredaEntity.setAttributes());


        TDBTDWorldGeneration.generateTDBTDWorldGen();
        TDBTDWorldGeneration.registerWorldGenFeat();
    }

    public static void registerTDBTDMod() {
        Main.TDBTDLOGGER.info("> --Connected || the-shit-of-crypt/src/main/java/com/spirit/tdbtd/TDBTDMod");
    }

    private static <T extends Entity> EntityType<T> createBombEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(EntityDimensions.changing(0.25f, 0.25f)).trackRangeBlocks(64).trackedUpdateRate(1).forceTrackedVelocityUpdates(true).build();
    }
}


