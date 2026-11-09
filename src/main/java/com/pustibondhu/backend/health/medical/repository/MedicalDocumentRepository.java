package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.MedicalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link MedicalDocument}.
 * Module: HEALTH | Table: medical_documents | Migration: V101 | Author: Ahsan
 */
@Repository
public interface MedicalDocumentRepository extends JpaRepository<MedicalDocument, Long> {

    /** All non-deleted documents of a user. */
    List<MedicalDocument> findByUserIdAndDeletedAtIsNull(Long userId);

    /** A user's non-deleted documents of one type (PRESCRIPTION / LAB_REPORT). */
    List<MedicalDocument> findByUserIdAndDocumentTypeAndDeletedAtIsNull(Long userId, String documentType);

    /** One non-deleted document by id. */
    Optional<MedicalDocument> findByIdAndDeletedAtIsNull(Long id);

    /** Finds a document by its storage key. */
    Optional<MedicalDocument> findByStorageKey(String storageKey);

    /** Finds a user's document by file checksum (used to detect duplicate uploads). */
    Optional<MedicalDocument> findByUserIdAndChecksumSha256AndDeletedAtIsNull(Long userId, String checksumSha256);
}