package com.spirit.shit.block.custom;

import com.spirit.shit.common.AbstractShitBlock;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.world.World;

import java.util.stream.Stream;

public class RadioBlock extends AbstractShitBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(2.5, 0, 6, 13.5, 6, 10),
            Block.createCuboidShape(4, 5.5, 8, 6, 6.5, 9),
            Block.createCuboidShape(7, 4, 5.5, 9, 5, 6.5),
            Block.createCuboidShape(9.5, 2.5, 5.5, 12.5, 5.5, 6.5),
            Block.createCuboidShape(3.5, 2.5, 5.5, 6.5, 5.5, 6.5),
            Block.createCuboidShape(5, 0.5, 5.5, 6, 1.5, 6.5),
            Block.createCuboidShape(10, 0.5, 5.5, 11, 1.5, 6.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public RadioBlock(Settings settings) {
        super(settings, SHAPE);
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hit) {
        world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, ShitSounds.MICROWAVE_BEEP, SoundCategory.BLOCKS, 1F, 1F, true);
        user.sendMessage(Text.of("[!] | incomplete"));

            return ActionResult.PASS;
}

}

