package com.spirit.shit;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ShitModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    //    pack.addProvider(ModLootTableGenerator::new);
    //    pack.addProvider(ModRecipeGenerator::new);
    //    pack.addProvider(ModModelProvider::new);
    //    pack.addProvider(ModWorldGenerator::new);
    }

    //@Override
    //public void buildRegistry(RegistryBuilder registryBuilder) {
    //    registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
    //    registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

}
