package com.spirit.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.SculkCatalystBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SculkCatalystBlockEntity.class)
public class MixinSculkCatalystBlockEntity {

    @Inject(method = "tick(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/block/entity/SculkCatalystBlockEntity;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/SculkCatalystBlockEntity$Listener;getSpreadManager()Lnet/minecraft/block/entity/SculkSpreadManager;"))
    private static void onTick(World world, BlockPos pos, BlockState state, SculkCatalystBlockEntity blockEntity, CallbackInfo ci) {
        blockEntity.getEventListener().getSpreadManager().spread(pos, 10);
    }
}
