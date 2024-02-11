package com.spirit.tdbtd.block.custom;

import com.spirit.tdbtd.block.entity.TDBTDBlockEntities;
import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustColorTransitionParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static net.minecraft.particle.DustColorTransitionParticleEffect.SCULK_BLUE;


public class SculkShakerBlock extends PlantBlock implements BlockEntityProvider {
    private final Supplier<Block> ground;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SculkShakerBlock(Settings settings, Supplier<Block> ground) {
        super(settings);
        this.ground = ground;
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SculkShakerBlock.SculkShakerBlockEntity(pos, state);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(0, 0, 0, 0, 15, 16),
            Block.createCuboidShape(16, 0, 0, 16, 15, 16),
            Block.createCuboidShape(0, 0, 16, 16, 15, 16),
            Block.createCuboidShape(0, 0, 0, 16, 15, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(0, 0, 0, 0, 15, 16),
            Block.createCuboidShape(16, 0, 0, 16, 15, 16),
            Block.createCuboidShape(0, 0, 16, 16, 15, 16),
            Block.createCuboidShape(0, 0, 0, 16, 15, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(0, 0, 0, 0, 15, 16),
            Block.createCuboidShape(16, 0, 0, 16, 15, 16),
            Block.createCuboidShape(0, 0, 16, 16, 15, 16),
            Block.createCuboidShape(0, 0, 0, 16, 15, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(0, 0, 0, 0, 15, 16),
            Block.createCuboidShape(16, 0, 0, 16, 15, 16),
            Block.createCuboidShape(0, 0, 16, 16, 15, 16),
            Block.createCuboidShape(0, 0, 0, 16, 15, 0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> SHAPE_N;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            case EAST -> SHAPE_E;
            default -> SHAPE_N;
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
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

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SCULK);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        spawnParticleOnShaker(world, pos, new DustColorTransitionParticleEffect(SCULK_BLUE, SCULK_BLUE, 1), 10, 0.5);
    }


    public static void spawnParticleOnShaker(World world, BlockPos pos, ParticleEffect particle, int count, double radius) {
        List<BlockPos> catalystPositions = findNearbyCatalysts(world, pos);

        world.addParticle(ParticleTypes.SONIC_BOOM, true, pos.getX(), pos.getY(), pos.getZ(), 0.0, 0.0, 0.0);

        if (!catalystPositions.isEmpty()) {
            Vec3d emitterVec = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);

            for (BlockPos catalystPos : catalystPositions) {
                Vec3d catalystVec = new Vec3d(catalystPos.getX() + 0.5, catalystPos.getY() + 0.5, catalystPos.getZ() + 0.5);

                BlockPos.Mutable currentPos = new BlockPos.Mutable(catalystPos.getX(), 0, catalystPos.getZ());
                Vec3d currentVec = new Vec3d(catalystVec.x, catalystVec.y, catalystVec.z);

                while (currentPos.getY() > 0) {
                    currentPos.setY(currentPos.getY() - 1);

                    if (!world.getBlockState(currentPos).isOpaque()) {
                        currentVec = new Vec3d(currentPos.getX() + 0.5, currentPos.getY() + 0.5, currentPos.getZ() + 0.5);
                    } else {
                        break;
                    }
                }

                double distance = emitterVec.distanceTo(currentVec);
                double step = radius / count;

                for (double i = 0; i < distance; i += step) {
                    double t = i / distance;
                    double x = emitterVec.x + (currentVec.x - emitterVec.x) * t;
                    double y = emitterVec.y + (currentVec.y - emitterVec.y) * t;
                    double z = emitterVec.z + (currentVec.z - emitterVec.z) * t;

                    world.addParticle(particle, true, x, y, z, 0.0, 0.0, 0.0);
                }
            }
        }
    }


    private static List<BlockPos> findNearbyCatalysts(World world, BlockPos pos) {
        int radius = 16;
        List<BlockPos> catalystPositions = new ArrayList<>();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos targetPos = pos.add(x, y, z);
                    BlockState targetState = world.getBlockState(targetPos);
                    if (targetState.getBlock() instanceof SculkCatalystBlock) {
                        catalystPositions.add(targetPos);
                    }
                }
            }
        }

