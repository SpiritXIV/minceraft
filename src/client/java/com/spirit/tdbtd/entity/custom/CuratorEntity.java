package com.spirit.tdbtd.entity.custom;

import com.mojang.serialization.Dynamic;
import com.spirit.tdbtd.entity.ai.brain.curator.CuratorBrain;
import com.spirit.tdbtd.entity.ai.brain.curator.VibrationCallback;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.WardenAngerManager;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.task.SonicBoomTask;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.Angriness;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.server.network.DebugInfoSender;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.Vibrations;
import net.minecraft.world.event.listener.EntityGameEventHandler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Objects;
import java.util.function.BiConsumer;

public class CuratorEntity extends HostileEntity implements Vibrations {
    public final AnimationState idleAnimationState = new AnimationState();
    public AnimationState roaringAnimationState = new AnimationState();
    public AnimationState sniffingAnimationState = new AnimationState();
    public AnimationState emergingAnimationState = new AnimationState();
    public AnimationState diggingAnimationState = new AnimationState();
    public AnimationState attackingAnimationState = new AnimationState();
    public AnimationState chargingSonicBoomAnimationState = new AnimationState();
    private int tendrilPitch;
    private int lastTendrilPitch;
    private int heartbeatCooldown;
    private int lastHeartbeatCooldown;
    private int idleAnimationTimeout = 0;
    private final WardenAngerManager angerManager = new WardenAngerManager(this::isValidTarget, Collections.emptyList());
    private static final WardenAngerManager angerstaticManager = new WardenAngerManager(CuratorEntity::isstaticValidTarget, Collections.emptyList());

