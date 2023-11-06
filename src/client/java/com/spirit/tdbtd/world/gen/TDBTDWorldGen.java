package com.spirit.tdbtd.world.gen;

public class  TDBTDWorldGen {
 public static void generateTDBTDWorldGen() {
        //TDBTDOreGeneration.generateOres();

        //TDBTDDiskGeneration.generateDiskTree();
        //TDBTDTreeGeneration.generateTrees();
        TDBTDCaveVinesGeneration.generateSculkCaveVines();

        //TDBTDDiskGeneration.generateDiskTD();
        //TDBTDDiskGeneration.generateDiskCD();
        //TDBTDDiskGeneration.generateDiskGD();

        //TDBTDPileGeneration.generatePileRibs();
        //TDBTDPileGeneration.generatePileSmallFern();
        //TDBTDPileGeneration.generatePileTeeth();
        //TDBTDPatchGeneration.generateLotusPatch();
        //TDBTDTenVinesGeneration.generateTenVines();

        //TDBTDGeodeGeneration.generateGeode();

        TDBTDEntitySpawn.addEntitySpawn();
    }
    public static void registerWorldGenFeat() {}


}
