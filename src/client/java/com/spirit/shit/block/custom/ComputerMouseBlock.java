package com.spirit.shit.block.custom;

import com.spirit.shit.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ComputerMouseBlock extends Block {

    public ComputerMouseBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(Block.createCuboidShape(6, 0, 6, 10, 2, 11), Block.createCuboidShape(6.5, 1.5, 6.75, 9.5, 2.5, 10.75), BooleanBiFunction.OR);
    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_N;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hit) {
        user.playSound(ShitSounds.MICROWAVE_BEEP, SoundCategory.BLOCKS, 1, 1);
        user.sendMessage(Text.of("[!] | incomplete"));
        return ActionResult.PASS;
    }

}

