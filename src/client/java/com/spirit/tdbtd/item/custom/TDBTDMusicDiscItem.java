package com.spirit.tdbtd.item.custom;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;

public class TDBTDMusicDiscItem extends MusicDiscItem {
    public TDBTDMusicDiscItem(int comparatorOutput, SoundEvent sound, Settings settings, int lengthInSeconds) {
        super(comparatorOutput, sound, settings, lengthInSeconds * 20);
    }
}
