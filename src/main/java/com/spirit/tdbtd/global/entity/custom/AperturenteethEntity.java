package com.spirit.tdbtd.global.entity.custom;

import com.spirit.tdbtd.global.entity.ai.goal.LookAtPlayerGoal;
import com.spirit.tdbtd.global.sound.TDBTDSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.EnumSet;

public class AperturenteethEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(AperturenteethEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    static float ATTACK_DAMAGE = 4.0f;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public AperturenteethEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
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
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_DAMAGE)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.1f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, -0.5)
                .add(EntityAttributes.GENERIC_ARMOR, 4)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(6, new BuriedAttackGoal(this));
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 0.4, false));
        this.goalSelector.add(3, new BreatheAirGoal(this));
        this.goalSelector.add(4, new AvoidSunlightGoal(this));
        this.goalSelector.add(5, new LookAtPlayerGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, FoxEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PassiveEntity.class, true));
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
    protected SoundEvent getAmbientSound() {
        return TDBTDSounds.APERTURENTEETH_AMBIENT;}

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_PLAYER_HURT;}

    @Override
    protected SoundEvent getDeathSound() {return TDBTDSounds.APERTURENTEETH_AMBIENT;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_SCULK_BREAK, 0.15f, 1.0f);}

    @Override
    public boolean tryAttack(Entity target) {
        this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_ATTACK_SOUND);
        this.playSound(TDBTDSounds.APERTURENTEETH_BITE, 1.0f, 0.8f);
        return super.tryAttack(target);
    }

    public float getDamage() {
        return ATTACK_DAMAGE;
    }

    public void lookAtEntity() {
    }

    public static class BuriedAttackGoal extends Goal {
        private final AperturenteethEntity entity;
        private final World world;
        private BlockPos buryPos;
        private int buryCooldown;
        private int buriedTime;

        public BuriedAttackGoal(AperturenteethEntity entity) {
            this.entity = entity;
            this.world = entity.getWorld();
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return !this.entity.isAttacking() && this.buryCooldown <= 0 && shouldBury();
        }

        private boolean shouldBury() {
            return this.world.getRandom().nextInt(this.world.isNight() ? 150 : 300) == 0
                    && this.world.getBlockState(this.entity.getBlockPos().down()).getBlock() == Blocks.SCULK;
        }

        @Override
        public void start() {
            this.buryPos = this.entity.getBlockPos().add(-5 + this.world.getRandom().nextInt(11), 0, -5 + this.world.getRandom().nextInt(11));
            this.buryCooldown = 600;
            this.buriedTime = 12000;

            this.entity.playSound(SoundEvents.ENTITY_WARDEN_ANGRY, 1.0f, 1.0f);
            this.entity.setAiDisabled(true);
        }

        @Override
        public void tick() {
            if (this.buriedTime > 0) {
                this.buriedTime--;

                this.entity.getNavigation().startMovingTo(this.buryPos.getX() + 0.5, this.entity.getY(), this.buryPos.getZ() + 0.5, 0.0);
                this.entity.setMovementSpeed(-1);
            } else {
                PlayerEntity player = this.world.getClosestPlayer(this.entity, 1.0);
                if (player != null) {
                    player.damage(entity.getRecentDamageSource(), entity.getDamage());
                    this.entity.playSound(SoundEvents.BLOCK_SCULK_BREAK, 1.0f, 1.0f);
                    this.entity.getWorld().addParticle(ParticleTypes.EXPLOSION, true, entity.getX(), entity.getY(), entity.getZ(), 0,1, 0);
                    this.entity.setAttacking(true);
                    this.entity.setMovementSpeed(+1);
                }
            }
        }

        @Override
        public void stop() {
            this.entity.setAttacking(false);
            this.entity.setAiDisabled(false);

        }

        @Override
        public boolean shouldContinue() {
            return this.entity.isAttacking();
        }

        public void stopExecuting() {
            this.entity.setAttacking(false);
        }

        public void resetTask() {
            this.buryCooldown--;
        }
    }

}
