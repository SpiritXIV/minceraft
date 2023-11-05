package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.DevastadorCurEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DevastadorCurRenderer extends MobEntityRenderer<DevastadorCurEntity, DevastadorCurModel<DevastadorCurEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/devastador_cur.png");

    public DevastadorCurRenderer(EntityRendererFactory.Context context) {
        super(context, new DevastadorCurModel<>(context.getPart(TDBTDModelLayers.DEVASTADOR_CUR)), 0.6f);
    }

    @Override
    public Identifier getTexture(DevastadorCurEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(DevastadorCurEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}