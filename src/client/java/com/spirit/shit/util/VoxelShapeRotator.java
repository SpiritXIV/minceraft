package com.spirit.shit.util;

import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.EnumMap;
import java.util.Map;

public class VoxelShapeRotator {

    // Existing method
    public static Map<Direction, VoxelShape> rotateAllDirections(VoxelShape originalShape) {
        Map<Direction, VoxelShape> rotatedShapes = new EnumMap<>(Direction.class);

        rotatedShapes.put(Direction.NORTH, originalShape);
        rotatedShapes.put(Direction.EAST, rotate90Degrees(originalShape));
        rotatedShapes.put(Direction.SOUTH, rotate180Degrees(originalShape));
        rotatedShapes.put(Direction.WEST, rotate270Degrees(originalShape));

        return rotatedShapes;
    }

    /**
     * Rotates the given VoxelShape 90 degrees clockwise.
     *
     * @param originalShape The original VoxelShape to rotate.
     * @return The rotated VoxelShape.
     */
    public static VoxelShape rotate90Degrees(VoxelShape originalShape) {
        return rotate(originalShape, 0.5, 0.5, 0.5, 90);
    }

    /**
     * Rotates the given VoxelShape 180 degrees.
     *
     * @param originalShape The original VoxelShape to rotate.
     * @return The rotated VoxelShape.
     */
    public static VoxelShape rotate180Degrees(VoxelShape originalShape) {
        return rotate(originalShape, 0.5, 0.5, 0.5, 180);
    }

    /**
     * Rotates the given VoxelShape 270 degrees clockwise.
     *
     * @param originalShape The original VoxelShape to rotate.
     * @return The rotated VoxelShape.
     */
    public static VoxelShape rotate270Degrees(VoxelShape originalShape) {
        return rotate(originalShape, 0.5, 0.5, 0.5, 270);
    }

    /**
     * Rotates the given VoxelShape around the specified point by the given angle.
     *
     * @param originalShape The original VoxelShape to rotate.
     * @param centerX       The x-coordinate of the rotation center.
     * @param centerY       The y-coordinate of the rotation center.
     * @param centerZ       The z-coordinate of the rotation center.
     * @param angle         The rotation angle in degrees.
     * @return The rotated VoxelShape.
     */
    public static VoxelShape rotate(VoxelShape originalShape, double centerX, double centerY, double centerZ, double angle) {
        VoxelShape rotatedShape = VoxelShapes.empty();

        // Loop through the boxes in the original shape
        for (Box box : originalShape.getBoundingBoxes()) {
            // Rotate the box
            Box rotatedBox = rotateBox(box, centerX, centerY, centerZ, angle);
            // Combine the rotated box into the final shape
            rotatedShape = VoxelShapes.union(rotatedShape, VoxelShapes.cuboid(rotatedBox));
        }

        return rotatedShape;
    }

    /**
     * Rotates the given Box around the specified point by the given angle.
     *
     * @param box      The original Box to rotate.
     * @param centerX  The x-coordinate of the rotation center.
     * @param centerY  The y-coordinate of the rotation center.
     * @param centerZ  The z-coordinate of the rotation center.
     * @param angle    The rotation angle in degrees.
     * @return The rotated Box.
     */
    public static Box rotateBox(Box box, double centerX, double centerY, double centerZ, double angle) {
        double rad = Math.toRadians(angle);

        // The Y coordinate is unchanged, only X and Z are affected by rotation
        double minX = Math.cos(rad) * (box.minX - centerX) - Math.sin(rad) * (box.minZ - centerZ) + centerX;
        double minZ = Math.sin(rad) * (box.minX - centerX) + Math.cos(rad) * (box.minZ - centerZ) + centerZ;
        double maxX = Math.cos(rad) * (box.maxX - centerX) - Math.sin(rad) * (box.maxZ - centerZ) + centerX;
        double maxZ = Math.sin(rad) * (box.maxX - centerX) + Math.cos(rad) * (box.maxZ - centerZ) + centerZ;

        return new Box(Math.min(minX, maxX), box.minY, Math.min(minZ, maxZ),
                Math.max(minX, maxX), box.maxY, Math.max(minZ, maxZ));
    }
}
