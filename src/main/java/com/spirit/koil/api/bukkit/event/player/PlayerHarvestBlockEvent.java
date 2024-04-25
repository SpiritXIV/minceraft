package com.spirit.koil.api.bukkit.event.player;

import com.spirit.koil.api.bukkit.block.Block;
import com.spirit.koil.api.bukkit.entity.Player;
import com.spirit.koil.api.bukkit.event.Cancellable;
import com.spirit.koil.api.bukkit.event.HandlerList;
import com.spirit.koil.api.bukkit.inventory.EquipmentSlot;
import com.spirit.koil.api.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * This event is called whenever a player harvests a block.
 * <br>
 * A 'harvest' is when a block drops an item (usually some sort of crop) and
 * changes state, but is not broken in order to drop the item.
 * <br>
 * This event is not called for when a block is broken, to handle that, listen
 * for {@link com.spirit.koil.api.bukkit.event.block.BlockBreakEvent} and
 * {@link com.spirit.koil.api.bukkit.event.block.BlockDropItemEvent}.
 */
public class PlayerHarvestBlockEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final Block harvestedBlock;
    private final EquipmentSlot hand;
    private final List<ItemStack> itemsHarvested;

    public PlayerHarvestBlockEvent(@NotNull Player player, @NotNull Block harvestedBlock, @NotNull EquipmentSlot hand, @NotNull List<ItemStack> itemsHarvested) {
        super(player);
        this.harvestedBlock = harvestedBlock;
        this.hand = hand;
        this.itemsHarvested = itemsHarvested;
    }

    @Deprecated
    public PlayerHarvestBlockEvent(@NotNull Player player, @NotNull Block harvestedBlock, @NotNull List<ItemStack> itemsHarvested) {
        this(player, harvestedBlock, EquipmentSlot.HAND, itemsHarvested);
    }

    /**
     * Gets the block that is being harvested.
     *
     * @return The block that is being harvested
     */
    @NotNull
    public Block getHarvestedBlock() {
        return harvestedBlock;
    }

    /**
     * Get the hand used to harvest the block.
     *
     * @return the hand
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
    }

    /**
     * Gets a list of items that are being harvested from this block.
     *
     * @return A list of items that are being harvested from this block
     */
    @NotNull
    public List<ItemStack> getItemsHarvested() {
        return itemsHarvested;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
