package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.AttractionAccessibility;
import org.example.service.AttractionAccessibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;


@RestController
@RequestMapping("/api") // http://localhost:8080/api/
public class AttractionAccessibilityController {
    private AttractionAccessibilityService attractionAccessibilityService;
    static HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setAttractionAccessibilityService(AttractionAccessibilityService attractionAccessibilityService) {
        this.attractionAccessibilityService = attractionAccessibilityService;
    }


    /**
     * Retrieves the accessibility details for a specific attraction by its attraction ID and accessibility ID.
     *
     * @param attractionId The ID of the attraction whose accessibility details the user is trying to retrieve.
     * @param attractionAccessibilityId The ID of the relevant accessibility details to retrieve.
     * @return ResponseEntity with the attraction's accessibility details and a success message if found (HTTP 200), or an error message and HTTP 404 if not found.
     */
    @GetMapping(path = "/parks/{parkId}/attractions/{attractionId}/attractionaccessibility/{attractionAccessibilityId}/")
    public ResponseEntity<?> getAttractionAccessibilityByAttractionIdAndId(@PathVariable(value = "attractionId") Long attractionId, @PathVariable(value = "attractionAccessibilityId") Long attractionAccessibilityId) {
        try {
            Optional<AttractionAccessibility> attractionAccessibilityOptional = attractionAccessibilityService.getAttractionAccessibilityByAttractionIdAndId(attractionId, attractionAccessibilityId);
            message.put("message", "success");
            message.put("data", attractionAccessibilityOptional);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(ResourceNotFoundException resourceNotFoundException) {
            message.put("message", "Attraction accessibility details with id " + attractionAccessibilityId + " not found");
            return new ResponseEntity<>(message.get("message"), HttpStatus.NOT_FOUND);
        }
    }

}
