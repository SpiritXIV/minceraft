package com.spirit.shit.entity.custom.vehicle;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class CropDusterEntity extends BoatEntity implements GeoEntity {


    private double x;
    private double y;
    private double z;
    public static float modelYaw;
    public static float modelPitch;
    private int interpolationStepsRemaining;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final TrackedData<Boolean> FLYING = DataTracker.registerData(CropDusterEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private float currentSpeed;
    private double movesY;

    public CropDusterEntity(EntityType<? extends BoatEntity> entityType, World world) {
            super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.getDataTracker().startTracking(FLYING, false);
    }

    public void setFlying(boolean isFlying) {
            this.getDataTracker().set(FLYING, isFlying);
        }

    public boolean isFlying() {
            return this.getDataTracker().get(FLYING);
        }

    // Was identical to super method.

    public boolean isPushable() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        this.updatePositionAndRotation();
        if (this.hasPassenger()) {
            PlayerEntity rider = (PlayerEntity) this.getPassengerList().get(0);

            if (rider != null) {
                if (isFlying()) {
                    handleFlyingControl();
                } else {
                    handleGroundControl(rider); // I would like to commend you for using an actual variable name that makes sense
                }
            }
        }
    }

    private void handleFlyingControl() {
        // Handle flying behavior (as before)
        if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_W)) {
            this.setVelocity(this.getVelocity().x, /*this.getVelocity().y +*/ 0, this.getVelocity().z);
            setFlying(true);
        }
            // Handle other flying controls as needed
    }

    private void handleGroundControl(PlayerEntity rider) {
        double riderYaw = rider.getYaw();
        float accelerationFactor = 0.02f; // These were changed to floats to remove casts in subsequent usages.
        float decelerationFactor = 0.01f;

        boolean isWPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_W);
        boolean isSPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_S);
        boolean isSpacePressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_SPACE);

        boolean canRotate = false; // Flag to allow rotation

        if (isWPressed || isSPressed) {
            // Accelerate forward speed or decelerate when 'W' or 'S' is pressed
            // BTW Spirit this is a ternary if operation, to illustrate its components:
            // If {condition} ?(? = if true then) {If True} :(: = else) {Else}
            currentSpeed += (isWPressed ? accelerationFactor : -decelerationFactor);
            canRotate = true; // Allow rotation when moving forward or backward
        } else {
            // Decelerate gradually when neither 'W' nor 'S' is pressed
            currentSpeed -= decelerationFactor;
            currentSpeed = Math.max(currentSpeed, 0.0f); // Ensure speed doesn't go negative
        }

        if (isWPressed && isSpacePressed) {
            movesY = 0.1;
        } else if (this.isOnGround() && !isSpacePressed) {
            movesY = 0;
        } else if (!this.isOnGround() && !isSpacePressed) {
            movesY = 0.1;
        }

        if (isSPressed && isSpacePressed) {
            movesY = -0.1;
        } else if (this.isOnGround() && !isSpacePressed) {
            movesY = 0;
        } else if (!this.isOnGround() && !isSpacePressed) {
            movesY = -0.02;
        }

        double moveY = this.movesY;
        double moveX = -Math.sin(Math.toRadians(riderYaw)) * currentSpeed;
        double moveZ = Math.cos(Math.toRadians(riderYaw)) * currentSpeed;

        this.setVelocity(moveX, moveY, moveZ);

        // Restrict rotation when not moving forward or backward or in the air
        if (!canRotate || this.isOnGround()) {
            this.setYaw((float) riderYaw);
        }
    }


    public void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate) {
        this.x = x;
        this.y = y;
        this.z = z;
        modelYaw = yaw;
        modelPitch = pitch;
        this.interpolationStepsRemaining = 10;
    }

    // Was identical to super method.


    private void updatePositionAndRotation() {
        if (this.isLogicalSideForUpdatingMovement()) {
            this.interpolationStepsRemaining = 0;
            this.updateTrackedPosition(this.getX(), this.getY(), this.getZ());
        } else if (this.interpolationStepsRemaining > 0) {
            double newX = this.getX() + (this.x - this.getX()) / (double)this.interpolationStepsRemaining;
            double newY = this.getY() + (this.y - this.getY()) / (double)this.interpolationStepsRemaining;
            double newZ = this.getZ() + (this.z - this.getZ()) / (double)this.interpolationStepsRemaining;

            float g = MathHelper.wrapDegrees(modelYaw - this.getYaw());
            this.setYaw(this.getYaw() + g / (float)this.interpolationStepsRemaining);
            this.setPitch(this.getPitch() + (float)(modelPitch - (double)this.getPitch()) / (float)this.interpolationStepsRemaining);

            --this.interpolationStepsRemaining;
            this.setPosition(newX, newY, newZ);
            this.setRotation(this.getYaw(), this.getPitch());
        }
    }

    // Was identical to super method.

    // Was identical to super method.


    private boolean hasPassenger () {
            return !this.getPassengerList().isEmpty();
    }
    protected void writeCustomDataToNbt (NbtCompound nbt){
        nbt.putString("Type", this.getVariant().asString());
    }
    protected void readCustomDataFromNbt (NbtCompound nbt){
            nbt.contains("Type", 0);
        }

    private <T extends GeoAnimatable > PlayState predicate(AnimationState < T > event) {


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
}
