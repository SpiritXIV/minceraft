package com.spirit.shit.item.custom.projectile.bullet;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtByte;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public class ShellItem extends ShotgunAbstract {
    public ShellItem(Settings settings) {
        super(settings);
    }

    @Override
    public void fire(World world, PlayerEntity player, double velocityModifier, ItemStack bulletItem, double damage) {
        if (!world.isClient) { // Only execute on the server side
            NbtCompound nbt = bulletItem.getNbt(); // Get the NBT data from the item
            if (nbt != null) {
                NbtList flagsList = nbt.getList("Flags", NbtElement.BYTE_TYPE);

                byte isIncendiary = ((NbtByte) flagsList.get(0)).byteValue();
                byte isExtendedDuration = ((NbtByte) flagsList.get(2)).byteValue();

                // For each ray
                for (float angle = -60; angle <= 60; angle += 5) { // Adjust the step for better/worse resolution
                    Vec3d start = player.getPos().add(0, player.getEyeY() - player.getY(), 0); // Start position
                    Vec3d direction = Vec3d.fromPolar(player.getPitch(), player.getYaw() + angle); // Direction vector

                    Vec3d end = start.add(direction.multiply(16)); // End position

                    // Perform the ray-cast
                    HitResult hitResult = world.raycast(new RaycastContext(start, end, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));

                    // Handle the hit result
                    if (hitResult.getType() == HitResult.Type.BLOCK) {
                        BlockHitResult blockHitResult = (BlockHitResult) hitResult;
                        // Do something when hit block
                        if (isIncendiary != 0) {
                            BlockPos pos = blockHitResult.getBlockPos().offset(blockHitResult.getSide()); // Get adjacent block
                            if (world.getBlockState(pos).isAir()) {
                                world.setBlockState(pos, Blocks.FIRE.getDefaultState()); // Set the block on fire
                            }
                        }
                    } else if (hitResult.getType() == HitResult.Type.ENTITY) {
                        @SuppressWarnings("DataFlowIssue") EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                        // Do something when hit an entity
                        if (entityHitResult.getEntity() instanceof LivingEntity livingEntity) { // Check if the entity is living

                            if (isIncendiary != 0) {
                                livingEntity.setOnFireFor(5); // Set the entity on fire for 5 seconds
                            }

                            if (isExtendedDuration != 0) {
                                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 800, 1)); // Apply Slowness status effect for 40 seconds with level 2
                            }
                        }
                    }
                }
            }
        }
    }
}
