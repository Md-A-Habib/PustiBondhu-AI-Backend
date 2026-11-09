package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access layer for {@link Medicine}.
 * Module: HEALTH | Table: medicines | Migration: V100 | Author: Ahsan
 */
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    /** Searches medicines by brand name (case-insensitive, partial match). */
    List<Medicine> findByBrandNameContainingIgnoreCase(String brandName);

    /** All medicines from one manufacturer. */
    List<Medicine> findByManufacturer(String manufacturer);

    /** All medicines of a dosage form (TABLET / SYRUP / INJECTION). */
    List<Medicine> findByDosageForm(String dosageForm);

    /** All prescription-only (true) or over-the-counter (false) medicines. */
    List<Medicine> findByIsPrescription(Boolean isPrescription);

    /** All medicines from one knowledge source. */
    List<Medicine> findBySourceId(Long sourceId);
}