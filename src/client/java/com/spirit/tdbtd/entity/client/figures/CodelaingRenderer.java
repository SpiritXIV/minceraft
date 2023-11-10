package com.spirit.tdbtd.entity.client.figures;

import com.spirit.Main;
import com.spirit.tdbtd.entity.client.TDBTDModelLayers;
import com.spirit.tdbtd.entity.custom.CodelaingEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CodelaingRenderer extends MobEntityRenderer<CodelaingEntity, CodelaingModel<CodelaingEntity>> {
    private static final Identifier TEXTURE = new Identifier(Main.TDBTD_ID, "textures/entity/codelaing.png");

    public CodelaingRenderer(EntityRendererFactory.Context context) {
        super(context, new CodelaingModel<>(context.getPart(TDBTDModelLayers.CODELAING)), 0.6f);
    }

    @Override
    public Identifier getTexture(CodelaingEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CodelaingEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}