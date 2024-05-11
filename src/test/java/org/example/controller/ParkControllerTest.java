package org.example.controller;

import org.example.model.Park;
import org.example.service.ParkService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.ArgumentMatchers.anyLong;


@WebMvcTest(ParkController.class)
public class ParkControllerTest {
    // using Spring's @Autowired annotation to inject an instance of MockMvc into this class
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkService parkService;


    @Autowired
    ObjectMapper objectMapper;


    Park magicKingdom = new Park(1L, "Magic Kingdom", "image URL", "random description for Magic Kingdom", 12.24, 20.17);
    Park hollywoodStudios = new Park(2L, "Hollywood Studios", "image URL", "random description for Hollywood Studios", 8.14, 19.88);
    Park animalKingdom = new Park(2L, "Animal Kingdom", "image URL", "random description for Animal Kingdom", 7.02, 19.77);
    Park epcot = new Park(2L, "Epcot", "image URL", "random description for Epcot", 3.01, 20.08);


    /**
     * This test says that when we call parkService.getAllParks(), then to return all parks.
     * Use mockMvc to perform a GET request to the endpoint ("/api/parks/"), set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the 'data' key of the payload to have a size of 3. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if list of parks not found
     */
    @Test
    public void getAllParkRecords_success() throws Exception {
        List<Park> parks = new ArrayList<>(Arrays.asList(magicKingdom, hollywoodStudios, animalKingdom, epcot));

        when(parkService.getAllParks()).thenReturn(parks);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/parks/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // jsonPath helps us check that we have a data key and a message key. '$' represents the payload
                .andExpect(jsonPath("$.data", hasSize(4))) // This represents the "data" key from Postman for this particular HTTP request. (How many object instances created as examples above)
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }


    /**
     * This test says that when we call parkService.getParkById(), then to return the park if it exists.
     * Perform a GET request to the endpoint and uri variable ("/api/parks/{id}/", "1"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if park not found
     */
    @Test
    public void getParkRecord_success() throws Exception {

        when(parkService.getParkById(magicKingdom.getId())).thenReturn(Optional.of(magicKingdom));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/parks/{id}/", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(magicKingdom.getId()))
                .andExpect(jsonPath("$.data.name").value(magicKingdom.getName()))
                .andExpect(jsonPath("$.data.imageUrl").value(magicKingdom.getImageUrl()))
                .andExpect(jsonPath("$.data.description").value(magicKingdom.getDescription()))
                .andExpect(jsonPath("$.data.latitude").value(magicKingdom.getLatitude()))
                .andExpect(jsonPath("$.data.longitude").value(magicKingdom.getLongitude()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

}
