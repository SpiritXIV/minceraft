package com.spirit.koil.api.bukkit.entity.minecart;

import com.spirit.koil.api.bukkit.entity.Minecart;
import com.spirit.koil.api.bukkit.inventory.InventoryHolder;
import com.spirit.koil.api.bukkit.loot.Lootable;

/**
 * Represents a minecart with a chest. These types of {@link Minecart
 * minecarts} have their own inventory that can be accessed using methods
 * from the {@link InventoryHolder} interface.
 */
public interface StorageMinecart extends Minecart, InventoryHolder, Lootable {
}
