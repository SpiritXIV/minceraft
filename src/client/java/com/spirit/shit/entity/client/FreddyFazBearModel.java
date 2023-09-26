package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.FreddyFazBearEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FreddyFazBearModel extends GeoModel<FreddyFazBearEntity> {

    @Override
    public Identifier getModelResource(FreddyFazBearEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/freddy_faz_bear.geo.json");
    }

    @Override
    public Identifier getTextureResource(FreddyFazBearEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/freddy_faz_bear.png");
    }

    @Override
    public Identifier getAnimationResource(FreddyFazBearEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/freddy_faz_bear.animation.json");
    }

    @Override
    public void setCustomAnimations(FreddyFazBearEntity animatable, long instanceId, AnimationState<FreddyFazBearEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
