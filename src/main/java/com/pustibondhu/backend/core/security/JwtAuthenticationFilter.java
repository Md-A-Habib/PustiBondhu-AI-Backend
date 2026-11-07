package com.pustibondhu.backend.core.security;

/**
 * A servlet filter that runs once per request. Reads the Bearer token from the
 * Authorization header, validates it through JwtTokenProvider, and sets the
 * authenticated user in the Spring Security context when the token is valid.
 */
public class JwtAuthenticationFilter {
}
