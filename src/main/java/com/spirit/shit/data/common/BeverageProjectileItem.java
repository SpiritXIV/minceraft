package com.spirit.shit.data.common;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class BeverageProjectileItem extends Item {
    private final SoundEvent THROW_SOUND;
    public BeverageProjectileItem(Settings settings, SoundEvent throwSound) {
        super(settings);
        THROW_SOUND = throwSound;
    }

    public abstract BeverageProjectileEntity createProjectileEntity(World world, PlayerEntity user);

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), THROW_SOUND, SoundCategory.NEUTRAL, 1F, 1F);
        user.getItemCooldownManager().set(this, 5);
        if (!world.isClient) {
            BeverageProjectileEntity projectileEntity = createProjectileEntity(world, user);
            projectileEntity.setItem(itemStack);
            projectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 1.0F, 0.5F, 1F);
            world.spawnEntity(projectileEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
