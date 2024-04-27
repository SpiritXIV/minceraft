package com.spirit.shit.data.datagen;

import com.spirit.shit.global.block.ShitBlocks;
import com.spirit.shit.global.item.ShitItems;
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
        addDrop(ShitBlocks.CRACKLIN_BOX);
        addDrop(ShitBlocks.GAS_CAN);
        addDrop(ShitBlocks.GAS_CANISTER);
        addDrop(ShitBlocks.TOILET);
        addDrop(ShitBlocks.WORLD_BOMB);
        addDrop(ShitBlocks.MODEM);
        addDrop(ShitBlocks.COMPUTER_MOUSE);
        addDrop(ShitBlocks.OLD_COMPUTER);
        addDrop(ShitBlocks.RADIO);

        //POSTER
        addDrop(ShitBlocks.ULTRAKILL_POSTER);
        
        
        // BACKROOMS LEVEL 0
        addDrop(ShitBlocks.BACKROOMS_LIGHT);
        addDrop(ShitBlocks.BACKROOMS_LIGHT_OFF);
        addDrop(ShitBlocks.BACKROOMS_FLOOR);
        addDrop(ShitBlocks.BACKROOMS_FLOOR_TELEPORT);
        addDrop(ShitBlocks.BACKROOMS_WALLPAPER);
        addDrop(ShitBlocks.BACKROOMS_WALLPAPER_LIP);
        addDrop(ShitBlocks.BACKROOMS_CEILING);
        addDrop(ShitBlocks.BACKROOMS_CEILING_VENT);

        // BACKROOMS LEVEL 1
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_FLOOR);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_WALLS);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_WALLS_TUBES);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_TOP_OFF);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_WALL_PILLAR_LIGHT_BOTTOM_OFF);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_WALLS_PAINTED);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_CEILING);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_CEILING_PAINTED);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT);
        addDrop(ShitBlocks.BACKROOMS_CONCRETE_CEILING_PAINTED_LIGHT_OFF);

        // BACKROOMS LEVEL 2
        addDrop(ShitBlocks.BACKROOMS_PIPE_LARGE);
        addDrop(ShitBlocks.BACKROOMS_PIPE_SMALL);
        addDrop(ShitBlocks.BACKROOMS_WETTED_CONCRETE_FLOOR);
        addDrop(ShitBlocks.BACKROOMS_WETTED_CONCRETE_WALL);
        addDrop(ShitBlocks.BACKROOMS_WETTED_CONCRETE_CEILING);
        addDrop(ShitBlocks.BACKROOMS_INDUSTRIAL_LIGHT);
        addDrop(ShitBlocks.BACKROOMS_INDUSTRIAL_LIGHT_SHATTERED);

        //PLUSHES
        addDrop(ShitBlocks.ALPHA_PLUSH);
        addDrop(ShitBlocks.CATLOVE_PLUSH);
        addDrop(ShitBlocks.CHEFINSANITY_PLUSH);
        addDrop(ShitBlocks.COMPUTER_PLUSH);
        addDrop(ShitBlocks.ERIS_PLUSH);
        addDrop(ShitBlocks.JARGEDES_PLUSH);
        addDrop(ShitBlocks.JBIRD_PLUSH);
        addDrop(ShitBlocks.KINGZHARA_PLUSH);
        addDrop(ShitBlocks.MCFELLA_PLUSH);
        addDrop(ShitBlocks.MILKYFUR_PLUSH);
        addDrop(ShitBlocks.SIERRA_PLUSH);
        addDrop(ShitBlocks.SLAZER_PLUSH);
        addDrop(ShitBlocks.SPIRIT_PLUSH);

        //WARZONE
        addDrop(ShitBlocks.LAND_MINE);

        // OTHER BLOCKS
        addDrop(ShitBlocks.CUBE_BLUE);
        addDrop(ShitBlocks.CUBE_GRAY);
        addDrop(ShitBlocks.CUBE_GREEN);
        addDrop(ShitBlocks.CUBE_LIGHTBLUE);
        addDrop(ShitBlocks.CUBE_ORANGE);
        addDrop(ShitBlocks.CUBE_PEACH);
        addDrop(ShitBlocks.CUBE_PINK);
        addDrop(ShitBlocks.CUBE_PURPLE);
        addDrop(ShitBlocks.CUBE_RED);
        addDrop(ShitBlocks.CUBE_RUSTY);
        addDrop(ShitBlocks.CUBE_WHITE);
        addDrop(ShitBlocks.CUBE_YELLOW);



        //ORES
        addDrop(ShitBlocks.BAUXITE_ORE, enchantedLikeOreDrops(ShitBlocks.BAUXITE_ORE, ShitItems.RAW_BAUXITE));
        addDrop(ShitBlocks.DEEPSLATE_BAUXITE_ORE, enchantedLikeOreDrops(ShitBlocks.DEEPSLATE_BAUXITE_ORE, ShitItems.RAW_BAUXITE));

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