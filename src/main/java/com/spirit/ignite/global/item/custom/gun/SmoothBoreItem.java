package com.spirit.ignite.global.item.custom.gun;

import com.spirit.ignite.data.common.Common;
import com.spirit.ignite.global.item.custom.GunItem;
import com.spirit.ignite.global.item.custom.GunProjectileItem;
import com.spirit.ignite.global.sound.IgniteSounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SmoothBoreItem extends GunItem {
    private static final int MAGAZINE_SIZE = 13;
    private static final int COOLDOWN = 14800;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 48F;
    private static final int MAX_RANGE = 500;
    private static final int MAX_USE_TIME = 1;
    private static final int ZOOM = 30;
    private static final Item[] ALLOWED_TYPES = new GunProjectileItem[] {
            Common.getBulletProjectileItemByType("high_caliber_bullet"),
            Common.getBulletProjectileItemByType("high_caliber_bullet_gold"),
            Common.getBulletProjectileItemByType("high_caliber_bullet_iron"),
            Common.getBulletProjectileItemByType("high_caliber_bullet_incendiary"),
            Common.getBulletProjectileItemByType("high_caliber_bullet_explosive")
    };

    public SmoothBoreItem(Settings settings) {
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE, MAX_RANGE, MAX_USE_TIME, ZOOM, ALLOWED_TYPES);
        this.SHOOT_SOUND = IgniteSounds.SMOOTHBORE_SHOT;
        this.RELOAD_SOUND = IgniteSounds.AWP_LOADED;
        this.IMPACT_SOUND = IgniteSounds.HIGH_CALIBER_IMPACT;
    }

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Random random = new Random();


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient) {
            int delay = 180 + random.nextInt(61);

            scheduler.schedule(() -> {
                if (entity.getHandItems() instanceof SmoothBoreItem) {
                    MinecraftClient.getInstance().execute(() -> {
                        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(IgniteSounds.VOICES, 1.0F));
                    });                }
            }, delay, TimeUnit.SECONDS);        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}