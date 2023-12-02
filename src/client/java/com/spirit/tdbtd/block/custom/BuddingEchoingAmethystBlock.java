package com.spirit.tdbtd.block.custom;

import com.spirit.tdbtd.block.TDBTDBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingEchoingAmethystBlock extends EchoingAmethystBlock {
	public static final int GROW_CHANCE = 5;
	private static final Direction[] DIRECTIONS = Direction.values();

	public BuddingEchoingAmethystBlock(AbstractBlock.Settings settings) {
		super(settings);
	}

	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextInt(GROW_CHANCE) == 0) {
			Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
			BlockPos blockPos = pos.offset(direction);
			BlockState blockState = world.getBlockState(blockPos);
			Block block = null;
			if (canGrowIn(blockState)) {
				block = TDBTDBlocks.SMALL_ECHOING_AMETHYST_BUD;
			} else if (blockState.isOf(TDBTDBlocks.SMALL_ECHOING_AMETHYST_BUD) && blockState.get(EchoingAmethystClusterBlock.FACING) == direction) {
				block = TDBTDBlocks.MEDIUM_ECHOING_AMETHYST_BUD;
			} else if ((blockState.isOf(TDBTDBlocks.MEDIUM_ECHOING_AMETHYST_BUD) && blockState.get(EchoingAmethystClusterBlock.FACING) == direction)) {
				block = TDBTDBlocks.LARGE_ECHOING_AMETHYST_BUD;
			} else if (blockState.isOf(TDBTDBlocks.LARGE_ECHOING_AMETHYST_BUD) && blockState.get(EchoingAmethystClusterBlock.FACING) == direction) {
				block = TDBTDBlocks.ECHOING_AMETHYST_CLUSTER;
			}

			if (block != null) {
				BlockState blockState2 = (BlockState)((BlockState)block.getDefaultState().with(EchoingAmethystClusterBlock.FACING, direction)).with(EchoingAmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
				world.setBlockState(blockPos, blockState2);
			}

		}
	}

	public static boolean canGrowIn(BlockState state) {
		return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
	}
}
