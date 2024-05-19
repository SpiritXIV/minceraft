package com.spirit.ignite.global.item.custom.explosive;

import com.spirit.ignite.global.item.IgniteItems;
import com.spirit.ignite.global.item.custom.ExplosiveItem;
import com.spirit.ignite.global.sound.IgniteSounds;

public class FlashBangItem extends ExplosiveItem {
    private static final long EXPLOSION_DELAY = 5000; // 5 seconds in milliseconds
    private static final float DAMAGE = 10F;
    private static final int POWER = 3;
    private static final int COOLDOWN = 60;
    private static final int COUNTDOWNTICKS = 100;

    public FlashBangItem(Settings settings) {
        super(settings, EXPLOSION_DELAY, (int) DAMAGE, POWER, COOLDOWN, COUNTDOWNTICKS, IgniteItems.FLASH_BANG);
        PINPULL_SOUND = IgniteSounds.PIN_PULL;
        DETONATE_SOUND = IgniteSounds.FLASH_BANG_EXPLODE;
    }
}