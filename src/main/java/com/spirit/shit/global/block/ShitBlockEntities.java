package com.spirit.shit.global.block;

import com.spirit.Main;
import com.spirit.shit.global.block.custom.SuitCaseBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ShitBlockEntities {

    public static final BlockEntityType<SuitCaseBlock.SuitCaseBlockEntity> SUITCASE_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Main.SHIT_ID, "suitcase_be"),
                    FabricBlockEntityTypeBuilder.create(SuitCaseBlock.SuitCaseBlockEntity::new,
                            ShitBlocks.SUITCASE).build());

    public static void registerBlockEntities() {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Main.SHIT_ID, "suitcase_block_entity"), BlockEntityType.Builder.create(SuitCaseBlock.SuitCaseBlockEntity::new, ShitBlocks.SUITCASE).build(null));
    }
}
