package com.spirit.shit.item.custom.projectile.bullet;

import com.spirit.shit.common.GunProjectileItem;
import com.spirit.shit.entity.custom.projectile.BulletProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtByte;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.World;

public class RifleBulletItem extends GunProjectileItem {
    double velocityMultiplier = 1.1;
    public RifleBulletItem(Settings settings) {
        super(settings);
    }

    @Override
    public void fire(World world, PlayerEntity player, double velocityModifier, ItemStack bulletItem, double damage) {
        if (!world.isClient) {
            NbtCompound nbt = bulletItem.getNbt();
            if (nbt != null) {
                // Get Flags and PotionEffect
                NbtList flagsList = nbt.getList("Flags", NbtElement.BYTE_TYPE);
                String potionEffect = nbt.getString("PotionEffect");

                // Create new bullet entity
                BulletProjectileEntity bullet = new BulletProjectileEntity(world, player, damage);

                // Set NBT Data to Entity
                byte[] flags = new byte[flagsList.size()];
                for (int i = 0; i < flagsList.size(); i++) {
                    flags[i] = ((NbtByte) flagsList.get(i)).byteValue();
                }
                bullet.setFlags(flags);
                bullet.setPotionEffect(potionEffect);

                // Set bullet properties here, e.g. position, velocity, etc.
                bullet.setPos(
                        player.getX(),
                        player.getEyeY() - 0.1,
                        player.getZ()
                );
                bullet.setVelocity(
                        (velocityMultiplier * velocityModifier) * (-Math.sin(Math.toRadians(player.getYaw())) * Math.cos(Math.toRadians(player.getPitch()))),
                        (velocityMultiplier * velocityModifier) * (-Math.sin(Math.toRadians(player.getPitch()))),
                        (velocityMultiplier * velocityModifier) * (Math.cos(Math.toRadians(player.getYaw())) * Math.cos(Math.toRadians(player.getPitch())))
                );

                // Spawn the bullet into the world
                world.spawnEntity(bullet);
            }
        }
    }
}
