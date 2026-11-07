package com.pustibondhu.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point of the PustiBondhu Spring Boot backend.
 *
 * Bootstraps the Spring Boot application context, enables component
 * scanning for all feature packages, and starts the embedded web
 * server that serves REST APIs to the Flutter mobile application.
 *
 * Base package: org.orion.backend
 */
@SpringBootApplication
public class PustiBondhuApplication {

    public static void main(String[] args) {
        SpringApplication.run(PustiBondhuApplication.class, args);
    }
}