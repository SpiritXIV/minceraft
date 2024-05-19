package com.spirit.ignite.global.block;

import com.spirit.Main;
import com.spirit.ignite.global.block.custom.LandMineBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IgniteBlocks {
    public static final Block LAND_MINE = new LandMineBlock(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).sounds(BlockSoundGroup.STONE).strength(2.0F));

    static Map<String, Object> BLOCKS = Stream.of(new Object[][] {
            {"land_mine", LAND_MINE},
    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));

    public static void registerAll() {
        for (Map.Entry<String, Object> entry : BLOCKS.entrySet()) {
            String key = entry.getKey();
            Block value = (Block) entry.getValue();

            registerBlock(key, value);
        }
    }

    private static void registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Registry.register(Registries.BLOCK, new Identifier(Main.IGNITE_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Main.IGNITE_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static void registerBlockWithoutBlockItem(String name, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(Main.IGNITE_ID, name), block);
    }
}
