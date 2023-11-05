package com.spirit.shit.entity.client.figures;

import com.spirit.Main;
import com.spirit.shit.entity.client.ShitModelLayers;
import com.spirit.shit.entity.custom.JbirdEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class JbirdRenderer extends MobEntityRenderer<JbirdEntity, JbirdModel<JbirdEntity>> {
private static final Identifier TEXTURE = new Identifier(Main.SHIT_ID, "textures/entity/jbird.png");

public JbirdRenderer(EntityRendererFactory.Context context) {
        super(context, new JbirdModel<>(context.getPart(ShitModelLayers.JBIRD)), 0.6f);
        }

@Override
public Identifier getTexture(JbirdEntity entity) {
        return TEXTURE;
        }

@Override
public void render(JbirdEntity mobEntity, float f, float g, MatrixStack matrixStack,
        VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        }
}