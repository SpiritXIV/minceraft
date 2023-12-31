package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.CuratorEntitySpare;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CuratorRenderer extends MobEntityRenderer<CuratorEntitySpare, CuratorModel<CuratorEntitySpare>> {
    private static final Identifier TEXTURE = new Identifier(Main.TDBTD_ID, "textures/entity/curator.png");

    public CuratorRenderer(EntityRendererFactory.Context context) {
        super(context, new CuratorModel<>(context.getPart(TDBTDModelLayers.CURATOR)), 0.6f);
    }

    @Override
    public Identifier getTexture(CuratorEntitySpare entity) {
        return TEXTURE;
    }

    @Override
    public void render(CuratorEntitySpare mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}