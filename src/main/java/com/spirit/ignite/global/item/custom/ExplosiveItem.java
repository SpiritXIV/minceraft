package com.spirit.ignite.global.item.custom;

import com.spirit.ignite.IgniteMod;
import com.spirit.ignite.global.entity.damage.DamageTypes;
import com.spirit.ignite.global.item.IgniteItems;
import com.spirit.ignite.global.particle.IgniteParticles;
import com.spirit.ignite.global.sound.IgniteSounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.explosion.ExplosionBehavior;

import java.util.*;

import static com.spirit.ignite.global.item.custom.ExplosiveItem.SoundType.DETONATE;
import static com.spirit.ignite.global.item.custom.ExplosiveItem.SoundType.PINPULL;

public abstract class ExplosiveItem extends Item {
    protected static long EXPLOSION_DELAY = 5000; // 5 seconds in milliseconds
    protected static float DAMAGE = 10F;
    protected static int POWER = 3;
    protected static int COOLDOWN = 60;
    protected static int COUNTDOWNTICKS = 100;
    protected static Item ITEM;

    protected static SoundEvent DETONATE_SOUND = IgniteSounds.BULLET_IMPACT;
    protected static SoundEvent PINPULL_SOUND = IgniteSounds.PIN_PULL;



    private static final Map<UUID, Boolean> PIN_PULLED_MAP = new HashMap<>();

    public enum SoundType {
        DETONATE,
        PINPULL
    }

    public ExplosiveItem(Settings settings, long explosion_delay, int damage, int power, int cooldown, int countdownticks, Item item) {
        super(settings);
        EXPLOSION_DELAY = explosion_delay;
        DAMAGE = damage;
        POWER = power;
        COOLDOWN = cooldown;
        COUNTDOWNTICKS = countdownticks;
        ITEM = item;
    }

    private void playSound(PlayerEntity player, SoundType type) {
        SoundEvent sound = null;
        switch (type) {
            case DETONATE -> sound = DETONATE_SOUND;
            case PINPULL -> sound = PINPULL_SOUND;
        }

        player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundCategory.PLAYERS, 1F, 1F);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        UUID playerId = player.getUuid();

