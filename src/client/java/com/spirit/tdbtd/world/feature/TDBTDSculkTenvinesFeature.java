package com.spirit.tdbtd.world.feature;

import com.mojang.serialization.Codec;
import com.spirit.tdbtd.block.TDBTDBlocks;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class TDBTDSculkTenvinesFeature extends Feature<DefaultFeatureConfig> {
	private static final Direction[] DIRECTIONS = Direction.values();

	public TDBTDSculkTenvinesFeature(Codec<DefaultFeatureConfig> codec) {
		super(codec);
	}

	public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
		StructureWorldAccess structureWorldAccess = context.getWorld();
		BlockPos blockPos = context.getOrigin();
		Random random = context.getRandom();
		if (!structureWorldAccess.isAir(blockPos)) {
			return false;
		} else {
			BlockState blockState = structureWorldAccess.getBlockState(blockPos.up());
			if (!blockState.isOf(Blocks.SCULK) && !blockState.isOf(Blocks.SCULK)) {
				return false;
			} else {
				this.generateBlocksInArea(structureWorldAccess, random, blockPos);
				this.generateVinesInArea(structureWorldAccess, random, blockPos);
				return true;
			}
		}
	}

	private void generateBlocksInArea(WorldAccess world, Random random, BlockPos pos) {
		world.setBlockState(pos, Blocks.SCULK.getDefaultState(), Block.NOTIFY_LISTENERS);
		BlockPos.Mutable mutable = new BlockPos.Mutable();
		BlockPos.Mutable mutable2 = new BlockPos.Mutable();

		for(int i = 0; i < 200; ++i) {
			mutable.set((Vec3i)pos, random.nextInt(6) - random.nextInt(6), random.nextInt(2) - random.nextInt(5), random.nextInt(6) - random.nextInt(6));
			if (world.isAir(mutable)) {
				int j = 0;
				Direction[] var8 = DIRECTIONS;
				int var9 = var8.length;

				for(int var10 = 0; var10 < var9; ++var10) {
					Direction direction = var8[var10];
					BlockState blockState = world.getBlockState(mutable2.set(mutable, (Direction)direction));
					if (blockState.isOf(Blocks.SCULK) || blockState.isOf(Blocks.SCULK)) {
						++j;
					}

					if (j > 1) {
						break;
					}
				}

				if (j == 1) {
					world.setBlockState(mutable, Blocks.SCULK.getDefaultState(), Block.NOTIFY_LISTENERS);
				}
			}
		}

	}

	private void generateVinesInArea(WorldAccess world, Random random, BlockPos pos) {
		BlockPos.Mutable mutable = new BlockPos.Mutable();

		for(int i = 0; i < 100; ++i) {
			mutable.set((Vec3i)pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
			if (world.isAir(mutable)) {
				BlockState blockState = world.getBlockState(mutable.up());
				if (blockState.isOf(Blocks.SCULK) || blockState.isOf(Blocks.SCULK)) {
					int j = MathHelper.nextInt(random, 1, 8);
					if (random.nextInt(6) == 0) {
						j *= 2;
					}

					if (random.nextInt(5) == 0) {
						j = 1;
					}

					boolean k = true;
					boolean l = true;
					generateVineColumn(world, random, mutable, j, 17, 25);
				}
			}
		}

	}

	public static void generateVineColumn(WorldAccess world, Random random, BlockPos.Mutable pos, int length, int minAge, int maxAge) {
		for(int i = 0; i <= length; ++i) {
			if (world.isAir(pos)) {
				if (i == length || !world.isAir(pos.down())) {
					world.setBlockState(pos, (BlockState) TDBTDBlocks.SCULK_TENVINES_PLANT.getDefaultState().with(AbstractPlantStemBlock.AGE, MathHelper.nextInt(random, minAge, maxAge)), Block.NOTIFY_LISTENERS);
					break;
				}

				world.setBlockState(pos, TDBTDBlocks.SCULK_TENVINES.getDefaultState(), Block.NOTIFY_LISTENERS);
			}

			pos.move(Direction.UP);
		}

	}
}