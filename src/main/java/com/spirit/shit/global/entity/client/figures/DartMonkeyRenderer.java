package com.spirit.shit.global.entity.client.figures;

import com.spirit.Main;
import com.spirit.shit.global.entity.client.ShitModelLayers;
import com.spirit.shit.global.entity.custom.DartMonkeyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DartMonkeyRenderer extends MobEntityRenderer<DartMonkeyEntity, DartMonkeyModel<DartMonkeyEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/dart_monkey.png");

    public DartMonkeyRenderer(EntityRendererFactory.Context context) {
        super(context, new DartMonkeyModel<>(context.getPart(ShitModelLayers.DART_MONKEY)), 0.6f);
    }

    @Override
    public Identifier getTexture(DartMonkeyEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(DartMonkeyEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}