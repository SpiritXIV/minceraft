package com.spirit.mixin;

import com.spirit.ignite.global.item.custom.GunItem;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientPlayerInteractionManagerMixin {
    @Inject(method = "handleInputEvents", at = @At("HEAD"))
    private void onHandleInputEvents(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        KeyBinding attackKey = client.options.attackKey;
        KeyBinding useKey = client.options.useKey;

        // Check if the left mouse button is down
        if (attackKey.isPressed()) {
            PlayerEntity player = client.player;
            World world = client.world;

            // Null checks in case the player or world instances are not available
            if (player == null || world == null) {
                return;
            }

            ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);

            if (itemStack.getItem() instanceof GunItem) {
                // Create a PacketByteBuf and write the hand to it
                PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
                buf.writeInt(Hand.MAIN_HAND.ordinal()); // 0 for MAIN_HAND, 1 for OFF_HAND

                // Send the packet to the server
                ClientPlayNetworking.send(new Identifier("ignite", "fire_gun"), buf);
            }
        }
        if (useKey.isPressed()) {
            PlayerEntity player = client.player;
            World world = client.world;

            if (player == null || world == null) {
                return;
            }

            ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);

            if (itemStack.getItem() instanceof GunItem) {
                PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
                buf.writeInt(Hand.MAIN_HAND.ordinal());

                ClientPlayNetworking.send(new Identifier("ignite", "zoom_gun"), buf);
            }
        }
    }


}