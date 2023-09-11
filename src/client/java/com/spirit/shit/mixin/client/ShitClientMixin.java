package com.spirit.shit.mixin.client;

import com.spirit.shit.ShitMod;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ShitClientMixin {
	@Inject(at = @At("HEAD"), method = "run")
	private void run(CallbackInfo info) {
		ShitMod.LOGGER.info("");	}
}