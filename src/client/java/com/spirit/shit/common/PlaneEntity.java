package com.spirit.shit.common;

import com.google.common.collect.Lists;

import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Dismounting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockLocating;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class PlaneEntity extends Entity implements GeoEntity {
    private static final TrackedData<Integer> DAMAGE_WOBBLE_TICKS;
    private static final TrackedData<Integer> DAMAGE_WOBBLE_SIDE;
    private static final TrackedData<Float> DAMAGE_WOBBLE_STRENGTH;
    private static final TrackedData<Integer> BUBBLE_WOBBLE_TICKS;
    private float ticksUnderwater;
    private float yawVelocity;
    private int interpolationStepsRemaining;
    private double x;
    private double y;
    private double z;
    private double boatYaw;
    private double boatPitch;
    private double waterLevel;
    private float nearbySlipperiness;
    private Location location;
    private Location lastLocation;
    private double fallVelocity;
    private boolean onBubbleColumnSurface;
    private boolean bubbleColumnIsDrag;
    private float bubbleWobbleStrength;
    private static final TrackedData<Boolean> FLYING = DataTracker.registerData(PlaneEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public PlaneEntity(EntityType entityType, World world) {
        super(entityType, world);
        this.intersectionChecked = true;
    }

    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height;
    }

    protected Entity.MoveEffect getMoveEffect() {
        return MoveEffect.EVENTS;
    }

    protected void initDataTracker() {
        this.dataTracker.startTracking(DAMAGE_WOBBLE_TICKS, 0);
        this.dataTracker.startTracking(DAMAGE_WOBBLE_SIDE, 1);
        this.dataTracker.startTracking(DAMAGE_WOBBLE_STRENGTH, 0.0F);
        this.dataTracker.startTracking(BUBBLE_WOBBLE_TICKS, 0);
        this.getDataTracker().startTracking(FLYING, false);
    }

    public boolean collidesWith(Entity other) {
        return canCollide(this, other);
    }

    public static boolean canCollide(Entity entity, Entity other) {
        return (other.isCollidable() || other.isPushable()) && !entity.isConnectedThroughVehicle(other);
    }

    public boolean isCollidable() {
        return true;
    }

    protected Vec3d positionInPortal(Direction.Axis portalAxis, BlockLocating.Rectangle portalRect) {
        return LivingEntity.positionInPortal(super.positionInPortal(portalAxis, portalRect));
    }

    public double getMountedHeightOffset() {
        return -0.1;
    }

    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.getWorld().isClient && !this.isRemoved()) {
            this.setDamageWobbleSide(-this.getDamageWobbleSide());
            this.setDamageWobbleTicks(10);
            this.setDamageWobbleStrength(this.getDamageWobbleStrength() + amount * 10.0F);
            this.scheduleVelocityUpdate();
            this.emitGameEvent(GameEvent.ENTITY_DAMAGE, source.getAttacker());
            boolean bl = source.getAttacker() instanceof PlayerEntity && ((PlayerEntity)source.getAttacker()).getAbilities().creativeMode;
            if (bl || this.getDamageWobbleStrength() > 40.0F) {
                if (!bl && this.getWorld().getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                    this.dropItems(source);
                }

                this.discard();
            }

            return true;
        } else {
            return true;
        }
    }

    protected void dropItems(DamageSource source) {
        this.dropItem(this.asItem());
    }

    public void onBubbleColumnSurfaceCollision(boolean drag) {
        if (!this.getWorld().isClient) {
            this.onBubbleColumnSurface = true;
            this.bubbleColumnIsDrag = drag;
            if (this.getBubbleWobbleTicks() == 0) {
                this.setBubbleWobbleTicks(60);
            }
        }

        this.getWorld().addParticle(ParticleTypes.SPLASH, this.getX() + (double)this.random.nextFloat(), this.getY() + 0.7, this.getZ() + (double)this.random.nextFloat(), 0.0, 0.0, 0.0);
        if (this.random.nextInt(20) == 0) {
            this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), this.getSplashSound(), this.getSoundCategory(), 1.0F, 0.8F + 0.4F * this.random.nextFloat(), false);
            this.emitGameEvent(GameEvent.SPLASH, this.getControllingPassenger());
        }

    }

    public void pushAwayFrom(Entity entity) {
        if (entity instanceof PlaneEntity) {
            if (entity.getBoundingBox().minY < this.getBoundingBox().maxY) {
                super.pushAwayFrom(entity);
            }
        } else if (entity.getBoundingBox().minY <= this.getBoundingBox().minY) {
            super.pushAwayFrom(entity);
        }

    }

    public Item asItem() {
        return Items.AIR.asItem();
    }

    public void animateDamage(float yaw) {
        this.setDamageWobbleSide(-this.getDamageWobbleSide());
        this.setDamageWobbleTicks(10);
        this.setDamageWobbleStrength(this.getDamageWobbleStrength() * 11.0F);
    }

    public boolean canHit() {
        return !this.isRemoved();
    }

    public void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.boatYaw = yaw;
        this.boatPitch = pitch;
        this.interpolationStepsRemaining = 10;
    }

    public Direction getMovementDirection() {
        return this.getHorizontalFacing().rotateYClockwise();
    }

    public void tick() {
        this.lastLocation = this.location;
        this.location = this.checkLocation();
        if (this.location != PlaneEntity.Location.UNDER_WATER && this.location != PlaneEntity.Location.UNDER_FLOWING_WATER) {
            this.ticksUnderwater = 0.0F;
        } else {
            ++this.ticksUnderwater;
        }

        if (!this.getWorld().isClient && this.ticksUnderwater >= 60.0F) {
            this.removeAllPassengers();
        }

        if (this.getDamageWobbleTicks() > 0) {
            this.setDamageWobbleTicks(this.getDamageWobbleTicks() - 1);
        }

        if (this.getDamageWobbleStrength() > 0.0F) {
            this.setDamageWobbleStrength(this.getDamageWobbleStrength() - 1.0F);
        }

        super.tick();
        this.updatePositionAndRotation();
        if (this.isLogicalSideForUpdatingMovement()) {
            this.updateVelocity();

            this.move(MovementType.SELF, this.getVelocity());
        } else {
            this.setVelocity(Vec3d.ZERO);
        }

        this.handleBubbleColumn();

        this.checkBlockCollision();
        List<Entity> list = this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(0.20000000298023224, -0.009999999776482582, 0.20000000298023224), EntityPredicates.canBePushedBy(this));
        if (!list.isEmpty()) {
            boolean bl = !this.getWorld().isClient && !(this.getControllingPassenger() instanceof PlayerEntity);

            for (Entity entity : list) {
                if (!entity.hasPassenger(this)) {
                    if (bl && this.getPassengerList().size() < this.getMaxPassengers() && !entity.hasVehicle() && this.isSmallerThanBoat(entity) && entity instanceof LivingEntity && !(entity instanceof WaterCreatureEntity) && !(entity instanceof PlayerEntity)) {
                        entity.startRiding(this);
                    } else {
                        this.pushAwayFrom(entity);
                    }
                }
            }
        }
    }

    private void handleBubbleColumn() {
        int i;
        if (this.getWorld().isClient) {
            i = this.getBubbleWobbleTicks();
            if (i > 0) {
                this.bubbleWobbleStrength += 0.05F;
            } else {
                this.bubbleWobbleStrength -= 0.1F;
            }

            this.bubbleWobbleStrength = MathHelper.clamp(this.bubbleWobbleStrength, 0.0F, 1.0F);
        } else {
            if (!this.onBubbleColumnSurface) {
                this.setBubbleWobbleTicks(0);
            }

            i = this.getBubbleWobbleTicks();
            if (i > 0) {
                --i;
                this.setBubbleWobbleTicks(i);
                int j = 60 - i - 1;
                if (j > 0 && i == 0) {
                    this.setBubbleWobbleTicks(0);
                    Vec3d vec3d = this.getVelocity();
                    if (this.bubbleColumnIsDrag) {
                        this.setVelocity(vec3d.add(0.0, -0.7, 0.0));
                        this.removeAllPassengers();
                    } else {
                        this.setVelocity(vec3d.x, this.hasPassenger((entity) -> entity instanceof PlayerEntity) ? 2.7 : 0.6, vec3d.z);
                    }
                }

                this.onBubbleColumnSurface = false;
            }
        }

    }

    private void updatePositionAndRotation() {
        if (this.isLogicalSideForUpdatingMovement()) {
            this.interpolationStepsRemaining = 0;
            this.updateTrackedPosition(this.getX(), this.getY(), this.getZ());
        } else if (this.interpolationStepsRemaining > 0) {
            double newX = this.getX() + (this.x - this.getX()) / this.interpolationStepsRemaining;
            double newY = this.getY() + (this.y - this.getY()) / this.interpolationStepsRemaining;
            double newZ = this.getZ() + (this.z - this.getZ()) / this.interpolationStepsRemaining;

            float boatYawDifference = (float) MathHelper.wrapDegrees(boatYaw - this.getYaw());
            this.setYaw(this.getYaw() + boatYawDifference / this.interpolationStepsRemaining);
            this.setPitch(this.getPitch() + (float)(boatPitch - this.getPitch()) / this.interpolationStepsRemaining);

            --this.interpolationStepsRemaining;
            this.setPosition(newX, newY, newZ);
            this.setRotation(this.getYaw(), this.getPitch());
        }
    }

    private Location checkLocation() {
        Location location = this.getUnderWaterLocation();
        if (location != null) {
            this.waterLevel = this.getBoundingBox().maxY;
            return location;
        } else if (this.checkBoatInWater()) {
            return PlaneEntity.Location.IN_WATER;
        } else {
            float f = this.getNearbySlipperiness();
            if (f > 0.0F) {
                this.nearbySlipperiness = f;
                return PlaneEntity.Location.ON_LAND;
            } else {
                return PlaneEntity.Location.IN_AIR;
            }
        }
    }

    public float getWaterHeightBelow() {
        Box box = this.getBoundingBox();
        int i = MathHelper.floor(box.minX);
        int j = MathHelper.ceil(box.maxX);
        int k = MathHelper.floor(box.maxY);
        int l = MathHelper.ceil(box.maxY - this.fallVelocity);
        int m = MathHelper.floor(box.minZ);
        int n = MathHelper.ceil(box.maxZ);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        label39:
        for(int o = k; o < l; ++o) {
            float f = 0.0F;

            for(int p = i; p < j; ++p) {
                for(int q = m; q < n; ++q) {
                    mutable.set(p, o, q);
                    FluidState fluidState = this.getWorld().getFluidState(mutable);
                    if (fluidState.isIn(FluidTags.WATER)) {
                        f = Math.max(f, fluidState.getHeight(this.getWorld(), mutable));
                    }

                    if (f >= 1.0F) {
                        continue label39;
                    }
                }
            }

            if (f < 1.0F) {
                return (float)mutable.getY() + f;
            }
        }

        return (float)(l + 1);
    }

    public float getNearbySlipperiness() {
        Box box = this.getBoundingBox();
        Box box2 = new Box(box.minX, box.minY - 0.001, box.minZ, box.maxX, box.minY, box.maxZ);
        int i = MathHelper.floor(box2.minX) - 1;
        int j = MathHelper.ceil(box2.maxX) + 1;
        int k = MathHelper.floor(box2.minY) - 1;
        int l = MathHelper.ceil(box2.maxY) + 1;
        int m = MathHelper.floor(box2.minZ) - 1;
        int n = MathHelper.ceil(box2.maxZ) + 1;
        VoxelShape voxelShape = VoxelShapes.cuboid(box2);
        float f = 0.0F;
        int o = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int p = i; p < j; ++p) {
            for(int q = m; q < n; ++q) {
                int r = (p != i && p != j - 1 ? 0 : 1) + (q != m && q != n - 1 ? 0 : 1);
                if (r != 2) {
                    for(int s = k; s < l; ++s) {
                        if (r <= 0 || s != k && s != l - 1) {
                            mutable.set(p, s, q);
                            BlockState blockState = this.getWorld().getBlockState(mutable);
                            if (!(blockState.getBlock() instanceof LilyPadBlock) && VoxelShapes.matchesAnywhere(blockState.getCollisionShape(this.getWorld(), mutable).offset(p, s, q), voxelShape, BooleanBiFunction.AND)) {
                                f += blockState.getBlock().getSlipperiness();
                                ++o;
                            }
                        }
                    }
                }
            }
        }

        return f / (float)o;
    }

    private boolean checkBoatInWater() {
        Box box = this.getBoundingBox();
        int i = MathHelper.floor(box.minX);
        int j = MathHelper.ceil(box.maxX);
        int k = MathHelper.floor(box.minY);
        int l = MathHelper.ceil(box.minY + 0.001);
        int m = MathHelper.floor(box.minZ);
        int n = MathHelper.ceil(box.maxZ);
        boolean inWater = false;
        this.waterLevel = -1.7976931348623157E308; // Magic number.
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int o = i; o < j; ++o) {
            for(int p = k; p < l; ++p) {
                for(int q = m; q < n; ++q) {// Nested loops for the whole things bounding box
                    mutable.set(o, p, q);
                    FluidState fluidState = this.getWorld().getFluidState(mutable);
                    if (fluidState.isIn(FluidTags.WATER)) {
                        float f = (float)p + fluidState.getHeight(this.getWorld(), mutable);
                        this.waterLevel = Math.max(f, this.waterLevel);
                        inWater |= box.minY < (double)f;
                    }
                }
            }
        }

        return inWater;
    }

    @Nullable
    private Location getUnderWaterLocation() {
        Box box = this.getBoundingBox();
        double d = box.maxY + 0.001;
        int boundingBoxXMax = MathHelper.floor(box.minX);
        int boundingBoxXMin = MathHelper.ceil(box.maxX);
        int boundingBoxYMax = MathHelper.floor(box.maxY);
        int boundingBoxYMin = MathHelper.ceil(d);
        int boundingBoxZMax = MathHelper.floor(box.minZ);
        int boundingBoxZMin = MathHelper.ceil(box.maxZ);
        boolean isUnderwater = false;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int boundingBoxIteratorX = boundingBoxXMax; boundingBoxIteratorX < boundingBoxXMin; ++boundingBoxIteratorX) {
            for(int boundingBoxIteratorY = boundingBoxYMax; boundingBoxIteratorY < boundingBoxYMin; ++boundingBoxIteratorY) {
                for(int boundingBoxIteratorZ = boundingBoxZMax; boundingBoxIteratorZ < boundingBoxZMin; ++boundingBoxIteratorZ) {// Nested loops for the whole things bounding box
                    mutable.set(boundingBoxIteratorX, boundingBoxIteratorY, boundingBoxIteratorZ);
                    FluidState fluidState = this.getWorld().getFluidState(mutable);
                    if (fluidState.isIn(FluidTags.WATER) && d < (double)((float)mutable.getY() + fluidState.getHeight(this.getWorld(), mutable))) {
                        if (!fluidState.isStill()) {
                            return PlaneEntity.Location.UNDER_FLOWING_WATER;
                        }

                        isUnderwater = true;
                    }
                }
            }
        }

        return isUnderwater ? PlaneEntity.Location.UNDER_WATER : null;
    }

    private void updateVelocity() {
        double gravityForce = -0.03999999910593033;
        double appliedGravityForce = this.hasNoGravity() ? 0.0 : gravityForce;
        double verticalVelocityModifier = 0.0;
        float velocityDecay = 0.05F;
        if (this.lastLocation == PlaneEntity.Location.IN_AIR && this.location != PlaneEntity.Location.IN_AIR && this.location != PlaneEntity.Location.ON_LAND) {
            this.waterLevel = this.getBodyY(1.0);
            this.setPosition(this.getX(), (double)(this.getWaterHeightBelow() - this.getHeight()) + 0.101, this.getZ());
            this.setVelocity(this.getVelocity().multiply(1.0, 0.0, 1.0));
            this.fallVelocity = 0.0;
            this.location = PlaneEntity.Location.IN_WATER;
        } else {
            if (this.location == PlaneEntity.Location.IN_WATER) {
                verticalVelocityModifier = (this.waterLevel - this.getY()) / (double)this.getHeight();
                velocityDecay = 0.9F;
            } else if (this.location == PlaneEntity.Location.UNDER_FLOWING_WATER) {
                appliedGravityForce = -7.0E-4;
                velocityDecay = 0.9F;
            } else if (this.location == PlaneEntity.Location.UNDER_WATER) {
                verticalVelocityModifier = 0.009999999776482582;
                velocityDecay = 0.45F;
            } else if (this.location == PlaneEntity.Location.IN_AIR) {
                velocityDecay = 0.9F;
            } else if (this.location == PlaneEntity.Location.ON_LAND) {
                velocityDecay = this.nearbySlipperiness;
                if (this.getControllingPassenger() instanceof PlayerEntity) {
                    this.nearbySlipperiness /= 2.0F;
                }
            }

            Vec3d currentVelocity = this.getVelocity();
            this.setVelocity(currentVelocity.x * (double) velocityDecay, currentVelocity.y + appliedGravityForce, currentVelocity.z * (double) velocityDecay);
            this.yawVelocity *= velocityDecay;
            if (verticalVelocityModifier > 0.0) {
                currentVelocity = this.getVelocity();
                this.setVelocity(currentVelocity.x, (currentVelocity.y + verticalVelocityModifier * 0.06153846016296973) * 0.75, currentVelocity.z);
            }
        }
        if (this.getControllingPassenger() instanceof PlayerEntity rider) {
            Vec3d groundControlVelocity = this.computeGroundVelocity(rider, this.getVelocity());
            this.setVelocity(groundControlVelocity);
        }
    }

    private Vec3d computeGroundVelocity(PlayerEntity rider, Vec3d currentVelocity) {
        double riderYaw = rider.getYaw();
        float accelerationFactor = 0.02f;
        float decelerationFactor = 0.01f;

        boolean isWPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_W);
        boolean isSPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_S);
        boolean isSpacePressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_SPACE);

        double moveX = currentVelocity.x;
        double moveZ = currentVelocity.z;
        double moveY;

        if (isWPressed) {
            moveX += -Math.sin(Math.toRadians(riderYaw)) * accelerationFactor;
            moveZ += Math.cos(Math.toRadians(riderYaw)) * accelerationFactor;

            if (isSpacePressed) moveY = 0.1;
            else if (this.isOnGround()) moveY = 0;
            else moveY = 0.1;
        } else if (isSPressed) {
            moveX -= -Math.sin(Math.toRadians(riderYaw)) * decelerationFactor;
            moveZ -= Math.cos(Math.toRadians(riderYaw)) * decelerationFactor;

            if (isSpacePressed) moveY = -0.1;
            else if (this.isOnGround()) moveY = 0;
            else moveY = -0.02;
        } else {
            moveX *= (1 - decelerationFactor);  // Slowly reduce the X and Z velocities if neither W nor S are pressed
            moveZ *= (1 - decelerationFactor);
            moveY = 0; // Default value if neither W or S are pressed
        }

        Vec3d groundControlVelocity = new Vec3d(moveX, moveY, moveZ);

        // Blending the two velocities by taking their average
        double blendX = (currentVelocity.x + groundControlVelocity.x) / 2;
        double blendY = (currentVelocity.y + groundControlVelocity.y) / 2;
        double blendZ = (currentVelocity.z + groundControlVelocity.z) / 2;

        return new Vec3d(blendX, blendY, blendZ);
    }

    protected float getPassengerHorizontalOffset() {
        return 0.0F;
    }

    public boolean isSmallerThanBoat(Entity entity) {
        return entity.getWidth() < this.getWidth();
    }

    protected void updatePassengerPosition(Entity passenger, Entity.PositionUpdater positionUpdater) {
        if (this.hasPassenger(passenger)) {
            float f = this.getPassengerHorizontalOffset();
            float g = (float)((this.isRemoved() ? 0.009999999776482582 : this.getMountedHeightOffset()) + passenger.getHeightOffset());
            if (this.getPassengerList().size() > 1) {
                int i = this.getPassengerList().indexOf(passenger);
                if (i == 0) {
                    f = 0.2F;
                } else {
                    f = -0.6F;
                }

                if (passenger instanceof AnimalEntity) {
                    f += 0.2F;
                }
            }

            Vec3d vec3d = (new Vec3d(f, 0.0, 0.0)).rotateY(-this.getYaw() * 0.017453292F - 1.5707964F);
            positionUpdater.accept(passenger, this.getX() + vec3d.x, this.getY() + (double)g, this.getZ() + vec3d.z);
            passenger.setYaw(passenger.getYaw() + this.yawVelocity);
            passenger.setHeadYaw(passenger.getHeadYaw() + this.yawVelocity);
            this.copyEntityData(passenger);
            if (passenger instanceof AnimalEntity && this.getPassengerList().size() == this.getMaxPassengers()) {
                int j = passenger.getId() % 2 == 0 ? 90 : 270;
                passenger.setBodyYaw(((AnimalEntity)passenger).bodyYaw + (float)j);
                passenger.setHeadYaw(passenger.getHeadYaw() + (float)j);
            }

        }
    }

    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        Vec3d vec3d = getPassengerDismountOffset(this.getWidth() * MathHelper.SQUARE_ROOT_OF_TWO, passenger.getWidth(), passenger.getYaw());
        double d = this.getX() + vec3d.x;
        double e = this.getZ() + vec3d.z;
        BlockPos blockPos = BlockPos.ofFloored(d, this.getBoundingBox().maxY, e);
        BlockPos blockPos2 = blockPos.down();
        if (!this.getWorld().isWater(blockPos2)) {
            List<Vec3d> list = Lists.newArrayList();
            double f = this.getWorld().getDismountHeight(blockPos);
            if (Dismounting.canDismountInBlock(f)) {
                list.add(new Vec3d(d, (double)blockPos.getY() + f, e));
            }

            double g = this.getWorld().getDismountHeight(blockPos2);
            if (Dismounting.canDismountInBlock(g)) {
                list.add(new Vec3d(d, (double)blockPos2.getY() + g, e));
            }

            for (EntityPose entityPose : passenger.getPoses()) {
                for (Vec3d vec3d2 : list) {
                    if (Dismounting.canPlaceEntityAt(this.getWorld(), vec3d2, passenger, entityPose)) {
                        passenger.setPose(entityPose);
                        return vec3d2;
                    }
                }
            }
        }

        return super.updatePassengerForDismount(passenger);
    }

    protected void copyEntityData(Entity entity) {
        entity.setBodyYaw(this.getYaw());
        float f = MathHelper.wrapDegrees(entity.getYaw() - this.getYaw());
        float g = MathHelper.clamp(f, -105.0F, 105.0F);
        entity.prevYaw += g - f;
        entity.setYaw(entity.getYaw() + g - f);
        entity.setHeadYaw(entity.getYaw());
    }

    public void onPassengerLookAround(Entity passenger) {
        this.copyEntityData(passenger);
    }

    protected void writeCustomDataToNbt(NbtCompound nbt) {
        // Empty
    }

    protected void readCustomDataFromNbt(NbtCompound nbt) {
        // Empty
    }

    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (player.shouldCancelInteraction()) {
            return ActionResult.PASS;
        } else if (this.ticksUnderwater < 60.0F) {
            if (!this.getWorld().isClient) {
                return player.startRiding(this) ? ActionResult.CONSUME : ActionResult.PASS;
            } else {
                return ActionResult.SUCCESS;
            }
        } else {
            return ActionResult.PASS;
        }
    }

    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
        this.fallVelocity = this.getVelocity().y;
        if (!this.hasVehicle()) {
            if (onGround) {
                if (this.fallDistance > 3.0F) {
                    if (this.location != PlaneEntity.Location.ON_LAND) {
                        this.onLanding();
                        return;
                    }

                    this.handleFallDamage(this.fallDistance, 1.0F, this.getDamageSources().fall());
                    if (!this.getWorld().isClient && !this.isRemoved()) {
                        this.kill();

                        if (this.getWorld().getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            // Entity drop handling
                        }
                    }
                }

                this.onLanding();
            } else if (!this.getWorld().getFluidState(this.getBlockPos().down()).isIn(FluidTags.WATER) && heightDifference < 0.0) {
                this.fallDistance -= (float)heightDifference;
            }

        }
    }

    public void setDamageWobbleStrength(float wobbleStrength) {
        this.dataTracker.set(DAMAGE_WOBBLE_STRENGTH, wobbleStrength);
    }

    public float getDamageWobbleStrength() {
        return this.dataTracker.get(DAMAGE_WOBBLE_STRENGTH);
    }

    public void setDamageWobbleTicks(int wobbleTicks) {
        this.dataTracker.set(DAMAGE_WOBBLE_TICKS, wobbleTicks);
    }

    public int getDamageWobbleTicks() {
        return this.dataTracker.get(DAMAGE_WOBBLE_TICKS);
    }

    private void setBubbleWobbleTicks(int wobbleTicks) {
        this.dataTracker.set(BUBBLE_WOBBLE_TICKS, wobbleTicks);
    }

    private int getBubbleWobbleTicks() {
        return this.dataTracker.get(BUBBLE_WOBBLE_TICKS);
    }

    public void setDamageWobbleSide(int side) {
        this.dataTracker.set(DAMAGE_WOBBLE_SIDE, side);
    }

    public int getDamageWobbleSide() {
        return this.dataTracker.get(DAMAGE_WOBBLE_SIDE);
    }

    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().size() < this.getMaxPassengers() && !this.isSubmergedIn(FluidTags.WATER);
    }

    protected int getMaxPassengers() {
        return 2;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        Entity var2 = this.getFirstPassenger();
        LivingEntity var10000;
        if (var2 instanceof LivingEntity livingEntity) {
            var10000 = livingEntity;
        } else {
            var10000 = null;
        }

        return var10000;
    }

    public boolean isSubmergedInWater() {
        return this.location == PlaneEntity.Location.UNDER_WATER || this.location == PlaneEntity.Location.UNDER_FLOWING_WATER;
    }
    private boolean hasPassenger () {
        return !this.getPassengerList().isEmpty();
    }

    public ItemStack getPickBlockStack() {
        return new ItemStack(this.asItem());
    }
    private <T extends GeoAnimatable> PlayState predicate(AnimationState< T > event) {
        if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().then("animation.crop_duster.moveon_ground", Animation.LoopType.LOOP));
        }
        if (event.isMoving() && !this.isOnGround()) {
            event.getController().setAnimation(RawAnimation.begin().then("animation.crop_duster.flying", Animation.LoopType.LOOP));
        }
        if (this.hasPassenger()) {
            event.getController().setAnimation(RawAnimation.begin().then("animation.crop_duster.close_doors", Animation.LoopType.PLAY_ONCE).then("animation.crop_duster.idle", Animation.LoopType.LOOP));
        }
        if (!this.hasPassenger()) {
            event.getController().setAnimation(RawAnimation.begin().then("animation.crop_duster.open_doors", Animation.LoopType.PLAY_ONCE).then("animation.crop_duster.off", Animation.LoopType.HOLD_ON_LAST_FRAME));
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers (AnimatableManager.ControllerRegistrar controllerRegistrar){
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache () {
        return cache;
    }

    static {
        DAMAGE_WOBBLE_TICKS = DataTracker.registerData(PlaneEntity.class, TrackedDataHandlerRegistry.INTEGER);
        DAMAGE_WOBBLE_SIDE = DataTracker.registerData(PlaneEntity.class, TrackedDataHandlerRegistry.INTEGER);
        DAMAGE_WOBBLE_STRENGTH = DataTracker.registerData(PlaneEntity.class, TrackedDataHandlerRegistry.FLOAT);
        BUBBLE_WOBBLE_TICKS = DataTracker.registerData(PlaneEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    public enum Location {
        IN_WATER,
        UNDER_WATER,
        UNDER_FLOWING_WATER,
        ON_LAND,
        IN_AIR;

        Location() {
        }
    }
}
