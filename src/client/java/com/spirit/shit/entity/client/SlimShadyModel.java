package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.SlimShadyEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SlimShadyModel extends GeoModel<SlimShadyEntity> {


    @Override
    public Identifier getModelResource(SlimShadyEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/slim_shady.geo.json");
    }

    @Override
    public Identifier getTextureResource(SlimShadyEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/slim_shady.png");
    }

    @Override
    public Identifier getAnimationResource(SlimShadyEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/slim_shady.animation.json");
    }

    @Override
    public void setCustomAnimations(SlimShadyEntity animatable, long instanceId, AnimationState<SlimShadyEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
