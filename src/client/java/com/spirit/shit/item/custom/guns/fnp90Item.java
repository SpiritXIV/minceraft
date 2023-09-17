package com.spirit.shit.item.custom.guns;

import com.spirit.shit.common.GunItem;
import net.minecraft.item.Item;

public class fnp90Item extends GunItem {
    private static final int MAGAZINE_SIZE = 50;
    private static final int COOLDOWN = 2;
    private static final int ITEM_BAR_COLOR = 0x00FF00;

    public fnp90Item(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR);
    }
}