package com.spirit.koil.api.bukkit.event.entity;

import com.spirit.koil.api.bukkit.entity.LivingEntity;
import com.spirit.koil.api.bukkit.event.Cancellable;
import com.spirit.koil.api.bukkit.event.HandlerList;
import com.spirit.koil.api.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called when an entity dies and may have the opportunity to be resurrected.
 * Will be called in a cancelled state if the entity does not have a totem
 * equipped.
 */
public class EntityResurrectEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    //
    private boolean cancelled;

    private final EquipmentSlot hand;

    public EntityResurrectEvent(@NotNull LivingEntity what, @Nullable EquipmentSlot hand) {
        super(what);
        this.hand = hand;
    }

    @Deprecated
    public EntityResurrectEvent(@NotNull LivingEntity what) {
        this(what, null);
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * Get the hand in which the totem of undying was found, or null if the
     * entity did not have a totem of undying.
     *
     * @return the hand, or null
     */
    @Nullable
    public EquipmentSlot getHand() {
        return hand;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
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
