package com.spirit.shit.item.custom.guns;

import com.spirit.shit.common.GunItem;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.item.Item;

public class DoubleBarrelItem extends GunItem {
    private static final int MAGAZINE_SIZE = 2;
    private static final int COOLDOWN = 55;
    private static final float DAMAGE = 0.5F;

    public DoubleBarrelItem(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, DAMAGE);
        this.SHOOT_SOUND = ShitSounds.SHOTGUN_SHOOT;
    }
}