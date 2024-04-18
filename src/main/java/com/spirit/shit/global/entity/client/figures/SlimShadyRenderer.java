package com.spirit.shit.global.entity.client.figures;

import com.spirit.Main;
import com.spirit.shit.global.entity.client.ShitModelLayers;
import com.spirit.shit.global.entity.custom.SlimShadyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SlimShadyRenderer extends MobEntityRenderer<SlimShadyEntity, SlimShadyModel<SlimShadyEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/slim_shady.png");

    public SlimShadyRenderer(EntityRendererFactory.Context context) {
        super(context, new SlimShadyModel<>(context.getPart(ShitModelLayers.SLIM_SHADY)), 0.6f);
    }

    @Override
    public Identifier getTexture(SlimShadyEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SlimShadyEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}