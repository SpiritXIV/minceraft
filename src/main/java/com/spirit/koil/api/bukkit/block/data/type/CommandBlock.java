package com.spirit.koil.api.bukkit.block.data.type;

import com.spirit.koil.api.bukkit.block.data.Directional;

/**
 * 'conditional' denotes whether this command block is conditional or not, i.e.
 * will only execute if the preceeding command block also executed successfully.
 */
public interface CommandBlock extends Directional {

    /**
     * Gets the value of the 'conditional' property.
     *
     * @return the 'conditional' value
     */
    boolean isConditional();

    /**
     * Sets the value of the 'conditional' property.
     *
     * @param conditional the new 'conditional' value
     */
    void setConditional(boolean conditional);
}
