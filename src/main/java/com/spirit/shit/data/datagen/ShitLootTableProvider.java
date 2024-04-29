package com.spirit.shit.data.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ShitLootTableProvider extends FabricBlockLootTableProvider {
    public ShitLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

    }
        public LootTable.Builder enchantedLikeOreDrops(Block drop, Item item) {
            return BlockLootTableGenerator.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop,
                    ((LeafEntry.Builder<?>)
                            ItemEntry.builder(item)
                                    .apply(SetCountLootFunction
                                            .builder(UniformLootNumberProvider
                                                    .create(2.0f, 5.0f))))
                            .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));

    }
}