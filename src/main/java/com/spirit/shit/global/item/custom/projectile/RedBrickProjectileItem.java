package com.spirit.shit.global.item.custom.projectile;

import com.spirit.shit.global.entity.custom.projectile.RedBrickProjectileEntity;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RedBrickProjectileItem extends Item {
    public RedBrickProjectileItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ShitSounds.BRICK_THROWN, SoundCategory.NEUTRAL, 1F, 1F);
        user.getItemCooldownManager().set(this, 5);
        if (!world.isClient) {
            RedBrickProjectileEntity snowballEntity = new RedBrickProjectileEntity(world, user);
            snowballEntity.setItem(itemStack);
            snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 1.0F, 1.5F, 1F);
            world.spawnEntity(snowballEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
