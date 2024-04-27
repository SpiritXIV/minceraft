package com.spirit.shit.global.sound;

import com.spirit.Main;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShitSounds {
    //BLOCKS
    public static final SoundEvent LIGHT_BUZZING = SoundEvent.of(new Identifier(Main.SHIT_ID, "light_buzzing"));
    public static final SoundEvent LIGHT_FLICKER = SoundEvent.of(new Identifier(Main.SHIT_ID, "light_flicker"));
    public static final SoundEvent FALL_INTO_BACKROOMS = SoundEvent.of(new Identifier(Main.SHIT_ID, "fall_into_backrooms"));
    public static final SoundEvent VENT_AMBIENT = SoundEvent.of(new Identifier(Main.SHIT_ID, "vent_ambient"));
    public static final SoundEvent MICROWAVE_RUNNING = SoundEvent.of(new Identifier(Main.SHIT_ID, "microwave_running"));
    public static final SoundEvent MICROWAVE_BEEP = SoundEvent.of(new Identifier(Main.SHIT_ID, "microwave_beep"));
    public static final SoundEvent MICROWAVE_OPEN_DOOR = SoundEvent.of(new Identifier(Main.SHIT_ID, "microwave_open_door"));
    public static final SoundEvent MICROWAVE_CLOSE_DOOR = SoundEvent.of(new Identifier(Main.SHIT_ID, "microwave_close_door"));
    public static final SoundEvent RADIO_TUNE = SoundEvent.of(new Identifier(Main.SHIT_ID, "radio_tune"));
    public static final SoundEvent SODA = SoundEvent.of(new Identifier(Main.SHIT_ID, "soda"));
    public static final SoundEvent JBIRD_SODA = SoundEvent.of(new Identifier(Main.SHIT_ID, "jbird_soda"));
    public static final SoundEvent MEME_PLAY = SoundEvent.of(new Identifier(Main.SHIT_ID, "meme_play"));
    public static final SoundEvent GIANT_CRUNCH = SoundEvent.of(new Identifier(Main.SHIT_ID, "giant_crunch"));
    public static final SoundEvent BRICK_THROWN = SoundEvent.of(new Identifier(Main.SHIT_ID, "brick_thrown"));
    public static final SoundEvent BRICK_LAND = SoundEvent.of(new Identifier(Main.SHIT_ID, "brick_land"));
    public static final SoundEvent CAN_HIT = SoundEvent.of(new Identifier(Main.SHIT_ID, "can_hit"));
    public static final SoundEvent GLASS_BOTTLE_THROWN = SoundEvent.of(new Identifier(Main.SHIT_ID, "glass_bottle_thrown"));
    public static final SoundEvent PLASTIC_BOTTLE_THROWN = SoundEvent.of(new Identifier(Main.SHIT_ID, "plastic_bottle_thrown"));
    public static final SoundEvent PLASTIC_BOTTLE_HIT = SoundEvent.of(new Identifier(Main.SHIT_ID, "plastic_bottle_hit"));
    public static final SoundEvent GROAN_TUBE_UP = SoundEvent.of(new Identifier(Main.SHIT_ID, "groan_tube_up"));
    public static final SoundEvent GROAN_TUBE_DOWN = SoundEvent.of(new Identifier(Main.SHIT_ID, "groan_tube_down"));
    public static final SoundEvent RUBBER_CHICKEN = SoundEvent.of(new Identifier(Main.SHIT_ID, "rubber_chicken"));
    public static final SoundEvent AIRHORN_START = SoundEvent.of(new Identifier(Main.SHIT_ID, "airhorn_start"));
    public static final SoundEvent AIRHORN_LOOP = SoundEvent.of(new Identifier(Main.SHIT_ID, "airhorn_loop"));
    public static final SoundEvent AIRHORN_REFILL = SoundEvent.of(new Identifier(Main.SHIT_ID, "airhorn_refill"));
    public static final SoundEvent BIKEHORN = SoundEvent.of(new Identifier(Main.SHIT_ID, "bikehorn"));
    public static final SoundEvent CLOWNHORN = SoundEvent.of(new Identifier(Main.SHIT_ID, "clownhorn"));
    public static final SoundEvent BIKEHORN_RARE = SoundEvent.of(new Identifier(Main.SHIT_ID, "bikehorn_rare"));
    public static final SoundEvent BULLET_IMPACT = SoundEvent.of(new Identifier(Main.SHIT_ID, "bullet_impact"));
    public static final SoundEvent HUNTING_RIFLE_SHOOT = SoundEvent.of(new Identifier(Main.SHIT_ID, "hunting_rifle_shoot"));
    public static final SoundEvent M16_SHOOT = SoundEvent.of(new Identifier(Main.SHIT_ID, "m16_shoot"));
    public static final SoundEvent PISTOL_SHOOT = SoundEvent.of(new Identifier(Main.SHIT_ID, "pistol_shoot"));
    public static final SoundEvent REVOLVER_SHOOT = SoundEvent.of(new Identifier(Main.SHIT_ID, "revolver_shoot"));
    public static final SoundEvent RIFLE_SHOOT = SoundEvent.of(new Identifier(Main.SHIT_ID, "rifle_shoot"));
    public static final SoundEvent SHOTGUN_SHOOT = SoundEvent.of(new Identifier(Main.SHIT_ID, "shotgun_shoot"));
    public static final SoundEvent SNIPER_SHOOT = SoundEvent.of(new Identifier(Main.SHIT_ID, "sniper_shoot"));
    public static final SoundEvent JBIRD_SPEAK = SoundEvent.of(new Identifier(Main.SHIT_ID, "jbird_speak"));
    public static final SoundEvent JBIRD_HURT = SoundEvent.of(new Identifier(Main.SHIT_ID, "jbird_hurt"));
    public static final SoundEvent IM_SLIM = SoundEvent.of(new Identifier(Main.SHIT_ID, "im_slim"));
    public static final SoundEvent FREE_BIRD = SoundEvent.of(new Identifier(Main.SHIT_ID, "free_bird"));
    public static final SoundEvent CAPYBARA_PULLS_UP = SoundEvent.of(new Identifier(Main.SHIT_ID, "capybara_pulls_up"));
    public static final SoundEvent YIPPEE = SoundEvent.of(new Identifier(Main.SHIT_ID, "yippee"));
    public static final SoundEvent EXPLODE_SOUND_COMMAND = SoundEvent.of(new Identifier(Main.SHIT_ID, "explode_sound_command"));
    public static final SoundEvent NOTHING = SoundEvent.of(new Identifier(Main.SHIT_ID, "nothing"));
    public static final SoundEvent SILENT_HOUSES = SoundEvent.of(new Identifier(Main.SHIT_ID, "silent_houses"));
    public static final SoundEvent FREE_BIRD_DISC = SoundEvent.of(new Identifier(Main.SHIT_ID, "free_bird_disc"));
    public static final SoundEvent AFTER_PARTY_DISC = SoundEvent.of(new Identifier(Main.SHIT_ID, "after_party"));
    public static final SoundEvent VILLAGER_AFTERPARTY = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_afterparty"));
    public static final SoundEvent VILLAGER_ALLSTAR = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_allstar"));
    public static final SoundEvent VILLAGER_BALLIN = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_ballin"));
    public static final SoundEvent VILLAGER_BEGGIN = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_beggin"));
    public static final SoundEvent VILLAGER_BILLIEJEAN = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_billiejean"));
    public static final SoundEvent VILLAGER_BUDDYHOLLY = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_buddyholly"));
    public static final SoundEvent VILLAGER_CUPID = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_cupid"));
    public static final SoundEvent VILLAGER_DONTSTOPMENOW = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_dontstopmenow"));
    public static final SoundEvent VILLAGER_FIREFLIES = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_fireflies"));
    public static final SoundEvent VILLAGER_FLYMETOTHEMOON = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_flymetothemoon"));
    public static final SoundEvent VILLAGER_FNAF = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_fnaf"));
    public static final SoundEvent VILLAGER_FREEBIRD = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_freebird"));
    public static final SoundEvent VILLAGER_GANGSTAPARADISE = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_gangstaparadise"));
    public static final SoundEvent VILLAGER_GOLDENHOUR = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_goldenhour"));
    public static final SoundEvent VILLAGER_HARDERBETTER = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_harderbetter"));
    public static final SoundEvent VILLAGER_HISWORLD = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_hisworld"));
    public static final SoundEvent VILLAGER_HOWBADCANIBE = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_howbadcanibe"));
    public static final SoundEvent VILLAGER_LIFECOULDBEDREAMS = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_lifecouldbedreams"));
    public static final SoundEvent VILLAGER_MONSTER = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_monster"));
    public static final SoundEvent VILLAGER_MYWAY = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_myway"));
    public static final SoundEvent VILLAGER_OPPENGANGNAMSTYLE = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_oppengangnamstyle"));
    public static final SoundEvent VILLAGER_PEACHES = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_peaches"));
    public static final SoundEvent VILLAGER_SMOOTHCRIMINAL = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_smoothcriminal"));
    public static final SoundEvent VILLAGER_SOMEBODYIUSETOKNOW = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_somebodyiusetoknow"));
    public static final SoundEvent VILLAGER_TAKEONME = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_takeonme"));
    public static final SoundEvent VILLAGER_WHATISLOVE = SoundEvent.of(new Identifier(Main.SHIT_ID, "villager_whatislove"));
    public static final SoundEvent RIFF = SoundEvent.of(new Identifier(Main.SHIT_ID, "riff"));

    static Map<String, Object> SOUNDS = Stream.of(new Object[][]{
            {"light_buzzing", LIGHT_BUZZING},
            {"light_flicker", LIGHT_FLICKER},
            {"fall_into_backrooms", FALL_INTO_BACKROOMS},
            {"vent_ambient", VENT_AMBIENT},
            {"microwave_running", MICROWAVE_RUNNING},
            {"microwave_beep", MICROWAVE_BEEP},
            {"microwave_open_door", MICROWAVE_OPEN_DOOR},
            {"microwave_close_door", MICROWAVE_CLOSE_DOOR},
            {"soda", SODA},
            {"jbird_soda", JBIRD_SODA},
            {"meme_play", MEME_PLAY},
            {"giant_crunch", GIANT_CRUNCH},
            {"brick_thrown", BRICK_THROWN},
            {"brick_land", BRICK_LAND},
            {"can_hit", CAN_HIT},
            {"glass_bottle_thrown", GLASS_BOTTLE_THROWN},
            {"plastic_bottle_thrown", PLASTIC_BOTTLE_THROWN},
            {"plastic_bottle_hit", PLASTIC_BOTTLE_HIT},
            {"bullet_impact", BULLET_IMPACT},
            {"hunting_rifle_shoot", HUNTING_RIFLE_SHOOT},
            {"m16_shoot", M16_SHOOT},
            {"pistol_shoot", PISTOL_SHOOT},
            {"revolver_shoot", REVOLVER_SHOOT},
            {"rifle_shoot", RIFLE_SHOOT},
            {"shotgun_shoot", SHOTGUN_SHOOT},
            {"sniper_shoot", SNIPER_SHOOT},
            {"jbird_speak", JBIRD_SPEAK},
            {"jbird_hurt", JBIRD_HURT},
            {"im_slim", IM_SLIM},
            {"free_bird", FREE_BIRD},
            {"capybara_pulls_up", CAPYBARA_PULLS_UP},
            {"yippee", YIPPEE},
            {"explode_sound_command", EXPLODE_SOUND_COMMAND},
            {"nothing", NOTHING},
            {"silent_houses", SILENT_HOUSES},
            {"free_bird_disc", FREE_BIRD_DISC},
            {"after_party", AFTER_PARTY_DISC},
            {"villager_afterparty", VILLAGER_AFTERPARTY},
            {"villager_allstar", VILLAGER_ALLSTAR},
            {"villager_ballin", VILLAGER_BALLIN},
            {"villager_beggin", VILLAGER_BEGGIN},
            {"villager_billiejean", VILLAGER_BILLIEJEAN},
            {"villager_buddyholly", VILLAGER_BUDDYHOLLY},
            {"villager_cupid", VILLAGER_CUPID},
            {"villager_dontstopmenow", VILLAGER_DONTSTOPMENOW},
            {"villager_fireflies", VILLAGER_FIREFLIES},
            {"villager_flymetothemoon", VILLAGER_FLYMETOTHEMOON},
            {"villager_fnaf", VILLAGER_FNAF},
            {"villager_freebird", VILLAGER_FREEBIRD},
            {"villager_gangstaparadise", VILLAGER_GANGSTAPARADISE},
            {"villager_goldenhour", VILLAGER_GOLDENHOUR},
            {"villager_harderbetter", VILLAGER_HARDERBETTER},
            {"villager_hisworld", VILLAGER_HISWORLD},
            {"villager_howbadcanibe", VILLAGER_HOWBADCANIBE},
            {"villager_lifecouldbedreams", VILLAGER_LIFECOULDBEDREAMS},
            {"villager_monster", VILLAGER_MONSTER},
            {"villager_myway", VILLAGER_MYWAY},
            {"villager_oppengangnamstyle", VILLAGER_OPPENGANGNAMSTYLE},
            {"villager_peaches", VILLAGER_PEACHES},
            {"villager_smoothcriminal", VILLAGER_SMOOTHCRIMINAL},
            {"villager_somebodyiusetoknow", VILLAGER_SOMEBODYIUSETOKNOW},
            {"villager_takeonme", VILLAGER_TAKEONME},
            {"villager_whatislove", VILLAGER_WHATISLOVE},
            {"rubber_chicken", RUBBER_CHICKEN},
            {"riff", RIFF}
    }).collect(Collectors.toMap(entry -> (String) entry[0], entry -> entry[1]));


    public static void registerAll() {
        for (Map.Entry<String, Object> entry : SOUNDS.entrySet()) {
            String key = entry.getKey();
            SoundEvent value = (SoundEvent) entry.getValue();

            registerSoundEvent(key, value);
        }
    }
    private static void registerSoundEvent(String name, SoundEvent sound) {
        Identifier id = new Identifier(Main.SHIT_ID, name);
        Registry.register(Registries.SOUND_EVENT, id, sound);
    }
}
