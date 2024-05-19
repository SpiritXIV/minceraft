package com.spirit.ignite.global.item;

import com.spirit.Main;
import com.spirit.ignite.global.block.IgniteBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IgniteItemGroup {

    public static final ItemGroup IGNITE_MAIN_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Main.IGNITE_ID, "ignitemain"),
            FabricItemGroup.builder().displayName(Text.literal("Ignite"))
                    .icon(() -> new ItemStack(IgniteItems.BULLET)).entries((displayContext, entries) -> {
                        entries.add(IgniteBlocks.LAND_MINE);
                        entries.add(IgniteItems.AK47);
                        entries.add(IgniteItems.AWP);
                        entries.add(IgniteItems.DOUBLE_BARREL);
                        entries.add(IgniteItems.FNP90);
                        entries.add(IgniteItems.FNP90SCOPE);
                        entries.add(IgniteItems.GLOCK17);
                        entries.add(IgniteItems.M16);
                        entries.add(IgniteItems.M1_GARAND);
                        entries.add(IgniteItems.REVOLVER);
                        entries.add(IgniteItems.GOLDEN_REVOLVER);
                        entries.add(IgniteItems.STRIKER_12);
                        entries.add(IgniteItems.FLAME_THROWER);
                        entries.add(IgniteItems.MUSKET);
                        entries.add(IgniteItems.STEYR_SCOUT_ELITE);

                        entries.add(IgniteItems.GRENADE);
                        entries.add(IgniteItems.INCGRENADE);
                        entries.add(IgniteItems.FLASH_BANG);
                        entries.add(IgniteItems.PIPE_BOMB);
                        entries.add(IgniteItems.SMOKE_BOMB);

                        entries.add(IgniteItems.BULLET);
                        entries.add(IgniteItems.BULLET_GOLD);
                        entries.add(IgniteItems.BULLET_IRON);
                        entries.add(IgniteItems.BULLET_INCENDIARY);
                        entries.add(IgniteItems.BULLET_EXPLOSIVE);
                        entries.add(IgniteItems.RIFLE_BULLET);
                        entries.add(IgniteItems.RIFLE_BULLET_GOLD);
                        entries.add(IgniteItems.RIFLE_BULLET_IRON);
                        entries.add(IgniteItems.RIFLE_BULLET_INCENDIARY);
                        entries.add(IgniteItems.RIFLE_BULLET_EXPLOSIVE);
                        entries.add(IgniteItems.HIGH_CALIBER_BULLET);
                        entries.add(IgniteItems.HIGH_CALIBER_BULLET_GOLD);
                        entries.add(IgniteItems.HIGH_CALIBER_BULLET_IRON);
                        entries.add(IgniteItems.HIGH_CALIBER_BULLET_INCENDIARY);
                        entries.add(IgniteItems.HIGH_CALIBER_BULLET_EXPLOSIVE);
                        entries.add(IgniteItems.SHELL);
                        entries.add(IgniteItems.SHELL_MAGNUM);
                        entries.add(IgniteItems.SHELL_SHORTY);
                        entries.add(IgniteItems.SLUG_HEAVY);
                        entries.add(IgniteItems.SLUG_INCENDIARY);
                        entries.add(IgniteItems.SLUG_EXPLOSIVE);
                        entries.add(IgniteItems.MUSKET_BALL);

                    }).build());

    public static void register() {
    }
}
