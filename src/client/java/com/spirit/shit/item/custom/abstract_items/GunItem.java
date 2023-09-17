package com.spirit.shit.item.custom.abstract_items;

import com.spirit.shit.entity.custom.projectile.BulletProjectileEntity;
import com.spirit.shit.item.ShitItems;
import com.spirit.shit.sound.ShitSounds;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.inventory.StackReference;
import net.minecraft.screen.slot.Slot;
import net.minecraft.client.item.BundleTooltipData;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.nbt.NbtElement;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.function.Predicate;

public abstract class GunItem extends RangedWeaponItem implements Vanishable {
    private long lastFireTick = 0; // Added this line

    private static final String ITEMS_KEY = "Items";
    private static final int DEFAULT_ITEM_BAR_COLOR = 0xFF0000; // RGB value for red
    private static final int RANGE = 100;
    protected final int MAGAZINE_SIZE;
    protected final int ITEM_BAR_COLOR;

    // Defining sounds.
    public enum SoundType {
       SHOOT,
       RELOAD,
       EMPTY
    }
    private final SoundEvent SHOOT_SOUND = ShitSounds.PISTOL_SHOOT;
    private final SoundEvent RELOAD_SOUND = ShitSounds.PISTOL_SHOOT; // Implement
    private final SoundEvent EMPTY_SOUND = ShitSounds.PISTOL_SHOOT; // Implement

