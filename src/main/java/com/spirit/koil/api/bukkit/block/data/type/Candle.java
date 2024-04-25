package com.spirit.koil.api.bukkit.block.data.type;

import com.spirit.koil.api.bukkit.block.data.Lightable;
import com.spirit.koil.api.bukkit.block.data.Waterlogged;

/**
 * 'candles' represents the number of candles which are present.
 */
public interface Candle extends Lightable, Waterlogged {

    /**
     * Gets the value of the 'candles' property.
     *
     * @return the 'candles' value
     */
    int getCandles();

    /**
     * Sets the value of the 'candles' property.
     *
     * @param candles the new 'candles' value
     */
    void setCandles(int candles);

    /**
     * Gets the maximum allowed value of the 'candles' property.
     *
     * @return the maximum 'candles' value
     */
    int getMaximumCandles();
}
