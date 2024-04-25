package com.spirit.koil.api.bukkit.event.server;

import com.spirit.koil.api.bukkit.event.HandlerList;
import com.spirit.koil.api.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a plugin is disabled.
 */
public class PluginDisableEvent extends PluginEvent {
    private static final HandlerList handlers = new HandlerList();

    public PluginDisableEvent(@NotNull final Plugin plugin) {
        super(plugin);
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
