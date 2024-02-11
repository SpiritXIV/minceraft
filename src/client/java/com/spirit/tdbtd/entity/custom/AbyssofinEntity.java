package com.spirit.tdbtd.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


public class AbyssofinEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(AbyssofinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> MOISTNESS = DataTracker.registerData(AbyssofinEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> MOVING_TO_DARK_PLACE = DataTracker.registerData(AbyssofinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int stalkingTime = 0;
    private int idleAnimationTimeout = 0;
    public int attackAnimationTimeout = 0;
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public AbyssofinEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new AquaticMoveControl(this);
        this.lookControl = new YawAdjustingLookControl(this, 10);
        this.dataTracker.startTracking(MOVING_TO_DARK_PLACE, false);    }
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


    public boolean occludeVibrationSignals() {
        return true;
    }

    public int getMoistness() {
        return this.dataTracker.get(MOISTNESS);
    }

    public void setMoistness(int moistness) {
        this.dataTracker.set(MOISTNESS, moistness);
    }



    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 9.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1)
                .add(EntityAttributes.GENERIC_ARMOR, 6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new BreatheAirGoal(this));
        this.goalSelector.add(1, new MoveIntoWaterGoal(this));
        this.goalSelector.add(2, new MoveToDarkPlaceGoal(this));
        this.goalSelector.add(3, new ChaseBoatGoal(this));
        this.goalSelector.add(4, new SwimAroundGoal(this, 2.0, 10));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 10.0f));
        this.goalSelector.add(7, new MeleeAttackGoal(this, 1.2f, true));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, DolphinEntity.class, true));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, DrownedEntity.class, true));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, CodEntity.class, true));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, SalmonEntity.class, true));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, AxolotlEntity.class, true));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, TurtleEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.experiencePoints = 5;
        this.getNavigation().setCanSwim(true);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_OTHER, 8.0f);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, 8.0f);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f);
    }

    public boolean isMovingToDarkPlace() {
        return this.dataTracker.get(MOVING_TO_DARK_PLACE);
    }

    public void setMovingToDarkPlace(boolean movingToDarkPlace) {
        this.dataTracker.set(MOVING_TO_DARK_PLACE, movingToDarkPlace);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }

        if (this.isDark() && !this.isAttacking()) {
            stalkingTime++;
        } else {
            stalkingTime = 0;
        }

        if (stalkingTime >= 600 && !this.isAttacking()) {
            this.setAttacking(true);
        }

        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
        if (this.isAiDisabled()) {
            this.setAir(this.getMaxAir());
            return;
        }
        if (this.isWet()) {
            this.setMoistness(2400);
        } else {
            this.setMoistness(this.getMoistness() - 1);
            if (this.getMoistness() <= 0) {
                this.damage(DamageTypes.DRY_OUT, 1.0f);
            }
            if (this.isOnGround()) {
                this.setVelocity(this.getVelocity().add((this.random.nextFloat() * .5f), 0.5, (this.random.nextFloat() * .5f)));
                this.setYaw(this.random.nextFloat());
                this.setOnGround(false);
                this.velocityDirty = true;
            }
        }
        if (this.getWorld().isClient && this.isTouchingWater() && this.getVelocity().lengthSquared() > 0.03) {
            Vec3d vec3d = this.getRotationVec(0.0f);
            float f = MathHelper.cos(this.getYaw() * ((float)Math.PI / 180)) * 0.3f;
            float g = MathHelper.sin(this.getYaw() * ((float)Math.PI / 180)) * 0.3f;
            float h = 1.2f - this.random.nextFloat() * 0.7f;
            for (int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(ParticleTypes.SCULK_CHARGE_POP, this.getX() - vec3d.x * (double)h + (double)f, this.getY() - vec3d.y, this.getZ() - vec3d.z * (double)h + (double)g, 0.0, 0.0, 0.0);
                this.getWorld().addParticle(ParticleTypes.SCULK_CHARGE_POP, this.getX() - vec3d.x * (double)h - (double)f, this.getY() - vec3d.y, this.getZ() - vec3d.z * (double)h - (double)g, 0.0, 0.0, 0.0);
            }
        }
    }

    private void damage(RegistryKey<DamageType> dryOut, float amount) {
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.2));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0, -0.008, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }

    static class AquaticMoveControl extends MoveControl {
        public AquaticMoveControl(MobEntity entity) {
            super(entity);
        }

        @Override
        public void tick() {
            if (this.state == MoveControl.State.MOVE_TO && !this.entity.isTouchingWater()) {
                this.entity.setMovementSpeed(MathHelper.lerp(0.02F, this.entity.getMovementSpeed(), 0.0F));
                this.entity.setForwardSpeed(0.0F);
                this.entity.setSidewaysSpeed(0.0F);
                this.state = MoveControl.State.WAIT;
            } else {
                super.tick();
            }
        }
    }

    @Override
    public int getMaxAir() {
        return 4800;
    }

    @Override
    protected int getNextAirOnLand(int air) {
        return this.getMaxAir();
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Moistness", this.getMoistness());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setMoistness(nbt.getInt("Moistness"));
    }

    private boolean isDark() {
        BlockPos blockPos = this.getBlockPos();
        return this.getWorld().isNight() && !this.getWorld().isSkyVisible(blockPos);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MOISTNESS, 2600);
        this.dataTracker.startTracking(ATTACKING, false);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }


    @Override
    public boolean canBreatheInWater() {
        return true;
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
    protected SoundEvent getAmbientSound() {return SoundEvents.BLOCK_CONDUIT_AMBIENT_SHORT;}

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.BLOCK_SOUL_SAND_BREAK;}

    @Override
    protected SoundEvent getDeathSound() {return SoundEvents.BLOCK_CONDUIT_ATTACK_TARGET;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_SLIME_BLOCK_STEP, 0.15f, 1.0f);}


    static class MoveToDarkPlaceGoal extends Goal {
        private final AbyssofinEntity entity;
        public MoveToDarkPlaceGoal(AbyssofinEntity entity) {
            this.entity = entity;
        }

        @Override
        public boolean canStart() {
            return this.entity.isDark() && !this.entity.isAttacking() && !this.entity.isMovingToDarkPlace();
        }

        @Override
        public void start() {
            this.entity.setMovingToDarkPlace(true);
        }

        @Override
        public void tick() {
            if (!this.entity.isDark()) {
                WorldAccess world = this.entity.getWorld();
                BlockPos darkPlace = findDarkPlace(world, this.entity.getBlockPos());
                if (darkPlace != null) {
                    this.entity.getNavigation().startMovingTo(darkPlace.getX(), darkPlace.getY(), darkPlace.getZ(), 1.0);
                }
            } else {
                this.entity.setMovingToDarkPlace(false);
            }
        }

        @Override
        public void stop() {
            this.entity.setMovingToDarkPlace(false);
        }

        private BlockPos findDarkPlace(WorldAccess world, BlockPos currentPos) {
            BlockPos.Mutable mutablePos = new BlockPos.Mutable();
            for (int i = 0; i < 10; i++) {
                int offsetX = this.entity.getRandom().nextInt(16) - 8;
                int offsetY = this.entity.getRandom().nextInt(8) - 4;
                int offsetZ = this.entity.getRandom().nextInt(16) - 8;
                mutablePos.set(currentPos).move(offsetX, offsetY, offsetZ);
                if (world.getLightLevel(LightType.BLOCK, mutablePos) < 8) {
                    return mutablePos;
                }
            }
            return null;
        }
    }
}
