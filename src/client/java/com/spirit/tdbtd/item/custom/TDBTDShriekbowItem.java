/*
 * Decompiled with CFR 0.1.1 (FabricMC 57d88659).
 */
package com.spirit.tdbtd.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundEvents;

import java.util.function.Predicate;

public class TDBTDShriekbowItem
        extends RangedWeaponItem
        implements Vanishable {
    private static final String CHARGED_KEY = "Charged";
    private static final String CHARGED_PROJECTILES_KEY = "ChargedProjectiles";
    private static final int field_30866 = 25;
    public static final int RANGE = 8;
    private boolean charged = false;
    private boolean loaded = false;
    private static final float field_30867 = 0.2f;
    private static final float field_30868 = 0.5f;
    private static final float field_30869 = 3.15f;
    private static final float field_30870 = 1.6f;

    public TDBTDShriekbowItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), attacker);
        target.setSwimming(true);
        target.setVelocity(0, -0.1, 0);
        target.playSound(SoundEvents.ENTITY_PLAYER_BREATH, 1.0f, 0.6f);
        target.playSound(SoundEvents.ENTITY_WARDEN_ATTACK_IMPACT, 0.5f, 2f);
        target.playSound(SoundEvents.BLOCK_SCULK_CATALYST_BLOOM, 1.0f, 0.2f);
        target.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, 1.0f, 1);
        target.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1.0f, 1);
        target.playSound(SoundEvents.ENCHANT_THORNS_HIT, 1.0f, 1);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0), attacker);
        return super.postHit(stack, target, attacker);
    }
    @Override
    public Predicate<ItemStack> getHeldProjectiles() {
        return CROSSBOW_HELD_PROJECTILES;
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }


    /*TEMP*/
    @Override
    public int getRange() {
        return 0;
    }

    /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (TDBTDShriekbowItem.isCharged(itemStack)) {
            TDBTDShriekbowItem.shootAll(world, user, hand, itemStack, TDBTDShriekbowItem.getSpeed(itemStack), 1.0f);
            TDBTDShriekbowItem.setCharged(itemStack, false);
            return TypedActionResult.consume(itemStack);
        }
        if (!user.getArrowType(itemStack).isEmpty()) {
            if (!TDBTDShriekbowItem.isCharged(itemStack)) {
                this.charged = false;
                this.loaded = false;
                user.setCurrentHand(hand);
            }
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    private static float getSpeed(ItemStack stack) {
        if (TDBTDShriekbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET)) {
            return 1.6f;
        }
        return 3.15f;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int i = this.getMaxUseTime(stack) - remainingUseTicks;
        float f = TDBTDShriekbowItem.getPullProgress(i, stack);
        if (f >= 1.0f && !TDBTDShriekbowItem.isCharged(stack) && TDBTDShriekbowItem.loadProjectiles(user, stack)) {
            TDBTDShriekbowItem.setCharged(stack, true);
            SoundCategory soundCategory = user instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WARDEN_LISTENING_ANGRY, soundCategory, 1.0f, 0.6f / (world.getRandom().nextFloat() * 0.5f + 1.0f) + 0.2f);
        }
    }

    private static boolean loadProjectiles(LivingEntity shooter, ItemStack projectile) {
        int i = EnchantmentHelper.getLevel(Enchantments.MULTISHOT, projectile);
        int j = i == 0 ? 1 : 3;
        boolean bl = shooter instanceof PlayerEntity && ((PlayerEntity) shooter).getAbilities().creativeMode;
        ItemStack itemStack = shooter.getArrowType(projectile);
        ItemStack itemStack2 = itemStack.copy();
        for (int k = 0; k < j; ++k) {
            if (k > 0) {
                itemStack = itemStack2.copy();
            }
            if (itemStack.isEmpty() && bl) {
                itemStack = new ItemStack(Items.ARROW);
                itemStack2 = itemStack.copy();
            }
            if (TDBTDShriekbowItem.loadProjectile(shooter, projectile, itemStack, k > 0, bl)) continue;
            return false;
        }
        return true;
    }

    private static boolean loadProjectile(LivingEntity shooter, ItemStack crossbow, ItemStack projectile, boolean simulated, boolean creative) {
        ItemStack itemStack;
        boolean bl;
        if (projectile.isEmpty()) {
            return false;
        }
        boolean bl2 = bl = creative && projectile.getItem() instanceof ArrowItem;
        if (!(bl || creative || simulated)) {
            itemStack = projectile.split(1);
            if (projectile.isEmpty() && shooter instanceof PlayerEntity) {
                ((PlayerEntity) shooter).getInventory().removeOne(projectile);
            }
        } else {
            itemStack = projectile.copy();
        }
        TDBTDShriekbowItem.putProjectile(crossbow, itemStack);
        return true;
    }

    public static boolean isCharged(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        return nbtCompound != null && nbtCompound.getBoolean(CHARGED_KEY);
    }

    public static void setCharged(ItemStack stack, boolean charged) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putBoolean(CHARGED_KEY, charged);
    }

    private static void putProjectile(ItemStack crossbow, ItemStack projectile) {
        NbtCompound nbtCompound = crossbow.getOrCreateNbt();
        NbtList nbtList = nbtCompound.contains(CHARGED_PROJECTILES_KEY, NbtElement.LIST_TYPE) ? nbtCompound.getList(CHARGED_PROJECTILES_KEY, NbtElement.COMPOUND_TYPE) : new NbtList();
        NbtCompound nbtCompound2 = new NbtCompound();
        projectile.writeNbt(nbtCompound2);
        nbtList.add(nbtCompound2);
        nbtCompound.put(CHARGED_PROJECTILES_KEY, nbtList);
    }

    private static List<ItemStack> getProjectiles(ItemStack crossbow) {
        NbtList nbtList;
        ArrayList<ItemStack> list = Lists.newArrayList();
        NbtCompound nbtCompound = crossbow.getNbt();
        if (nbtCompound != null && nbtCompound.contains(CHARGED_PROJECTILES_KEY, NbtElement.LIST_TYPE) && (nbtList = nbtCompound.getList(CHARGED_PROJECTILES_KEY, NbtElement.COMPOUND_TYPE)) != null) {
            for (int i = 0; i < nbtList.size(); ++i) {
                NbtCompound nbtCompound2 = nbtList.getCompound(i);
                list.add(ItemStack.fromNbt(nbtCompound2));
            }
        }
        return list;
    }

    private static void clearProjectiles(ItemStack crossbow) {
        NbtCompound nbtCompound = crossbow.getNbt();
        if (nbtCompound != null) {
            NbtList nbtList = nbtCompound.getList(CHARGED_PROJECTILES_KEY, NbtElement.LIST_TYPE);
            nbtList.clear();
            nbtCompound.put(CHARGED_PROJECTILES_KEY, nbtList);
        }
    }

    public static boolean hasProjectile(ItemStack crossbow, Item projectile) {
        return TDBTDShriekbowItem.getProjectiles(crossbow).stream().anyMatch(s -> s.isOf(projectile));
    }

    private static void shoot(World world, LivingEntity shooter, Hand hand, ItemStack crossbow, ItemStack projectile, float soundPitch, boolean creative, float speed, float divergence, float simulated) {
        ProjectileEntity projectileEntity;
        if (world.isClient) {
            return;
        }
        boolean bl = projectile.isOf(Items.SCULK);
        if (bl) {
            projectileEntity = new FireworkRocketEntity(world, projectile, shooter, shooter.getX(), shooter.getEyeY() - (double) 0.15f, shooter.getZ(), true);
        } else {
            projectileEntity = TDBTDShriekbowItem.createArrow(world, shooter, crossbow, projectile);
            if (creative || simulated != 0.0f) {
                ((PersistentProjectileEntity) projectileEntity).pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
        }
        if (shooter instanceof CrossbowUser) {
            CrossbowUser crossbowUser = (CrossbowUser) ((Object) shooter);
            crossbowUser.shoot(crossbowUser.getTarget(), crossbow, projectileEntity, simulated);
        } else {
            Vec3d vec3d = shooter.getOppositeRotationVector(1.0f);
            Quaternion quaternion = new Quaternion(new Vec3f(vec3d), simulated, true);
            Vec3d vec3d2 = shooter.getRotationVec(1.0f);
            Vec3f vec3f = new Vec3f(vec3d2);
            vec3f.rotate(quaternion);
            projectileEntity.setVelocity(vec3f.getX(), vec3f.getY(), vec3f.getZ(), speed, divergence);
        }
        crossbow.damage(bl ? 3 : 1, shooter, e -> e.sendToolBreakStatus(hand));
        world.spawnEntity(projectileEntity);
        world.playSound(null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.BLOCK_SCULK_CATALYST_BLOOM, SoundCategory.PLAYERS, 1f, 0.6f);
    }

    private static PersistentProjectileEntity createArrow(World world, LivingEntity entity, ItemStack crossbow, ItemStack arrow) {
        ArrowItem arrowItem = (ArrowItem) (arrow.getItem() instanceof ArrowItem ? arrow.getItem() : Items.ARROW);
        PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, arrow, entity);
        if (entity instanceof PlayerEntity) {
            persistentProjectileEntity.setCritical(true);
        }
        persistentProjectileEntity.setSound(SoundEvents.ENTITY_WARDEN_ROAR);
        persistentProjectileEntity.setShotFromCrossbow(true);
        int i = EnchantmentHelper.getLevel(Enchantments.PIERCING, crossbow);
        if (i > 0) {
            persistentProjectileEntity.setPierceLevel((byte) i);
        }
        return persistentProjectileEntity;
    }

    public static void shootAll(World world, LivingEntity entity, Hand hand, ItemStack stack, float speed, float divergence) {
        List<ItemStack> list = TDBTDShriekbowItem.getProjectiles(stack);
        float[] fs = TDBTDShriekbowItem.getSoundPitches(entity.getRandom());
        for (int i = 0; i < list.size(); ++i) {
            boolean bl;
            ItemStack itemStack = list.get(i);
            boolean bl2 = bl = entity instanceof PlayerEntity && ((PlayerEntity) entity).getAbilities().creativeMode;
            if (itemStack.isEmpty()) continue;
            if (i == 0) {
                TDBTDShriekbowItem.shoot(world, entity, hand, stack, itemStack, fs[i], bl, 0.1f, divergence, 0.0f);
                continue;
            }
        }
        TDBTDShriekbowItem.postShoot(world, entity, stack);
    }

    private static float[] getSoundPitches(Random random) {
        boolean bl = random.nextBoolean();
        return new float[]{1.0f, TDBTDShriekbowItem.getSoundPitch(bl, random), TDBTDShriekbowItem.getSoundPitch(!bl, random)};
    }

    private static float getSoundPitch(boolean flag, Random random) {
        float f = flag ? 0.63f : 0.43f;
        return 1.0f / (random.nextFloat() * 0.5f + 1.8f) + f;
    }

    private static void postShoot(World world, LivingEntity entity, ItemStack stack) {
        if (entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) entity;
            if (!world.isClient) {
                Criteria.SHOT_CROSSBOW.trigger(serverPlayerEntity, stack);
            }
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
        }
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
            SoundEvent soundEvent = this.getQuickChargeSound(i);
            SoundEvent soundEvent2 = i == 0 ? SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK : null;
            float f = (float) (stack.getMaxUseTime() - remainingUseTicks) / (float) TDBTDShriekbowItem.getPullTime(stack);
            if (f < 0.9f) {
                this.charged = false;
                this.loaded = false;
            }
            if (f >= 0.2f && !this.charged) {
                this.charged = true;
                world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, SoundCategory.PLAYERS, 0.5f, 0.6f);
            }
            if (f >= 0.9f && soundEvent2 != null && !this.loaded) {
                this.loaded = true;
                world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent2, SoundCategory.PLAYERS, 0.5f, 0.8f);
            }
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return TDBTDShriekbowItem.getPullTime(stack) + 100;
    }

    public static int getPullTime(ItemStack stack) {
        int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
        return i == 0 ? 25 : 25 - 5 * i;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    private SoundEvent getQuickChargeSound(int stage) {
        switch (stage) {
            case 1: {
                return SoundEvents.ENTITY_WARDEN_TENDRIL_CLICKS;
            }
            case 2: {
                return SoundEvents.BLOCK_SCULK_SENSOR_CLICKING;
            }
            case 3: {
                return SoundEvents.BLOCK_SCULK_SENSOR_CLICKING_STOP;
            }
        }
        return SoundEvents.BLOCK_SCULK_CATALYST_BLOOM;
    }

    private static float getPullProgress(int useTicks, ItemStack stack) {
        float f = (float) useTicks / 100.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Stand still and Hold Right Click for 5 Seconds, Then Release").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("Stand still and Hold Right Click for 5 Seconds, Then Release").formatted(Formatting.GRAY));

            if (!CrossbowItem.isCharged(stack))
                tooltip.add(Text.literal("Info: [ Not Loaded ]").formatted(Formatting.GRAY));

            if (CrossbowItem.isCharged(stack))
                tooltip.add(Text.literal("Info: [ Loaded ]").formatted(Formatting.GRAY));
            }
            super.appendTooltip(stack, world, tooltip, context);
        }

    @Override
    public boolean isUsedOnRelease(ItemStack stack) {
        return stack.isOf(this);
    }

    @Override
    public int getRange() {
        return 8;
    }

     */
}

