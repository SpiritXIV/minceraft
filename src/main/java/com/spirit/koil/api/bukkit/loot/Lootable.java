package com.spirit.koil.api.bukkit.loot;

import com.spirit.koil.api.bukkit.block.Container;
import com.spirit.koil.api.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a {@link Container} or a
 * {@link Mob} that can have a loot table.
 * <br>
 * Container loot will only generate upon opening, and only when the container
 * is <i>first</i> opened.
 * <br>
 * Entities will only generate loot upon death.
 */
public interface Lootable {

    /**
     * Set the loot table for a container or entity.
     * <br>
     * To remove a loot table use null. Do not use {@link LootTables#EMPTY} to
     * clear a LootTable.
     *
     * @param table the Loot Table this {@link Container} or
     * {@link Mob} will have.
     */
    void setLootTable(@Nullable LootTable table);

    /**
     * Gets the Loot Table attached to this block or entity.
     * <br>
     *
     * If an block/entity does not have a loot table, this will return null, NOT
     * an empty loot table.
     *
     * @return the Loot Table attached to this block or entity.
     */
    @Nullable
    LootTable getLootTable();

    /**
     * Set the seed used when this Loot Table generates loot.
     *
     * @param seed the seed to used to generate loot. Default is 0.
     */
    void setSeed(long seed);

    /**
     * Get the Loot Table's seed.
     * <br>
     * The seed is used when generating loot.
     *
     * @return the seed
     */
    long getSeed();
}
