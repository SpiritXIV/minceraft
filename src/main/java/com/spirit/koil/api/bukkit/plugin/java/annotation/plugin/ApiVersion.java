package com.spirit.koil.api.bukkit.plugin.java.annotation.plugin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation specifies the api version of the plugin.
 * <br>
 * Defaults to {@link ApiVersion.Target#DEFAULT}.
 * <br>
 * Pre-1.13 plugins do not need to use this annotation.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( ElementType.TYPE )
public @interface ApiVersion {

    Target value() default Target.DEFAULT;

    /**
     * Specifies the target api-version for this plugin.
     *
     * All pre-1.13 plugins must use {@link #DEFAULT}.
     */
    public static enum Target {
        /**
         * This target version specifies that the plugin was made for pre-1.13 Spigot versions.
         */
        DEFAULT( null ),

        /**
         * This target version specifies that the plugin was made with 1.13+ versions in mind.
         */
        v1_13( "1.13" ),

        /**
         * This target version specifies that the plugin was made with 1.14+ versions in mind.
         */
        v1_14( "1.14" ),

        /**
         * This target version specifies that the plugin was made with 1.15+ versions in mind.
         */
        v1_15( "1.15" ),

        /**
         * This target version specifies that the plugin was made with 1.16+ versions in mind.
         */
        v1_16("1.16"),

        /**
         * This target version specifies that the plugin was made with 1.17+ versions in mind.
         */
        v1_17("1.17"),

        /**
         * This target version specifies that the plugin was made with 1.18+ versions in mind.
         */
        v1_18("1.18"),

        /**
         * This target version specifies that the plugin was made with 1.19+ versions in mind.
         */
        v1_19("1.19"),

        /**
         * This target version specifies that the plugin was made with 1.20+ versions in mind.
         */
        v1_20("1.20");

        private final String version;

        private Target(String version) {
            this.version = version;
        }

        public String getVersion() {
            return version;
        }
    }
}
