package org.example.repository;

import org.example.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Attr;

import java.util.List;
import java.util.Optional;


@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    // This method finds all attractions by associated park ID
    List<Attraction> findByParkId(Long parkId);

    // This method finds an attraction by its ID
    Optional<Attraction> findById(Long attractionId);

    // This method finds an attraction by its ID and associated park ID
    Optional<Attraction> findByParkIdAndId(Long parkId, Long attractionId);
}
