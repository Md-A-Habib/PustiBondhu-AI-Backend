package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.FoodConditionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link FoodConditionRule}.
 * Module: HEALTH | Table: food_condition_rules | Migration: V100 | Author: Ahsan
 */
@Repository
public interface FoodConditionRuleRepository extends JpaRepository<FoodConditionRule, Long> {

    /** All rules of a food. */
    List<FoodConditionRule> findByFoodId(Long foodId);

    /** All rules of a medical condition. */
    List<FoodConditionRule> findByConditionId(Long conditionId);

    /** The rule for one food under one condition. */
    Optional<FoodConditionRule> findByFoodIdAndConditionId(Long foodId, Long conditionId);

    /** A condition's rules of one tier (SAFE / RESTRICT / AVOID). */
    List<FoodConditionRule> findByConditionIdAndTier(Long conditionId, String tier);

    /** All rules from one knowledge source. */
    List<FoodConditionRule> findBySourceId(Long sourceId);
}