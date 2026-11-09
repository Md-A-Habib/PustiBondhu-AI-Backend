package com.pustibondhu.backend.health.activity.repository;

import com.pustibondhu.backend.health.activity.entity.ActivitySample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link ActivitySample}.
 * Module: HEALTH | Table: activity_samples | Migration: V104 | Author: Ahsan
 */
@Repository
public interface ActivitySampleRepository extends JpaRepository<ActivitySample, Long> {

    /** All samples of a user. */
    List<ActivitySample> findByUserId(Long userId);

    /** All samples that came from one connection. */
    List<ActivitySample> findByConnectionId(Long connectionId);

    /** Finds an already-synced record (used to avoid duplicates). */
    Optional<ActivitySample> findByConnectionIdAndExternalRecordId(Long connectionId, String externalRecordId);

    /** A user's samples for one metric within a time range. */
    List<ActivitySample> findByUserIdAndMetricTypeAndStartTimeBetween(
            Long userId, String metricType, Instant from, Instant to);
}