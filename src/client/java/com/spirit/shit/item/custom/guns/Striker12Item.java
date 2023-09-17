package com.spirit.shit.item.custom.guns;

import com.spirit.shit.common.GunItem;
import net.minecraft.item.Item;

public class Striker12Item extends GunItem {
    private static final int MAGAZINE_SIZE = 12;
    private static final int COOLDOWN = 20;

    public Striker12Item(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE);
    }
}