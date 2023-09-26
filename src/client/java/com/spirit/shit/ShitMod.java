/*
    $/ A K F I I J L M P Q $ I L \$
    |  F $ N R P T K D Q W V J N
    |
    |
    |
    |
    #\
 */

package com.spirit.shit;

import com.spirit.shit.block.ShitBlocks;
import com.spirit.shit.common.GunProjectileItem;
import com.spirit.shit.effect.ShitEffects;
import com.spirit.shit.entity.ShitEntities;
import com.spirit.shit.entity.custom.*;
import com.spirit.shit.entity.custom.projectile.*;
import com.spirit.shit.entity.custom.projectile.beverage.*;
import com.spirit.shit.item.ShitFoodComponents;
import com.spirit.shit.item.ShitItemGroup;
import com.spirit.shit.item.ShitItems;
import com.spirit.shit.common.GunItem;
import com.spirit.shit.item.custom.projectile.bullet.BulletItem;
import com.spirit.shit.particle.ShitParticles;
import com.spirit.shit.potion.ShitPotions;
import com.spirit.shit.sound.ShitSounds;
import com.spirit.shit.util.PacketIDs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib.GeckoLib;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import com.spirit.shit.common.Common;

import java.util.Objects;

import static net.minecraft.server.command.CommandManager.literal;

public class ShitMod implements ModInitializer {

