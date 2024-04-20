package com.spirit.ignite;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class IgniteDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
/*
        pack.addProvider(GamblicBlockTagProvider::new);
        pack.addProvider(GamblicItemTagProvider::new);
        pack.addProvider(GamblicLootTableProvider::new);
        pack.addProvider(GamblicModelProvider::new);
        pack.addProvider(GamblicPoiTagProvider::new);
 */
    }
}
