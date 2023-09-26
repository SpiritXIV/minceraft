package com.spirit.shit.item.custom.gun;

import com.spirit.shit.common.Common;
import com.spirit.shit.common.GunItem;

import com.spirit.shit.common.GunProjectileItem;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.item.Item;

public class M16Item extends GunItem {
    private static final int MAGAZINE_SIZE = 10;
    private static final int COOLDOWN = 2;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 2F;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("rifle")
    };

    public M16Item(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, ALLOWED_TYPES);
        this.SHOOT_SOUND = ShitSounds.M16_SHOOT;
    }
}