    @Contract("null->false")
    public boolean isValidTarget(@Nullable Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            return this.getWorld() == entity.getWorld() && EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity) && !this.isTeammate(entity) && livingEntity.getType() != EntityType.ARMOR_STAND && livingEntity.getType() != EntityType.WARDEN && !livingEntity.isInvulnerable() && !livingEntity.isDead() && this.getWorld().getWorldBorder().contains(livingEntity.getBoundingBox());
        }

        return false;
    }

    public static World getstaticWorld() {
        return CuratorEntity.getstaticWorld();
    }

    public static boolean isstaticTeammate(Entity other) {
        return CuratorEntity.isstaticTeamPlayer(other.getScoreboardTeam());
    }

    public static boolean isstaticTeamPlayer(AbstractTeam team) {
        return CuratorEntity.getstaticScoreboardTeam() != null && Objects.requireNonNull(CuratorEntity.getstaticScoreboardTeam()).isEqual(team);
    }

    @Nullable
    public static AbstractTeam getstaticScoreboardTeam() {
        assert CuratorEntity.getstaticTarget() != null;
        return CuratorEntity.getstaticWorld().getScoreboard().getPlayerTeam(CuratorEntity.getstaticTarget().getEntityName());
    }

    @Contract("null->false")
    public static boolean isstaticValidTarget(@Nullable Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            return CuratorEntity.getstaticWorld() == entity.getWorld() && EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity) && !CuratorEntity.isstaticTeammate(entity) && livingEntity.getType() != EntityType.ARMOR_STAND && livingEntity.getType() != EntityType.WARDEN && !livingEntity.isInvulnerable() && !livingEntity.isDead() && CuratorEntity.getstaticWorld().getWorldBorder().contains(livingEntity.getBoundingBox());
        }

        return false;
    }

    private static final TrackedData<Integer> ANGER = DataTracker.registerData(CuratorEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private final EntityGameEventHandler<Vibrations.VibrationListener> gameEventHandler = new EntityGameEventHandler<>(new Vibrations.VibrationListener(this));
    private final Vibrations.Callback vibrationCallback = new VibrationCallback(this.getType(), this.getWorld());
    private final Vibrations.ListenerData vibrationListenerData = new Vibrations.ListenerData();

    protected CuratorEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
        this.getNavigation().setCanSwim(true);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_OTHER, 8.0F);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, 8.0F);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0F);
        this.moveControl = new AquaticMoveControl(this, 85, 10, 0.02f, 0.1f, true);
        this.lookControl = new YawAdjustingLookControl(this, 10);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this, this.isInPose(EntityPose.EMERGING) ? 1 : 0);
    }

    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        if (packet.getEntityData() == 1) {
            this.setPose(EntityPose.EMERGING);
        }

    }

    public boolean canSpawn(WorldView world) {
        return super.canSpawn(world) && world.isSpaceEmpty(this, this.getType().getDimensions().getBoxAt(this.getPos()));
    }

    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return 0.0F;
    }

    public boolean isInvulnerableTo(DamageSource damageSource) {
        return this.isDiggingOrEmerging() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) || super.isInvulnerableTo(damageSource);
    }

    boolean isDiggingOrEmerging() {
        return this.isInPose(EntityPose.DIGGING) || this.isInPose(EntityPose.EMERGING);
    }

    protected boolean canStartRiding(Entity entity) {
        return false;
    }

    public boolean disablesShield() {
        return true;
    }

    protected float calculateNextStepSoundDistance() {
        return this.distanceTraveled + 0.55F;
    }

    public static DefaultAttributeContainer.Builder addAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.5).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 30.0);
    }

    public boolean occludeVibrationSignals() {
        return true;
    }

    protected float getSoundVolume() {
        return 4.0F;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return !this.isInPose(EntityPose.ROARING) && !this.isDiggingOrEmerging() ? this.getAngriness().getSound() : null;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WARDEN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WARDEN_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_WARDEN_STEP, 10.0F, 1.0F);
    }

    public boolean tryAttack(Entity target) {
        this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_ATTACK_SOUND);
        this.playSound(SoundEvents.ENTITY_WARDEN_ATTACK_IMPACT, 10.0F, this.getSoundPitch());
        SonicBoomTask.cooldown(this, 40);
        return super.tryAttack(target);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ANGER, 0);
    }

    public int getAnger() {
        return (Integer) this.dataTracker.get(ANGER);
    }

    private void updateAnger() {
        this.dataTracker.set(ANGER, this.getAngerAtTarget());
    }

    public void tick() {
        World var2 = this.getWorld();
        if (var2 instanceof ServerWorld serverWorld) {
            Vibrations.Ticker.tick(serverWorld, this.vibrationListenerData, this.vibrationCallback);
            if (this.isPersistent() || this.cannotDespawn()) {
                CuratorBrain.resetDigCooldownOne(this);
            }
        }

        super.tick();
        if (this.getWorld().isClient()) {
            if (this.age % this.getHeartRate() == 0) {
                this.heartbeatCooldown = 10;
                if (!this.isSilent()) {
                    this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_WARDEN_HEARTBEAT, this.getSoundCategory(), 5.0F, this.getSoundPitch(), false);
                }
            }

            this.lastTendrilPitch = this.tendrilPitch;
            if (this.tendrilPitch > 0) {
                --this.tendrilPitch;
            }

            this.lastHeartbeatCooldown = this.heartbeatCooldown;
            if (this.heartbeatCooldown > 0) {
                --this.heartbeatCooldown;
            }

            switch (this.getPose()) {
                case EMERGING:
                    this.addDigParticles(this.emergingAnimationState);
                    break;
                case DIGGING:
                    this.addDigParticles(this.diggingAnimationState);
            }
        }

    }

    protected void mobTick() {
        ServerWorld serverWorld = (ServerWorld)this.getWorld();
        serverWorld.getProfiler().push("curatorBrain");
        this.getBrain().tick(serverWorld, this);
        this.getWorld().getProfiler().pop();
        super.mobTick();
        if ((this.age + this.getId()) % 120 == 0) {
            addDarknessToClosePlayers(serverWorld, this.getPos(), this, 20);
        }

        if (this.age % 20 == 0) {
            this.angerManager.tick(serverWorld, this::isValidTarget);
            this.updateAnger();
        }

        CuratorBrain.updateActivities(this);
    }

    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_ATTACK_SOUND) {
            this.roaringAnimationState.stop();
            this.attackingAnimationState.start(this.age);
        } else if (status == EntityStatuses.EARS_TWITCH) {
            this.tendrilPitch = 10;
        } else if (status == EntityStatuses.SONIC_BOOM) {
            this.chargingSonicBoomAnimationState.start(this.age);
        } else {
            super.handleStatus(status);
        }

    }

    private int getHeartRate() {
        float f = (float)this.getAnger() / (float)Angriness.ANGRY.getThreshold();
        return 40 - MathHelper.floor(MathHelper.clamp(f, 0.0F, 1.0F) * 30.0F);
    }

    public float getTendrilPitch(float tickDelta) {
        return MathHelper.lerp(tickDelta, (float)this.lastTendrilPitch, (float)this.tendrilPitch) / 10.0F;
    }

    public float getHeartPitch(float tickDelta) {
        return MathHelper.lerp(tickDelta, (float)this.lastHeartbeatCooldown, (float)this.heartbeatCooldown) / 10.0F;
    }

    private void addDigParticles(AnimationState animationState) {
        if ((float)animationState.getTimeRunning() < 4500.0F) {
            Random random = this.getRandom();
            BlockState blockState = this.getSteppingBlockState();
            if (blockState.getRenderType() != BlockRenderType.INVISIBLE) {
                for(int i = 0; i < 30; ++i) {
                    double d = this.getX() + (double)MathHelper.nextBetween(random, -0.7F, 0.7F);
                    double e = this.getY();
                    double f = this.getZ() + (double)MathHelper.nextBetween(random, -0.7F, 0.7F);
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), d, e, f, 0.0, 0.0, 0.0);
                }
            }
        }

    }

    public void onTrackedDataSet(TrackedData<?> data) {
        if (POSE.equals(data)) {
            switch (this.getPose()) {
                case EMERGING:
                    this.emergingAnimationState.start(this.age);
                    break;
                case DIGGING:
                    this.diggingAnimationState.start(this.age);
                    break;
                case ROARING:
                    this.roaringAnimationState.start(this.age);
                    break;
                case SNIFFING:
                    this.sniffingAnimationState.start(this.age);
            }
        }

        super.onTrackedDataSet(data);
    }

    public boolean isImmuneToExplosion() {
        return this.isDiggingOrEmerging();
    }

    protected Brain<?> deserializeBrain(Dynamic<?> dynamic) {
        return CuratorBrain.create(this, dynamic);
    }

    public Brain<CuratorEntity> getBrain() {
        return (Brain<CuratorEntity>) super.getBrain();
    }

    protected void sendAiDebugData() {
        super.sendAiDebugData();
        DebugInfoSender.sendBrainDebugData(this);
    }

    public void updateEventHandler(BiConsumer<EntityGameEventHandler<?>, ServerWorld> callback) {
        World var3 = this.getWorld();
        if (var3 instanceof ServerWorld serverWorld) {
            callback.accept(this.gameEventHandler, serverWorld);
        }

    }

    public static void addDarknessToClosePlayers(ServerWorld world, Vec3d pos, @Nullable Entity entity, int range) {
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.DARKNESS, 260, 0, false, false);
        StatusEffectUtil.addEffectToPlayersWithinDistance(world, entity, pos, (double) range, statusEffectInstance, 200);
    }


    public Angriness getAngriness() {
        return Angriness.getForAnger(this.getAngerAtTarget());
    }
    public static Angriness getstaticAngriness() {
        return Angriness.getForAnger(CuratorEntity.getstaticAngerAtTarget());
    }

    private int getAngerAtTarget() {
        return this.angerManager.getAngerFor(this.getTarget());
    }

    @Nullable
    public static LivingEntity getstaticTarget() {
        return CuratorEntity.getstaticTarget();
    }

    private static int getstaticAngerAtTarget() {
        return CuratorEntity.angerstaticManager.getAngerFor(CuratorEntity.getstaticTarget());
    }

    @Override
    public ListenerData getVibrationListenerData() {
        return null;
    }

    @Override
    public Callback getVibrationCallback() {
        return null;
    }

    public void removeSuspect(Entity entity) {
        angerManager.removeSuspect(entity);
    }

    /*
    public Object getPrimeSuspect(Object o) {
        return this.getAngriness().isAngry() ? this.angerManager.getPrimeSuspect() : Optional.empty();
    }

    public static Object getstaticPrimeSuspect(Object o) {
        return CuratorEntity.getstaticAngriness().isAngry() ? CuratorEntity.angerstaticManager.getPrimeSuspect() : Optional.empty();
    }

    public Optional<? extends CuratorEntity> getPrimeSuspect() {
        return CuratorEntity.getstaticAngriness().isAngry() ? (Optional<? extends CuratorEntity>) angerManager.getPrimeSuspect() : Optional.empty();
    }

     */

}

