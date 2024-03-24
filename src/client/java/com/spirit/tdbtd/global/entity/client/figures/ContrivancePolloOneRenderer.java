package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.global.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.global.entity.custom.ContrivancePolloOneEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ContrivancePolloOneRenderer extends MobEntityRenderer<ContrivancePolloOneEntity, ContrivancePolloOneModel<ContrivancePolloOneEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.TDBTD_ID, "textures/entity/contrivancepolloone.png");

    public ContrivancePolloOneRenderer(EntityRendererFactory.Context context) {
        super(context, new ContrivancePolloOneModel<>(context.getPart(TDBTDModelLayers.CONTRIVANCEPOLLOONE)), 0.6f);
    }

    @Override
    public Identifier getTexture(ContrivancePolloOneEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ContrivancePolloOneEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}