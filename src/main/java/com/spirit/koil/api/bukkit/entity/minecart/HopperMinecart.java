package com.spirit.koil.api.bukkit.entity.minecart;

import com.spirit.koil.api.bukkit.entity.Minecart;
import com.spirit.koil.api.bukkit.inventory.InventoryHolder;
import com.spirit.koil.api.bukkit.loot.Lootable;

/**
 * Represents a Minecart with a Hopper inside it
 */
public interface HopperMinecart extends Minecart, InventoryHolder, Lootable {

    /**
     * Checks whether or not this Minecart will pick up
     * items into its inventory.
     *
     * @return true if the Minecart will pick up items
     */
    boolean isEnabled();

    /**
     * Sets whether this Minecart will pick up items.
     *
     * @param enabled new enabled state
     */
    void setEnabled(boolean enabled);
}
