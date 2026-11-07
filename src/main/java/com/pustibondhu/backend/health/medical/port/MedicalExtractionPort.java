package com.pustibondhu.backend.health.medical.port;

/**
 * Port (interface) that the health module uses to request AI extraction of
 * uploaded medical reports. Defined by Ahsan so the health module never depends
 * on Katon's AI client directly; the core module provides the implementation.
 * Implemented in core by MedicalExtractionAdapter.
 */
public interface MedicalExtractionPort {
}
