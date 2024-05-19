package com.spirit.ignite.global.item.custom.gun;

import com.spirit.ignite.data.common.Common;
import com.spirit.ignite.global.item.custom.GunItem;
import com.spirit.ignite.global.item.custom.GunProjectileItem;
import com.spirit.ignite.global.sound.IgniteSounds;
import net.minecraft.item.Item;

public class DoubleBarrelItem extends /*Make ShotGun Class*/GunItem {
    private static final int MAGAZINE_SIZE = 2;
    private static final int COOLDOWN = 20;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 4.5F;
    private static final int MAX_RANGE = 200;
    private static final int MAX_USE_TIME = 1;
    private static final int ZOOM = 60;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("shell"),
            Common.getBulletProjectileItemByType("shell_magnum"),
            Common.getBulletProjectileItemByType("shell_shorty"),
            Common.getBulletProjectileItemByType("slug"),
            Common.getBulletProjectileItemByType("slug_heavy"),
            Common.getBulletProjectileItemByType("slug_incendiary"),
            Common.getBulletProjectileItemByType("slug_explosive")
    };

    public DoubleBarrelItem(Settings settings) {
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, MAX_RANGE, MAX_USE_TIME, ZOOM, ALLOWED_TYPES);
        this.SHOOT_SOUND = IgniteSounds.SHOTGUN_SHOT;
        this.RELOAD_SOUND = IgniteSounds.SHOTGUN_RELOAD;
        this.IMPACT_SOUND = IgniteSounds.SHOTGUN_IMPACT;
    }
}