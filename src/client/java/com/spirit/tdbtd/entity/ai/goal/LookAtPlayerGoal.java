package com.spirit.tdbtd.entity.ai.goal;

import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class LookAtPlayerGoal extends Goal {
    private final AperturenteethEntity entity;

    public LookAtPlayerGoal(AperturenteethEntity entity) {
        this.entity = entity;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        return !this.entity.isAttacking() && this.entity.getTarget() != null && this.entity.getTarget() instanceof PlayerEntity;
    }

    @Override
    public void start() {
        this.entity.getNavigation().stop();
        this.entity.setAttacking(true);
    }

    @Override
    public void tick() {
        Entity target = this.entity.getTarget();
        if (target instanceof PlayerEntity player && this.entity.canSee(target)) {
            if (player.isSneaking()) {
                this.entity.setAttacking(false);
            } else {
                this.entity.lookAtEntity();
                if (this.entity.squaredDistanceTo(player) < 2.0 * 2.0) {
                    this.entity.tryAttack(player);
                }
            }
        } else {
            this.entity.setAttacking(false);
        }
    }

    @Override
    public void stop() {
        this.entity.setAttacking(false);
    }
}
