package com.spirit.koil.api.bukkit.util;

import com.spirit.koil.api.bukkit.Location;
import com.spirit.koil.api.bukkit.World;
import com.spirit.koil.api.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;

/**
 * Holds the result of searching for a biome.
 *
 * @see World#locateNearestBiome(Location, int, Biome...)
 * @see World#locateNearestBiome(Location, int, int, int, Biome...)
 */
public interface BiomeSearchResult {

    /**
     * Return the biome which was found.
     *
     * @return the found biome.
     */
    @NotNull
    Biome getBiome();

    /**
     * Return the location of the biome.
     *
     * @return the location the biome was found.
     */
    @NotNull
    Location getLocation();
}
