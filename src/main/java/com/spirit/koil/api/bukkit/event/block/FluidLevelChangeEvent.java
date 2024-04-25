package com.spirit.koil.api.bukkit.event.block;

import com.google.common.base.Preconditions;
import com.spirit.koil.api.bukkit.block.Block;
import com.spirit.koil.api.bukkit.block.data.BlockData;
import com.spirit.koil.api.bukkit.event.Cancellable;
import com.spirit.koil.api.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when the fluid level of a block changes due to changes in adjacent
 * blocks.
 */
public class FluidLevelChangeEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    //
    private BlockData newData;

    public FluidLevelChangeEvent(@NotNull Block theBlock, @NotNull BlockData newData) {
        super(theBlock);
        this.newData = newData;
    }

    /**
     * Gets the new data of the changed block.
     *
     * @return new data
     */
    @NotNull
    public BlockData getNewData() {
        return newData;
    }

    /**
     * Sets the new data of the changed block. Must be of the same Material as
     * the old one.
     *
     * @param newData the new data
     */
    public void setNewData(@NotNull BlockData newData) {
        Preconditions.checkArgument(newData != null, "newData null");
        Preconditions.checkArgument(this.newData.getMaterial().equals(newData.getMaterial()), "Cannot change fluid type");

        this.newData = newData;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
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
