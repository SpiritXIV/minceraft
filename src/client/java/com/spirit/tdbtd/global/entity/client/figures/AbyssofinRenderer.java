package com.spirit.tdbtd.global.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.global.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.global.entity.custom.AbyssofinEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AbyssofinRenderer extends MobEntityRenderer<AbyssofinEntity, AbyssofinModel<AbyssofinEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.TDBTD_ID, "textures/entity/abyssofin.png");

    public AbyssofinRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssofinModel<>(context.getPart(TDBTDModelLayers.ABYSSOFIN)), 0.6f);
    }

    @Override
    public Identifier getTexture(AbyssofinEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AbyssofinEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}