package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Attraction;
import org.example.model.Park;
import org.example.repository.AttractionRepository;
import org.example.repository.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AttractionService {
    private ParkRepository parkRepository;
    private AttractionRepository attractionRepository;


    // This enables us to use the methods from JpaRepository
    @Autowired
    public void setParkRepository(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    @Autowired
    public void setAttractionRepository(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }


    /**
     * Retrieves a list of attractions for a specific theme park based on the provided parkId.
     *
     * @param parkId The ID of the theme park for which attractions are to be retrieved.
     * @return A list of attractions associated with the specified theme park.
     * @throws ResourceNotFoundException if no attractions are found for the specified parkId.
     */
    public List<Attraction> getAllAttractions(Long parkId) {
        Optional<Park> parkOptional = Optional.of(parkRepository.getById(parkId));
        List<Attraction> attractionList = attractionRepository.findAll();

        if (parkOptional.isPresent() && !attractionList.isEmpty()) {
            return attractionList;
        } else {
            throw new ResourceNotFoundException("Error retrieving attractions from the database. No attractions found.");
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
    public Optional<Attraction> getAttractionById(Long parkId, Long attractionId) {
        Optional<Park> parkOptional = parkRepository.findById(parkId);
        Optional<Attraction> attractionOptional = attractionRepository.findById(attractionId);

        if (attractionOptional.isPresent() && parkOptional.get().getAttractionList().contains(attractionOptional)) {
            return attractionOptional;
        } else {
            throw new ResourceNotFoundException("Error retrieving attraction with id " + attractionId + " from the database. Attraction with id " + attractionId + " not found");
        }
    }

}
