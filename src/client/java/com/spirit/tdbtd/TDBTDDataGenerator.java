package com.spirit.tdbtd;

import com.spirit.tdbtd.data.TDBTDWorldGenerator;
import com.spirit.tdbtd.world.TDBTDConfiguredFeatures;
import com.spirit.tdbtd.world.TDBTDPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.Nullable;

public class TDBTDDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TDBTDWorldGenerator::new);
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return DataGeneratorEntrypoint.super.getEffectiveModId();
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TDBTDConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, TDBTDPlacedFeatures::bootstrap);
    }
}
