package com.spirit.shit.common;

import com.spirit.shit.util.VoxelShapeRotator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractShitBlock extends Block {
    final VoxelShape NORTH_SHAPE;
    final Map<Direction, VoxelShape> SHAPE_MAP;

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public AbstractShitBlock(Settings settings, VoxelShape SHAPE) {
        super(settings);
        this.NORTH_SHAPE = SHAPE;
        this.SHAPE_MAP = VoxelShapeRotator.rotateAllDirections(NORTH_SHAPE);
    }
    public AbstractShitBlock(Settings settings) {
        super(settings);
        this.NORTH_SHAPE = null;
        this.SHAPE_MAP = null;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (placer != null) {
            Direction direction = placer.getHorizontalFacing();
            world.setBlockState(pos, state.with(FACING, direction), 2);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        return SHAPE_MAP.get(facing);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        float yaw = Objects.requireNonNull(ctx.getPlayer()).getYaw();
        Direction dir = Direction.fromHorizontal(Math.floorMod((int)Math.floor((double)(yaw * 4.0F / 360.0F) + 0.5D), 4));
        return this.getDefaultState().with(FACING, dir);
    }
}

