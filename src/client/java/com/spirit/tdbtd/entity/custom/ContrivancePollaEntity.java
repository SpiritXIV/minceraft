package com.spirit.tdbtd.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContrivancePollaEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public ContrivancePollaEntity(EntityType<? extends HostileEntity> entityType, World world) {
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
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 550.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 60.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.1f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, -3)
                .add(EntityAttributes.GENERIC_ARMOR, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 0.6, false));
        this.goalSelector.add(3, new BreatheAirGoal(this));
        this.goalSelector.add(4, new AvoidSunlightGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, WardenEntity.class, true));
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
        this.playSound(SoundEvents.PARTICLE_SOUL_ESCAPE, 10.0f, 1f);
        this.playSound(SoundEvents.ITEM_LODESTONE_COMPASS_LOCK, 1.0f, 0f);
        return SoundEvents.BLOCK_TUFF_BREAK;}

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        this.playSound(SoundEvents.BLOCK_RESPAWN_ANCHOR_SET_SPAWN, 20.0f, 0f);
        this.playSound(SoundEvents.BLOCK_LODESTONE_PLACE, 20.0f, 0f);
        return SoundEvents.BLOCK_SCULK_CATALYST_BREAK;}

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.BLOCK_BEACON_POWER_SELECT, 10.0f, 0.7f);
        return SoundEvents.BLOCK_BEACON_DEACTIVATE;
}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_COPPER_PLACE, 0.15f, 1.0f);
        this.playSound(SoundEvents.BLOCK_CHAIN_PLACE, 1.0f, 1.5f);}

    @Override
    public boolean tryAttack(Entity target) {
        this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_ATTACK_SOUND);
        this.playSound(SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, 1.0f, 0f);

        return super.tryAttack(target);
    }
}
