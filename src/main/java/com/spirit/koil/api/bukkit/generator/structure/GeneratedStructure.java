package com.spirit.koil.api.bukkit.generator.structure;

import com.spirit.koil.api.bukkit.persistence.PersistentDataHolder;
import com.spirit.koil.api.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Represents a structure placed in the world.
 *
 * @see StructurePiece
 */
public interface GeneratedStructure extends PersistentDataHolder {

    /**
     * Gets the bounding box of this placed structure.
     *
     * @return bounding box of this placed structure
     */
    @NotNull
    public BoundingBox getBoundingBox();

    /**
     * Gets the structure that this PlacedStructure represents.
     *
     * @return the structure that this PlacedStructure represents
     */
    @NotNull
    public Structure getStructure();

    /**
     * Gets all the {@link StructurePiece} that make up this PlacedStructure.
     *
     * @return a collection of all the StructurePieces
     */
    @NotNull
    public Collection<StructurePiece> getPieces();
}
