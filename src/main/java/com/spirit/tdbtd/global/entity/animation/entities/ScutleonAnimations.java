package com.spirit.tdbtd.global.entity.animation.entities;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ScutleonAnimations {
    @SuppressWarnings("unused")
    public static void FileContents() {
        Animation scutleonIdle = ScutleonAnimations.SCUTLEON_IDLE;

}
    public static final Animation SCUTLEON_IDLE = Animation.Builder.create(0f)
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -27.5f, -17.5f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_mandible",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -67.5f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_mandible",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 75f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("abdomen",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(8.61f, 12.45f, 5.12f),
                                    Transformation.Interpolations.LINEAR))).build();}
