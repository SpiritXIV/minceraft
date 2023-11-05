package com.spirit.tdbtd.world.feature;

import com.spirit.Main;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class TDBTDFeature <FC extends FeatureConfig> {
    public static final Feature<DefaultFeatureConfig> SCULK_CAVE_VINES = TDBTDFeature.register("sculk_cave_vines", new TDBTDCaveVinesFeature(DefaultFeatureConfig.CODEC));

    private static Feature<DefaultFeatureConfig> register(String id, TDBTDCaveVinesFeature feature) {
        return Registry.register(Registries.FEATURE, new Identifier(Main.TDBTD_ID, id), feature);
    }

    public static void registerFeatures() {}

    }

