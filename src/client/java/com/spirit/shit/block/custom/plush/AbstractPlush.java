package com.spirit.shit.block.custom.plush;

import com.spirit.shit.util.VoxelShapeRotator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class AbstractPlush extends Block {
    final VoxelShape NORTH_SHAPE;
    final Map<Direction, VoxelShape> SHAPE_MAP;

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public AbstractPlush(Settings settings, VoxelShape SHAPE) {
        super(settings);
        this.NORTH_SHAPE = SHAPE;
        this.SHAPE_MAP = VoxelShapeRotator.rotateAllDirections(NORTH_SHAPE); // Call the imported function

    }

    // Override this method to set the block's state when it is placed
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (placer != null) {
            Direction direction = placer.getHorizontalFacing().getOpposite();
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
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

