package com.gym.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
        @Bean
        public OpenAPI customOpenAPI(
                @Value("${spring.application.name:Gym API}") String applicationName,
                @Value("${server.port:8080}") String serverPort) {
                return new OpenAPI()
                                .info(new Info()
                                                .title(applicationName + " - API")
                                                .description("REST API for gym management with microservices. " +
                                                                "Uses Bearer JWT authentication. " +
                                                                "Available roles: ROLE_ADMIN, ROLE_TRAINER, ROLE_MEMBER")
                                                .version("1.0.0"))
                                .servers(List.of(
                                                new Server().url("http://localhost:" + serverPort)
                                                                .description("Local Development Server")))
                                .components(new Components()
                                                .addSecuritySchemes("bearer-key",
                                                                new SecurityScheme()
                                                                                .type(SecurityScheme.Type.HTTP)
                                                                                .scheme("bearer")
                                                                                .bearerFormat("JWT")
                                                                                .description("JWT Bearer token for authentication")))
                                .addSecurityItem(new SecurityRequirement().addList("bearer-key"));
        }
}
