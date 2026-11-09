package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.SafetyAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access layer for {@link SafetyAlert}.
 * Module: HEALTH | Table: safety_alerts | Migration: V103 | Author: Ahsan
 */
@Repository
public interface SafetyAlertRepository extends JpaRepository<SafetyAlert, Long> {

    /** All alerts of a user, newest first. */
    List<SafetyAlert> findByUserIdOrderByIdDesc(Long userId);

    /** A user's unread (not yet acknowledged) alerts. */
    List<SafetyAlert> findByUserIdAndAcknowledgedAtIsNull(Long userId);

    /** Counts a user's unread alerts (for a badge). */
    long countByUserIdAndAcknowledgedAtIsNull(Long userId);

    /** A user's alerts of one type (FOOD_MEDICINE / DRUG_DRUG / LAB_CRITICAL). */
    List<SafetyAlert> findByUserIdAndAlertType(Long userId, String alertType);

    /** A user's alerts of one severity (INFO / WARNING / URGENT). */
    List<SafetyAlert> findByUserIdAndSeverity(Long userId, String severity);

    /** All alerts triggered by one lab result. */
    List<SafetyAlert> findByLabResultId(Long labResultId);
}