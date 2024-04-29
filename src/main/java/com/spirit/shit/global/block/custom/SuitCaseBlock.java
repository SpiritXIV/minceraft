package com.spirit.shit.global.block.custom;

import com.spirit.koil.render.VoxelShapeRotator;
import com.spirit.shit.data.common.AbstractShitBlock;
import com.spirit.shit.global.block.ShitBlockEntities;
import com.spirit.shit.global.block.ShitBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SuitCaseBlock extends AbstractShitBlock implements BlockEntityProvider {
    VoxelShape NORTH_SHAPE;
    final Map<Direction, VoxelShape> SHAPE_MAP;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static int value;

    private static final VoxelShape SHAPE_OPEN = Stream.of(
            Block.createCuboidShape(-1, 2, 12.5, 17, 13, 13.5),
            Block.createCuboidShape(17, 2, 11.5, 17, 13, 12.5),
            Block.createCuboidShape(-1, 13, 11.5, 17, 13, 12.5),
            Block.createCuboidShape(-1, 2, 11.5, -1, 13, 12.5),
            Block.createCuboidShape(-1, 0, 1.5, 0, 2, 12.5),
            Block.createCuboidShape(16, 0, 1.5, 17, 2, 12.5),
            Block.createCuboidShape(-1, 0, 11.5, 17, 2, 12.5),
            Block.createCuboidShape(-1, 0, 1.5, 17, 2, 2.5),
            Block.createCuboidShape(-1, 0, 1.5, 17, 0, 12.5),
            Block.createCuboidShape(10, 1.5, -0.45, 11, 2.5, 2.55),
            Block.createCuboidShape(6, 1.5, -0.45, 10, 2.5, 0.55),
            Block.createCuboidShape(5, 1.5, -0.45, 6, 2.5, 2.55)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_CLOSED = Stream.of(
            Block.createCuboidShape(-1, 0, 1.5, 17, 4, 12.5),
            Block.createCuboidShape(10, 1.5, -0.45, 11, 2.5, 2.55),
            Block.createCuboidShape(6, 1.5, -0.45, 10, 2.5, 0.55),
            Block.createCuboidShape(5, 1.5, -0.45, 6, 2.5, 2.55)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_FILLED = Stream.of(
            Block.createCuboidShape(0, 2, 2.25, 16, 4.75, 12.25),
            Block.createCuboidShape(-1, 2, 12.5, 17, 13, 13.5),
            Block.createCuboidShape(17, 2, 11.5, 17, 13, 12.5),
            Block.createCuboidShape(-1, 13, 11.5, 17, 13, 12.5),
            Block.createCuboidShape(-1, 2, 11.5, -1, 13, 12.5),
            Block.createCuboidShape(-1, 0, 1.5, 17, 2, 12.5),
            Block.createCuboidShape(10, 1.5, -0.45, 11, 2.5, 2.55),
            Block.createCuboidShape(6, 1.5, -0.45, 10, 2.5, 0.55),
            Block.createCuboidShape(5, 1.5, -0.45, 6, 2.5, 2.55)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    public static final IntProperty TYPE = IntProperty.of("type", 0, 7);
    public static final BooleanProperty STATE = BooleanProperty.of("state");
    private int writeType; // Changed to instance variable

    public SuitCaseBlock(Settings settings) {
        super(settings, SHAPE_CLOSED);
        BlockState state = this.stateManager.getDefaultState();
        this.SHAPE_MAP = VoxelShapeRotator.rotateAllDirections(SHAPE_CLOSED);
        this.setDefaultState(this.getStateManager().getDefaultState().with(TYPE, 0));
        this.setDefaultState(this.getStateManager().getDefaultState().with(STATE, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
        builder.add(STATE);
        builder.add(FACING);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if (!stack.isEmpty() && stack.getCount() >= 63 && state.get(STATE) == false) {
            Item item = stack.getItem();
            int type = 0;
            if (item == ShitBlocks.ONE_MOMEN_STACK.asItem()) {
                type = 1;
            } else if (item == ShitBlocks.FIVE_MOMEN_STACK.asItem()) {
                type = 2;
            } else if (item == ShitBlocks.TEN_MOMEN_STACK.asItem()) {
                type = 3;
            } else if (item == ShitBlocks.TWENTY_MOMEN_STACK.asItem()) {
                type = 4;
            } else if (item == ShitBlocks.FIFTY_MOMEN_STACK.asItem()) {
                type = 5;
            } else if (item == ShitBlocks.ONEHUNDRED_MOMEN_STACK.asItem()) {
                type = 6;
            } else if (item == ShitBlocks.FIVEHUNDRED_MOMEN_STACK.asItem()) {
                type = 7;
            }
            if (type != 0) {
                world.setBlockState(pos, state.with(TYPE, type));
                if (!player.isCreative()) {
                    stack.decrement(63);
                }
                return ActionResult.SUCCESS;
            }
        }

        if (player.isSneaking() && stack.isEmpty() && state.get(STATE) == false) {
            int type = state.get(TYPE);
            Item momenItem = switch (type) {
                case 1 -> ShitBlocks.ONE_MOMEN_STACK.asItem();
                case 2 -> ShitBlocks.FIVE_MOMEN_STACK.asItem();
                case 3 -> ShitBlocks.TEN_MOMEN_STACK.asItem();
                case 4 -> ShitBlocks.TWENTY_MOMEN_STACK.asItem();
                case 5 -> ShitBlocks.FIFTY_MOMEN_STACK.asItem();
                case 6 -> ShitBlocks.ONEHUNDRED_MOMEN_STACK.asItem();
                case 7 -> ShitBlocks.FIVEHUNDRED_MOMEN_STACK.asItem();
                default -> null;
            };
            if (momenItem != null) {
                ItemStack momenStack = new ItemStack(momenItem, 63);
                if (player.getInventory().insertStack(momenStack)) {
                    world.setBlockState(pos, state.with(TYPE, 0));
                } else {
                    player.dropItem(momenStack, false);
                }
                return ActionResult.SUCCESS;
            }
        }

        if (!player.isSneaking() && stack.isEmpty()) {
            world.setBlockState(pos, state.cycle(STATE));
            if (state.get(STATE) == false && state.get(TYPE) >= 1) {
                this.NORTH_SHAPE = SHAPE_FILLED;
            }
            if (state.get(STATE) == false && state.get(TYPE) == 0) {
                this.NORTH_SHAPE = SHAPE_OPEN;
            }
            if (state.get(STATE) == true) {
                this.NORTH_SHAPE = SHAPE_CLOSED;
            }

            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasNbt() && itemStack.getNbt().contains("type", NbtElement.INT_TYPE)) {
            int storedType = itemStack.getNbt().getInt("type");
            world.setBlockState(pos, state.with(TYPE, storedType));
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        if (!player.isCreative()) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt() && stack.getNbt().contains("type", NbtElement.INT_TYPE)) {
            int storedType = stack.getNbt().getInt("type");
        }
        tooltip.add(Text.literal("ƒ: " + value).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SuitCaseBlockEntity(pos, state);
    }

    public static class SuitCaseBlockEntity extends BlockEntity {
        public static int storedType;

        public SuitCaseBlockEntity(BlockPos pos, BlockState state) {
            super(ShitBlockEntities.SUITCASE_ENTITY, pos, state);
            storedType = state.get(SuitCaseBlock.TYPE);
        }

        public void writeNbt(NbtCompound nbt) {
            super.writeNbt(nbt);
            nbt.putInt("type", getCachedState().get(SuitCaseBlock.TYPE));
        }

        @Override
        public void readNbt(NbtCompound nbt) {
            super.readNbt(nbt);
            if (nbt.contains("type", NbtElement.INT_TYPE) && world != null) {
                world.setBlockState(getPos(), getCachedState().with(SuitCaseBlock.TYPE, storedType));
            }
        }

        @Override
        public Packet<ClientPlayPacketListener> toUpdatePacket() {
            return BlockEntityUpdateS2CPacket.create(this);
        }
    }
}