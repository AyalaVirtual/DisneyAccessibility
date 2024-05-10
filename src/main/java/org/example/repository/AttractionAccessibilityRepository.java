package org.example.repository;

import org.example.model.Attraction;
import org.example.model.AttractionAccessibility;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface AttractionAccessibilityRepository extends JpaRepository<AttractionAccessibility, Long> {
    // This finds an attraction's accessibility details by id
    Optional<AttractionAccessibility> findById(Long attractionAccessibilityId);

    // This method finds an attraction's accessibility details by ID and associated attraction ID
    Optional<AttractionAccessibility> findByAttractionIdAndId(Long attractionId, Long attractionAccessibilityId);

}
