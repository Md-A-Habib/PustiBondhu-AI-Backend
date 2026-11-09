package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.UserMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access layer for {@link UserMedication}.
 * Module: HEALTH | Table: user_medications | Migration: V101 | Author: Ahsan
 */
@Repository
public interface UserMedicationRepository extends JpaRepository<UserMedication, Long> {

    /** All medications of a user. */
    List<UserMedication> findByUserId(Long userId);

    /** A user's active (true) or inactive (false) medications. */
    List<UserMedication> findByUserIdAndIsActive(Long userId, Boolean isActive);

    /** All regimens that use a given brand medicine. */
    List<UserMedication> findByMedicineId(Long medicineId);

    /** All regimens created from one prescription item. */
    List<UserMedication> findByPrescriptionItemId(Long prescriptionItemId);
}