package com.spirit.shit.item.custom;

import com.spirit.shit.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SoundBoardItem extends Item {

    public SoundBoardItem(Item.Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 1200;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(ShitSounds.MEME_PLAY, 1.0F, 1.0F);
            return ItemUsage.consumeHeldItem(world, user, hand);
    }
}