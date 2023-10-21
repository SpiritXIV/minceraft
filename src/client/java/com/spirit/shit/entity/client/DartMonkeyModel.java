package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.DartMonkeyEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DartMonkeyModel extends GeoModel<DartMonkeyEntity> {


    @Override
    public Identifier getModelResource(DartMonkeyEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/dart_monkey.geo.json");
    }

    @Override
    public Identifier getTextureResource(DartMonkeyEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/dart_monkey.png");
    }

    @Override
    public Identifier getAnimationResource(DartMonkeyEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/dart_monkey.animation.json");
    }

    @Override
    public void setCustomAnimations(DartMonkeyEntity animatable, long instanceId, AnimationState<DartMonkeyEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
