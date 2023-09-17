package com.spirit.shit.item.custom.guns;

import com.spirit.shit.common.GunItem;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;

public class Striker12Item extends GunItem {
    private static final int MAGAZINE_SIZE = 12;
    private static final int COOLDOWN = 10;


    public Striker12Item(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE);
    }
}