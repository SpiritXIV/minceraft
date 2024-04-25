package com.spirit.koil.api.bukkit.event.world;

import com.spirit.koil.api.bukkit.World;
import com.spirit.koil.api.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * Represents events within a world
 */
public abstract class WorldEvent extends Event {
    private final World world;

    public WorldEvent(@NotNull final World world) {
        this(world, false);
    }

    public WorldEvent(@NotNull World world, boolean isAsync) {
        super(isAsync);
        this.world = world;
    }

    /**
     * Gets the world primarily involved with this event
     *
     * @return World which caused this event
     */
    @NotNull
    public World getWorld() {
        return world;
    }
}
