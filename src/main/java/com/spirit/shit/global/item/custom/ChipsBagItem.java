package com.spirit.shit.global.item.custom;

import com.spirit.shit.global.item.ShitItems;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ChipsBagItem extends Item {

    private static final int MAX_USES = 9;
    private int remainingUses;

    public ChipsBagItem(Settings settings) {
        super(settings);
        this.remainingUses = MAX_USES;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
            this.remainingUses--;
            if (this.remainingUses <= 0) {
                return new ItemStack(Items.AIR);
            }
        }
        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public SoundEvent getDrinkSound() {
        return ShitSounds.NOTHING;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_EAT;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack heldItemStack = user.getStackInHand(hand);
            if (heldItemStack.getItem() instanceof ChipsBagItem) {
                ChipsBagItem item = (ChipsBagItem) heldItemStack.getItem();
                int chipsToGive = (int) Math.ceil((double) item.remainingUses / MAX_USES * heldItemStack.getMaxCount());
                item.remainingUses = 0;
                ItemStack emptyBagStack = new ItemStack(Items.AIR);
                if (!user.getInventory().insertStack(new ItemStack(ShitItems.PLAIN_CHIPS, chipsToGive))) {
                    ItemScatterer.spawn(world, user.getBlockPos().getX(), user.getBlockPos().getY(), user.getBlockPos().getZ(), new ItemStack(ShitItems.PLAIN_CHIPS, chipsToGive)); // Replace with your chips item
                }
                user.setStackInHand(hand, emptyBagStack);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
