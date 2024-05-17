package org.example.seed;

import org.example.model.Attraction;
import org.example.model.AttractionAccessibility;
import org.example.model.Park;
import org.example.model.ParkAccessibility;
import org.example.model.attractionaccessibilityattributes.*;
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

        MustTransfer mustTransfer = new MustTransfer(true, false, true, false, true);

        TransferAssistance transferAssistance = new TransferAssistance(true, false, true, false);

        ServiceAnimalRestrictions serviceAnimalRestrictions = new ServiceAnimalRestrictions(true, false);

        AssistiveDevices assistiveDevices = new AssistiveDevices(true, false, true, false, true);

        SensoryExperience sensoryExperience = new SensoryExperience(true, false, true, false, true, true, false, true, "sudden turns and drops", "seatbelts", "7 minutes");


        Park enchantedRealm = new Park();
        enchantedRealm.setName("Enchanted Realm");
        enchantedRealm.setImageUrl("https://drive.google.com/file/d/1yNwfgmo7WQ4Z9znTldkFu-NKJbBhUPPk/view?usp=sharing");
        enchantedRealm.setDescription("Enter a world of enchantment and wonder at Enchanted Realm, where fairy tales come to life. From meeting beloved Malt Fizzby characters to experiencing magical parades and fireworks, Enchanted Realm is a timeless destination for guests of all ages.");
        enchantedRealm.setLatitude(28.4188);
        enchantedRealm.setLongitude(81.5818);
        parkRepository.save(enchantedRealm);

        ParkAccessibility enchantedRealmA11y = new ParkAccessibility();
        enchantedRealmA11y.setRentalLocations(randomList);
        enchantedRealmA11y.setWheelchairReplacementLocations(randomList);
        enchantedRealmA11y.setBreakLocations(randomList);
        enchantedRealmA11y.setStationaryBrailleMapLocations(randomList);
        enchantedRealmA11y.setSignLanguageSchedule("Schedule");
        enchantedRealmA11y.setGuestRelationsLocations(randomList);
        enchantedRealmA11y.setServiceAnimalRestrictions_Ride(randomList);
        enchantedRealmA11y.setServiceAnimalRestrictions_Board(randomList);
        enchantedRealmA11y.setServiceAnimalReliefAreas(randomList);
        enchantedRealmA11y.setCompanionRestroomLocations(randomList);
        enchantedRealmA11y.setFirstAidLocations("by front entrance");
        enchantedRealmA11y.setPark(enchantedRealm);
        parkAccessibilityRepository.save(enchantedRealmA11y);


        Attraction dreamweaversDen = new Attraction();
        dreamweaversDen.setName("Dreamweaver's Den");
        dreamweaversDen.setImageUrl("dreamweavers-den");
        dreamweaversDen.setDescription("Enter the magical workshop of the Dreamweaver—an inventor who weaves dreams into reality. Explore fantastical contraptions and discover your own dream thread.");
        dreamweaversDen.setLatitude(12.24);
        dreamweaversDen.setLongitude(20.17);
        dreamweaversDen.setPark(enchantedRealm);
        attractionRepository.save(dreamweaversDen);

        AttractionAccessibility dreamweaversDenA11y = new AttractionAccessibility();
        dreamweaversDenA11y.setMustTransfer(mustTransfer);
        dreamweaversDenA11y.setTransferAssistance(transferAssistance);
        dreamweaversDenA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        dreamweaversDenA11y.setAssistiveDevices(assistiveDevices);
        dreamweaversDenA11y.setSensoryExperience(sensoryExperience);
        dreamweaversDenA11y.setAttraction(dreamweaversDen);
        attractionAccessibilityRepository.save(dreamweaversDenA11y);


        Park expeditionIsle = new Park();
        expeditionIsle.setName("Expedition Isle");
        expeditionIsle.setImageUrl("");
        expeditionIsle.setDescription("Step into the adventure at Malt Fizzby's Expedition Isle, where the magic of exploring the unknown comes to life.");
        expeditionIsle.setLatitude(28.3581);
        expeditionIsle.setLongitude(-81.5591);
        parkRepository.save(expeditionIsle);

        ParkAccessibility expeditionIsleA11y = new ParkAccessibility();
        expeditionIsleA11y.setRentalLocations(randomList);
        expeditionIsleA11y.setWheelchairReplacementLocations(randomList);
        expeditionIsleA11y.setBreakLocations(randomList);
        expeditionIsleA11y.setStationaryBrailleMapLocations(randomList);
        expeditionIsleA11y.setSignLanguageSchedule("Testing if works");
        expeditionIsleA11y.setGuestRelationsLocations(randomList);
        expeditionIsleA11y.setServiceAnimalRestrictions_Ride(randomList);
        expeditionIsleA11y.setServiceAnimalRestrictions_Board(randomList);
        expeditionIsleA11y.setServiceAnimalReliefAreas(randomList);
        expeditionIsleA11y.setCompanionRestroomLocations(randomList);
        expeditionIsleA11y.setFirstAidLocations("near Guest Relations");
        expeditionIsleA11y.setPark(expeditionIsle);
        parkAccessibilityRepository.save(expeditionIsleA11y);


        Attraction lostLagoon = new Attraction();
        lostLagoon.setName("Lost Lagoon");
        lostLagoon.setImageUrl("https://drive.google.com/file/d/1iMSg-KWxZswRAGXZ8TtGs_5T3Ja_ewhb/view?usp=sharing");
        lostLagoon.setDescription("Dive into the crystal-clear waters of this tropical oasis in Expedition Isle. Snorkel alongside colorful fish, explore hidden caves, and uncover sunken treasures.");
        lostLagoon.setLatitude(3.01);
        lostLagoon.setLongitude(20.08);
        lostLagoon.setPark(expeditionIsle);
        attractionRepository.save(lostLagoon);

        AttractionAccessibility lostLagoonA11y = new AttractionAccessibility();
        lostLagoonA11y.setMustTransfer(mustTransfer);
        lostLagoonA11y.setTransferAssistance(transferAssistance);
        lostLagoonA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        lostLagoonA11y.setAssistiveDevices(assistiveDevices);
        lostLagoonA11y.setSensoryExperience(sensoryExperience);
        lostLagoonA11y.setAttraction(lostLagoon);
        attractionAccessibilityRepository.save(lostLagoonA11y);


        Park mysticalForest = new Park();
        mysticalForest.setName("Mystical Forest");
        mysticalForest.setImageUrl("https://drive.google.com/file/d/1cwPlL-7mUnTA8RaowXtbzhoztu3Tg7OO/view?usp=sharing");
        mysticalForest.setDescription("Embark on a wild expedition at Malt Fizzby's Mystical Forest. Encounter exotic animals, enjoy thrilling rides, and connect with nature in immersive and educational experiences that inspire a deeper appreciation for our planet's wildlife and ecosystems.");
        mysticalForest.setLatitude(28.3574);
        mysticalForest.setLongitude(81.5906);
        parkRepository.save(mysticalForest);

        ParkAccessibility mysticalForestA11y = new ParkAccessibility();
        mysticalForestA11y.setRentalLocations(randomList);
        mysticalForestA11y.setWheelchairReplacementLocations(randomList);
        mysticalForestA11y.setBreakLocations(randomList);
        mysticalForestA11y.setStationaryBrailleMapLocations(randomList);
        mysticalForestA11y.setSignLanguageSchedule("Schedule");
        mysticalForestA11y.setGuestRelationsLocations(randomList);
        mysticalForestA11y.setServiceAnimalRestrictions_Ride(randomList);
        mysticalForestA11y.setServiceAnimalRestrictions_Board(randomList);
        mysticalForestA11y.setServiceAnimalReliefAreas(randomList);
        mysticalForestA11y.setCompanionRestroomLocations(randomList);
        mysticalForestA11y.setFirstAidLocations("by front entrance");
        mysticalForestA11y.setPark(mysticalForest);
        parkAccessibilityRepository.save(mysticalForestA11y);


        Attraction etherealGardens = new Attraction();
        etherealGardens.setName("Ethereal Gardens");
        etherealGardens.setImageUrl("https://drive.google.com/file/d/1cwPlL-7mUnTA8RaowXtbzhoztu3Tg7OO/view?usp=sharing");
        etherealGardens.setDescription("A serene oasis within the Mystical Forest, these gardens bloom with otherworldly flowers. Each blossom grants a wish—choose wisely!");
        etherealGardens.setLatitude(12.24);
        etherealGardens.setLongitude(20.17);
        etherealGardens.setPark(mysticalForest);
        attractionRepository.save(etherealGardens);

        AttractionAccessibility etherealGardensA11y = new AttractionAccessibility();
        etherealGardensA11y.setMustTransfer(mustTransfer);
        etherealGardensA11y.setTransferAssistance(transferAssistance);
        etherealGardensA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        etherealGardensA11y.setAssistiveDevices(assistiveDevices);
        etherealGardensA11y.setSensoryExperience(sensoryExperience);
        etherealGardensA11y.setAttraction(etherealGardens);
        attractionAccessibilityRepository.save(etherealGardensA11y);


        Park fantasyGalaxy = new Park();
        fantasyGalaxy.setName("Fantasy Galaxy");
        fantasyGalaxy.setImageUrl("https://drive.google.com/file/d/1cwPlL-7mUnTA8RaowXtbzhoztu3Tg7OO/view?usp=sharing");
        fantasyGalaxy.setDescription("Explore the wonders of the past, present, and future at Fantasy Galaxy, where innovation meets imagination. Discover technological innovations and international cuisine as you journey through this celebration of human achievement and global diversity.");
        fantasyGalaxy.setLatitude(28.3765);
        fantasyGalaxy.setLongitude(81.5494);
        parkRepository.save(fantasyGalaxy);

        ParkAccessibility fantasyGalaxyA11y = new ParkAccessibility();
        fantasyGalaxyA11y.setRentalLocations(randomList);
        fantasyGalaxyA11y.setWheelchairReplacementLocations(randomList);
        fantasyGalaxyA11y.setBreakLocations(randomList);
        fantasyGalaxyA11y.setStationaryBrailleMapLocations(randomList);
        fantasyGalaxyA11y.setSignLanguageSchedule("Schedule");
        fantasyGalaxyA11y.setGuestRelationsLocations(randomList);
        fantasyGalaxyA11y.setServiceAnimalRestrictions_Ride(randomList);
        fantasyGalaxyA11y.setServiceAnimalRestrictions_Board(randomList);
        fantasyGalaxyA11y.setServiceAnimalReliefAreas(randomList);
        fantasyGalaxyA11y.setCompanionRestroomLocations(randomList);
        fantasyGalaxyA11y.setFirstAidLocations("by front entrance");
        fantasyGalaxyA11y.setPark(fantasyGalaxy);
        parkAccessibilityRepository.save(fantasyGalaxyA11y);


        Attraction starfallObservatory = new Attraction();
        starfallObservatory.setName("Starfall Observatory");
        starfallObservatory.setImageUrl("https://drive.google.com/file/d/1cwPlL-7mUnTA8RaowXtbzhoztu3Tg7OO/view?usp=sharing");
        starfallObservatory.setDescription("Located in the Fantasy Galaxy, this futuristic observatory offers stargazing like no other. Peer through telescopes to see distant planets, meteor showers, and celestial wonders.");
        starfallObservatory.setLatitude(12.24);
        starfallObservatory.setLongitude(20.17);
        starfallObservatory.setPark(fantasyGalaxy);
        attractionRepository.save(starfallObservatory);

        AttractionAccessibility starfallObservatoryA11y = new AttractionAccessibility();
        starfallObservatoryA11y.setMustTransfer(mustTransfer);
        starfallObservatoryA11y.setTransferAssistance(transferAssistance);
        starfallObservatoryA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        starfallObservatoryA11y.setAssistiveDevices(assistiveDevices);
        starfallObservatoryA11y.setSensoryExperience(sensoryExperience);
        starfallObservatoryA11y.setAttraction(starfallObservatory);
        attractionAccessibilityRepository.save(starfallObservatoryA11y);

    }
}
