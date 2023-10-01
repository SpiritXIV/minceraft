package com.spirit.shit.item.custom.gun;

import com.spirit.shit.common.Common;
import com.spirit.shit.common.GunItem;
import com.spirit.shit.common.GunProjectileItem;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.item.Item;

public class M1GarandItem extends GunItem {
    private static final int MAGAZINE_SIZE = 8;
    private static final int COOLDOWN = 20;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 2F;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("bullet")
    };

    public M1GarandItem(Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, ALLOWED_TYPES);
        this.SHOOT_SOUND = ShitSounds.M16_SHOOT;
    }
}