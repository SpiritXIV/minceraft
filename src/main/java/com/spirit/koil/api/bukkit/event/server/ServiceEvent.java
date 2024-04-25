package com.spirit.koil.api.bukkit.event.server;

import com.spirit.koil.api.bukkit.plugin.RegisteredServiceProvider;
import com.spirit.koil.api.bukkit.plugin.ServicesManager;
import org.jetbrains.annotations.NotNull;

/**
 * An event relating to a registered service. This is called in a {@link
 * ServicesManager}
 */
public abstract class ServiceEvent extends ServerEvent {
    private final RegisteredServiceProvider<?> provider;

    public ServiceEvent(@NotNull final RegisteredServiceProvider<?> provider) {
        this.provider = provider;
    }

    @NotNull
    public RegisteredServiceProvider<?> getProvider() {
        return provider;
    }
}
