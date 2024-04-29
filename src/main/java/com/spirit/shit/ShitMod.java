/*
    $/ A K F I I J L M P Q $ I L \$
    |  F $ N R P T K D Q W V J N
    |
    |
    |
    |
    #\
 */

package com.spirit.shit;


import com.spirit.Main;
import com.spirit.shit.data.common.Common;
import com.spirit.shit.data.common.GunProjectileItem;
import com.spirit.shit.global.entity.custom.projectile.BulletProjectileEntity;
import com.spirit.shit.global.entity.custom.projectile.TrashCanProjectileEntity;
import com.spirit.shit.global.item.ShitItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ShitMod implements ModInitializer {
    private static <T extends Entity> EntityType<T> registerEntityType(String name, SpawnGroup group, EntityType.EntityFactory<T> entityFactory, float width, float height) {
        Identifier entityId = new Identifier(Main.SHIT_ID, name);
        FabricEntityTypeBuilder<T> entityTypeBuilder = FabricEntityTypeBuilder.create(group, entityFactory)
                .dimensions(EntityDimensions.fixed(width, height))
                .trackRangeBlocks(4).trackedUpdateRate(10);
        return Registry.register(Registries.ENTITY_TYPE, entityId, entityTypeBuilder.build());
    }
    public static final EntityType<TrashCanProjectileEntity> TrashCanProjectileEntityType = registerEntityType("trash_can", SpawnGroup.MISC, TrashCanProjectileEntity::new, 1F, 2F);
    public static final EntityType<BulletProjectileEntity> BulletProjectileEntityType = registerEntityType("bullet_entity", SpawnGroup.MISC, BulletProjectileEntity::new, 0.25F, 0.25F);


    public static final ItemGroup BULLET_ITEM_GROUP = FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bullet"))
            .icon(() -> new ItemStack(ShitItems.BULLET))  // Replace with a representative ItemStack for this group
            .entries((displayContext, entries) -> {
                // Items to consider
                GunProjectileItem[] items = Common.getBulletProjectileItems();

                for (GunProjectileItem bulletItem : items) {
                    for (StatusEffect effect : Registries.STATUS_EFFECT) {
                        for (byte isIncendiary : new byte[]{0, 1}) {
                            for (byte isExplosive : new byte[]{0, 1}) {
                                for (byte isExtendedDuration : new byte[]{0, 1}) {
                                    ItemStack stack = bulletItem.createItemWithEffects(effect, isIncendiary, isExplosive, isExtendedDuration, /*attempt*/ bulletItem);

                                    // Add BulletType to NBT data
                                    NbtCompound nbt = stack.getOrCreateNbt();
                                    nbt.putString("BulletType", bulletItem.getName().getString());  // Assuming getName().getString() returns the type like "Bullet", "Rifle Bullet", etc.

                                    // Generate a custom name for this bullet based on its properties.
                                    String customName = bulletItem.generateCustomNameFromNBT(stack);

                                    // Set the custom name to the ItemStack.
                                    stack.setCustomName(Text.translatable(customName));

                                    // Add the customized ItemStack to the entries.
                                    entries.add(stack);
                                }
                            }
                        }
                    }
                }
            }).build();

    @Override
    public void onInitialize() {
    }


    public static void registerShitpostMod() {
        Main.SHITLOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/shit/ShitMod");
    }
}


