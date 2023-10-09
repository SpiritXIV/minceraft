package com.spirit.shit.entity.custom.vehicle;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class TankEntity extends BoatEntity implements GeoEntity {
    private static final float TANK_ACCELERATION = 0.05f;
    private static final float TANK_DECELERATION = 0.02f;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public TankEntity(EntityType<? extends TankEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();

        // Handle tank movement and control
        if (this.hasPassenger()) {
            PlayerEntity rider = (PlayerEntity) this.getPassengerList().get(0);

            if (rider != null) {
                handleTankControl(rider);
            }
        }
    }

    private void handleTankControl(PlayerEntity rider) {
        // Handle tank movement controls
        boolean isForwardPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_W);
        boolean isBackwardPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_S);
        boolean isLeftPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_A);
        boolean isRightPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_D);

        if (isForwardPressed) {
            // Accelerate tank forward
            this.setVelocity(TANK_ACCELERATION, 0, 0);
        } else if (isBackwardPressed) {
            // Reverse tank
            this.setVelocity(-TANK_ACCELERATION, 0, 0);
        } else {
            // Decelerate gradually when not moving
            double currentXVelocity = this.getVelocity().x;
            if (currentXVelocity > 0) {
                this.setVelocity(Math.max(currentXVelocity - TANK_DECELERATION, 0), 0, 0);
            } else if (currentXVelocity < 0) {
                this.setVelocity(Math.min(currentXVelocity + TANK_DECELERATION, 0), 0, 0);
            }
        }

        // Handle tank rotation controls
        if (isLeftPressed) {
            // Rotate tank left
            this.setYaw(this.getYaw() + 2.0f);
        } else if (isRightPressed) {
            // Rotate tank right
            this.setYaw(this.getYaw() - 2.0f);
        }

        // Handle tank special action (e.g., shooting, deploying, etc.) with isSpacePressed

        // You can add more tank-specific behavior here
    }


    private boolean hasPassenger () {
        return !this.getPassengerList().isEmpty();
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState< T > event) {


        if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().then("animation.crop_duster.move", Animation.LoopType.LOOP));
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