package com.spirit.Mixin;

import com.mojang.serialization.Codec;
import com.spirit.tdbtd.block.TDBTDBlocks;
import net.minecraft.block.*;
import net.minecraft.block.entity.SculkSpreadManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SculkPatchFeature;
import net.minecraft.world.gen.feature.SculkPatchFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Objects;
import java.util.stream.Stream;

@Mixin(SculkPatchFeature.class)
public abstract class SculkPatchFeatureMixin extends Feature<SculkPatchFeatureConfig> {

    public SculkPatchFeatureMixin(Codec<SculkPatchFeatureConfig> codec) {
        super(codec);
    }

    /**
     * @author SpiritXIV
     * @reason To add more blocks to the generation
     */

    @Overwrite
    public boolean generate(FeatureContext<SculkPatchFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        if (!this.canGenerate(structureWorldAccess, blockPos)) {
            return false;
        } else {
            SculkPatchFeatureConfig sculkPatchFeatureConfig = (SculkPatchFeatureConfig) context.getConfig();
            Random random = context.getRandom();
            SculkSpreadManager sculkSpreadManager = SculkSpreadManager.createWorldGen();
            int i = sculkPatchFeatureConfig.spreadRounds() + sculkPatchFeatureConfig.growthRounds();

            int k;
            int l;
            for (int j = 0; j < i; ++j) {
                for (k = 0; k < sculkPatchFeatureConfig.chargeCount(); ++k) {
                    sculkSpreadManager.spread(blockPos, sculkPatchFeatureConfig.amountPerCharge());
                }

                boolean bl = j < sculkPatchFeatureConfig.spreadRounds();

                for (l = 0; l < sculkPatchFeatureConfig.spreadAttempts(); ++l) {
                    sculkSpreadManager.tick(structureWorldAccess, blockPos, random, bl);
                }

                sculkSpreadManager.clearCursors();
            }

            BlockPos blockPos2 = blockPos.down();
            if (random.nextFloat() <= sculkPatchFeatureConfig.catalystChance() && structureWorldAccess.getBlockState(blockPos2).isFullCube(structureWorldAccess, blockPos2)) {
                structureWorldAccess.setBlockState(blockPos, Blocks.SCULK_CATALYST.getDefaultState(), Block.NOTIFY_ALL);
            }

            k = sculkPatchFeatureConfig.extraRareGrowths().get(random);

            for (l = 0; l < k; ++l) {
                BlockPos blockPos3 = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
                if (structureWorldAccess.getBlockState(blockPos3).isAir() && structureWorldAccess.getBlockState(blockPos3.down()).isSideSolidFullSquare(structureWorldAccess, blockPos3.down(), Direction.UP)) {
                    structureWorldAccess.setBlockState(blockPos3, (BlockState) Blocks.SCULK_SHRIEKER.getDefaultState().with(SculkShriekerBlock.CAN_SUMMON, true), Block.NOTIFY_ALL);
                }
            }
        }

        spawnAdditionalSculkBlocks(context);

        return true;
    }

    @Unique
    private void spawnAdditionalSculkBlocks(FeatureContext<SculkPatchFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        SculkPatchFeatureConfig sculkPatchFeatureConfig = context.getConfig();
        Random random = context.getRandom();

        BlockPos addTendril = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addTendril).isAir() && structureWorldAccess.getBlockState(addTendril.down()).isSideSolidFullSquare(structureWorldAccess, addTendril.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addTendril, (BlockState) TDBTDBlocks.SCULK_TENDRIL.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addWeb = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addWeb).isAir() && structureWorldAccess.getBlockState(addWeb.down()).isSideSolidFullSquare(structureWorldAccess, addWeb.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addWeb, (BlockState) TDBTDBlocks.SCULK_WEB.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addGrowth = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addGrowth).isAir() && structureWorldAccess.getBlockState(addGrowth.down()).isSideSolidFullSquare(structureWorldAccess, addGrowth.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addGrowth, (BlockState) TDBTDBlocks.SCULK_GROWTH.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addTenvines = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addTenvines).isAir() && structureWorldAccess.getBlockState(addTenvines.down()).isSideSolidFullSquare(structureWorldAccess, addTenvines.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addTenvines, (BlockState) TDBTDBlocks.SCULK_TENVINES.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addBoneshaft = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addBoneshaft).isAir() && structureWorldAccess.getBlockState(addBoneshaft.down()).isSideSolidFullSquare(structureWorldAccess, addBoneshaft.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addBoneshaft, (BlockState) TDBTDBlocks.SCULK_BONESHAFT.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addFountainShroom = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addFountainShroom).isAir() && structureWorldAccess.getBlockState(addFountainShroom.down()).isSideSolidFullSquare(structureWorldAccess, addFountainShroom.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addFountainShroom, (BlockState) TDBTDBlocks.SCULK_FOUNTAIN_SHROOM.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addShroom = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addShroom).isAir() && structureWorldAccess.getBlockState(addShroom.down()).isSideSolidFullSquare(structureWorldAccess, addShroom.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addShroom, (BlockState) TDBTDBlocks.SCULK_SHROOM.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addSpike = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addSpike).isAir() && structureWorldAccess.getBlockState(addSpike.down()).isSideSolidFullSquare(structureWorldAccess, addSpike.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addSpike, (BlockState) TDBTDBlocks.SCULK_SPIKE.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addTail = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addTail).isAir() && structureWorldAccess.getBlockState(addTail.down()).isSideSolidFullSquare(structureWorldAccess, addTail.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addTail, (BlockState) TDBTDBlocks.SCULK_TAIL.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addTeeth = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addTeeth).isAir() && structureWorldAccess.getBlockState(addTeeth.down()).isSideSolidFullSquare(structureWorldAccess, addTeeth.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addTeeth, (BlockState) TDBTDBlocks.SCULK_TEETH.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addRib = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addRib).isAir() && structureWorldAccess.getBlockState(addRib.down()).isSideSolidFullSquare(structureWorldAccess, addRib.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addRib, (BlockState) TDBTDBlocks.SCULK_RIBS.getDefaultState(), Block.NOTIFY_ALL);
        }

        BlockPos addThorns = blockPos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        if (structureWorldAccess.getBlockState(addThorns).isAir() && structureWorldAccess.getBlockState(addThorns.down()).isSideSolidFullSquare(structureWorldAccess, addThorns.down(), Direction.UP)) {
            structureWorldAccess.setBlockState(addThorns, (BlockState) TDBTDBlocks.SCULK_THORNS.getDefaultState(), Block.NOTIFY_ALL);
        }
    }

    @Unique
    private boolean canGenerate(WorldAccess world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof SculkSpreadable) {
            return true;
        } else if (!blockState.isAir() && (!blockState.isOf(Blocks.WATER) || !blockState.getFluidState().isStill())) {
            return false;
        } else {
            Stream<Direction> var10000 = Direction.stream();
            Objects.requireNonNull(pos);
            return var10000.map(pos::offset).anyMatch((pos2) -> {
                return world.getBlockState(pos2).isFullCube(world, pos2);
            });
        }
    }
}
