package com.spirit.tdbtd.world.gen;

import com.spirit.tdbtd.world.feature.TDBTDFeature;

public class TDBTDWorldGeneration {
    public static void generateTDBTDWorldGen() {
        TDBTDOreGeneration.generateOres();
        TDBTDDiskGeneration.generateDisk();
        TDBTDGeodeGeneration.generateGeode();
        TDBTDFossilGeneration.generateFossil();
        TDBTDMossGeneration.generateMoss();
        TDBTDMossCeilingGeneration.generateCeiling();
        TDBTDCaveVinesGeneration.generateVines();
        TDBTDTreeGeneration.generateTrees();
        TDBTDCritericCharredGeneration.generateCritericCharred();

        TDBTDEntitySpawn.addEntitySpawn();
    }
    public static void registerWorldGenFeat() {
        TDBTDFeature.registerFeatures();
    }
}
