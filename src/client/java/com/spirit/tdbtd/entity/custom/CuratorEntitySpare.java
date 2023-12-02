package com.spirit.tdbtd.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.WardenAngerManager;
import net.minecraft.entity.ai.brain.task.SonicBoomTask;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.Vibrations;
import net.minecraft.world.event.listener.EntityGameEventHandler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.UUID;

public class CuratorEntitySpare extends HostileEntity implements Angerable {

    private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
    private static final EntityAttributeModifier ATTACKING_SPEED_BOOST = new EntityAttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", 0.0003, EntityAttributeModifier.Operation.ADDITION);
    private static final UniformIntProvider ANGRY_SOUND_DELAY_RANGE = TimeHelper.betweenSeconds(0, 1);
    private int angrySoundDelay;
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    private int angerTime;
    private static final int field_30524 = 10;
    private static final UniformIntProvider ANGER_PASSING_COOLDOWN_RANGE = TimeHelper.betweenSeconds(4, 6);
    private int angerPassingCooldown;


    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public CuratorEntitySpare(EntityType<CuratorEntitySpare> entityType, World world) {
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

    private final WardenAngerManager angerManager = new WardenAngerManager(this::isValidTarget, Collections.emptyList());

    public CuratorEntitySpare(EntityType<CuratorEntitySpare> entityType, World world, EntityGameEventHandler<Vibrations.VibrationListener> gameEventHandler) {
        super(entityType, world);
    }

    @Contract(value = "null->false")
    public boolean isValidTarget(@Nullable Entity entity) {
        if (!(entity instanceof LivingEntity livingEntity)) return false;
        if (this.getWorld() != ((LivingEntity) entity).getWorld()) return false;
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity)) return false;
        if (this.isTeammate(entity)) return false;
        if (livingEntity.getType() == EntityType.ARMOR_STAND) return false;
        if (livingEntity.getType() == EntityType.WARDEN) return false;
        if (livingEntity.isInvulnerable()) return false;
        if (livingEntity.isDead()) return false;
        if (!this.getWorld().getWorldBorder().contains(livingEntity.getBoundingBox())) return false;
        return true;
    }

    public boolean occludeVibrationSignals() {
        return true;
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return 0.0f;
    }


    @Override
    protected boolean canStartRiding(Entity entity) {
        return false;
    }

    @Override
    public boolean disablesShield() {
        return true;
    }

    @Override
    @Nullable
    protected SoundEvent getAmbientSound() {
        return this.hasAngerTime() ? SoundEvents.ENTITY_WARDEN_ANGRY : SoundEvents.ENTITY_WARDEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        this.playSound(SoundEvents.ENTITY_WARDEN_HURT, 10f, 1.2f);
        return SoundEvents.ENTITY_HOSTILE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WARDEN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_SCULK_BREAK, 10.0f, 1.2f);
    }

    @Override
    public boolean tryAttack(Entity target) {
        this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_ATTACK_SOUND);
        this.playSound(SoundEvents.ENTITY_WARDEN_ATTACK_IMPACT, 10.0f, 1.5f);
        SonicBoomTask.cooldown(this, 40);
        return super.tryAttack(target);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.6f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, -0.6)
                .add(EntityAttributes.GENERIC_ARMOR, 16)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 100)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 0.6, false));
        this.goalSelector.add(3, new BreatheAirGoal(this));
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new RevengeGoal(this));
        this.goalSelector.add(4, new AvoidSunlightGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));

        this.targetSelector.add(3, new UniversalAngerGoal<CuratorEntitySpare>(this, true));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]).setGroupRevenge(new Class[0]));



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


    private void tickAngrySound() {
        if (this.angrySoundDelay > 0) {
            --this.angrySoundDelay;
            if (this.angrySoundDelay == 0) {
                this.playAngrySound();
            }
        }
    }

    private void tickAngerPassing() {
        if (this.angerPassingCooldown > 0) {
            --this.angerPassingCooldown;
            return;
        }
        if (this.getVisibilityCache().canSee(this.getTarget())) {
            this.angerNearbyCurator();
        }
        this.angerPassingCooldown = ANGER_PASSING_COOLDOWN_RANGE.get(this.random);
    }

    private void angerNearbyCurator() {
        double d = this.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
        Box box = Box.from(this.getPos()).expand(d, 10.0, d);
        this.getWorld().getEntitiesByClass(CuratorEntitySpare.class, box, EntityPredicates.EXCEPT_SPECTATOR).stream().filter(curator -> curator != this).filter(curator -> curator.getTarget() == null).filter(curator -> !curator.isTeammate(this.getTarget())).forEach(curator -> curator.setTarget(this.getTarget()));
    }

    private void playAngrySound() {
        this.playSound(SoundEvents.ENTITY_WARDEN_ANGRY, this.getSoundVolume() * 20.0f, this.getSoundPitch() * 1.8f);
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        if (this.getTarget() == null && target != null) {
            this.angrySoundDelay = ANGRY_SOUND_DELAY_RANGE.get(this.random);
            this.angerPassingCooldown = ANGER_PASSING_COOLDOWN_RANGE.get(this.random);
        }
        if (target instanceof PlayerEntity) {
            this.setAttacking((PlayerEntity)target);
        }
        super.setTarget(target);
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }



    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        this.writeAngerToNbt(nbt);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.readAngerFromNbt(this.getWorld(), nbt);
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.angerTime = angerTime;
    }

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return null;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
    }

}
