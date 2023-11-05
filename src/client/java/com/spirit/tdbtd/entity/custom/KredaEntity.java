package com.spirit.tdbtd.entity.custom;

import com.spirit.tdbtd.entity.ai.goal.KredaFlyGoal;
import com.spirit.tdbtd.entity.ai.pathing.KredaFlightMoveControl;
import com.spirit.tdbtd.entity.ai.pathing.KredaNavigation;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KredaEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public KredaEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
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
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.41)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 3f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() || this.isLogicalSideForUpdatingMovement()) {
            if (this.isTouchingWater() && this.isSwimming()) {
                this.updateVelocity(0.08f, movementInput);
                this.move(MovementType.SELF, this.getVelocity());
                this.setVelocity(this.getVelocity().multiply(1.8f));
            } else if (this.isInLava()) {
                this.updateVelocity(0.08f, movementInput);
                this.move(MovementType.SELF, this.getVelocity());
                this.setVelocity(this.getVelocity().multiply(1.0));
            } else {
                float f = 0.91f;
                if (this.isOnGround()) {
                    f = this.getWorld().getBlockState(new BlockPos((int) this.getX(), (int) (this.getY() - 100.0), (int) this.getZ())).getBlock().getSlipperiness() * 0f;
                }
                float g = 0.16277137f / (f * f * f);
                f = 0.91f;
                if (this.isOnGround()) {
                    f = this.getWorld().getBlockState(new BlockPos((int) this.getX(), (int) (this.getY() - 100.0), (int) this.getZ())).getBlock().getSlipperiness() * 0.9f;
                }
                this.updateVelocity(this.isOnGround() ? 0.1f * g : 0.02f, movementInput);
                this.move(MovementType.SELF, this.getVelocity());
                this.setVelocity(this.getVelocity().multiply(f));
            }
        }
    }


    static class Land
            extends FlyGoal {
        public Land(PathAwareEntity pathAwareEntity, double d) {
            super(pathAwareEntity, d);
        }

        @Override
        @Nullable
        protected Vec3d getWanderTarget() {
            Vec3d vec3d = null;
            if (this.mob.isTouchingWater()) {
                vec3d = FuzzyTargeting.find(this.mob, 15, 15);
            }
            if (this.mob.getRandom().nextFloat() >= this.probability) {
                vec3d = this.locateground();
            }
            return vec3d == null ? super.getWanderTarget() : vec3d;
        }

        @Nullable
        private Vec3d locateground() {
            BlockPos blockPos = this.mob.getBlockPos();
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            BlockPos.Mutable mutable2 = new BlockPos.Mutable();
            Iterable<BlockPos> iterable = BlockPos.iterate(MathHelper.floor(this.mob.getX() - 30.0), MathHelper.floor(this.mob.getY() - 60.0), MathHelper.floor(this.mob.getZ() - 30.0), MathHelper.floor(this.mob.getX() + 30.0), MathHelper.floor(this.mob.getY() + 60.0), MathHelper.floor(this.mob.getZ() + 30.0));
            for (BlockPos blockPos2 : iterable) {
                BlockState blockState;
                boolean bl;
                if (blockPos.equals(blockPos2) || !(bl = (blockState = this.mob.getWorld().getBlockState(mutable2.set((Vec3i)blockPos2, Direction.DOWN))).getBlock() instanceof GrassBlock) || !this.mob.getWorld().isAir(blockPos2) || !this.mob.getWorld().isAir(mutable.set((Vec3i)blockPos2, Direction.UP))) continue;
                return Vec3d.ofBottomCenter(blockPos2);
            }
            return null;
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(1, new FleeEntityGoal<WardenEntity>(this, WardenEntity.class, 10, 1,1.2));
        this.goalSelector.add(1, new WanderAroundPointOfInterestGoal(this, 10.0, false));
        this.goalSelector.add(1, new WanderAroundGoal(this, 10f));
        this.goalSelector.add(1, new WanderNearTargetGoal(this, 30.0, 10));
        this.goalSelector.add(9, new KredaFlyGoal(this, 10f));
        this.moveControl = new KredaFlightMoveControl(this, 20, false);
        this.goalSelector.add(2, new MeleeAttackGoal(this,1.0f, false));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(3, new AvoidSunlightGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(1, new MoveIntoWaterGoal(this));
        this.goalSelector.add(1, new SwimGoal(this));

        this.goalSelector.add(0, new Land(this, 10.0));



        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));

        this.getNavigation().setCanSwim(true);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_OTHER, 8.0f);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, 8.0f);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f);
    }


    @Override
    protected EntityNavigation createNavigation(World world) {
        KredaNavigation kredaNavigation = new KredaNavigation(this, world);
        kredaNavigation.setCanPathThroughDoors(false);
        kredaNavigation.setCanSwim(true);
        kredaNavigation.setCanEnterOpenDoors(true);
        return kredaNavigation;
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
    protected SoundEvent getAmbientSound() {return SoundEvents.BLOCK_SCULK_CATALYST_BLOOM;}

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_PARROT_IMITATE_SLIME;}

    @Override
    protected SoundEvent getDeathSound() {return SoundEvents.BLOCK_SCULK_CHARGE;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_SCULK_STEP, 0.15f, 1.0f);}
}
