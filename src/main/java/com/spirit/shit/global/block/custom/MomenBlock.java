package com.spirit.shit.global.block.custom;

import com.spirit.koil.render.VoxelShapeRotator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MomenBlock extends FallingBlock {
    final VoxelShape NORTH_SHAPE;
    final Map<Direction, VoxelShape> SHAPE_MAP;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private final int value;

    private static final VoxelShape SHAPE_ONE = Stream.of(
            Block.createCuboidShape(2, 0, 5, 14, 5, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_TWO = Stream.of(
            Block.createCuboidShape(2, 0, 1, 14, 5, 7),
            Block.createCuboidShape(6, 0, 5, 18, 5, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_THREE = Stream.of(
            Block.createCuboidShape(2, 0, 2, 14, 5, 8),
            Block.createCuboidShape(1, 5, 3, 13, 10, 9),
            Block.createCuboidShape(1, 0, 8, 13, 5, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FOUR = Stream.of(
            Block.createCuboidShape(2, 0, 0, 14, 5, 6),
            Block.createCuboidShape(1, 5, 1, 13, 10, 7),
            Block.createCuboidShape(1, 0, 6, 13, 5, 12),
            Block.createCuboidShape(2, 9, -2, 8, 14, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FIVE = Stream.of(
            Block.createCuboidShape(2, 0, 0, 14, 5, 6),
            Block.createCuboidShape(1, 5, 0, 13, 10, 6),
            Block.createCuboidShape(-4, 5, 11, 8, 10, 17),
            Block.createCuboidShape(1, 0, 6, 13, 5, 12),
            Block.createCuboidShape(1, 0, 12, 13, 5, 18)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SIX = Stream.of(
            Block.createCuboidShape(2, 0, 0, 14, 5, 6),
            Block.createCuboidShape(1, 5, 0, 13, 10, 6),
            Block.createCuboidShape(0, 5, 6, 12, 10, 12),
            Block.createCuboidShape(2, 5, 12, 14, 10, 18),
            Block.createCuboidShape(1, 0, 6, 13, 5, 12),
            Block.createCuboidShape(1, 0, 12, 13, 5, 18)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_SEVEN = Stream.of(
            Block.createCuboidShape(2, 0, 0, 14, 5, 6),
            Block.createCuboidShape(1, 5, 0, 13, 10, 6),
            Block.createCuboidShape(-2, 10, 5, 10, 15, 11),
            Block.createCuboidShape(0, 5, 6, 12, 10, 12),
            Block.createCuboidShape(2, 5, 12, 14, 10, 18),
            Block.createCuboidShape(1, 0, 6, 13, 5, 12),
            Block.createCuboidShape(1, 0, 12, 13, 5, 18)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_EIGHT = Stream.of(
            Block.createCuboidShape(2, 0, 0, 14, 5, 6),
            Block.createCuboidShape(1, 5, 0, 13, 10, 6),
            Block.createCuboidShape(3, 10, 2, 15, 15, 8),
            Block.createCuboidShape(0, 5, 6, 12, 10, 12),
            Block.createCuboidShape(2, 5, 12, 14, 10, 18),
            Block.createCuboidShape(5, 10, 7, 17, 15, 13),
            Block.createCuboidShape(1, 0, 6, 13, 5, 12),
            Block.createCuboidShape(1, 0, 12, 13, 5, 18)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_NINE = Stream.of(
            Block.createCuboidShape(2, 0, 0, 14, 5, 6),
            Block.createCuboidShape(1, 5, 0, 13, 10, 6),
            Block.createCuboidShape(3, 10, 0, 15, 15, 6),
            Block.createCuboidShape(2, 10, 6, 14, 15, 12),
            Block.createCuboidShape(1, 10, 12, 13, 15, 18),
            Block.createCuboidShape(0, 5, 6, 12, 10, 12),
            Block.createCuboidShape(2, 5, 12, 14, 10, 18),
            Block.createCuboidShape(1, 0, 6, 13, 5, 12),
            Block.createCuboidShape(1, 0, 12, 13, 5, 18)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final IntProperty STACK = IntProperty.of("stack", 1, 9);

    public MomenBlock(Settings settings, int value) {
        super(settings);
        this.value = value;
        BlockState state = this.stateManager.getDefaultState();
        this.SHAPE_MAP = VoxelShapeRotator.rotateAllDirections(SHAPE_ONE);
        this.setDefaultState(this.getDefaultState().with(STACK, 1));
        Direction facing = state.get(FACING);
        int stackSize = state.get(STACK);
        this.NORTH_SHAPE = switch (stackSize) {
            case 1:
                yield SHAPE_ONE;
            case 2:
                yield SHAPE_TWO;
            case 3:
                yield SHAPE_THREE;
            case 4:
                yield SHAPE_FOUR;
            case 5:
                yield SHAPE_FIVE;
            case 6:
                yield SHAPE_SIX;
            case 7:
                yield SHAPE_SEVEN;
            case 8:
                yield SHAPE_EIGHT;
            case 9:
                yield SHAPE_NINE;
            default:
                yield SHAPE_MAP.get(facing);
        };
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);
        this.checkFall(world, pos, state);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, net.minecraft.util.hit.BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        int currentStacks = state.get(STACK);

        if (player.isSneaking() && hand == Hand.MAIN_HAND) {
            if (currentStacks > 1) {
                if (!world.isClient) {
                    ItemStack newItemStack = new ItemStack(this.asItem());
                    if (!player.isCreative()) {
                        itemStack.decrement(1);
                    }
                    player.getInventory().offerOrDrop(newItemStack);
                    world.setBlockState(pos, state.with(STACK, currentStacks - 1));
                    world.playSound(null, pos, SoundEvents.BLOCK_CHISELED_BOOKSHELF_INSERT, SoundCategory.BLOCKS,1, 1);
                }
                return ActionResult.SUCCESS;
            } else if (currentStacks == 1) {
                if (!world.isClient) {
                    ItemStack newItemStack = new ItemStack(this.asItem());
                    if (!player.isCreative()) {
                        itemStack.decrement(1);
                    }
                    player.getInventory().offerOrDrop(newItemStack);
                    world.removeBlock(pos, false);
                    world.playSound(null, pos, SoundEvents.BLOCK_CHISELED_BOOKSHELF_INSERT, SoundCategory.BLOCKS,1, 1);
                }
                return ActionResult.SUCCESS;
            }
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STACK);
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        int stackSize = state.get(STACK);

        switch (stackSize) {
            case 1:
                return SHAPE_ONE;
            case 2:
                return SHAPE_TWO;
            case 3:
                return SHAPE_THREE;
            case 4:
                return SHAPE_FOUR;
            case 5:
                return SHAPE_FIVE;
            case 6:
                return SHAPE_SIX;
            case 7:
                return SHAPE_SEVEN;
            case 8:
                return SHAPE_EIGHT;
            case 9:
                return SHAPE_NINE;
        }
        return SHAPE_MAP.get(facing);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (placer != null) {
            Direction direction = placer.getHorizontalFacing();
            world.setBlockState(pos, state.with(FACING, direction), 2);

            BlockPos blockBelowPos = pos.offset(Direction.DOWN);
            if (world.getBlockState(blockBelowPos).isOf(this)) {
                pos = pos.down();
            }
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        float yaw = Objects.requireNonNull(ctx.getPlayer()).getYaw();
        Direction dir = Direction.fromHorizontal(Math.floorMod((int)Math.floor((double)(yaw * 4.0F / 360.0F) + 0.5D), 4));
        return this.getDefaultState().with(FACING, dir);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
        //this.checkFall(world, pos, state);
    }


    private void checkFall(World world, BlockPos pos, BlockState state) {
        if (!world.isClient) {
            BlockPos blockBelowPos = pos.down();
            BlockState blockBelowState = world.getBlockState(blockBelowPos);
            Block blockBelow = blockBelowState.getBlock();
            int stackSize = state.get(STACK);

            if (blockBelow == this) {
                int newStackSize = Math.min(stackSize + blockBelowState.get(STACK), 9);
                if (blockBelowState.get(STACK) < 9) {
                    world.setBlockState(blockBelowPos, blockBelowState.with(STACK, newStackSize));
                    world.playSound(null, pos, SoundEvents.BLOCK_CHISELED_BOOKSHELF_INSERT, SoundCategory.BLOCKS,1, 1);
                    world.removeBlock(pos, false);
                }
            }
        }
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(16) == 0) {
            BlockPos blockPos = pos.down();
            if (canFallThrough(world.getBlockState(blockPos))) {
                ParticleUtil.spawnParticle(world, pos, random, new BlockStateParticleEffect(ParticleTypes.FALLING_DUST, state));
            }
        }
    }
    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return -16777216;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext context) {
        int totalValue = getTotalValue(stack);
        tooltip.add(Text.literal("ƒ: " + totalValue).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }

    private int getTotalValue(ItemStack stack) {
        return value * stack.getCount();
    }
}
