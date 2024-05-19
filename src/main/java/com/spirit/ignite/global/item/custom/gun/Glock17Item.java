package com.spirit.ignite.global.item.custom.gun;

import com.spirit.ignite.data.common.Common;
import com.spirit.ignite.global.item.custom.GunItem;
import com.spirit.ignite.global.item.custom.GunProjectileItem;
import com.spirit.ignite.global.sound.IgniteSounds;
import net.minecraft.item.Item;

public class Glock17Item extends GunItem {
    private static final int MAGAZINE_SIZE = 17;
    private static final int COOLDOWN = 5;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 4F;
    private static final int MAX_RANGE = 200;
    private static final int MAX_USE_TIME = 1;
    private static final int ZOOM = 5;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("bullet"),
            Common.getBulletProjectileItemByType("bullet_gold"),
            Common.getBulletProjectileItemByType("bullet_iron"),
            Common.getBulletProjectileItemByType("bullet_incendiary"),
            Common.getBulletProjectileItemByType("bullet_explosive")
    };

    public Glock17Item(Item.Settings settings) {
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, MAX_RANGE, MAX_USE_TIME, ZOOM, ALLOWED_TYPES);
        this.SHOOT_SOUND = IgniteSounds.GLOCK_17_SHOT;
        this.RELOAD_SOUND = IgniteSounds.GLOCK_17_LOADED;
        this.IMPACT_SOUND = IgniteSounds.BULLET_IMPACT;
    }
}