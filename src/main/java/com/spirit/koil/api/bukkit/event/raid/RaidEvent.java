package com.spirit.koil.api.bukkit.event.raid;

import com.spirit.koil.api.bukkit.Raid;
import com.spirit.koil.api.bukkit.World;
import com.spirit.koil.api.bukkit.event.world.WorldEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Represents events related to raids.
 */
public abstract class RaidEvent extends WorldEvent {

    private final Raid raid;

    protected RaidEvent(@NotNull Raid raid, @NotNull World world) {
        super(world);
        this.raid = raid;
    }

    /**
     * Returns the raid involved with this event.
     *
     * @return Raid
     */
    @NotNull
    public Raid getRaid() {
        return raid;
    }
}
