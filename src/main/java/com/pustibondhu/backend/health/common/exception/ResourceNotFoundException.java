package com.pustibondhu.backend.health.common.exception;

/**
 * Custom runtime exception thrown when a requested record such as a user, food
 * item, meal, or report does not exist. The global exception handler maps it
 * to an HTTP 404 response.
 */
public class ResourceNotFoundException {
}