    public static final String MOD_ID = "shit";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final EntityType<RedBrickProjectileEntity> RedBrickProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "red_brick"),
            FabricEntityTypeBuilder.<RedBrickProjectileEntity>create(SpawnGroup.MISC, RedBrickProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
    public static final EntityType<BlueBrickProjectileEntity> BlueBrickProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "blue_brick"),
            FabricEntityTypeBuilder.<BlueBrickProjectileEntity>create(SpawnGroup.MISC, BlueBrickProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
    public static final EntityType<TrashCanProjectileEntity> TrashCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "trash_can"),
            FabricEntityTypeBuilder.<TrashCanProjectileEntity>create(SpawnGroup.MISC, TrashCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(1F, 2F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
    public static final EntityType<OatProjectileEntity> OatProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "oat"),
            FabricEntityTypeBuilder.<OatProjectileEntity>create(SpawnGroup.MISC, OatProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());


    public static final EntityType<BulletProjectileEntity> BulletProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "bullet_entity"),
            FabricEntityTypeBuilder.<BulletProjectileEntity>create(SpawnGroup.MISC, BulletProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

//DRINKS
    public static final EntityType<BeerBottleProjectileEntity> BeerBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "beer_bottle"),
            FabricEntityTypeBuilder.<BeerBottleProjectileEntity>create(SpawnGroup.MISC, BeerBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<BonkAtomicPunchProjectileEntity> BonkAtomicPunchProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "bonk_atomic_punch_projectile"),
            FabricEntityTypeBuilder.<BonkAtomicPunchProjectileEntity>create(SpawnGroup.MISC, BonkAtomicPunchProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<BottleProjectileEntity> BottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "bottle"),
            FabricEntityTypeBuilder.<BottleProjectileEntity>create(SpawnGroup.MISC, BottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<BudLightCanProjectileEntity> BudLightCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "bud_light_can"),
            FabricEntityTypeBuilder.<BudLightCanProjectileEntity>create(SpawnGroup.MISC, BudLightCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ChampagneBottleProjectileEntity> ChampagneBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "champagne_bottle"),
            FabricEntityTypeBuilder.<ChampagneBottleProjectileEntity>create(SpawnGroup.MISC, ChampagneBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ChugJugProjectileEntity> ChugJugProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "chug_jug_empty"),
            FabricEntityTypeBuilder.<ChugJugProjectileEntity>create(SpawnGroup.MISC, ChugJugProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<CocaColaCanProjectileEntity> CocaColaCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "coca_cola_can"),
            FabricEntityTypeBuilder.<CocaColaCanProjectileEntity>create(SpawnGroup.MISC, CocaColaCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<CokeZeroCanProjectileEntity> CokeZeroCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "coke_zero_can"),
            FabricEntityTypeBuilder.<CokeZeroCanProjectileEntity>create(SpawnGroup.MISC, CokeZeroCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<CritaColaCanProjectileEntity> CritaColaCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "crita_cola_can"),
            FabricEntityTypeBuilder.<CritaColaCanProjectileEntity>create(SpawnGroup.MISC, CritaColaCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<DrPepperCanProjectileEntity> DrPepperCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "dr_pepper_can"),
            FabricEntityTypeBuilder.<DrPepperCanProjectileEntity>create(SpawnGroup.MISC, DrPepperCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<FantaCanProjectileEntity> FantaCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "fanta_can"),
            FabricEntityTypeBuilder.<FantaCanProjectileEntity>create(SpawnGroup.MISC, FantaCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<FlaskProjectileEntity> FlaskProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "flask_empty"),
            FabricEntityTypeBuilder.<FlaskProjectileEntity>create(SpawnGroup.MISC, FlaskProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<GlassJarProjectileEntity> GlassJarProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "glass_jar"),
            FabricEntityTypeBuilder.<GlassJarProjectileEntity>create(SpawnGroup.MISC, GlassJarProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<LagarBottleProjectileEntity> LagarBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "lagar_bottle"),
            FabricEntityTypeBuilder.<LagarBottleProjectileEntity>create(SpawnGroup.MISC, LagarBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<MilkCartonProjectileEntity> MilkCartonProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "milk_carton_empty"),
            FabricEntityTypeBuilder.<MilkCartonProjectileEntity>create(SpawnGroup.MISC, MilkCartonProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<MountainDewCanProjectileEntity> MountainDewCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "mountain_dew_can"),
            FabricEntityTypeBuilder.<MountainDewCanProjectileEntity>create(SpawnGroup.MISC, MountainDewCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<MugProjectileEntity> MugProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "mug"),
            FabricEntityTypeBuilder.<MugProjectileEntity>create(SpawnGroup.MISC, MugProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<NukaColaBottleProjectileEntity> NukaColaBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "nuka_cola_bottle"),
            FabricEntityTypeBuilder.<NukaColaBottleProjectileEntity>create(SpawnGroup.MISC, NukaColaBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<NukaColaDarkBottleProjectileEntity> NukaColaDarkBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "nuka_cola_dark_bottle"),
            FabricEntityTypeBuilder.<NukaColaDarkBottleProjectileEntity>create(SpawnGroup.MISC, NukaColaDarkBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<NukaColaQuantumBottleProjectileEntity> NukaColaQuantumBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "nuka_cola_quantum_bottle"),
            FabricEntityTypeBuilder.<NukaColaQuantumBottleProjectileEntity>create(SpawnGroup.MISC, NukaColaQuantumBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<MugRootBeerCanProjectileEntity> MugRootBeerCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "mug_root_beer_can"),
            FabricEntityTypeBuilder.<MugRootBeerCanProjectileEntity>create(SpawnGroup.MISC, MugRootBeerCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<PeepsPepsiCanProjectileEntity> PeepsPepsiCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "peeps_pepsi_can"),
            FabricEntityTypeBuilder.<PeepsPepsiCanProjectileEntity>create(SpawnGroup.MISC, PeepsPepsiCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<PepsiCanProjectileEntity> PepsiCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "pepsi_can"),
            FabricEntityTypeBuilder.<PepsiCanProjectileEntity>create(SpawnGroup.MISC, PepsiCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<RumBottleProjectileEntity> RumBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "rum_bottle"),
            FabricEntityTypeBuilder.<RumBottleProjectileEntity>create(SpawnGroup.MISC, RumBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeBlueBerryTartCanProjectileEntity> ShizeBlueBerryTartCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_blueberrytart_can"),
            FabricEntityTypeBuilder.<ShizeBlueBerryTartCanProjectileEntity>create(SpawnGroup.MISC, ShizeBlueBerryTartCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeBlushingRoseCanProjectileEntity> ShizeBlushingRoseCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_blushingrose_can"),
            FabricEntityTypeBuilder.<ShizeBlushingRoseCanProjectileEntity>create(SpawnGroup.MISC, ShizeBlushingRoseCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeCanadaShyCanProjectileEntity> ShizeCanadaShyCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_canadashy_can"),
            FabricEntityTypeBuilder.<ShizeCanadaShyCanProjectileEntity>create(SpawnGroup.MISC, ShizeCanadaShyCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeCheekyBitoPudCanProjectileEntity> ShizeCheekyBitoPudCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_cheekybitopud_can"),
            FabricEntityTypeBuilder.<ShizeCheekyBitoPudCanProjectileEntity>create(SpawnGroup.MISC, ShizeCheekyBitoPudCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeCherryPopCanProjectileEntity> ShizeCherryPopCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_cherrypop_can"),
            FabricEntityTypeBuilder.<ShizeCherryPopCanProjectileEntity>create(SpawnGroup.MISC, ShizeCherryPopCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeColdBeetStewCanProjectileEntity> ShizeColdBeetStewCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_coldbeetstew_can"),
            FabricEntityTypeBuilder.<ShizeColdBeetStewCanProjectileEntity>create(SpawnGroup.MISC, ShizeColdBeetStewCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeElderFlowerCanProjectileEntity> ShizeElderFlowerCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_elderflower_can"),
            FabricEntityTypeBuilder.<ShizeElderFlowerCanProjectileEntity>create(SpawnGroup.MISC, ShizeElderFlowerCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeFactoryRustCanProjectileEntity> ShizeFactoryRustCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_factoryrust_can"),
            FabricEntityTypeBuilder.<ShizeFactoryRustCanProjectileEntity>create(SpawnGroup.MISC, ShizeFactoryRustCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeFourCheeseCanProjectileEntity> ShizeFourCheeseCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_fourcheese_can"),
            FabricEntityTypeBuilder.<ShizeFourCheeseCanProjectileEntity>create(SpawnGroup.MISC, ShizeFourCheeseCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeFrenchVanillaCanProjectileEntity> ShizeFrenchVanillaCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_frenchvanilla_can"),
            FabricEntityTypeBuilder.<ShizeFrenchVanillaCanProjectileEntity>create(SpawnGroup.MISC, ShizeFrenchVanillaCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeFulmedamesCanProjectileEntity> ShizeFulmedamesCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_fulmedames_can"),
            FabricEntityTypeBuilder.<ShizeFulmedamesCanProjectileEntity>create(SpawnGroup.MISC, ShizeFulmedamesCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeGamerEnergyCanProjectileEntity> ShizeGamerEnergyCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_gamerenergy_can"),
            FabricEntityTypeBuilder.<ShizeGamerEnergyCanProjectileEntity>create(SpawnGroup.MISC, ShizeGamerEnergyCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeJellyBeanCanProjectileEntity> ShizeJellyBeanCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_jellybean_can"),
            FabricEntityTypeBuilder.<ShizeJellyBeanCanProjectileEntity>create(SpawnGroup.MISC, ShizeJellyBeanCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeJuicyMelonCanProjectileEntity> ShizeJuicyMelonCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_juicymelon_can"),
            FabricEntityTypeBuilder.<ShizeJuicyMelonCanProjectileEntity>create(SpawnGroup.MISC, ShizeJuicyMelonCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeLemonPartyCanProjectileEntity> ShizeLemonPartyCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_lemonparty_can"),
            FabricEntityTypeBuilder.<ShizeLemonPartyCanProjectileEntity>create(SpawnGroup.MISC, ShizeLemonPartyCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeLightCanProjectileEntity> ShizeLightCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_light_can"),
            FabricEntityTypeBuilder.<ShizeLightCanProjectileEntity>create(SpawnGroup.MISC, ShizeLightCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeLiquorLisiousCanProjectileEntity> ShizeLiquroLisiousCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_liqurolisious_can"),
            FabricEntityTypeBuilder.<ShizeLiquorLisiousCanProjectileEntity>create(SpawnGroup.MISC, ShizeLiquorLisiousCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeMayonnaiseCanProjectileEntity> ShizeMayonnaiseCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_mayonnaise_can"),
            FabricEntityTypeBuilder.<ShizeMayonnaiseCanProjectileEntity>create(SpawnGroup.MISC, ShizeMayonnaiseCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeMustardCanProjectileEntity> ShizeMustardCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_mustard_can"),
            FabricEntityTypeBuilder.<ShizeMustardCanProjectileEntity>create(SpawnGroup.MISC, ShizeMustardCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeOriginalCanProjectileEntity> ShizeOriginalCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_original_can"),
            FabricEntityTypeBuilder.<ShizeOriginalCanProjectileEntity>create(SpawnGroup.MISC, ShizeOriginalCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizePineapplePizzaCanProjectileEntity> ShizePineapplePizzaCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_pineapplepizza_can"),
            FabricEntityTypeBuilder.<ShizePineapplePizzaCanProjectileEntity>create(SpawnGroup.MISC, ShizePineapplePizzaCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeRawMeatCanProjectileEntity> ShizeRawMeatCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_rawmeat_can"),
            FabricEntityTypeBuilder.<ShizeRawMeatCanProjectileEntity>create(SpawnGroup.MISC, ShizeRawMeatCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeSardineSurpriseCanProjectileEntity> ShizeSardineSurpriseCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_sardinesurprise_can"),
            FabricEntityTypeBuilder.<ShizeSardineSurpriseCanProjectileEntity>create(SpawnGroup.MISC, ShizeSardineSurpriseCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeStrawberryKiwiCanProjectileEntity> ShizeStrawberryKiwiCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_strawberrykiwi_can"),
            FabricEntityTypeBuilder.<ShizeStrawberryKiwiCanProjectileEntity>create(SpawnGroup.MISC, ShizeStrawberryKiwiCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeTangyKetchupCanProjectileEntity> ShizeTangyKetchupCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_tangyketchup_can"),
            FabricEntityTypeBuilder.<ShizeTangyKetchupCanProjectileEntity>create(SpawnGroup.MISC, ShizeTangyKetchupCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeTaroTeaseCanProjectileEntity> ShizeTaroTeaseCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_tarotease_can"),
            FabricEntityTypeBuilder.<ShizeTaroTeaseCanProjectileEntity>create(SpawnGroup.MISC, ShizeTaroTeaseCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeThirstBornCanProjectileEntity> ShizeThirstBornCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_thirstborn_can"),
            FabricEntityTypeBuilder.<ShizeThirstBornCanProjectileEntity>create(SpawnGroup.MISC, ShizeThirstBornCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeTiramisuCanProjectileEntity> ShizeTiramisuCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_tiramisu_can"),
            FabricEntityTypeBuilder.<ShizeTiramisuCanProjectileEntity>create(SpawnGroup.MISC, ShizeTiramisuCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeTropicalStormCanProjectileEntity> ShizeTropicalStormCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_tropicalstorm_can"),
            FabricEntityTypeBuilder.<ShizeTropicalStormCanProjectileEntity>create(SpawnGroup.MISC, ShizeTropicalStormCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<ShizeVeggieBrothCanProjectileEntity> ShizeVeggieBrothCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "shize_veggiebroth_can"),
            FabricEntityTypeBuilder.<ShizeVeggieBrothCanProjectileEntity>create(SpawnGroup.MISC, ShizeVeggieBrothCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<SpeedColaCanProjectileEntity> SpeedColaCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "speed_cola_can"),
            FabricEntityTypeBuilder.<SpeedColaCanProjectileEntity>create(SpawnGroup.MISC, SpeedColaCanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<StrawBerryMilkCartonProjectileEntity> StrawBerryMilkCartonProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "strawberry_milk_carton_empty"),
            FabricEntityTypeBuilder.<StrawBerryMilkCartonProjectileEntity>create(SpawnGroup.MISC, StrawBerryMilkCartonProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<VodkaBottleProjectileEntity> VodkaBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "vodka_bottle"),
            FabricEntityTypeBuilder.<VodkaBottleProjectileEntity>create(SpawnGroup.MISC, VodkaBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<WineBottleProjectileEntity> WineBottleProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "wine_bottle"),
            FabricEntityTypeBuilder.<WineBottleProjectileEntity>create(SpawnGroup.MISC, WineBottleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    public static final EntityType<WineGlassProjectileEntity> WineGlassProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ShitMod.MOD_ID, "wine_glass_empty"),
            FabricEntityTypeBuilder.<WineGlassProjectileEntity>create(SpawnGroup.MISC, WineGlassProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());




    public static final ItemGroup BULLET_ITEM_GROUP = FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bullet"))
                    .icon(() -> new ItemStack(ShitItems.BULLET))  // Replace with a representative ItemStack for this group
                    .entries((displayContext, entries) -> {
                        // Items to consider
                        GunProjectileItem[] items = Common.getBulletProjectileItems();

                        for (GunProjectileItem bulletItem : items) {
                            for (StatusEffect effect : Registries.STATUS_EFFECT) {
                                for (byte isIncendiary : new byte[]{0, 1}) {
                                    for (byte isExplosive : new byte[]{0, 1}) {
                                        for (byte isExtendedDuration : new byte[]{0, 1}) {
                                            ItemStack stack = bulletItem.createItemWithEffects(effect, isIncendiary, isExplosive, isExtendedDuration);

                                            // Add BulletType to NBT data
                                            NbtCompound nbt = stack.getOrCreateNbt();
                                            nbt.putString("BulletType", bulletItem.getName().getString());  // Assuming getName().getString() returns the type like "Bullet", "Rifle Bullet", etc.

                                            // Generate a custom name for this bullet based on its properties.
                                            String customName = bulletItem.generateCustomNameFromNBT(stack);

                                            // Set the custom name to the ItemStack.
                                            stack.setCustomName(Text.translatable(customName));

                                            // Add the customized ItemStack to the entries.
                                            entries.add(stack);
                                        }
                                    }
                                }
                            }
                        }
                    }).build();
    @Override
    public void onInitialize() {
        System.out.println("INIT - BULLET" + ShitItems.BULLET);
        ShitItems.registerCustomShitItems();
        ShitItems.registerCustomPShitItems();
        ShitItems.registerMaterialShitItems();
        ShitBlocks.registerShitBlocks();
        ShitBlocks.registerShitCustomBlocks();

        ShitMod.registerShitMain();
        ShitParticles.registerParticles();
        ShitEffects.registerShitEffects();
        ShitEntities.registerShitEntities();
        ShitEntities.registerShitEntityAI();
        ShitEntities.registerShitClientEntity();
        ShitEntities.registerShitCustomEntity();
        ShitEntities.registerShitCustomPEntity();
        ShitPotions.registerShitPotions();
        ShitFoodComponents.registerShitFoodItems();
        ShitEffects.registerEffects();
        ShitPotions.registerPotions();

        ShitSounds.registerShitSounds();

        GeckoLib.initialize();
        FabricDefaultAttributeRegistry.register(ShitEntities.JBIRD, JbirdEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.RAT_BOMB, RatBombEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.RAT, RatEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.CAPYBARA, CapybaraEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.SLIM_SHADY, SlimShadyEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ShitEntities.YIPPEE, YippeeEntity.setAttributes());

        Registry.register(Registries.ITEM_GROUP, new Identifier("shit", "booletgroup"), BULLET_ITEM_GROUP);
        ShitItemGroup.registerShitItemGroup();



        //PACKETS

        ServerPlayNetworking.registerGlobalReceiver(PacketIDs.FIRE_GUN_PACKET, (server, player, handler, buf, responseSender) -> {
            int hand = buf.readInt(); // Read data sent from the client
            server.execute(() -> { // Switch to the main server thread before modifying the game
                ItemStack itemStack = player.getStackInHand(Hand.values()[hand]);
                if (itemStack.getItem() instanceof GunItem) {
                    ((GunItem) itemStack.getItem()).handleLeftClick(itemStack, player, player.getWorld());
                    // Now this function internally checks for cooldown
                }
            });
        });

        //COMMANDS

        //DETONATION COMMAND
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("explode")
                .executes(context -> {
                    if (!Objects.requireNonNull(context.getSource().getPlayer()).getWorld().isClient()) {
                        double x = context.getSource().getPlayer().getX();
                        double y = context.getSource().getPlayer().getY();
                        double z = context.getSource().getPlayer().getZ();
                        float xp = context.getSource().getPlayer().experienceLevel;
                        boolean fire = context.getSource().getPlayer().isOnFire();
                        context.getSource().getWorld().createExplosion(context.getSource().getPlayer(), new DamageSource(RegistryEntry.of(new DamageType("bombed_self", 1))), new ExplosionBehavior(), x, y + 1, z, xp, fire, World.ExplosionSourceType.BLOCK, true);
                        context.getSource().getPlayer().damage(new DamageSource(RegistryEntry.of(new DamageType("bombed_self", 1))), xp/10);
                        context.getSource().getPlayer().playSound(ShitSounds.EXPLODE_SOUND_COMMAND, SoundCategory.PLAYERS, 1, 1);
                    }
                    return 1;
                })));
    }

    public static void registerShitMain() {
        ShitMod.LOGGER.info("> --Loaded || the-shit-of-crypt/src/main/java/com/spirit/shit/ShitMod");
    }
}


