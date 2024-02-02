package com.spirit.tdbtd.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TDBTDSculkSerpentItem extends BowItem {
    static double DISTANCE = 50.0;
    static float DAMAGE = 10;
    static double YADJUST = 1.3;

    public TDBTDSculkSerpentItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (user.isSneaking()) {
            user.setCurrentHand(hand);

            user.playSound(SoundEvents.ENTITY_WARDEN_NEARBY_CLOSEST, SoundCategory.PLAYERS, 0.4f, 1);

            return TypedActionResult.consume(stack);
        } else {
            user.playSound(SoundEvents.ENTITY_WARDEN_NEARBY_CLOSEST, SoundCategory.PLAYERS, 10, 1);
            return super.use(world, user, hand);
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            if (user instanceof PlayerEntity player) {
                int chargeTime = this.getMaxUseTime(stack) - remainingUseTicks;

                if (chargeTime >= 60) {
                    if (player.experienceLevel >= 30) {
                        player.experienceLevel -= 15;

                        executeSonicBoom(world, player);

                        // Add sound when fully charged
                        player.playSound(SoundEvents.ENTITY_WARDEN_ANGRY, SoundCategory.PLAYERS, 10, 0);

                        player.getItemCooldownManager().set(this, 1);
                    }
                }
            }
        }
    }

    private static void applyDamageAndEffect(LivingEntity entity, float DAMAGE) {
        // Apply your damage and effects here
        entity.damage(new DamageSource(RegistryEntry.of(new DamageType("bombed_self", 1))), TDBTDSculkSerpentItem.DAMAGE);
    }


    public static void executeSonicBoom(World world, PlayerEntity player) {
        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) world;

            player.playSound(SoundEvents.ENTITY_WARDEN_ROAR, SoundCategory.PLAYERS, 10, 1);
            player.playSound(SoundEvents.ENTITY_WARDEN_AGITATED, SoundCategory.PLAYERS, 10, 1);
            player.playSound(SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, SoundCategory.PLAYERS, 10, 1.4f);
            player.playSound(SoundEvents.ENTITY_WARDEN_TENDRIL_CLICKS, SoundCategory.PLAYERS, 10, 0.5f);
            player.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_AMBIENT, SoundCategory.PLAYERS, 10, 1.1f);
            player.playSound(SoundEvents.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM, SoundCategory.PLAYERS, 10, 0);
            player.playSound(SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.PLAYERS, 10, 0);
            serverWorld.spawnParticles(ParticleTypes.SCULK_SOUL, player.getX(), player.getY(), player.getZ(), 100, 0.0, 0.0, 0.0, 0.4);
            serverWorld.spawnParticles(ParticleTypes.SOUL_FIRE_FLAME, player.getX(), player.getY(), player.getZ(), 100, 0.0, 0.0, 0.0, 0.4);
            serverWorld.spawnParticles(ParticleTypes.SOUL, player.getX(), player.getY(), player.getZ(), 100, 0.0, 0.0, 0.0, 0.4);


            Vec3d lookVector = player.getRotationVec(1.0f);
            Vec3d shootVector = player.getCameraPosVec(1.0F).add(lookVector.multiply(DISTANCE));

            int numberOfParticles = 60;

            Vec3d step = shootVector.subtract(player.getCameraPosVec(1.0F)).multiply(1.0 / numberOfParticles);

            for (int i = 0; i < numberOfParticles; i++) {
                double posX = player.getX() + i * step.x;
                double posY = player.getY() + i * step.y;
                double posZ = player.getZ() + i * step.z;
                serverWorld.spawnParticles(ParticleTypes.SONIC_BOOM, posX, posY + YADJUST, posZ, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.SCULK_CHARGE_POP, posX, posY  + YADJUST, posZ, 1, 0.0, 0.0, 0.0, 0.0);
            }

            for (int i = 0; i < 50; i++) {
                player.playSound(SoundEvents.ENTITY_WARDEN_DEATH, SoundCategory.PLAYERS, 10, 1);

            }


            Box area = new Box(player.getX(), player.getY() + YADJUST, player.getZ(), shootVector.x, shootVector.y + YADJUST, shootVector.z);

            serverWorld.getEntitiesByClass(LivingEntity.class, area, entity -> true).forEach(entity -> {
                if (entity instanceof LivingEntity) {
                    applyDamageAndEffect((LivingEntity) entity, DAMAGE);
                }
            });
        }
    }
}
