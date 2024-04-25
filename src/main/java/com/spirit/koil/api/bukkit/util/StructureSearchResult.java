package com.spirit.koil.api.bukkit.util;

import com.spirit.koil.api.bukkit.Location;
import com.spirit.koil.api.bukkit.World;
import com.spirit.koil.api.bukkit.generator.structure.Structure;
import org.jetbrains.annotations.NotNull;

/**
 * Holds the result of searching for a structure.
 *
 * @see World#locateNearestStructure(Location, Structure, int, boolean)
 */
public interface StructureSearchResult {

    /**
     * Return the structure which was found.
     *
     * @return the found structure.
     */
    @NotNull
    Structure getStructure();

    /**
     * Return the location of the structure.
     *
     * @return the location the structure was found.
     */
    @NotNull
    Location getLocation();
}
