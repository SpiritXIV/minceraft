package com.spirit.shit.render;

import com.spirit.shit.common.PlaneEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class PlaneEntityRenderer extends EntityRenderer<PlaneEntity> {
    protected PlaneEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(PlaneEntity entity) {
        return null;
    }
}
