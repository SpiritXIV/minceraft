package com.spirit.shit.entity.client.figures;

import com.spirit.Main;
import com.spirit.shit.entity.client.ShitModelLayers;
import com.spirit.shit.entity.custom.RatEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RatRenderer extends MobEntityRenderer<RatEntity, RatModel<RatEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/rat.png");

    public RatRenderer(EntityRendererFactory.Context context) {
        super(context, new RatModel<>(context.getPart(ShitModelLayers.RAT)), 0.6f);
    }

    @Override
    public Identifier getTexture(RatEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(RatEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}