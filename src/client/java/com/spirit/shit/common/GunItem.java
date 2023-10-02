package com.spirit.shit.common;

import com.spirit.shit.item.ShitItems;
import com.spirit.shit.sound.ShitSounds;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtByte;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.*;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.inventory.StackReference;
import net.minecraft.screen.slot.Slot;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.nbt.NbtElement;
import net.minecraft.sound.SoundEvents;

import java.util.*;
import java.util.stream.Stream;
import java.util.function.Predicate;

public abstract class GunItem extends RangedWeaponItem implements Vanishable {
    private long lastFireTick = 0;
    private static final String ITEMS_KEY = "Items";
    private static final int DEFAULT_ITEM_BAR_COLOR = 0xFF0000; // RGB value for red
    private static final int RANGE = 100;
    protected final int COOLDOWN;
    protected final int MAGAZINE_SIZE;
    protected final float BULLET_DAMAGE;
    protected final int ITEM_BAR_COLOR;
    private final Item[] ALLOWED_TYPES;
    // Defining sounds.
    public enum SoundType {
        SHOOT,
        RELOAD,
        EMPTY,
        REMOVE_ONE,
        INSERT,
        DROP_CONTENT
    }
    protected SoundEvent SHOOT_SOUND = ShitSounds.PISTOL_SHOOT;
    protected final SoundEvent RELOAD_SOUND = ShitSounds.PISTOL_SHOOT; // Implement
    protected final SoundEvent EMPTY_SOUND = ShitSounds.PISTOL_SHOOT; // Implement
    protected final SoundEvent REMOVE_BULLET_SOUND = SoundEvents.ITEM_BUNDLE_REMOVE_ONE;
    protected final SoundEvent INSERT_SOUND = SoundEvents.ITEM_BUNDLE_INSERT;
    protected final SoundEvent DROP_CONTENT_SOUND = SoundEvents.ITEM_BUNDLE_DROP_CONTENTS;
    private static final Random random = new Random();


    // Constructor with mandatory magazineSize parameter and optional itemBarColor parameter
    public GunItem(Settings settings, int magazineSize, int cooldown, float bulletDamage, Item[] allowedTypes) {
        this(settings, cooldown, magazineSize, DEFAULT_ITEM_BAR_COLOR, bulletDamage, allowedTypes);
    }

    public GunItem(Settings settings, int cooldown, int magazineSize, int itemBarColor, float bulletDamage, Item[] allowedTypes) {
        super(settings);
        this.COOLDOWN = cooldown;
        this.MAGAZINE_SIZE = magazineSize;
        this.ITEM_BAR_COLOR = itemBarColor;
        this.BULLET_DAMAGE = bulletDamage;  // Initialize BULLET_DAMAGE
        ALLOWED_TYPES = allowedTypes;
    }

