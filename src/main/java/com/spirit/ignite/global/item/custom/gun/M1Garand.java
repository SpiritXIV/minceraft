package com.spirit.ignite.global.item.custom.gun;

import com.spirit.ignite.data.common.Common;
import com.spirit.ignite.global.item.custom.GunItem;
import com.spirit.ignite.global.item.custom.GunProjectileItem;
import com.spirit.ignite.global.sound.IgniteSounds;
import net.minecraft.item.Item;

public class M1Garand extends GunItem {
    private static final int MAGAZINE_SIZE = 8;
    private static final int COOLDOWN = 40;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 4F;
    private static final int MAX_RANGE = 200;
    private static final int MAX_USE_TIME = 72000;
    private static final int ZOOM = 60;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("rifle_bullet"),
            Common.getBulletProjectileItemByType("rifle_bullet_gold"),
            Common.getBulletProjectileItemByType("rifle_bullet_iron"),
            Common.getBulletProjectileItemByType("rifle_bullet_incendiary"),
            Common.getBulletProjectileItemByType("rifle_bullet_explosive")
    };

    public M1Garand(Settings settings) {
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, MAX_RANGE, MAX_USE_TIME, ZOOM, ALLOWED_TYPES);
        this.SHOOT_SOUND = IgniteSounds.M1_GARAND_SHOT;
        this.IMPACT_SOUND = IgniteSounds.BULLET_IMPACT;
    }
}