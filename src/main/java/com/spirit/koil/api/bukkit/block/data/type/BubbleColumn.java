package com.spirit.koil.api.bukkit.block.data.type;

import com.spirit.koil.api.bukkit.block.data.BlockData;

/**
 * 'drag' indicates whether a force will be applied on entities moving through
 * this block.
 */
public interface BubbleColumn extends BlockData {

    /**
     * Gets the value of the 'drag' property.
     *
     * @return the 'drag' value
     */
    boolean isDrag();

    /**
     * Sets the value of the 'drag' property.
     *
     * @param drag the new 'drag' value
     */
    void setDrag(boolean drag);

}