    public void handleLeftClick(ItemStack itemStack, PlayerEntity user, World world) {
        this.shoot(itemStack, user, world);

    }
    private void shoot(ItemStack gun, PlayerEntity user, World world) {
        long currentTick = world.getTime();
        if (currentTick - lastFireTick < COOLDOWN) {
            return;
        }

        lastFireTick = currentTick; // Update last fire tick

        NbtCompound gunNBT = gun.getOrCreateNbt();
        boolean hasAmmunition = this.hasAmmo(gunNBT),
                usesAmmunition = this.doesUseAmmo(user);

        if (usesAmmunition && !hasAmmunition)
            return;

        ItemStack ammunition;

        // For creative players, get a random bullet without removing it
        if (!usesAmmunition) {
            ammunition = getRandomAmmo(gunNBT);
        } else {
            // For survival players, get a random bullet and remove it
            ammunition = removeAmmo(gunNBT);
        }

        // If ammo was successfully acquired, proceed to firing
        if (ammunition != null) {
            System.out.println(ammunition);
            System.out.println(ammunition.getItem());
            // Cast to GunProjectileItem and call fire method
            GunProjectileItem projectileItem = (GunProjectileItem) ammunition.getItem();
            projectileItem.fire(world, user, 1, ammunition, BULLET_DAMAGE);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        this.playSound(user, SoundType.SHOOT);
    }

    // Get a random ammo ItemStack without removing it
    private ItemStack getRandomAmmo(NbtCompound gunNBT) {
        NbtList gunInventory = gunNBT.getList(ITEMS_KEY, 10);
        List<Integer> ammoIndices = getAmmoIndices(gunInventory);

        if (ammoIndices.isEmpty()) {
            return null;
        }

        int randomIndex = ammoIndices.get(random.nextInt(ammoIndices.size()));
        NbtCompound randomSlotNBT = gunInventory.getCompound(randomIndex);
        ItemStack randomBulletStack = ItemStack.fromNbt(randomSlotNBT);

        // Create a new ItemStack with a count of 1 to return
        ItemStack returnBulletStack = randomBulletStack.copy();
        returnBulletStack.setCount(1);

        return returnBulletStack;
    }

    // Remove ammo and get ItemStack
    private ItemStack removeAmmo(NbtCompound gunNBT) {
        NbtList gunInventory = gunNBT.getList(ITEMS_KEY, 10);
        List<Integer> ammoIndices = getAmmoIndices(gunInventory);

        if (ammoIndices.isEmpty()) {
            return null;
        }

        int randomIndex = ammoIndices.get(random.nextInt(ammoIndices.size()));
        NbtCompound randomSlotNBT = gunInventory.getCompound(randomIndex);
        ItemStack randomBulletStack = ItemStack.fromNbt(randomSlotNBT);

        // Remove one bullet from the stack
        randomBulletStack.decrement(1);

        // Update the NBT data
        randomBulletStack.writeNbt(randomSlotNBT);

        // Create a new ItemStack with a count of 1 to return
        ItemStack returnBulletStack = randomBulletStack.copy();
        returnBulletStack.setCount(1);

        return returnBulletStack;
    }

    // Helper method to get ammo indices
    private List<Integer> getAmmoIndices(NbtList gunInventory) {
        List<Integer> ammoIndices = new ArrayList<>();

        for (int i = 0; i < gunInventory.size(); i++) {
            NbtCompound slotNBT = gunInventory.getCompound(i);
            ItemStack bulletStack = ItemStack.fromNbt(slotNBT);
            if (bulletStack.getCount() > 0) {
                ammoIndices.add(i);
            }
        }
        return ammoIndices;
    }

    private boolean hasAmmo(NbtCompound gunNBT) {
        return gunNBT.contains(ITEMS_KEY);
    }

    private boolean doesUseAmmo(PlayerEntity player) {
        return !player.isCreative();
    }

    private void playSound(PlayerEntity player, SoundType type) {
        SoundEvent sound = null;
        switch (type) {
            case SHOOT -> sound = SHOOT_SOUND;
            case RELOAD -> sound = RELOAD_SOUND;
            case EMPTY -> sound = EMPTY_SOUND;
            case REMOVE_ONE -> sound = REMOVE_BULLET_SOUND;
            case INSERT -> sound = INSERT_SOUND;
            case DROP_CONTENT -> sound = DROP_CONTENT_SOUND;
        }

        player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundCategory.NEUTRAL, 1F, 1F);
    }
    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        // Check if it's a right-click event
        if (clickType != ClickType.RIGHT)
            return false;

        // Validate if the clicked item is of an allowed type
        boolean isAllowedType = Arrays.stream(ALLOWED_TYPES).anyMatch(stack::isOf);
        if (!isAllowedType)
            return false;

        // Fetch the ItemStack from the slot, which should represent the gun
        ItemStack gun = slot.getStack();
        NbtCompound gunNbt = gun.getOrCreateNbt();
        if (!gunNbt.contains(ITEMS_KEY))
            gunNbt.put(ITEMS_KEY, new NbtList());

        NbtList gunInventory = gunNbt.getList(ITEMS_KEY, 10);

        // Check if the gun has enough space based on the MAGAZINE_SIZE
        int currentOccupancy = getBundleOccupancy(gun);
        if (currentOccupancy >= MAGAZINE_SIZE)
            return false;

        // Check if there is an identical ItemStack inside the gun
        Optional<NbtCompound> matchingSlotNbt = canMergeStack(stack, gunInventory);
        if (matchingSlotNbt.isPresent()) {
            NbtCompound slotNbt = matchingSlotNbt.get();
            ItemStack existingStack = ItemStack.fromNbt(slotNbt);
            existingStack.increment(stack.getCount());
            existingStack.writeNbt(slotNbt);
        } else {
            // If no matching ItemStack, append as a new slot in the gun
            ItemStack newStack = stack.copy();
            NbtCompound newSlotNbt = new NbtCompound();
            newStack.writeNbt(newSlotNbt);
            gunInventory.add(newSlotNbt);
        }

