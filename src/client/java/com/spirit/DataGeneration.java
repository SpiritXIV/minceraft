package com.spirit;

import com.spirit.shit.data.datagen.*;
import com.spirit.tdbtd.data.datagen.TDBTDWorldGenerator;
import com.spirit.tdbtd.global.world.TDBTDConfiguredFeatures;
import com.spirit.tdbtd.global.world.TDBTDPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.Nullable;

public class DataGeneration implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ShitBlockTagProvider::new);
        pack.addProvider(ShitItemTagProvider::new);
        pack.addProvider(ShitLootTableProvider::new);
        pack.addProvider(ShitModelProvider::new);
        pack.addProvider(ShitPoiTagProvider::new);

        pack.addProvider(TDBTDWorldGenerator::new);
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return DataGeneratorEntrypoint.super.getEffectiveModId();
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TDBTDConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, TDBTDPlacedFeatures::boostrap);
    }
}
