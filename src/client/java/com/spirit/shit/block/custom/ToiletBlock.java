package com.spirit.shit.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
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
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ToiletBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ToiletBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Stream.of(
                    Block.createCuboidShape(5, 0, 3, 11, 3, 7),
                    Block.createCuboidShape(5, 3, 4, 11, 6, 7),
                    Block.createCuboidShape(4, 0, 7, 12, 6, 13)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(3, 6, 2, 13, 8, 11), Block.createCuboidShape(2.5, 8, 1, 13.5, 12, 11), BooleanBiFunction.OR),
            Stream.of(
                    Block.createCuboidShape(2, 6, 11, 14, 14, 14),
                    Block.createCuboidShape(1.5, 14, 10.75, 14.5, 21, 14.75),
                    Block.createCuboidShape(1, 21, 10.75, 15, 23, 14.75),
                    Block.createCuboidShape(12, 19, 10, 15, 20, 11)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> SHAPE_N;
        };
    }

    @Nullable

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hit) {
        world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, 1F, 1F, true);

        user.getWorld().addParticle(ParticleTypes.SPLASH, pos.getX() + 0.5F, pos.getY() + 1F, pos.getZ() + 0.5F, (world.getRandom().nextFloat() * 0.2F - 0.6F), 0.1F, (world.getRandom().nextFloat() * 0.2F - 0.6F));
        user.getWorld().addParticle(ParticleTypes.SPLASH, pos.getX() + 0.5F, pos.getY() + 1F, pos.getZ() + 0.5F, (world.getRandom().nextFloat() * -0.2F + 0.6F), 0.1F, (world.getRandom().nextFloat() * -0.2F + 0.6F));
        user.getWorld().addParticle(ParticleTypes.SPLASH, pos.getX() + 0.5F, pos.getY() + 1F, pos.getZ() + 0.5F, (world.getRandom().nextFloat() * 0.2F - 0.6F), 0.1F, (world.getRandom().nextFloat() * 0.2F - 0.6F));
        user.getWorld().addParticle(ParticleTypes.SPLASH, pos.getX() + 0.5F, pos.getY() + 1F, pos.getZ() + 0.5F, (world.getRandom().nextFloat() * -0.2F + 0.6F), 0.1F, (world.getRandom().nextFloat() * -0.2F + 0.6F));
        user.getWorld().addParticle(ParticleTypes.SPLASH, pos.getX() + 0.5F, pos.getY() + 1F, pos.getZ() + 0.5F, (world.getRandom().nextFloat() * 0.2F - 0.6F), 0.1F, (world.getRandom().nextFloat() * 0.2F - 0.6F));
        user.getWorld().addParticle(ParticleTypes.SPLASH, pos.getX() + 0.5F, pos.getY() + 1F, pos.getZ() + 0.5F, (world.getRandom().nextFloat() * -0.2F + 0.6F), 0.1F, (world.getRandom().nextFloat() * -0.2F + 0.6F));

        user.sendMessage(Text.of("[!] | incomplete"));
        return ActionResult.PASS;
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

