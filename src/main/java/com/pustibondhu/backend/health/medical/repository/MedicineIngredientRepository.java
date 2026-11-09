package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.MedicineIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link MedicineIngredient}.
 * Module: HEALTH | Table: medicine_ingredients | Migration: V100 | Author: Ahsan
 */
@Repository
public interface MedicineIngredientRepository extends JpaRepository<MedicineIngredient, Long> {

    /** All ingredients of a medicine. */
    List<MedicineIngredient> findByMedicineId(Long medicineId);

    /** All medicines that contain a given ingredient. */
    List<MedicineIngredient> findByIngredientId(Long ingredientId);

    /** The mapping between one medicine and one ingredient. */
    Optional<MedicineIngredient> findByMedicineIdAndIngredientId(Long medicineId, Long ingredientId);

    /** Deletes all ingredient mappings of a medicine. */
    void deleteByMedicineId(Long medicineId);
}