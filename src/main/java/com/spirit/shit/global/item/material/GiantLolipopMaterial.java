package com.spirit.shit.global.item.material;

import com.spirit.shit.global.item.ShitItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class GiantLolipopMaterial implements ToolMaterial {
    public static final GiantLolipopMaterial INSTANCE = new GiantLolipopMaterial();

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
        return Ingredient.ofItems(ShitItems.POCKY_STICK_BOX);
    }
}

