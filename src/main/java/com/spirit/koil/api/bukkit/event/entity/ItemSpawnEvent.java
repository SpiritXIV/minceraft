package com.spirit.koil.api.bukkit.event.entity;

import com.spirit.koil.api.bukkit.Location;
import com.spirit.koil.api.bukkit.entity.Item;
import org.jetbrains.annotations.NotNull;

/**
 * Called when an item is spawned into a world
 */
public class ItemSpawnEvent extends EntitySpawnEvent {

    @Deprecated
    public ItemSpawnEvent(@NotNull final Item spawnee, final Location loc) {
        this(spawnee);
    }

    public ItemSpawnEvent(@NotNull final Item spawnee) {
        super(spawnee);
    }

    @NotNull
    @Override
    public Item getEntity() {
        return (Item) entity;
    }
}
