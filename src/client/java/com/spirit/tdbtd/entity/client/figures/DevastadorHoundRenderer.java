package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.DevastadorHoundEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DevastadorHoundRenderer extends MobEntityRenderer<DevastadorHoundEntity, DevastadorHoundModel<DevastadorHoundEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.TDBTD_ID, "textures/entity/devastador_hound.png");

    public DevastadorHoundRenderer(EntityRendererFactory.Context context) {
        super(context, new DevastadorHoundModel<>(context.getPart(TDBTDModelLayers.DEVASTADOR_HOUND)), 0.6f);
    }

    @Override
    public Identifier getTexture(DevastadorHoundEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(DevastadorHoundEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}