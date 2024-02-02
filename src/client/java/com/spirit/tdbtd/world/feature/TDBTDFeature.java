package com.spirit.tdbtd.world.feature;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.*;

public abstract class TDBTDFeature<FC extends FeatureConfig> {

    static {
        Feature<DefaultFeatureConfig> SCULK_CAVE_VINES = Registry.register(Registries.FEATURE, "sculk_cave_vines", new TDBTDCaveVinesFeature(DefaultFeatureConfig.CODEC));
        Feature<DefaultFeatureConfig> SCULK_TENVINES = Registry.register(Registries.FEATURE, "sculk_tenvines", new TDBTDSculkTenvinesFeature(DefaultFeatureConfig.CODEC));


    }

        private static <C extends FeatureConfig, F extends Feature<C>>F register (String name, F feature){
            return (F) Registry.register(Registries.FEATURE, (String) name, feature);
        }

        public static void registerFeatures () {
    }
}

