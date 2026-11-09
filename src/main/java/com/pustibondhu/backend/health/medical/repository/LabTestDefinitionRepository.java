package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.LabTestDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link LabTestDefinition}.
 * Module: HEALTH | Table: lab_test_definitions | Migration: V102 | Author: Ahsan
 */
@Repository
public interface LabTestDefinitionRepository extends JpaRepository<LabTestDefinition, Long> {

    /** Finds a test by its unique code (e.g. HBA1C). */
    Optional<LabTestDefinition> findByCode(String code);

    /** Checks whether a test code already exists. */
    boolean existsByCode(String code);

    /** All tests of a category (DIABETES / LIPID / KIDNEY). */
    List<LabTestDefinition> findByCategory(String category);
}