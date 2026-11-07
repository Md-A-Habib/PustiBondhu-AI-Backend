package com.pustibondhu.backend.health.common.exception;

/**
 * Custom runtime exception for invalid client input that passes validation
 * syntax but violates business rules, such as logging a meal with a negative
 * serving size. Mapped to HTTP 400 by the global exception handler.
 */
public class BadRequestException {
}
