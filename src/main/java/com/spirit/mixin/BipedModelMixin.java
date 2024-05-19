//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spirit.mixin;

import com.spirit.ignite.global.item.custom.GunItem;
import com.spirit.ignite.global.item.custom.gun.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public abstract class BipedModelMixin<T extends LivingEntity> extends AnimalModel<T> {
    @Shadow @Final public ModelPart head;
    @Shadow @Final public ModelPart body;
    @Shadow @Final public ModelPart leftArm;
    @Shadow @Final public ModelPart rightArm;

    @Inject(method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/BipedEntityModel;animateArms(Lnet/minecraft/entity/LivingEntity;F)V"))
    void onSetArmAngle(T living, float f, float g, float h, float headYaw, float headPitch, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (living.equals(client.player) && !client.gameRenderer.getCamera().isThirdPerson()) {
            return;
        }
        Item heldItem = living.getMainHandStack().getItem();
        if (living.getOffHandStack().getItem() instanceof Glock17Item || living.getOffHandStack().getItem() instanceof Revolver) {
            Vector3f angles;
            boolean rightHanded = living.getMainArm().equals(Arm.RIGHT);
            if (rightHanded || (!rightHanded && living.getMainHandStack().isEmpty())) {
                leftArm.resetTransform();
                angles = new Vector3f(-55, 45, 0).mul(MathHelper.RADIANS_PER_DEGREE);
                leftArm.setAngles(angles.x, angles.y, angles.z);
            }
            if (!rightHanded || (rightHanded && living.getMainHandStack().isEmpty())) {
                rightArm.resetTransform();
                angles = new Vector3f(-45, -30, 0).mul(MathHelper.RADIANS_PER_DEGREE);
                rightArm.setAngles(angles.x, angles.y, angles.z);
            }
        }
        if (heldItem instanceof GunItem w && w.shouldAim())
            GunAimPose(living);
    }

    void GunAimPose(LivingEntity livingEntity) {
        boolean flipped = livingEntity.getMainArm().equals(Arm.LEFT);
        ModelPart main = flipped ? leftArm : rightArm;
        ModelPart off = flipped ? rightArm : leftArm;
        Vector3f angles = new Vector3f(head.pitch, head.yaw, 0F) //Right ARN
                .add(new Vector3f(-90F, 0F,  0F).mul(MathHelper.RADIANS_PER_DEGREE));
        main.setAngles(angles.x, angles.y, angles.z);
        angles = new Vector3f(-90F, flipped ? -45F : 45F, 0F).mul(MathHelper.RADIANS_PER_DEGREE) //Left ARM
                .add(new Vector3f(head.pitch, head.yaw, 0F));
        off.setAngles(angles.x, angles.y, angles.z);
        off.pivotY += 0.5F;
    }
}