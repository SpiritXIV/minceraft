package com.spirit.tdbtd.entity.custom;

import com.spirit.shit.sound.ShitSounds;
import com.spirit.tdbtd.sound.TDBTDSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.AquaticMoveControl;
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

import java.util.Objects;


public class AbyssofinEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(AbyssofinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> MOISTNESS = DataTracker.registerData(AbyssofinEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public int attackAnimationTimeout = 0;
    private int stalkCooldown = 0;

    public AbyssofinEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
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

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
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
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1f);
    }

    @Override
    protected void initGoals() {

        this.goalSelector.add(0, new BreatheAirGoal(this));
        this.goalSelector.add(0, new MoveIntoWaterGoal(this));
        this.goalSelector.add(1, new ChaseBoatGoal(this));
        this.goalSelector.add(1, new AvoidSunlightGoal(this));
        this.goalSelector.add(4, new SwimAroundGoal(this, 2.0, 10));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 10.0f));
        this.goalSelector.add(6, new MeleeAttackGoal(this, 1.2f, true));
        this.goalSelector.add(2, new AbyssofinEntity.StalkPlayerGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, DolphinEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, DrownedEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, CodEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SalmonEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, AxolotlEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, TurtleEntity.class, true));
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
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setupAnimationStates();
        }

        // Check for darkness and move towards it
        if (this.getTarget() == null) {
            moveTowardsDarkness();
        }

        // Rest on ocean surface only if there is sculk below
        if (!this.isTouchingWater() && this.getWorld().getBlockState(new BlockPos((int) this.getX(), (int) (this.getY() - 1), (int) this.getZ())).isOf(Blocks.SCULK)) {
            this.setAiDisabled(true);
            if (this.getTarget() != null) {
                jumpTowardsTarget();
            }
        }

        if (this.isWet()) {
            this.setMoistness(2400);
        } else {
            this.setMoistness(this.getMoistness() - 1);
            if (this.getMoistness() <= 0) {
                this.damage(DamageTypes.DRY_OUT, 1.0f);
            }
            if (this.isOnGround()) {
                this.setVelocity(this.getVelocity().add((this.random.nextFloat() * 2.0f - 1.0f) * 0.2f, 0.5, (this.random.nextFloat() * 2.0f - 1.0f) * 0.2f));
                this.setYaw(this.random.nextFloat() * 360.0f);
                this.setOnGround(false);
                this.velocityDirty = true;
            }
        }
        if (this.getWorld().isClient && this.isTouchingWater() && this.getVelocity().lengthSquared() > 0.03) {
            Vec3d vec3d = this.getRotationVec(0.0f);
            float f = MathHelper.cos(this.getYaw() * ((float) Math.PI / 180)) * 0.3f;
            float g = MathHelper.sin(this.getYaw() * ((float) Math.PI / 180)) * 0.3f;
            float h = 1.2f - this.random.nextFloat() * 0.7f;
            for (int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(ParticleTypes.SCULK_CHARGE_POP, this.getX() - vec3d.x * (double) h + (double) f, this.getY() - vec3d.y, this.getZ() - vec3d.z * (double) h + (double) g, 0.0, 0.0, 0.0);
                this.getWorld().addParticle(ParticleTypes.SCULK_CHARGE_POP, this.getX() - vec3d.x * (double) h - (double) f, this.getY() - vec3d.y, this.getZ() - vec3d.z * (double) h - (double) g, 0.0, 0.0, 0.0);
            }
        }
    }

    private void jumpTowardsTarget() {
        Vec3d targetPos = this.getTarget().getPos();
        double dx = targetPos.x - this.getX();
        double dz = targetPos.z - this.getZ();
        double distanceSquared = dx * dx + dz * dz;
        if (distanceSquared > 2.0) { // If the target is far enough, jump towards it
            this.setVelocity(this.getVelocity().add(0.0, 0.5, 0.0));
        } else { // If the target is close, dip down
            this.setVelocity(this.getVelocity().add(0.0, -0.5, 0.0));
        }
    }

    private void moveTowardsDarkness() {
        BlockPos blockPos = this.getBlockPos();
        int lightLevel = this.getWorld().getLightLevel(LightType.SKY, blockPos);
        if (lightLevel <= 7) { // Adjust this threshold as needed
            BlockPos targetPos = new BlockPos((int) (blockPos.getX() + 0.5), (int) this.getY(), (int) (blockPos.getZ() + 0.5));
            this.getNavigation().startMovingTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 0.2);
        }
    }


        private void damage (RegistryKey < DamageType > dryOut,float amount){
        }

        @Override
        public void travel (Vec3d movementInput){
            if (this.canMoveVoluntarily() && this.isTouchingWater()) {
                this.updateVelocity(this.getMovementSpeed(), movementInput);
                this.move(MovementType.SELF, this.getVelocity());
                this.setVelocity(this.getVelocity().multiply(0.9));
                if (this.getTarget() == null) {
                    this.setVelocity(this.getVelocity().add(0.0, -0.008, 0.0));
                }
            } else {
                super.travel(movementInput);
            }
        }

        @Override
        protected EntityNavigation createNavigation (World world){
            return new SwimNavigation(this, world);
        }

        @Override
        public int getMaxAir () {
            return 4800;
        }

        @Override
        protected int getNextAirOnLand ( int air){
            return this.getMaxAir();
        }


        @Override
        public void writeCustomDataToNbt (NbtCompound nbt){
            super.writeCustomDataToNbt(nbt);
            nbt.putInt("Moistness", this.getMoistness());
        }

        @Override
        public void readCustomDataFromNbt (NbtCompound nbt){
            super.readCustomDataFromNbt(nbt);
            this.setMoistness(nbt.getInt("Moistness"));
        }

        @Override
        protected void initDataTracker () {
            super.initDataTracker();
            this.dataTracker.startTracking(MOISTNESS, 2600);
            this.dataTracker.startTracking(ATTACKING, false);
        }

        @Override
        public boolean canBreatheInWater () {
            return true;
        }

        @Override
        protected float calculateNextStepSoundDistance () {
            return this.distanceTraveled + 0.55f;
        }

        @Override
        protected float getSoundVolume () {
            return 1.0f;
        }

        @Override
        protected SoundEvent getAmbientSound () {
            return TDBTDSounds.ENTITY_WATER_BREATH;
        }

        @Override
        protected SoundEvent getHurtSound (DamageSource source){
            return SoundEvents.ENTITY_PLAYER_HURT;
        }

        @Override
        protected SoundEvent getDeathSound () {
            return TDBTDSounds.ENTITY_WATER_BREATH;
        }

        @Override
        protected void playStepSound (BlockPos pos, BlockState state){
            this.playSound(ShitSounds.NOTHING, 0.15f, 1.0f);
        }

        class StalkPlayerGoal extends Goal {
            private final AbyssofinEntity entity;

            public StalkPlayerGoal(AbyssofinEntity entity) {
                this.entity = entity;
            }

            @Override
            public boolean canStart() {
                return entity.getTarget() == null && (entity.isSubmergedInWater() || entity.hasVehicle()) && stalkCooldown <= 0;
            }

            @Override
            public void start() {
                entity.setAttacking(false);
            }

            @Override
            public void tick() {
                if (entity.getTarget() == null) {
                    PlayerEntity player = entity.getWorld().getClosestPlayer(entity, 10.0);
                    if (player != null) {
                        entity.getNavigation().startMovingTo(player, 1.0);
                    }
                }

                if (entity.getTarget() != null && entity.getTarget().hasVehicle()) {
                    if (stalkCooldown <= 0) {
                        // Break the target's boat and set cooldown
                        Objects.requireNonNull(entity.getTarget().getVehicle()).kill();
                        stalkCooldown = 200; // 10 seconds cooldown (200 ticks at 20 ticks per second)
                    } else {
                        stalkCooldown--;
                    }
                }
            }

            @Override
            public void stop() {
                entity.getNavigation().stop();
            }
    }
}