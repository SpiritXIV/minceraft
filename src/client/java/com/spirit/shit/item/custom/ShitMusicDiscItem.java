package com.spirit.shit.item.custom;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;

public class ShitMusicDiscItem extends MusicDiscItem {
    public ShitMusicDiscItem(int comparatorOutput, SoundEvent sound, Settings settings, int lengthInSeconds) {
        super(comparatorOutput, sound, settings, lengthInSeconds * 20);
    }
}
