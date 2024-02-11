package com.spirit.tdbtd.entity.ai.goal;

import com.spirit.tdbtd.entity.custom.AperturenteethEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.EnumSet;

public class BuriedAttackGoal extends Goal {
    private final AperturenteethEntity entity;
    private final World world;
    private BlockPos buryPos;
    private int buryCooldown;
    private int buriedTime;

    public BuriedAttackGoal(AperturenteethEntity entity) {
        this.entity = entity;
        this.world = entity.getWorld();
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        return !this.entity.isAttacking() && this.buryCooldown <= 0 && shouldBury();
    }

    private boolean shouldBury() {
        return this.world.getRandom().nextInt(this.world.isNight() ? 150 : 300) == 0
                && this.world.getBlockState(this.entity.getBlockPos().down()).getBlock() == Blocks.SCULK;
    }

    @Override
    public void start() {
        this.buryPos = this.entity.getBlockPos().add(-5 + this.world.getRandom().nextInt(11), 0, -5 + this.world.getRandom().nextInt(11));
        this.buryCooldown = 600;
        this.buriedTime = 12000;

        this.entity.playSound(SoundEvents.ENTITY_WARDEN_ANGRY, 1.0f, 1.0f);
        this.entity.getWorld().addParticle(ParticleTypes.EXPLOSION, true, entity.getX(), entity.getY(), entity.getZ(), 0,1, 0);
    }

    @Override
    public void tick() {
        if (this.buriedTime > 0) {
            this.buriedTime--;

            this.entity.getNavigation().startMovingTo(this.buryPos.getX() + 0.5, this.entity.getY(), this.buryPos.getZ() + 0.5, 0.0);
            this.entity.setMovementSpeed(-1);
        } else {
            PlayerEntity player = this.world.getClosestPlayer(this.entity, 1.0);
            if (player != null) {
                player.damage(entity.getRecentDamageSource(), entity.getDamage());
                this.entity.playSound(SoundEvents.BLOCK_SCULK_BREAK, 1.0f, 1.0f);
                this.entity.getWorld().addParticle(ParticleTypes.EXPLOSION, true, entity.getX(), entity.getY(), entity.getZ(), 0,1, 0);
                this.entity.setAttacking(true);
                this.entity.setMovementSpeed(+1);
            }
        }
    }

    @Override
    public void stop() {
        this.entity.setAttacking(false);
    }

    @Override
    public boolean shouldContinue() {
        return this.entity.isAttacking();
    }

    public void stopExecuting() {
        this.entity.setAttacking(false);
    }

    public void resetTask() {
        this.buryCooldown--;
    }
}
