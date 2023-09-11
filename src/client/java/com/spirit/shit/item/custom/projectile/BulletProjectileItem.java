package com.spirit.shit.item.custom.projectile;

import com.spirit.shit.item.ShitItems;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class BulletProjectileItem extends Item {
    public BulletProjectileItem(Settings settings) {
        super(settings);
    }
}
