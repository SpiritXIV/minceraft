package com.spirit.tdbtd.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TDBTDToolMaterial implements ToolMaterial {
    public static final TDBTDToolMaterial INSTANCE = new TDBTDToolMaterial();

    @Override
    public int getDurability() {
        return 3100;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TDBTDItems.INFURTRINATED_FRAGMENT);
    }
}

