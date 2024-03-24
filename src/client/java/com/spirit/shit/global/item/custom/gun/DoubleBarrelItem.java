package com.spirit.shit.global.item.custom.gun;

import com.spirit.shit.data.common.Common;
import com.spirit.shit.data.common.GunItem;

import com.spirit.shit.data.common.GunProjectileItem;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.item.Item;

public class DoubleBarrelItem extends GunItem { // BUBBLE BARREL BOT BUN
    private static final int MAGAZINE_SIZE = 2;
    private static final int COOLDOWN = 55;
    private static final float DAMAGE = 0.5F;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("shell"),
            Common.getBulletProjectileItemByType("slug")
    };

    public DoubleBarrelItem(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, MAGAZINE_SIZE, COOLDOWN, DAMAGE, ALLOWED_TYPES);
        this.SHOOT_SOUND = ShitSounds.SHOTGUN_SHOOT;
    }
}