package com.spirit.koil.api.bukkit.event.block;

import com.spirit.koil.api.bukkit.GameEvent;
import com.spirit.koil.api.bukkit.block.Block;
import com.spirit.koil.api.bukkit.entity.Entity;
import com.spirit.koil.api.bukkit.event.Cancellable;
import com.spirit.koil.api.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called when a Sculk sensor receives a game event and hence might activate.
 *
 * Will be called cancelled if the block's default behavior is to ignore the
 * event.
 */
public class BlockReceiveGameEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final GameEvent event;
    private final Entity entity;
    private boolean cancelled;

    public BlockReceiveGameEvent(@NotNull GameEvent event, @NotNull Block block, @Nullable Entity entity) {
        super(block);
        this.event = event;
        this.entity = entity;
    }

    /**
     * Get the underlying event.
     *
     * @return the event
     */
    @NotNull
    public GameEvent getEvent() {
        return event;
    }

    /**
     * Get the entity which triggered this event, if present.
     *
     * @return triggering entity or null
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
