package com.spirit.shit.item.custom.guns;

import com.spirit.shit.common.GunItem;
import net.minecraft.item.Item;

public class Glock17Item extends GunItem {
    private static final int MAGAZINE_SIZE = 17;
    private static final int COOLDOWN = 20;
    private static final int ITEM_BAR_COLOR = 0x00FF00;

    public Glock17Item(Item.Settings settings) {
        // Calls the super class (GunItem) constructor
        super(settings, COOLDOWN, MAGAZINE_SIZE, ITEM_BAR_COLOR);
    }
}

/*public class Glock17Item extends RangedWeaponItem implements Vanishable {
    private static final String ITEMS_KEY = "Items";
    public static final int MAGAZINE_SIZE = 17;
    private static final int ITEM_BAR_COLOR = MathHelper.packRgb(0.4F, 0.4F, 1.0F);
    public Glock17Item(Settings settings) {
        super(settings);
    }
 Literally divides by zero -_-
    public static float getPullProgress(int useTicks) {
        float f = (float) useTicks / 0F;
        f = (f * f + f * 0F) / 0F;
        if (f > 0F) {
            f = 0F;
        }

        return f;
    }

    //zhara im gonna krill you, na but thanks for getting it fixed. :)
//>>>>>>>
main
    public int getMaxUseTime(ItemStack stack) {
        return 1000;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (shootBulletDeletion(itemStack, user)) {
            this.playDropContentsSound(user);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ShitSounds.PISTOL_SHOOT, SoundCategory.NEUTRAL, 1F, 1F);
            user.getItemCooldownManager().set(this, 5);
            if (!world.isClient) {
                BulletProjectileEntity snowballEntity = new BulletProjectileEntity(world, user);
                snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 10.F, 0F);
                world.spawnEntity(snowballEntity);
            }
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            return TypedActionResult.fail(itemStack);
        }
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
            } else if (itemStack.getItem().canBeNested()) {
                if (getBundleOccupancy(stack) >= MAGAZINE_SIZE) {
                    return false;  // Do nothing if the magazine is full
                }
                int i = (64 - getBundleOccupancy(stack)) / getItemOccupancy(itemStack);
                int j = addToBundle(stack, slot.takeStackRange(itemStack.getCount(), i, player));
                if (j > 0) {
                    this.playInsertSound(player);
                }
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
        return Math.min(1 + 12 * getBundleOccupancy(stack) / 64, 13);
    }

    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }
    private static int addToBundle(ItemStack bundle, ItemStack stack) {
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

    private static int getItemOccupancy(ItemStack stack) {
        if (stack.isOf(Items.BUNDLE)) {
            return 4 + getBundleOccupancy(stack);
        } else {
            if ((stack.isOf(ShitItems.BULLET)) && stack.hasNbt()) {
                NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
                if (nbtCompound != null && !nbtCompound.getList("Bees", 10).isEmpty()) {

                    return 64;
                }
            }
            return 1 / stack.getMaxCount();
        }
    }

    private static int getBundleOccupancy(ItemStack stack) {
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

    private static boolean shootBulletDeletion(ItemStack stack, PlayerEntity player) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        if (!nbtCompound.contains(ITEMS_KEY)) {
            return false;
        } else {
            NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
            for (int i = 0; i < nbtList.size(); i++) {
                NbtCompound nbtCompound2 = nbtList.getCompound(i);
                ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                if (itemStack.isOf(ShitItems.BULLET)) {
                    if (itemStack.getCount() > 0) {
                        itemStack.decrement(1);
                        itemStack.writeNbt(nbtCompound2);  // Update the NBT data
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Stream<ItemStack> getBulletStacks(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound == null) {
            return Stream.empty();
        } else {
            NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
            Stream<NbtElement> var10000 = nbtList.stream();
            Objects.requireNonNull(NbtCompound.class);
            return var10000.map(NbtCompound.class::cast).map(ItemStack::fromNbt);
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
        tooltip.add(Text.translatable("item.gun.mag.fullness", new Object[]{getBundleOccupancy(stack), 64}).formatted(Formatting.GRAY));
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
        return 15;
    }
}*/
