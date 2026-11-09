package com.pustibondhu.backend.health.activity.repository;

import com.pustibondhu.backend.health.activity.entity.HealthPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link HealthPermission}.
 * Module: HEALTH | Table: health_permissions | Migration: V104 | Author: Ahsan
 */
@Repository
public interface HealthPermissionRepository extends JpaRepository<HealthPermission, Long> {

    /** All permissions of a connection. */
    List<HealthPermission> findByConnectionId(Long connectionId);

    /** A connection's permission for one metric (STEPS / HEART_RATE / SLEEP). */
    Optional<HealthPermission> findByConnectionIdAndMetricType(Long connectionId, String metricType);

    /** All granted (true) or not-granted (false) permissions of a connection. */
    List<HealthPermission> findByConnectionIdAndGranted(Long connectionId, Boolean granted);
}