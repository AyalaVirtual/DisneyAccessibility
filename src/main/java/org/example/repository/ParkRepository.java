package org.example.repository;

import org.example.model.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ParkRepository extends JpaRepository<Park, Long> {
    // This method finds a park by its id
    Optional<Park> findById(Long parkId);
    // This method finds a park by its name
    Optional<Park> findByName(String parkName);
}
