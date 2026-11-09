package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.DrugIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link DrugIngredient}.
 * Module: HEALTH | Table: drug_ingredients | Migration: V100 | Author: Ahsan
 */
@Repository
public interface DrugIngredientRepository extends JpaRepository<DrugIngredient, Long> {

    /** Finds an ingredient by its unique English generic name. */
    Optional<DrugIngredient> findByNameEn(String nameEn);

    /** Checks whether an English generic name already exists. */
    boolean existsByNameEn(String nameEn);

    /** All ingredients of a drug class (e.g. Biguanide). */
    List<DrugIngredient> findByDrugClass(String drugClass);
}