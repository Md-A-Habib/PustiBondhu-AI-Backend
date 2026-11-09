package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.FoodAlternative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access layer for {@link FoodAlternative}.
 * Module: HEALTH | Table: food_alternatives | Migration: V100 | Author: Ahsan
 */
@Repository
public interface FoodAlternativeRepository extends JpaRepository<FoodAlternative, Long> {

    /** All alternatives suggested for a food. */
    List<FoodAlternative> findByFoodId(Long foodId);

    /** All swaps where a food is the suggested alternative. */
    List<FoodAlternative> findByAlternativeFoodId(Long alternativeFoodId);

    /** All swaps tied to a medical condition. */
    List<FoodAlternative> findByConditionId(Long conditionId);

    /** A food's alternatives for one medical condition. */
    List<FoodAlternative> findByFoodIdAndConditionId(Long foodId, Long conditionId);
}