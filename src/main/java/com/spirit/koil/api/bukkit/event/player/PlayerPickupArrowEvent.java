package com.spirit.koil.api.bukkit.event.player;

import com.spirit.koil.api.bukkit.entity.AbstractArrow;
import com.spirit.koil.api.bukkit.entity.Item;
import com.spirit.koil.api.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Thrown when a player picks up an arrow from the ground.
 */
public class PlayerPickupArrowEvent extends PlayerPickupItemEvent {

    private final AbstractArrow arrow;

    public PlayerPickupArrowEvent(@NotNull final Player player, @NotNull final Item item, @NotNull final AbstractArrow arrow) {
        super(player, item, 0);
        this.arrow = arrow;
    }

    /**
     * Get the arrow being picked up by the player
     *
     * @return The arrow being picked up
     */
    @NotNull
    public AbstractArrow getArrow() {
        return arrow;
    }
}
