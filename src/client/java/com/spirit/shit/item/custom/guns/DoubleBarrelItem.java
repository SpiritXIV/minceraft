package com.spirit.shit.item.custom.guns;

import com.spirit.shit.common.GunItem;
import net.minecraft.item.Item;

public class DoubleBarrelItem extends GunItem {
    private static final int MAGAZINE_SIZE = 2;
    private static final int COOLDOWN = 55;

    public DoubleBarrelItem(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE);
    }
}