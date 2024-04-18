package com.spirit.shit.global.entity.client.figures;

import com.spirit.Main;
import com.spirit.shit.global.entity.client.ShitModelLayers;
import com.spirit.shit.global.entity.custom.FreddyFazBearEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FreddyFazBearRenderer extends MobEntityRenderer<FreddyFazBearEntity, FreddyFazBearModel<FreddyFazBearEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/FreddyFazBear.png");

    public FreddyFazBearRenderer(EntityRendererFactory.Context context) {
        super(context, new FreddyFazBearModel<>(context.getPart(ShitModelLayers.FREDDY_FAZ_BEAR)), 0.6f);
    }

    @Override
    public Identifier getTexture(FreddyFazBearEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FreddyFazBearEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}