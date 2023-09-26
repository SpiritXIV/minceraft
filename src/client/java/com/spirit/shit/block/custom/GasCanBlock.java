package com.spirit.shit.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class GasCanBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public GasCanBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 0, 2, 12, 12, 14),
            Block.createCuboidShape(7, 13, 1, 9, 19, 3),
            Block.createCuboidShape(6, 12, 0, 10, 14, 4),
            Block.createCuboidShape(6, 11, 11, 10, 13, 13),
            Block.createCuboidShape(6, 13, 5, 10, 14, 13),
            Block.createCuboidShape(6, 11, 5, 10, 13, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(4, 0, 2, 12, 12, 14),
            Block.createCuboidShape(7, 13, 1, 9, 19, 3),
            Block.createCuboidShape(6, 12, 0, 10, 14, 4),
            Block.createCuboidShape(6, 11, 11, 10, 13, 13),
            Block.createCuboidShape(6, 13, 5, 10, 14, 13),
            Block.createCuboidShape(6, 11, 5, 10, 13, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(4, 0, 2, 12, 12, 14),
            Block.createCuboidShape(7, 13, 1, 9, 19, 3),
            Block.createCuboidShape(6, 12, 0, 10, 14, 4),
            Block.createCuboidShape(6, 11, 11, 10, 13, 13),
            Block.createCuboidShape(6, 13, 5, 10, 14, 13),
            Block.createCuboidShape(6, 11, 5, 10, 13, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(4, 0, 2, 12, 12, 14),
            Block.createCuboidShape(7, 13, 1, 9, 19, 3),
            Block.createCuboidShape(6, 12, 0, 10, 14, 4),
            Block.createCuboidShape(6, 11, 11, 10, 13, 13),
            Block.createCuboidShape(6, 13, 5, 10, 14, 13),
            Block.createCuboidShape(6, 11, 5, 10, 13, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
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

    public static void primeTnt(World world, BlockPos pos) {
        GasCanBlock.primeTnt(world, pos, null);
        if (!world.isClient()) {
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();
            world.createExplosion(null, new DamageSource(RegistryEntry.of(new DamageType("gas_can_bomb",1 ))), new ExplosionBehavior(), x, y + 1, z, 10, true, World.ExplosionSourceType.TNT);
        }
    }

    private static void primeTnt(World world, BlockPos pos, LivingEntity igniter) {
        if (!world.isClient()) {
            float health = igniter.getHealth();
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();

            world.createExplosion(igniter, new DamageSource(RegistryEntry.of(new DamageType("gas_can_bomb", 1 ))), new ExplosionBehavior(), x, y + 1, z, 10, true, World.ExplosionSourceType.TNT);
            igniter.getWorld().createExplosion(igniter, new DamageSource(RegistryEntry.of(new DamageType("gas_can_bomb",1 ))), new ExplosionBehavior(), x, y + 1, z, 10, true, World.ExplosionSourceType.TNT);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player2, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player2.getStackInHand(hand);
        if (itemStack.isOf(Items.FLINT_AND_STEEL) || itemStack.isOf(Items.FIRE_CHARGE)) {
            GasCanBlock.primeTnt(world, pos, player2);
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
            player2.damage(new DamageSource(RegistryEntry.of(new DamageType("gas_can_bomb", 1))), 100);
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player2, hand, hit);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

