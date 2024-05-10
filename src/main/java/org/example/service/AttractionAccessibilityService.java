package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.AttractionAccessibility;
import org.example.repository.AttractionAccessibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AttractionAccessibilityService {
    private AttractionAccessibilityRepository attractionAccessibilityRepository;


    // This enables us to use the methods from JpaRepository
    @Autowired
    public void setAttractionAccessibilityRepository(AttractionAccessibilityRepository attractionAccessibilityRepository) {
        this.attractionAccessibilityRepository = attractionAccessibilityRepository;
    }


    /**
     * Retrieves an attraction's accessibility details by ID.
     *
     * @param attractionAccessibilityId The ID of the attraction's accessibility details to retrieve.
     * @return An Optional containing the attraction's accessibility details if found, else an empty Optional.
     * @throws ResourceNotFoundException if the attraction's accessibility details are not found.
     */
    public Optional<AttractionAccessibility> getAttractionAccessibilityById(Long attractionAccessibilityId) {
        Optional<AttractionAccessibility> attractionAccessibilityOptional = attractionAccessibilityRepository.findById(attractionAccessibilityId);

        if (attractionAccessibilityOptional.isPresent()) {
            return attractionAccessibilityOptional;
        } else {
            throw new ResourceNotFoundException("Error retrieving attraction accessibility details with id " + attractionAccessibilityId + " from the database. No attraction accessibility details found.");
        }
    }

}