        if (!world.isClient) {
            if (PIN_PULLED_MAP.getOrDefault(playerId, false)) {
                spawnExplosive(world, player, stack);
                player.getItemCooldownManager().set(this, COOLDOWN);
                PIN_PULLED_MAP.put(playerId, false);
            } else {
                this.playSound(player, PINPULL);
                PIN_PULLED_MAP.put(playerId, true);
                scheduleExplosion(world, player, stack);
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }

    private void scheduleExplosion(World world, PlayerEntity player, ItemStack stack) {
        Timer timer = new Timer();
        UUID playerId = player.getUuid();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (PIN_PULLED_MAP.getOrDefault(playerId, false)) {
                    if (stack.isOf(IgniteItems.GRENADE)) {
                        world.createExplosion(player, player.getX(), player.getY(), player.getZ(), POWER, World.ExplosionSourceType.MOB);
                        player.damage(DamageTypes.of(world, DamageTypes.BLEW_SELF), DAMAGE);
                    }
                    if (stack.isOf(IgniteItems.INCGRENADE) || stack.isOf(IgniteItems.PIPE_BOMB)) {
                        world.createExplosion(player, player.getX(), player.getY(), player.getZ(), POWER, World.ExplosionSourceType.MOB);
                        player.damage(DamageTypes.of(world, DamageTypes.BLEW_SELF), DAMAGE);
                        player.setOnFireFor(10);
                    }
                    if (stack.isOf(IgniteItems.FLASH_BANG)) {
                        double radius = 5.0;
                        for (Entity entity : player.getWorld().getOtherEntities(null, new Box(player.getX() - radius, player.getY() - radius, player.getZ() - radius, player.getX() + radius, player.getY() + radius, player.getZ() + radius))) {
                            if (entity instanceof PlayerEntity) {
                                ((PlayerEntity) entity).playSound(IgniteSounds.FLASH_BANG_RING, SoundCategory.MASTER, 10F, 1F);
                                player.getWorld().playSound(player.getX(), player.getY(), player.getZ(), SoundEvent.of(SoundEvents.ENTITY_GENERIC_EXPLODE.getId()), SoundCategory.PLAYERS, 1F, 1F, true);
                                spawnFlashBangParticle(entity.getX(), entity.getY(), entity.getZ());
                            }
                        }
                    }

                    PIN_PULLED_MAP.put(playerId, false);
                    player.getItemCooldownManager().set(player.getActiveItem().getItem(), COOLDOWN);
                    if (!player.getAbilities().creativeMode) {
                        stack.decrement(1);
                    }
                }
            }
        }, EXPLOSION_DELAY);
    }

    private void spawnFlashBangParticle(double x, double y, double z) {
        ClientWorld world = MinecraftClient.getInstance().world;
        if (world != null) {
            world.addParticle(IgniteParticles.FLASH_BANG_PARTICLE, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }

    private void spawnExplosive(World world, PlayerEntity player, ItemStack stack) {
        GrenadeEntity grenadeEntity = new GrenadeEntity(world, player);
        grenadeEntity.setItem(stack.copy());
        grenadeEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
        world.spawnEntity(grenadeEntity);
        if (!player.getAbilities().creativeMode) {
            stack.decrement(1);
        }
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (context.isAdvanced()) {
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.literal("[ Stats ]").formatted(Formatting.GRAY));
                tooltip.add(Text.literal("Explosion Delay: " + this.getExplosionDecay()).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("Explosive Damage: " + this.getExplosiveDamage()).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("Explosive Power: " + this.getPower()).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("Cooldown: " + this.getCooldown()).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("Countdown Ticks: " + this.getCountdownTicks()).formatted(Formatting.DARK_GRAY));
            }
        }
    }

    public long getExplosionDecay() {
        return EXPLOSION_DELAY;
    }
    public float getExplosiveDamage() {
        return DAMAGE;
    }
    public int getPower() {
        return POWER;
    }
    public int getCooldown() {
        return COOLDOWN;
    }
    public int getCountdownTicks() {
        return COUNTDOWNTICKS;
    }

    public static class GrenadeEntity extends ThrownItemEntity {
        private final int countdownticks = COUNTDOWNTICKS;

        public GrenadeEntity(EntityType<? extends GrenadeEntity> entityType, World world) {
            super(entityType, world);
        }

        public GrenadeEntity(World world, LivingEntity owner) {
            super(IgniteMod.GrenadeProjectileEntityType, owner, world);
        }

        public GrenadeEntity(World world, double x, double y, double z) {
            super(IgniteMod.GrenadeProjectileEntityType, x, y, z, world);
        }

        protected Item getDefaultItem() {
            return ITEM;
        }

        private ParticleEffect getParticleParameters() {
            ItemStack itemStack = this.getItem();
            return itemStack.isEmpty() ? (ParticleEffect) ParticleTypes.ITEM : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack);
        }

        public void handleStatus(byte status) {
            if (status == 3) {
                ParticleEffect particleEffect = this.getParticleParameters();

                for (int i = 0; i < 8; ++i) {
                    this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
                }
            }
        }

        protected void onCollision(HitResult hitResult) {
            super.onCollision(hitResult);
            if (!this.getWorld().isClient) {
                this.getWorld().sendEntityStatus(this, (byte) 3);
                this.scheduleExplosion(); // Schedule explosion after a delay
                this.discard();
            }
        }

        private void scheduleExplosion() {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    detonate();
                }
            }, countdownticks);
        }

        private void detonate() {
            if (this.getItem().isOf(IgniteItems.GRENADE)) {
                ExplosionBehavior explosionBehavior = new ExplosionBehavior();
                this.getWorld().createExplosion(this, DamageTypes.of(this.getWorld(), DamageTypes.GRENADED), explosionBehavior, this.getX(), this.getY(), this.getZ(), POWER, false, World.ExplosionSourceType.TNT, true);
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvent.of(SoundEvents.ENTITY_GENERIC_EXPLODE.getId()), SoundCategory.PLAYERS, 1F, 1F, true);
                this.playSound(DETONATE);
            } else if (this.getItem().isOf(IgniteItems.INCGRENADE)) {
                ExplosionBehavior explosionBehavior = new ExplosionBehavior();
                this.getWorld().createExplosion(this, DamageTypes.of(this.getWorld(), DamageTypes.GRENADED), explosionBehavior, this.getX(), this.getY(), this.getZ(), POWER, true, World.ExplosionSourceType.TNT, true);
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvent.of(SoundEvents.ENTITY_GENERIC_EXPLODE.getId()), SoundCategory.PLAYERS, 1F, 1F, true);
                this.playSound(DETONATE);
            } else if (this.getItem().isOf(IgniteItems.FLASH_BANG)) {
                double radius = 5.0;
                for (Entity entity : this.getWorld().getOtherEntities(null, new Box(this.getX() - radius, this.getY() - radius, this.getZ() - radius, this.getX() + radius, this.getY() + radius, this.getZ() + radius))) {
                    if (entity instanceof PlayerEntity) {
                        ((PlayerEntity) entity).playSound(IgniteSounds.FLASH_BANG_RING, SoundCategory.MASTER, 10F, 1F);
                        spawnFlashBangParticle(entity.getX(), entity.getY(), entity.getZ());
                    }
                }

                this.playSound(DETONATE);
            } else if (this.getItem().isOf(IgniteItems.PIPE_BOMB)) {
                ExplosionBehavior explosionBehavior = new ExplosionBehavior();
                this.getWorld().createExplosion(this, DamageTypes.of(this.getWorld(), DamageTypes.GRENADED), explosionBehavior, this.getX(), this.getY(), this.getZ(), POWER, false, World.ExplosionSourceType.TNT, true);
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvent.of(SoundEvents.ENTITY_GENERIC_EXPLODE.getId()), SoundCategory.PLAYERS, 1F, 1F, true);
                this.playSound(DETONATE);
            } else if (this.getItem().isOf(IgniteItems.SMOKE_BOMB)) {
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvent.of(SoundEvents.ENTITY_GENERIC_EXPLODE.getId()), SoundCategory.PLAYERS, 1F, 1F, true);
                this.playSound(DETONATE);
            }

            this.damage(DamageTypes.of(this.getWorld(), DamageTypes.GRENADED), DAMAGE);
        }

        private void spawnFlashBangParticle(double x, double y, double z) {
            ClientWorld world = MinecraftClient.getInstance().world;
            if (world != null) {
                world.addParticle(IgniteParticles.FLASH_BANG_PARTICLE, x, y, z, 0.0D, 0.0D, 0.0D);
            }
        }


        private void playSound(SoundType type) {
            SoundEvent sound = null;
            switch (type) {
                case DETONATE -> sound = DETONATE_SOUND;
                case PINPULL -> sound = PINPULL_SOUND;
            }

            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), sound, SoundCategory.PLAYERS, 10F, 1F);
        }
    }
}