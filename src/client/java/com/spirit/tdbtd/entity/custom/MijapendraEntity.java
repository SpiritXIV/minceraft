package com.spirit.tdbtd.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MijapendraEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public MijapendraEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
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


    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }
    public boolean occludeVibrationSignals() {
        return true;
    }

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

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, SilverfishEntity.class, true));
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
    protected float calculateNextStepSoundDistance() {
        return this.distanceTraveled + 0.55f;
    }

    @Override
    protected float getSoundVolume() {
        return 4.0f;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.ENTITY_SILVERFISH_AMBIENT, 0.5f, 0.6f);
        this.playSound(SoundEvents.BLOCK_SCULK_SENSOR_BREAK, 1f, 0f);
        return SoundEvents.BLOCK_TUFF_BREAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.BLOCK_SCULK_CATALYST_BREAK;}

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.ENTITY_SILVERFISH_DEATH, 1f, 0.6f);
        return SoundEvents.BLOCK_DRIPSTONE_BLOCK_BREAK;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_SCULK_BREAK, 0.15f, 1.0f);
        this.playSound(SoundEvents.BLOCK_BONE_BLOCK_STEP, 1f, 1f);
    }
}
