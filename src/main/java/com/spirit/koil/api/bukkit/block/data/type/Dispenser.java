package com.spirit.koil.api.bukkit.block.data.type;

import com.spirit.koil.api.bukkit.block.data.Directional;
import com.spirit.koil.api.bukkit.block.data.Powerable;

/**
 * Similar to {@link Powerable}, 'triggered' indicates whether or not the
 * dispenser is currently activated.
 */
public interface Dispenser extends Directional {

    /**
     * Gets the value of the 'triggered' property.
     *
     * @return the 'triggered' value
     */
    boolean isTriggered();

    /**
     * Sets the value of the 'triggered' property.
     *
     * @param triggered the new 'triggered' value
     */
    void setTriggered(boolean triggered);
}
