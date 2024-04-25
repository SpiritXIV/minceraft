package com.spirit.koil.api.bukkit.event.block;

import com.spirit.koil.api.bukkit.block.Block;
import com.spirit.koil.api.bukkit.block.BlockFace;
import com.spirit.koil.api.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Called when a piston extends
 */
public class BlockPistonExtendEvent extends BlockPistonEvent {
    private static final HandlerList handlers = new HandlerList();
    private final int length;
    private List<Block> blocks;

    @Deprecated
    public BlockPistonExtendEvent(@NotNull final Block block, final int length, @NotNull final BlockFace direction) {
        super(block, direction);

        this.length = length;
    }

    public BlockPistonExtendEvent(@NotNull final Block block, @NotNull final List<Block> blocks, @NotNull final BlockFace direction) {
        super(block, direction);

        this.length = blocks.size();
        this.blocks = blocks;
    }

    /**
     * Get the amount of blocks which will be moved while extending.
     *
     * @return the amount of moving blocks
     * @deprecated slime blocks make the value of this method
     *          inaccurate due to blocks being pushed at the side
     */
    @Deprecated
    public int getLength() {
        return this.length;
    }

    /**
     * Get an immutable list of the blocks which will be moved by the
     * extending.
     *
     * @return Immutable list of the moved blocks.
     */
    @NotNull
    public List<Block> getBlocks() {
        if (blocks == null) {
            ArrayList<Block> tmp = new ArrayList<Block>();
            for (int i = 0; i < this.getLength(); i++) {
                tmp.add(block.getRelative(getDirection(), i + 1));
            }
            blocks = Collections.unmodifiableList(tmp);
        }
        return blocks;
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
