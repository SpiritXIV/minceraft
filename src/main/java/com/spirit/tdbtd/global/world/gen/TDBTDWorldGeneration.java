package com.spirit.tdbtd.global.world.gen;

import com.spirit.tdbtd.global.world.feature.TDBTDFeature;

public class TDBTDWorldGeneration {
    public static void generateTDBTDWorldGen() {
        TDBTDOreGeneration.generateOres();
        TDBTDDiskGeneration.generateDisk();
        TDBTDGeodeGeneration.generateGeode();
        TDBTDFossilGeneration.generateFossil();
        TDBTDMossGeneration.generateMoss();
        TDBTDReplaceGeneration.generateReplace();
        TDBTDMossCeilingGeneration.generateCeiling();
        TDBTDCaveVinesGeneration.generateVines();
        TDBTDTreeGeneration.generateTrees();
        TDBTDCaveVinesGeneration.generateTenvines();

        TDBTDEntitySpawn.addEntitySpawn();
    }
    public static void registerWorldGenFeat() {
        TDBTDFeature.registerFeatures();
    }
}
