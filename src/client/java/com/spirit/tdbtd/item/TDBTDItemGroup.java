package com.spirit.tdbtd.item;

import com.spirit.Main;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TDBTDItemGroup {
    public static final ItemGroup TDBTD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.TDBTD_ID, "tdbtd_item_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.tdbtditem"))
                    .icon(() -> new ItemStack(TDBTDItems.DIMENTEDHELMET))
                    .entries((displayContext, entries) -> {
                        entries.add(TDBTDItems.INFURTRINATED_FRAGMENT);
                        entries.add(TDBTDItems.INFURTRINATED_INGOT);
                        entries.add(TDBTDItems.DIMENTEDSTEM);
                        entries.add(TDBTDItems.DIMENTEDPETAL);
                        entries.add(TDBTDItems.DIMENTEDPETALALLOY);
                        entries.add(TDBTDItems.DIMENTEDFLOWER);
                        entries.add(TDBTDItems.SOUL_ESSENCE);
                        entries.add(TDBTDItems.LOST_SOUL);
                        entries.add(TDBTDItems.DIMENTEDHELMET);
                        entries.add(TDBTDItems.DIMENTEDCHESTPLATE);
                        entries.add(TDBTDItems.DIMENTEDLEGGINGS);
                        entries.add(TDBTDItems.DIMENTEDBOOTS);
                        entries.add(TDBTDItems.DIMENTED_SWORD);
                        entries.add(TDBTDItems.DIMENTED_PICKAXE);
                        entries.add(TDBTDItems.DIMENTED_AXE);
                        entries.add(TDBTDItems.DIMENTED_SHOVEL);
                        entries.add(TDBTDItems.DIMENTED_HOE);
                        entries.add(TDBTDItems.DIMENTEDSCYTHE);
                        entries.add(TDBTDItems.SCULKBOW);
                        entries.add(TDBTDItems.DIMENTEDSERPENT);
                        entries.add(TDBTDItems.DIMENTEDTHORN);
                        entries.add(TDBTDItems.SOULSHRIEKER);
                        entries.add(TDBTDItems.SHRIEKER_MUSIC_DISC);
                        entries.add(TDBTDItems.THE_WARDEN_MUSIC_DISC);
                        entries.add(TDBTDItems.WARDEN_RUN_MUSIC_DISC);
                        entries.add(TDBTDItems.TENEBROUS_NIBBLER_SPAWN_EGG);
                        entries.add(TDBTDItems.APERTURENTEETH_SPAWN_EGG);
                        entries.add(TDBTDItems.CODELAING_SPAWN_EGG);
                        entries.add(TDBTDItems.PERICARPIUM_SPAWN_EGG);
                        entries.add(TDBTDItems.SCUTLEON_SPAWN_EGG);
                        entries.add(TDBTDItems.NIDIVER_SPAWN_EGG);
                        entries.add(TDBTDItems.CURATOR_SPAWN_EGG);
                        entries.add(TDBTDItems.MIJAPENDRA_SPAWN_EGG);
                        entries.add(TDBTDItems.CONTRIVANCEPOLLOONE_SPAWN_EGG);
                        entries.add(TDBTDItems.CONTRIVANCEPOLLA_SPAWN_EGG);
                        entries.add(TDBTDItems.ABYSSOFIN_SPAWN_EGG);
                        entries.add(TDBTDItems.STURGO_SPAWN_EGG);
                        entries.add(TDBTDItems.ENGUIA_SPAWN_EGG);
                        entries.add(TDBTDItems.MALDININKAS_SPAWN_EGG);
                        entries.add(TDBTDItems.DEVASTADOR_HOUND_SPAWNEGG);
                        entries.add(TDBTDItems.DEVASTADOR_CUR_SPAWN_EGG);
                        entries.add(TDBTDItems.DEVASTADOR_PUP_SPAWN_EGG);
                        entries.add(TDBTDItems.KREDA_SPAWN_EGG);
                    }).build());

    public static final ItemGroup TDBTD_FOOD_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.TDBTD_ID, "tdbtd_food_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.tdbtdfood"))
                    .icon(() -> new ItemStack(TDBTDItems.APPLE))
                    .entries((displayContext, entries) -> {
                        entries.add(TDBTDItems.APPLE);
                        entries.add(TDBTDItems.BAKED_POTATO);
                        entries.add(TDBTDItems.BEEF);
                        entries.add(TDBTDItems.BEETROOT);
                        entries.add(TDBTDItems.BREAD);
                        entries.add(TDBTDItems.CARROT);
                        entries.add(TDBTDItems.GLOW_BERRY);
                        entries.add(TDBTDItems.CHICKEN);
                        entries.add(TDBTDItems.COD);
                        entries.add(TDBTDItems.MUTTON);
                        entries.add(TDBTDItems.PORKCHOP);
                        entries.add(TDBTDItems.RABBIT);
                        entries.add(TDBTDItems.SALMON);
                        entries.add(TDBTDItems.TROPICAL_FISH);
                        entries.add(TDBTDItems.COOKED_BEEF);
                        entries.add(TDBTDItems.COOKED_CHICKEN);
                        entries.add(TDBTDItems.COOKED_COD);
                        entries.add(TDBTDItems.COOKED_MUTTON);
                        entries.add(TDBTDItems.COOKED_PORKCHOP);
                        entries.add(TDBTDItems.COOKED_RABBIT);
                        entries.add(TDBTDItems.COOKED_SALMON);
                        entries.add(TDBTDItems.PUFFERFISH);
                        entries.add(TDBTDItems.COOKIE);
                        entries.add(TDBTDItems.PUMPKIN_PIE);
                        entries.add(TDBTDItems.DRIED_KELP);
                        entries.add(TDBTDItems.ENCHANTED_GOLDEN_APPLE);
                        entries.add(TDBTDItems.GOLDEN_APPLE);
                        entries.add(TDBTDItems.GOLDEN_CARROT);
                        entries.add(TDBTDItems.MELON_SLICE);
                        entries.add(TDBTDItems.POISONOUS_POTATO);
                        entries.add(TDBTDItems.POTATO);
                        entries.add(TDBTDItems.ROTTEN_FLESH);
                        entries.add(TDBTDItems.SPIDER_EYE);
                    }).build());

    public static void register() {}
}

