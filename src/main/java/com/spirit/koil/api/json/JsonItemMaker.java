package com.spirit.koil.api.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spirit.Main;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JsonItemMaker {
    public static void makeTheJsonItem() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            Path customItemsDir = Paths.get(server.getRunDirectory().getPath(), "./koil/", server.getSaveProperties().getLevelName() + "/items");
            if (!Files.exists(customItemsDir)) {
                try {
                    Files.createDirectories(customItemsDir);
                    Main.KOIL_LOGGER.info("Created custom items directory: " + customItemsDir);
                } catch (IOException e) {
                    Main.KOIL_LOGGER.error("Failed to create custom items directory", e);
                    return;
                }
            }
            Path datapacksDir = Paths.get(server.getRunDirectory().getPath(), "./saves/", server.getSaveProperties().getLevelName() + "/datapacks/");
            Main.KOIL_LOGGER.info("Searching for datapacks in: " + datapacksDir);
            searchAndCopyItems(datapacksDir, customItemsDir);
        });
    }

    private static void searchAndCopyItems(Path sourceDir, Path targetDir) {
        if (!Files.isDirectory(sourceDir)) {
            Main.KOIL_LOGGER.warn("Datapacks directory does not exist or is not a directory: " + sourceDir);
            return;
        }

        try {
            Files.walk(sourceDir)
                    .filter(path -> Files.isDirectory(path) || path.toString().endsWith(".zip"))
                    .forEach(path -> {
                        if (Files.isDirectory(path)) {
                            copyItemsFromFolder(path, targetDir);
                        } else if (path.toString().endsWith(".zip")) {
                            extractAndCopyItemsFromZip(path, targetDir);
                        }
                    });
        } catch (IOException e) {
            Main.KOIL_LOGGER.error("Failed to walk through the datapacks directory", e);
        }
    }

    private static void copyItemsFromFolder(Path sourceDir, Path targetDir) {
        Path koilItemsDir = sourceDir.resolve("data/koil/items");
        if (Files.exists(koilItemsDir) && Files.isDirectory(koilItemsDir)) {
            try {
                Files.walk(koilItemsDir)
                        .filter(Files::isRegularFile)
                        .forEach(sourcePath -> {
                            Path relativePath = koilItemsDir.relativize(sourcePath);
                            Path targetPath = targetDir.resolve(relativePath);
                            try {
                                Files.createDirectories(targetPath.getParent());
                                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                                Main.KOIL_LOGGER.info("Copied item from folder: " + sourcePath + " to: " + targetPath);
                            } catch (IOException e) {
                                Main.KOIL_LOGGER.error("Failed to copy item from folder: " + sourcePath, e);
                            }
                        });
            } catch (IOException e) {
                Main.KOIL_LOGGER.error("Failed to walk through the koil/items directory", e);
            }
        }
    }

    private static void extractAndCopyItemsFromZip(Path zipFile, Path targetDir) {
        try (ZipFile zip = new ZipFile(zipFile.toFile())) {
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.getName().startsWith("data/koil/items/") && !entry.isDirectory()) {
                    Path targetPath = targetDir.resolve(entry.getName().substring("data/koil/items/".length()));
                    try (InputStream is = zip.getInputStream(entry)) {
                        Files.createDirectories(targetPath.getParent());
                        Files.copy(is, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        Main.KOIL_LOGGER.info("Extracted and copied item from zip: " + entry.getName() + " to: " + targetPath);
                    } catch (IOException e) {
                        Main.KOIL_LOGGER.error("Failed to extract and copy item from zip: " + entry.getName(), e);
                    }
                }
            }
        } catch (IOException e) {
            Main.KOIL_LOGGER.error("Failed to extract items from zip file: " + zipFile, e);
        }
    }

    public static void registerItemsFromJson() {
        Path koilDirectory = Paths.get("./koil/").toAbsolutePath();

        try {
            Files.walk(koilDirectory)
                    .filter(Files::isDirectory)
                    .forEach(worldDirectory -> {
                        String worldName = worldDirectory.getFileName().toString();
                        Path itemsDirectory = worldDirectory.resolve("items");

                        try {
                            Files.walk(itemsDirectory)
                                    .filter(path -> path.toString().endsWith(".json"))
                                    .forEach(path -> {
                                        try (FileReader reader = new FileReader(path.toFile())) {
                                            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

                                            if (jsonObject.has("type")) {
                                                registerItemFromJson(jsonObject, worldName, path.toString());
                                            } else {
                                                Main.KOIL_LOGGER.error("Missing 'type' field in JSON file: " + path);
                                            }
                                        } catch (Exception e) {
                                            Main.KOIL_LOGGER.error("Failed to read the JSON file: " + path);
                                            e.printStackTrace();
                                        }
                                    });
                        } catch (IOException e) {
                            Main.KOIL_LOGGER.error("Failed to walk through the items directory for world: " + worldName);
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            Main.KOIL_LOGGER.error("Failed to walk through the koil directory");
            e.printStackTrace();
        }
    }


    private static void registerItemFromJson(JsonObject jsonObject, String path, String string) {
        String modId = jsonObject.get("mod-id").getAsString();
        String itemName = jsonObject.get("name").getAsString().toLowerCase();
        String type = jsonObject.get("type").getAsString();
        String rarity = jsonObject.has("rarity") ? jsonObject.get("rarity").getAsString() : "common";
        Identifier itemId = new Identifier(modId, itemName.toLowerCase().replace(" ", "_"));
        int maxCount = jsonObject.has("max-count") ? jsonObject.get("max-count").getAsInt() : 64;
        int durability = jsonObject.has("durability") ? jsonObject.get("durability").getAsInt() : 0;

        Item.Settings itemSettings = new FabricItemSettings().rarity(getRarity(rarity)).maxCount(maxCount).maxDamage(durability);

        boolean fireproof = jsonObject.has("fireproof") && jsonObject.get("fireproof").getAsBoolean();
        if (fireproof) {itemSettings.fireproof();}


        Item newItem;
        switch (type) {
            case "normal":
                newItem = new Item(itemSettings);
                break;

            case "food":
                float saturationModifier = jsonObject.has("saturation-modifier") ? jsonObject.get("saturation-modifier").getAsFloat() : 0.1F;
                int hunger = jsonObject.has("hunger") ? jsonObject.get("hunger").getAsInt() : 1;

                FoodComponent.Builder foodBuilder = new FoodComponent.Builder().hunger(hunger).saturationModifier(saturationModifier);

                if (jsonObject.has("status-effects")) {
                    JsonArray statusEffectsArray = jsonObject.getAsJsonArray("status-effects");
                    for (JsonElement element : statusEffectsArray) {
                        JsonObject statusEffectObject = element.getAsJsonObject();
                        String statusEffectName = statusEffectObject.get("name").getAsString();
                        int duration = statusEffectObject.get("duration").getAsInt();
                        int amplifier = statusEffectObject.get("amplifier").getAsInt();
                        float chance = statusEffectObject.get("chance").getAsFloat();
                        StatusEffect statusEffect = Registries.STATUS_EFFECT.get(new Identifier(statusEffectName));
                        if (statusEffect != null) {
                            foodBuilder.statusEffect(new StatusEffectInstance(statusEffect, duration, amplifier), chance);
                        }
                    }
                }
                newItem = new Item(itemSettings.food(foodBuilder.build()));
                break;


            case "air":
                Block airBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("block") ? jsonObject.get("block").getAsString() : "air"));
                newItem = new AirBlockItem(airBlock, itemSettings);
                break;
            case "aliased_block":
                Block aliasedBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("block") ? jsonObject.get("block").getAsString() : "air"));
                newItem = new AliasedBlockItem(aliasedBlock, itemSettings);
                break;
                /*
            case "armor":
                String armorMaterial = jsonObject.has("armor-material") ? jsonObject.get("armor-material").getAsString() : "wood";
                String armorType = jsonObject.get("armor-type").getAsString();
                newItem = new ArmorItem(getArmorMaterial(armorMaterial), getArmorType(armorType), itemSettings);
                break;
                 */
            case "armor_stand":
                newItem = new ArmorStandItem(itemSettings);
                break;
            case "arrow":
                newItem = new ArrowItem(itemSettings);
                break;
            case "axe":
                String axeToolMaterial = jsonObject.get("tool-material").getAsString();
                int axeAttackDamage = jsonObject.has("attack-damage") ? jsonObject.get("attack-damage").getAsInt() : 0;
                float axeAttackSpeed = jsonObject.has("attack-speed") ? jsonObject.get("attack-speed").getAsFloat() : 0F;
                newItem = new AxeItem(getToolMaterial(axeToolMaterial), axeAttackDamage, axeAttackSpeed, itemSettings);
                break;
            case "bone_meal":
                newItem = new BoneMealItem(itemSettings);
                break;
            case "book":
                newItem = new BookItem(itemSettings);
                break;
            case "bow":
                newItem = new BowItem(itemSettings);
                break;
            case "brush":
                newItem = new BrushItem(itemSettings);
                break;
            case "bundle":
                newItem = new BundleItem(itemSettings);
                break;
            case "chorus_fruit":
                newItem = new ChorusFruitItem(itemSettings);
                break;
            case "compass":
                newItem = new CompassItem(itemSettings);
                break;
            case "crossbow":
                newItem = new CrossbowItem(itemSettings);
                break;
            case "debug_stick":
                newItem = new DebugStickItem(itemSettings);
                break;
            case "disc_fragment":
                newItem = new DiscFragmentItem(itemSettings);
                break;
            case "dye":
                String getDyeItemColorString = jsonObject.get("dye-color").getAsString();
                newItem = new DyeItem(getDyeColor(getDyeItemColorString), itemSettings);
                break;
            case "egg":
                newItem = new EggItem(itemSettings);
                break;
            case "elytra":
                newItem = new ElytraItem(itemSettings);
                break;
            case "empty_map":
                newItem = new EmptyMapItem(itemSettings);
                break;
            case "enchanted_book":
                newItem = new EnchantedBookItem(itemSettings);
                break;
            case "enchanted_golden_apple":
                newItem = new EnchantedGoldenAppleItem(itemSettings);
                break;
            case "end_crystal":
                newItem = new EndCrystalItem(itemSettings);
                break;
            case "ender_eye":
                newItem = new EnderEyeItem(itemSettings);
                break;
            case "ender_pearl":
                newItem = new EnderPearlItem(itemSettings);
                break;
            case "experience_bottle":
                newItem = new ExperienceBottleItem(itemSettings);
                break;
            case "filled_map":
                newItem = new FilledMapItem(itemSettings);
                break;
            case "fire_charge":
                newItem = new FireChargeItem(itemSettings);
                break;
            case "firework_rocket":
                newItem = new FireworkRocketItem(itemSettings);
                break;
            case "firework_star":
                newItem = new FireworkStarItem(itemSettings);
                break;
            case "fishing_rod":
                newItem = new FishingRodItem(itemSettings);
                break;
            case "flint_and_steel":
                newItem = new FlintAndSteelItem(itemSettings);
                break;
            case "glass_bottle":
                newItem = new GlassBottleItem(itemSettings);
                break;
            case "glow_ink_sac":
                newItem = new GlowInkSacItem(itemSettings);
                break;
            case "hoe":
                String hoeToolMaterial = jsonObject.get("tool-material").getAsString();
                int hoeAttackDamage = jsonObject.has("attack-damage") ? jsonObject.get("attack-damage").getAsInt() : 0;
                float hoeAttackSpeed = jsonObject.has("attack-speed") ? jsonObject.get("attack-speed").getAsFloat() : 0F;
                newItem = new HoeItem(getToolMaterial(hoeToolMaterial), hoeAttackDamage, hoeAttackSpeed, itemSettings);
                break;
            case "honey_bottle":
                newItem = new HoneyBottleItem(itemSettings);
                break;
            case "honeycomb":
                newItem = new HoneycombItem(itemSettings);
                break;
            case "horse_armor":
                int bonus = jsonObject.has("bonus") ? jsonObject.get("bonus").getAsInt() : 0;
                newItem = new HorseArmorItem(bonus, itemName, itemSettings);
                break;
            case "ink_sac":
                newItem = new InkSacItem(itemSettings);
                break;
            case "item":
                newItem = new Item(itemSettings);
                break;
            case "item_frame":
                EntityType<?> entityType = Registries.ENTITY_TYPE.get(new Identifier(jsonObject.get("entity-type").getAsString()));
                newItem = new ItemFrameItem((EntityType<? extends AbstractDecorationEntity>) entityType, itemSettings);
                break;
            case "knowledge_book":
                newItem = new KnowledgeBookItem(itemSettings);
                break;
            case "lead":
                newItem = new LeadItem(itemSettings);
                break;
            case "lingering_potion":
                newItem = new LingeringPotionItem(itemSettings);
                break;
            case "milk_bucket":
                newItem = new MilkBucketItem(itemSettings);
                break;
            case "minecart":
                String getMinecartItemTypeString = jsonObject.get("minecart-item-type").getAsString();
                newItem = new MinecartItem(getMinecartItemType(getMinecartItemTypeString), itemSettings);
                break;
            case "music_disc":
                int comparatorOutput = jsonObject.has("comparator-output") ? jsonObject.get("comparator-output").getAsInt() : 1;
                SoundEvent musicDiscSound = Registries.SOUND_EVENT.get(new Identifier(jsonObject.get("sound").getAsString()));
                int lengthInSeconds = jsonObject.has("length-in-seconds") ? jsonObject.get("length-in-seconds").getAsInt() : 1;
                newItem = new MusicDiscItem(comparatorOutput, musicDiscSound, itemSettings, lengthInSeconds);
                break;
            case "name_tag":
                newItem = new NameTagItem(itemSettings);
                break;
            case "nether_star":
                newItem = new NetherStarItem(itemSettings);
                break;
            case "network_synced":
                newItem = new NetworkSyncedItem(itemSettings);
                break;
            case "on_a_stick":
                EntityType onAStickEntityType = Registries.ENTITY_TYPE.get(new Identifier(jsonObject.get("entity-target").getAsString()));
                int damagePerUse = jsonObject.has("damage-per-use") ? jsonObject.get("damage-per-use").getAsInt() : 1;
                newItem = new OnAStickItem(itemSettings, onAStickEntityType, damagePerUse);
                break;
            case "operator_only_block":
                Block operatorOnlyBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("block") ? jsonObject.get("block").getAsString() : "air"));
                newItem = new OperatorOnlyBlockItem(operatorOnlyBlock, itemSettings);
                break;
            case "pickaxe":
                String pickaxeToolMaterial = jsonObject.get("tool-material").getAsString();
                int pickaxeAttackDamage = jsonObject.has("attack-damage") ? jsonObject.get("attack-damage").getAsInt() : 0;
                float pickaxeAttackSpeed = jsonObject.has("attack-speed") ? jsonObject.get("attack-speed").getAsFloat() : 0F;
                newItem = new PickaxeItem(getToolMaterial(pickaxeToolMaterial), pickaxeAttackDamage, pickaxeAttackSpeed, itemSettings);
                break;
            case "placeable_on_water":
                Block placeableOnWaterBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("block") ? jsonObject.get("block").getAsString() : "air"));
                newItem = new PlaceableOnWaterItem(placeableOnWaterBlock, itemSettings);
                break;
            case "potion":
                newItem = new PotionItem(itemSettings);
                break;
            case "saddle":
                newItem = new SaddleItem(itemSettings);
                break;
            case "scaffolding":
                Block scaffoldingBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("block") ? jsonObject.get("block").getAsString() : "air"));
                newItem = new ScaffoldingItem(scaffoldingBlock,itemSettings);
                break;
            case "shears":
                newItem = new ShearsItem(itemSettings);
                break;
            case "shield":
                newItem = new ShieldItem(itemSettings);
                break;
            case "shovel":
                String shovelToolMaterial = jsonObject.get("tool-material").getAsString();
                int shovelAttackDamage = jsonObject.has("attack-damage") ? jsonObject.get("attack-damage").getAsInt() : 0;
                float shovelAttackSpeed = jsonObject.has("attack-speed") ? jsonObject.get("attack-speed").getAsFloat() : 0F;
                newItem = new ShovelItem(getToolMaterial(shovelToolMaterial), shovelAttackDamage, shovelAttackSpeed, itemSettings);
                break;
            case "skull":
                Block skullBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("skull") ? jsonObject.get("skull").getAsString() : "air"));
                Block skullwallBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("skull-wall") ? jsonObject.get("skull-wall").getAsString() : "air"));
                newItem = new SkullItem(skullBlock, skullwallBlock, itemSettings);
                break;
            case "smithing_template":
                Text appliedToText = Text.of(jsonObject.get("applied-to-text").getAsString());
                Text ingredientsText = Text.of(jsonObject.get("ingredients-text").getAsString());
                Text additionsSlotDescriptionText = Text.of(jsonObject.get("additions-slot-description-text").getAsString());
                Text baseSlotDescriptionText = Text.of(jsonObject.get("base-slot-description-text").getAsString());
                Text emptyAdditionsSlotTextures = Text.of(jsonObject.get("empty-additions-slot-textures").getAsString());
                Text emptyBaseSlotTextures = Text.of(jsonObject.get("empty-base-slot-textures").getAsString());
                newItem = new SmithingTemplateItem(appliedToText, ingredientsText, additionsSlotDescriptionText, baseSlotDescriptionText, emptyAdditionsSlotTextures, (List<Identifier>) emptyBaseSlotTextures, (List<Identifier>) emptyAdditionsSlotTextures);
                break;
            case "snowball":
                newItem = new SnowballItem(itemSettings);
                break;
            case "spawn_egg":
                EntityType SpawnEggEntityType = Registries.ENTITY_TYPE.get(new Identifier(jsonObject.has("entity-type") ? jsonObject.get("entity-type").getAsString() : "air"));
                int primaryColor = jsonObject.has("primary-color") ? jsonObject.get("primary-color").getAsInt() : 0;
                int secondaryColor = jsonObject.has("secondary-color") ? jsonObject.get("secondary-color").getAsInt() : 0;
                newItem = new SpawnEggItem(SpawnEggEntityType, primaryColor, secondaryColor, itemSettings);
                break;
            case "spectral_arrow":
                newItem = new SpectralArrowItem(itemSettings);
                break;
            case "splash_potion":
                newItem = new SplashPotionItem(itemSettings);
                break;
            case "spyglass":
                newItem = new SpyglassItem(itemSettings);
                break;
            case "stew":
                newItem = new StewItem(itemSettings);
                break;
            case "suspicious_stew":
                newItem = new SuspiciousStewItem(itemSettings);
                break;
            case "sword":
                String swordToolMaterial = jsonObject.get("tool-material").getAsString();
                int swordAttackDamage = jsonObject.has("attack-damage") ? jsonObject.get("attack-damage").getAsInt() : 0;
                float swordAttackSpeed = jsonObject.has("attack-speed") ? jsonObject.get("attack-speed").getAsFloat() : 0F;
                newItem = new SwordItem(getToolMaterial(swordToolMaterial), swordAttackDamage, swordAttackSpeed, itemSettings);
                break;
            case "tall_block":
                Block tallBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("skull") ? jsonObject.get("skull").getAsString() : "air"));
                newItem = new TallBlockItem(tallBlock, itemSettings);
                break;
            case "throwable_potion":
                newItem = new ThrowablePotionItem(itemSettings);
                break;
            case "tipped_arrow":
                newItem = new TippedArrowItem(itemSettings);
                break;
            case "trident":
                newItem = new TridentItem(itemSettings);
                break;
            case "vertically_attachable_block":
                Block standingBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("skull") ? jsonObject.get("skull").getAsString() : "air"));
                Block wallBlock = Registries.BLOCK.get(new Identifier(jsonObject.has("skull-wall") ? jsonObject.get("skull").getAsString() : "air"));
                String getverticalAttachmentDirectionString = jsonObject.get("vertical-attachment-direction").getAsString();
                newItem = new VerticallyAttachableBlockItem(standingBlock, wallBlock, itemSettings, getDirectionType(getverticalAttachmentDirectionString));
                break;
            case "writable_book":
                newItem = new WritableBookItem(itemSettings);
                break;
            case "written_book":
                newItem = new WrittenBookItem(itemSettings);
                break;
            default:
                Main.KOIL_LOGGER.error("Unrecognized item type: " + type + " in JSON file: " + path);
                return;
        }
        Registry.register(Registries.ITEM, itemId, newItem);
        Main.KOIL_LOGGER.info("Registered " + type + " item: " + itemName + " with ID: " + itemId);
    }


    private static Rarity getRarity(String rarityString) {
        return switch (rarityString) {
            case "common" -> Rarity.COMMON;
            case "uncommon" -> Rarity.UNCOMMON;
            case "rare" -> Rarity.RARE;
            case "epic" -> Rarity.EPIC;
            default -> Rarity.COMMON;
        };
    }

    private static ToolMaterials getToolMaterial(String toolMaterialString) {
        return switch (toolMaterialString) {
            case "wood" -> ToolMaterials.WOOD;
            case "stone" -> ToolMaterials.STONE;
            case "iron" -> ToolMaterials.IRON;
            case "gold" -> ToolMaterials.GOLD;
            case "diamond" -> ToolMaterials.DIAMOND;
            case "netherite" -> ToolMaterials.NETHERITE;
            default -> ToolMaterials.WOOD;
        };
    }

    private static AbstractMinecartEntity.Type getMinecartItemType(String minecartItemTypeString) {
        return switch (minecartItemTypeString) {
            case "chest" -> AbstractMinecartEntity.Type.CHEST;
            case "command_block" -> AbstractMinecartEntity.Type.COMMAND_BLOCK;
            case "tnt" -> AbstractMinecartEntity.Type.TNT;
            case "furnace" -> AbstractMinecartEntity.Type.FURNACE;
            case "hopper" -> AbstractMinecartEntity.Type.HOPPER;
            case "rideable" -> AbstractMinecartEntity.Type.RIDEABLE;
            case "spawner" -> AbstractMinecartEntity.Type.SPAWNER;
            default -> AbstractMinecartEntity.Type.CHEST;
        };
    }

    /*
    private static ArmorItem.Type getArmorType(String armorTypeString) {
        return switch (armorTypeString) {
            case "helmet" -> ArmorItem.Type.HELMET;
            case "chestplate" -> ArmorItem.Type.CHESTPLATE;
            case "leggings" -> ArmorItem.Type.LEGGINGS;
            case "boots" -> ArmorItem.Type.BOOTS;
            default -> ArmorItem.Type.HELMET;
        };
    }
     */

    private static Direction getDirectionType(String directionTypeString) {
        return switch (directionTypeString) {
            case "north" -> Direction.NORTH;
            case "east" -> Direction.EAST;
            case "south" -> Direction.SOUTH;
            case "west" -> Direction.WEST;
            case "up" -> Direction.UP;
            case "down" -> Direction.DOWN;
            default -> Direction.NORTH;
        };
    }

    private static DyeColor getDyeColor(String dyeColorString) {
        return switch (dyeColorString) {
            case "white" -> DyeColor.WHITE;
            case "light_gray" -> DyeColor.LIGHT_GRAY;
            case "gray" -> DyeColor.GRAY;
            case "black" -> DyeColor.BLACK;
            case "brown" -> DyeColor.BROWN;
            case "red" -> DyeColor.RED;
            case "orange" -> DyeColor.ORANGE;
            case "yellow" -> DyeColor.YELLOW;
            case "lime" -> DyeColor.LIME;
            case "green" -> DyeColor.GREEN;
            case "cyan" -> DyeColor.CYAN;
            case "light_blue" -> DyeColor.LIGHT_BLUE;
            case "blue" -> DyeColor.BLUE;
            case "purple" -> DyeColor.PURPLE;
            case "magenta" -> DyeColor.MAGENTA;
            case "pink" -> DyeColor.PINK;
            default -> DyeColor.WHITE;
        };
    }
}