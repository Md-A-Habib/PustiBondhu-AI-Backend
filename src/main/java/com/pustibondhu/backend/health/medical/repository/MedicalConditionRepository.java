package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.MedicalCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link MedicalCondition}.
 * Module: HEALTH | Table: medical_conditions | Migration: V100 | Author: Ahsan
 */
@Repository
public interface MedicalConditionRepository extends JpaRepository<MedicalCondition, Long> {

    /** Finds a condition by its unique ICD-10 code. */
    Optional<MedicalCondition> findByCode(String code);

    /** Checks whether an ICD-10 code already exists. */
    boolean existsByCode(String code);

    /** All conditions of a category (METABOLIC / CARDIAC / RENAL). */
    List<MedicalCondition> findByCategory(String category);

    /** All conditions from one knowledge source. */
    List<MedicalCondition> findBySourceId(Long sourceId);
}