package com.spirit.shit.global.item.custom.gun;

import com.spirit.shit.data.common.Common;
import com.spirit.shit.data.common.GunItem;

import com.spirit.shit.data.common.GunProjectileItem;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.item.Item;

public class Striker12Item extends GunItem {
    private static final int MAGAZINE_SIZE = 12;
    private static final int COOLDOWN = 10;
    private static final float DAMAGE = 2F;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("shell"),
            Common.getBulletProjectileItemByType("slug")
    };

    public Striker12Item(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, DAMAGE, ALLOWED_TYPES);
        this.SHOOT_SOUND = ShitSounds.RIFLE_SHOOT;
    }
}