package com.spirit.koil.api.bukkit.material;

import com.spirit.koil.api.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;

/**
 * Indicates that a block can be attached to another block
 */
public interface Attachable extends Directional {

    /**
     * Gets the face that this block is attached on
     *
     * @return BlockFace attached to
     */
    @NotNull
    public BlockFace getAttachedFace();
}
