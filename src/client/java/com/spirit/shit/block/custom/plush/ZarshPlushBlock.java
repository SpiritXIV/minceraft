package com.spirit.shit.block.custom.plush;

import com.spirit.shit.sound.ShitSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.entry.RegistryEntry;
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
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ZarshPlushBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ZarshPlushBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Stream.of(
                    Block.createCuboidShape(5.25, 13, 3, 10.75, 15, 5),
                    Block.createCuboidShape(10, 12.5, 2.75, 12, 14.5, 4.75),
                    Block.createCuboidShape(10.5, 10.5, 2.75, 12.25, 12.5, 4.75),
                    Block.createCuboidShape(11, 8.5, 2.75, 12.75, 10.5, 4.75),
                    Block.createCuboidShape(10.5, 6.75, 2.75, 12.25, 8.5, 4.75),
                    Block.createCuboidShape(4, 12.5, 2.75, 6, 14.5, 4.75),
                    Block.createCuboidShape(3.75, 10.5, 2.75, 5.5, 12.5, 4.75),
                    Block.createCuboidShape(3.25, 8.5, 2.75, 5, 10.5, 4.75),
                    Block.createCuboidShape(3.75, 6.75, 2.75, 5.5, 8.5, 4.75),
                    Block.createCuboidShape(6, 10.5, 11.5, 10, 13.5, 12.5),
                    Block.createCuboidShape(6.5, 11, 12, 9.5, 13, 13),
                    Block.createCuboidShape(7, 11, 13, 9, 12, 14),
                    Block.createCuboidShape(7.5, 10.75, 14, 8.5, 11.75, 15)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Block.createCuboidShape(6, 6.25, 4.25, 10, 7.25, 5.25),
            Block.createCuboidShape(4, 7, 4, 12, 14, 12),
            Block.createCuboidShape(5, 1, 6, 11, 7, 10),
            Block.createCuboidShape(10, 4, 7, 15, 6, 9),
            Block.createCuboidShape(13, 6, 8, 14, 7, 9),
            Block.createCuboidShape(9, 0, 4, 11, 2, 8),
            Block.createCuboidShape(9, 0, 2, 11, 3, 4),
            Block.createCuboidShape(1, 4, 7, 6, 6, 9),
            Block.createCuboidShape(2, 6, 8, 3, 7, 9),
            Block.createCuboidShape(5, 0, 4, 7, 2, 8),
            Block.createCuboidShape(5, 0, 2, 7, 3, 4),
            Block.createCuboidShape(9, 4.75, 5.25, 10, 6.75, 6.25),
            Block.createCuboidShape(6, 4.75, 5.25, 7, 6.75, 6.25)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_N;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hit) {
        double x = user.getX();
        double y = user.getY();
        double z = user.getZ();
        user.getWorld().createExplosion(user, new DamageSource(RegistryEntry.of(new DamageType("zarsh_plush",1 ))), new ExplosionBehavior(), x, y + 1, z, 30, true, World.ExplosionSourceType.TNT);

        user.playSound(ShitSounds.MICROWAVE_BEEP, SoundCategory.BLOCKS, 1, 1);
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

