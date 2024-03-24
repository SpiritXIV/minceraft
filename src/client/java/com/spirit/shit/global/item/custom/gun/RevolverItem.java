package com.spirit.shit.global.item.custom.gun;

import com.spirit.shit.data.common.Common;
import com.spirit.shit.data.common.GunItem;

import com.spirit.shit.data.common.GunProjectileItem;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.item.Item;

public class RevolverItem extends GunItem {
    private static final int MAGAZINE_SIZE = 5;
    private static final int COOLDOWN = 25;
    private static final float DAMAGE = 8F;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("bullet")
    };

    public RevolverItem(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, DAMAGE, ALLOWED_TYPES);
        this.SHOOT_SOUND = ShitSounds.REVOLVER_SHOOT;
    }
}