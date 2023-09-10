package com.spirit.shit.entity.client;

import com.spirit.shit.ShitMod;
import com.spirit.shit.entity.custom.YippeeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class YippeeModel extends GeoModel<YippeeEntity> {


    @Override
    public Identifier getModelResource(YippeeEntity object) {
        return new Identifier(ShitMod.MOD_ID, "geo/yippee.geo.json");
    }

    @Override
    public Identifier getTextureResource(YippeeEntity object) {
        return new Identifier(ShitMod.MOD_ID, "textures/entity/yippee.png");
    }

    @Override
    public Identifier getAnimationResource(YippeeEntity animatable) {
        return new Identifier(ShitMod.MOD_ID, "animations/yippee.animation.json");
    }

    @Override
    public void setCustomAnimations(YippeeEntity animatable, long instanceId, AnimationState<YippeeEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
