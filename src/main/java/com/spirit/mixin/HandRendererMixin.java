package com.spirit.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.spirit.ignite.global.item.custom.GunItem;
import com.spirit.koil.accessor.LivingEntityAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(HeldItemRenderer.class)
public abstract class HandRendererMixin {

	@Shadow public abstract void renderItem(LivingEntity entity, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light);

	@Shadow @Final private EntityRenderDispatcher entityRenderDispatcher;
	@Shadow @Final private MinecraftClient client;

	@Inject(method = "renderFirstPersonItem", at = @At(value = "HEAD"), cancellable = true)
	void onRenderFirstPersonItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {

		if (!(item.getItem() instanceof GunItem)) {
			// client.options.getFov().setValue(100);
			return;
		}

		LivingEntityAccessor playerAccessor = ((LivingEntityAccessor) player);
		if (hand == Hand.MAIN_HAND && (playerAccessor.IsPunching() || !item.isEmpty())) {
			RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
			if (item.getItem() instanceof GunItem)
				matrices.translate(0f, 0f, 0f);
			matrices.push();
			PlayerEntityRenderer renderer = (PlayerEntityRenderer) entityRenderDispatcher.getRenderer(client.player);
			PlayerEntityModel<?> model = renderer.getModel();
			boolean left = player.getMainArm().equals(Arm.LEFT);

			boolean arm, sleeve;
			if (left) {
				arm = model.rightArm.visible;
				sleeve = model.rightSleeve.visible;
			} else {
				arm = model.leftArm.visible;
				sleeve = model.leftSleeve.visible;
			}
			setArmVisibility(model, left ? Arm.RIGHT : Arm.LEFT, true, true);

			setArmVisibility(model, left ? Arm.RIGHT : Arm.LEFT, arm, sleeve);
			matrices.push();
			boolean transform = true;
			int flip = left ? -1 : 1;
			matrices.scale(0.75F, 0.75F, 0.75F);
			if (!GunItem.getZoom()) {
				client.options.getFov().setValue(100);
					matrices.scale(0.75F, 0.75F, 0.75F);
					matrices.translate(0.1F * flip, -0.35F, -0.2F * flip);

			}
			if (GunItem.getZoom()) {
					matrices.scale(1F, 1F, 1F);
					matrices.translate(-0.11F * flip, -0.4F, -0.1F * flip);
					client.options.getFov().setValue(100 - GunItem.getZoomInt());
			}

			renderItem(player, item,
					transform ? (left ? ModelTransformationMode.FIRST_PERSON_LEFT_HAND : ModelTransformationMode.FIRST_PERSON_RIGHT_HAND) :
							ModelTransformationMode.NONE, !left, matrices, vertexConsumers, light);
			matrices.pop();
			matrices.pop();
			ci.cancel();
		}
	}


	void setArmVisibility(PlayerEntityModel<?> model, Arm side, boolean arm, boolean sleeve) {
		if(side.equals(Arm.RIGHT)) {
			model.rightArm.visible = arm;
			model.rightSleeve.visible = sleeve;
		}
		else {
			model.leftArm.visible = arm;
			model.leftSleeve.visible = sleeve;
		}
	}
}