package com.spirit.tdbtd.data.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class TDBTDBlockTags {
	public static final TagKey<Block> GRASS_BLOCK = of("grass_block");
	public static final TagKey<Block> DIRT = of("dirt");

	private TDBTDBlockTags() {
	}

	private static TagKey<Block> of(String id) {
		return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
	}
}
