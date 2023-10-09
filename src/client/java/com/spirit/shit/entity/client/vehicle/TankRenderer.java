package com.spirit.shit.entity.client.vehicle;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.vehicle.TankEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TankRenderer extends GeoEntityRenderer<TankEntity> {
    public static final Identifier TEXTURE = new Identifier(ShitMod.MOD_ID, "textures/entity/abrams_tank.png");

    public TankRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TankModel());
    }

    @Override
    public Identifier getTextureLocation(TankEntity instance) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/abrams_tank.png");
    }


    @Override
    public void render(TankEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
