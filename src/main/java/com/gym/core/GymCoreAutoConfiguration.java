package com.gym.core;

import com.gym.core.config.KeycloakRealmRoleConverter;
import com.gym.core.config.OpenApiConfig;
import com.gym.core.config.SecurityConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Auto-configuration class for gym Core
 * Automatically imports all base configurations when the core gym is included
 */
@AutoConfiguration
@Import({
    OpenApiConfig.class,
    SecurityConfig.class,
    KeycloakRealmRoleConverter.class
})
public class GymCoreAutoConfiguration {
    // This class enables automatic configuration import
    // All microservices that include the core dependency will automatically
    // get OpenAPI, Security and Keycloak configurations
}
