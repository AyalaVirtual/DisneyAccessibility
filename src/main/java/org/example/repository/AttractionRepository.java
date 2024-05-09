package org.example.repository;

import org.example.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    // This method finds an attraction by its id
    Optional<Attraction> findById(Long parkId, Long attractionId);
    // This method finds an attraction by its name
    Optional<Attraction> findByName(String attractionName);
}
