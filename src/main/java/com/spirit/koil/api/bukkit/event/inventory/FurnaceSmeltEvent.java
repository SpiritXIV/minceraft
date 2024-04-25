package com.spirit.koil.api.bukkit.event.inventory;

import com.spirit.koil.api.bukkit.block.Block;
import com.spirit.koil.api.bukkit.event.block.BlockCookEvent;
import com.spirit.koil.api.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Called when an ItemStack is successfully smelted in a furnace.
 */
public class FurnaceSmeltEvent extends BlockCookEvent {

    public FurnaceSmeltEvent(@NotNull final Block furnace, @NotNull final ItemStack source, @NotNull final ItemStack result) {
        super(furnace, source, result);
    }
}
