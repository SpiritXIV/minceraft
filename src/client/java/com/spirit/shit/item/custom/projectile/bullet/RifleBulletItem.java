package com.spirit.shit.item.custom.projectile.bullet;

import com.spirit.shit.common.GunProjectileItem;
import com.spirit.shit.entity.custom.projectile.BulletProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RifleBulletItem extends GunProjectileItem {
    double velocityMultiplier = 1.1;
    public RifleBulletItem(Settings settings) {
        super(settings);
    }

    @Override
    public void fire(World world, PlayerEntity player, double velocityModifier, ItemStack bulletItem, double damage) {
        if (!world.isClient) { // Only execute on the server side
            velocityMultiplier += velocityModifier;

            // Create new bullet entity
            BulletProjectileEntity bullet = new BulletProjectileEntity(world, player, damage);

            // Set bullet properties here, e.g. position, velocity, etc.
            bullet.setPos(
                    player.getX(),
                    player.getEyeY() - 0.1,
                    player.getZ()
            );
            bullet.setVelocity(
                    velocityMultiplier * (-Math.sin(Math.toRadians(player.getYaw())) * Math.cos(Math.toRadians(player.getPitch()))),
                    velocityMultiplier * (-Math.sin(Math.toRadians(player.getPitch()))),
                    velocityMultiplier * (Math.cos(Math.toRadians(player.getYaw())) * Math.cos(Math.toRadians(player.getPitch())))
            );

            // Spawn the bullet into the world
            world.spawnEntity(bullet);
        }
    }
}
