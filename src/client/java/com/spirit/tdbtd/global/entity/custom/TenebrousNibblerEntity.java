package com.spirit.tdbtd.global.entity.custom;

import com.mojang.datafixers.util.Pair;
import com.spirit.shit.global.sound.ShitSounds;
import com.spirit.tdbtd.global.sound.TDBTDSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
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
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;


public class TenebrousNibblerEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(TenebrousNibblerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> MOISTNESS = DataTracker.registerData(TenebrousNibblerEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Optional<UUID>> GROUP_LEADER = DataTracker.registerData(TenebrousNibblerEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    private static final TrackedData<Integer> GROUP_SIZE = DataTracker.registerData(TenebrousNibblerEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public TenebrousNibblerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new AquaticMoveControl(this, 85, 10, 0.1f, 0.02f, true);
        this.lookControl = new YawAdjustingLookControl(this, 10);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {this.idleAnimationTimeout = this.random.nextInt(40) + 80; this.idleAnimationState.start(this.age);
        } else {--this.idleAnimationTimeout;}
        if (this.isAttacking() && attackAnimationTimeout <= 0) {attackAnimationTimeout = 40; attackAnimationState.start(this.age);
        } else {--this.attackAnimationTimeout;}
        if (!this.isAttacking()) {attackAnimationState.stop();}
    }

    @Override
    protected void updateLimbs(float posDelta) {float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;this.limbAnimator.updateLimbs(f, 0.2f);}
    public void setAttacking(boolean attacking) {this.dataTracker.set(ATTACKING, attacking);}
    @Override
    public boolean isAttacking() {return this.dataTracker.get(ATTACKING);}
    public boolean occludeVibrationSignals() {return true;}
    public int getMoistness() {return this.dataTracker.get(MOISTNESS);}
    public void setMoistness(int moistness) {this.dataTracker.set(MOISTNESS, moistness);}
    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.25f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.9f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwarmPlayerGoal(this, 1.2, 15));
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(0, new MoveIntoWaterGoal(this));
        this.goalSelector.add(1, new ChaseBoatGoal(this));
        this.goalSelector.add(1, new AvoidSunlightGoal(this));
        this.goalSelector.add(4, new SwimAroundGoal(this, 1.0, 10));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 10.0f));
        this.goalSelector.add(6, new MeleeAttackGoal(this, 1.2f, true));
        this.goalSelector.add(7, new IdleInGroupsGoal(this, 1.0));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PassiveEntity.class, true));

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
                this.setVelocity(this.getVelocity().add((this.random.nextFloat() * 2.0f - 1.0f) * 0.2f, 0.5, (this.random.nextFloat() * 2.0f - 1.0f) * 0.2f));
                this.setYaw(this.random.nextFloat() * 360.0f);
                this.setOnGround(false);
                this.velocityDirty = true;
            }
        }

        if (this.getTarget() != null && !this.isTouchingWater()) {
            double distanceToTargetXZ = this.squaredDistanceTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ());
            double distanceToTargetY = Math.abs(this.getTarget().getY() - this.getY());
            if (distanceToTargetXZ < 2.0 && distanceToTargetY < 2.0 && distanceToTargetY > -5.0) { // Modified condition
                Vec3d targetPos = this.getTarget().getPos();
                Vec3d jumpPos = targetPos.add(0.0, 2.0, 0.0); // Jump 2 blocks above the target
                this.getNavigation().startMovingTo(jumpPos.getX(), jumpPos.getY(), jumpPos.getZ(), 1.0);
                this.tryAttack(this.getTarget());

            }
        }

        if (this.getWorld().isClient && this.isTouchingWater() && this.getVelocity().lengthSquared() > 0.03) {
            Vec3d vec3d = this.getRotationVec(0.0f);
            float f = MathHelper.cos(this.getYaw() * ((float) Math.PI / 180)) * 0.3f;
            float g = MathHelper.sin(this.getYaw() * ((float) Math.PI / 180)) * 0.3f;
            float h = 1.2f - this.random.nextFloat() * 0.7f;
            for (int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3d.x * (double) h + (double) f, this.getY() - vec3d.y, this.getZ() - vec3d.z * (double) h + (double) g, 0.0, 0.0, 0.0);
                this.getWorld().addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3d.x * (double) h - (double) f, this.getY() - vec3d.y, this.getZ() - vec3d.z * (double) h - (double) g, 0.0, 0.0, 0.0);
            }
        }

        if (!this.getWorld().isClient()) {
            if (this.getGroupSize() < 15) {
                List<TenebrousNibblerEntity> nearbyNibblers = getGroupMembers();
                for (TenebrousNibblerEntity nearbyNibbler : nearbyNibblers) {
                    if (!nearbyNibbler.getGroupLeader().equals(this.getGroupLeader())) {
                        nearbyNibbler.setGroupLeader(this.getUuid());
                        nearbyNibbler.setGroupSize(this.getGroupSize() + 1);
                    }
                }
            }

            if (this.isLeader()) {
                if (this.getTarget() != null) {
                    this.getNavigation().startMovingTo(this.getTarget(), 1.0);
                }
            }

            if (this.isLeader() && this.getRecentDamageSource() != null) {
                List<TenebrousNibblerEntity> groupMembers = getGroupMembers();
                for (TenebrousNibblerEntity groupMember : groupMembers) {
                    groupMember.setAttacking(true);
                    groupMember.getNavigation().startMovingTo(this.getRecentDamageSource().getAttacker(), 1.5);
                }
            }
        }
        if (!this.getWorld().isClient && this.isAlive() && this.getHealth() < this.getMaxHealth()) {
            this.getWorld().getEntitiesByClass(ItemEntity.class, this.getBoundingBox().expand(3.0), (itemEntity) -> {
                if (itemEntity.getStack().getItem().isFood()) {
                    ItemStack itemStack = itemEntity.getStack();
                    FoodComponent foodComponent = itemStack.getItem().getFoodComponent();
                    if (foodComponent != null) {
                        this.eatFood(itemStack);
                        itemEntity.getStack().decrement(1);
                        this.heal(foodComponent.getHunger());
                        if (foodComponent.getStatusEffects() != null) {
                            for (Pair<StatusEffectInstance, Float> pair : foodComponent.getStatusEffects()) {
                                if (!this.hasStatusEffect(pair.getFirst().getEffectType())) {
                                    if (this.random.nextFloat() < pair.getSecond()) {
                                        this.addStatusEffect(new StatusEffectInstance(pair.getFirst()));
                                    }
                                }
                            }
                        }
                        this.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0f, this.getRandom().nextFloat() * 0.1F + 0.9F);
                    }
                }
                return false;
            });
        }
    }

    private void eatFood(ItemStack itemStack) {}
    private void damage(RegistryKey<DamageType> dryOut, float amount) {}

    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && (this.isTouchingWater() || this.isInsideWaterOrBubbleColumn())) {
            if (this.isInsideWaterOrBubbleColumn()) {
                this.updateVelocity(this.getMovementSpeed(), movementInput);

                this.move(MovementType.SELF, this.getVelocity());
                this.setVelocity(this.getVelocity().multiply(0.8));

                BlockPos entityPos = this.getBlockPos();
                BlockPos downPos = entityPos.down();
                BlockState downBlockState = this.getWorld().getBlockState(downPos);

                if (downBlockState.isOf(Blocks.MAGMA_BLOCK) || downBlockState.isOf(Blocks.SOUL_SAND)) {
                    this.setVelocity(this.getVelocity().add(0.0, -0.1, 0.0));
                } else {
                    if (this.getTarget() == null) {
                        this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
                    }
                }
            }
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    protected EntityNavigation createNavigation(World world) {return new SwimNavigation(this, world);}
    @Override
    public int getMaxAir() {return 4800;}
    @Override
    protected int getNextAirOnLand(int air) {return this.getMaxAir();}

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

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MOISTNESS, 400);
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(GROUP_LEADER, Optional.of(UUID.randomUUID()));
        this.dataTracker.startTracking(GROUP_SIZE, 15);
    }

    private Optional<Optional<UUID>> getGroupLeader() {return Optional.ofNullable(this.dataTracker.get(GROUP_LEADER));}

    private void setGroupLeader(@Nullable UUID leaderUUID) {this.dataTracker.set(GROUP_LEADER, Optional.ofNullable(leaderUUID));}

    private int getGroupSize() {return this.dataTracker.get(GROUP_SIZE);}
    private void setGroupSize(int size) {this.dataTracker.set(GROUP_SIZE, size);}
    private List<TenebrousNibblerEntity> getGroupMembers() {
        Predicate<Entity> predicate = entity -> entity instanceof TenebrousNibblerEntity;
        return this.getWorld().getEntitiesByClass(TenebrousNibblerEntity.class, this.getBoundingBox().expand(15.0, 5.0, 15.0), predicate);
    }
    @Override
    public boolean canBreatheInWater() {return true;}
    @Override
    protected float calculateNextStepSoundDistance() {return this.distanceTraveled + 0.55f;}
    @Override
    protected float getSoundVolume() {return 1.0f;}
    private boolean isLeader() {return this.getUuid().equals(this.getGroupLeader());}
    @Override
    protected SoundEvent getAmbientSound() {return ShitSounds.NOTHING;}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_PLAYER_HURT;}
    @Override
    protected SoundEvent getDeathSound() {return ShitSounds.NOTHING;}

    @Override
    public boolean tryAttack(Entity target) {
        float damage = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        target.timeUntilRegen = 0;

        if (this.squaredDistanceTo(target) < 4.0 && Math.abs(target.getY() - this.getY()) < 2.0) {
            if (target.damage(com.spirit.tdbtd.global.entity.damage.DamageTypes.of(getWorld(), com.spirit.tdbtd.global.entity.damage.DamageTypes.FISH_BITE), damage)) {
                this.applyDamageEffects(this, target);
                this.onAttacking(target);
                this.attackAnimationState.start(this.age);
                this.setAttacking(true);
                this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_ATTACK_SOUND);
                this.playSound(TDBTDSounds.TENEBROUS_NIBBLER_BITE, 1.0F, this.getSoundPitch());
                return true;
            }
        }
        return false;
    }


    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {this.playSound(ShitSounds.NOTHING, 0.15f, 1.0f);}

    private static class SwarmPlayerGoal extends TrackTargetGoal {
        private final TenebrousNibblerEntity nibbler;

        public SwarmPlayerGoal(TenebrousNibblerEntity nibbler, double speed, int updateRate) {
            super(nibbler, true, true);
            this.nibbler = nibbler;
        }

        @Override
        public boolean canStart() {return nibbler.isLeader();}
        @Override
        public void start() {super.start(); nibbler.setAttacking(true);}
        @Override
        public void stop() {super.stop(); nibbler.setAttacking(false);}

        @Override
        public void tick() {
            super.tick();
            if (nibbler.getTarget() != null && nibbler.getTarget().isAlive()) {
                Vec3d targetPos = Objects.requireNonNull(nibbler.getTarget()).getPos();
                List<TenebrousNibblerEntity> nearbyNibblers = nibbler.getGroupMembers();
                for (TenebrousNibblerEntity nearbyNibbler : nearbyNibblers) {
                    if (!nearbyNibbler.equals(nibbler)) {
                        double distanceToTargetXZ = nearbyNibbler.squaredDistanceTo(targetPos.x, targetPos.y, targetPos.z);
                        double distanceToTargetY = Math.abs(targetPos.y - nearbyNibbler.getY());
                        if (distanceToTargetXZ < 2.0 && distanceToTargetY < 2.0 && distanceToTargetY > -5.0) {
                            Vec3d jumpPos = targetPos.add(0.0, -1.0, 0.0);
                            nearbyNibbler.getNavigation().startMovingTo(jumpPos.x, jumpPos.y, jumpPos.z, 1.0);
                            if (distanceToTargetXZ <= 4.0) {
                                nearbyNibbler.tryAttack(nibbler.getTarget());
                            }
                        } else {
                            nearbyNibbler.getNavigation().startMovingTo(targetPos.x, targetPos.y, targetPos.z, 1.0);
                        }
                    }
                }
            }
        }
    }

    private static class IdleInGroupsGoal extends WanderAroundGoal {
        private final TenebrousNibblerEntity nibbler;
        private int idleTime;
        private static final int BOB_TIMER_MAX = 20;
        private int bobTimer;
        public IdleInGroupsGoal(TenebrousNibblerEntity nibbler, double speed) {
            super(nibbler, speed);
            this.nibbler = nibbler;
            this.idleTime = 0;
        }

        @Override
        public boolean canStart() {return !this.nibbler.isAttacking() && super.canStart();}
        @Override
        public boolean shouldContinue() {return !this.nibbler.isAttacking() && super.shouldContinue();}
        @Override
        public void start() {super.start(); this.idleTime = 0;}
        @Override
        public void stop() {super.stop(); this.idleTime = 0;}

        @Override
        public void tick() {
            super.tick();
            if (!this.nibbler.isAttacking()) {
                if (this.idleTime <= 0) {
                    this.idleTime = this.nibbler.getRandom().nextInt(200) + 100;
                    this.bobTimer = this.nibbler.getRandom().nextInt(BOB_TIMER_MAX);
                    List<TenebrousNibblerEntity> groupMembers = this.nibbler.getGroupMembers();
                    for (TenebrousNibblerEntity groupMember : groupMembers) {
                        BlockPos wanderPos = this.nibbler.getBlockPos().add(this.nibbler.getRandom().nextInt(10) - 5, 0, this.nibbler.getRandom().nextInt(10) - 5);
                        groupMember.getNavigation().startMovingTo(wanderPos.getX(), wanderPos.getY(), wanderPos.getZ(), 1.0);
                    }
                } else {
                    --this.idleTime;
                    if (this.bobTimer > 0) {
                        double yOffset = Math.sin(Math.PI * this.bobTimer / BOB_TIMER_MAX) * 0.2;
                        this.nibbler.setPos(this.nibbler.getX(), this.nibbler.getY() + yOffset, this.nibbler.getZ());
                        this.bobTimer--;
                    }
                }
            }
        }

        @Override
        protected Vec3d getWanderTarget() {
            BlockPos blockPos = this.mob.getBlockPos();
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            for (int i = 0; i < 3; ++i) {
                int j = this.nibbler.getRandom().nextInt(10) - 5;
                int k = this.nibbler.getRandom().nextInt(10) - 5;
                int l = this.nibbler.getRandom().nextInt(10) - 5;
                mutable.set(blockPos.getX() + j, blockPos.getY() + k, blockPos.getZ() + l);
                if (!this.nibbler.getNavigation().isValidPosition(mutable)) {
                    return new Vec3d(mutable.getX(), mutable.getY(), mutable.getZ());
                }
            }
            return super.getWanderTarget();
        }
    }
}