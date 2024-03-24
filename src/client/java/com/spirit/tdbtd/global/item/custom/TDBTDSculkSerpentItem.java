package com.spirit.tdbtd.global.item.custom;

import com.spirit.tdbtd.global.entity.damage.DamageTypes;
import com.spirit.tdbtd.global.sound.TDBTDSounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.Vanishable;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class TDBTDSculkSerpentItem extends RangedWeaponItem implements Vanishable {
    static float DAMAGE = 10;
    static float PULLTIME = 80;
    public static final Predicate<ItemStack> NO_PROJECTILES = (stack) -> stack.isOf(Items.AIR);

    public TDBTDSculkSerpentItem(Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return NO_PROJECTILES;
    }

    @Override
    public int getRange() {
        return 15;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (world instanceof ServerWorld serverWorld) {
            if (user.isSneaking()) {
                user.setCurrentHand(hand);
                serverWorld.playSound(null, user.getX(), user.getY(), user.getZ(), TDBTDSounds.DIMENTED_SERPENT_CHARGE, SoundCategory.PLAYERS, 1, 1);
                return TypedActionResult.consume(stack);
            } else {
                user.setCurrentHand(hand);
                serverWorld.playSound(null, user.getX(), user.getY(), user.getZ(), TDBTDSounds.DIMENTED_SERPENT_CHARGE, SoundCategory.PLAYERS, 10, 1);
                return TypedActionResult.consume(stack);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            if (user instanceof PlayerEntity player) {
                int chargeTime = this.getMaxUseTime(stack) - remainingUseTicks;

                if (chargeTime >= PULLTIME || player.experienceLevel == 1) {
                    float damage = DAMAGE + ((float) player.experienceLevel / 10) * 2;

                    executeSonicBoom(world, player, damage);
                    int currentXP = player.experienceLevel;
                    player.experienceLevel -= currentXP / 2;
                    player.experienceLevel = Math.max(0, player.experienceLevel - currentXP / 2);

                    player.getItemCooldownManager().set(this, player.experienceLevel / 10);
                }
            }
        }
    }

    public static void executeSonicBoom(World world, PlayerEntity user, float damage) {
        if (world instanceof ServerWorld serverWorld) {

            Vec3d lookVector = user.getRotationVec(1.0F);
            Vec3d currentPos = user.getCameraPosVec(1.0F);
            int numberOfParticles = user.experienceLevel * 2;
            Vec3d step = lookVector.multiply(user.experienceLevel * 2).multiply(1.0 / numberOfParticles);

            for (int i = 0; i < numberOfParticles; i++) {
                currentPos = currentPos.add(step);
                serverWorld.spawnParticles(ParticleTypes.SONIC_BOOM, currentPos.x, currentPos.y, currentPos.z, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.SCULK_CHARGE_POP, currentPos.x, currentPos.y, currentPos.z, 1, 0.0, 0.0, 0.0, 0.0);

                double beamWidth = 2.0;
                double halfWidth = beamWidth / 2.0;
                Box collisionBox = new Box(
                        currentPos.x - halfWidth, currentPos.y,
                        currentPos.z - halfWidth, currentPos.x + halfWidth,
                        currentPos.y + 1.0, currentPos.z + halfWidth);

                serverWorld.getEntitiesByClass(LivingEntity.class, collisionBox, entity -> entity != user)
                        .forEach(entity -> {
                            if (entity instanceof LivingEntity) {
                                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 5, 0));
                                entity.damage(DamageTypes.of(world, DamageTypes.DIMENTED_SERPENT), damage);
                            }
                        });
            }

            serverWorld.playSound(null, user.getX(), user.getY(), user.getZ(), TDBTDSounds.DIMENTED_SERPENT_SHOOT, SoundCategory.PLAYERS, 10, 1);
            serverWorld.spawnParticles(ParticleTypes.SCULK_SOUL, user.getX(), user.getY(), user.getZ(), user.experienceLevel * 2, 0.0, 0.0, 0.0, 0.4);
            serverWorld.spawnParticles(ParticleTypes.SOUL_FIRE_FLAME, user.getX(), user.getY(), user.getZ(), user.experienceLevel * 2, 0.0, 0.0, 0.0, 0.4);
            serverWorld.spawnParticles(ParticleTypes.SOUL, user.getX(), user.getY(), user.getZ(), user.experienceLevel * 2, 0.0, 0.0, 0.0, 0.4);

            user.damage(DamageTypes.of(world, DamageTypes.DIMENTED_LIFESHOT), 6);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (MinecraftClient.getInstance().player != null) {
            PlayerEntity player = MinecraftClient.getInstance().player;

            int attackDamage = (int) (DAMAGE + ((float) player.experienceLevel / 10) * 2);
            if (player.experienceLevel == 0) {
                attackDamage = 0;
            }
            float attackSpeed = PULLTIME / 100;
            tooltip.add(Text.literal("When in Main Hand:").formatted(Formatting.GRAY));
            tooltip.add(Text.literal(" " + attackDamage + " Attack Damage").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.literal(" " + attackSpeed + " Attack Speed").formatted(Formatting.DARK_GREEN));
        }
    }
}