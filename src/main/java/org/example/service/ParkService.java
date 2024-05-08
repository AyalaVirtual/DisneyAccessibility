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
     * This is a GET request that checks to see if the list of theme parks is empty before either throwing a ResourceNotFoundException, or returning the list of all available theme parks
     *
     * @return a list of all available theme parks
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
     * This is a GET request that checks to see if an individual theme park exists before either returning it, or throwing a ResourceNotFoundException
     *
     * @param parkId represents the id of the specific theme park the user is trying to get
     * @return a theme park by its id if it exists
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
