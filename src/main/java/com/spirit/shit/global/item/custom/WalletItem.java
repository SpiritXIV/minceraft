//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spirit.shit.global.item.custom;

import com.spirit.shit.global.item.ShitItems;
import net.minecraft.client.item.BundleTooltipData;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class WalletItem extends Item {
    private static final String ITEMS_KEY = "Items";
    private static final int ITEM_BAR_COLOR = MathHelper.packRgb(0.6F, 0.1F, 0.6F);
    public static int MAXVALUE = 100000;

    public WalletItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT) {
            return false;
        } else {
            ItemStack itemStack = slot.getStack();
            if (itemStack.isEmpty()) {
                this.playRemoveOneSound(player);
                removeFirstStack(stack).ifPresent((removedStack) -> addToBundle(stack, slot.insertStack(removedStack)));
            } else if (itemStack.getItem().canBeNested()) {
                int i = (MAXVALUE - getBundleOccupancy(stack)) / getItemOccupancy(itemStack);
                int j = addToBundle(stack, slot.takeStackRange(itemStack.getCount(), i, player));
                if (j > 0) {
                    this.playInsertSound(player);
                }
            }

            return true;
        }
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
            if (otherStack.isEmpty()) {
                removeFirstStack(stack).ifPresent((itemStack) -> {
                    this.playRemoveOneSound(player);
                    cursorStackReference.set(itemStack);
                });
            } else {
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

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (dropAllBundledItems(itemStack, user)) {
            this.playDropContentsSound(user);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }

    public boolean isItemBarVisible(ItemStack stack) {
        return getBundleOccupancy(stack) > 0;
    }

    public int getItemBarStep(ItemStack stack) {
        return Math.min(1 + 12 * getBundleOccupancy(stack) / MAXVALUE, 13);
    }

    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }

    private static int addToBundle(ItemStack bundle, ItemStack stack) {
        if (!stack.isEmpty() && stack.getItem().canBeNested()) {
            NbtCompound nbtCompound = bundle.getOrCreateNbt();
            if (!nbtCompound.contains(ITEMS_KEY)) {
                nbtCompound.put(ITEMS_KEY, new NbtList());
            }

            int i = getBundleOccupancy(bundle);
            int j = getItemOccupancy(stack);
            int k = Math.min(stack.getCount(), (MAXVALUE - i) / j);
            if (k == 0) {
                return 0;
            } else {
                NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
                Optional<NbtCompound> optional = canMergeStack(stack, nbtList);
                if (optional.isPresent()) {
                    NbtCompound nbtCompound2 = optional.get();
                    ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                    int currentCount = itemStack.getCount();
                    int totalCount = currentCount + k;
                    if (totalCount > 127) {
                        // If adding more would exceed 127, reject the addition
                        return 0;
                    } else {
                        itemStack.increment(k);
                        itemStack.writeNbt(nbtCompound2);
                    }
                } else {
                    if (getCountOfItem(stack.getItem(), nbtList) + k > 127) {
                        // If adding more would exceed 127, reject the addition
                        return 0;
                    } else {
                        ItemStack itemStack2 = stack.copyWithCount(k);
                        NbtCompound nbtCompound3 = new NbtCompound();
                        itemStack2.writeNbt(nbtCompound3);
                        nbtList.add(0, nbtCompound3);
                    }
                }
                return k;
            }
        } else {
            return 0;
        }
    }

    private static int getCountOfItem(Item item, NbtList items) {
        return items.stream()
                .map(NbtCompound.class::cast)
                .map(ItemStack::fromNbt)
                .filter(stack -> stack.getItem() == item)
                .mapToInt(ItemStack::getCount)
                .sum();
    }


    private static Optional<NbtCompound> canMergeStack(ItemStack stack, NbtList items) {
        if (stack.isOf(Items.BUNDLE)) {
            return Optional.empty();
        } else {
            Stream<NbtElement> var10000 = items.stream();
            var10000 = var10000.filter(NbtCompound.class::isInstance);
            return var10000.map(NbtCompound.class::cast)
                    .filter((NbtCompound item) -> ItemStack.canCombine(ItemStack.fromNbt(item), stack))
                    .findFirst();
        }
    }


    private static int getItemOccupancy(ItemStack stack) {
        if (stack.isOf(Items.BUNDLE)) {
            return 4 + getBundleOccupancy(stack);
        } else {
            if (!stack.isEmpty() && stack.isOf(ShitItems.ONE_MOMEN) || stack.isOf(ShitItems.FIVE_MOMEN) || stack.isOf(ShitItems.TEN_MOMEN) || stack.isOf(ShitItems.TWENTY_MOMEN) || stack.isOf(ShitItems.FIFTY_MOMEN) || stack.isOf(ShitItems.ONEHUNDRED_MOMEN) || stack.isOf(ShitItems.FIVEHUNDRED_MOMEN)) {
                return stack.getCount();
            } else {
                return 0;
            }
        }
    }


    private static int getBundleOccupancy(ItemStack stack) {
        return getBundledStacks(stack)
                .mapToInt(WalletItem::getItemValue)
                .sum();
    }


    private static int getItemValue(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        }

        Item item = stack.getItem();
        if (item == ShitItems.ONE_MOMEN) {
            return stack.getCount();
        } else if (item == ShitItems.FIVE_MOMEN) {
            return stack.getCount() * 5;
        } else if (item == ShitItems.TEN_MOMEN) {
            return stack.getCount() * 10;
        } else if (item == ShitItems.TWENTY_MOMEN) {
            return stack.getCount() * 20;
        } else if (item == ShitItems.FIFTY_MOMEN) {
            return stack.getCount() * 50;
        } else if (item == ShitItems.ONEHUNDRED_MOMEN) {
            return stack.getCount() * 100;
        } else if (item == ShitItems.FIVEHUNDRED_MOMEN) {
            return stack.getCount() * 500;
        }
        return 0;
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

    private static boolean dropAllBundledItems(ItemStack stack, PlayerEntity player) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        if (!nbtCompound.contains(ITEMS_KEY)) {
            return false;
        } else {
            if (player instanceof ServerPlayerEntity) {
                NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);

                for(int i = 0; i < nbtList.size(); ++i) {
                    NbtCompound nbtCompound2 = nbtList.getCompound(i);
                    ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                    player.dropItem(itemStack, true);
                }
            }

            stack.removeSubNbt(ITEMS_KEY);
            return true;
        }
    }

    private static Stream<ItemStack> getBundledStacks(ItemStack stack) {
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
        Stream<ItemStack> var10000 = getBundledStacks(stack);
        Objects.requireNonNull(defaultedList);
        var10000.forEach(defaultedList::add);
        return Optional.of(new BundleTooltipData(defaultedList, getBundleOccupancy(stack)));
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        int totalValue = getBundleOccupancy(stack);
        tooltip.add(Text.translatable("item.shit.bundle.fullness", getBundleOccupancy(stack)).formatted(Formatting.GRAY));
    }

    public void onItemEntityDestroyed(ItemEntity entity) {
        ItemUsage.spawnItemContents(entity, getBundledStacks(entity.getStack()));
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
}
