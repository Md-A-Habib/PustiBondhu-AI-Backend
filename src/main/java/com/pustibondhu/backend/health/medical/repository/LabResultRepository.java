package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access layer for {@link LabResult}.
 * Module: HEALTH | Table: lab_results | Migration: V102 | Author: Ahsan
 */
@Repository
public interface LabResultRepository extends JpaRepository<LabResult, Long> {

    /** All results of a lab report. */
    List<LabResult> findByLabReportId(Long labReportId);

    /** All results of one lab test (across reports). */
    List<LabResult> findByLabTestId(Long labTestId);

    /** A report's results with a given flag (NORMAL / LOW / HIGH / CRITICAL). */
    List<LabResult> findByLabReportIdAndFlag(Long labReportId, String flag);

    /** A user's result history for one lab test, newest report first. */
    @Query("SELECT r FROM LabResult r "
            + "WHERE r.labReport.user.id = :userId AND r.labTest.id = :labTestId "
            + "ORDER BY r.labReport.reportDate DESC")
    List<LabResult> findHistory(@Param("userId") Long userId,
                                @Param("labTestId") Long labTestId);

    /** Deletes all results of a lab report. */
    void deleteByLabReportId(Long labReportId);
}