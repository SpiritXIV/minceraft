package com.spirit.shit.entity.ai.goal;

import com.spirit.shit.entity.custom.RatBombEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.CreeperEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class RatBombIgniteGoal extends Goal {
    private final RatBombEntity ratbomb;
    @Nullable
    private LivingEntity target;

    public RatBombIgniteGoal(RatBombEntity ratbomb) {
        this.ratbomb = ratbomb;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    @Override
    public boolean canStart() {
        LivingEntity livingEntity = this.ratbomb.getTarget();
        return this.ratbomb.getFuseSpeed() > 0 || livingEntity != null && this.ratbomb.squaredDistanceTo(livingEntity) < 9.0;
    }

    @Override
    public void start() {
        this.ratbomb.getNavigation().stop();
        this.target = this.ratbomb.getTarget();
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
        if (this.target == null) {
            this.ratbomb.setFuseSpeed(-1);
            return;
        }
        if (this.ratbomb.squaredDistanceTo(this.target) > 49.0) {
            this.ratbomb.setFuseSpeed(-1);
            return;
        }
        if (!this.ratbomb.getVisibilityCache().canSee(this.target)) {
            this.ratbomb.setFuseSpeed(-1);
            return;
        }
        this.ratbomb.setFuseSpeed(1);
    }
}
