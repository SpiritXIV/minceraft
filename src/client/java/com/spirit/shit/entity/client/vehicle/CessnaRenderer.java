package com.spirit.shit.entity.client.vehicle;

import com.spirit.Main;
import com.spirit.shit.entity.client.ShitModelLayers;
import com.spirit.shit.entity.client.figures.CapybaraModel;
import com.spirit.shit.entity.custom.CapybaraEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CessnaRenderer extends MobEntityRenderer<CapybaraEntity, CapybaraModel<CapybaraEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/cessna.png");

    public CessnaRenderer(EntityRendererFactory.Context context) {
        super(context, new CapybaraModel<>(context.getPart(ShitModelLayers.CAPYBARA)), 0.6f);
    }

    @Override
    public Identifier getTexture(CapybaraEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CapybaraEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}