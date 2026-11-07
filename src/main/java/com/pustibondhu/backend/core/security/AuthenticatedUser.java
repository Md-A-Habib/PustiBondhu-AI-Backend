package com.pustibondhu.backend.core.security;

/**
 * Lightweight principal object representing the currently logged-in user.
 * Holds the user id, email, and roles so that controllers and services can
 * read the caller's identity without querying the database again.
 */
public class AuthenticatedUser {
}
