package com.spirit.tdbtd.util;

import com.spirit.tdbtd.block.TDBTDBlocks;
import com.spirit.tdbtd.item.TDBTDItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class TDBTDLootTableModifiers {
    private static final Identifier ANCIENT_CITY_ID =
            new Identifier("minecraft", "chests/ancient_city");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(TDBTDBlocks.INFURTRINATED_DEEPSLATE))
                        .with(ItemEntry.builder(TDBTDBlocks.INFURTRINATED_DEEPSLATE_BRICKS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f)) // Drops 50% of the time
                        .with(ItemEntry.builder(TDBTDItems.INFURTRINATED_FRAGMENT))
                        .with(ItemEntry.builder(TDBTDBlocks.CRITERIC_CHARRED_SAPLING))
                        .with(ItemEntry.builder(TDBTDBlocks.INFURTRINATED_DEEPSLATE))
                        .with(ItemEntry.builder(TDBTDBlocks.INFURTRINATED_DEEPSLATE_BRICKS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f)) // Drops 25% of the time
                        .with(ItemEntry.builder(TDBTDItems.INFURTRINATED_INGOT))
                        .with(ItemEntry.builder(TDBTDItems.DIMENTEDPETAL))
                        .with(ItemEntry.builder(TDBTDItems.DIMENTEDSTEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f)) // Drops 10% of the time
                        .with(ItemEntry.builder(TDBTDItems.DIMENTEDPETALALLOY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(TDBTDItems.DIMENTEDFLOWER))
                        .with(ItemEntry.builder(TDBTDItems.DIMENTEDBOOTS))
                        .with(ItemEntry.builder(TDBTDItems.DIMENTEDCHESTPLATE))
                        .with(ItemEntry.builder(TDBTDItems.DIMENTEDLEGGINGS))
                        .with(ItemEntry.builder(TDBTDItems.DIMENTEDHELMET))
                        .with(ItemEntry.builder(TDBTDItems.DIMENTED_SWORD))
                        .with(ItemEntry.builder(TDBTDItems.DIMENTED_HOE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}