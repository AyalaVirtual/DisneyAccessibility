package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Park;
import org.example.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api") // http://localhost:8080/api/
public class ParkController {
    private ParkService parkService;

    static HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setParkService(ParkService parkService) {
        this.parkService = parkService;
    }


    /**
     * This method handles GET requests to fetch a list of theme parks from the ParkService.
     * If the parks are found, it returns a ResponseEntity with a success message and the list of theme parks.
     * If no parks are found or an error occurs during retrieval, it returns a ResponseEntity
     *  with an error message and an appropriate HTTP status code.
     *
     * @return ResponseEntity<?> A ResponseEntity containing either a success message and list of theme parks (HTTP 200 OK), or an error message (HTTP 404 NOT FOUND).
     */
    @GetMapping(path = "/parks/")
    public ResponseEntity<?> getAllParks() {
        try {
            List<Park> parkList = parkService.getAllParks();
            message.put("message", "success");
            message.put("data", parkList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(ResourceNotFoundException) {
            message.put("message", "List of parks not found.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Retrieves a theme park by its ID.
     *
     * This method handles GET requests to fetch a theme park identified by its ID from the ParkService.
     * If the park is found, it returns a ResponseEntity with a success message and the park details.
     * If the park is not found or an error occurs during retrieval, it returns a ResponseEntity
     * with an error message and an appropriate HTTP status code.
     *
     * @param parkId The ID of the theme park to retrieve.
     * @return ResponseEntity<?> A ResponseEntity containing either a success message and park details (HTTP 200 OK), or an error message (HTTP 404 NOT FOUND).
     */
    @GetMapping(path = "/parks/{parkId}/")
    public ResponseEntity<?> getParkById(@PathVariable(value = "parkId") Long parkId) {
        try {
            Optional<Park> parkOptional = parkService.getParkById(parkId);
            message.put("message", "success");
            message.put("data", parkOptional);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(ResourceNotFoundException) {
            message.put("message", "Park with id " + parkId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
