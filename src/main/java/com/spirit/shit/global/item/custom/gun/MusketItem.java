package com.spirit.shit.global.item.custom.gun;

import com.spirit.shit.data.common.Common;
import com.spirit.shit.data.common.GunItem;
import com.spirit.shit.data.common.GunProjectileItem;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.item.Item;

public class MusketItem extends GunItem {
    private static final int MAGAZINE_SIZE = 1;
    private static final int COOLDOWN = 40;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 2F;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("bullet") //going to be musket once added
    };

    public MusketItem(Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, ALLOWED_TYPES);
        this.SHOOT_SOUND = ShitSounds.M16_SHOOT;
    }
}