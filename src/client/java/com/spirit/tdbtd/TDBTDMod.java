package com.spirit.tdbtd;

import com.spirit.Main;
import com.spirit.tdbtd.block.entity.TDBTDBlockEntities;
import com.spirit.tdbtd.effect.TDBTDEffects;
import com.spirit.tdbtd.entity.custom.*;
import com.spirit.tdbtd.item.TDBTDItemGroup;
import com.spirit.tdbtd.potion.TDBTDPotions;
import com.spirit.tdbtd.util.TDBTDLootTableModifiers;
import com.spirit.tdbtd.world.gen.TDBTDWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import static com.spirit.tdbtd.entity.TDBTDEntities.*;
public class TDBTDMod implements ModInitializer {
    @Override
    public void onInitialize() {
        TDBTDHelperMethods.registerAllItems();
        TDBTDEffects.registerEffects();
        TDBTDPotions.registerPotions();
        TDBTDHelperMethods.registerAllBlocks();
        TDBTDItemGroup.register();
        TDBTDLootTableModifiers.modifyLootTables();
        TDBTDBlockEntities.registerBlockEntities();
        FabricDefaultAttributeRegistry.register(TENEBROUS_NIBBLER, TenebrousNibblerEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(APERTURENTEETH, AperturenteethEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CODELAING, CodelaingEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(PERICARPIUM, PericarpiumEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(SCUTLEON, ScutleonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(NIDIVER, NidiverEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CURATOR, CuratorEntity.addAttributes());
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
}


