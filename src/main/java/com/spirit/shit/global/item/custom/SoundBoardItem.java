package com.spirit.shit.global.item.custom;

import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
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

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        world.playSoundFromEntity(null, player, ShitSounds.MEME_PLAY, SoundCategory.PLAYERS, 1.0F, 1.0F);
        player.getItemCooldownManager().set(this, 15);
        return ItemUsage.consumeHeldItem(world, player, hand);
    }
}