package org.example.controller;

import org.example.model.Attraction;
import org.example.model.AttractionAccessibility;
import org.example.model.Park;
import org.example.model.ParkAccessibility;
import org.example.model.attractionaccessibilityattributes.MustTransfer;
import org.example.model.attractionaccessibilityattributes.SensoryExperience;
import org.example.service.ParkAccessibilityService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ParkAccessibilityController.class)
public class ParkAccessibilityControllerTest {
    // using Spring's @Autowired annotation to inject an instance of MockMvc into this class
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkAccessibilityService parkAccessibilityService;


    @Autowired
    ObjectMapper objectMapper;


    Park hollywoodStudios = new Park(1L, "Hollywood Studios", "image URL", "Embark on a daring quest to incredible worlds.", 12.24, 20.17);

    List<String> randomList = new ArrayList<>();

    ParkAccessibility hollywoodStudiosA11y = new ParkAccessibility(1L, randomList, randomList, randomList, randomList, "Fridays", randomList,randomList,randomList,randomList,randomList, "by Main entrance", hollywoodStudios);


    /**
     * This test says that when we call parkAccessibilityService.getAttractionAccessibilityByParkIdAndId(), then to return the park's accessibility details if they exist.
     * Perform a GET request to the endpoint and uri variable ("/api/parks/{parkId}/parkaccessibility/{id}/", "1", "1"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if park's accessibility details not found
     */
    @Test
    public void getParkAccessibilityRecord_success() throws Exception {

        when(parkAccessibilityService.getParkAccessibilityByParkIdAndId(hollywoodStudios.getId(), hollywoodStudiosA11y.getId())).thenReturn(Optional.of(hollywoodStudiosA11y));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/parks/{parkId}/parkaccessibility/{id}/", "1", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(hollywoodStudiosA11y.getId()))
                .andExpect(jsonPath("$.data.rentalLocations").value(hollywoodStudiosA11y.getRentalLocations()))
                .andExpect(jsonPath("$.data.wheelchairReplacementLocations").value(hollywoodStudiosA11y.getWheelchairReplacementLocations()))
                .andExpect(jsonPath("$.data.breakLocations").value(hollywoodStudiosA11y.getBreakLocations()))
                .andExpect(jsonPath("$.data.stationaryBrailleMapLocations").value(hollywoodStudiosA11y.getStationaryBrailleMapLocations()))
                .andExpect(jsonPath("$.data.signLanguageSchedule").value(hollywoodStudiosA11y.getSignLanguageSchedule()))
                .andExpect(jsonPath("$.data.guestRelationsLocations").value(hollywoodStudiosA11y.getGuestRelationsLocations()))
                .andExpect(jsonPath("$.data.serviceAnimalRestrictions_Ride").value(hollywoodStudiosA11y.getServiceAnimalRestrictions_Ride()))
                .andExpect(jsonPath("$.data.serviceAnimalRestrictions_Board").value(hollywoodStudiosA11y.getServiceAnimalRestrictions_Board()))
                .andExpect(jsonPath("$.data.serviceAnimalReliefAreas").value(hollywoodStudiosA11y.getServiceAnimalReliefAreas()))
                .andExpect(jsonPath("$.data.companionRestroomLocations").value(hollywoodStudiosA11y.getCompanionRestroomLocations()))
                .andExpect(jsonPath("$.data.firstAidLocations").value(hollywoodStudiosA11y.getFirstAidLocations()))

                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

}
