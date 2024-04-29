package com.spirit.tdbtd.global.sound;

import com.spirit.Main;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TDBTDSounds {
    public static final SoundEvent EVILFROMTHEWASTES = SoundEvent.of(new Identifier(Main.TDBTD_ID, "evilfromthewastes"));
    public static final SoundEvent FINDINGAWAYOUT = SoundEvent.of(new Identifier(Main.TDBTD_ID,"findingawayout"));
    public static final SoundEvent SCULKINGAROUND = SoundEvent.of(new Identifier(Main.TDBTD_ID,"sculkingaround"));
    public static final SoundEvent POLLO_ONE_BEAM = SoundEvent.of(new Identifier(Main.TDBTD_ID,"pollo_one_beam"));
    public static final SoundEvent DEEP_DARK_AMBIENCE = SoundEvent.of(new Identifier(Main.TDBTD_ID,"deepdarkambience"));
    public static final SoundEvent DIMENTED_SERPENT_SHOOT = SoundEvent.of(new Identifier(Main.TDBTD_ID,"dimented_serpent_shoot"));
    public static final SoundEvent DIMENTED_SERPENT_CHARGE = SoundEvent.of(new Identifier(Main.TDBTD_ID,"dimented_serpent_charge"));
    public static final SoundEvent APERTURENTEETH_AMBIENT = SoundEvent.of(new Identifier(Main.TDBTD_ID,"aperturenteeth_ambient"));
    public static final SoundEvent APERTURENTEETH_BITE = SoundEvent.of(new Identifier(Main.TDBTD_ID,"aperturenteeth_bite"));
    public static final SoundEvent CODELAING_AMBIENT = SoundEvent.of(new Identifier(Main.TDBTD_ID,"codelaing_ambient"));
    public static final SoundEvent DEVASTADOR_AMBIENT = SoundEvent.of(new Identifier(Main.TDBTD_ID,"devastador_ambient"));
    public static final SoundEvent DEVASTADOR_ANGRY = SoundEvent.of(new Identifier(Main.TDBTD_ID,"devastador_angry"));
    public static final SoundEvent TENEBROUS_NIBBLER_BITE = SoundEvent.of(new Identifier(Main.TDBTD_ID,"tenebrous_nibbler_bite"));
    public static final SoundEvent ENTITY_WATER_BREATH = SoundEvent.of(new Identifier(Main.TDBTD_ID,"entity_water_breath"));
    public static final SoundEvent ITEM_ARMOR_EQUIP_DIMENTED = SoundEvent.of(new Identifier(Main.TDBTD_ID,"item_armor_equip_dimented"));

    static Map<String, Object> SOUNDS = Stream.of(new Object[][]{
            {"evilfromthewastes", EVILFROMTHEWASTES},
            {"findingawayout", FINDINGAWAYOUT},
            {"sculkingaround", SCULKINGAROUND},
            {"pollo_one_beam", POLLO_ONE_BEAM},
            {"deep_dark_ambience", DEEP_DARK_AMBIENCE},
            {"dimented_serpent_shoot", DIMENTED_SERPENT_SHOOT},
            {"dimented_serpent_charge", DIMENTED_SERPENT_CHARGE},
            {"aperturenteeth_ambient", APERTURENTEETH_AMBIENT},
            {"aperturenteeth_bite", APERTURENTEETH_BITE},
            {"codelaing_ambient", CODELAING_AMBIENT},
            {"devastador_ambient", DEVASTADOR_AMBIENT},
            {"devastador_angry", DEVASTADOR_ANGRY},
            {"tenebrous_nibbler_bite", TENEBROUS_NIBBLER_BITE},
            {"entity_water_breath", ENTITY_WATER_BREATH},
            {"item_armor_equip_dimented", ITEM_ARMOR_EQUIP_DIMENTED},

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