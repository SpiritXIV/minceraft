package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.global.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.global.entity.custom.AperturenteethEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AperturenteethRenderer extends MobEntityRenderer<AperturenteethEntity, AperturenteethModel<AperturenteethEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.TDBTD_ID, "textures/entity/aperturenteeth.png");

    public AperturenteethRenderer(EntityRendererFactory.Context context) {
        super(context, new AperturenteethModel<>(context.getPart(TDBTDModelLayers.APERTURENTEETH)), 0.6f);
    }

    @Override
    public Identifier getTexture(AperturenteethEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AperturenteethEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}