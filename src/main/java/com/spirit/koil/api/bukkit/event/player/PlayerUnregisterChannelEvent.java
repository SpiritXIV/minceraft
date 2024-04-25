package com.spirit.koil.api.bukkit.event.player;

import com.spirit.koil.api.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * This is called immediately after a player unregisters for a plugin channel.
 */
public class PlayerUnregisterChannelEvent extends PlayerChannelEvent {

    public PlayerUnregisterChannelEvent(@NotNull final Player player, @NotNull final String channel) {
        super(player, channel);
    }
}
