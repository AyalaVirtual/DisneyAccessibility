package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.ParkAccessibility;
import org.example.repository.ParkAccessibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ParkAccessibilityService {
    private ParkAccessibilityRepository parkAccessibilityRepository;


    // This enables us to use the methods from JpaRepository
    @Autowired
    public void setParkAccessibilityRepository(ParkAccessibilityRepository parkAccessibilityRepository) {
        this.parkAccessibilityRepository = parkAccessibilityRepository;
    }


    /**
     * Retrieves the accessibility details for a specific theme park by its park ID and accessibility ID.
     *
     * @param parkId The ID of the theme park whose accessibility details the user is trying to retrieve.
     * @param parkAccessibilityId The ID of the relevant accessibility details to retrieve.
     * @return An Optional containing the theme park's accessibility details if found, else an empty Optional.
     * @throws ResourceNotFoundException if the theme park's accessibility details are not found.
     */
    public Optional<ParkAccessibility> getParkAccessibilityByParkIdAndId(Long parkId, Long parkAccessibilityId) {
        Optional<ParkAccessibility> parkAccessibilityOptional = parkAccessibilityRepository.findByParkIdAndId(parkId, parkAccessibilityId);

        if (parkAccessibilityOptional.isPresent()) {
            return parkAccessibilityOptional;
        } else {
            throw new ResourceNotFoundException("Error retrieving park accessibility details with id " + parkAccessibilityId + " from the database. No park accessibility details found.");
        }
    }

}
