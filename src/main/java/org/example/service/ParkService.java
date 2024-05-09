package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Park;
import org.example.repository.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ParkService {
    private ParkRepository parkRepository;


    // This enables us to use the methods from JpaRepository
    @Autowired
    public void setParkRepository(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }


    /**
     * Retrieves a list of all theme parks stored in the database.
     *
     * @return A list of theme parks if found, or throws ResourceNotFoundException if no theme parks are found.
     * @throws ResourceNotFoundException if no theme parks are found in the database.
     */
    public List<Park> getAllParks() {
        List<Park> parkList = parkRepository.findAll();

        if (parkList.isEmpty()) {
            throw new ResourceNotFoundException("Error retrieving theme parks from the database. No theme parks found.");
        } else {
            return parkList;
        }
    }


    /**
     * Retrieves a theme park from the database based on the provided parkId.
     *
     * @param parkId The unique identifier of the theme park to retrieve.
     * @return An Optional containing the theme park if found, or empty if not found.
     * @throws ResourceNotFoundException if the theme park with the specified parkId is not found in the database.
     */
    public Optional<Park> getParkById(Long parkId) {
        Optional<Park> parkOptional = parkRepository.findById(parkId);

        if (parkOptional.isPresent()) {
            return parkOptional;
        } else {
            throw new ResourceNotFoundException("Error retrieving theme park with id " + parkId + " from the database. Park with id " + parkId + " not found");
        }
    }

}
