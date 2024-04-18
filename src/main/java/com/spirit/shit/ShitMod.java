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


import com.spirit.Main;
import com.spirit.shit.data.common.Common;
import com.spirit.shit.data.common.GunProjectileItem;
import com.spirit.shit.global.entity.custom.projectile.*;
import com.spirit.shit.global.entity.custom.projectile.beverage.*;
import com.spirit.shit.global.item.ShitItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ShitMod implements ModInitializer {
    private static <T extends Entity> EntityType<T> registerEntityType(String name, SpawnGroup group, EntityType.EntityFactory<T> entityFactory, float width, float height) {
        Identifier entityId = new Identifier(Main.SHIT_ID, name);
        FabricEntityTypeBuilder<T> entityTypeBuilder = FabricEntityTypeBuilder.create(group, entityFactory)
                .dimensions(EntityDimensions.fixed(width, height))
                .trackRangeBlocks(4).trackedUpdateRate(10);
        return Registry.register(Registries.ENTITY_TYPE, entityId, entityTypeBuilder.build());
    }
    public static final EntityType<RedBrickProjectileEntity> RedBrickProjectileEntityType = registerEntityType("red_brick", SpawnGroup.MISC, RedBrickProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<BlueBrickProjectileEntity> BlueBrickProjectileEntityType = registerEntityType("blue_brick", SpawnGroup.MISC, BlueBrickProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<TrashCanProjectileEntity> TrashCanProjectileEntityType = registerEntityType("trash_can", SpawnGroup.MISC, TrashCanProjectileEntity::new, 1F, 2F);
    public static final EntityType<OatProjectileEntity> OatProjectileEntityType = registerEntityType("oat", SpawnGroup.MISC, OatProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<BulletProjectileEntity> BulletProjectileEntityType = registerEntityType("bullet_entity", SpawnGroup.MISC, BulletProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<BeerBottleProjectileEntity> BeerBottleProjectileEntityType = registerEntityType("beer_bottle", SpawnGroup.MISC, BeerBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<BonkAtomicPunchProjectileEntity> BonkAtomicPunchProjectileEntityType = registerEntityType("bonk_atomic_punch_projectile", SpawnGroup.MISC, BonkAtomicPunchProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<BottleProjectileEntity> BottleProjectileEntityType = registerEntityType("bottle", SpawnGroup.MISC, BottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<BudLightCanProjectileEntity> BudLightCanProjectileEntityType = registerEntityType("bud_light_can", SpawnGroup.MISC, BudLightCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ChampagneBottleProjectileEntity> ChampagneBottleProjectileEntityType = registerEntityType("champagne_bottle", SpawnGroup.MISC, ChampagneBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ChugJugProjectileEntity> ChugJugProjectileEntityType = registerEntityType("chug_jug_empty", SpawnGroup.MISC, ChugJugProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<CocaColaCanProjectileEntity> CocaColaCanProjectileEntityType = registerEntityType("coca_cola_can", SpawnGroup.MISC, CocaColaCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<CokeZeroCanProjectileEntity> CokeZeroCanProjectileEntityType = registerEntityType("coke_zero_can", SpawnGroup.MISC, CokeZeroCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<CritaColaCanProjectileEntity> CritaColaCanProjectileEntityType = registerEntityType("crita_cola_can", SpawnGroup.MISC, CritaColaCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<DrPepperCanProjectileEntity> DrPepperCanProjectileEntityType = registerEntityType("dr_pepper_can", SpawnGroup.MISC, DrPepperCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<FantaCanProjectileEntity> FantaCanProjectileEntityType = registerEntityType("fanta_can", SpawnGroup.MISC, FantaCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<FlaskProjectileEntity> FlaskProjectileEntityType = registerEntityType("flask_empty", SpawnGroup.MISC, FlaskProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<GlassJarProjectileEntity> GlassJarProjectileEntityType = registerEntityType("glass_jar", SpawnGroup.MISC, GlassJarProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<LagarBottleProjectileEntity> LagarBottleProjectileEntityType = registerEntityType("lagar_bottle", SpawnGroup.MISC, LagarBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<MilkCartonProjectileEntity> MilkCartonProjectileEntityType = registerEntityType("milk_carton_empty", SpawnGroup.MISC, MilkCartonProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<MountainDewCanProjectileEntity> MountainDewCanProjectileEntityType = registerEntityType("mountain_dew_can", SpawnGroup.MISC, MountainDewCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<MugProjectileEntity> MugProjectileEntityType = registerEntityType("mug", SpawnGroup.MISC, MugProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<NukaColaBottleProjectileEntity> NukaColaBottleProjectileEntityType = registerEntityType("nuka_cola_bottle", SpawnGroup.MISC, NukaColaBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<NukaColaDarkBottleProjectileEntity> NukaColaDarkBottleProjectileEntityType = registerEntityType("nuka_cola_dark_bottle", SpawnGroup.MISC, NukaColaDarkBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<NukaColaQuantumBottleProjectileEntity> NukaColaQuantumBottleProjectileEntityType = registerEntityType("nuka_cola_quantum_bottle", SpawnGroup.MISC, NukaColaQuantumBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<MugRootBeerCanProjectileEntity> MugRootBeerCanProjectileEntityType = registerEntityType("mug_root_beer_can", SpawnGroup.MISC, MugRootBeerCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<PeepsPepsiCanProjectileEntity> PeepsPepsiCanProjectileEntityType = registerEntityType("peeps_pepsi_can", SpawnGroup.MISC, PeepsPepsiCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<PepsiCanProjectileEntity> PepsiCanProjectileEntityType = registerEntityType("pepsi_can", SpawnGroup.MISC, PepsiCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<RumBottleProjectileEntity> RumBottleProjectileEntityType = registerEntityType("rum_bottle", SpawnGroup.MISC, RumBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeBlueBerryTartCanProjectileEntity> ShizeBlueBerryTartCanProjectileEntityType = registerEntityType("shize_blueberrytart_can", SpawnGroup.MISC, ShizeBlueBerryTartCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeBlushingRoseCanProjectileEntity> ShizeBlushingRoseCanProjectileEntityType = registerEntityType("shize_blushingrose_can", SpawnGroup.MISC, ShizeBlushingRoseCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeCanadaShyCanProjectileEntity> ShizeCanadaShyCanProjectileEntityType = registerEntityType("shize_canadashy_can", SpawnGroup.MISC, ShizeCanadaShyCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeCheekyBitoPudCanProjectileEntity> ShizeCheekyBitoPudCanProjectileEntityType = registerEntityType("shize_cheekybitopud_can", SpawnGroup.MISC, ShizeCheekyBitoPudCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeCherryPopCanProjectileEntity> ShizeCherryPopCanProjectileEntityType = registerEntityType("shize_cherrypop_can", SpawnGroup.MISC, ShizeCherryPopCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeColdBeetStewCanProjectileEntity> ShizeColdBeetStewCanProjectileEntityType = registerEntityType("shize_coldbeetstew_can", SpawnGroup.MISC, ShizeColdBeetStewCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeElderFlowerCanProjectileEntity> ShizeElderFlowerCanProjectileEntityType = registerEntityType("shize_elderflower_can", SpawnGroup.MISC, ShizeElderFlowerCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeFactoryRustCanProjectileEntity> ShizeFactoryRustCanProjectileEntityType = registerEntityType("shize_factoryrust_can", SpawnGroup.MISC, ShizeFactoryRustCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeFourCheeseCanProjectileEntity> ShizeFourCheeseCanProjectileEntityType = registerEntityType("shize_fourcheese_can", SpawnGroup.MISC, ShizeFourCheeseCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeFrenchVanillaCanProjectileEntity> ShizeFrenchVanillaCanProjectileEntityType = registerEntityType("shize_frenchvanilla_can", SpawnGroup.MISC, ShizeFrenchVanillaCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeFulmedamesCanProjectileEntity> ShizeFulmedamesCanProjectileEntityType = registerEntityType("shize_fulmedames_can", SpawnGroup.MISC, ShizeFulmedamesCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeGamerEnergyCanProjectileEntity> ShizeGamerEnergyCanProjectileEntityType = registerEntityType("shize_gamerenergy_can", SpawnGroup.MISC, ShizeGamerEnergyCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeJellyBeanCanProjectileEntity> ShizeJellyBeanCanProjectileEntityType = registerEntityType("shize_jellybean_can", SpawnGroup.MISC, ShizeJellyBeanCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeJuicyMelonCanProjectileEntity> ShizeJuicyMelonCanProjectileEntityType = registerEntityType("shize_juicymelon_can", SpawnGroup.MISC, ShizeJuicyMelonCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeLemonPartyCanProjectileEntity> ShizeLemonPartyCanProjectileEntityType = registerEntityType("shize_lemonparty_can", SpawnGroup.MISC, ShizeLemonPartyCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeLightCanProjectileEntity> ShizeLightCanProjectileEntityType = registerEntityType("shize_light_can", SpawnGroup.MISC, ShizeLightCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeLiquorLisiousCanProjectileEntity> ShizeLiquorLisiousCanProjectileEntityType = registerEntityType("shize_liqurolisious_can", SpawnGroup.MISC, ShizeLiquorLisiousCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeMayonnaiseCanProjectileEntity> ShizeMayonnaiseCanProjectileEntityType = registerEntityType("shize_mayonnaise_can", SpawnGroup.MISC, ShizeMayonnaiseCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeMustardCanProjectileEntity> ShizeMustardCanProjectileEntityType = registerEntityType("shize_mustard_can", SpawnGroup.MISC, ShizeMustardCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeOriginalCanProjectileEntity> ShizeOriginalCanProjectileEntityType = registerEntityType("shize_original_can", SpawnGroup.MISC, ShizeOriginalCanProjectileEntity::new, 0.25F, 0.25F);

    public static final EntityType<ShizePineapplePizzaCanProjectileEntity> ShizePineapplePizzaCanProjectileEntityType = registerEntityType("shize_pineapplepizza_can", SpawnGroup.MISC, ShizePineapplePizzaCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeRawMeatCanProjectileEntity> ShizeRawMeatCanProjectileEntityType = registerEntityType("shize_rawmeat_can", SpawnGroup.MISC, ShizeRawMeatCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeSardineSurpriseCanProjectileEntity> ShizeSardineSurpriseCanProjectileEntityType = registerEntityType("shize_sardinesurprise_can", SpawnGroup.MISC, ShizeSardineSurpriseCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeStrawberryKiwiCanProjectileEntity> ShizeStrawberryKiwiCanProjectileEntityType = registerEntityType("shize_strawberrykiwi_can", SpawnGroup.MISC, ShizeStrawberryKiwiCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeTangyKetchupCanProjectileEntity> ShizeTangyKetchupCanProjectileEntityType = registerEntityType("shize_tangyketchup_can", SpawnGroup.MISC, ShizeTangyKetchupCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeTaroTeaseCanProjectileEntity> ShizeTaroTeaseCanProjectileEntityType = registerEntityType("shize_tarotease_can", SpawnGroup.MISC, ShizeTaroTeaseCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeThirstBornCanProjectileEntity> ShizeThirstBornCanProjectileEntityType = registerEntityType("shize_thirstborn_can", SpawnGroup.MISC, ShizeThirstBornCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeTiramisuCanProjectileEntity> ShizeTiramisuCanProjectileEntityType = registerEntityType("shize_tiramisu_can", SpawnGroup.MISC, ShizeTiramisuCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeTropicalStormCanProjectileEntity> ShizeTropicalStormCanProjectileEntityType = registerEntityType("shize_tropicalstorm_can", SpawnGroup.MISC, ShizeTropicalStormCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<ShizeVeggieBrothCanProjectileEntity> ShizeVeggieBrothCanProjectileEntityType = registerEntityType("shize_veggiebroth_can", SpawnGroup.MISC, ShizeVeggieBrothCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<StrawBerryMilkCartonProjectileEntity> StrawBerryMilkCartonProjectileEntityType = registerEntityType("strawberry_milk_carton_empty", SpawnGroup.MISC, StrawBerryMilkCartonProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<VodkaBottleProjectileEntity> VodkaBottleProjectileEntityType = registerEntityType("vodka_bottle", SpawnGroup.MISC, VodkaBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<WineBottleProjectileEntity> WineBottleProjectileEntityType = registerEntityType("wine_bottle", SpawnGroup.MISC, WineBottleProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<WineGlassProjectileEntity> WineGlassProjectileEntityType = registerEntityType("wine_glass_empty", SpawnGroup.MISC, WineGlassProjectileEntity::new, 0.25F, 0.25F);


    /*
    public static final EntityType<DeadShotDaiquiriCanProjectileEntity> DeadShotDaiquiriCanProjectileEntityType = registerEntityType("deadshotdaiquiri_can", SpawnGroup.MISC, DeadShotDaiquiriCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<DoubleTapRootBeerCanProjectileEntity> DoubleTapRootBeerCanProjectileEntityType = registerEntityType("doubletaprootbeer_can", SpawnGroup.MISC, DoubleTapRootBeerCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<JuggernogCanProjectileEntity> JuggernogCanProjectileEntityType = registerEntityType("juggernog_can", SpawnGroup.MISC, JuggernogCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<MuleKickCanProjectileEntity> MuleKickCanProjectileEntityType = registerEntityType("mulekick_can", SpawnGroup.MISC, MuleKickCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<PHDFlopperCanProjectileEntity> PHDFlopperCanProjectileEntityType = registerEntityType("phdflopper_can", SpawnGroup.MISC, PHDFlopperCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<QuickReviveCanProjectileEntity> QuickReviveCanProjectileEntityType = registerEntityType("quickrevive_can", SpawnGroup.MISC, QuickReviveCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<StaminUpCanProjectileEntity> StaminUpCanProjectileEntityType = registerEntityType("staminup_can", SpawnGroup.MISC, StaminUpCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<TombStoneSodaCanProjectileEntity> TombStoneSodaCanProjectileEntityType = registerEntityType("tombstonesoda_can", SpawnGroup.MISC, TombStoneSodaCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<VultureAidCanProjectileEntity> VultureAidCanProjectileEntityType = registerEntityType("vultureaid_can", SpawnGroup.MISC, VultureAidCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<WhosWhoCanProjectileEntity> WhosWhoCanProjectileEntityType = registerEntityType("whoswho_can", SpawnGroup.MISC, WhosWhoCanProjectileEntity::new, 0.25F, 0.25F);
    public static final EntityType<WidowsWineCanProjectileEntity> WidowsWineCanProjectileEntityType = registerEntityType("widowswine_can", SpawnGroup.MISC, WidowsWineCanProjectileEntity::new, 0.25F, 0.25F);
    */

    public static final EntityType<SpeedColaCanProjectileEntity> SpeedColaCanProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Main.SHIT_ID, "speed_cola_can"),
            FabricEntityTypeBuilder.<SpeedColaCanProjectileEntity>create(SpawnGroup.MISC, SpeedColaCanProjectileEntity::new)
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
                                    ItemStack stack = bulletItem.createItemWithEffects(effect, isIncendiary, isExplosive, isExtendedDuration, /*attempt*/ bulletItem);

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
    }


    public static void registerShitpostMod() {
        Main.SHITLOGGER.info("> --Connected || the-shit-of-crypt/src/main/java/com/spirit/shit/ShitMod");
    }
}


