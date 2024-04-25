package com.spirit.koil.api.bukkit.plugin;

import com.spirit.koil.api.bukkit.event.Event;
import com.spirit.koil.api.bukkit.event.EventException;
import com.spirit.koil.api.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

/**
 * Interface which defines the class for event call backs to plugins
 */
public interface EventExecutor {
    public void execute(@NotNull Listener listener, @NotNull Event event) throws EventException;
}
