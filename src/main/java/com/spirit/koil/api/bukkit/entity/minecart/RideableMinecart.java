package com.spirit.koil.api.bukkit.entity.minecart;

import com.spirit.koil.api.bukkit.entity.Entity;
import com.spirit.koil.api.bukkit.entity.IronGolem;
import com.spirit.koil.api.bukkit.entity.LivingEntity;
import com.spirit.koil.api.bukkit.entity.Minecart;

/**
 * Represents a minecart that can have certain {@link
 * Entity entities} as passengers. Normal passengers
 * include all {@link LivingEntity living entities} with
 * the exception of {@link IronGolem iron golems}.
 * Non-player entities that meet normal passenger criteria automatically
 * mount these minecarts when close enough.
 */
public interface RideableMinecart extends Minecart {
}
