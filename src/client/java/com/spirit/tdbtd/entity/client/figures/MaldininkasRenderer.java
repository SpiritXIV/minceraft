package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.MaldininkasEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MaldininkasRenderer extends MobEntityRenderer<MaldininkasEntity, MaldininkasModel<MaldininkasEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/maldininkas.png");

    public MaldininkasRenderer(EntityRendererFactory.Context context) {
        super(context, new MaldininkasModel<>(context.getPart(TDBTDModelLayers.MALDININKAS)), 0.6f);
    }

    @Override
    public Identifier getTexture(MaldininkasEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MaldininkasEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}