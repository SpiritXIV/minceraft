package com.spirit.koil.api.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an ender dragon part
 */
public interface EnderDragonPart extends ComplexEntityPart, Damageable {
    @Override
    @NotNull
    public EnderDragon getParent();
}
