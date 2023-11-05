package com.spirit.tdbtd.block.custom;

import com.spirit.tdbtd.block.TDBTDBlocks;
import com.spirit.tdbtd.item.TDBTDItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class TDBTDCaveVinesBodyBlock
            extends AbstractPlantBlock
            implements Fertilizable,
            CaveVines {
        public TDBTDCaveVinesBodyBlock(Settings settings) {
            super(settings, Direction.DOWN, SHAPE, false);
            this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BERRIES, false));
        }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) TDBTDBlocks.CRITERIC_VINES_HEAD;
    }

    @Override
    protected BlockState copyState(BlockState from, BlockState to) {
        return (BlockState)to.with(BERRIES, from.get(BERRIES));
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(TDBTDItems.GLOW_BERRY);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BERRIES);
    }


    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, (BlockState)state.with(BERRIES, true), Block.NOTIFY_LISTENERS);
    }
}

