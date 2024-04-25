package com.spirit.koil.api.bukkit.event.weather;

import com.spirit.koil.api.bukkit.World;
import com.spirit.koil.api.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a Weather-related event
 */
public abstract class WeatherEvent extends Event {
    protected World world;

    public WeatherEvent(@NotNull final World where) {
        world = where;
    }

    /**
     * Returns the World where this event is occurring
     *
     * @return World this event is occurring in
     */
    @NotNull
    public final World getWorld() {
        return world;
    }
}
