package com.spirit.shit.common;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
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

import java.util.Objects;

public abstract class GunProjectileEntity extends ProjectileEntity {
    private byte[] flags = new byte[3]; // Will hold flags in the future
    private boolean CRITICAL_FLAG = false;
    private static final float WATER_DRAG = 0.6f;
    private double damage;
    private String potionEffect; // Will hold the potion effect in the future
    private SoundEvent sound = this.getHitSound();
    private short life;


    public GunProjectileEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public void setFlags(byte[] flags) {
        this.flags = flags;
    }

    public void setPotionEffect(String potionEffect) {
        this.potionEffect = potionEffect;
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
    public void setVelocity(double x, double y, double z, float speed, float divergence) {
        super.setVelocity(x, y, z, speed, divergence);
        this.life = 0;
    }

    @Override
    public void setVelocityClient(double x, double y, double z) {
        super.setVelocityClient(x, y, z);
        this.life = 0;
    }

    @Override
    public void tick() {
        Vec3d vec3d2;
        VoxelShape voxelShape;
        super.tick();
        boolean noClip = this.isNoClip();
        Vec3d vec3d = this.getVelocity();
        if (this.prevPitch == 0.0f && this.prevYaw == 0.0f) {
            double d = vec3d.horizontalLength();
            //noinspection SuspiciousNameCombination
            this.setYaw((float)(MathHelper.atan2(vec3d.x, vec3d.z) * 57.2957763671875));
            this.setPitch((float)(MathHelper.atan2(vec3d.y, d) * 57.2957763671875));
            this.prevYaw = this.getYaw();
            this.prevPitch = this.getPitch();
        }
        BlockPos blockPos = this.getBlockPos();
        BlockState blockState = this.getWorld().getBlockState(blockPos);
        if (!(blockState.isAir() || noClip || (voxelShape = blockState.getCollisionShape(this.getWorld(), blockPos)).isEmpty())) {
            vec3d2 = this.getPos();
            for (Box box : voxelShape.getBoundingBoxes()) {
                if (!box.offset(blockPos).contains(vec3d2)) continue;
                this.discard();
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
                @SuppressWarnings("DataFlowIssue") Entity entity = ((EntityHitResult)hitResult).getEntity();
                Entity entity2 = this.getOwner();
                if (entity instanceof PlayerEntity && entity2 instanceof PlayerEntity && !((PlayerEntity)entity2).shouldDamagePlayer((PlayerEntity)entity)) {
                    hitResult = null;
                    entityHitResult = null;
                }
            }
            if (hitResult != null && !noClip) {
                this.onCollision(hitResult);
                this.velocityDirty = true;
            }
            if (entityHitResult == null) break;
            hitResult = null;
        }
        vec3d = this.getVelocity();
        double vX = vec3d.x;
        double vY = vec3d.y;
        double vZ = vec3d.z;
        if (this.isCritical()) {
            for (int i = 0; i < 4; ++i) {
                this.getWorld().addParticle(ParticleTypes.CRIT, this.getX() + vX * (double)i / 4.0, this.getY() + vY * (double)i / 4.0, this.getZ() + vZ * (double)i / 4.0, -vX, -vY + 0.2, -vZ);
            }
        }
        double newX = this.getX() + vX;
        double newY = this.getY() + vY;
        double newZ = this.getZ() + vZ;
        double l = vec3d.horizontalLength();
        if (noClip) {
            this.setYaw((float)(MathHelper.atan2(-vX, -vZ) * 57.2957763671875));
        } else {
            //noinspection SuspiciousNameCombination
            this.setYaw((float)(MathHelper.atan2(vX, vZ) * 57.2957763671875));
        }
        this.setPitch((float)(MathHelper.atan2(vY, l) * 57.2957763671875));
        this.setPitch(GunProjectileEntity.updateRotation(this.prevPitch, this.getPitch()));
        this.setYaw(GunProjectileEntity.updateRotation(this.prevYaw, this.getYaw()));
        float drag = 0.99f;
        float gravity = 0.05f;
        if (this.isTouchingWater()) {
            for (int o = 0; o < 4; ++o) {
                float particlePosModifier = 0.25f;
                this.getWorld().addParticle(ParticleTypes.BUBBLE, newX - vX * particlePosModifier, newY - vY * particlePosModifier, newZ - vZ * particlePosModifier, vX, vY, vZ);
            }
            drag = WATER_DRAG;
        }
        this.setVelocity(vec3d.multiply(drag));
        if (!this.hasNoGravity() && !noClip) {
            Vec3d vec3d4 = this.getVelocity();
            this.setVelocity(vec3d4.x, vec3d4.y - (double) gravity, vec3d4.z);
        }
        this.setPosition(newX, newY, newZ);
        this.checkBlockCollision();
        this.age();
    }

    private boolean shouldFall() {
        return this.getWorld().isSpaceEmpty(new Box(this.getPos(), this.getPos()).expand(0.06));
    }

    private void fall() {
        Vec3d vec3d = this.getVelocity();
        float AIR_DRAG = 0.2f;
        this.setVelocity(vec3d.multiply(this.random.nextFloat() * AIR_DRAG, this.random.nextFloat() * AIR_DRAG, this.random.nextFloat() * AIR_DRAG));
        this.life = 0;
    }

    @Override
    public void move(MovementType movementType, Vec3d movement) {
        super.move(movementType, movement);
        if (movementType != MovementType.SELF && this.shouldFall()) {
            this.fall();
        }
    }

    protected void age() {
        ++this.life;
        if (this.life >= 1200) {
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        DamageSource damageSource;
        Entity owner = this.getOwner();
        super.onEntityHit(entityHitResult);
        Entity hitEntity = entityHitResult.getEntity();
        float velocityDamageModifier = 1; //(float)this.getVelocity().length();
        int damage = MathHelper.ceil(MathHelper.clamp((double) velocityDamageModifier * this.damage, 0.0, 2.147483647E9));

        if (this.isCritical()) {
            long l = this.random.nextInt(damage / 2 + 2);
            damage = (int)Math.min(l + (long) damage, Integer.MAX_VALUE);
        }

        // NEEDS TO BE UPDATED w/ NEW DAMAGE SOURCES WHEN IMPLEMENTED
        if (owner == null) {
            // If the owner is null, set damageSource to generic
            damageSource = this.getDamageSources().generic();
        } else {
            // If the owner is not null, set damageSource to generic
            damageSource = this.getDamageSources().generic();

            // Check if the owner is an instance of LivingEntity & cast it to one
            if (owner instanceof LivingEntity livingEntity) {
                // Call the onAttacking method
                livingEntity.onAttacking(hitEntity);
            }
        }

        boolean isEnderman = hitEntity.getType() == EntityType.ENDERMAN;

        if (this.isOnFire() && !isEnderman) {
            hitEntity.setOnFireFor(5);
        }

        if (hitEntity.damage(damageSource, damage)) {
            if (isEnderman) {
                return;
            }

            if (hitEntity instanceof LivingEntity hitLivingEntity) {
                if (!this.getWorld().isClient && owner instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(hitLivingEntity, owner);
                    EnchantmentHelper.onTargetDamaged((LivingEntity) owner, hitLivingEntity);
                }

                this.onHit(entityHitResult);

                // If hit entity isn't the owner & is a player & the owner is a server player & the arrow isn't silent, make noises.
                if (hitLivingEntity != owner && hitLivingEntity instanceof PlayerEntity && owner instanceof ServerPlayerEntity && !this.isSilent()) {
                    ((ServerPlayerEntity) owner).networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.PROJECTILE_HIT_PLAYER, GameStateChangeS2CPacket.DEMO_OPEN_SCREEN));
                }
            }
            this.playSound(this.sound, 1.0f, 1.2f / (this.random.nextFloat() * 0.2f + 0.9f));
            this.discard();
        } else {
            // Discard if it didn't damage the entity
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        // Just discard for now
        this.discard();
    }

    @SuppressWarnings("SameReturnValue")
    protected SoundEvent getHitSound() { // Spirit, replace this w/ your sound.
        return SoundEvents.ENTITY_ARROW_HIT;
    }

    protected void onHit(HitResult hitResult) {
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            Entity entity = ((EntityHitResult) hitResult).getEntity();
            if (entity instanceof LivingEntity livingEntity) {
                int duration = 400; // default duration in ticks (20 seconds)

                // Handle extended duration flag
                if (flags[2] != 0) { // hasExtendedDuration
                    duration = 800; // extended duration in ticks (40 seconds)
                }

                // Handle incendiary flag
                if (flags[0] != 0) { // isIncendiary
                    livingEntity.setOnFireFor(5);
                }

                // Handle explosive flag and area effect clouds
                if (flags[1] != 0) { // isExplosive
                    // Create an explosion at the entity's location
                    entity.getWorld().createExplosion(null,
                            entity.getX(),
                            entity.getY(),
                            entity.getZ(),
                            2.0F,
                            World.ExplosionSourceType.MOB
                    );

                    // Create area effect clouds if a potion effect exists
                    if (potionEffect != null) {
                        StatusEffect effect = Registries.STATUS_EFFECT.get(new Identifier(potionEffect));

                        if (effect != null) {
                            for (int i = -2; i <= 2; i++) {
                                AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(entity.getWorld(), entity.getX(), entity.getY() + i, entity.getZ());
                                cloud.setParticleType(ParticleTypes.AMBIENT_ENTITY_EFFECT); // just an example
                                cloud.addEffect(new StatusEffectInstance(effect, duration, 0));
                                cloud.setRadius(3.0F);
                                cloud.setDuration(duration); // set the cloud duration to match the effect duration
                                entity.getWorld().spawnEntity(cloud);
                            }
                        }
                    }
                }

                // Handle stored potion effect
                if (potionEffect != null) {
                    StatusEffect effect = Registries.STATUS_EFFECT.get(new Identifier(potionEffect));

                    if (effect != null) {
                        // Add the status effect to the entity
                        livingEntity.addStatusEffect(new StatusEffectInstance(effect, duration, 0));
                    }
                }

                // Add other conditions and effects here
            }
        }
        // Handle block hits...
    }

    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return ProjectileUtil.getEntityCollision(this.getWorld(), this, currentPosition, nextPosition, this.getBoundingBox().stretch(this.getVelocity()).expand(1.0), this::canHit);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putShort("life", this.life);
        nbt.putDouble("damage", this.damage);
        nbt.putBoolean("crit", this.isCritical());
        nbt.putString("SoundEvent", Objects.requireNonNull(Registries.SOUND_EVENT.getId(this.sound)).toString());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.life = nbt.getShort("life");
        this.setCritical(nbt.getBoolean("crit"));
        if (nbt.contains("damage", NbtElement.NUMBER_TYPE)) { this.damage = nbt.getDouble("damage"); }

        if (nbt.contains("SoundEvent", NbtElement.STRING_TYPE)) {
            this.sound = Registries.SOUND_EVENT.getOrEmpty(new Identifier(nbt.getString("SoundEvent"))).orElse(this.getHitSound());
        }
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        if (this.getWorld().isClient) {
            return;
        }
        if (!this.isOwner(player))
            this.discard();
    }

    @Override
    protected Entity.MoveEffect getMoveEffect() {
        return Entity.MoveEffect.NONE; // Spirit, replace w/ whatever effect you want to use.
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
        this.CRITICAL_FLAG = critical;
    }

    public boolean isCritical() {
        return this.CRITICAL_FLAG;
    }

    public boolean isNoClip() {
        return this.noClip;
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

    @Override
    protected void initDataTracker() {

    }
}