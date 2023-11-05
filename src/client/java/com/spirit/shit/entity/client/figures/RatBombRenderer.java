package com.spirit.shit.entity.client.figures;

import com.spirit.Main;
import com.spirit.shit.entity.client.ShitModelLayers;
import com.spirit.shit.entity.custom.RatBombEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RatBombRenderer extends MobEntityRenderer<RatBombEntity, RatBombModel<RatBombEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/rat_bomb.png");

    public RatBombRenderer(EntityRendererFactory.Context context) {
        super(context, new RatBombModel<>(context.getPart(ShitModelLayers.RAT_BOMB)), 0.6f);
    }

    @Override
    public Identifier getTexture(RatBombEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(RatBombEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}