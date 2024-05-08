package org.example.repository;

import org.example.model.ParkAccessibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ParkAccessibilityRepository extends JpaRepository<ParkAccessibility, Long> {
    // This method finds a theme park's accessibility details by id
    Optional<ParkAccessibility> findById(Long parkAccessibilityId);

}
