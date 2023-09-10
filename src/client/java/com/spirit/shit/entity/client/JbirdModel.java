package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.JbirdEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class JbirdModel extends GeoModel<JbirdEntity> {


    @Override
    public Identifier getModelResource(JbirdEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/jbird.geo.json");
    }

    @Override
    public Identifier getTextureResource(JbirdEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/jbird.png");
    }

    @Override
    public Identifier getAnimationResource(JbirdEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/jbird.animation.json");
    }

    @Override
    public void setCustomAnimations(JbirdEntity animatable, long instanceId, AnimationState<JbirdEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
