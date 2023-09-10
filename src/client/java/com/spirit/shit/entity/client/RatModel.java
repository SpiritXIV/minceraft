package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.RatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RatModel extends GeoModel<RatEntity> {


    @Override
    public Identifier getModelResource(RatEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/rat.geo.json");
    }

    @Override
    public Identifier getTextureResource(RatEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/rat.png");
    }

    @Override
    public Identifier getAnimationResource(RatEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/rat.animation.json");
    }

    @Override
    public void setCustomAnimations(RatEntity animatable, long instanceId, AnimationState<RatEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
