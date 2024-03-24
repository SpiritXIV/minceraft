package com.spirit.tdbtd.global.block.custom;

import com.spirit.tdbtd.global.block.TDBTDBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.HashMap;
import java.util.Map;

public class TDBTDGrassBlock extends SpreadableBlock implements Fertilizable {
    private static final Map<Block, Block> DIMENTED_BLOCK_MAP = new HashMap<>();

    static {
        DIMENTED_BLOCK_MAP.put(Blocks.GRASS_BLOCK, TDBTDBlocks.DIMENTED_GRASS_BLOCK);
        DIMENTED_BLOCK_MAP.put(Blocks.DIRT, TDBTDBlocks.DIMENTED_DIRT);
        DIMENTED_BLOCK_MAP.put(Blocks.PODZOL, TDBTDBlocks.DIMENTED_PODZOL);
        DIMENTED_BLOCK_MAP.put(Blocks.COARSE_DIRT, TDBTDBlocks.DIMENTED_COARSE_DIRT);

    }

    public TDBTDGrassBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos offsetPos = pos.offset(direction);
            BlockState offsetState = world.getBlockState(offsetPos);
            Block offsetBlock = DIMENTED_BLOCK_MAP.get(offsetState.getBlock());

            if (offsetBlock != null && world.isAir(offsetPos)) {
                world.setBlockState(offsetPos, offsetBlock.getDefaultState());
            }
        }

        BlockPos upPos = pos.up();
        BlockPos downPos = pos.down();

        BlockState upState = world.getBlockState(upPos);
        BlockState downState = world.getBlockState(downPos);

        Block upBlock = DIMENTED_BLOCK_MAP.get(upState.getBlock());
        Block downBlock = DIMENTED_BLOCK_MAP.get(downState.getBlock());

        if (upBlock != null && world.isAir(upPos)) {
            world.setBlockState(upPos, upBlock.getDefaultState());
        }

        if (downBlock != null && world.isAir(downPos)) {
            world.setBlockState(downPos, downBlock.getDefaultState());
        }
    }
}
