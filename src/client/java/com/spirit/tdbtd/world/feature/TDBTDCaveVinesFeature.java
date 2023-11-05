package com.spirit.tdbtd.world.feature;

import com.mojang.serialization.Codec;
import com.spirit.tdbtd.block.TDBTDBlocks;
import com.spirit.tdbtd.block.custom.TDBTDCaveVinesBodyBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class TDBTDCaveVinesFeature extends Feature<DefaultFeatureConfig> {
    public TDBTDCaveVinesFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        context.getConfig();
        if (!structureWorldAccess.isAir(blockPos)) {
            return false;
        }
        for (Direction direction : Direction.values()) {
            if (direction == Direction.UP || !VineBlock.shouldConnectTo(structureWorldAccess, blockPos.up(), direction)) continue;
            structureWorldAccess.setBlockState(blockPos, (BlockState) TDBTDBlocks.CRITERIC_VINES_HEAD.getDefaultState().with(TDBTDCaveVinesBodyBlock.BERRIES, false), Block.NOTIFY_LISTENERS);
            return true;
        }
        return false;
    }
}
