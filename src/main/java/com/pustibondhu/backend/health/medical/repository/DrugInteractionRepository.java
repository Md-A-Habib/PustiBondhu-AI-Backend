package com.pustibondhu.backend.health.medical.repository;

import com.pustibondhu.backend.health.medical.entity.DrugInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access layer for {@link DrugInteraction}.
 * Module: HEALTH | Table: drug_interactions | Migration: V100 | Author: Ahsan
 */
@Repository
public interface DrugInteractionRepository extends JpaRepository<DrugInteraction, Long> {

    /** All interactions of a given severity (MINOR / MODERATE / MAJOR). */
    List<DrugInteraction> findBySeverity(String severity);

    /** All interactions where the ingredient appears on either side. */
    @Query("SELECT d FROM DrugInteraction d "
            + "WHERE d.ingredientA.id = :ingredientId OR d.ingredientB.id = :ingredientId")
    List<DrugInteraction> findByIngredientId(@Param("ingredientId") Long ingredientId);

    /** The interaction between two ingredients, in either order. */
    @Query("SELECT d FROM DrugInteraction d "
            + "WHERE (d.ingredientA.id = :firstId AND d.ingredientB.id = :secondId) "
            + "OR (d.ingredientA.id = :secondId AND d.ingredientB.id = :firstId)")
    Optional<DrugInteraction> findBetween(@Param("firstId") Long firstId,
                                          @Param("secondId") Long secondId);

    /** All interactions from one knowledge source. */
    List<DrugInteraction> findBySourceId(Long sourceId);
}