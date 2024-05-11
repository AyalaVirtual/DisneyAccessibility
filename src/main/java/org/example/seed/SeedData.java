package org.example.seed;

import org.example.model.Attraction;
import org.example.model.AttractionAccessibility;
import org.example.model.Park;
import org.example.model.ParkAccessibility;
import org.example.model.attractionaccessibilityattributes.MustTransfer;
import org.example.model.attractionaccessibilityattributes.SensoryExperience;
import org.example.repository.AttractionAccessibilityRepository;
import org.example.repository.AttractionRepository;
import org.example.repository.ParkAccessibilityRepository;
import org.example.repository.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;


@Component
public class SeedData implements CommandLineRunner {
    private final ParkRepository parkRepository;
    private final ParkAccessibilityRepository parkAccessibilityRepository;
    private final AttractionRepository attractionRepository;
    private final AttractionAccessibilityRepository attractionAccessibilityRepository;


    @Autowired
    public SeedData(ParkRepository parkRepository, ParkAccessibilityRepository parkAccessibilityRepository, AttractionRepository attractionRepository, AttractionAccessibilityRepository attractionAccessibilityRepository) {
        this.parkRepository = parkRepository;
        this.parkAccessibilityRepository = parkAccessibilityRepository;
        this.attractionRepository = attractionRepository;
        this.attractionAccessibilityRepository = attractionAccessibilityRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        List<String> randomList = new ArrayList<>();
        randomList.add("random string 1");
        randomList.add("random string 2");

        String image = "some image URL";

        MustTransfer mustTransfer = new MustTransfer();
        mustTransfer.setMustBeAmbulatory(false);
        mustTransfer.setMustTransferToWheelchair(false);
        mustTransfer.setMustTransferFromWheelchairEcv(true);
        mustTransfer.setMayRemainInWheelchairEcv(false);
        mustTransfer.setMustTransferToWheelchairThenToRide(false);


        SensoryExperience sensoryExperience = new SensoryExperience();
        sensoryExperience.setScentSmell(false);
        sensoryExperience.setLightingEffects(true);
        sensoryExperience.setLoudNoises(true);
        sensoryExperience.setPeriodsOfDarkness(false);
        sensoryExperience.setBumpy(false);
        sensoryExperience.setFast(false);
        sensoryExperience.setLiftsOffGround(false);
        sensoryExperience.setWet(false);
        sensoryExperience.setElementOfSurprise("sudden turns and drops");
        sensoryExperience.setTypeOfRestraint("seatbelt");
        sensoryExperience.setTripTime("7 minutes");


        Park magicKingdom = new Park();
        magicKingdom.setName("Magic Kingdom");
        magicKingdom.setImageUrl(image);
        magicKingdom.setDescription("Enter a world of enchantment and wonder at Magic Kingdom, where fairy tales come to life. From meeting beloved Disney characters to experiencing magical parades and fireworks, Magic Kingdom is a timeless destination for guests of all ages.");
        magicKingdom.setLatitude(28.4188);
        magicKingdom.setLongitude(81.5818);
        parkRepository.save(magicKingdom);

        ParkAccessibility magicKingdomA11y = new ParkAccessibility();
        magicKingdomA11y.setRentalLocations(randomList);
        magicKingdomA11y.setWheelchairReplacementLocations(randomList);
        magicKingdomA11y.setBreakLocations(randomList);
        magicKingdomA11y.setStationaryBrailleMapLocations(randomList);
        magicKingdomA11y.setSignLanguageSchedule("Schedule");
        magicKingdomA11y.setGuestRelationsLocations(randomList);
        magicKingdomA11y.setServiceAnimalRestrictions_Ride(randomList);
        magicKingdomA11y.setServiceAnimalRestrictions_Board(randomList);
        magicKingdomA11y.setServiceAnimalReliefAreas(randomList);
        magicKingdomA11y.setCompanionRestroomLocations(randomList);
        magicKingdomA11y.setFirstAidLocations("by front entrance");
        magicKingdomA11y.setPark(magicKingdom);
        parkAccessibilityRepository.save(magicKingdomA11y);


        Attraction cinderellasCastle = new Attraction();
        cinderellasCastle.setName("Cinderella Castle");
        cinderellasCastle.setImageUrl(image);
        cinderellasCastle.setDescription("Inspired by the castle in the Disney film Cinderella, this enchanting edifice is the symbol of Magic Kingdom park.");
        cinderellasCastle.setLatitude(12.24);
        cinderellasCastle.setLongitude(20.17);
        cinderellasCastle.setPark(magicKingdom);
        attractionRepository.save(cinderellasCastle);

        AttractionAccessibility cinderellasCastleA11y = new AttractionAccessibility();
        cinderellasCastleA11y.setMustTransfer(mustTransfer);
        cinderellasCastleA11y.setLoadUnloadAreas(true);
        cinderellasCastleA11y.setWheelchairAccessVehicles(true);
        cinderellasCastleA11y.setTransferAccessVehicle(true);
        cinderellasCastleA11y.setTransferDevices(false);
        cinderellasCastleA11y.setServiceAnimalRestrictions_Ride(true);
        cinderellasCastleA11y.setServiceAnimalRestrictions_Board(false);
        cinderellasCastleA11y.setAssistiveListening(true);
        cinderellasCastleA11y.setAudioDescription(false);
        cinderellasCastleA11y.setHandheldCaptioning(true);
        cinderellasCastleA11y.setSignLanguage(true);
        cinderellasCastleA11y.setVideoCaptioning(false);
        cinderellasCastleA11y.setSensoryExperience(sensoryExperience);
        cinderellasCastleA11y.setAttraction(cinderellasCastle);
        attractionAccessibilityRepository.save(cinderellasCastleA11y);


        Attraction meetAriel = new Attraction();
        meetAriel.setName("Meet Ariel at Her Grotto");
        meetAriel.setImageUrl(image);
        meetAriel.setDescription("The Little Mermaid greets friends from both the land and sea in her shimmering ocean retreat.");
        meetAriel.setLatitude(8.14);
        meetAriel.setLongitude(19.88);
        meetAriel.setPark(magicKingdom);
        attractionRepository.save(meetAriel);

        AttractionAccessibility meetArielA11y = new AttractionAccessibility();
        meetArielA11y.setMustTransfer(mustTransfer);
        meetArielA11y.setLoadUnloadAreas(true);
        meetArielA11y.setWheelchairAccessVehicles(true);
        meetArielA11y.setTransferAccessVehicle(true);
        meetArielA11y.setTransferDevices(false);
        meetArielA11y.setServiceAnimalRestrictions_Ride(true);
        meetArielA11y.setServiceAnimalRestrictions_Board(false);
        meetArielA11y.setAssistiveListening(true);
        meetArielA11y.setAudioDescription(false);
        meetArielA11y.setHandheldCaptioning(true);
        meetArielA11y.setSignLanguage(true);
        meetArielA11y.setVideoCaptioning(false);
        meetArielA11y.setSensoryExperience(sensoryExperience);
        meetArielA11y.setAttraction(meetAriel);
        attractionAccessibilityRepository.save(meetArielA11y);


        Park hollywoodStudios = new Park();
        hollywoodStudios.setName("Hollywood Studios");
        hollywoodStudios.setImageUrl(image);
        hollywoodStudios.setDescription("Step into the glitz and glamour of showbiz at Disney's Hollywood Studios, where the magic of movies and television comes to life.");
        hollywoodStudios.setLatitude(28.3581);
        hollywoodStudios.setLongitude(-81.5591);
        parkRepository.save(hollywoodStudios);

        ParkAccessibility hollywoodStudiosA11y = new ParkAccessibility();
        hollywoodStudiosA11y.setRentalLocations(randomList);
        hollywoodStudiosA11y.setWheelchairReplacementLocations(randomList);
        hollywoodStudiosA11y.setBreakLocations(randomList);
        hollywoodStudiosA11y.setStationaryBrailleMapLocations(randomList);
        hollywoodStudiosA11y.setSignLanguageSchedule("Testing if works");
        hollywoodStudiosA11y.setGuestRelationsLocations(randomList);
        hollywoodStudiosA11y.setServiceAnimalRestrictions_Ride(randomList);
        hollywoodStudiosA11y.setServiceAnimalRestrictions_Board(randomList);
        hollywoodStudiosA11y.setServiceAnimalReliefAreas(randomList);
        hollywoodStudiosA11y.setCompanionRestroomLocations(randomList);
        hollywoodStudiosA11y.setFirstAidLocations("near Guest Relations");
        hollywoodStudiosA11y.setPark(hollywoodStudios);
        parkAccessibilityRepository.save(hollywoodStudiosA11y);


        Attraction frozenSingAlong = new Attraction();
        frozenSingAlong.setName("For the First Time in Forever: A Frozen Sing-Along Celebration");
        frozenSingAlong.setImageUrl(image);
        frozenSingAlong.setDescription("You’ll melt for this heartwarming celebration of Frozen with a flurry of stories, songs and special guests.");
        frozenSingAlong.setLatitude(3.01);
        frozenSingAlong.setLongitude(20.08);
        frozenSingAlong.setPark(hollywoodStudios);
        attractionRepository.save(frozenSingAlong);

        AttractionAccessibility frozenSingAlongA11y = new AttractionAccessibility();
        frozenSingAlongA11y.setMustTransfer(mustTransfer);
        frozenSingAlongA11y.setLoadUnloadAreas(false);
        frozenSingAlongA11y.setWheelchairAccessVehicles(true);
        frozenSingAlongA11y.setTransferAccessVehicle(true);
        frozenSingAlongA11y.setTransferDevices(false);
        frozenSingAlongA11y.setServiceAnimalRestrictions_Ride(true);
        frozenSingAlongA11y.setServiceAnimalRestrictions_Board(false);
        frozenSingAlongA11y.setAssistiveListening(true);
        frozenSingAlongA11y.setAudioDescription(false);
        frozenSingAlongA11y.setHandheldCaptioning(true);
        frozenSingAlongA11y.setSignLanguage(true);
        frozenSingAlongA11y.setVideoCaptioning(false);
        frozenSingAlongA11y.setSensoryExperience(sensoryExperience);
        frozenSingAlongA11y.setAttraction(frozenSingAlong);
        attractionAccessibilityRepository.save(frozenSingAlongA11y);


        Attraction meetOlaf = new Attraction();
        meetOlaf.setName("Meet Olaf at Celebrity Spotlight");
        meetOlaf.setImageUrl(image);
        meetOlaf.setDescription("See Olaf the snowman from Disney’s Frozen—who’s finally doing what frozen things do in summer.");
        meetOlaf.setLatitude(7.02);
        meetOlaf.setLongitude(19.77);
        meetOlaf.setPark(hollywoodStudios);
        attractionRepository.save(meetOlaf);

        AttractionAccessibility meetOlafA11y = new AttractionAccessibility();
        meetOlafA11y.setMustTransfer(mustTransfer);
        meetOlafA11y.setLoadUnloadAreas(true);
        meetOlafA11y.setWheelchairAccessVehicles(true);
        meetOlafA11y.setTransferAccessVehicle(true);
        meetOlafA11y.setTransferDevices(false);
        meetOlafA11y.setServiceAnimalRestrictions_Ride(true);
        meetOlafA11y.setServiceAnimalRestrictions_Board(false);
        meetOlafA11y.setAssistiveListening(true);
        meetOlafA11y.setAudioDescription(false);
        meetOlafA11y.setHandheldCaptioning(true);
        meetOlafA11y.setSignLanguage(true);
        meetOlafA11y.setVideoCaptioning(false);
        meetOlafA11y.setSensoryExperience(sensoryExperience);
        meetOlafA11y.setAttraction(meetOlaf);
        attractionAccessibilityRepository.save(meetOlafA11y);

    }
}
