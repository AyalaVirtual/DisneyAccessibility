package org.example.controller;

import org.example.model.Attraction;
import org.example.model.AttractionAccessibility;
import org.example.model.Park;
import org.example.model.attractionaccessibilityattributes.*;
import org.example.service.AttractionAccessibilityService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AttractionAccessibilityController.class)
public class AttractionAccessibilityControllerTest {
    // using Spring's @Autowired annotation to inject an instance of MockMvc into this class
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AttractionAccessibilityService attractionAccessibilityService;


    @Autowired
    ObjectMapper objectMapper;


    Park magicKingdom = new Park(1L, "Magic Kingdom", "image URL", "Enter enchanting lands and step inside fantastical stories.", 12.24, 20.17);
    Attraction cinderellasCastle = new Attraction(1L, "Cinderella's Castle", "image URL", "Inspired by the castle in the Disney film Cinderella, this enchanting edifice is the symbol of Magic Kingdom park.", 12.24, 20.17, magicKingdom);
    MustTransfer mustTransfer = new MustTransfer(true, false, true, false, true);

    TransferAssistance transferAssistance = new TransferAssistance(true, false, true, false);

    ServiceAnimalRestrictions serviceAnimalRestrictions = new ServiceAnimalRestrictions(true, false);

    AssistiveDevices assistiveDevices = new AssistiveDevices(true, false, true, false, true);

    SensoryExperience sensoryExperience = new SensoryExperience(true, false, true, false, true, true, false, true, "sudden turns and drops", "seatbelts", "7 minutes");
    AttractionAccessibility cinderellasCastleA11y = new AttractionAccessibility(1L, mustTransfer, transferAssistance, serviceAnimalRestrictions, assistiveDevices, sensoryExperience, cinderellasCastle);


    /**
     * This test says that when we call attractionAccessibilityService.getAttractionAccessibilityByAttractionIdAndId(), then to return the attraction's accessibility details if they exist.
     * Perform a GET request to the endpoint and uri variable ("/api/parks/{parkId}/attractions/{attractionId}/attractionaccessibility/{id}/", "1", "1", "1"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if attraction's accessibility details not found
     */
    @Test
    public void getAttractionAccessibilityRecord_success() throws Exception {

        when(attractionAccessibilityService.getAttractionAccessibilityByAttractionIdAndId(cinderellasCastle.getId(), cinderellasCastleA11y.getId())).thenReturn(Optional.of(cinderellasCastleA11y));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/parks/{parkId}/attractions/{attractionId}/attractionaccessibility/{id}/", "1", "1", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(cinderellasCastleA11y.getId()))
                .andExpect(jsonPath("$.data.mustTransfer.mayRemainInWheelchairEcv").value(cinderellasCastleA11y.getMustTransfer().getMayRemainInWheelchairEcv()))
                .andExpect(jsonPath("$.data.mustTransfer.mustBeAmbulatory").value(cinderellasCastleA11y.getMustTransfer().getMustBeAmbulatory()))
                .andExpect(jsonPath("$.data.mustTransfer.mustTransferFromWheelchairEcv").value(cinderellasCastleA11y.getMustTransfer().getMustTransferFromWheelchairEcv()))
                .andExpect(jsonPath("$.data.mustTransfer.mustTransferToWheelchair").value(cinderellasCastleA11y.getMustTransfer().getMustTransferToWheelchair()))
                .andExpect(jsonPath("$.data.mustTransfer.mustTransferToWheelchairThenToRide").value(cinderellasCastleA11y.getMustTransfer().getMustTransferToWheelchairThenToRide()))
                 .andExpect(jsonPath("$.data.transferAssistance.loadUnloadAreas").value(cinderellasCastleA11y.getTransferAssistance().getLoadUnloadAreas()))
                .andExpect(jsonPath("$.data.transferAssistance.wheelchairAccessVehicles").value(cinderellasCastleA11y.getTransferAssistance().getWheelchairAccessVehicles()))
                .andExpect(jsonPath("$.data.transferAssistance.transferAccessVehicle").value(cinderellasCastleA11y.getTransferAssistance().getTransferAccessVehicle()))
                .andExpect(jsonPath("$.data.transferAssistance.transferDevices").value(cinderellasCastleA11y.getTransferAssistance().getTransferDevices()))
                .andExpect(jsonPath("$.data.serviceAnimalRestrictions.rideRestrictions").value(cinderellasCastleA11y.getServiceAnimalRestrictions().getRideRestrictions()))
                .andExpect(jsonPath("$.data.serviceAnimalRestrictions.boardRestrictions").value(cinderellasCastleA11y.getServiceAnimalRestrictions().getBoardRestrictions()))
                .andExpect(jsonPath("$.data.assistiveDevices.assistiveListening").value(cinderellasCastleA11y.getAssistiveDevices().getAssistiveListening()))
                .andExpect(jsonPath("$.data.assistiveDevices.audioDescription").value(cinderellasCastleA11y.getAssistiveDevices().getAudioDescription()))
                .andExpect(jsonPath("$.data.assistiveDevices.handheldCaptioning").value(cinderellasCastleA11y.getAssistiveDevices().getHandheldCaptioning()))
                .andExpect(jsonPath("$.data.assistiveDevices.signLanguage").value(cinderellasCastleA11y.getAssistiveDevices().getSignLanguage()))
                .andExpect(jsonPath("$.data.assistiveDevices.videoCaptioning").value(cinderellasCastleA11y.getAssistiveDevices().getVideoCaptioning()))
                .andExpect(jsonPath("$.data.sensoryExperience.scentSmell").value(cinderellasCastleA11y.getSensoryExperience().getScentSmell()))
                .andExpect(jsonPath("$.data.sensoryExperience.lightingEffects").value(cinderellasCastleA11y.getSensoryExperience().getLightingEffects()))
                .andExpect(jsonPath("$.data.sensoryExperience.loudNoises").value(cinderellasCastleA11y.getSensoryExperience().getLoudNoises()))
                .andExpect(jsonPath("$.data.sensoryExperience.periodsOfDarkness").value(cinderellasCastleA11y.getSensoryExperience().getPeriodsOfDarkness()))
                .andExpect(jsonPath("$.data.sensoryExperience.bumpy").value(cinderellasCastleA11y.getSensoryExperience().isBumpy()))
                .andExpect(jsonPath("$.data.sensoryExperience.fast").value(cinderellasCastleA11y.getSensoryExperience().isFast()))
                .andExpect(jsonPath("$.data.sensoryExperience.liftsOffGround").value(cinderellasCastleA11y.getSensoryExperience().getLiftsOffGround()))
                .andExpect(jsonPath("$.data.sensoryExperience.wet").value(cinderellasCastleA11y.getSensoryExperience().isWet()))
                .andExpect(jsonPath("$.data.sensoryExperience.elementOfSurprise").value(cinderellasCastleA11y.getSensoryExperience().getElementOfSurprise()))
                .andExpect(jsonPath("$.data.sensoryExperience.typeOfRestraint").value(cinderellasCastleA11y.getSensoryExperience().getTypeOfRestraint()))
                .andExpect(jsonPath("$.data.sensoryExperience.tripTime").value(cinderellasCastleA11y.getSensoryExperience().getTripTime()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

}
