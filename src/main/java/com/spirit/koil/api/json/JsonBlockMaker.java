package com.spirit.koil.api.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spirit.Main;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JsonBlockMaker {
    public static void makeTheJsonBlocks() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            Path customBlocksDir = Paths.get(server.getRunDirectory().getPath(), "./koil/", server.getSaveProperties().getLevelName() + "/blocks");
            if (!Files.exists(customBlocksDir)) {
                try {
                    Files.createDirectories(customBlocksDir);
                    Main.KOIL_LOGGER.info("Created custom blocks directory: " + customBlocksDir);
                } catch (IOException e) {
                    Main.KOIL_LOGGER.error("Failed to create custom blocks directory", e);
                    return;
                }
            }
            Path datapacksDir = Paths.get(server.getRunDirectory().getPath(), "./saves/", server.getSaveProperties().getLevelName() + "/datapacks/");
            Main.KOIL_LOGGER.info("Searching for datapacks in: " + datapacksDir);
            searchAndCopyBlocks(datapacksDir, customBlocksDir);
        });
    }

    private static void searchAndCopyBlocks(Path sourceDir, Path targetDir) {
        if (!Files.isDirectory(sourceDir)) {
            Main.KOIL_LOGGER.warn("Datapacks directory does not exist or is not a directory: " + sourceDir);
            return;
        }

        try {
            Files.walk(sourceDir)
                    .filter(path -> Files.isDirectory(path) || path.toString().endsWith(".zip"))
                    .forEach(path -> {
                        if (Files.isDirectory(path)) {
                            copyBlocksFromFolder(path, targetDir);
                        } else if (path.toString().endsWith(".zip")) {
                            extractAndCopyBlocksFromZip(path, targetDir);
                        }
                    });
        } catch (IOException e) {
            Main.KOIL_LOGGER.error("Failed to walk through the datapacks directory", e);
        }
    }

    private static void copyBlocksFromFolder(Path sourceDir, Path targetDir) {
        Path koilBlocksDir = sourceDir.resolve("data/koil/blocks");
        if (Files.exists(koilBlocksDir) && Files.isDirectory(koilBlocksDir)) {
            try {
                Files.walk(koilBlocksDir)
                        .filter(Files::isRegularFile)
                        .forEach(sourcePath -> {
                            Path relativePath = koilBlocksDir.relativize(sourcePath);
                            Path targetPath = targetDir.resolve(relativePath);
                            try {
                                Files.createDirectories(targetPath.getParent());
                                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                                Main.KOIL_LOGGER.info("Copied block from folder: " + sourcePath + " to: " + targetPath);
                            } catch (IOException e) {
                                Main.KOIL_LOGGER.error("Failed to copy block from folder: " + sourcePath, e);
                            }
                        });
            } catch (IOException e) {
                Main.KOIL_LOGGER.error("Failed to walk through the koil/blocks directory", e);
            }
        }
    }

    private static void extractAndCopyBlocksFromZip(Path zipFile, Path targetDir) {
        try (ZipFile zip = new ZipFile(zipFile.toFile())) {
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.getName().startsWith("data/koil/blocks/") && !entry.isDirectory()) {
                    Path targetPath = targetDir.resolve(entry.getName().substring("data/koil/blocks/".length()));
                    try (InputStream is = zip.getInputStream(entry)) {
                        Files.createDirectories(targetPath.getParent());
                        Files.copy(is, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        Main.KOIL_LOGGER.info("Extracted and copied block from zip: " + entry.getName() + " to: " + targetPath);
                    } catch (IOException e) {
                        Main.KOIL_LOGGER.error("Failed to extract and copy block from zip: " + entry.getName(), e);
                    }
                }
            }
        } catch (IOException e) {
            Main.KOIL_LOGGER.error("Failed to extract block from zip file: " + zipFile, e);
        }
    }

    public static void registerBlocksFromJson() {
        Path koilDirectory = Paths.get("./koil/").toAbsolutePath();

        try {
            Files.walk(koilDirectory)
                    .filter(Files::isDirectory)
                    .forEach(worldDirectory -> {
                        String worldName = worldDirectory.getFileName().toString();
                        Path blocksDirectory = worldDirectory.resolve("blocks");

                        try {
                            Files.walk(blocksDirectory)
                                    .filter(path -> path.toString().endsWith(".json"))
                                    .forEach(path -> {
                                        try (FileReader reader = new FileReader(path.toFile())) {
                                            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

                                            if (jsonObject.has("type")) {
                                                registerBlockFromJson(jsonObject, worldName, path.toString());
                                            } else {
                                                Main.KOIL_LOGGER.error("Missing 'type' field in JSON file: " + path);
                                            }
                                        } catch (Exception e) {
                                            Main.KOIL_LOGGER.error("Failed to read the JSON file: " + path);
                                            e.printStackTrace();
                                        }
                                    });
                        } catch (IOException e) {
                            Main.KOIL_LOGGER.error("Failed to walk through the blocks directory for world: " + worldName);
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            Main.KOIL_LOGGER.error("Failed to walk through the koil directory");
            e.printStackTrace();
        }
    }


    private static void registerBlockFromJson(JsonObject jsonObject, String path, String string) {
        String type = jsonObject.get("type").getAsString();
        String modId = jsonObject.get("mod-id").getAsString();
        String blockName = jsonObject.get("name").getAsString();
        Identifier blockId = new Identifier(modId, blockName.toLowerCase().replace(" ", "_"));

        float hardness = jsonObject.get("hardness").getAsFloat();
        float resistance = jsonObject.get("resistance").getAsFloat();
        String copyBlockSettings = jsonObject.get("copy-block-settings").getAsString();
        Block copyBlock = getBlockFromString(copyBlockSettings);


        SoundEvent breakSound = Registries.SOUND_EVENT.get(new Identifier(jsonObject.get("break-sound").getAsString()));
        SoundEvent stepSound = Registries.SOUND_EVENT.get(new Identifier(jsonObject.get("step-sound").getAsString()));
        SoundEvent placeSound = Registries.SOUND_EVENT.get(new Identifier(jsonObject.get("place-sound").getAsString()));
        SoundEvent hitSound = Registries.SOUND_EVENT.get(new Identifier(jsonObject.get("hit-sound").getAsString()));
        SoundEvent fallSound = Registries.SOUND_EVENT.get(new Identifier(jsonObject.get("fall-sound").getAsString()));



        float volume = jsonObject.get("volume").getAsFloat();
        float pitch = jsonObject.get("pitch").getAsFloat();
        float radius = jsonObject.get("radius").getAsFloat();

        BlockSoundGroup blockSoundGroup = new BlockSoundGroup(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);

        Block.Settings blockSettings = FabricBlockSettings.copy(copyBlock)
                .strength(hardness, resistance)
                .sounds(blockSoundGroup);


        boolean requiresTool = jsonObject.has("requires-tool") && jsonObject.get("requires-tool").getAsBoolean();
        if (requiresTool) {blockSettings.requiresTool();}
        boolean breakInstantly = jsonObject.has("break-instantly") && jsonObject.get("break-instantly").getAsBoolean();
        if (breakInstantly) {blockSettings.breakInstantly();}
        boolean burnable = jsonObject.has("burnable") && jsonObject.get("burnable").getAsBoolean();
        if (burnable) {blockSettings.burnable();}
        boolean dropsNothing = jsonObject.has("drops-nothing") && jsonObject.get("drops-nothing").getAsBoolean();
        if (dropsNothing) {blockSettings.dropsNothing();}
        boolean noCollision = jsonObject.has("no-collision") && jsonObject.get("no-collision").getAsBoolean();
        if (noCollision) {blockSettings.noCollision();}
        boolean nonOpaque = jsonObject.has("non-opaque") && jsonObject.get("non-opaque").getAsBoolean();
        if (nonOpaque) {blockSettings.nonOpaque();}
        boolean ticksRandomly = jsonObject.has("ticks-randomly") && jsonObject.get("ticks-randomly").getAsBoolean();
        if (ticksRandomly) {blockSettings.ticksRandomly();}
        boolean hasLuminance = jsonObject.has("has-luminance") && jsonObject.get("has-luminance").getAsBoolean();
        if (hasLuminance) {
            int luminance = jsonObject.get("luminance").getAsInt();
            blockSettings.luminance((state) -> luminance);
        }

        String pistonBehaviorString = jsonObject.get("piston-behavior").getAsString();
        Block.Settings blockSettingsWithPistonBehavior = setPistonBehavior(blockSettings, pistonBehaviorString);


        Block newBlock;
        switch (type) {
            case "air":
                newBlock = new AirBlock(blockSettingsWithPistonBehavior);
                break;
            case "amethyst":
                newBlock = new AmethystBlock(blockSettingsWithPistonBehavior);
                break;
            case "amethyst_cluster":
                int cluster_height = jsonObject.get("cluster-height").getAsInt();
                int cluster_xzOffset = jsonObject.get("cluster-xz-offset").getAsInt();
                newBlock = new AmethystClusterBlock(cluster_height, cluster_xzOffset, blockSettingsWithPistonBehavior);
                break;
            case "anvil":
                newBlock = new AnvilBlock(blockSettingsWithPistonBehavior);
                break;
            case "azalea":
                newBlock = new AzaleaBlock(blockSettingsWithPistonBehavior);
                break;
            case "bamboo":
                newBlock = new BambooBlock(blockSettingsWithPistonBehavior);
                break;
            case "bamboo_sapling":
                newBlock = new BambooSaplingBlock(blockSettingsWithPistonBehavior);
                break;
            case "banner":
                String getBannerDyeColorString = jsonObject.get("dye-color").getAsString();
                newBlock = new BannerBlock(getDyeColor(getBannerDyeColorString), blockSettingsWithPistonBehavior);
                break;
            case "barrel":
                newBlock = new BarrelBlock(blockSettingsWithPistonBehavior);
                break;
            case "beacon":
                newBlock = new BeaconBlock(blockSettingsWithPistonBehavior);
                break;
            case "bed":
                String getBedDyeColorString = jsonObject.get("dye-color").getAsString();
                newBlock = new BedBlock(getDyeColor(getBedDyeColorString), blockSettingsWithPistonBehavior);
                break;
            case "beehive":
                newBlock = new BeehiveBlock(blockSettingsWithPistonBehavior);
                break;
            case "beetroots":
                newBlock = new BeetrootsBlock(blockSettingsWithPistonBehavior);
                break;
            case "bell":
                newBlock = new BellBlock(blockSettingsWithPistonBehavior);
                break;
            case "big_drip_leaf":
                newBlock = new BigDripleafBlock(blockSettingsWithPistonBehavior);
                break;
            case "blast_furnace":
                newBlock = new BlastFurnaceBlock(blockSettingsWithPistonBehavior);
                break;
            case "block":
                newBlock = new Block(blockSettingsWithPistonBehavior);
                break;
            case "brewing_stand":
                newBlock = new BrewingStandBlock(blockSettingsWithPistonBehavior);
                break;
            case "brushable":
                String baseBlockJson = jsonObject.get("base-block").getAsString();
                SoundEvent brushing_sound = Registries.SOUND_EVENT.get(new Identifier(jsonObject.get("brushing-sound").getAsString()));
                SoundEvent brushing_complete_sound = Registries.SOUND_EVENT.get(new Identifier(jsonObject.get("brushing-complete-sound").getAsString()));
                newBlock = new BrushableBlock(getBlockFromString(baseBlockJson), blockSettingsWithPistonBehavior, brushing_sound, brushing_complete_sound);
                break;
            case "bubble_column":
                newBlock = new BubbleColumnBlock(blockSettingsWithPistonBehavior);
                break;
            case "budding_amethyst":
                newBlock = new BuddingAmethystBlock(blockSettingsWithPistonBehavior);
                break;
            case "button":
                String blockSetType = jsonObject.has("set-type") ? jsonObject.get("set-type").getAsString() : "oak";
                int pressTicks = jsonObject.get("press-ticks").getAsInt();
                boolean wooden = jsonObject.has("is-wooden") && jsonObject.get("is-wooden").getAsBoolean();
                newBlock = new ButtonBlock(blockSettingsWithPistonBehavior, getBlockSetTypeFromString(blockSetType), pressTicks, wooden);
                break;
            case "cactus":
                newBlock = new CactusBlock(blockSettingsWithPistonBehavior);
                break;
            case "cake":
                newBlock = new CakeBlock(blockSettingsWithPistonBehavior);
                break;
            case "calibrated_sculk_sensor":
                newBlock = new CalibratedSculkSensorBlock(blockSettingsWithPistonBehavior);
                break;
            case "campfire":
                boolean emitsParticles = jsonObject.has("emits-particles") && jsonObject.get("emits-particles").getAsBoolean();
                int fireDamage = jsonObject.has("fire-damage") ? jsonObject.get("fire-damage").getAsInt() : 1;
                newBlock = new CampfireBlock(emitsParticles, fireDamage, blockSettingsWithPistonBehavior);
                break;
            case "candle":
                newBlock = new CandleBlock(blockSettingsWithPistonBehavior);
                break;
            case "candle_cake":
                String getCandleColorString = jsonObject.get("candle-color").getAsString();
                newBlock = new CandleCakeBlock(getCandleColor(getCandleColorString), blockSettingsWithPistonBehavior);
                break;
            case "carpet":
                newBlock = new CarpetBlock(blockSettingsWithPistonBehavior);
                break;
            case "carrots":
                newBlock = new CarrotsBlock(blockSettingsWithPistonBehavior);
                break;
            case "cartography_table":
                newBlock = new CartographyTableBlock(blockSettingsWithPistonBehavior);
                break;
            case "carved_pumpkin":
                newBlock = new CarvedPumpkinBlock(blockSettingsWithPistonBehavior);
                break;
            case "cauldron":
                newBlock = new CauldronBlock(blockSettingsWithPistonBehavior);
                break;
            case "cave_vines_body":
                newBlock = new CaveVinesBodyBlock(blockSettingsWithPistonBehavior);
                break;
            case "cave_vines_head":
                newBlock = new CaveVinesHeadBlock(blockSettingsWithPistonBehavior);
                break;
            case "chain":
                newBlock = new ChainBlock(blockSettingsWithPistonBehavior);
                break;
            case "cherry_leaves":
                newBlock = new CherryLeavesBlock(blockSettingsWithPistonBehavior);
                break;
            case "chiseled_bookshelf":
                newBlock = new ChiseledBookshelfBlock(blockSettingsWithPistonBehavior);
                break;
            case "chorus_plant":
                newBlock = new ChorusPlantBlock(blockSettingsWithPistonBehavior);
                break;
            case "cobweb":
                newBlock = new CobwebBlock(blockSettingsWithPistonBehavior);
                break;
            case "cocoa":
                newBlock = new CocoaBlock(blockSettingsWithPistonBehavior);
                break;
            case "command_block":
                boolean auto = jsonObject.has("command-block-auto") && jsonObject.get("command-block-auto").getAsBoolean();
                newBlock = new CommandBlock(blockSettingsWithPistonBehavior, auto);
                break;
            case "comparator":
                newBlock = new ComparatorBlock(blockSettingsWithPistonBehavior);
                break;
            case "composter":
                newBlock = new ComposterBlock(blockSettingsWithPistonBehavior);
                break;
            case "concrete_powder":
                String getHardenedConcreteString = jsonObject.get("concrete-color").getAsString();
                newBlock = new ConcretePowderBlock(getHardenedConcrete(getHardenedConcreteString), blockSettingsWithPistonBehavior);
                break;
            case "conduit":
                newBlock = new ConduitBlock(blockSettingsWithPistonBehavior);
                break;
            case "connecting":
                newBlock = new ConnectingBlock(radius, blockSettingsWithPistonBehavior);
                break;
            case "coral":
                String getDeadCoralBlockString = jsonObject.get("dead-coral-block").getAsString();
                newBlock = new CoralBlock(getDeadCoralBlock(getDeadCoralBlockString), blockSettingsWithPistonBehavior);
                break;
            case "coral_coral":
                String getDeadCoralCoralBlockString = jsonObject.get("dead-coral-coral-block").getAsString();
                newBlock = new CoralBlockBlock(getDeadCoralBlock(getDeadCoralCoralBlockString), blockSettingsWithPistonBehavior);
                break;
            case "coral_fan":
                String getDeadCoralFanBlockString = jsonObject.get("dead-coral-fan-block").getAsString();
                newBlock = new CoralFanBlock(getDeadCoralFanBlock(getDeadCoralFanBlockString), blockSettingsWithPistonBehavior);
                break;
            case "coral_parent":
                newBlock = new CoralParentBlock(blockSettingsWithPistonBehavior);
                break;
            case "coral_wall_fan":
                String getDeadCoralWallFanBlockString = jsonObject.get("dead-coral-wall-fan-block").getAsString();
                newBlock = new CoralWallFanBlock(getDeadCoralWallFanBlock(getDeadCoralWallFanBlockString), blockSettingsWithPistonBehavior);
                break;
            case "crafting_table":
                newBlock = new CraftingTableBlock(blockSettingsWithPistonBehavior);
                break;
            case "crop_block":
                newBlock = new CropBlock(blockSettingsWithPistonBehavior);
                break;
            case "crying_obsidian":
                newBlock = new CryingObsidianBlock(blockSettingsWithPistonBehavior);
                break;
            case "daylight_detector":
                newBlock = new DaylightDetectorBlock(blockSettingsWithPistonBehavior);
                break;
            case "dead_bush":
                newBlock = new DeadBushBlock(blockSettingsWithPistonBehavior);
                break;
            case "dead_coral":
                newBlock = new DeadCoralBlock(blockSettingsWithPistonBehavior);
                break;
            case "dead_coral_fan":
                newBlock = new DeadCoralFanBlock(blockSettingsWithPistonBehavior);
                break;
            case "dead_coral_wall_fan":
                newBlock = new DeadCoralWallFanBlock(blockSettingsWithPistonBehavior);
                break;
            case "decorated_pot":
                newBlock = new DecoratedPotBlock(blockSettingsWithPistonBehavior);
                break;
            case "detector_rail":
                newBlock = new DetectorRailBlock(blockSettingsWithPistonBehavior);
                break;
            case "dirt_path":
                newBlock = new DirtPathBlock(blockSettingsWithPistonBehavior);
                break;
            case "dispenser":
                newBlock = new DispenserBlock(blockSettingsWithPistonBehavior);
                break;
            case "door":
                String doorSetType = jsonObject.has("set-type") ? jsonObject.get("set-type").getAsString() : "oak";
                newBlock = new DoorBlock(blockSettingsWithPistonBehavior, getBlockSetTypeFromString(doorSetType));
                break;
            case "dragon_egg":
                newBlock = new DragonEggBlock(blockSettingsWithPistonBehavior);
                break;
            case "dropper":
                newBlock = new DropperBlock(blockSettingsWithPistonBehavior);
                break;
            case "dyed_carpet":
                String getCarpetDyeColorString = jsonObject.get("dye-color").getAsString();
                newBlock = new DyedCarpetBlock(getDyeColor(getCarpetDyeColorString), blockSettingsWithPistonBehavior);
                break;
            case "enchanting_table":
                newBlock = new EnchantingTableBlock(blockSettingsWithPistonBehavior);
                break;
            case "ender_chest":
                newBlock = new EnderChestBlock(blockSettingsWithPistonBehavior);
                break;
            case "end_gateway":
                newBlock = new EndGatewayBlock(blockSettingsWithPistonBehavior);
                break;
            case "end_portal":
                newBlock = new EndPortalBlock(blockSettingsWithPistonBehavior);
                break;
            case "end_portal_frame":
                newBlock = new EndPortalFrameBlock(blockSettingsWithPistonBehavior);
                break;
            case "end_rod":
                newBlock = new EndRodBlock(blockSettingsWithPistonBehavior);
                break;
            case "experience_dropping":
                newBlock = new ExperienceDroppingBlock(blockSettingsWithPistonBehavior);
                break;
            case "falling_block":
                newBlock = new FallingBlock(blockSettingsWithPistonBehavior);
                break;
            case "farmland":
                newBlock = new FarmlandBlock(blockSettingsWithPistonBehavior);
                break;
            case "fence":
                newBlock = new FenceBlock(blockSettingsWithPistonBehavior);
                break;
            case "fence_gate":
                String fenceGateWoodType = jsonObject.has("wood-type") ? jsonObject.get("wood-type").getAsString() : "oak";
                newBlock = new FenceGateBlock(blockSettingsWithPistonBehavior, getWoodTypeFromString(fenceGateWoodType));
                break;
            case "fern":
                newBlock = new FernBlock(blockSettingsWithPistonBehavior);
                break;
            case "fire":
                newBlock = new FireBlock(blockSettingsWithPistonBehavior);
                break;
            case "fletching_table":
                newBlock = new FletchingTableBlock(blockSettingsWithPistonBehavior);
                break;
            case "flowerbed":
                newBlock = new FlowerbedBlock(blockSettingsWithPistonBehavior);
                break;
            case "flower":
                StatusEffect suspiciousStewEffect = Registries.STATUS_EFFECT.get(new Identifier(jsonObject.get("suspicious-stew-effect").getAsString()));
                int effectDuration = jsonObject.has("effect-duration") ? jsonObject.get("effect-duration").getAsInt() : 20;
                newBlock = new FlowerBlock(suspiciousStewEffect, effectDuration, blockSettingsWithPistonBehavior);
                break;
            case "flower_pot":
                String content = jsonObject.has("pot-content") ? jsonObject.get("pot-content").getAsString() : "poppy";
                newBlock = new FlowerPotBlock(getContentFromString(content), blockSettingsWithPistonBehavior);
                break;
            case "frogspawn":
                newBlock = new FrogspawnBlock(blockSettingsWithPistonBehavior);
                break;
            case "frosted_ice":
                newBlock = new FrostedIceBlock(blockSettingsWithPistonBehavior);
                break;
            case "furnace":
                newBlock = new FurnaceBlock(blockSettingsWithPistonBehavior);
                break;
            case "glass":
                newBlock = new GlassBlock(blockSettingsWithPistonBehavior);
                break;
            case "glazed_terracotta":
                newBlock = new GlazedTerracottaBlock(blockSettingsWithPistonBehavior);
                break;
            case "glow_lichen":
                newBlock = new GlowLichenBlock(blockSettingsWithPistonBehavior);
                break;
            case "grass":
                newBlock = new GrassBlock(blockSettingsWithPistonBehavior);
                break;
            case "gravel":
                newBlock = new GravelBlock(blockSettingsWithPistonBehavior);
                break;
            case "grindstone":
                newBlock = new GrindstoneBlock(blockSettingsWithPistonBehavior);
                break;
            case "hanging_roots":
                newBlock = new HangingRootsBlock(blockSettingsWithPistonBehavior);
                break;
            case "hanging_sign":
                String hangingSignWoodType = jsonObject.has("wood-type") ? jsonObject.get("wood-type").getAsString() : "oak";
                newBlock = new HangingSignBlock(blockSettingsWithPistonBehavior, getWoodTypeFromString(hangingSignWoodType));
                break;
            case "hay":
                newBlock = new HayBlock(blockSettingsWithPistonBehavior);
                break;
            case "honey":
                newBlock = new HoneyBlock(blockSettingsWithPistonBehavior);
                break;
            case "hopper":
                newBlock = new HopperBlock(blockSettingsWithPistonBehavior);
                break;
            case "horizontal_connecting":
                float radius1 = jsonObject.has("radius-1") ? jsonObject.get("radius-1").getAsFloat() : 1;
                float radius2 = jsonObject.has("radius-2") ? jsonObject.get("radius-2").getAsFloat() : 1;
                float boundingHeight1 = jsonObject.has("bounding-height-1") ? jsonObject.get("bounding-height-1").getAsFloat() : 1;
                float boundingHeight2 = jsonObject.has("bounding-height-2") ? jsonObject.get("bounding-height-2").getAsFloat() : 1;
                float collisionHeight = jsonObject.has("collision-height") ? jsonObject.get("collision-height").getAsFloat() : 1;
                newBlock = new HorizontalConnectingBlock(radius1, radius2, boundingHeight1, boundingHeight2, collisionHeight, blockSettingsWithPistonBehavior);
                break;
            case "ice":
                newBlock = new IceBlock(blockSettingsWithPistonBehavior);
                break;
            case "infested":
                Block regularBlock = Registries.BLOCK.get(new Identifier(jsonObject.get("normal-block").getAsString()));
                newBlock = new InfestedBlock(regularBlock, blockSettingsWithPistonBehavior);
                break;
            case "jigsaw":
                newBlock = new JigsawBlock(blockSettingsWithPistonBehavior);
                break;
            case "jukebox":
                newBlock = new JukeboxBlock(blockSettingsWithPistonBehavior);
                break;
            case "kelp":
                newBlock = new KelpBlock(blockSettingsWithPistonBehavior);
                break;
            case "kelp_plant":
                newBlock = new KelpPlantBlock(blockSettingsWithPistonBehavior);
                break;
            case "ladder":
                newBlock = new LadderBlock(blockSettingsWithPistonBehavior);
                break;
            case "lantern":
                newBlock = new LanternBlock(blockSettingsWithPistonBehavior);
                break;
            case "lava_cauldron":
                newBlock = new LavaCauldronBlock(blockSettingsWithPistonBehavior);
                break;
            case "leaves":
                newBlock = new LeavesBlock(blockSettingsWithPistonBehavior);
                break;
            case "lectern":
                newBlock = new LecternBlock(blockSettingsWithPistonBehavior);
                break;
            case "lever":
                newBlock = new LeverBlock(blockSettingsWithPistonBehavior);
                break;
            case "light":
                newBlock = new LightBlock(blockSettingsWithPistonBehavior);
                break;
            case "lightning_rod":
                newBlock = new LightningRodBlock(blockSettingsWithPistonBehavior);
                break;
            case "lily_pad":
                newBlock = new LilyPadBlock(blockSettingsWithPistonBehavior);
                break;
            case "loom":
                newBlock = new LoomBlock(blockSettingsWithPistonBehavior);
                break;
            case "magma":
                newBlock = new MagmaBlock(blockSettingsWithPistonBehavior);
                break;
            case "mangrove_leaves":
                newBlock = new MangroveLeavesBlock(blockSettingsWithPistonBehavior);
                break;
            case "mangrove_roots":
                newBlock = new MangroveRootsBlock(blockSettingsWithPistonBehavior);
                break;
            case "melon":
                newBlock = new MelonBlock(blockSettingsWithPistonBehavior);
                break;
            case "moss":
                newBlock = new MossBlock(blockSettingsWithPistonBehavior);
                break;
            case "mud":
                newBlock = new MudBlock(blockSettingsWithPistonBehavior);
                break;
            case "mushroom":
                newBlock = new MushroomBlock(blockSettingsWithPistonBehavior);
                break;
            case "mycelium":
                newBlock = new MyceliumBlock(blockSettingsWithPistonBehavior);
                break;
            case "nether_portal":
                newBlock = new NetherPortalBlock(blockSettingsWithPistonBehavior);
                break;
            case "netherrack":
                newBlock = new NetherrackBlock(blockSettingsWithPistonBehavior);
                break;
            case "nether_wart":
                newBlock = new NetherWartBlock(blockSettingsWithPistonBehavior);
                break;
            case "note":
                newBlock = new NoteBlock(blockSettingsWithPistonBehavior);
                break;
            case "nylium":
                newBlock = new NyliumBlock(blockSettingsWithPistonBehavior);
                break;
            case "observer":
                newBlock = new ObserverBlock(blockSettingsWithPistonBehavior);
                break;
            case "oxidizable":
                Oxidizable.OxidationLevel oxidationBlockLevel = Oxidizable.OxidationLevel.valueOf(jsonObject.get("oxidation-level").getAsString());
                newBlock = new OxidizableBlock(oxidationBlockLevel, blockSettingsWithPistonBehavior);
                break;
            case "oxidizable_slab":
                Oxidizable.OxidationLevel oxidationSlabLevel = Oxidizable.OxidationLevel.valueOf(jsonObject.get("oxidation-level").getAsString());
                newBlock = new OxidizableSlabBlock(oxidationSlabLevel, blockSettingsWithPistonBehavior);
                break;
            case "pane":
                newBlock = new PaneBlock(blockSettingsWithPistonBehavior);
                break;
            case "pillar":
                newBlock = new PillarBlock(blockSettingsWithPistonBehavior);
                break;
            case "piston":
                boolean sticky = jsonObject.has("sticky") && jsonObject.get("sticky").getAsBoolean();
                newBlock = new PistonBlock(sticky, blockSettingsWithPistonBehavior);
                break;
            case "piston_extension":
                newBlock = new PistonExtensionBlock(blockSettingsWithPistonBehavior);
                break;
            case "piston_head":
                newBlock = new PistonHeadBlock(blockSettingsWithPistonBehavior);
                break;
            case "pitcher_crop":
                newBlock = new PitcherCropBlock(blockSettingsWithPistonBehavior);
                break;
            case "plant":
                newBlock = new PlantBlock(blockSettingsWithPistonBehavior);
                break;
            case "player_skull":
                newBlock = new PlayerSkullBlock(blockSettingsWithPistonBehavior);
                break;
            case "pointed_dripstone":
                newBlock = new PointedDripstoneBlock(blockSettingsWithPistonBehavior);
                break;
            case "potatoes":
                newBlock = new PotatoesBlock(blockSettingsWithPistonBehavior);
                break;
            case "powder_snow":
                newBlock = new PowderSnowBlock(blockSettingsWithPistonBehavior);
                break;
            case "powered_rail":
                newBlock = new PoweredRailBlock(blockSettingsWithPistonBehavior);
                break;
            case "pressure_plate":
                String pressurePlateActivationString = jsonObject.get("pressure-plate-activation").getAsString();
                PressurePlateBlock.ActivationRule blockSettingsWithPressurePlateActivation = setPressurePlateActivation(pressurePlateActivationString);
                String pressurePlateSetType = jsonObject.has("set-type") ? jsonObject.get("set-type").getAsString() : "oak";
                newBlock = new PressurePlateBlock(blockSettingsWithPressurePlateActivation, blockSettingsWithPistonBehavior, getBlockSetTypeFromString(pressurePlateSetType));
                break;
            case "propagule":
                newBlock = new PropaguleBlock(blockSettingsWithPistonBehavior);
                break;
            case "pumpkin":
                newBlock = new PumpkinBlock(blockSettingsWithPistonBehavior);
                break;
            case "rail":
                newBlock = new RailBlock(blockSettingsWithPistonBehavior);
                break;
            case "redstone":
                newBlock = new RedstoneBlock(blockSettingsWithPistonBehavior);
                break;
            case "redstone_lamp":
                newBlock = new RedstoneLampBlock(blockSettingsWithPistonBehavior);
                break;
            case "redstone_ore":
                newBlock = new RedstoneOreBlock(blockSettingsWithPistonBehavior);
                break;
            case "redstone_torch":
                newBlock = new RedstoneTorchBlock(blockSettingsWithPistonBehavior);
                break;
            case "redstone_wire":
                newBlock = new RedstoneWireBlock(blockSettingsWithPistonBehavior);
                break;
            case "repeater":
                newBlock = new RepeaterBlock(blockSettingsWithPistonBehavior);
                break;
            case "respawn_anchor":
                newBlock = new RespawnAnchorBlock(blockSettingsWithPistonBehavior);
                break;
            case "rod":
                newBlock = new RodBlock(blockSettingsWithPistonBehavior);
                break;
            case "rooted_dirt":
                newBlock = new RootedDirtBlock(blockSettingsWithPistonBehavior);
                break;
            case "roots":
                newBlock = new RootsBlock(blockSettingsWithPistonBehavior);
                break;
            case "rotated_infested":
                Block regularRotatedBlock = Registries.BLOCK.get(new Identifier(jsonObject.get("normal-block").getAsString()));
                newBlock = new RotatedInfestedBlock(regularRotatedBlock,blockSettingsWithPistonBehavior);
                break;
            case "sand":
                int color = jsonObject.has("sand-color") ? jsonObject.get("sand-color").getAsInt() : 1;
                newBlock = new SandBlock(color, blockSettingsWithPistonBehavior);
                break;
            case "scaffolding":
                newBlock = new ScaffoldingBlock(blockSettingsWithPistonBehavior);
                break;
            case "sculk":
                newBlock = new SculkBlock(blockSettingsWithPistonBehavior);
                break;
            case "sculk_catalyst":
                newBlock = new SculkCatalystBlock(blockSettingsWithPistonBehavior);
                break;
            case "sculk_sensor":
                newBlock = new SculkSensorBlock(blockSettingsWithPistonBehavior);
                break;
            case "sculk_shrieker":
                newBlock = new SculkShriekerBlock(blockSettingsWithPistonBehavior);
                break;
            case "sculk_vein":
                newBlock = new SculkVeinBlock(blockSettingsWithPistonBehavior);
                break;
            case "seagrass":
                newBlock = new SeagrassBlock(blockSettingsWithPistonBehavior);
                break;
            case "sea_pickle":
                newBlock = new SeaPickleBlock(blockSettingsWithPistonBehavior);
                break;
            case "shulker_box":
                String getShulkerBoxDyeColorString = jsonObject.get("dye-color").getAsString();
                newBlock = new ShulkerBoxBlock(getDyeColor(getShulkerBoxDyeColorString),blockSettingsWithPistonBehavior);
                break;
            case "sign":
                String signWoodType = jsonObject.has("wood-type") ? jsonObject.get("wood-type").getAsString() : "oak";
                newBlock = new SignBlock(blockSettingsWithPistonBehavior, getWoodTypeFromString(signWoodType));
                break;
            case "slab":
                newBlock = new SlabBlock(blockSettingsWithPistonBehavior);
                break;
            case "slime":
                newBlock = new SlimeBlock(blockSettingsWithPistonBehavior);
                break;
            case "small_dripleaf":
                newBlock = new SmallDripleafBlock(blockSettingsWithPistonBehavior);
                break;
            case "smithing_table":
                newBlock = new SmithingTableBlock(blockSettingsWithPistonBehavior);
                break;
            case "smoker":
                newBlock = new SmokerBlock(blockSettingsWithPistonBehavior);
                break;
            case "sniffer_egg":
                newBlock = new SnifferEggBlock(blockSettingsWithPistonBehavior);
                break;
            case "snow":
                newBlock = new SnowBlock(blockSettingsWithPistonBehavior);
                break;
            case "snowy":
                newBlock = new SnowyBlock(blockSettingsWithPistonBehavior);
                break;
            case "soul_fire":
                newBlock = new SoulFireBlock(blockSettingsWithPistonBehavior);
                break;
            case "soul_sand":
                newBlock = new SoulSandBlock(blockSettingsWithPistonBehavior);
                break;
            case "spawner":
                newBlock = new SpawnerBlock(blockSettingsWithPistonBehavior);
                break;
            case "sponge":
                newBlock = new SpongeBlock(blockSettingsWithPistonBehavior);
                break;
            case "spore_blossom":
                newBlock = new SporeBlossomBlock(blockSettingsWithPistonBehavior);
                break;
            case "sprouts":
                newBlock = new SproutsBlock(blockSettingsWithPistonBehavior);
                break;
            case "stained_glass":
                String getStainedGlassDyeColorString = jsonObject.get("dye-color").getAsString();
                newBlock = new StainedGlassBlock(getDyeColor(getStainedGlassDyeColorString),blockSettingsWithPistonBehavior);
                break;
            case "stained_glass_pane":
                String getStainedGlassPaneDyeColorString = jsonObject.get("dye-color").getAsString();
                newBlock = new StainedGlassPaneBlock(getDyeColor(getStainedGlassPaneDyeColorString), blockSettingsWithPistonBehavior);
                break;
            case "stairs":
                newBlock = new StairsBlock(copyBlock.getDefaultState(), blockSettingsWithPistonBehavior);
                break;
            case "stonecutter":
                newBlock = new StonecutterBlock(blockSettingsWithPistonBehavior);
                break;
            case "structure":
                newBlock = new StructureBlock(blockSettingsWithPistonBehavior);
                break;
            case "structure_void":
                newBlock = new StructureVoidBlock(blockSettingsWithPistonBehavior);
                break;
            case "sugar_cane":
                newBlock = new SugarCaneBlock(blockSettingsWithPistonBehavior);
                break;
            case "sweet_berry_bush":
                newBlock = new SweetBerryBushBlock(blockSettingsWithPistonBehavior);
                break;
            case "tall_flower":
                newBlock = new TallFlowerBlock(blockSettingsWithPistonBehavior);
                break;
            case "tall_plant":
                newBlock = new TallPlantBlock(blockSettingsWithPistonBehavior);
                break;
            case "tall_seagrass":
                newBlock = new TallSeagrassBlock(blockSettingsWithPistonBehavior);
                break;
            case "target":
                newBlock = new TargetBlock(blockSettingsWithPistonBehavior);
                break;
            case "tinted_glass":
                newBlock = new TintedGlassBlock(blockSettingsWithPistonBehavior);
                break;
            case "tnt":
                newBlock = new TntBlock(blockSettingsWithPistonBehavior);
                break;
            case "torch":
                ParticleEffect torchParticle = (ParticleEffect) Registries.PARTICLE_TYPE.get(new Identifier(jsonObject.get("particle").getAsString()));
                newBlock = new TorchBlock(blockSettingsWithPistonBehavior, torchParticle);
                break;
            case "torch_flower":
                newBlock = new TorchflowerBlock(blockSettingsWithPistonBehavior);
                break;
            case "transparent":
                newBlock = new TransparentBlock(blockSettingsWithPistonBehavior);
                break;
            case "trapdoor":
                String trapdoorSetType = jsonObject.has("set-type") ? jsonObject.get("set-type").getAsString() : "oak";
                newBlock = new TrapdoorBlock(blockSettingsWithPistonBehavior, getBlockSetTypeFromString(trapdoorSetType));
                break;
            case "trapped_chest":
                newBlock = new TrappedChestBlock(blockSettingsWithPistonBehavior);
                break;
            case "tripwire":
                TripwireHookBlock hookBlock = (TripwireHookBlock) Registries.BLOCK.get(new Identifier(jsonObject.get("hook-block").getAsString()));
                newBlock = new TripwireBlock(hookBlock, blockSettingsWithPistonBehavior);
                break;
            case "tripwire_hook":
                newBlock = new TripwireHookBlock(blockSettingsWithPistonBehavior);
                break;
            case "turtle_egg":
                newBlock = new TurtleEggBlock(blockSettingsWithPistonBehavior);
                break;
            case "twisting_vines":
                newBlock = new TwistingVinesBlock(blockSettingsWithPistonBehavior);
                break;
            case "twisting_vines_plant":
                newBlock = new TwistingVinesPlantBlock(blockSettingsWithPistonBehavior);
                break;
            case "vine":
                newBlock = new VineBlock(blockSettingsWithPistonBehavior);
                break;
            case "wall_banner":
                String getWallBannerDyeColorString = jsonObject.get("dye-color").getAsString();
                newBlock = new WallBannerBlock(getDyeColor(getWallBannerDyeColorString),blockSettingsWithPistonBehavior);
                break;
            case "wall":
                newBlock = new WallBlock(blockSettingsWithPistonBehavior);
                break;
            case "wall_hanging_sign":
                String hangingWallSignWoodType = jsonObject.has("wood-type") ? jsonObject.get("wood-type").getAsString() : "oak";
                newBlock = new WallHangingSignBlock(blockSettingsWithPistonBehavior, getWoodTypeFromString(hangingWallSignWoodType));
                break;
            case "wall_mounted":
                newBlock = new WallMountedBlock(blockSettingsWithPistonBehavior);
                break;
            case "wall_piglin_head":
                newBlock = new WallPiglinHeadBlock(blockSettingsWithPistonBehavior);
                break;
            case "wall_player_skull":
                newBlock = new WallPlayerSkullBlock(blockSettingsWithPistonBehavior);
                break;
            case "wall_redstone_torch":
                newBlock = new WallRedstoneTorchBlock(blockSettingsWithPistonBehavior);
                break;
            case "wall_sign":
                String wallSignWoodType = jsonObject.has("wood-type") ? jsonObject.get("wood-type").getAsString() : "oak";
                newBlock = new WallSignBlock(blockSettingsWithPistonBehavior, getWoodTypeFromString(wallSignWoodType));
                break;
            case "wall_torch":
                ParticleEffect wallTorchParticle = (ParticleEffect) Registries.PARTICLE_TYPE.get(new Identifier(jsonObject.get("particle").getAsString()));
                newBlock = new WallTorchBlock(blockSettingsWithPistonBehavior, wallTorchParticle);
                break;
            case "wall_wither_skull":
                newBlock = new WallWitherSkullBlock(blockSettingsWithPistonBehavior);
                break;
            case "wearable_carved_pumpkin":
                newBlock = new WearableCarvedPumpkinBlock(blockSettingsWithPistonBehavior);
                break;
            case "weeping_vines":
                newBlock = new WeepingVinesBlock(blockSettingsWithPistonBehavior);
                break;
            case "weeping_vines_plant":
                newBlock = new WeepingVinesPlantBlock(blockSettingsWithPistonBehavior);
                break;
            case "weighted_pressure_plate":
                String blockWeightedSetType = jsonObject.has("set-type") ? jsonObject.get("set-type").getAsString() : "oak";
                int weight = jsonObject.has("weight") ? jsonObject.get("weight").getAsInt() : 1;
                newBlock = new WeightedPressurePlateBlock(weight, blockSettingsWithPistonBehavior, getBlockSetTypeFromString(blockWeightedSetType));
                break;
            case "wet_sponge":
                newBlock = new WetSpongeBlock(blockSettingsWithPistonBehavior);
                break;
            case "wither_rose":
                StatusEffect effect = Registries.STATUS_EFFECT.get(new Identifier(jsonObject.get("status-effect").getAsString()));
                newBlock = new WitherRoseBlock(effect, blockSettingsWithPistonBehavior);
                break;
            case "wither_skull":
                newBlock = new WitherSkullBlock(blockSettingsWithPistonBehavior);
                break;
            default:
                Main.KOIL_LOGGER.error("Unrecognized block type: " + type + " in JSON file: " + path);
                return;
        }

        Registry.register(Registries.BLOCK, blockId, newBlock);
        Registry.register(Registries.ITEM, blockId, new BlockItem(newBlock, new Item.Settings()));
        Main.KOIL_LOGGER.info("Registered " + type + " block: " + blockName + " with ID: " + blockId);
    }

    private static Block getBlockFromString(String blockName) {
        Identifier identifier = Identifier.tryParse(blockName);
        if (identifier != null) {
            return Registries.BLOCK.get(identifier);
        } else {
            return Blocks.AIR;
        }
    }

    private static Block.Settings setPistonBehavior(Block.Settings settings, String pistonBehaviorString) {
        Block.Settings updatedSettings = settings;
        updatedSettings = switch (pistonBehaviorString) {
            case "normal" -> updatedSettings.pistonBehavior(PistonBehavior.NORMAL);
            case "destroy" -> updatedSettings.pistonBehavior(PistonBehavior.DESTROY);
            case "block" -> updatedSettings.pistonBehavior(PistonBehavior.BLOCK);
            default -> updatedSettings;
        };
        return updatedSettings;
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

    private static Block getCandleColor(String candleColorString) {
        return switch (candleColorString) {
            case "white" -> Blocks.WHITE_CANDLE;
            case "light_gray" -> Blocks.LIGHT_GRAY_CANDLE;
            case "gray" -> Blocks.GRAY_CANDLE;
            case "black" -> Blocks.BLACK_CANDLE;
            case "brown" -> Blocks.BROWN_CANDLE;
            case "red" -> Blocks.RED_CANDLE;
            case "orange" -> Blocks.ORANGE_CANDLE;
            case "yellow" -> Blocks.YELLOW_CANDLE;
            case "lime" -> Blocks.LIME_CANDLE;
            case "green" -> Blocks.GREEN_CANDLE;
            case "cyan" -> Blocks.CYAN_CANDLE;
            case "light_blue" -> Blocks.LIGHT_BLUE_CANDLE;
            case "blue" -> Blocks.BLUE_CANDLE;
            case "purple" -> Blocks.PURPLE_CANDLE;
            case "magenta" -> Blocks.MAGENTA_CANDLE;
            case "pink" -> Blocks.PINK_CANDLE;
            case "default" -> Blocks.CANDLE;
            default -> Blocks.CANDLE;
        };
    }

    private static Block getHardenedConcrete(String hardenedConcreteString) {
        return switch (hardenedConcreteString) {
            case "white" -> Blocks.WHITE_CONCRETE;
            case "light_gray" -> Blocks.LIGHT_GRAY_CONCRETE;
            case "gray" -> Blocks.GRAY_CONCRETE;
            case "black" -> Blocks.BLACK_CONCRETE;
            case "brown" -> Blocks.BROWN_CONCRETE;
            case "red" -> Blocks.RED_CONCRETE;
            case "orange" -> Blocks.ORANGE_CONCRETE;
            case "yellow" -> Blocks.YELLOW_CONCRETE;
            case "lime" -> Blocks.LIME_CONCRETE;
            case "green" -> Blocks.GREEN_CONCRETE;
            case "cyan" -> Blocks.CYAN_CONCRETE;
            case "light_blue" -> Blocks.LIGHT_BLUE_CONCRETE;
            case "blue" -> Blocks.BLUE_CONCRETE;
            case "purple" -> Blocks.PURPLE_CONCRETE;
            case "magenta" -> Blocks.MAGENTA_CONCRETE;
            case "pink" -> Blocks.PINK_CONCRETE;
            default -> Blocks.WHITE_CONCRETE;
        };
    }

    private static Block getDeadCoralBlock(String deadCoralBlockString) {
        return switch (deadCoralBlockString) {
            case "tube_coral" -> Blocks.DEAD_TUBE_CORAL_BLOCK;
            case "brain_coral" -> Blocks.DEAD_BRAIN_CORAL_BLOCK;
            case "bubble_coral" -> Blocks.DEAD_BUBBLE_CORAL_BLOCK;
            case "horn_coral" -> Blocks.DEAD_HORN_CORAL_BLOCK;
            default -> Blocks.DEAD_TUBE_CORAL_BLOCK;
        };
    }

    private static Block getDeadCoralFanBlock(String deadCoralFanBlockString) {
        return switch (deadCoralFanBlockString) {
            case "tube_coral_fan" -> Blocks.DEAD_TUBE_CORAL_FAN;
            case "brain_coral_fan" -> Blocks.DEAD_BRAIN_CORAL_FAN;
            case "bubble_coral_fan" -> Blocks.DEAD_BUBBLE_CORAL_FAN;
            case "horn_coral_fan" -> Blocks.DEAD_HORN_CORAL_FAN;
            default -> Blocks.DEAD_TUBE_CORAL_FAN;
        };
    }

    private static Block getDeadCoralWallFanBlock(String deadCoralWallFanBlockString) {
        return switch (deadCoralWallFanBlockString) {
            case "tube_coral_wall_fan" -> Blocks.DEAD_TUBE_CORAL_WALL_FAN;
            case "brain_coral_wall_fan" -> Blocks.DEAD_BRAIN_CORAL_WALL_FAN;
            case "bubble_coral_wall_fan" -> Blocks.DEAD_BUBBLE_CORAL_WALL_FAN;
            case "horn_coral_wall_fan" -> Blocks.DEAD_HORN_CORAL_WALL_FAN;
            default -> Blocks.DEAD_TUBE_CORAL_WALL_FAN;
        };
    }

    private static PressurePlateBlock.ActivationRule setPressurePlateActivation(String pressurePlateActivationString) {
        PressurePlateBlock.ActivationRule pressurePlateBehavior = PressurePlateBlock.ActivationRule.valueOf(pressurePlateActivationString);
        pressurePlateBehavior = switch (pressurePlateActivationString) {
            case "everything" -> pressurePlateBehavior.EVERYTHING;
            case "mobs" -> pressurePlateBehavior.MOBS;
            default -> pressurePlateBehavior;
        };
        return pressurePlateBehavior;
    }

    private static Block getContentFromString(String flowerTypeString) {
        return switch (flowerTypeString) {
            case "dandelion" -> Blocks.DANDELION;
            case "poppy" -> Blocks.POPPY;
            case "blue_orchid" -> Blocks.BLUE_ORCHID;
            case "allium" -> Blocks.ALLIUM;
            case "azure_bluet" -> Blocks.AZURE_BLUET;
            case "red_tulip" -> Blocks.RED_TULIP;
            case "orange_tulip" -> Blocks.ORANGE_TULIP;
            case "white_tulip" -> Blocks.WHITE_TULIP;
            case "pink_tulip" -> Blocks.PINK_TULIP;
            case "oxeye_daisy" -> Blocks.OXEYE_DAISY;
            case "cornflower" -> Blocks.CORNFLOWER;
            case "lily_of_the_valley" -> Blocks.LILY_OF_THE_VALLEY;
            case "wither_rose" -> Blocks.WITHER_ROSE;
            default -> Blocks.POPPY;
        };
    }

    private static WoodType getWoodTypeFromString(String woodTypeString) {
        return switch (woodTypeString) {
            case "acacia" -> WoodType.ACACIA;
            case "birch" -> WoodType.BIRCH;
            case "dark_oak" -> WoodType.DARK_OAK;
            case "jungle" -> WoodType.JUNGLE;
            case "spruce" -> WoodType.SPRUCE;
            case "crimson" -> WoodType.CRIMSON;
            case "warped" -> WoodType.WARPED;
            case "mangrove" -> WoodType.MANGROVE;
            default -> WoodType.OAK;
        };
    }

    private static BlockSetType getBlockSetTypeFromString(String blockSetTypeString) {
        return switch (blockSetTypeString) {
            case "acacia" -> BlockSetType.ACACIA;
            case "birch" -> BlockSetType.BIRCH;
            case "dark_oak" -> BlockSetType.DARK_OAK;
            case "jungle" -> BlockSetType.JUNGLE;
            case "spruce" -> BlockSetType.SPRUCE;
            case "crimson" -> BlockSetType.CRIMSON;
            case "warped" -> BlockSetType.WARPED;
            case "mangrove" -> BlockSetType.MANGROVE;
            default -> BlockSetType.OAK;
        };
    }
}
