package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Attraction;
import org.example.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AttractionService {
    private AttractionRepository attractionRepository;


    // This enables us to use the methods from JpaRepository
    @Autowired
    public void setAttractionRepository(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }


    /**
     * Retrieves a list of attractions.
     *
     * @return A list of attractions.
     * @throws ResourceNotFoundException if no attractions are found.
     */
    public List<Attraction> getAllAttractionsByParkId(Long parkId) {
        List<Attraction> attractionList = attractionRepository.findByParkId(parkId);

        if (attractionList.isEmpty()) {
            throw new ResourceNotFoundException("Error retrieving attractions from the database. No attractions found.");
        } else {
            return attractionList;
        }
    }


    /**
     * Retrieves an attraction from the database based on the provided parkId and attractionId.
     *
     * @param parkId The ID of the theme park for which attractions are to be retrieved.
     * @param attractionId The unique identifier of the attraction to retrieve.
     * @return An Optional containing the attraction if found, or empty if not found.
     * @throws ResourceNotFoundException if the attraction with the specified attractionId is not found in the database.
     */
    public Optional<Attraction> getAttractionByParkIdAndId(Long parkId, Long attractionId) {
        Optional<Attraction> attractionOptional = attractionRepository.findByParkIdAndId(parkId, attractionId);

        if (attractionOptional.isPresent()) {
            return attractionOptional;
        } else {
            throw new ResourceNotFoundException("Error retrieving attraction with id " + attractionId + " from the database. Attraction with id " + attractionId + " not found");
        }
    }

}