        return true;
    }


    public boolean onClicked(ItemStack gun, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
            if (otherStack.isEmpty()) {
                removeFirstStack(gun).ifPresent((itemStack) -> {
                    playSound(player, SoundType.REMOVE_ONE);
                    cursorStackReference.set(itemStack);
                });
            } else {
                if (getBundleOccupancy(gun) >= MAGAZINE_SIZE) {
                    return false;  // Do nothing if the magazine is full
                }

                int i = addToGunInventory(gun, otherStack);

                if (i > 0) {
                    playSound(player, SoundType.INSERT);
                    otherStack.decrement(i);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private int addToGunInventory(ItemStack gun, ItemStack item) {
        // Check if the item type is allowed
        boolean isAllowedType = Arrays.stream(ALLOWED_TYPES).anyMatch(item::isOf);
        System.out.println("a");
        if (!isAllowedType) {
            System.out.println("b");
            return 0;
        }

        System.out.println("c");
        if (!item.isEmpty()) {
            System.out.println("d");
            NbtCompound gunNbt = gun.getOrCreateNbt();
            if (!gunNbt.contains(ITEMS_KEY)) {
                System.out.println("e");
                gunNbt.put(ITEMS_KEY, new NbtList());
            }
            System.out.println("f");

            int currentOccupancy = getBundleOccupancy(gun); // Check the current number of bullets/items in the gun

            // Check if the gun is already full
            if (currentOccupancy >= MAGAZINE_SIZE) {
                System.out.println("g");
                return 0;
            }
            System.out.println("h");

            // Calculate how many more bullets/items can be added
            int availableSpace = MAGAZINE_SIZE - currentOccupancy;
            int itemOccupancy = getItemOccupancy(item);
            int itemsToAdd = Math.min(itemOccupancy, availableSpace);

            System.out.println(availableSpace);
            System.out.println(itemOccupancy);
            System.out.println(itemsToAdd);
            if (itemsToAdd == 0) {
                System.out.println("i");
                return 0;
            } else {
                System.out.println("j");
                NbtList gunInventory = gunNbt.getList(ITEMS_KEY, 10);
                Optional<NbtCompound> optional = canMergeStack(item, gunInventory);
                if (optional.isPresent()) {
                    System.out.println("k");
                    NbtCompound nbtCompound2 = optional.get();
                    ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                    itemStack.increment(itemsToAdd);
                    itemStack.writeNbt(nbtCompound2);
                } else {
                    System.out.println("l");
                    ItemStack itemStack2 = item.copyWithCount(itemsToAdd);
                    NbtCompound nbtCompound3 = new NbtCompound();
                    itemStack2.writeNbt(nbtCompound3);
                    gunInventory.add(nbtCompound3); // Add to the end if no existing item is found
                }
                System.out.println("m");
                return itemsToAdd;
            }
        } else {
            System.out.println("n");
            return 0;
        }
    }

    private static Optional<NbtCompound> canMergeStack(ItemStack stack, NbtList gunInventory) {
        Stream<NbtElement> var10000 = gunInventory.stream();
        Objects.requireNonNull(NbtCompound.class);
        var10000 = var10000.filter(NbtCompound.class::isInstance);
        Objects.requireNonNull(NbtCompound.class);
        return var10000.map(NbtCompound.class::cast).filter((item) -> ItemStack.canCombine(ItemStack.fromNbt(item), stack)).findFirst();
    }

    private int getItemOccupancy(ItemStack stack) {
        int occupancy = 0;
        Queue<ItemStack> toProcess = new LinkedList<>();
        toProcess.offer(stack);

        while (!toProcess.isEmpty()) {
            ItemStack currentStack = toProcess.poll();

            // Assume the currentStack itself should not be counted if it has contained items
            boolean shouldCountCurrentStack = true;

            // If this stack has NBT data, handle it specially
            if (currentStack.hasNbt()) {
                NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(currentStack);
                if (nbtCompound != null) {
                    // Enqueue the contained items for processing
                    NbtList containedItems = nbtCompound.getList("Items", 10);  // Assuming 10 is the tag type for a compound
                    for (int i = 0; i < containedItems.size(); i++) {
                        NbtCompound containedItem = containedItems.getCompound(i);
                        ItemStack containedStack = ItemStack.fromNbt(containedItem);
                        toProcess.offer(containedStack);
                    }
                    // Since this stack contains other items, we don't count it itself
                    shouldCountCurrentStack = false;
                }
            }

            // Add the count of the current stack to the total occupancy only if it should be counted
            if (shouldCountCurrentStack) {
                occupancy += currentStack.getCount();
            }
        }

        return occupancy;
    }

    private Optional<ItemStack> removeFirstStack(ItemStack stack) {
        NbtCompound gun = stack.getOrCreateNbt();
        if (!gun.contains(ITEMS_KEY)) {
            return Optional.empty();
        }
        NbtList bulletList = gun.getList(ITEMS_KEY, 10);
        if (bulletList.isEmpty()) {
            return Optional.empty();
        } else {
            NbtCompound bulletCompound = bulletList.getCompound(0);
            ItemStack bulletStack = ItemStack.fromNbt(bulletCompound);
            // Validate if the item type is allowed
            boolean isAllowedType = Arrays.stream(ALLOWED_TYPES).anyMatch(bulletStack::isOf);
            if (!isAllowedType) {
                return Optional.empty();
            }
            bulletList.remove(0);
            if (bulletList.isEmpty()) {
                stack.removeSubNbt(ITEMS_KEY);
            }
            return Optional.of(bulletStack);
        }
    }

    private Stream<ItemStack> getBulletStacks(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound == null) {
            return Stream.empty();
        } else {
            NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
            return nbtList.stream()
                    .map(NbtCompound.class::cast)
                    .map(ItemStack::fromNbt)
                    .filter(itemStack -> {
                        // Validate if the item type is allowed
                        return Arrays.stream(ALLOWED_TYPES).anyMatch(itemStack::isOf);
                    });
        }
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        // Display Capacity
        int totalLoaded = getBundleOccupancy(stack); // Assuming this is the current number of bullet in the magazine
        tooltip.add(Text.translatable("[ Capacity ]").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(totalLoaded + "/" + MAGAZINE_SIZE).formatted(Formatting.WHITE));

        // Display Loaded Bullets
        tooltip.add(Text.translatable("[ Loaded Bullets ]").formatted(Formatting.GRAY));

        List<ItemStack> bulletStacks = getBulletStacks(stack).toList();

        // Limiting display to up to 5 bullet stacks
        for (int i = 0; i < Math.min(bulletStacks.size(), 5); i++) {
            ItemStack bulletStack = bulletStacks.get(i);
            MutableText bulletText = Text.translatable(bulletStack.getName().getString()).formatted(Formatting.WHITE);

            NbtCompound nbt = bulletStack.getNbt();
            if (nbt != null) {
                if (nbt.contains("Flags")) {
                    NbtList flags = nbt.getList("Flags", 1);  // Assuming 1 is the NBT type for BYTE

                    if (!flags.isEmpty() && ((NbtByte)flags.get(0)).byteValue() == 1) {
                        bulletText.append(Text.translatable(" I").formatted(Formatting.GOLD, Formatting.BOLD));
                    }
                    if (flags.size() > 1 && ((NbtByte)flags.get(1)).byteValue() == 1) {
                        bulletText.append(Text.translatable(" X").formatted(Formatting.DARK_RED, Formatting.BOLD));
                    }
                    if (flags.size() > 2 && ((NbtByte)flags.get(2)).byteValue() == 1) {
                        bulletText.append(Text.translatable(" E").formatted(Formatting.AQUA, Formatting.BOLD));
                    }
                }
            }

            // Append item size
            bulletText.append(" x" + bulletStack.getCount());

            tooltip.add(bulletText);
        }
    }

    private int getBundleOccupancy(ItemStack stack) {
        return getBulletStacks(stack).mapToInt(this::getItemOccupancy).sum();
    }

    public void onItemEntityDestroyed(ItemEntity entity) {
        ItemUsage.spawnItemContents(entity, getBulletStacks(entity.getStack()));
    }
    public Predicate<ItemStack> getProjectiles() {
        return itemStack -> itemStack.getItem().equals(ShitItems.BULLET);
    }
    public int getRange() {
        return RANGE;
    }

    public boolean isItemBarVisible(ItemStack stack) {
        return getBundleOccupancy(stack) > 0;
    }

    public int getItemBarStep(ItemStack stack) {
        return Math.min(1 + 12 * getBundleOccupancy(stack) / MAGAZINE_SIZE, 13);
    }

    //Sets the item to not be used as a mining tool
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return false;
    }

    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }
}