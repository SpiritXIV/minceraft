package com.spirit.tdbtd.block.entity;

import com.spirit.Main;
import com.spirit.tdbtd.block.TDBTDBlocks;
import com.spirit.tdbtd.block.custom.SculkEmitterBlock.SculkEmitterBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TDBTDBlockEntities {
    public static final BlockEntityType<SculkEmitterBlockEntity> SCULK_EMITTER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Main.TDBTD_ID, "sculk_emitter_be"),
                    FabricBlockEntityTypeBuilder.create(SculkEmitterBlockEntity::new,
                            TDBTDBlocks.SCULK_EMITTER).build());

    /*
    public static final BlockEntityType<SculkShakerBlock.SculkShakerBlockEntity> SCULK_SHAKER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Main.TDBTD_ID, "sculk_shaker_be"),
                    FabricBlockEntityTypeBuilder.create(SculkShakerBlock.SculkShakerBlockEntity::new,
                            TDBTDBlocks.SCULK_EMITTER).build());

     */

    public static void registerBlockEntities() {
        Main.LOGGER.info("Registering Block Entities for " + Main.TDBTD_ID);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Main.TDBTD_ID, "sculk_emitter_block_entity"), BlockEntityType.Builder.create(SculkEmitterBlockEntity::new, TDBTDBlocks.SCULK_EMITTER).build(null));
        //Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Main.TDBTD_ID, "sculk_shaker_block_entity"), BlockEntityType.Builder.create(SculkShakerBlock.SculkShakerBlockEntity::new, TDBTDBlocks.SCULK_SHAKER).build(null));
    }
}