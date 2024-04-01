package com.spirit.shit.global.entity.custom;

import com.spirit.shit.global.sound.ShitSounds;
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
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JbirdEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public JbirdEntity(EntityType<? extends HostileEntity> entityType, World world) {
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

    public static DefaultAttributeContainer.Builder creatorJbirdAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, -0.1)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new BreatheAirGoal(this));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.5));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new AttackGoal(this));
        this.goalSelector.add(6, new MeleeAttackGoal(this, 0.5, false));
        this.goalSelector.add(7, new BreatheAirGoal(this));

        this.targetSelector.add(5, new ActiveTargetGoal<>(this, PassiveEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, HostileEntity.class, true));


        this.experiencePoints = 5;
        this.getNavigation().setCanSwim(true);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_OTHER, 8.0f);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, 8.0f);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0f);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return  ShitSounds.JBIRD_SPEAK;}

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return ShitSounds.JBIRD_HURT;}

    @Override
    protected SoundEvent getDeathSound() {
        return ShitSounds.JBIRD_HURT;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_STONE_STEP, 1f, 1.0f);
    }
}