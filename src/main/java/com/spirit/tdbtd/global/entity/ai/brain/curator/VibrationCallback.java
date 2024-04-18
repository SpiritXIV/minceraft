package com.spirit.tdbtd.global.entity.ai.brain.curator;

import com.google.common.annotations.VisibleForTesting;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.spirit.Main;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.WardenAngerManager;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angriness;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.GameEventTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.EntityPositionSource;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.PositionSource;
import net.minecraft.world.event.Vibrations;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class VibrationCallback extends Entity implements Vibrations.Callback {
    private static final int RANGE = 16;
    private static final TrackedData<? extends Object> HEALTH = DataTracker.registerData(VibrationCallback.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<? extends Object> MOB_FLAGS = DataTracker.registerData(VibrationCallback.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<? super Integer> ANGER = DataTracker.registerData(VibrationCallback.class, TrackedDataHandlerRegistry.INTEGER);
    private final PositionSource positionSource = new EntityPositionSource(this, 1.0F);
    private WardenAngerManager angerManager;
    private Brain brain;
    private static Brain staticbrain;
    private Vibrations.ListenerData vibrationListenerData;

    public VibrationCallback(EntityType type, World world) {
        super(type, world);
    }

    public int getRange() {
        return 16;
    }

    public PositionSource getPositionSource() {
        return this.positionSource;
    }

    public TagKey<GameEvent> getTag() {
        return GameEventTags.WARDEN_CAN_LISTEN;
    }

    public boolean triggersAvoidCriterion() {
        return true;
    }

    boolean isDiggingOrEmerging() {
        return this.isInPose(EntityPose.DIGGING) || this.isInPose(EntityPose.EMERGING);
    }

    public boolean accepts(ServerWorld world, BlockPos pos, GameEvent event, GameEvent.Emitter emitter) {
        if (!this.isAiDisabled() && !this.isDead() && !this.getBrain().hasMemoryModule(MemoryModuleType.VIBRATION_COOLDOWN) && !this.isDiggingOrEmerging() && world.getWorldBorder().contains(pos)) {
            Entity var6 = emitter.sourceEntity();
            boolean var10000;
            if (var6 instanceof LivingEntity livingEntity) {
                if (!this.isValidTarget(livingEntity)) {
                    var10000 = false;
                    return var10000;
                }
            }

            var10000 = true;
            return var10000;
        } else {
            return false;
        }
    }

    public boolean isAiDisabled() {
        return ((Byte) this.dataTracker.get(MOB_FLAGS) & 1) != 0;
    }

    public boolean isDead() {
        return this.getHealth() <= 0.0F;
    }

    public float getHealth() {
        return (Float) this.dataTracker.get(HEALTH);
    }

    public Brain<LivingEntity> getBrain() {
        return (Brain<LivingEntity>) brain;
    }

    public static Brain<LivingEntity> getstaticBrain() {
        return (Brain<LivingEntity>) staticbrain;
    }

    public void accept(ServerWorld world, BlockPos pos, GameEvent event, @Nullable Entity sourceEntity, @Nullable Entity entity, float distance) {
        if (!this.isDead()) {
            this.brain.remember(MemoryModuleType.VIBRATION_COOLDOWN, Unit.INSTANCE, 40L);
            world.sendEntityStatus(this, EntityStatuses.EARS_TWITCH);
            this.playSound(SoundEvents.ENTITY_WARDEN_TENDRIL_CLICKS, 5.0F, this.getSoundPitch());
            BlockPos blockPos = pos;
            if (entity != null) {
                if (this.isInRange(entity, 30.0)) {
                    if (this.getBrain().hasMemoryModule(MemoryModuleType.RECENT_PROJECTILE)) {
                        if (this.isValidTarget(entity)) {
                            blockPos = entity.getBlockPos();
                        }

                        this.increaseAngerAt(entity);
                    } else {
                        this.increaseAngerAt(entity, 10, true);
                    }
                }

                this.getBrain().remember(MemoryModuleType.RECENT_PROJECTILE, Unit.INSTANCE, 100L);
            } else {
                this.increaseAngerAt(sourceEntity);
            }

            if (!this.getAngriness().isAngry()) {
                Optional<LivingEntity> optional = this.angerManager.getPrimeSuspect();
                if (entity != null || optional.isEmpty() || optional.get() == sourceEntity) {
                    CuratorBrain.lookAtDisturbance(this, blockPos);
                }
            }

        }
    }

    public float getSoundPitch() {
        return this.isBaby() ? (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.5F : (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F;
    }

    public boolean isBaby() {
        return false;
    }


    private void playListeningSound() {
        if (!this.isInPose(EntityPose.ROARING)) {
            this.playSound(this.getAngriness().getListeningSound(), 10.0F, this.getSoundPitch());
        }

    }

    public Angriness getAngriness() {
        return Angriness.getForAnger(this.getAngerAtTarget());
    }

    private int getAngerAtTarget() {
        return this.angerManager.getAngerFor(this.getTarget());
    }

    public void removeSuspect(Entity entity) {
        this.angerManager.removeSuspect(entity);
    }

    public void increaseAngerAt(@Nullable Entity entity) {
        this.increaseAngerAt(entity, 35, true);
    }

    @VisibleForTesting
    public void increaseAngerAt(@Nullable Entity entity, int amount, boolean listening) {
        if (!this.isAiDisabled() && this.isValidTarget(entity)) {
            CuratorBrain.resetDigCooldown(this);
            boolean bl = !(this.getBrain().getOptionalRegisteredMemory(MemoryModuleType.ATTACK_TARGET).orElse((LivingEntity) null) instanceof PlayerEntity);
            int i = this.angerManager.increaseAngerAt(entity, amount);
            if (entity instanceof PlayerEntity && bl && Angriness.getForAnger(i).isAngry()) {
                this.getBrain().forget(MemoryModuleType.ATTACK_TARGET);
            }

            if (listening) {
                this.playListeningSound();
            }
        }

    }

    public Optional<LivingEntity> getPrimeSuspect() {
        return this.getAngriness().isAngry() ? this.angerManager.getPrimeSuspect() : Optional.empty();
    }

    @Nullable
    public LivingEntity getTarget() {
        return (LivingEntity) this.getBrain().getOptionalRegisteredMemory(MemoryModuleType.ATTACK_TARGET).orElse((LivingEntity) null);
    }

    @Nullable
    public static LivingEntity getstaticTarget() {
        return (LivingEntity) VibrationCallback.getstaticBrain().getOptionalRegisteredMemory(MemoryModuleType.ATTACK_TARGET).orElse((LivingEntity) null);
    }

    @Contract("null->false")
    public boolean isValidTarget(@Nullable Entity entity) {
        boolean var10000;
        if (entity instanceof LivingEntity livingEntity) {
            if (this.getWorld() == entity.getWorld() && EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity) && !this.isTeammate(entity) && livingEntity.getType() != EntityType.ARMOR_STAND && livingEntity.getType() != EntityType.WARDEN && !livingEntity.isInvulnerable() && !livingEntity.isDead() && this.getWorld().getWorldBorder().contains(livingEntity.getBoundingBox())) {
                var10000 = true;
                return var10000;
            }
        }

        var10000 = false;
        return var10000;
    }


    @Override
    protected void initDataTracker() {

    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        DataResult<NbtElement> var10000 = WardenAngerManager.createCodec(this::isValidTarget).encodeStart(NbtOps.INSTANCE, this.angerManager);
        Logger var10001 = (Logger) Main.LOGGER;
        Objects.requireNonNull(var10001);
        var10000.resultOrPartial(var10001::error).ifPresent((angerNbt) -> {
            nbt.put("anger", angerNbt);
        });
        var10000 = Vibrations.ListenerData.CODEC.encodeStart(NbtOps.INSTANCE, this.vibrationListenerData);
        var10001 = (Logger) Main.LOGGER;
        Objects.requireNonNull(var10001);
        var10000.resultOrPartial(var10001::error).ifPresent((listenerData) -> {
            nbt.put("listener", listenerData);
        });
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        DataResult var10000;
        Logger var10001 = (Logger) Main.LOGGER;
        if (nbt.contains("anger")) {
            var10000 = WardenAngerManager.createCodec(this::isValidTarget).parse(new Dynamic(NbtOps.INSTANCE, nbt.get("anger")));
            Objects.requireNonNull(var10001);
            var10000.resultOrPartial((Consumer<String>) error -> var10001.error(error)).ifPresent(angerManager -> {
                this.angerManager = (WardenAngerManager) angerManager;
            });
            this.updateAnger();
        }

        if (nbt.contains("listener", NbtElement.COMPOUND_TYPE)) {
            var10000 = Vibrations.ListenerData.CODEC.parse(new Dynamic(NbtOps.INSTANCE, nbt.getCompound("listener")));
            Objects.requireNonNull(var10001);
            var10000.resultOrPartial((Consumer<String>) error -> var10001.error(error)).ifPresent(listenerData -> {
                this.vibrationListenerData = (Vibrations.ListenerData) listenerData;
            });
        }
    }


    private void updateAnger() {
        this.dataTracker.set(ANGER, this.getAngerAtTarget());
    }
}
