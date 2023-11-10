package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.KredaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class KredaRenderer extends MobEntityRenderer<KredaEntity, KredaModel<KredaEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.TDBTD_ID, "textures/entity/kreda.png");

    public KredaRenderer(EntityRendererFactory.Context context) {
        super(context, new KredaModel<>(context.getPart(TDBTDModelLayers.KREDA)), 0.6f);
    }

    @Override
    public Identifier getTexture(KredaEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(KredaEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}