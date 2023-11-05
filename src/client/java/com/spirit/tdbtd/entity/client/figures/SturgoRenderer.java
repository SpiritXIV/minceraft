package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.SturgoEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SturgoRenderer extends MobEntityRenderer<SturgoEntity, SturgoModel<SturgoEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/sturgo.png");

    public SturgoRenderer(EntityRendererFactory.Context context) {
        super(context, new SturgoModel<>(context.getPart(TDBTDModelLayers.STURGO)), 0.6f);
    }

    @Override
    public Identifier getTexture(SturgoEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SturgoEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}