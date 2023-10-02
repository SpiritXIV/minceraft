package com.spirit.shit.entity.client.vehicle;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.CapybaraEntity;
import com.spirit.shit.entity.custom.vehicle.CropDusterEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CropDusterModel extends GeoModel<CropDusterEntity> {

    @Override
    public Identifier getModelResource(CropDusterEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/crop_duster.geo.json");
    }

    @Override
    public Identifier getTextureResource(CropDusterEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/crop_duster.png");
    }

    @Override
    public Identifier getAnimationResource(CropDusterEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/crop_duster.animation.json");
    }

    public void setCustomAnimations(CapybaraEntity animatable, long instanceId, AnimationState<CapybaraEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("body");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}