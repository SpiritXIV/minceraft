package com.spirit.tdbtd.entity.custom;

import com.spirit.shit.sound.ShitSounds;
import com.spirit.tdbtd.sound.TDBTDSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DevastadorPupEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(DevastadorPupEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState sprintingAnimationState = new AnimationState();
    public int sprintingAnimationTimeout = 0;

    public DevastadorPupEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {this.idleAnimationTimeout = this.random.nextInt(40) + 80; this.idleAnimationState.start(this.age);
        } else {--this.idleAnimationTimeout;}
        if(this.isAttacking() && attackAnimationTimeout <= 0) {attackAnimationTimeout = 40; attackAnimationState.start(this.age);
        } else {--this.attackAnimationTimeout;}
        if(!this.isSprinting()) {sprintingAnimationState.stop();}
        if(this.isAttacking() && sprintingAnimationTimeout <= 0) {sprintingAnimationTimeout = 40; sprintingAnimationState.start(this.age);
        } else {--this.sprintingAnimationTimeout;}
        if(!this.isSprinting()) {sprintingAnimationState.stop();}
    }

    @Override
    protected void updateLimbs(float posDelta) {float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;this.limbAnimator.updateLimbs(f, 0.2f);}
    public void setAttacking(boolean attacking) {this.dataTracker.set(ATTACKING, attacking);}
    @Override
    public boolean isAttacking() {return this.dataTracker.get(ATTACKING);}
    @Override
    protected void initDataTracker() {super.initDataTracker(); this.dataTracker.startTracking(ATTACKING, false);}
    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    public boolean occludeVibrationSignals() {return true;}

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.1f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, -0.5)
                .add(EntityAttributes.GENERIC_ARMOR, 4)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 0.5, false));
        this.goalSelector.add(3, new BreatheAirGoal(this));
        this.goalSelector.add(4, new AvoidSunlightGoal(this));
        this.goalSelector.add(3, new FollowEntityGoal(this, DevastadorHoundEntity.class, 1.0F, 10.0F, 20.0F));
        this.goalSelector.add(3, new FollowEntityGoal(this, DevastadorCurEntity.class, 1.0F, 10.0F, 20.0F));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));

        this.experiencePoints = 5;
        this.getNavigation().setCanSwim(true);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_OTHER, 8.0f);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, 8.0f);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f);
    }

    @Override
    protected float calculateNextStepSoundDistance() {return this.distanceTraveled + 0.55f;}
    @Override
    protected SoundEvent getAmbientSound() {this.playSound(TDBTDSounds.DEVASTADOR_AMBIENT, 1f, 2f); return ShitSounds.NOTHING;}
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_PLAYER_HURT;}
    @Override
    protected SoundEvent getDeathSound() {return TDBTDSounds.DEVASTADOR_AMBIENT;}
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_BONE_BLOCK_PLACE, 1f, 1.0f);
    }

    public static class FollowEntityGoal extends Goal {
        private final MobEntity mob;
        private final Class<? extends LivingEntity> targetClass;
        private LivingEntity targetEntity;
        private final double speed;
        private final float maxDistance;
        private final float minDistance;

        public FollowEntityGoal(MobEntity mob, Class<? extends LivingEntity> targetClass, double speed, float minDistance, float maxDistance) {
            this.mob = mob;
            this.targetClass = targetClass;
            this.speed = speed;
            this.minDistance = minDistance;
            this.maxDistance = maxDistance;
        }
        @Override
        public boolean canStart() {
            this.targetEntity = this.mob.getWorld().getClosestEntity(
                    this.targetClass,
                    TargetPredicate.createAttackable().setBaseMaxDistance(this.maxDistance),
                    this.mob,
                    this.mob.getX(),
                    this.mob.getY(),
                    this.mob.getZ(),
                    this.mob.getBoundingBox().expand(this.maxDistance, 3.0D, this.maxDistance)
            );
            return this.targetEntity != null && this.mob.getPos().distanceTo(this.targetEntity.getPos()) > this.minDistance;
        }
        @Override
        public boolean shouldContinue() {return this.targetEntity != null && !this.mob.getNavigation().isIdle() && this.mob.getPos().distanceTo(this.targetEntity.getPos()) > this.minDistance;}
        @Override
        public void start() {this.mob.getNavigation().startMovingTo(this.targetEntity, this.speed);}
        @Override
        public void stop() {this.targetEntity = null;}
    }
}