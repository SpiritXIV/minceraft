package com.spirit.shit;

import com.spirit.shit.data.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ShitDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ShitBlockTagProvider::new);
        pack.addProvider(ShitItemTagProvider::new);
        pack.addProvider(ShitLootTableProvider::new);
        pack.addProvider(ShitModelProvider::new);
        pack.addProvider(ShitPoiTagProvider::new);
    }
}
