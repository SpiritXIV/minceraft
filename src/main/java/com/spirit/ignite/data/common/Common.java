package com.spirit.ignite.data.common;

import com.spirit.ignite.global.item.IgniteItems;
import com.spirit.ignite.global.item.custom.GunProjectileItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

import java.util.*;

/**
 * Common utility class for storing commonly used functions and data.
 */

@SuppressWarnings("unused")
public final class Common {
    private static final String[] AMMO_TYPES = {
            "bullet",
            "bullet_gold",
            "bullet_iron",
            "bullet_incendiary",
            "bullet_explosive",
            "shell",
            "shell_magnum",
            "shell_shorty",
            "rifle_bullet",
            "rifle_bullet_gold",
            "rifle_bullet_iron",
            "rifle_bullet_incendiary",
            "rifle_bullet_explosive",
            "high_caliber_bullet",
            "high_caliber_bullet_gold",
            "high_caliber_bullet_iron",
            "high_caliber_bullet_incendiary",
            "high_caliber_bullet_explosive",
            "slug",
            "slug_heavy",
            "slug_incendiary",
            "slug_explosive",
            "musket_ball",
            "grenade",
            "incgrenade",
            "flash_bang",
            "pipe_bomb",
            "smoke_bomb"
    };
    private static final Map<String, GunProjectileItem> AMMO_MAP = new HashMap<>();
    static {
        AMMO_MAP.put("bullet", (GunProjectileItem) IgniteItems.BULLET);
        AMMO_MAP.put("bullet_gold", (GunProjectileItem) IgniteItems.BULLET_GOLD);
        AMMO_MAP.put("bullet_iron", (GunProjectileItem) IgniteItems.BULLET_IRON);
        AMMO_MAP.put("bullet_incendiary", (GunProjectileItem) IgniteItems.BULLET_INCENDIARY);
        AMMO_MAP.put("bullet_explosive", (GunProjectileItem) IgniteItems.BULLET_EXPLOSIVE);
        AMMO_MAP.put("shell", (GunProjectileItem) IgniteItems.SHELL);
        AMMO_MAP.put("shell_magnum", (GunProjectileItem) IgniteItems.SHELL_MAGNUM);
        AMMO_MAP.put("shell_shorty", (GunProjectileItem) IgniteItems.SHELL_SHORTY);
        AMMO_MAP.put("rifle_bullet", (GunProjectileItem) IgniteItems.RIFLE_BULLET);
        AMMO_MAP.put("rifle_bullet_gold", (GunProjectileItem) IgniteItems.RIFLE_BULLET_GOLD);
        AMMO_MAP.put("rifle_bullet_iron", (GunProjectileItem) IgniteItems.RIFLE_BULLET_IRON);
        AMMO_MAP.put("rifle_bullet_incendiary", (GunProjectileItem) IgniteItems.RIFLE_BULLET_INCENDIARY);
        AMMO_MAP.put("rifle_bullet_explosive", (GunProjectileItem) IgniteItems.RIFLE_BULLET_EXPLOSIVE);
        AMMO_MAP.put("high_caliber_bullet", (GunProjectileItem) IgniteItems.HIGH_CALIBER_BULLET);
        AMMO_MAP.put("high_caliber_bullet_gold", (GunProjectileItem) IgniteItems.HIGH_CALIBER_BULLET_GOLD);
        AMMO_MAP.put("high_caliber_bullet_iron", (GunProjectileItem) IgniteItems.HIGH_CALIBER_BULLET_IRON);
        AMMO_MAP.put("high_caliber_bullet_incendiary", (GunProjectileItem) IgniteItems.HIGH_CALIBER_BULLET_INCENDIARY);
        AMMO_MAP.put("high_caliber_bullet_explosive", (GunProjectileItem) IgniteItems.HIGH_CALIBER_BULLET_EXPLOSIVE);
        AMMO_MAP.put("slug", (GunProjectileItem) IgniteItems.SLUG);
        AMMO_MAP.put("slug_heavy", (GunProjectileItem) IgniteItems.SLUG_HEAVY);
        AMMO_MAP.put("slug_incendiary", (GunProjectileItem) IgniteItems.SLUG_INCENDIARY);
        AMMO_MAP.put("slug_explosive", (GunProjectileItem) IgniteItems.SLUG_EXPLOSIVE);
        AMMO_MAP.put("musket_ball", (GunProjectileItem) IgniteItems.MUSKET_BALL);
        AMMO_MAP.put("grenade", (GunProjectileItem) IgniteItems.GRENADE);
        AMMO_MAP.put("incgrenade", (GunProjectileItem) IgniteItems.INCGRENADE);
        AMMO_MAP.put("flash_bang", (GunProjectileItem) IgniteItems.FLASH_BANG);
        AMMO_MAP.put("pipe_bomb", (GunProjectileItem) IgniteItems.PIPE_BOMB);
        AMMO_MAP.put("smoke_bomb", (GunProjectileItem) IgniteItems.SMOKE_BOMB);
    }


    // Private constructor to prevent instantiation
    private Common() {
    }

