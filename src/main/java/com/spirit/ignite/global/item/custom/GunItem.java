package com.spirit.ignite.global.item.custom;

import com.spirit.ignite.data.common.Common;
import com.spirit.ignite.global.entity.damage.DamageTypes;
import com.spirit.ignite.global.item.IgniteItems;
import com.spirit.ignite.global.sound.IgniteSounds;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public abstract class GunItem extends RangedWeaponItem implements Vanishable {
    private long lastFireTick = 0;
    private long lastZoomTick = 0;
    private static final String ITEMS_KEY = "Items";
    private static final int DEFAULT_ITEM_BAR_COLOR = 0xFF0000;
    private static final int RANGE = 100;
    protected int COOLDOWN;
    protected int MAGAZINE_SIZE;
    protected float BULLET_DAMAGE;
    protected int ITEM_BAR_COLOR;
    protected int MAX_RANGE;
    protected int MAX_USE_TIME;
    protected static int ZOOM;
    private final Item[] ALLOWED_TYPES;
    protected static boolean zoom;

    public static boolean isZoom() {
        return zoom;
    }

    public enum SoundType {
        SHOOT,
        RELOAD,
        EMPTY,
        REMOVE_ONE,
        INSERT,
        DROP_CONTENT,
        IMPACT
    }

    protected SoundEvent SHOOT_SOUND = IgniteSounds.BULLET_IMPACT;
    protected SoundEvent RELOAD_SOUND = IgniteSounds.BULLET_IMPACT;
    protected SoundEvent EMPTY_SOUND = IgniteSounds.BULLET_IMPACT;
    protected SoundEvent REMOVE_BULLET_SOUND = SoundEvents.ITEM_BUNDLE_REMOVE_ONE;
    protected SoundEvent INSERT_SOUND = SoundEvents.ITEM_BUNDLE_INSERT;
    protected SoundEvent DROP_CONTENT_SOUND = SoundEvents.ITEM_BUNDLE_DROP_CONTENTS;
    protected SoundEvent IMPACT_SOUND = IgniteSounds.BULLET_IMPACT;
    private static final Random random = new Random();


    public GunItem(Settings settings, int cooldown, int magazineSize, float bulletDamage, int max_range, int max_use_time, int zoomint, Item[] allowedTypes) {
        this(settings, cooldown, magazineSize, DEFAULT_ITEM_BAR_COLOR, bulletDamage, max_range, max_use_time, zoomint, allowedTypes);
    }

    public GunItem(Settings settings, int cooldown, int magazineSize, int itemBarColor, float bulletDamage, int max_range, int max_use_time, int zoomint, Item[] allowedTypes) {
        super(settings);
        this.COOLDOWN = cooldown;
        this.MAGAZINE_SIZE = magazineSize;
        this.ITEM_BAR_COLOR = itemBarColor;
        this.BULLET_DAMAGE = bulletDamage;
        this.MAX_RANGE = max_range;
        this.MAX_USE_TIME = max_use_time;
        ZOOM = zoomint;

        ALLOWED_TYPES = allowedTypes;
    }

    public void handleLeftClick(ItemStack itemStack, PlayerEntity player, World world) {
        this.shoot(itemStack, player, world);
    }

    public void handleRightClick(ItemStack itemStack, PlayerEntity player, World world) {
        long currentTick = world.getTime();
        if (currentTick - lastZoomTick < 20 ) {
            return;
        }
        if (player.isSprinting() || player.isSwimming() || player.isClimbing()) {
            return;
        }
        zoom = !zoom;
        lastZoomTick = currentTick;
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        return TypedActionResult.pass(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return MAX_USE_TIME;
    }
    
    public boolean shouldAim() {
        return true;
    }
    public boolean shouldCancelPunching() {
        return true;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity player)) {
            return;
        }
        int useTime = this.getMaxUseTime(stack) - remainingUseTicks;
        if (useTime < 10) {
            return;
        }

        this.shoot(stack, player, world);
    }

    private void shoot(ItemStack gun, PlayerEntity player, World world) {
        long currentTick = world.getTime();
        if (currentTick - lastFireTick < COOLDOWN) {
            return;
        }

        lastFireTick = currentTick;

        double maxRangeForDamage = MAX_RANGE;

        Vec3d lookDirection = player.getRotationVec(1.0F);
        Vec3d playerPos = player.getCameraPosVec(1.0F);
        int numberOfSteps = MAX_RANGE;
        double stepSize = maxRangeForDamage / numberOfSteps;
        Vec3d endPos = playerPos.add(lookDirection.multiply(maxRangeForDamage));

        for (int i = 0; i < numberOfSteps; i++) {
            Vec3d currentPos = playerPos.add(lookDirection.multiply(stepSize * i));
            //Box collisionBox = new Box(currentPos.getX() - 0.5, currentPos.getY() - 0.5, currentPos.getZ() - 0.5,
            //        currentPos.getX() + 0.5, currentPos.getY() + 0.5, currentPos.getZ() + 0.5);

            if (hasAmmo(gun.getOrCreateNbt())) {
                BlockPos blockPos = new BlockPos((int) currentPos.x, (int) currentPos.y, (int) currentPos.z);
                BlockState blockState = world.getBlockState(blockPos);
                BlockHitResult blockHitResult = world.raycast(new RaycastContext(playerPos, endPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));
                if (blockHitResult.getType() != HitResult.Type.MISS) {
                    endPos = blockHitResult.getPos();
                }
            }
        }

        Box collisionBox = new Box(playerPos, endPos);
        for (Entity entity : world.getEntitiesByClass(Entity.class, collisionBox, entity -> entity != player)) {
            if (entity instanceof LivingEntity && hasAmmo(gun.getOrCreateNbt())) {
                if (!entity.isInvulnerable()) {
                    entity.damage(DamageTypes.of(world, DamageTypes.SHOT), BULLET_DAMAGE);
                    player.tryAttack(entity);
                    List<Item> allowedBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("bullet"));
                    List<Item> allowedRifleBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("rifle_bullet"));
                    List<Item> allowedHighCaliberBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("high_caliber_bullet"));
                    List<Item> allowedSlugTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("slug"));
                    List<Item> allowedShellTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("shell"));
                    List<Item> allowedIncendiaryBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("bullet_incendiary"));
                    List<Item> allowedIncendiaryRifleBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("rifle_bullet_incendiary"));
                    List<Item> allowedIncendiaryHighCaliberBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("high_caliber_bullet_incendiary"));
                    List<Item> allowedIncendiarySlugBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("slug_incendiary"));
                    List<Item> allowedGoldenBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("bullet_gold"));
                    List<Item> allowedGoldenRifleBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("rifle_bullet_gold"));
                    List<Item> allowedGoldenHighCaliberBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("high_caliber_bullet_gold"));
                    List<Item> allowedIronBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("bullet_iron"));
                    List<Item> allowedIronRifleBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("rifle_bullet_iron"));
                    List<Item> allowedIronHighCaliberBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("high_caliber_bullet_iron"));
                    List<Item> allowedMagnumShellBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("shell_magnum"));
                    List<Item> allowedExplosiveBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("bullet_explosive"));
                    List<Item> allowedExplosiveRifleBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("rifle_bullet_explosive"));
                    List<Item> allowedExplosiveHighCaliberBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("high_caliber_bullet_explosive"));
                    List<Item> allowedExplosiveSlugBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("slug_explosive"));
                    List<Item> allowedShortyShellBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("shell_shorty"));
                    List<Item> allowedHeavySlugBulletTypes = Collections.singletonList(
                            Common.getBulletProjectileItemByType("slug_heavy"));

                    if (ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedIncendiaryBulletTypes) || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedIncendiaryRifleBulletTypes)  || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedIncendiaryHighCaliberBulletTypes) || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedIncendiarySlugBulletTypes)) {
                        entity.setOnFireFor(3);
                    }
                    if (ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedGoldenBulletTypes) || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedGoldenRifleBulletTypes) || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedGoldenHighCaliberBulletTypes)) {
                        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0));
                    }
                    if (ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedIronBulletTypes) || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedIronRifleBulletTypes) || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedIronHighCaliberBulletTypes)) {
                        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 0));
                    }
                    if (ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedMagnumShellBulletTypes)) {
                        entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 1, World.ExplosionSourceType.MOB);
                        BULLET_DAMAGE = this.getBulletDamage()*2;
                        //MAX_RANGE = this.getMaxRange() / 3;
                    }
                    if (ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedShortyShellBulletTypes)) {
                        //MAX_RANGE = this.getMaxRange() / 2;
                    }
                    if (ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedHeavySlugBulletTypes)) {
                        entity.setOnFireFor(3);
                        //MAX_RANGE = this.getMaxRange() / 2;
                    }
                    if (ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedExplosiveBulletTypes) || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedExplosiveRifleBulletTypes)  || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedExplosiveHighCaliberBulletTypes) || ammoContainsSpecialBullet(gun.getOrCreateNbt(), allowedExplosiveSlugBulletTypes)) {
                        entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), BULLET_DAMAGE, World.ExplosionSourceType.MOB);
                        //MAX_RANGE = this.getMaxRange() / 5;
                    }

                    if (!player.isCreative()) {
                        removeAmmo(gun.getOrCreateNbt());
                    }

                    entity.playSound(IMPACT_SOUND, 1, 1);
                }
            }
        }

        if (hasAmmo(gun.getOrCreateNbt())) {
            player.incrementStat(Stats.USED.getOrCreateStat(this));
            this.playSound(player, SoundType.SHOOT);
        }
    }

    private boolean ammoContainsSpecialBullet(NbtCompound gunNBT, List<Item> allowedBulletTypes) {
        NbtList gunInventory = gunNBT.getList(ITEMS_KEY, 10);

        for (int i = 0; i < gunInventory.size(); i++) {
            NbtCompound slotNBT = gunInventory.getCompound(i);
            ItemStack bulletStack = ItemStack.fromNbt(slotNBT);
            if (allowedBulletTypes.contains(bulletStack.getItem())) {
                return true;
            }
        }
        return false;
    }


    private ItemStack getRandomAmmo(NbtCompound gunNBT) {
        NbtList gunInventory = gunNBT.getList(ITEMS_KEY, 10);
        List<Integer> ammoIndices = getAmmoIndices(gunInventory);

        if (ammoIndices.isEmpty()) {
            return null;
        }

        int randomIndex = ammoIndices.get(random.nextInt(ammoIndices.size()));
        NbtCompound randomSlotNBT = gunInventory.getCompound(randomIndex);
        ItemStack randomBulletStack = ItemStack.fromNbt(randomSlotNBT);

        ItemStack returnBulletStack = randomBulletStack.copy();
        returnBulletStack.setCount(1);

        return returnBulletStack;
    }

    private void removeAmmo(NbtCompound gunNBT) {
        NbtList gunInventory = gunNBT.getList(ITEMS_KEY, 10);
        List<Integer> ammoIndices = getAmmoIndices(gunInventory);

        if (ammoIndices.isEmpty()) {
            return;
        }

        int randomIndex = ammoIndices.get(random.nextInt(ammoIndices.size()));
        NbtCompound randomSlotNBT = gunInventory.getCompound(randomIndex);
        ItemStack randomBulletStack = ItemStack.fromNbt(randomSlotNBT);

        randomBulletStack.decrement(1);

        if (randomBulletStack.isEmpty()) {
            gunInventory.remove(randomIndex);
        } else {
            randomBulletStack.writeNbt(randomSlotNBT);
        }
    }

    private List<Integer> getAmmoIndices(NbtList gunInventory) {
        List<Integer> ammoIndices = new ArrayList<>();

        for (int i = 0; i < gunInventory.size(); i++) {
            NbtCompound slotNBT = gunInventory.getCompound(i);
            ItemStack bulletStack = ItemStack.fromNbt(slotNBT);
            if (bulletStack.getCount() > 0) {
                ammoIndices.add(i);
            }
        }
        return ammoIndices;
    }

    private boolean hasAmmo(NbtCompound gunNBT) {
        return gunNBT.contains(ITEMS_KEY);
    }

    private boolean doesUseAmmo(PlayerEntity player) {
        return !player.isCreative();
    }

    private void playSound(PlayerEntity player, SoundType type) {
        SoundEvent sound = null;
        switch (type) {
            case SHOOT -> sound = SHOOT_SOUND;
            case RELOAD -> sound = RELOAD_SOUND;
            case EMPTY -> sound = EMPTY_SOUND;
            case REMOVE_ONE -> sound = REMOVE_BULLET_SOUND;
            case INSERT -> sound = INSERT_SOUND;
            case DROP_CONTENT -> sound = DROP_CONTENT_SOUND;
            case IMPACT -> sound = IMPACT_SOUND;
        }

        player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundCategory.NEUTRAL, 1F, 1F);
    }
    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT)
            return false;

        boolean isAllowedType = Arrays.stream(ALLOWED_TYPES).anyMatch(stack::isOf);
        if (!isAllowedType)
            return false;

        ItemStack gun = slot.getStack();
        NbtCompound gunNbt = gun.getOrCreateNbt();
        if (!gunNbt.contains(ITEMS_KEY))
            gunNbt.put(ITEMS_KEY, new NbtList());

        NbtList gunInventory = gunNbt.getList(ITEMS_KEY, 10);

        int currentOccupancy = getBundleOccupancy(gun);
        if (currentOccupancy >= MAGAZINE_SIZE)
            return false;

        Optional<NbtCompound> matchingSlotNbt = canMergeStack(stack, gunInventory);
        if (matchingSlotNbt.isPresent()) {
            NbtCompound slotNbt = matchingSlotNbt.get();
            ItemStack existingStack = ItemStack.fromNbt(slotNbt);
            existingStack.increment(stack.getCount());
            existingStack.writeNbt(slotNbt);
        } else {
            ItemStack newStack = stack.copy();
            NbtCompound newSlotNbt = new NbtCompound();
            newStack.writeNbt(newSlotNbt);
            gunInventory.add(newSlotNbt);
        }

        return true;
    }


    public boolean onClicked(ItemStack gun, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
            if (otherStack.isEmpty()) {
                removeFirstStack(gun).ifPresent((itemStack) -> {
                    playSound(player, SoundType.REMOVE_ONE);
                    cursorStackReference.set(itemStack);
                });
            } else {
                if (getBundleOccupancy(gun) >= MAGAZINE_SIZE) {
                    return false;
                }

                int i = addToGunInventory(gun, otherStack);

                if (i > 0) {
                    playSound(player, SoundType.INSERT);
                    otherStack.decrement(i);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private int addToGunInventory(ItemStack gun, ItemStack item) {
        boolean isAllowedType = Arrays.stream(ALLOWED_TYPES).anyMatch(item::isOf);
        if (!isAllowedType) {
            return 0;
        }

        if (!item.isEmpty()) {
            NbtCompound gunNbt = gun.getOrCreateNbt();
            if (!gunNbt.contains(ITEMS_KEY)) {
                gunNbt.put(ITEMS_KEY, new NbtList());
            }

            int currentOccupancy = getBundleOccupancy(gun);

            if (currentOccupancy >= MAGAZINE_SIZE) {
                return 0;
            }

            int availableSpace = MAGAZINE_SIZE - currentOccupancy;
            int itemOccupancy = getItemOccupancy(item);
            int itemsToAdd = Math.min(itemOccupancy, availableSpace);
            if (itemsToAdd == 0) {
                return 0;
            } else {
                NbtList gunInventory = gunNbt.getList(ITEMS_KEY, 10);
                Optional<NbtCompound> optional = canMergeStack(item, gunInventory);
                if (optional.isPresent()) {
                    NbtCompound nbtCompound2 = optional.get();
                    ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                    itemStack.increment(itemsToAdd);
                    itemStack.writeNbt(nbtCompound2);
                } else {
                    ItemStack itemStack2 = item.copyWithCount(itemsToAdd);
                    NbtCompound nbtCompound3 = new NbtCompound();
                    itemStack2.writeNbt(nbtCompound3);
                    gunInventory.add(nbtCompound3);
                }
                return itemsToAdd;
            }
        } else {
            return 0;
        }
    }

    private static Optional<NbtCompound> canMergeStack(ItemStack stack, NbtList gunInventory) {
        Stream<NbtElement> var10000 = gunInventory.stream();
        Objects.requireNonNull(NbtCompound.class);
        var10000 = var10000.filter(NbtCompound.class::isInstance);
        Objects.requireNonNull(NbtCompound.class);
        return var10000.map(NbtCompound.class::cast).filter((item) -> ItemStack.canCombine(ItemStack.fromNbt(item), stack)).findFirst();
    }

    private int getItemOccupancy(ItemStack stack) {
        int occupancy = 0;
        Queue<ItemStack> toProcess = new LinkedList<>();
        toProcess.offer(stack);

        while (!toProcess.isEmpty()) {
            ItemStack currentStack = toProcess.poll();

            boolean shouldCountCurrentStack = true;

            if (currentStack.hasNbt()) {
                NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(currentStack);
                if (nbtCompound != null) {
                    NbtList containedItems = nbtCompound.getList("Items", 10);
                    for (int i = 0; i < containedItems.size(); i++) {
                        NbtCompound containedItem = containedItems.getCompound(i);
                        ItemStack containedStack = ItemStack.fromNbt(containedItem);
                        toProcess.offer(containedStack);
                    }
                    shouldCountCurrentStack = false;
                }
            }

            if (shouldCountCurrentStack) {
                occupancy += currentStack.getCount();
            }
        }

        return occupancy;
    }

    private Optional<ItemStack> removeFirstStack(ItemStack stack) {
        NbtCompound gun = stack.getOrCreateNbt();
        if (!gun.contains(ITEMS_KEY)) {
            return Optional.empty();
        }
        NbtList bulletList = gun.getList(ITEMS_KEY, 10);
        if (bulletList.isEmpty()) {
            return Optional.empty();
        } else {
            NbtCompound bulletCompound = bulletList.getCompound(0);
            ItemStack bulletStack = ItemStack.fromNbt(bulletCompound);
            boolean isAllowedType = Arrays.stream(ALLOWED_TYPES).anyMatch(bulletStack::isOf);
            if (!isAllowedType) {
                return Optional.empty();
            }
            bulletList.remove(0);
            if (bulletList.isEmpty()) {
                stack.removeSubNbt(ITEMS_KEY);
            }
            return Optional.of(bulletStack);
        }
    }

    protected Stream<ItemStack> getBulletStacks(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound == null) {
            return Stream.empty();
        } else {
            NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
            return nbtList.stream()
                    .map(NbtCompound.class::cast)
                    .map(ItemStack::fromNbt)
                    .filter(itemStack -> {
                        return Arrays.stream(ALLOWED_TYPES).anyMatch(itemStack::isOf);
                    });
        }
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        int totalLoaded = getBundleOccupancy(stack);
        tooltip.add(Text.literal("[ Capacity ]").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(totalLoaded + "/" + MAGAZINE_SIZE).formatted(Formatting.DARK_GRAY));

        tooltip.add(Text.literal("[ Loaded Bullets ]").formatted(Formatting.GRAY));

        List<ItemStack> bulletStacks = getBulletStacks(stack).toList();

        for (int i = 0; i < Math.min(bulletStacks.size(), 5); i++) {
            ItemStack bulletStack = bulletStacks.get(i);
            MutableText bulletText = Text.translatable(bulletStack.getName().getString()).formatted(Formatting.DARK_GRAY);
            bulletText.append(" x" + bulletStack.getCount());

            tooltip.add(bulletText);
        }

        if (context.isAdvanced()) {
            String firerate = "";
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.literal("[ Stats ]").formatted(Formatting.GRAY));
                tooltip.add(Text.literal("Cooldown: " + this.getGunCooldown()).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("Magazine Size: " + this.getMagSize()).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("Bullet Damage: " + this.getBulletDamage()).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("Max Range: " + this.getMaxRange()).formatted(Formatting.DARK_GRAY));
                if (MAX_USE_TIME <= 1) {
                    firerate = "Manual";
                }
                if (MAX_USE_TIME >= 2 && MAX_USE_TIME <= 72000) {
                    firerate = "Semi-Auto";
                }
                if (MAX_USE_TIME >= 72000) {
                    firerate = "Full-Auto";
                }
                tooltip.add(Text.literal("Type: " + firerate).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("[ Allowed Ammo Types ]").formatted(Formatting.GRAY));
                for (Item allowedType : ALLOWED_TYPES) {
                    tooltip.add(allowedType.getName().copy().formatted(Formatting.DARK_GRAY));
                }
            }
        }
    }

    protected int getBundleOccupancy(ItemStack stack) {
        return getBulletStacks(stack).mapToInt(this::getItemOccupancy).sum();
    }

    public void onItemEntityDestroyed(ItemEntity entity) {
        ItemUsage.spawnItemContents(entity, getBulletStacks(entity.getStack()));
    }
    public Predicate<ItemStack> getProjectiles() {
        return itemStack -> itemStack.getItem().equals(IgniteItems.BULLET);
    }
    
    public boolean isItemBarVisible(ItemStack stack) {
        return getBundleOccupancy(stack) > 0;
    }

    public int getItemBarStep(ItemStack stack) {
        return Math.min(1 + 12 * getBundleOccupancy(stack) / MAGAZINE_SIZE, 13);
    }

    //Sets the item to not be used as a mining tool
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return false;
    }
    
    public int getRange() {
        return RANGE;
    }
    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }
    public int getMaxRange() {
        return MAX_RANGE;
    }
    public int getGunCooldown() {
        return COOLDOWN;
    }
    public int getMagSize() {
        return MAGAZINE_SIZE;
    }
    public int getMaxUseTimeINT() {
        return MAX_USE_TIME;
    }
    public float getBulletDamage() {
        return BULLET_DAMAGE;
    }
    public static boolean getZoom() {
        return zoom;
    }
    public static int getZoomInt() {
        return ZOOM;
    }
}