package com.pustibondhu.backend.health.activity.repository;

import com.pustibondhu.backend.health.activity.entity.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link WorkoutSession}.
 * Module: HEALTH | Table: workout_sessions | Migration: V104 | Author: Ahsan
 */
@Repository
public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {

    /** All workouts of a user. */
    List<WorkoutSession> findByUserId(Long userId);

    /** All workouts that came from one connection. */
    List<WorkoutSession> findByConnectionId(Long connectionId);

    /** A user's workouts of one type (WALKING / RUNNING / CYCLING). */
    List<WorkoutSession> findByUserIdAndExerciseType(Long userId, String exerciseType);

    /** Finds an already-synced workout (used to avoid duplicates). */
    Optional<WorkoutSession> findByConnectionIdAndExternalRecordId(Long connectionId, String externalRecordId);

    /** A user's workouts starting within a time range. */
    List<WorkoutSession> findByUserIdAndStartTimeBetween(Long userId, Instant from, Instant to);
}