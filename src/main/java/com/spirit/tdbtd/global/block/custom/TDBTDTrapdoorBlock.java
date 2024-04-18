package com.spirit.tdbtd.global.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.Direction;

public class TDBTDTrapdoorBlock extends TrapdoorBlock {
    private final BlockSetType blockSetType;

    public TDBTDTrapdoorBlock(AbstractBlock.Settings settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.blockSetType = blockSetType;
        this.setDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(OPEN, false)).with(HALF, BlockHalf.BOTTOM)).with(POWERED, false)).with(WATERLOGGED, false));
    }
}