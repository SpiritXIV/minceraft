package com.spirit.shit.entity.client.vehicle;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.CapybaraEntity;
import com.spirit.shit.entity.custom.vehicle.CropDusterEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CropDusterRenderer extends GeoEntityRenderer<CropDusterEntity> {
    public static final Identifier TEXTURE = new Identifier(ShitMod.MOD_ID, "textures/entity/crop_duster.png");

    public CropDusterRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CropDusterModel());
    }

    @Override
    public Identifier getTextureLocation(CropDusterEntity instance) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/crop_duster.png");
    }


    @Override
    public void render(CropDusterEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
