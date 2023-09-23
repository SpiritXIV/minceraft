package com.spirit.shit.common;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtByte;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import java.util.Objects;
import net.minecraft.world.World;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;
import java.util.List;

public abstract class GunProjectileItem extends Item {

    public GunProjectileItem(Settings settings) {
        super(settings);
    }

    public ItemStack createItemWithEffects(StatusEffect effect, byte isIncendiary, byte isExplosive, byte isExtendedDuration) {
        ItemStack stack = new ItemStack(this);
        NbtCompound nbt = new NbtCompound();
        NbtList flags = new NbtList();

        nbt.putString("PotionEffect", Objects.requireNonNull(Registries.STATUS_EFFECT.getId(effect)).toString());
        flags.add(NbtByte.of(isIncendiary)); // Is Incendiary
        flags.add(NbtByte.of(isExplosive));  // Is Explosive
        flags.add(NbtByte.of(isExtendedDuration)); // Has Extended Duration

        nbt.put("Flags", flags);

        stack.setNbt(nbt);
        return stack;
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null) {
            // Display potion effect
            if (nbt.contains("PotionEffect")) {
                String effect = nbt.getString("PotionEffect");
                tooltip.add(Text.translatable(effect).formatted(Formatting.WHITE));
            }

            if (nbt.contains("Flags")) {
                NbtList flags = nbt.getList("Flags", 1);  // 1 is the NBT type for BYTE

                if (!flags.isEmpty() && ((NbtByte)flags.get(0)).byteValue() == 1) {
                    tooltip.add(Text.translatable("tooltip.bullet.incendiary").formatted(Formatting.GOLD));
                }
                if (flags.size() > 1 && ((NbtByte)flags.get(1)).byteValue() == 1) {
                    tooltip.add(Text.translatable("tooltip.bullet.explosive").formatted(Formatting.DARK_RED));
                }
                if (flags.size() > 2 && ((NbtByte)flags.get(2)).byteValue() == 1) {
                    tooltip.add(Text.translatable("tooltip.bullet.extended_duration").formatted(Formatting.AQUA));
                }
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
            return this.getName().getString();
        }

        // Initialize the components of the name.
        String effectName = "";

        // Use Common.getBulletProjectileItemNameByType to fetch the bullet type's name
        String bulletTypeName = Common.getBulletProjectileItemNameByType(this);

        // Initialize bulletType to fetched name or an empty string if not found
        String bulletType = bulletTypeName != null ? bulletTypeName : "";

        if (nbt.contains("EffectName")) {
            String effectId = nbt.getString("EffectName");
            StatusEffect effect = Registries.STATUS_EFFECT.get(Identifier.tryParse(effectId));
            if (effect != null) {
                effectName = effect.getName().getString();
            }
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

    @Override
    public Text getName(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null) {
            String customName = generateCustomNameFromNBT(stack);
            return Text.translatable(customName);
        }
        return super.getName(stack);
    }
    public abstract void fire(World world, PlayerEntity player, double velocityModifier, ItemStack bulletItem, double damage);
}
