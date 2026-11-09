package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link Prescription}.
 * Module: HEALTH | Table: prescriptions | Migration: V101 | Author: Ahsan
 */
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    /** All prescriptions of a user. */
    List<Prescription> findByUserId(Long userId);

    /** The prescription created from one uploaded document. */
    Optional<Prescription> findByDocumentId(Long documentId);

    /** A user's prescriptions still valid on the given date. */
    List<Prescription> findByUserIdAndValidUntilGreaterThanEqual(Long userId, LocalDate date);

    /** A user's prescriptions by one doctor. */
    List<Prescription> findByUserIdAndDoctorNameContainingIgnoreCase(Long userId, String doctorName);
}