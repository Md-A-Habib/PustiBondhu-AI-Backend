package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access layer for {@link PrescriptionItem}.
 * Module: HEALTH | Table: prescription_items | Migration: V101 | Author: Ahsan
 */
@Repository
public interface PrescriptionItemRepository extends JpaRepository<PrescriptionItem, Long> {

    /** All items of a prescription. */
    List<PrescriptionItem> findByPrescriptionId(Long prescriptionId);

    /** All prescription items matched to a brand medicine. */
    List<PrescriptionItem> findByMedicineId(Long medicineId);

    /** Items not yet matched to a brand medicine (needs review). */
    List<PrescriptionItem> findByMedicineIsNull();

    /** Searches items by raw medicine name (case-insensitive, partial match). */
    List<PrescriptionItem> findByMedicineNameRawContainingIgnoreCase(String medicineNameRaw);

    /** Deletes all items of a prescription. */
    void deleteByPrescriptionId(Long prescriptionId);
}