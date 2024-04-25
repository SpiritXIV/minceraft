package com.spirit.koil.api.bukkit.event.player;

import java.util.Set;
import com.spirit.koil.api.bukkit.Warning;
import com.spirit.koil.api.bukkit.entity.Player;
import com.spirit.koil.api.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Used to format chat for chat preview. If this event is used, then the result
 * of the corresponding {@link AsyncPlayerChatEvent} <b>must</b> be formatted in
 * the same way.
 *
 * @deprecated chat previews have been removed
 */
@Deprecated
@Warning(false)
public class AsyncPlayerChatPreviewEvent extends AsyncPlayerChatEvent {

    private static final HandlerList handlers = new HandlerList();

    public AsyncPlayerChatPreviewEvent(final boolean async, @NotNull final Player who, @NotNull final String message, @NotNull final Set<Player> players) {
        super(async, who, message, players);
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
