package com.spirit.shit.common;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.*;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class GunProjectileEntity extends ProjectileEntity {
    private final byte[] flags = new byte[3];
    private static final TrackedData<Byte> PROJECTILE_FLAGS = DataTracker.registerData(GunProjectileEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> PIERCE_LEVEL = DataTracker.registerData(GunProjectileEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final int CRITICAL_FLAG = 1;
    private double damage;
    private String potionEffect;

    private SoundEvent sound = this.getHitSound();

    protected GunProjectileEntity(EntityType<? extends GunProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public void setSound(SoundEvent sound) {
            this.sound = sound;
        }

        @Override
        public boolean shouldRender(double distance) {
            double d = this.getBoundingBox().getAverageSideLength() * 10.0;
            if (Double.isNaN(d)) {
                d = 1.0;
            }
            return distance < (d *= 64.0 * GunProjectileEntity.getRenderDistanceMultiplier()) * d;
        }

        @Override
        protected void initDataTracker() {
            this.dataTracker.startTracking(PROJECTILE_FLAGS, (byte)0);
            this.dataTracker.startTracking(PIERCE_LEVEL, (byte)0);
        }

        @Override
        public void setVelocity(double x, double y, double z, float speed, float divergence) {
            super.setVelocity(x, y, z, speed, divergence);
        }

        @Override
        public void setVelocityClient(double x, double y, double z) {
            super.setVelocityClient(x, y, z);
        }

        @Override
        public void tick() {
            Vec3d vec3d2;
            VoxelShape voxelShape;
            super.tick();
            Vec3d vec3d = this.getVelocity();
            if (this.prevPitch == 0.0f && this.prevYaw == 0.0f) {
                double d = vec3d.horizontalLength();
                this.setYaw((float)(MathHelper.atan2(vec3d.x, vec3d.z) * 57.2957763671875));
                this.setPitch((float)(MathHelper.atan2(vec3d.y, d) * 57.2957763671875));
                this.prevYaw = this.getYaw();
                this.prevPitch = this.getPitch();
            }
            BlockPos blockPos = this.getBlockPos();
            BlockState blockState = this.getWorld().getBlockState(blockPos);
            if (!(blockState.isAir() || (voxelShape = blockState.getCollisionShape(this.getWorld(), blockPos)).isEmpty())) {
                vec3d2 = this.getPos();
                for (Box box : voxelShape.getBoundingBoxes()) {
                    if (!box.offset(blockPos).contains(vec3d2)) continue;
                    break;
                }
            }

            if (this.isTouchingWaterOrRain() || blockState.isOf(Blocks.POWDER_SNOW)) {
                this.extinguish();
            }

            Vec3d vec3d3 = this.getPos();
            vec3d2 = vec3d3.add(vec3d);
            HitResult hitResult = this.getWorld().raycast(new RaycastContext(vec3d3, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this));
            if (hitResult.getType() != HitResult.Type.MISS) {
                vec3d2 = hitResult.getPos();
            }
            while (!this.isRemoved()) {
                EntityHitResult entityHitResult = this.getEntityCollision(vec3d3, vec3d2);
                if (entityHitResult != null) {
                    hitResult = entityHitResult;
                }
                if (hitResult != null && hitResult.getType() == HitResult.Type.ENTITY) {
                    assert hitResult instanceof EntityHitResult;
                    Entity entity = ((EntityHitResult)hitResult).getEntity();
                    Entity entity2 = this.getOwner();
                    if (entity instanceof PlayerEntity && entity2 instanceof PlayerEntity && !((PlayerEntity)entity2).shouldDamagePlayer((PlayerEntity)entity)) {
                        hitResult = null;
                        entityHitResult = null;
                    }
                }
                if (hitResult != null) {
                    this.onCollision(hitResult);
                    this.velocityDirty = true;
                }
                if (entityHitResult == null) break;
                hitResult = null;
            }
            vec3d = this.getVelocity();
            double e = vec3d.x;
            double f = vec3d.y;
            double g = vec3d.z;
            if (this.isCritical()) {
                for (int i = 0; i < 4; ++i) {
                    this.getWorld().addParticle(ParticleTypes.CRIT, this.getX() + e * (double)i / 4.0, this.getY() + f * (double)i / 4.0, this.getZ() + g * (double)i / 4.0, -e, -f + 0.2, -g);
                }
            }
            double h = this.getX() + e;
            double j = this.getY() + f;
            double k = this.getZ() + g;
            double l = vec3d.horizontalLength();
            this.setYaw((float)(MathHelper.atan2(e, g) * 57.2957763671875));
            this.setPitch((float)(MathHelper.atan2(f, l) * 57.2957763671875));
            this.setPitch(GunProjectileEntity.updateRotation(this.prevPitch, this.getPitch()));
            this.setYaw(GunProjectileEntity.updateRotation(this.prevYaw, this.getYaw()));
            float m = 0.99f;
            if (this.isTouchingWater()) {
                for (int o = 0; o < 4; ++o) {
                    this.getWorld().addParticle(ParticleTypes.BUBBLE, h - e * 0.25, j - f * 0.25, k - g * 0.25, e, f, g);
                }
                m = this.getDragInWater();
            }
            this.setVelocity(vec3d.multiply(m));
            if (!this.hasNoGravity()) {
                Vec3d vec3d4 = this.getVelocity();
                this.setVelocity(vec3d4.x, vec3d4.y - (double)0.05f, vec3d4.z);
            }
            this.setPosition(h, j, k);
            this.checkBlockCollision();
        }

        @Override
        public void move(MovementType movementType, Vec3d movement) {
            super.move(movementType, movement);
        }

        @Override
        protected void onEntityHit(EntityHitResult entityHitResult) {
            DamageSource damageSource;
            LivingEntity owner = (LivingEntity) this.getOwner();
            super.onEntityHit(entityHitResult);
            Entity hitEntity = entityHitResult.getEntity();
            float f = (float)this.getVelocity().length();
            int i = MathHelper.ceil(MathHelper.clamp((double)f * this.damage, 0.0, 2.147483647E9));
            boolean isEnderman = hitEntity.getType() == EntityType.ENDERMAN;
            int fireTicks = hitEntity.getFireTicks();

            if (this.isCritical()) {
                long l = this.random.nextInt(i / 2 + 2);
                i = (int)Math.min(l + (long)i, Integer.MAX_VALUE);
            }

            if (owner == null) {
                damageSource = this.getDamageSources().generic();
            } else {
                damageSource = this.getDamageSources().mobProjectile(this, owner);
                owner.onAttacking(hitEntity);
            }

            if (this.isOnFire() && !isEnderman) {
                hitEntity.setOnFireFor(5);
            }

            if (hitEntity.damage(damageSource, i)) {
                if (isEnderman) {
                    return;
                }

                if (hitEntity instanceof LivingEntity livingEntity) {
                    this.onHit(livingEntity);

                    if (!this.getWorld().isClient && owner != null) {
                        EnchantmentHelper.onUserDamaged(livingEntity, owner);
                        EnchantmentHelper.onTargetDamaged(owner, livingEntity);
                    }

                    if (livingEntity != owner && livingEntity instanceof PlayerEntity && owner instanceof ServerPlayerEntity && !this.isSilent()) {
                        ((ServerPlayerEntity) owner).networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.PROJECTILE_HIT_PLAYER, GameStateChangeS2CPacket.DEMO_OPEN_SCREEN));
                    }
                }

                this.playSound(this.sound, 1.0f, 1.2f / (this.random.nextFloat() * 0.2f + 0.9f));
            } else {
                hitEntity.setFireTicks(fireTicks);
            }
        }

        void onHit(LivingEntity entity) {

        }

        @Override
        protected void onBlockHit(BlockHitResult blockHitResult) {
            super.onBlockHit(blockHitResult);
            this.playSound(this.getSound(), 1.0f, 1.2f / (this.random.nextFloat() * 0.2f + 0.9f));
            this.setCritical(false);
            this.setSound(SoundEvents.ENTITY_ARROW_HIT);
            this.kill();
        }

        @SuppressWarnings("SameReturnValue")
        protected SoundEvent getHitSound() {
            return SoundEvents.ENTITY_ARROW_HIT;
        }

        protected final SoundEvent getSound() {
            return this.sound;
        }

    @Nullable
        protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
            return ProjectileUtil.getEntityCollision(this.getWorld(), this, currentPosition, nextPosition, this.getBoundingBox().stretch(this.getVelocity()).expand(1.0), this::canHit);
        }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putDouble("BulletDamage", damage);
        NbtList flagList = new NbtList();
        for (byte flag : flags) {
            flagList.add(NbtByte.of(flag));
        }
        tag.put("Flags", flagList);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        damage = tag.getDouble("BulletDamage");
        NbtList flagList = tag.getList("Flags", 1); // 1 is the type ID for ByteTag
        for (int i = 0; i < Math.min(flagList.size(), 3); i++) { // Updated to match new flag length
            flags[i] = ((NbtByte) flagList.get(i)).byteValue(); // Cast to ByteTag and then get byte
        }
    }

        @Override
        protected Entity.MoveEffect getMoveEffect() {
            return Entity.MoveEffect.NONE;
        }

        public void setDamage(double damage) {
            this.damage = damage;
        }

        public double getDamage() {
            return this.damage;
        }

        @Override
        public boolean isAttackable() {
            return false;
        }

        @Override
        protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
            return 0.13f;
        }

        public void setCritical(boolean critical) {
            this.setProjectileFlag(critical);
        }
        private void setProjectileFlag(boolean flag) {
            byte b = this.dataTracker.get(PROJECTILE_FLAGS);
            if (flag) {
                this.dataTracker.set(PROJECTILE_FLAGS, (byte)(b | GunProjectileEntity.CRITICAL_FLAG));
            } else {
                this.dataTracker.set(PROJECTILE_FLAGS, (byte)(b & ~GunProjectileEntity.CRITICAL_FLAG));
            }
        }

        public boolean isCritical() {
            byte b = this.dataTracker.get(PROJECTILE_FLAGS);
            return (b & 1) != 0;
        }

        @SuppressWarnings("SameReturnValue")
        protected float getDragInWater() {
            return 0.6f;
        }

    public int getColor() {
        if (potionEffect == null) {
            return 0xFFFFFF; // Default color if no potion effect is set, white in this case
        }
        try {
            Identifier id = new Identifier(potionEffect);
            StatusEffect effect = Registries.STATUS_EFFECT.get(id);

            if (effect == null) {
                return 0xFFFFFF; // Default color if the effect was not found
            }

            return effect.getColor();
        } catch (Exception e) {
            // Handle exceptions such as invalid identifiers
            return 0xFFFFFF; // Default color if an exception occurs
        }
    }
}