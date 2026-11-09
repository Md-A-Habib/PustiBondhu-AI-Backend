package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.LabReferenceRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access layer for {@link LabReferenceRange}.
 * Module: HEALTH | Table: lab_reference_ranges | Migration: V102 | Author: Ahsan
 */
@Repository
public interface LabReferenceRangeRepository extends JpaRepository<LabReferenceRange, Long> {

    /** All reference ranges of a lab test. */
    List<LabReferenceRange> findByLabTestId(Long labTestId);

    /** A lab test's ranges for one sex (MALE / FEMALE / ANY). */
    List<LabReferenceRange> findByLabTestIdAndSex(Long labTestId, String sex);

    /** All ranges from one knowledge source. */
    List<LabReferenceRange> findBySourceId(Long sourceId);

    /**
     * Ranges of a lab test that apply to a person: matching sex (or ANY)
     * and an age inside the range (null age bounds mean no limit).
     */
    @Query("SELECT r FROM LabReferenceRange r "
            + "WHERE r.labTest.id = :labTestId "
            + "AND (r.sex = :sex OR r.sex = 'ANY') "
            + "AND (r.ageMin IS NULL OR r.ageMin <= :age) "
            + "AND (r.ageMax IS NULL OR r.ageMax >= :age)")
    List<LabReferenceRange> findApplicable(@Param("labTestId") Long labTestId,
                                           @Param("sex") String sex,
                                           @Param("age") Integer age);
}