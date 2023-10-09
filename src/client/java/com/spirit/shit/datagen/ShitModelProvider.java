package com.spirit.shit.datagen;

import com.spirit.shit.item.ShitItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ShitModelProvider extends FabricModelProvider {
    public ShitModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ShitItems.SILENT_HOUSES_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.FREE_BIRD_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.AFTER_PARTY_MUSIC_DISC, Models.GENERATED);
        
        itemModelGenerator.register(ShitItems.VILLAGER_AFTERPARTY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_ALLSTAR_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_BALLIN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_BEGGIN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_BILLIEJEAN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_BUDDYHOLLY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_CUPID_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_DONTSTOPMENOW_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_FIREFLIES_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_FLYMETOTHEMOON_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_FNAF_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_FREEBIRD_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_GANGSTAPARADISE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_GOLDENHOUR_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_HARDERBETTER_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_HISWORLD_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_HOWBADCANIBE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_LIFECOULDBEDREAMS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_MONSTER_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_MYWAY_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_OPPENGANGNAMSTYLE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_PEACHES_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_SCATMANSWORLD_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_SMOOTHCRIMINAL_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_SOMEBODYIUSETOKNOW_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_TAKEONME_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ShitItems.VILLAGER_WHATISLOVE_MUSIC_DISC, Models.GENERATED);
    }
}