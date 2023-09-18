package com.spirit.shit.item.custom.projectile;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import java.util.Objects;
import net.minecraft.world.World;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;
import java.util.List;

public class BulletProjectileItem extends Item {

    public BulletProjectileItem(Settings settings) {
        super(settings);
    }

    public ItemStack createItemWithEffects(StatusEffect effect, byte isIncendiary, byte isExplosive, byte isExtendedDuration) {
        ItemStack stack = new ItemStack(this);
        NbtCompound nbt = new NbtCompound();

        nbt.putString("EffectName", Objects.requireNonNull(Registries.STATUS_EFFECT.getId(effect)).toString());
        nbt.putByte("IsIncendiary", isIncendiary);
        nbt.putByte("IsExplosive", isExplosive);
        nbt.putByte("IsExtendedDuration", isExtendedDuration);

        stack.setNbt(nbt);
        return stack;
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null) {
            if (nbt.contains("IsIncendiary") && nbt.getByte("IsIncendiary") == 1) {
                tooltip.add(Text.translatable("tooltip.bullets.incendiary"));
            }

            if (nbt.contains("IsExplosive") && nbt.getByte("IsExplosive") == 1) {
                tooltip.add(Text.translatable("tooltip.bullets.explosive"));
            }

            if (nbt.contains("IsExtendedDuration") && nbt.getByte("IsExtendedDuration") == 1) {
                tooltip.add(Text.translatable("tooltip.bullets.extended_duration"));
            }
        }
    }

    /**
     * Generates a custom name for the bullet item based on its NBT data.
     *
     * @param stack The ItemStack representing the bullet.
     * @return The custom name generated based on the bullet's properties.
     */
    public String generateCustomNameFromNBT(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();

        if (nbt == null) {
            return this.getName().getString(); // or whatever method you use to get the name
        }

        // Initialize the components of the name.
        String effectName = "";
        String bulletType = "";  // Add this for bullet type

        if (nbt.contains("EffectName")) {
            String effectId = nbt.getString("EffectName");
            StatusEffect effect = Registries.STATUS_EFFECT.get(Identifier.tryParse(effectId));
            if (effect != null) {
                effectName = effect.getName().getString();
            }
        }

        // Fetch the bullet type from the NBT data if it exists
        if (nbt.contains("BulletType")) {
            bulletType = nbt.getString("BulletType");
        }

        // Concatenate the pieces.
        StringBuilder customName = new StringBuilder();

        if (!bulletType.isEmpty()) {
            customName.append(bulletType);
        }

        if (!effectName.isEmpty()) {
            if (!customName.isEmpty()) {
                customName.append(" of ");
            }
            customName.append(effectName);
        }

        return customName.toString();
    }
/*
    public void fire() {
        BulletProjectileEntity bullet = new BulletProjectileEntity(world, user);
        bullet.setBulletDamage(BULLET_DAMAGE);  // Pass bullet damage to BulletProjectileEntity
        bullet.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 10.F, 0F);
        world.spawnEntity(bullet);
        System.out.println("Shot!");
    }
    */
}
