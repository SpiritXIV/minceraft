package com.spirit.ignite.global.sound;

import com.spirit.Main;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IgniteSounds {
    public static final SoundEvent BULLET_IMPACT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "bullet_impact"));
    public static final SoundEvent AK47_LOADED = SoundEvent.of(new Identifier(Main.IGNITE_ID, "ak47_loaded"));
    public static final SoundEvent AK47_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "ak47_shot"));
    public static final SoundEvent AK47_UNLOADED = SoundEvent.of(new Identifier(Main.IGNITE_ID, "ak47_unloaded"));
    public static final SoundEvent AWP_LOADED = SoundEvent.of(new Identifier(Main.IGNITE_ID, "awp_loaded"));
    public static final SoundEvent AWP_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "awp_shot"));
    public static final SoundEvent FLAMETHROWER_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "flamethrower_shot"));
    public static final SoundEvent FNP90_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "fnp90_shot"));
    public static final SoundEvent SHOTGUN_IMPACT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "shotgun_impact"));
    public static final SoundEvent SHOTGUN_RELOAD = SoundEvent.of(new Identifier(Main.IGNITE_ID, "shotgun_reload"));
    public static final SoundEvent SHOTGUN_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "shotgun_shot"));
    public static final SoundEvent GLOCK_17_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "glock_17_shot"));
    public static final SoundEvent GLOCK_17_LOADED = SoundEvent.of(new Identifier(Main.IGNITE_ID, "glock_17_loaded"));
    public static final SoundEvent M1_GARAND_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "m1_garand_shot"));
    public static final SoundEvent M1_GARAND_CLIP_EJECT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "m1_garand_clip_eject"));
    public static final SoundEvent M16_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "m16_shot"));
    public static final SoundEvent M16_LOADED = SoundEvent.of(new Identifier(Main.IGNITE_ID, "m16_loaded"));
    public static final SoundEvent PIN_PULL = SoundEvent.of(new Identifier(Main.IGNITE_ID, "pin_pull"));
    public static final SoundEvent GRENADE_EXPLODE = SoundEvent.of(new Identifier(Main.IGNITE_ID, "grenade_explode"));
    public static final SoundEvent FLASH_BANG_EXPLODE = SoundEvent.of(new Identifier(Main.IGNITE_ID, "flash_bang_explode"));
    public static final SoundEvent FLASH_BANG_RING = SoundEvent.of(new Identifier(Main.IGNITE_ID, "flash_bang_ring"));
    public static final SoundEvent REVOLVER_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "revolver_shot"));
    public static final SoundEvent SMOOTHBORE_SHOT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "smoothbore_shot"));
    public static final SoundEvent HIGH_CALIBER_IMPACT = SoundEvent.of(new Identifier(Main.IGNITE_ID, "high_caliber_impact"));
    public static final SoundEvent VOICES = SoundEvent.of(new Identifier(Main.IGNITE_ID, "voices"));

    static Map<String, Object> SOUNDS = Stream.of(new Object[][]{
            {"bullet_impact", BULLET_IMPACT},
            {"ak47_loaded", AK47_LOADED},
            {"ak47_shot", AK47_SHOT},
            {"ak47_unloaded", AK47_UNLOADED},
            {"awp_loaded", AWP_LOADED},
            {"awp_shot", AWP_SHOT},
            {"flamethrower_shot", FLAMETHROWER_SHOT},
            {"fnp90_shot", FNP90_SHOT},
            {"shotgun_impact", SHOTGUN_IMPACT},
            {"shotgun_reload", SHOTGUN_RELOAD},
            {"shotgun_shot", SHOTGUN_SHOT},
            {"glock_17_shot", GLOCK_17_SHOT},
            {"glock_17_loaded", GLOCK_17_LOADED},
            {"m1_garand_shot", M1_GARAND_SHOT},
            {"m1_garand_clip_eject", M1_GARAND_CLIP_EJECT},
            {"m16_shot", M16_SHOT},
            {"m16_loaded", M16_LOADED},
            {"pin_pull", PIN_PULL},
            {"grenade_explode", GRENADE_EXPLODE},
            {"flash_bang_explode", FLASH_BANG_EXPLODE},
            {"flash_bang_ring", FLASH_BANG_RING},
            {"smoothbore_shot", SMOOTHBORE_SHOT},
            {"high_caliber_impact", HIGH_CALIBER_IMPACT},
            {"voices", VOICES},
    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));


    public static void registerAll() {
        for (Map.Entry<String, Object> entry : SOUNDS.entrySet()) {
            String key = entry.getKey();
            SoundEvent value = (SoundEvent) entry.getValue();

            registerSoundEvent(key, value);
        }
    }
    private static void registerSoundEvent(String name, SoundEvent sound) {
        Identifier id = new Identifier(Main.IGNITE_ID, name);
        Registry.register(Registries.SOUND_EVENT, id, sound);
    }
}
