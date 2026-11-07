package com.pustibondhu.backend.core.config;

/**
 * Defines the Spring Security filter chain. Configures stateless session
 * management, which endpoints are public (register, login, Swagger) and which
 * require a valid JWT, registers the JWT authentication filter, and sets the
 * password encoder.
 */
public class SecurityConfig {
}
