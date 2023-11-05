package com.spirit.shit.painting;

import com.spirit.Main;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShitPaintings {
    public static final PaintingVariant ZOORSH = registerPainting("zoorsh", new PaintingVariant(4, 4));


    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(Main.SHIT_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
    }
}
