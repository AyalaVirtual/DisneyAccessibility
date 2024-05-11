package org.example.controller;

import org.example.model.Attraction;
import org.example.model.Park;
import org.example.service.AttractionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Optional;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AttractionController.class)
public class AttractionControllerTest {
    // using Spring's @Autowired annotation to inject an instance of MockMvc into this class
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AttractionService attractionService;


    @Autowired
    ObjectMapper objectMapper;


    Park magicKingdom = new Park(1L, "Magic Kingdom", "image URL", "random description for Magic Kingdom", 12.24, 20.17);
    Attraction cinderellasCastle = new Attraction(1L, "Cinderella's Castle", "image URL", "Inspired by the castle in the Disney film Cinderella, this enchanting edifice is the symbol of Magic Kingdom park.", 12.24, 20.17, magicKingdom);
    Attraction jungleCruise = new Attraction(2L, "Jungle Cruise", "image URL", "Chart a course for high adventure on a scenic and comedic boat tour of exotic rivers across Asia, Africa and South America.", 8.14, 19.88, magicKingdom);
    Attraction hauntedMansion = new Attraction(3L, "Haunted Mansion", "image URL", "Climb aboard a gloomy Doom Buggy for a grave journey through a labyrinth of haunted chambers.", 7.02, 19.77, magicKingdom);


    /**
     * This test says that when we call attractionService.getAllAttractions(), then to return all attractions.
     * Use mockMvc to perform a GET request to the endpoint ("/api/attractions/"), set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the 'data' key of the payload to have a size of 3. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if list of attractions not found
     */
    @Test
    public void getAllAttractionRecords_success() throws Exception {
        List<Attraction> attractions = new ArrayList<>(Arrays.asList(cinderellasCastle, jungleCruise, hauntedMansion));

        when(attractionService.getAllAttractionsByParkId(magicKingdom.getId())).thenReturn(attractions);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/parks/{parkId}/attractions/", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // jsonPath helps us check that we have a data key and a message key. '$' represents the payload
                .andExpect(jsonPath("$.data", hasSize(3))) // This represents the "data" key from Postman for this particular HTTP request. (How many object instances created as examples above)
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }


    /**
     * This test says that when we call attractionService.getAttractionById(), then to return the attraction if it exists.
     * Perform a GET request to the endpoint and uri variable ("/api/attractions/{id}/", "1"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if attraction not found
     */
    @Test
    public void getAttractionRecord_success() throws Exception {

        when(attractionService.getAttractionByParkIdAndId(magicKingdom.getId(), cinderellasCastle.getId())).thenReturn(Optional.of(cinderellasCastle));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/parks/{parkId}/attractions/{id}/", "1", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(cinderellasCastle.getId()))
                .andExpect(jsonPath("$.data.name").value(cinderellasCastle.getName()))
                .andExpect(jsonPath("$.data.imageUrl").value(cinderellasCastle.getImageUrl()))
                .andExpect(jsonPath("$.data.description").value(cinderellasCastle.getDescription()))
                .andExpect(jsonPath("$.data.latitude").value(cinderellasCastle.getLatitude()))
                .andExpect(jsonPath("$.data.longitude").value(cinderellasCastle.getLongitude()))
                .andExpect(jsonPath("$.data.attractionAccessibility").value(cinderellasCastle.getAttractionAccessibility()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

}
