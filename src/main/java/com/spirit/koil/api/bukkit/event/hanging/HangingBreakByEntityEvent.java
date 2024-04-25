package com.spirit.koil.api.bukkit.event.hanging;

import com.spirit.koil.api.bukkit.entity.Entity;
import com.spirit.koil.api.bukkit.entity.Hanging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Triggered when a hanging entity is removed by an entity
 */
public class HangingBreakByEntityEvent extends HangingBreakEvent {
    private final Entity remover;

    public HangingBreakByEntityEvent(@NotNull final Hanging hanging, @Nullable final Entity remover) {
        this(hanging, remover, HangingBreakEvent.RemoveCause.ENTITY);
    }

    public HangingBreakByEntityEvent(@NotNull final Hanging hanging, @Nullable final Entity remover, @NotNull final HangingBreakEvent.RemoveCause cause) {
        super(hanging, cause);
        this.remover = remover;
    }

    /**
     * Gets the entity that removed the hanging entity.
     * May be null, for example when broken by an explosion.
     *
     * @return the entity that removed the hanging entity
     */
    @Nullable
    public Entity getRemover() {
        return remover;
    }
}
