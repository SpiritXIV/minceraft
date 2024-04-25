package com.spirit.koil.api.bukkit.plugin.java.annotation.permission;

import com.spirit.koil.api.bukkit.permissions.PermissionDefault;

import java.lang.annotation.*;

/**
 * Defines a plugin permission
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Permissions.class)
public @interface Permission {
    /**
     * This permission's name.
     */
    String name();

    /**
     * This permission's description.
     */
    String desc() default "";

    /**
     * This permission's default {@link PermissionDefault}
     */
    PermissionDefault defaultValue() default PermissionDefault.OP;

    /**
     * This permission's child nodes ( {@link ChildPermission} )
     */
    ChildPermission[] children() default {};
}
