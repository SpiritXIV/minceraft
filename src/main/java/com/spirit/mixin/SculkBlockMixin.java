package com.spirit.mixin;

import com.spirit.tdbtd.global.block.TDBTDBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SculkBlock;
import net.minecraft.block.SculkShriekerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(SculkBlock.class)
public class SculkBlockMixin {

    @Inject(method = "getExtraBlockState", at = @At("HEAD"), cancellable = true)
    private void modifyGetExtraBlockState(WorldAccess world, BlockPos pos, Random random, boolean allowShrieker, CallbackInfoReturnable<BlockState> info) {
        // Your custom logic to add blocks here
        if (random.nextInt(11) == 0) {
            BlockState customBlockState = Blocks.SCULK_CATALYST.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(1) == 0) {
            BlockState customBlockState = Blocks.SCULK_SHRIEKER.getDefaultState().with(SculkShriekerBlock.CAN_SUMMON, true);
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(1) == 0) {
            BlockState customBlockState = Blocks.SCULK_SENSOR.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(10) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_SHAKER.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_TENDRIL.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState =  TDBTDBlocks.SCULK_FOUNTAIN_SHROOM.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_SHROOM.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_WEB.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_GROWTH.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_RIBS.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_THORNS.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_TEETH.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_SPIKE.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_BONESHAFT.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_TENVINES.getDefaultState();
            info.setReturnValue(customBlockState);
        }
        if (random.nextInt(5) == 0) {
            BlockState customBlockState = TDBTDBlocks.SCULK_BUD.getDefaultState();
            info.setReturnValue(customBlockState);
        }
    }
}