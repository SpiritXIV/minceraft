package com.spirit.shit.datagen;

import com.spirit.shit.item.ShitItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ShitItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ShitItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.SILENT_HOUSES_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.SILENT_HOUSES_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.FREE_BIRD_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.FREE_BIRD_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.AFTER_PARTY_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.AFTER_PARTY_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_AFTERPARTY_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_AFTERPARTY_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_ALLSTAR_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_ALLSTAR_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_BALLIN_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_BALLIN_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_BEGGIN_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_BEGGIN_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_BILLIEJEAN_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_BILLIEJEAN_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_BUDDYHOLLY_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_BUDDYHOLLY_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_CUPID_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_CUPID_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_DONTSTOPMENOW_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_DONTSTOPMENOW_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_FIREFLIES_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_FIREFLIES_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_FLYMETOTHEMOON_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_FLYMETOTHEMOON_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_FNAF_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_FNAF_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_FREEBIRD_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_FREEBIRD_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_GANGSTAPARADISE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_GANGSTAPARADISE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_GOLDENHOUR_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_GOLDENHOUR_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_HARDERBETTER_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_HARDERBETTER_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_HISWORLD_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_HISWORLD_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_HOWBADCANIBE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_HOWBADCANIBE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_LIFECOULDBEDREAMS_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_LIFECOULDBEDREAMS_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_MONSTER_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_MONSTER_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_MYWAY_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_MYWAY_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_OPPENGANGNAMSTYLE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_OPPENGANGNAMSTYLE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_PEACHES_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_PEACHES_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_SCATMANSWORLD_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_SCATMANSWORLD_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_SMOOTHCRIMINAL_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_SMOOTHCRIMINAL_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_SOMEBODYIUSETOKNOW_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_SOMEBODYIUSETOKNOW_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_TAKEONME_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_TAKEONME_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ShitItems.VILLAGER_WHATISLOVE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ShitItems.VILLAGER_WHATISLOVE_MUSIC_DISC);
    }
}