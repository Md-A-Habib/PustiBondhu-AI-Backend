package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.LabReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link LabReport}.
 * Module: HEALTH | Table: lab_reports | Migration: V102 | Author: Ahsan
 */
@Repository
public interface LabReportRepository extends JpaRepository<LabReport, Long> {

    /** All reports of a user, newest first. */
    List<LabReport> findByUserIdOrderByReportDateDesc(Long userId);

    /** A user's reports with a given review status (PENDING_REVIEW / CONFIRMED). */
    List<LabReport> findByUserIdAndReviewStatus(Long userId, String reviewStatus);

    /** The report created from one uploaded document. */
    Optional<LabReport> findByDocumentId(Long documentId);

    /** A user's reports within a date range. */
    List<LabReport> findByUserIdAndReportDateBetween(Long userId, LocalDate from, LocalDate to);
}