package com.spirit.shit.global.item.custom.gun;

import com.spirit.shit.data.common.Common;
import com.spirit.shit.data.common.GunItem;

import com.spirit.shit.data.common.GunProjectileItem;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.item.Item;

public class fnp90scopeItem extends GunItem {
    private static final int MAGAZINE_SIZE = 50;
    private static final int COOLDOWN = 2;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 1F;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("bullet"),
            Common.getBulletProjectileItemByType("rifle_bullet")
    };

    public fnp90scopeItem(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, ALLOWED_TYPES);
        this.SHOOT_SOUND = ShitSounds.M16_SHOOT;
    }
}