package com.spirit.shit.global.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class MomenItem extends Item {
    private final int value;

    public MomenItem(Settings settings, int value) {
        super(settings);
        this.value = value;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        int totalValue = getTotalValue(stack);
        tooltip.add(Text.literal("ƒ: " + totalValue).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }

    private int getTotalValue(ItemStack stack) {
        return value * stack.getCount();
    }
}
