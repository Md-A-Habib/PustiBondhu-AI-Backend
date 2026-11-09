package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.UserCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link UserCondition}.
 * Module: HEALTH | Table: user_conditions | Migration: V101 | Author: Ahsan
 */
@Repository
public interface UserConditionRepository extends JpaRepository<UserCondition, Long> {

    /** All conditions of a user. */
    List<UserCondition> findByUserId(Long userId);

    /** A user's conditions with a given status (ACTIVE / CONTROLLED). */
    List<UserCondition> findByUserIdAndStatus(Long userId, String status);

    /** The record of one condition for one user. */
    Optional<UserCondition> findByUserIdAndConditionId(Long userId, Long conditionId);

    /** Checks whether a user already has a condition. */
    boolean existsByUserIdAndConditionId(Long userId, Long conditionId);

    /** All users who have a given condition. */
    List<UserCondition> findByConditionId(Long conditionId);

    /** All conditions created from one extraction. */
    List<UserCondition> findByExtractionId(Long extractionId);
}
