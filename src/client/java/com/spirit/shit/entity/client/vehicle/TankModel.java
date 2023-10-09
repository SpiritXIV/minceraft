package com.spirit.shit.entity.client.vehicle;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.CapybaraEntity;
import com.spirit.shit.entity.custom.vehicle.CropDusterEntity;
import com.spirit.shit.entity.custom.vehicle.TankEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TankModel extends GeoModel<TankEntity> {

    @Override
    public Identifier getModelResource(TankEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/abrams_tank.geo.json");
    }

    @Override
    public Identifier getTextureResource(TankEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/abrams_tank.png");
    }

    @Override
    public Identifier getAnimationResource(TankEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/abrams_tank.animation.json");
    }

    public void setCustomAnimations(TankEntity animatable, long instanceId, AnimationState<TankEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("body");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}