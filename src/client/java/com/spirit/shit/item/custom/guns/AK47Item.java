package com.spirit.shit.item.custom.guns;

import com.spirit.shit.common.GunItem;
import com.spirit.shit.sound.ShitSounds;
import net.minecraft.item.Item;

public class AK47Item extends GunItem {
    private static final int MAGAZINE_SIZE = 30;
    private static final int COOLDOWN = 2;
    private static final int ITEM_BAR_COLOR = 0x00FF00;
    private static final float DAMAGE = 1F;

    public AK47Item(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR, DAMAGE);
        this.SHOOT_SOUND = ShitSounds.RIFLE_SHOOT;
    }
}