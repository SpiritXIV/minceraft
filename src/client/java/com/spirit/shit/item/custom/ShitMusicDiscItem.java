package com.spirit.shit.item.custom;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ShitMusicDiscItem extends Item {
    private static final Map<SoundEvent, ShitMusicDiscItem> SHIT_MUSIC_DISCS = Maps.newHashMap();
    private final int comparatorOutput;
    private final SoundEvent sound;
    private final int lengthInTicks;
    public ShitMusicDiscItem(int comparatorOutput, SoundEvent sound, Settings settings, int lengthInSeconds) {
        super(settings);
        this.comparatorOutput = comparatorOutput;
        this.sound = sound;
        this.lengthInTicks = lengthInSeconds * 20;
        SHIT_MUSIC_DISCS.put(this.sound, this);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(Blocks.JUKEBOX) && !(Boolean)blockState.get(JukeboxBlock.HAS_RECORD)) {
            ItemStack itemStack = context.getStack();
            if (!world.isClient) {
                PlayerEntity playerEntity = context.getPlayer();
                BlockEntity var8 = world.getBlockEntity(blockPos);
                if (var8 instanceof JukeboxBlockEntity jukeboxBlockEntity) {
                    jukeboxBlockEntity.setStack(itemStack.copy());
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState));
                }

                itemStack.decrement(1);
                if (playerEntity != null) {
                    playerEntity.incrementStat(Stats.PLAY_RECORD);
                }
            }

            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    public int getComparatorOutput() {
        return this.comparatorOutput;
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(this.getDescription().formatted(Formatting.GRAY));
    }

    public MutableText getDescription() {
        return Text.translatable(this.getTranslationKey() + ".desc");
    }

    @Nullable
    public static ShitMusicDiscItem bySound(SoundEvent sound) {
        return SHIT_MUSIC_DISCS.get(sound);
    }

    public SoundEvent getSound() {
        return this.sound;
    }

    public int getSongLengthInTicks() {
        return this.lengthInTicks;
    }

}
