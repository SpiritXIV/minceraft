package com.spirit.shit.item.custom.guns;

import com.spirit.shit.common.GunItem;
import net.minecraft.item.Item;

public class RevolverItem extends GunItem {
    private static final int MAGAZINE_SIZE = 5;
    private static final int COOLDOWN = 25;

    public RevolverItem(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE);
    }
}