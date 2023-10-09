package com.spirit.shit.entity.ai.goal;

import com.spirit.shit.entity.custom.RatBombEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class RatBombIgniteGoal extends Goal {
    private final RatBombEntity ratBomb;
    @Nullable
    private LivingEntity target;

    public RatBombIgniteGoal(RatBombEntity entity) {
        this.ratBomb = entity;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    @Override
    public boolean canStart() {
        LivingEntity livingEntity = this.ratBomb.getTarget();
        double distanceSquared = this.ratBomb.squaredDistanceTo(livingEntity);
        return this.ratBomb.getFuseSpeed() > 0 || (livingEntity != null && distanceSquared <= 250.0 && this.ratBomb.getVisibilityCache().canSee(this.target));
    }

    @Override
    public void start() {
        this.ratBomb.getNavigation().stop();
        this.target = this.ratBomb.getTarget();
    }

    @Override
    public void stop() {
        this.target = null;
    }

    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        if (this.target == null || this.ratBomb.squaredDistanceTo(this.target) >= 50.0 || !this.ratBomb.getVisibilityCache().canSee(this.target)) {
            this.ratBomb.setFuseSpeed(-1);
        } else {
            this.ratBomb.setFuseSpeed(1);
        }
    }
}