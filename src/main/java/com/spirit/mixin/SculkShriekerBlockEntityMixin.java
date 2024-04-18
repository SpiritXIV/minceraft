package com.spirit.mixin;

import net.minecraft.block.SculkShriekerBlock;
import net.minecraft.block.entity.SculkShriekerBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LargeEntitySpawnHelper;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("unused")
@Mixin(SculkShriekerBlockEntity.class)
public abstract class SculkShriekerBlockEntityMixin {

    @Unique
    private int warningLevel;
    @Inject(method = "shriek*", at = @At("HEAD"))
    private void onShriek(ServerWorld world, Entity entity) {
        BlockPos pos = ((SculkShriekerBlockEntity) (Object) this).getPos();
        world.setBlockState(pos, world.getBlockState(pos).with(SculkShriekerBlock.SHRIEKING, true), 0);
        world.syncWorldEvent(WorldEvents.SCULK_SHRIEKS, pos, 0);
        world.emitGameEvent(GameEvent.SHRIEK, pos, GameEvent.Emitter.of(entity));
    }

    @Inject(method = "canWarn", at = @At("HEAD"), cancellable = true)
    private void onCanWarn(ServerWorld world, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(!world.getDifficulty().equals(Difficulty.PEACEFUL));
    }

    @Unique
    private boolean trySpawnWarden(ServerWorld world, BlockPos pos) {
        Difficulty difficulty = world.getDifficulty();
        int strikesAllowed = switch (difficulty) {
            case EASY -> 3;
            case NORMAL -> 2;
            case HARD -> 1;
            default -> 0;
        };

        return this.warningLevel >= 4 && 1 <= strikesAllowed &&
                LargeEntitySpawnHelper.trySpawnAt(EntityType.WARDEN, SpawnReason.TRIGGERED, world, pos, 20, 5, 6, LargeEntitySpawnHelper.Requirements.WARDEN).isEmpty();
    }

    @Inject(method = "warn", at = @At("HEAD"))
    private void onWarn(ServerWorld world, CallbackInfo ci) {
        Difficulty difficulty = world.getDifficulty();
        int RANGE = switch (difficulty) {
            case EASY -> 35;
            case NORMAL -> 60;
            case HARD -> 80;
            default -> 40;
        };
        WardenEntity.addDarknessToClosePlayers(world, Vec3d.ofCenter(((SculkShriekerBlockEntity) (Object) this).getPos()), null, RANGE);

    }
}
