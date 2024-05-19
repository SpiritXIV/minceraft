package com.spirit.ignite.global.item.custom.gun;

import com.spirit.ignite.data.common.Common;
import com.spirit.ignite.global.item.custom.GunItem;
import com.spirit.ignite.global.item.custom.GunProjectileItem;
import com.spirit.ignite.global.sound.IgniteSounds;
import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.item.Item;

public class FlameThrower extends GunItem {
    private static final int MAGAZINE_SIZE = 128;
    private static final int COOLDOWN = 1;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 5F;
    private static final int MAX_RANGE = 200;
    private static final int MAX_USE_TIME = 72000;
    private static final int ZOOM = 60;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("bullet")
    };

    public FlameThrower(Settings settings) {
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, MAX_RANGE, MAX_USE_TIME, ZOOM, ALLOWED_TYPES);
        this.SHOOT_SOUND = IgniteSounds.FLAMETHROWER_SHOT;
        this.IMPACT_SOUND = ShitSounds.NOTHING;
    }
}