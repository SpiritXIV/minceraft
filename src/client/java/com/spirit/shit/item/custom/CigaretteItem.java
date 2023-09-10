package com.spirit.shit.item.custom;

import com.spirit.shit.sound.ShitSounds;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CigaretteItem extends Item {
    private static final int MAX_USE_TIME = 1800;

    public CigaretteItem(Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 1800;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            if (!((ServerPlayerEntity) user).getAbilities().creativeMode) {
                stack.decrement(1);
            }
            double x = user.getX();
            double y = user.getY();
            double z = user.getZ();
            float health = user.getHealth();
            user.damage(new DamageSource(RegistryEntry.of(new DamageType("smoked_to_much", 1))), health);
        }
        return stack;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_EAT;
    }

    public TypedActionResult<ItemStack> use(ItemStack stack, World world, PlayerEntity user, Hand hand) {

        double x = user.getX();
        double y = user.getY();
        double z = user.getZ();

        double xx = user.getRotationVecClient().getX();
        double yy = user.getRotationVecClient().getY();
        double zz = user.getRotationVecClient().getZ();
        user.getItemCooldownManager().set(this, 15);
        user.getWorld().addParticle(ParticleTypes.SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        user.getWorld().addParticle(ParticleTypes.SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        user.getWorld().addParticle(ParticleTypes.SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        stack.damage(1, user, (p) -> {
            p.sendToolBreakStatus(user.getActiveHand());
        });
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        double x = user.getX();
        double y = user.getY();
        double z = user.getZ();
        double xx = user.getRotationVecClient().getX();
        double yy = user.getRotationVecClient().getY();
        double zz = user.getRotationVecClient().getZ();

        user.getWorld().addParticle(ParticleTypes.SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        user.getWorld().addParticle(ParticleTypes.SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        user.getWorld().addParticle(ParticleTypes.SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        user.getWorld().addParticle(ParticleTypes.SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        double x = user.getX();
        double y = user.getY();
        double z = user.getZ();
        double xx = user.getRotationVecClient().getX();
        double yy = user.getRotationVecClient().getY();
        double zz = user.getRotationVecClient().getZ();

        user.getWorld().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        user.getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        user.getWorld().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
        user.getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y + 1.5, z, xx/7, yy, zz/7);
    }
}

