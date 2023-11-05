package com.spirit.tdbtd.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.spirit.tdbtd.block.TDBTDBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

public class TDBTDPickaxeItem
        extends PickaxeItem { protected static final Map<Block, BlockState> INFURTRINATED_STATE = Maps.newHashMap(new ImmutableMap.Builder<Block, BlockState>().put(TDBTDBlocks.INFURTRINATED_COBBLESTONE, Blocks.COBBLESTONE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_DEEPSLATE, Blocks.DEEPSLATE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_STONE, Blocks.STONE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_ANDESITE, Blocks.ANDESITE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_CALCITE, Blocks.CALCITE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_TUFF, Blocks.TUFF.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_BLACKSTONE, Blocks.BLACKSTONE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_BASALT, Blocks.BASALT.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_DIORITE, Blocks.DIORITE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_GRANITE, Blocks.GRANITE.getDefaultState()).put(TDBTDBlocks.INFURTRINATED_SMOOTH_BASALT, Blocks.SMOOTH_BASALT.getDefaultState()).build());

    public TDBTDPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (context.getBlockPos() != BlockPos.ORIGIN) {
            PlayerEntity playerEntity = context.getPlayer();
            BlockState blockState2 = INFURTRINATED_STATE.get(blockState.getBlock());
            BlockState blockState3 = null;
            if (blockState2 != null) {
                world.playSound(playerEntity, blockPos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 0.5f, 1.0f);
                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_SCULK_SENSOR_CLICKING_STOP, SoundCategory.BLOCKS, 0.6f, 1.2f);
                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_SCULK_SENSOR_CLICKING, SoundCategory.BLOCKS, 0.6f, 1.2f);
                blockState3 = blockState2;
                                } else if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT).booleanValue()) {
                                    if (!world.isClient()) {
                                        world.syncWorldEvent(null, WorldEvents.FIRE_EXTINGUISHED, blockPos, 0);
                                    }
                                    CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                                    blockState3 = (BlockState) blockState.with(CampfireBlock.SIGNAL_FIRE, true);
                                }
                                if (blockState3 != null) {
                                    if (!world.isClient) {
                                        world.setBlockState(blockPos, blockState3, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
                                        world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState3));
                                        if (playerEntity != null) {
                                            context.getStack().damage(3, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
                                        }
                                    }
                                    return ActionResult.success(world.isClient);
                                }
                                return ActionResult.PASS;
                            }
                            return ActionResult.PASS;
                    }

}
