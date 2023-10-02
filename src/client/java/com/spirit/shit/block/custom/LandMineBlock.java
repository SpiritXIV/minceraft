package com.spirit.shit.block.custom;

import com.spirit.shit.common.AbstractShitBlock;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;

import java.util.stream.Stream;

public class LandMineBlock extends AbstractShitBlock {
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(3, 0, 3, 13, 2, 13),
            Block.createCuboidShape(4, 1.5, 4, 12, 2.5, 12),
            Block.createCuboidShape(7, 2, 7, 9, 3, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public LandMineBlock(Settings settings) {
        super(settings, SHAPE);
        this.setDefaultState(this.getDefaultState().with(POWERED, false));
    }
    @Override
    @SuppressWarnings("deprecation")
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            LandMineBlock.primeTnt(world, pos);
            world.removeBlock(pos, true);
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isCreative()) {
            LandMineBlock.primeTnt(world, pos);
        }
        super.onBreak(world, pos, state, player);
    }

    public static void primeTnt(World world, BlockPos pos) {
        LandMineBlock.primeTnt(world, pos, null);
        if (!world.isClient()) {
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();
            world.createExplosion(null, new DamageSource(RegistryEntry.of(new DamageType("gas_can_bomb", 1))), new ExplosionBehavior(), x, y + 1, z, 10, false, World.ExplosionSourceType.TNT);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static void primeTnt(World world, BlockPos pos, LivingEntity igniter) {
        if (!world.isClient()) {
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();

            world.createExplosion(igniter, new DamageSource(RegistryEntry.of(new DamageType("gas_can_bomb", 1))), new ExplosionBehavior(), x, y + 1, z, 10, false, World.ExplosionSourceType.TNT);
            igniter.getWorld().createExplosion(igniter, new DamageSource(RegistryEntry.of(new DamageType("gas_can_bomb", 1))), new ExplosionBehavior(), x, y + 1, z, 10, false, World.ExplosionSourceType.TNT);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (state.get(POWERED)) {
            world.emitGameEvent(entity, GameEvent.BLOCK_ACTIVATE, pos);
            world.removeBlock(pos, false);
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();
            world.createExplosion(entity, new DamageSource(RegistryEntry.of(new DamageType("land_mine", 1))), new ExplosionBehavior(), x, y + 1, z, 10, false, World.ExplosionSourceType.TNT);
            entity.getWorld().createExplosion(entity, new DamageSource(RegistryEntry.of(new DamageType("land_mine", 1))), new ExplosionBehavior(), x, y + 1, z, 10, false, World.ExplosionSourceType.TNT);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            world.setBlockState(pos, state.cycle(POWERED));
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
}

