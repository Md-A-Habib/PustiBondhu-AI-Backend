package com.pustibondhu.backend.health.activity.repository;

import com.pustibondhu.backend.health.activity.entity.SleepSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link SleepSession}.
 * Module: HEALTH | Table: sleep_sessions | Migration: V104 | Author: Ahsan
 */
@Repository
public interface SleepSessionRepository extends JpaRepository<SleepSession, Long> {

    /** All sleep sessions of a user. */
    List<SleepSession> findByUserId(Long userId);

    /** All sleep sessions that came from one connection. */
    List<SleepSession> findByConnectionId(Long connectionId);

    /** Finds an already-synced session (used to avoid duplicates). */
    Optional<SleepSession> findByConnectionIdAndExternalRecordId(Long connectionId, String externalRecordId);

    /** A user's sleep sessions starting within a time range. */
    List<SleepSession> findByUserIdAndStartTimeBetween(Long userId, Instant from, Instant to);
}