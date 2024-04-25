package com.spirit.koil.api.bukkit.plugin.java.annotation.dependency;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a plugin library.
 * <br>
 * Libraries are dynamically loaded by the server implementation and should take
 * the form of groupId:artifactId:version.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Libraries.class)
public @interface Library {

    /**
     * A library that is to be loaded and accessible by this plugin.
     */
    String value();
}