    // Constructor with mandatory magazineSize parameter and optional itemBarColor parameter
    public GunItem(Settings settings, int magazineSize) {
        this(settings, magazineSize, DEFAULT_ITEM_BAR_COLOR);
    }
    public GunItem(Settings settings, int magazineSize, int itemBarColor) {
        super(settings);
        this.MAGAZINE_SIZE = magazineSize;
        this.ITEM_BAR_COLOR = itemBarColor;
    }
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        // This method is called when the player left-clicks on an entity.
        return handleLeftClick(stack, user, entity.getWorld());
    }
    public ActionResult handleLeftClick(ItemStack itemStack, PlayerEntity user, World world) {
        System.out.println("Shooting!");
        return this.shoot(itemStack, user, world);

    }
    private ActionResult shoot(ItemStack gun, PlayerEntity user, World world) {
        long currentTick = world.getTime(); // Current server tick
        // Added this line, assuming 1-second cooldown
        long cooldownTicks = 20;
        if (currentTick - lastFireTick < cooldownTicks) {
            return ActionResult.PASS;
        }

        lastFireTick = currentTick; // Update last fire tick

        System.out.println("At Function!");
        NbtCompound gunNBT = gun.getOrCreateNbt();
        boolean hasAmmunition = this.hasAmmo(gunNBT),
                usesAmmunition = this.doesUseAmmo(user);

        System.out.println("Validating!");
        if (usesAmmunition && !hasAmmunition)
            return ActionResult.FAIL;

        if (usesAmmunition)
            this.removeAmmo(gunNBT);
        System.out.println("Is Valid!");

        if (!world.isClient) {
            BulletProjectileEntity bullet = new BulletProjectileEntity(world, user);
            bullet.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 10.F, 0F);
            world.spawnEntity(bullet);
            System.out.println("Shot!");
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        this.playSound(world, user, SoundType.SHOOT);

        return ActionResult.SUCCESS;
    }

    private void removeAmmo(NbtCompound gunNBT) {
        NbtList slotList = gunNBT.getList(ITEMS_KEY, 10);
        for (int i = 0; i < slotList.size(); i++) {
            NbtCompound slotNBT = slotList.getCompound(i);
            ItemStack itemStack = ItemStack.fromNbt(slotNBT);
            if (itemStack.isOf(ShitItems.BULLET)) {
                if (itemStack.getCount() > 0) {
                    itemStack.decrement(1);
                    itemStack.writeNbt(slotNBT);  // Update the NBT data
                }
            }
        }
    }

    private boolean hasAmmo(NbtCompound gunNBT) {
        return gunNBT.contains(ITEMS_KEY);
    }
    private boolean doesUseAmmo(PlayerEntity player) {
        return !player.isCreative();
    }
    private void playSound(World world, PlayerEntity player, SoundType type) {
        SoundEvent sound;
        switch (type) {
            case SHOOT -> sound = SHOOT_SOUND;
            case RELOAD -> sound = RELOAD_SOUND;
            case EMPTY -> sound = EMPTY_SOUND;
            default -> {
                throw new IllegalArgumentException("Invalid sound type specified: " + type);
            }
        }
        world.playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundCategory.NEUTRAL, 1F, 1F);
    }


    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT) {
            return false;
        } else {
            ItemStack itemStack = slot.getStack();
            if (itemStack.isEmpty()) {
                this.playRemoveOneSound(player);
                removeFirstStack(stack).ifPresent((removedStack) -> {
                    addToBundle(stack, slot.insertStack(removedStack));
                });
            } else if (itemStack.isOf(ShitItems.BULLET)) {  // Changed this line
                if (getBundleOccupancy(stack) >= MAGAZINE_SIZE) {
                    return false;  // Do nothing if the magazine is full
                }
                int itemOccupancy = getItemOccupancy(itemStack);
                if (itemOccupancy == 0) {
                    return false;  // If occupancy is zero, return false
                }
                int i = (MAGAZINE_SIZE - getBundleOccupancy(stack)) / itemOccupancy;
                int j = addToBundle(stack, slot.takeStackRange(itemStack.getCount(), i, player));
                if (j > 0) {
                    this.playInsertSound(player);
                }
            } else {
                return false;  // If item is not a bullet, return false
            }

            return true;
        }
    }

    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
            if (otherStack.isEmpty()) {
                removeFirstStack(stack).ifPresent((itemStack) -> {
                    this.playRemoveOneSound(player);
                    cursorStackReference.set(itemStack);
                });
            } else {
                if (getBundleOccupancy(stack) >= MAGAZINE_SIZE) {
                    return false;  // Do nothing if the magazine is full
                }
                int i = addToBundle(stack, otherStack);
                if (i > 0) {
                    this.playInsertSound(player);
                    otherStack.decrement(i);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean isItemBarVisible(ItemStack stack) {
        return getBundleOccupancy(stack) > 0;
    }

    public int getItemBarStep(ItemStack stack) {
        return Math.min(1 + 12 * getBundleOccupancy(stack) / MAGAZINE_SIZE, 13);
    }

    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }
    private int addToBundle(ItemStack bundle, ItemStack stack) {
        if (!stack.isEmpty() && stack.isOf(ShitItems.BULLET)) {
            NbtCompound nbtCompound = bundle.getOrCreateNbt();
            if (!nbtCompound.contains(ITEMS_KEY)) {
                nbtCompound.put(ITEMS_KEY, new NbtList());
            }

            int i = getBundleOccupancy(bundle); // Check the current number of bullets

            // Check if the bundle is already full
            if (i >= MAGAZINE_SIZE) {
                return 0;
            }

            // Calculate how many more bullets can be added
            int j = Math.min(stack.getCount(), MAGAZINE_SIZE - i);
            if (j == 0) {
                return 0;
            } else {
                NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
                Optional<NbtCompound> optional = canMergeStack(stack, nbtList);
                if (optional.isPresent()) {
                    NbtCompound nbtCompound2 = optional.get();
                    ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                    itemStack.increment(j);
                    itemStack.writeNbt(nbtCompound2);
                    nbtList.remove(nbtCompound2);
                    nbtList.add(0, nbtCompound2);
                } else {
                    ItemStack itemStack2 = stack.copyWithCount(j);
                    NbtCompound nbtCompound3 = new NbtCompound();
                    itemStack2.writeNbt(nbtCompound3);
                    nbtList.add(0, nbtCompound3);
                }
                return j;
            }
        } else {
            return 0;
        }
    }

    private static Optional<NbtCompound> canMergeStack(ItemStack stack, NbtList items) {
        if (stack.isOf(Items.BUNDLE)) {
            return Optional.empty();
        } else {
            Stream<NbtElement> var10000 = items.stream();
            Objects.requireNonNull(NbtCompound.class);
            var10000 = var10000.filter(NbtCompound.class::isInstance);
            Objects.requireNonNull(NbtCompound.class);
            return var10000.map(NbtCompound.class::cast).filter((item) -> {
                return ItemStack.canCombine(ItemStack.fromNbt(item), stack);
            }).findFirst();
        }
    }

    private int getItemOccupancy(ItemStack stack) {
        if (stack.isOf(Items.BUNDLE)) {
            return 4 + getBundleOccupancy(stack);
        } else {
            if ((stack.isOf(ShitItems.BULLET)) && stack.hasNbt()) {
                NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
                if (nbtCompound != null) {
                    return MAGAZINE_SIZE;
                }
            }
            if (stack.getMaxCount() == 0) {
                return 0;  // Return zero if getMaxCount is zero
            }
            return 1 / stack.getMaxCount();
        }
    }

    private int getBundleOccupancy(ItemStack stack) {
        return getBulletStacks(stack).mapToInt((itemStack) -> {
            return getItemOccupancy(itemStack) * itemStack.getCount();
        }).sum();
    }

    private static Optional<ItemStack> removeFirstStack(ItemStack stack) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        if (!nbtCompound.contains(ITEMS_KEY)) {
            return Optional.empty();
        } else {
            NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
            if (nbtList.isEmpty()) {
                return Optional.empty();
            } else {
                boolean i = false;
                NbtCompound nbtCompound2 = nbtList.getCompound(0);
                ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                nbtList.remove(0);
                if (nbtList.isEmpty()) {
                    stack.removeSubNbt(ITEMS_KEY);
                }

                return Optional.of(itemStack);
            }
        }
    }



    private static Stream<ItemStack> getBulletStacks(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound == null) {
            return Stream.empty();
        } else {
            NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
            return nbtList.stream()
                    .map(NbtCompound.class::cast)
                    .map(ItemStack::fromNbt)
                    .filter(itemStack -> itemStack.isOf(ShitItems.BULLET));
        }
    }

    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.of();
        Stream<ItemStack> var10000 = getBulletStacks(stack);
        Objects.requireNonNull(defaultedList);
        var10000.forEach(defaultedList::add);
        return Optional.of(new BundleTooltipData(defaultedList, getBundleOccupancy(stack)));
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.gun.mag.fullness", new Object[]{getBundleOccupancy(stack), MAGAZINE_SIZE}).formatted(Formatting.GRAY));
    }

    public void onItemEntityDestroyed(ItemEntity entity) {
        ItemUsage.spawnItemContents(entity, getBulletStacks(entity.getStack()));
    }

    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_REMOVE_ONE, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playDropContentsSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_DROP_CONTENTS, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }
    public Predicate<ItemStack> getProjectiles() {
        return (Predicate<ItemStack>) ShitItems.BULLET;
    }
    public int getRange() {
        return RANGE;
    }
}