package org.example.seed;

import org.example.model.Park;
import org.example.model.ParkAccessibility;
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


    @Autowired
    public SeedData(ParkRepository parkRepository, ParkAccessibilityRepository parkAccessibilityRepository) {
        this.parkRepository = parkRepository;
        this.parkAccessibilityRepository = parkAccessibilityRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        List<String> randomList = new ArrayList<>();
        randomList.add("random string 1");
        randomList.add("random string 2");


        Park magicKingdom = new Park();
        magicKingdom.setName("Magic Kingdom");
        magicKingdom.setImageUrl("image1");
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


        Park hollywoodStudios = new Park();
        hollywoodStudios.setName("Hollywood Studios");
        hollywoodStudios.setImageUrl("image2");
        hollywoodStudios.setDescription("Step into the glitz and glamour of showbiz at Disney's Hollywood Studios, where the magic of movies and television comes to life.");
        hollywoodStudios.setLatitude(28.3581);
        hollywoodStudios.setLongitude(-81.5591);
        parkRepository.save(hollywoodStudios);

        ParkAccessibility hollywoodStudiosA11y = new ParkAccessibility();
        hollywoodStudiosA11y.setRentalLocations(randomList);
        hollywoodStudiosA11y.setWheelchairReplacementLocations(randomList);
        hollywoodStudiosA11y.setBreakLocations(randomList);
        hollywoodStudiosA11y.setStationaryBrailleMapLocations(randomList);
        hollywoodStudiosA11y.setSignLanguageSchedule("Schedule");
        hollywoodStudiosA11y.setGuestRelationsLocations(randomList);
        hollywoodStudiosA11y.setServiceAnimalRestrictions_Ride(randomList);
        hollywoodStudiosA11y.setServiceAnimalRestrictions_Board(randomList);
        hollywoodStudiosA11y.setServiceAnimalReliefAreas(randomList);
        hollywoodStudiosA11y.setCompanionRestroomLocations(randomList);
        hollywoodStudiosA11y.setFirstAidLocations("near Guest Relations");
        hollywoodStudiosA11y.setPark(hollywoodStudios);
        parkAccessibilityRepository.save(hollywoodStudiosA11y);


    }
}
