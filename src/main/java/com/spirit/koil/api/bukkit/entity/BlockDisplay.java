package com.spirit.koil.api.bukkit.entity;

import com.spirit.koil.api.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a block display entity.
 */
public interface BlockDisplay extends Display {

    /**
     * Gets the displayed block.
     *
     * @return the displayed block
     */
    @NotNull
    public BlockData getBlock();

    /**
     * Sets the displayed block.
     *
     * @param block the new block
     */
    public void setBlock(@NotNull BlockData block);
}
