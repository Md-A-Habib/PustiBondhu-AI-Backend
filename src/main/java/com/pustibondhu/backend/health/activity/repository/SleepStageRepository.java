package com.pustibondhu.backend.health.activity.repository;

import com.pustibondhu.backend.health.activity.entity.SleepStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access layer for {@link SleepStage}.
 * Module: HEALTH | Table: sleep_stages | Migration: V104 | Author: Ahsan
 */
@Repository
public interface SleepStageRepository extends JpaRepository<SleepStage, Long> {

    /** All stages of a sleep session. */
    List<SleepStage> findBySleepSessionId(Long sleepSessionId);

    /** A session's stages of one type (AWAKE / LIGHT / DEEP / REM). */
    List<SleepStage> findBySleepSessionIdAndStage(Long sleepSessionId, String stage);

    /** Deletes all stages of a sleep session. */
    void deleteBySleepSessionId(Long sleepSessionId);
}