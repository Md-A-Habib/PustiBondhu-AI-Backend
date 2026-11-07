package com.pustibondhu.backend.health.medical.storage;

/**
 * Interface that defines how uploaded medical files are stored, retrieved, and
 * deleted. Keeps the rest of the code independent of where files physically
 * live, so local storage can later be replaced with cloud storage.
 */
public interface FileStorageService {
}
