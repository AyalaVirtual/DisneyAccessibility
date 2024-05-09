package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.ParkAccessibility;
import org.example.service.ParkAccessibilityService;
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
public class ParkAccessibilityController {
    private ParkAccessibilityService parkAccessibilityService;

    static HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setParkAccessibilityService(ParkAccessibilityService parkAccessibilityService) {
        this.parkAccessibilityService = parkAccessibilityService;
    }



    @GetMapping(path = "/parks/{parkId}/parkaccessibility/{parkAccessibilityId}/")
    public ResponseEntity<?> getParkAccessibilityById(@PathVariable(value = "parkId") Long parkId, @PathVariable(value = "parkAccessibilityId") Long parkAccessibilityId) {

        try {
            Optional<ParkAccessibility> parkAccessibilityOptional = parkAccessibilityService.getParkAccessibilityById(parkId, parkAccessibilityId);
            message.put("message", "success");
            message.put("data", parkAccessibilityOptional);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(ResourceNotFoundException resourceNotFoundException) {
            message.put("message", "Accessibility details for park with id " + parkId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
