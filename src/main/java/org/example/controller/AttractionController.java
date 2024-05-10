package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Attraction;
import org.example.service.AttractionService;
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
public class AttractionController {
    private AttractionService attractionService;
    static HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setAttractionService(AttractionService attractionService) {
        this.attractionService = attractionService;
    }


    /**
     * This method handles GET requests to fetch a specific theme park's list of attractions from the AttractionService.
     * If the attractions are found, it returns a ResponseEntity with a success message and the list of attractions.
     * If the attractions are not found, or an error occurs during retrieval, it returns a ResponseEntity with an error message and an appropriate HTTP status code.
     *
     * @param parkId The ID of the theme park for which attractions are to be retrieved.
     * @return ResponseEntity<?> A ResponseEntity containing either a success message and list of attractions (HTTP 200 OK), or an error message (HTTP 404 NOT FOUND).
     */
    @GetMapping(path = "/parks/{parkId}/attractions/")
    public ResponseEntity<?> getAllAttractionsByParkId(@PathVariable(value = "parkId") Long parkId) {
        try {
            List<Attraction> attractionList = attractionService.getAllAttractionsByParkId(parkId);
            message.put("message", "success");
            message.put("data", attractionList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(ResourceNotFoundException resourceNotFoundException) {
            message.put("message", "List of attractions not found.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Retrieves a specific attraction based on the provided parkId and attractionId.
     *
     * This method handles GET requests to fetch a specific attraction by its associated theme park's ID and the attraction's ID from the AttractionService.
     * If the attraction is found and the associated theme park's list of attractions contain the specific attraction, it returns a ResponseEntity with a success message and the attraction's details.
     * If the attraction is not found, or it is not contained within the associated theme park's list of attractions, an error occurs during retrieval, and it returns a ResponseEntity with an error message and an appropriate HTTP status code.
     *
     * @param parkId The ID of the theme park for which attractions are to be retrieved.
     * @param attractionId The ID of the attraction to retrieve.
     * @return ResponseEntity<?> A ResponseEntity containing either a success message and the attraction's details (HTTP 200 OK), or an error message (HTTP 404 NOT FOUND).
     */
    @GetMapping(path = "/parks/{parkId}/attractions/{attractionId}/")
    public ResponseEntity<?> getAttractionByParkIdAndId(@PathVariable(value = "parkId") Long parkId, @PathVariable(value = "attractionId") Long attractionId) {
        try {
            Optional<Attraction> attractionOptional = attractionService.getAttractionByParkIdAndId(parkId, attractionId);
            message.put("message", "success");
            message.put("data", attractionOptional);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(ResourceNotFoundException resourceNotFoundException) {
            message.put("message", "Attraction with id " + attractionId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
