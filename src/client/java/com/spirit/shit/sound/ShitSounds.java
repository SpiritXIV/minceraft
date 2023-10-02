package com.spirit.shit.sound;

import com.spirit.shit.ShitMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ShitSounds {

    //BLOCKS
    public static final SoundEvent LIGHT_BUZZING = registerSoundEvent("light_buzzing");
    public static final SoundEvent LIGHT_FLICKER = registerSoundEvent("light_flicker");
    public static final SoundEvent FALL_INTO_BACKROOMS = registerSoundEvent("fall_into_backrooms");
    public static final SoundEvent VENT_AMBIENT = registerSoundEvent("vent_ambient");
    public static final SoundEvent MICROWAVE_RUNNING = registerSoundEvent("microwave_running");
    public static final SoundEvent MICROWAVE_BEEP = registerSoundEvent("microwave_beep");
    public static final SoundEvent MICROWAVE_OPEN_DOOR = registerSoundEvent("microwave_open_door");
    public static final SoundEvent MICROWAVE_CLOSE_DOOR = registerSoundEvent("microwave_close_door");

    //PLUSH
    public static final SoundEvent TALON_SPEAK = registerSoundEvent("talon_speak");


    //ITEMS
    public static final SoundEvent SODA = registerSoundEvent("soda");
    public static final SoundEvent JBIRD_SODA = registerSoundEvent("jbird_soda");
    public static final SoundEvent MEME_PLAY = registerSoundEvent("meme_play");
    public static final SoundEvent GIANT_CRUNCH = registerSoundEvent("giant_crunch");
    public static final SoundEvent BRICK_THROWN = registerSoundEvent("brick_thrown");
    public static final SoundEvent BRICK_LAND = registerSoundEvent("brick_land");

    public static final SoundEvent CAN_HIT = registerSoundEvent("can_hit");

    public static final SoundEvent GLASS_BOTTLE_THROWN = registerSoundEvent("glass_bottle_thrown");

    public static final SoundEvent PLASTIC_BOTTLE_THROWN = registerSoundEvent("plastic_bottle_thrown");

    public static final SoundEvent PLASTIC_BOTTLE_HIT = registerSoundEvent("plastic_bottle_hit");

    public static final SoundEvent BULLET_IMPACT = registerSoundEvent("bullet_impact");



    //GUNS
    public static final SoundEvent HUNTING_RIFLE_SHOOT = registerSoundEvent("hunting_rifle_shoot");
    public static final SoundEvent M16_SHOOT = registerSoundEvent("m16_shoot");
    public static final SoundEvent PISTOL_SHOOT = registerSoundEvent("pistol_shoot");
    public static final SoundEvent REVOLVER_SHOOT = registerSoundEvent("revolver_shoot");
    public static final SoundEvent RIFLE_SHOOT = registerSoundEvent("rifle_shoot");
    public static final SoundEvent SHOTGUN_SHOOT = registerSoundEvent("shotgun_shoot");
    public static final SoundEvent SNIPER_SHOOT = registerSoundEvent("sniper_shoot");


    //ENTITES
    public static final SoundEvent JBIRD_SPEAK = registerSoundEvent("jbird_speak");
    public static final SoundEvent JBIRD_HURT = registerSoundEvent("jbird_hurt");
    public static final SoundEvent IM_SLIM = registerSoundEvent("im_slim");
    public static final SoundEvent FREE_BIRD = registerSoundEvent("free_bird");
    public static final SoundEvent CAPYBARA_PULLS_UP = registerSoundEvent("capybara_pulls_up");
    public static final SoundEvent YIPPEE = registerSoundEvent("yippee");

    //COMMAND
    public static final SoundEvent EXPLODE_SOUND_COMMAND = registerSoundEvent("explode_sound_command");

    public static final SoundEvent NOTHING = registerSoundEvent("nothing");


    //MUSIC DISCS
    public static final SoundEvent SILENT_HOUSES = registerSoundEvent("silent_houses");
    public static final SoundEvent FREE_BIRD_DISC = registerSoundEvent("free_bird_disc");
    public static final SoundEvent AFTER_PARTY_DISC = registerSoundEvent("after_party");


    public static final SoundEvent VILLAGER_AFTERPARTY = registerSoundEvent("villager_afterparty");
    public static final SoundEvent VILLAGER_ALLSTAR = registerSoundEvent("villager_allstar");
    public static final SoundEvent VILLAGER_BALLIN = registerSoundEvent("villager_ballin");
    public static final SoundEvent VILLAGER_BEGGIN = registerSoundEvent("villager_beggin");
    public static final SoundEvent VILLAGER_BILLIEJEAN = registerSoundEvent("villager_billiejean");
    public static final SoundEvent VILLAGER_BUDDYHOLLY = registerSoundEvent("villager_buddyholly");
    public static final SoundEvent VILLAGER_CUPID = registerSoundEvent("villager_cupid");
    public static final SoundEvent VILLAGER_DONTSTOPMENOW = registerSoundEvent("villager_dontstopmenow");
    public static final SoundEvent VILLAGER_FIREFLIES = registerSoundEvent("villager_fireflies");
    public static final SoundEvent VILLAGER_FLYMETOTHEMOON = registerSoundEvent("villager_flymetothemoon");
    public static final SoundEvent VILLAGER_FNAF = registerSoundEvent("villager_fnaf");
    public static final SoundEvent VILLAGER_FREEBIRD = registerSoundEvent("villager_freebird");
    public static final SoundEvent VILLAGER_GANGSTAPARADISE = registerSoundEvent("villager_gangstaparadise");
    public static final SoundEvent VILLAGER_GOLDENHOUR = registerSoundEvent("villager_goldenhour");
    public static final SoundEvent VILLAGER_HARDERBETTER = registerSoundEvent("villager_harderbetter");
    public static final SoundEvent VILLAGER_HISWORLD = registerSoundEvent("villager_hisworld");
    public static final SoundEvent VILLAGER_HOWBADCANIBE = registerSoundEvent("villager_howbadcanibe");
    public static final SoundEvent VILLAGER_LIFECOULDBEDREAMS = registerSoundEvent("villager_lifecouldbedreams");
    public static final SoundEvent VILLAGER_MONSTER = registerSoundEvent("villager_monster");
    public static final SoundEvent VILLAGER_MYWAY = registerSoundEvent("villager_myway");
    public static final SoundEvent VILLAGER_OPPENGANGNAMSTYLE = registerSoundEvent("villager_oppengangnamstyle");
    public static final SoundEvent VILLAGER_PEACHES = registerSoundEvent("villager_peaches");
    public static final SoundEvent VILLAGER_SMOOTHCRIMINAL = registerSoundEvent("villager_smoothcriminal");
    public static final SoundEvent VILLAGER_SOMEBODYIUSETOKNOW = registerSoundEvent("villager_somebodyiusetoknow");
    public static final SoundEvent VILLAGER_TAKEONME = registerSoundEvent("villager_takeonme");
    public static final SoundEvent VILLAGER_WHATISLOVE = registerSoundEvent("villager_whatislove");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ShitMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
