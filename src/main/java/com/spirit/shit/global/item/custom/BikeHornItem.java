package com.spirit.shit.global.item.custom;

import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Random;

public class BikeHornItem extends Item {
    public final double rareSoundChance = 0.01;

    public BikeHornItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (new Random().nextDouble() < rareSoundChance) {
            world.playSoundFromEntity(null, player, ShitSounds.BIKEHORN_RARE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            player.emitGameEvent(GameEvent.INSTRUMENT_PLAY);
            player.getItemCooldownManager().set(this, 20);
        } else {
            world.playSoundFromEntity(null, player, ShitSounds.BIKEHORN, SoundCategory.PLAYERS, 1.0f, 1.0f);
            player.emitGameEvent(GameEvent.INSTRUMENT_PLAY);
            player.getItemCooldownManager().set(this, 20);
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (new Random().nextDouble() < rareSoundChance) {
            attacker.getWorld().playSoundFromEntity(null, target, ShitSounds.BIKEHORN_RARE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            target.emitGameEvent(GameEvent.INSTRUMENT_PLAY);
        } else {
            attacker.getWorld().playSoundFromEntity(null, target, ShitSounds.BIKEHORN, SoundCategory.PLAYERS, 1.0f, 1.0f);
            target.emitGameEvent(GameEvent.INSTRUMENT_PLAY);
        }

        return super.postHit(stack, target, attacker);
    }
}