        return catalystPositions;
    }

    private static List<BlockPos> findNearbyShakers(World world, BlockPos pos) {
        int radius = 16;
        List<BlockPos> shakerPositions = new ArrayList<>();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos targetPos = pos.add(x, y, z);
                    BlockState targetState = world.getBlockState(targetPos);
                    if (targetState.getBlock() instanceof SculkShakerBlock) {
                        shakerPositions.add(targetPos);
                    }
                }
            }
        }

        return shakerPositions;
    }

    private static List<BlockPos> findNearbyEmitters(World world, BlockPos pos) {
        int radius = 16;
        List<BlockPos> emitterPositions = new ArrayList<>();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos targetPos = pos.add(x, y, z);
                    BlockState targetState = world.getBlockState(targetPos);
                    if (targetState.getBlock() instanceof SculkEmitterBlock) {
                        emitterPositions.add(targetPos);
                    }
                }
            }
        }

        return emitterPositions;
    }
    private World world;

    public void shootBeamToShaker(BlockPos targetPos, BlockPos emitterPos) {
        Vec3d startVec = new Vec3d(emitterPos.getX() + 0.5, emitterPos.getY() + 0.5, emitterPos.getZ() + 0.5);
        Vec3d endVec = new Vec3d(targetPos.getX() + 0.5, targetPos.getY() + 0.5, targetPos.getZ() + 0.5);

        double distance = startVec.distanceTo(endVec);
        double step = distance / 20; // Adjust the number of particles as needed

        for (double i = 0; i < distance; i += step) {
            double t = i / distance;
            double x = startVec.x + (endVec.x - startVec.x) * t;
            double y = startVec.y + (endVec.y - startVec.y) * t;
            double z = startVec.z + (endVec.z - startVec.z) * t;

            world.addParticle(ParticleTypes.SOUL, true, x, y, z, 0.0, 0.0, 0.0);
        }
    }

    public static class SculkShakerBlockEntity extends BlockEntity {
        private int emitTimer = 0;
        private static final int EMIT_INTERVAL = 24000;
        private boolean isValid = true;

        public SculkShakerBlockEntity(BlockPos pos, BlockState state) {
            super(TDBTDBlockEntities.SCULK_SHAKER_BLOCK_ENTITY, pos, state);
            ServerTickCallback.EVENT.register(this::onServerTick);
        }


        private void onServerTick(MinecraftServer server) {
            if (world != null && !world.isSpaceEmpty(new Box(pos))) {
                if (isValid) {
                    List<BlockPos> emitterPositions = findNearbyEmitters(world, pos);

                    if (!emitterPositions.isEmpty()) {
                        emitTimer++;
                    }

                    if (emitTimer >= EMIT_INTERVAL) {
                        spawnProjectileToOtherShaker(world, pos);
                        emitTimer = 0;
                    }
                }
            } else {
                isValid = false;
            }
        }

        private void spawnProjectileToOtherShaker(World world, BlockPos pos) {
            List<BlockPos> shakerPositions = findNearbyShakers(world, pos);
            boolean hasEmitter = false;

            for (BlockPos shakerPos : shakerPositions) {
                if (!shakerPos.equals(pos)) {
                    BlockState shakerState = world.getBlockState(shakerPos);
                    if (shakerState.getBlock() instanceof SculkEmitterBlock) {
                        hasEmitter = true;
                        break;
                    }
                }
            }

            if (hasEmitter) {
                for (BlockPos shakerPos : shakerPositions) {
                    if (!shakerPos.equals(pos)) {
                        BlockState shakerState = world.getBlockState(shakerPos);
                        if (shakerState.getBlock() instanceof SculkCatalystBlock) {
                            shootBeamToCatalyst(pos, shakerPos);
                        }
                    }
                }
            }
        }

        public void shootBeamToCatalyst(BlockPos targetBlockPos, BlockPos emitterPos) {
            Vec3d startVec = new Vec3d(emitterPos.getX() + 0.5, emitterPos.getY() + 0.5, emitterPos.getZ() + 0.5);
            Vec3d endVec = new Vec3d(targetBlockPos.getX() + 0.5, targetBlockPos.getY() + 0.5, targetBlockPos.getZ() + 0.5);

                double distance = startVec.distanceTo(endVec);
                double step = distance / 20;

                for (double i = 0; i < distance; i += step) {
                    double t = i / distance;
                    double x = startVec.x + (endVec.x - startVec.x) * t;
                    double y = startVec.y + (endVec.y - startVec.y) * t;
                    double z = startVec.z + (endVec.z - startVec.z) * t;

                    world.addParticle(ParticleTypes.SOUL, true, x, y, z, 0.0, 0.0, 0.0);
                }
        }
    }
}