package com.spirit.shit.global.block.custom;

import com.spirit.Main;
import com.spirit.shit.global.entity.damage.DamageTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;

import java.util.Objects;

public class WorldBombBlock extends Block {

    public WorldBombBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            GasCanBlock.primeTnt(world, pos);
            world.removeBlock(pos, true);
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isCreative()) {
            GasCanBlock.primeTnt(world, pos);
        }
        super.onBreak(world, pos, state, player);
    }

    private static void primeTnt(World world, BlockPos pos, LivingEntity igniter) {
        if (!world.isClient()) {
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();


            world.createExplosion(igniter, new DamageSource(RegistryEntry.of(new DamageType("world_bomb", 1))), new ExplosionBehavior(), x, y, z, 100, true, World.ExplosionSourceType.TNT);
            igniter.getWorld().createExplosion(igniter, new DamageSource(RegistryEntry.of(new DamageType("world_bomb", 1))), new ExplosionBehavior(), x, y, z, 100, true, World.ExplosionSourceType.TNT);
            Main.LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------");
            Main.LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------");
            Main.LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------");
            Main.LOGGER.info("----------------------------------------------------------SHIT OF THE CRYPT ----------------------------------------------------------");
            for (int i = 0; i < 25; i++)
                Main.LOGGER.info("- THE SERVER WAS CLOSED DUE TO SOMEONE DETONATING THE WORLD BOMB, IT DIDN'T CRASH THE BOMB IS MADE TO INTENTIONALLY CRASH THE SERVER -");
            Main.LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------");
            Main.LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------");
            Main.LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------");
            Objects.requireNonNull(world.getServer()).save(false, false, true);
            Objects.requireNonNull(world.getServer()).close();
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player2, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player2.getStackInHand(hand);
        if (itemStack.isOf(Items.FLINT_AND_STEEL) || itemStack.isOf(Items.FIRE_CHARGE)) {
            WorldBombBlock.primeTnt(world, pos, player2);
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            Item item = itemStack.getItem();
            if (!player2.isCreative()) {
                if (itemStack.isOf(Items.FLINT_AND_STEEL)) {
                    itemStack.damage(1, player2, player -> player.sendToolBreakStatus(hand));
                } else {
                    itemStack.decrement(1);
                }
            }
            player2.incrementStat(Stats.USED.getOrCreateStat(item));
            player2.damage(DamageTypes.of(world, DamageTypes.GAS_CAN), 100);
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player2, hand, hit);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }
}

