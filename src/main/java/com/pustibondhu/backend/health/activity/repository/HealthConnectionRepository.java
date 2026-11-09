package com.pustibondhu.backend.health.activity.repository;

import com.pustibondhu.backend.health.activity.entity.HealthConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link HealthConnection}.
 * Module: HEALTH | Table: health_connections | Migration: V104 | Author: Ahsan
 */
@Repository
public interface HealthConnectionRepository extends JpaRepository<HealthConnection, Long> {

    /** All connections owned by a user. */
    List<HealthConnection> findByUserId(Long userId);

    /** A user's connection on a specific platform (HEALTH_CONNECT / HEALTHKIT). */
    Optional<HealthConnection> findByUserIdAndPlatform(Long userId, String platform);

    /** All connections of a user with a given status (CONNECTED / REVOKED / ERROR). */
    List<HealthConnection> findByUserIdAndStatus(Long userId, String status);
}