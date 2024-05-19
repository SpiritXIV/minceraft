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
import com.spirit.shit.global.entity.custom.projectile.TrashCanProjectileEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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


    @Override
    public void onInitialize() {
    }


    public static void registerShitpostMod() {
        Main.SHITLOGGER.info("> --Connected || minceraft/src/main/java/com/spirit/shit/ShitMod");
    }
}