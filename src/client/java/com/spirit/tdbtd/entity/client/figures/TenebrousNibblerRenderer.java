package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.TenebrousNibblerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class TenebrousNibblerRenderer extends MobEntityRenderer<TenebrousNibblerEntity, TenebrousNibblerModel<TenebrousNibblerEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/tenebrous_nibbler.png");

    public TenebrousNibblerRenderer(EntityRendererFactory.Context context) {
        super(context, new TenebrousNibblerModel<>(context.getPart(TDBTDModelLayers.TENEBROUS_NIBBLER)), 0.6f);
    }

    @Override
    public Identifier getTexture(TenebrousNibblerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TenebrousNibblerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}