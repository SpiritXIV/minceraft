package com.spirit.mixin;

import com.spirit.koil.accessor.LivingEntityAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Environment(EnvType.CLIENT)
@Mixin(LivingEntity.class)
public abstract class ClientLivingEntityMixin implements LivingEntityAccessor
{
	@Shadow public abstract void swingHand(Hand hand);

	@Override
	public boolean punch()
	{
		if((Object)this instanceof OtherClientPlayerEntity || MinecraftClient.getInstance().gameRenderer.getCamera().isThirdPerson())
			swingHand(Hand.OFF_HAND);
		return false;
	}
}