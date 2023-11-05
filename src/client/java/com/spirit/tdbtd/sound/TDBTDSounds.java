package com.spirit.tdbtd.sound;

import com.spirit.Main;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TDBTDSounds {
    public static final SoundEvent SHRIEKER = SoundEvent.of(new Identifier(Main.TDBTD_ID, "shrieker"));
    public static final SoundEvent THE_WARDEN = SoundEvent.of(new Identifier(Main.TDBTD_ID,"the_warden"));
    public static final SoundEvent WARDEN_RUN = SoundEvent.of(new Identifier(Main.TDBTD_ID,"warden_run"));
    public static final SoundEvent POLLO_ONE_BEAM = SoundEvent.of(new Identifier(Main.TDBTD_ID,"pollo_one_beam"));


    static Map<String, Object> SOUNDS = Stream.of(new Object[][]{
            {"shrieker", SHRIEKER},
            {"the_warden", THE_WARDEN},
            {"warden_run", WARDEN_RUN},
            {"pollo_one_beam", POLLO_ONE_BEAM},
    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));


    public static void registerAll() {
        for (Map.Entry<String, Object> entry : SOUNDS.entrySet()) {
            String key = entry.getKey();
            SoundEvent value = (SoundEvent) entry.getValue();

            registerSoundEvent(key, value);
        }
    }

    private static void registerSoundEvent(String name, SoundEvent sound) {
        Identifier id = new Identifier(Main.TDBTD_ID, name);
        Registry.register(Registries.SOUND_EVENT, id, sound);
    }
}