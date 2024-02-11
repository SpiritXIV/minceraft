package com.spirit.tdbtd.entity.ai.goal;

import com.spirit.tdbtd.entity.custom.CuratorEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

public class StalkingGoal extends MeleeAttackGoal {
    private final CuratorEntity curator;
    private double speed;

    public StalkingGoal(CuratorEntity curator, double speed, boolean pauseWhenMobIdle) {
        super(curator, speed, pauseWhenMobIdle);
        this.curator = curator;
    }

    @Override
    public void start() {
        super.start();
        this.curator.setAttacking(true);
    }

    @Override
    public void stop() {
        super.stop();
        this.curator.setAttacking(false);
    }

    @Override
    public void tick() {
        LivingEntity target = this.curator.getTarget();
        if (target != null) {
            Vec3d targetPos = target.getPos();
            double distance = this.curator.squaredDistanceTo(targetPos.getX(), targetPos.getY(), targetPos.getZ());

            if (distance <= 25.0D) { // 5 blocks squared
                // Move slowly towards the player
                this.curator.getNavigation().startMovingTo(target, this.speed);
            } else {
                // Player is too far, stop moving
                this.curator.getNavigation().stop();
            }
        }

        // Check if the player is making sound
        if (this.curator.isInEarsTwitchPose() && this.curator.getSoundPitch() > 0.0F) {
            // Player is making sound, initiate attack
            this.curator.tryAttack(target);
        }

        // Play a sound effect to indicate stalking behavior
        this.curator.playSound(SoundEvents.ENTITY_WARDEN_ROAR, 1.0F, this.curator.getSoundPitch());
    }
}
