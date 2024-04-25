package com.spirit.koil.api.bukkit.entity.minecart;

import com.spirit.koil.api.bukkit.Material;
import com.spirit.koil.api.bukkit.entity.Minecart;

/**
 * Represents a powered minecart. A powered minecart moves on its own when a
 * player deposits {@link Material#COAL fuel}.
 */
public interface PoweredMinecart extends Minecart {

    /**
     * Get the number of ticks until the minecart runs out of fuel.
     *
     * @return Number of ticks until the minecart runs out of fuel
     */
    public int getFuel();

    /**
     * Set the number of ticks until the minecart runs out of fuel.
     *
     * @param fuel Number of ticks until the minecart runs out of fuel
     */
    public void setFuel(int fuel);
}
