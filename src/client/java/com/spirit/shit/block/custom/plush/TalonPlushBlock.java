package com.spirit.shit.block.custom.plush;

import com.spirit.shit.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
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
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class TalonPlushBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public TalonPlushBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Stream.of(
                    Block.createCuboidShape(4, 7, 4, 12, 15, 12),
                    Block.createCuboidShape(5, 1, 6, 11, 7, 10),
                    Block.createCuboidShape(10, 4, 7, 15, 6, 9),
                    Block.createCuboidShape(13, 6, 8, 14, 7, 9),
                    Block.createCuboidShape(1, 4, 7, 6, 6, 9),
                    Block.createCuboidShape(2, 6, 8, 3, 7, 9),
                    Block.createCuboidShape(9, 0, 4, 11, 2, 8),
                    Block.createCuboidShape(9, 0, 2, 11, 3, 4),
                    Block.createCuboidShape(5, 0, 4, 7, 2, 8),
                    Block.createCuboidShape(5, 0, 2, 7, 3, 4),
                    Block.createCuboidShape(8.75, 4.75, 5.25, 9.75, 6.75, 6.25),
                    Block.createCuboidShape(6.25, 3.75, 5.25, 7.25, 6.75, 6.25),
                    Block.createCuboidShape(5.5, 5.75, 9.5, 10.5, 6.75, 10.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(3.5, 7.5, 3, 12.5, 13.5, 4),
            Block.createCuboidShape(4, 6.5, 3, 12, 7.5, 4),
            Block.createCuboidShape(4, 13.5, 3, 12, 14.5, 4)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Stream.of(
            Block.createCuboidShape(10.75, 13.5, 12, 11.75, 14.5, 15),
            Block.createCuboidShape(11.75, 14, 10.5, 12.75, 15, 13.5),
            Block.createCuboidShape(11.75, 12.31703, 5.96088, 12.75, 13.31703, 8.96088),
            Block.createCuboidShape(9.75, 15.31703, 2.96088, 10.75, 16.31703, 5.96088),
            Block.createCuboidShape(10.75, 15.31703, 3.96088, 11.75, 16.31703, 5.96088),
            Block.createCuboidShape(3.25, 12.31703, 5.96088, 4.25, 13.31703, 8.96088),
            Block.createCuboidShape(10.25, 15, 8.5, 11.25, 16, 11.5),
            Block.createCuboidShape(10.75, 11, 11, 11.75, 12, 13),
            Block.createCuboidShape(4.25, 11, 11, 5.25, 12, 13),
            Block.createCuboidShape(4.75, 15, 8.5, 5.75, 16, 11.5),
            Block.createCuboidShape(3.25, 14, 10.5, 4.25, 15, 13.5),
            Block.createCuboidShape(4.25, 13.5, 12, 5.25, 14.5, 15),
            Block.createCuboidShape(4.5, 6, 11, 8.5, 7, 12),
            Block.createCuboidShape(5.25, 5, 11.25, 7.25, 6, 12.25),
            Block.createCuboidShape(9.75, 5.25, 11.25, 10.75, 6.25, 12.25),
            Block.createCuboidShape(9.5, 6, 11, 11.5, 7, 12),
            Block.createCuboidShape(6, 4.5, 11.5, 7, 5.5, 12.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();



    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_N;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hit) {

        user.playSound(ShitSounds.TALON_SPEAK, SoundCategory.BLOCKS, 1, 1);
        user.sendMessage(Text.of("[!] | incomplete"));
        return ActionResult.PASS;
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

