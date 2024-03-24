package com.spirit.shit.data.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_SHIT = "The Shit of The Crypt";
    public static final String KEY_RELOAD = "Reload";

    public static KeyBinding reloadKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            //noinspection StatementWithEmptyBody
            if (reloadKey.wasPressed()) {
                //
            }
        });
    }

    public static void register() {
        reloadKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_RELOAD,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,
                KEY_CATEGORY_SHIT
        ));

        registerKeyInputs();
    }
}