package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.RatBombEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RatBombModel extends GeoModel<RatBombEntity> {


    @Override
    public Identifier getModelResource(RatBombEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/rat_bomb.geo.json");
    }

    @Override
    public Identifier getTextureResource(RatBombEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/rat_bomb.png");
    }

    @Override
    public Identifier getAnimationResource(RatBombEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/rat_bomb.animation.json");
    }

    @Override
    public void setCustomAnimations(RatBombEntity animatable, long instanceId, AnimationState<RatBombEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
