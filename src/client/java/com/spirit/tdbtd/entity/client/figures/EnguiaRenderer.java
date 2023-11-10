package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.EnguiaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EnguiaRenderer extends MobEntityRenderer<EnguiaEntity, EnguiaModel<EnguiaEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.TDBTD_ID, "textures/entity/enguia.png");

    public EnguiaRenderer(EntityRendererFactory.Context context) {
        super(context, new EnguiaModel<>(context.getPart(TDBTDModelLayers.ENGUIA)), 0.6f);
    }

    @Override
    public Identifier getTexture(EnguiaEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(EnguiaEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}