    /**
     * Returns an unmodifiable list containing types of ammunition.
     *
     * @return an unmodifiable list of ammo types
     */
    @SuppressWarnings("unused")
    public static List<String> getAmmoTypes() {
        return Collections.unmodifiableList(Arrays.asList(AMMO_TYPES));
    }

    /**
     * Retrieves a BulletProjectileItem based on its string identifier.
     *
     * @param ammoType the string identifier for the ammo type
     * @return the corresponding BulletProjectileItem, or null if the type is not recognized
     */

    public static GunProjectileItem getBulletProjectileItemByType(String ammoType) {
        return AMMO_MAP.get(ammoType);
    }

    /**
     * Retrieves a String based on its BulletProjectileItem identifier.
     *
     * @param ammoType the BulletProjectileItem identifier for the ammo type
     * @return the corresponding String, or null if the type is not recognized
     */
    public static String getBulletProjectileItemNameByType(GunProjectileItem ammoType) {
        for (Map.Entry<String, GunProjectileItem> entry : AMMO_MAP.entrySet()) {
            if (entry.getValue().equals(ammoType)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Creates an array of BulletProjectileItem objects based on the internally stored AMMO_TYPES.
     *
     * @return an array of BulletProjectileItem objects.
     */
    public static GunProjectileItem[] getBulletProjectileItems() {
        List<GunProjectileItem> itemsList = new ArrayList<>();

        // Populate the list
        for (String ammoType : AMMO_TYPES) {
            GunProjectileItem item = getBulletProjectileItemByType(ammoType);
            if (item != null) {
                itemsList.add(item);
            }
        }

        // Convert the list to an array
        GunProjectileItem[] itemsArray = new GunProjectileItem[itemsList.size()];
        itemsList.toArray(itemsArray);
        return itemsArray;
    }

    /**
     * Applies knockback to a target entity based on the position of an attacker entity.
     *
     * @param attacker The entity dealing the damage and causing the knockback.
     * @param target   The entity receiving the damage and knockback.
     * @param strength The strength of the knockback.
     */
    public static void applyKnockback(Entity attacker, LivingEntity target, float strength) {
        double xRatio = attacker.getX() - target.getX();
        double zRatio = attacker.getZ() - target.getZ();

        // Normalize the x and z ratios to create a unit vector.
        double length = Math.sqrt(xRatio * xRatio + zRatio * zRatio);
        xRatio /= length;
        zRatio /= length;

        // Apply knockback
        target.takeKnockback(strength, xRatio, zRatio);
    }

    /**
     * Calculates the direction vector based on the pitch and yaw of a given LivingEntity.
     * The direction vector is then scaled by a specified dampening factor.
     *
     * @param user The LivingEntity (e.g., player) from which to get the pitch and yaw.
     * @param DAMPENING_FACTOR The factor by which to scale the direction vector components.
     * @return A double array containing the direction vector [xx, yy, zz].
     *
     * <p>
     * Direction vector calculation is based on the spherical coordinate system.
     * </p>
     * <ul>
     *   <li>xx = -sin(yaw) * cos(pitch)</li>
     *   <li>yy = -sin(pitch)</li>
     *   <li>zz = cos(yaw) * cos(pitch)</li>
     * </ul>
     *
     * <p>
     * The method first converts the pitch and yaw of the LivingEntity to radians.
     * It then calculates the x, y, and z components of the direction vector.
     * Finally, it scales these components using the provided dampening factor.
     * </p>
     */
    public static double[] calculateDirectionVector(LivingEntity user, double DAMPENING_FACTOR) {
        // Get the pitch and yaw from the player
        float pitch = user.getPitch(1.0F);
        float yaw = user.getYaw(1.0F);

        // Convert pitch and yaw to radians
        double pitchRadians = Math.toRadians(pitch);
        double yawRadians = Math.toRadians(yaw);

        // Calculate direction vector for particles
        double xx = -Math.sin(yawRadians) * Math.cos(pitchRadians);
        double yy = -Math.sin(pitchRadians);
        double zz = Math.cos(yawRadians) * Math.cos(pitchRadians);

        // Apply dampening factor to the direction vector
        xx *= DAMPENING_FACTOR;
        yy *= DAMPENING_FACTOR;
        zz *= DAMPENING_FACTOR;

        return new double[]{xx, yy, zz};
    }

    /**
     * Calculate the azimuth and elevation angles required for entity1 to face entity2.
     *
     * @param entity1 The entity that needs to face entity2.
     * @param entity2 The entity that entity1 should face.
     * @return A float array containing [azimuth, elevation].
     */
    @SuppressWarnings("unused")
    public static float[] calculateFacingAngles(Entity entity1, Entity entity2) {
        double deltaX = entity2.getX() - entity1.getX();
        double deltaY = entity2.getY() - entity1.getY();
        double deltaZ = entity2.getZ() - entity1.getZ();

        // Calculate azimuth (yaw) angle in degrees
        float azimuth = (float) (Math.atan2(deltaZ, deltaX) * (180 / Math.PI)) - 90;

        // Calculate elevation (pitch) angle in degrees
        float elevation = (float) -(Math.atan2(deltaY, Math.sqrt(deltaX * deltaX + deltaZ * deltaZ)) * (180 / Math.PI));

        return new float[]{azimuth, elevation};
    }
}