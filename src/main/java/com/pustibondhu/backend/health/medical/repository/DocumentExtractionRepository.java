package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.DocumentExtraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link DocumentExtraction}.
 * Module: HEALTH | Table: document_extractions | Migration: V101 | Author: Ahsan
 */
@Repository
public interface DocumentExtractionRepository extends JpaRepository<DocumentExtraction, Long> {

    /** All extractions of a document. */
    List<DocumentExtraction> findByDocumentId(Long documentId);

    /** All extractions produced by one AI job. */
    List<DocumentExtraction> findByJobId(Long jobId);

    /** All extractions with a given review status (PENDING_REVIEW / CONFIRMED). */
    List<DocumentExtraction> findByReviewStatus(String reviewStatus);

    /** A document's extractions with a given review status. */
    List<DocumentExtraction> findByDocumentIdAndReviewStatus(Long documentId, String reviewStatus);

    /** The latest extraction of a document. */
    Optional<DocumentExtraction> findFirstByDocumentIdOrderByIdDesc(Long documentId);
}