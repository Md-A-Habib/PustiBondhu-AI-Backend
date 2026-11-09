package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.FoodMedicineInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link FoodMedicineInteraction}.
 * Module: HEALTH | Table: food_medicine_interactions | Migration: V100 | Author: Ahsan
 */
@Repository
public interface FoodMedicineInteractionRepository extends JpaRepository<FoodMedicineInteraction, Long> {

    /** All interactions of a food. */
    List<FoodMedicineInteraction> findByFoodId(Long foodId);

    /** All food interactions of a drug ingredient. */
    List<FoodMedicineInteraction> findByIngredientId(Long ingredientId);

    /** The interaction between one food and one ingredient. */
    Optional<FoodMedicineInteraction> findByFoodIdAndIngredientId(Long foodId, Long ingredientId);

    /** All interactions of a given severity (MINOR / MODERATE / MAJOR). */
    List<FoodMedicineInteraction> findBySeverity(String severity);

    /** All interactions from one knowledge source. */
    List<FoodMedicineInteraction> findBySourceId(Long sourceId);
}