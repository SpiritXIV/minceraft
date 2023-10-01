package com.spirit.shit.entity.custom.vehicle;

import com.spirit.shit.ShitMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

@SuppressWarnings("unused")
public class CropDusterEntity extends BoatEntity implements GeoEntity {


    public static float modelYaw;
    public static float modelPitch;
    public static float modelRoll;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final TrackedData<Boolean> FLYING = DataTracker.registerData(CropDusterEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private float currentSpeed;
    private final float pitch = 0.0f;
    private final float roll = 0.0f;

    private double waterLevel;
    private float nearbySlipperiness;
    private Location location;
    private Location lastLocation;
    private float yawVelocity;
    private double movesY;

    public CropDusterEntity(EntityType<? extends BoatEntity> entityType, World world) {
            super(entityType, world);
        }
        private static final float MAX_GROUND_SPEED = 1f;

        @Override
        protected void initDataTracker() {
            super.initDataTracker();
            this.getDataTracker().startTracking(FLYING, false);
        }

        public void setFlying(boolean isFlying) {
            this.getDataTracker().set(FLYING, isFlying);
        }

        public boolean isFlying(boolean b) {
            return this.getDataTracker().get(FLYING);
        }

        @Override
        public void tick() {
            super.tick();

            if (this.hasPassenger()) {
                PlayerEntity rider = (PlayerEntity) this.getPassengerList().get(0);

                if (rider != null) {
                    if (isFlying(false)) {
                        handleFlyingControl(rider);
                    } else {
                        handleGroundControl(rider);
                    }
                }
            }
        }

        private boolean FlyingYayorNae() {
            if (this.isOnGround()) {
                ShitMod.LOGGER.info("flying: false");
                return this.isFlying(false);
            }
            ShitMod.LOGGER.info("flying: true");
            return this.isFlying(true);
        }

        private void handleFlyingControl(PlayerEntity rider) {
            // Handle flying behavior (as before)
            if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_W)) {
                ShitMod.LOGGER.info("wwwwwwwwwwww");
                this.setVelocity(this.getVelocity().x, /*this.getVelocity().y +*/ 0, this.getVelocity().z);
                setFlying(true);
            }
            // Handle other flying controls as needed
        }

    private void handleGroundControl(PlayerEntity rider) {
        // Handle grounded behavior (move on the ground)
        double riderYaw = rider.getYaw();
        float forwardSpeed = 0.0f;
        float sidewaysSpeed = 0.0f;

        // Check for player input and adjust speed accordingly
        if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_W)) {
            ShitMod.LOGGER.info("wwwwwwwwwwww");
            this.setVelocity(this.getVelocity().x, /*this.getVelocity().y +*/ 0, this.getVelocity().z);
            forwardSpeed = MAX_GROUND_SPEED;
            setFlying(false);
        }
        if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_SPACE)) {
            ShitMod.LOGGER.info("space");
            movesY = 0.1;
            this.setVelocity(this.getVelocity().x, this.getVelocity().y + 0.1, this.getVelocity().z);
            forwardSpeed = MAX_GROUND_SPEED;
            setFlying(false);
        }
        if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_SPACE)) {
            ShitMod.LOGGER.info("no longer space");
            movesY = 0;
        }

        double moveY = this.movesY;
        // Calculate the movement vector based on rider's input
        double moveX = -Math.sin(Math.toRadians(riderYaw)) * forwardSpeed + Math.cos(Math.toRadians(riderYaw)) * sidewaysSpeed;
        double moveZ = Math.cos(Math.toRadians(riderYaw)) * forwardSpeed + Math.sin(Math.toRadians(riderYaw)) * sidewaysSpeed;

        // Apply the movement vector to the entity
        this.setVelocity(moveX, moveY, moveZ);
    }

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
            } else {
                event.getController().setAnimation(RawAnimation.begin().then("animation.crop_duster.off", Animation.LoopType.LOOP));
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
