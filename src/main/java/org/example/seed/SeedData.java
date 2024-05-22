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

        String image = "https://drive.google.com/thumbnail?id=1P1NUpDKigrmF49ydalOG3ME99xMv55yJ&sz=w200-h200";

        String schedule = "Tuesdays, Fridays";

        MustTransfer mustTransfer = new MustTransfer(true, false, true, false, true);

        TransferAssistance transferAssistance = new TransferAssistance(true, false, true, false);

        ServiceAnimalRestrictions serviceAnimalRestrictions = new ServiceAnimalRestrictions(true, false);

        AssistiveDevices assistiveDevices = new AssistiveDevices(true, false, true, false, true);

        SensoryExperience sensoryExperience = new SensoryExperience(true, false, true, false, true, true, false, true, "sudden turns and drops", "seatbelts", "7 minutes");


        Park enchantedRealm = new Park();
        enchantedRealm.setName("Enchanted Realm");
        enchantedRealm.setImageUrl("https://img.pikbest.com/origin/09/42/18/71NpIkbEsTxXv.jpg!sw800");
        enchantedRealm.setDescription("Enter a world of enchantment and wonder at Enchanted Realm, where fairy tales come to life. From meeting beloved Malt Fizzby characters to experiencing magical parades and fireworks, Enchanted Realm is a timeless destination for guests of all ages.");
        enchantedRealm.setLatitude(28.4188);
        enchantedRealm.setLongitude(81.5818);
        parkRepository.save(enchantedRealm);

        ParkAccessibility enchantedRealmA11y = new ParkAccessibility();
        enchantedRealmA11y.setRentalLocations(randomList);
        enchantedRealmA11y.setWheelchairReplacementLocations(randomList);
        enchantedRealmA11y.setBreakLocations(randomList);
        enchantedRealmA11y.setStationaryBrailleMapLocations(randomList);
        enchantedRealmA11y.setSignLanguageSchedule(schedule);
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
        dreamweaversDen.setImageUrl("https://drive.google.com/thumbnail?id=11Qpx_zHLU_nst2P4lsmvcQqW8PMPJ_QU&sz=w200-h200");
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


        Attraction castleOfLight = new Attraction();
        castleOfLight.setName("Castle of Light");
        castleOfLight.setImageUrl(image);
        castleOfLight.setDescription("Marvel at the breathtaking Castle of Light, a symbol of hope and magic. Experience dazzling light shows that illuminate the night sky.");
        castleOfLight.setLatitude(28.4190);
        castleOfLight.setLongitude(81.5820);
        castleOfLight.setPark(enchantedRealm);
        attractionRepository.save(castleOfLight);

        AttractionAccessibility castleOfLightA11y = new AttractionAccessibility();
        castleOfLightA11y.setMustTransfer(mustTransfer);
        castleOfLightA11y.setTransferAssistance(transferAssistance);
        castleOfLightA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        castleOfLightA11y.setAssistiveDevices(assistiveDevices);
        castleOfLightA11y.setSensoryExperience(sensoryExperience);
        castleOfLightA11y.setAttraction(castleOfLight);
        attractionAccessibilityRepository.save(castleOfLightA11y);

        Attraction mysticCarousel = new Attraction();
        mysticCarousel.setName("Mystic Carousel");
        mysticCarousel.setImageUrl(image);
        mysticCarousel.setDescription("Take a whimsical ride on the Mystic Carousel, where each horse tells a different story of magic and adventure.");
        mysticCarousel.setLatitude(28.4192);
        mysticCarousel.setLongitude(81.5822);
        mysticCarousel.setPark(enchantedRealm);
        attractionRepository.save(mysticCarousel);

        AttractionAccessibility mysticCarouselA11y = new AttractionAccessibility();
        mysticCarouselA11y.setMustTransfer(mustTransfer);
        mysticCarouselA11y.setTransferAssistance(transferAssistance);
        mysticCarouselA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        mysticCarouselA11y.setAssistiveDevices(assistiveDevices);
        mysticCarouselA11y.setSensoryExperience(sensoryExperience);
        mysticCarouselA11y.setAttraction(mysticCarousel);
        attractionAccessibilityRepository.save(mysticCarouselA11y);


        Attraction fairyTaleForest = new Attraction();
        fairyTaleForest.setName("Fairy Tale Forest");
        fairyTaleForest.setImageUrl(image);
        fairyTaleForest.setDescription("Explore the enchanting Fairy Tale Forest, where every corner is filled with characters and stories from your favorite fairy tales.");
        fairyTaleForest.setLatitude(28.4194);
        fairyTaleForest.setLongitude(81.5824);
        fairyTaleForest.setPark(enchantedRealm);
        attractionRepository.save(fairyTaleForest);

        AttractionAccessibility fairyTaleForestA11y = new AttractionAccessibility();
        fairyTaleForestA11y.setMustTransfer(mustTransfer);
        fairyTaleForestA11y.setTransferAssistance(transferAssistance);
        fairyTaleForestA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        fairyTaleForestA11y.setAssistiveDevices(assistiveDevices);
        fairyTaleForestA11y.setSensoryExperience(sensoryExperience);
        fairyTaleForestA11y.setAttraction(fairyTaleForest);
        attractionAccessibilityRepository.save(fairyTaleForestA11y);


        Attraction pixieHollow = new Attraction();
        pixieHollow.setName("Pixie Hollow");
        pixieHollow.setImageUrl(image);
        pixieHollow.setDescription("Enter Pixie Hollow, where the magic of fairies fills the air. Meet Tinker Bell and her friends, explore whimsical gardens, and embark on enchanted adventures.");
        pixieHollow.setLatitude(28.4189);
        pixieHollow.setLongitude(81.5819);
        pixieHollow.setPark(enchantedRealm);
        attractionRepository.save(pixieHollow);

        AttractionAccessibility pixieHollowA11y = new AttractionAccessibility();
        pixieHollowA11y.setMustTransfer(mustTransfer);
        pixieHollowA11y.setTransferAssistance(transferAssistance);
        pixieHollowA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        pixieHollowA11y.setAssistiveDevices(assistiveDevices);
        pixieHollowA11y.setSensoryExperience(sensoryExperience);
        pixieHollowA11y.setAttraction(pixieHollow);
        attractionAccessibilityRepository.save(pixieHollowA11y);


        Attraction magicalParade = new Attraction();
        magicalParade.setName("Magical Parade");
        magicalParade.setImageUrl(image);
        magicalParade.setDescription("Join the Magical Parade, a dazzling procession of beloved characters, majestic floats, and lively music. Experience the joy and wonder of enchantment.");
        magicalParade.setLatitude(28.4190);
        magicalParade.setLongitude(81.5820);
        magicalParade.setPark(enchantedRealm);
        attractionRepository.save(magicalParade);

        AttractionAccessibility magicalParadeA11y = new AttractionAccessibility();
        magicalParadeA11y.setMustTransfer(mustTransfer);
        magicalParadeA11y.setTransferAssistance(transferAssistance);
        magicalParadeA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        magicalParadeA11y.setAssistiveDevices(assistiveDevices);
        magicalParadeA11y.setSensoryExperience(sensoryExperience);
        magicalParadeA11y.setAttraction(magicalParade);
        attractionAccessibilityRepository.save(magicalParadeA11y);


        Attraction fairyTaleCastle = new Attraction();
        fairyTaleCastle.setName("Fairy Tale Castle");
        fairyTaleCastle.setImageUrl(image);
        fairyTaleCastle.setDescription("Behold the Fairy Tale Castle, a majestic fortress where dreams come true. Explore royal chambers, attend magical balls, and meet fairy tale princesses.");
        fairyTaleCastle.setLatitude(28.4191);
        fairyTaleCastle.setLongitude(81.5821);
        fairyTaleCastle.setPark(enchantedRealm);
        attractionRepository.save(fairyTaleCastle);

        AttractionAccessibility fairyTaleCastleA11y = new AttractionAccessibility();
        fairyTaleCastleA11y.setMustTransfer(mustTransfer);
        fairyTaleCastleA11y.setTransferAssistance(transferAssistance);
        fairyTaleCastleA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        fairyTaleCastleA11y.setAssistiveDevices(assistiveDevices);
        fairyTaleCastleA11y.setSensoryExperience(sensoryExperience);
        fairyTaleCastleA11y.setAttraction(fairyTaleCastle);
        attractionAccessibilityRepository.save(fairyTaleCastleA11y);


        Attraction dragonFlight = new Attraction();
        dragonFlight.setName("Dragon Flight");
        dragonFlight.setImageUrl(image);
        dragonFlight.setDescription("Embark on a thrilling Dragon Flight, soaring through the skies atop mythical dragons. Feel the wind in your hair as you journey across enchanted lands.");
        dragonFlight.setLatitude(28.4192);
        dragonFlight.setLongitude(81.5822);
        dragonFlight.setPark(enchantedRealm);
        attractionRepository.save(dragonFlight);

        AttractionAccessibility dragonFlightA11y = new AttractionAccessibility();
        dragonFlightA11y.setMustTransfer(mustTransfer);
        dragonFlightA11y.setTransferAssistance(transferAssistance);
        dragonFlightA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        dragonFlightA11y.setAssistiveDevices(assistiveDevices);
        dragonFlightA11y.setSensoryExperience(sensoryExperience);
        dragonFlightA11y.setAttraction(dragonFlight);
        attractionAccessibilityRepository.save(dragonFlightA11y);


        Attraction enchantedForestTrail = new Attraction();
        enchantedForestTrail.setName("Enchanted Forest Trail");
        enchantedForestTrail.setImageUrl(image);
        enchantedForestTrail.setDescription("Embark on the Enchanted Forest Trail, a winding path through ancient woodlands where mystical creatures roam and hidden treasures await.");
        enchantedForestTrail.setLatitude(28.4193);
        enchantedForestTrail.setLongitude(81.5823);
        enchantedForestTrail.setPark(enchantedRealm);
        attractionRepository.save(enchantedForestTrail);

        AttractionAccessibility enchantedForestTrailA11y = new AttractionAccessibility();
        enchantedForestTrailA11y.setMustTransfer(mustTransfer);
        enchantedForestTrailA11y.setTransferAssistance(transferAssistance);
        enchantedForestTrailA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        enchantedForestTrailA11y.setAssistiveDevices(assistiveDevices);
        enchantedForestTrailA11y.setSensoryExperience(sensoryExperience);
        enchantedForestTrailA11y.setAttraction(enchantedForestTrail);
        attractionAccessibilityRepository.save(enchantedForestTrailA11y);


        Attraction wizardWorkshop = new Attraction();
        wizardWorkshop.setName("Wizard Workshop");
        wizardWorkshop.setImageUrl(image);
        wizardWorkshop.setDescription("Enter the Wizard Workshop, where magic is crafted and spells are woven. Learn the secrets of sorcery from master wizards.");
        wizardWorkshop.setLatitude(28.4194);
        wizardWorkshop.setLongitude(81.5824);
        wizardWorkshop.setPark(enchantedRealm);
        attractionRepository.save(wizardWorkshop);

        AttractionAccessibility wizardWorkshopA11y = new AttractionAccessibility();
        wizardWorkshopA11y.setMustTransfer(mustTransfer);
        wizardWorkshopA11y.setTransferAssistance(transferAssistance);
        wizardWorkshopA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        wizardWorkshopA11y.setAssistiveDevices(assistiveDevices);
        wizardWorkshopA11y.setSensoryExperience(sensoryExperience);
        wizardWorkshopA11y.setAttraction(wizardWorkshop);
        attractionAccessibilityRepository.save(wizardWorkshopA11y);


        Attraction fairyRingGrove = new Attraction();
        fairyRingGrove.setName("Fairy Ring Grove");
        fairyRingGrove.setImageUrl(image);
        fairyRingGrove.setDescription("Discover the Fairy Ring Grove, a mystical clearing where fairies gather to dance under the moonlight. Make a wish upon the enchanted toadstools.");
        fairyRingGrove.setLatitude(28.4195);
        fairyRingGrove.setLongitude(81.5825);
        fairyRingGrove.setPark(enchantedRealm);
        attractionRepository.save(fairyRingGrove);

        AttractionAccessibility fairyRingGroveA11y = new AttractionAccessibility();
        fairyRingGroveA11y.setMustTransfer(mustTransfer);
        fairyRingGroveA11y.setTransferAssistance(transferAssistance);
        fairyRingGroveA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        fairyRingGroveA11y.setAssistiveDevices(assistiveDevices);
        fairyRingGroveA11y.setSensoryExperience(sensoryExperience);
        fairyRingGroveA11y.setAttraction(fairyRingGrove);
        attractionAccessibilityRepository.save(fairyRingGroveA11y);


        Attraction unicornMeadow = new Attraction();
        unicornMeadow.setName("Unicorn Meadow");
        unicornMeadow.setImageUrl(image);
        unicornMeadow.setDescription("Enter the Unicorn Meadow, where shimmering fields of flowers stretch as far as the eye can see. Encounter majestic unicorns grazing in peaceful harmony.");
        unicornMeadow.setLatitude(28.4196);
        unicornMeadow.setLongitude(81.5826);
        unicornMeadow.setPark(enchantedRealm);
        attractionRepository.save(unicornMeadow);

        AttractionAccessibility unicornMeadowA11y = new AttractionAccessibility();
        unicornMeadowA11y.setMustTransfer(mustTransfer);
        unicornMeadowA11y.setTransferAssistance(transferAssistance);
        unicornMeadowA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        unicornMeadowA11y.setAssistiveDevices(assistiveDevices);
        unicornMeadowA11y.setSensoryExperience(sensoryExperience);
        unicornMeadowA11y.setAttraction(unicornMeadow);
        attractionAccessibilityRepository.save(unicornMeadowA11y);


        Attraction mermaidLagoon = new Attraction();
        mermaidLagoon.setName("Mermaid Lagoon");
        mermaidLagoon.setImageUrl(image);
        mermaidLagoon.setDescription("Dive into the depths of Mermaid Lagoon, where mermaids swim gracefully amidst coral reefs and hidden grottos. Discover the secrets of the sea.");
        mermaidLagoon.setLatitude(28.4197);
        mermaidLagoon.setLongitude(81.5827);
        mermaidLagoon.setPark(enchantedRealm);
        attractionRepository.save(mermaidLagoon);

        AttractionAccessibility mermaidLagoonA11y = new AttractionAccessibility();
        mermaidLagoonA11y.setMustTransfer(mustTransfer);
        mermaidLagoonA11y.setTransferAssistance(transferAssistance);
        mermaidLagoonA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        mermaidLagoonA11y.setAssistiveDevices(assistiveDevices);
        mermaidLagoonA11y.setSensoryExperience(sensoryExperience);
        mermaidLagoonA11y.setAttraction(mermaidLagoon);
        attractionAccessibilityRepository.save(mermaidLagoonA11y);


        Attraction fairyTaleTheater = new Attraction();
        fairyTaleTheater.setName("Fairy Tale Theater");
        fairyTaleTheater.setImageUrl(image);
        fairyTaleTheater.setDescription("Step into the Fairy Tale Theater, where classic stories come to life on stage. Be captivated by enchanting performances and magical tales.");
        fairyTaleTheater.setLatitude(28.4198);
        fairyTaleTheater.setLongitude(81.5828);
        fairyTaleTheater.setPark(enchantedRealm);
        attractionRepository.save(fairyTaleTheater);

        AttractionAccessibility fairyTaleTheaterA11y = new AttractionAccessibility();
        fairyTaleTheaterA11y.setMustTransfer(mustTransfer);
        fairyTaleTheaterA11y.setTransferAssistance(transferAssistance);
        fairyTaleTheaterA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        fairyTaleTheaterA11y.setAssistiveDevices(assistiveDevices);
        fairyTaleTheaterA11y.setSensoryExperience(sensoryExperience);
        fairyTaleTheaterA11y.setAttraction(fairyTaleTheater);
        attractionAccessibilityRepository.save(fairyTaleTheaterA11y);


        Attraction dragonRoost = new Attraction();
        dragonRoost.setName("Dragon Roost");
        dragonRoost.setImageUrl(image);
        dragonRoost.setDescription("Visit the Dragon Roost, where majestic dragons perch atop ancient cliffs. Witness their fiery breath and awe-inspiring flights.");
        dragonRoost.setLatitude(28.4199);
        dragonRoost.setLongitude(81.5829);
        dragonRoost.setPark(enchantedRealm);
        attractionRepository.save(dragonRoost);

        AttractionAccessibility dragonRoostA11y = new AttractionAccessibility();
        dragonRoostA11y.setMustTransfer(mustTransfer);
        dragonRoostA11y.setTransferAssistance(transferAssistance);
        dragonRoostA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        dragonRoostA11y.setAssistiveDevices(assistiveDevices);
        dragonRoostA11y.setSensoryExperience(sensoryExperience);
        dragonRoostA11y.setAttraction(dragonRoost);
        attractionAccessibilityRepository.save(dragonRoostA11y);


        Attraction enchantedCarousel = new Attraction();
        enchantedCarousel.setName("Enchanted Carousel");
        enchantedCarousel.setImageUrl(image);
        enchantedCarousel.setDescription("Take a ride on the Enchanted Carousel, where mythical creatures prance to the melody of enchanting music. Feel the magic in the air as you whirl around.");
        enchantedCarousel.setLatitude(28.4200);
        enchantedCarousel.setLongitude(81.5830);
        enchantedCarousel.setPark(enchantedRealm);
        attractionRepository.save(enchantedCarousel);

        AttractionAccessibility enchantedCarouselA11y = new AttractionAccessibility();
        enchantedCarouselA11y.setMustTransfer(mustTransfer);
        enchantedCarouselA11y.setTransferAssistance(transferAssistance);
        enchantedCarouselA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        enchantedCarouselA11y.setAssistiveDevices(assistiveDevices);
        enchantedCarouselA11y.setSensoryExperience(sensoryExperience);
        enchantedCarouselA11y.setAttraction(enchantedCarousel);
        attractionAccessibilityRepository.save(enchantedCarouselA11y);


        Attraction magicalLabyrinth = new Attraction();
        magicalLabyrinth.setName("Magical Labyrinth");
        magicalLabyrinth.setImageUrl(image);
        magicalLabyrinth.setDescription("Navigate the twists and turns of the Magical Labyrinth, where illusions and enchantments challenge your senses. Find your way to the heart of mystery.");
        magicalLabyrinth.setLatitude(28.4201);
        magicalLabyrinth.setLongitude(81.5831);
        magicalLabyrinth.setPark(enchantedRealm);
        attractionRepository.save(magicalLabyrinth);

        AttractionAccessibility magicalLabyrinthA11y = new AttractionAccessibility();
        magicalLabyrinthA11y.setMustTransfer(mustTransfer);
        magicalLabyrinthA11y.setTransferAssistance(transferAssistance);
        magicalLabyrinthA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        magicalLabyrinthA11y.setAssistiveDevices(assistiveDevices);
        magicalLabyrinthA11y.setSensoryExperience(sensoryExperience);
        magicalLabyrinthA11y.setAttraction(magicalLabyrinth);
        attractionAccessibilityRepository.save(magicalLabyrinthA11y);


        Attraction wizardAcademy = new Attraction();
        wizardAcademy.setName("Wizard Academy");
        wizardAcademy.setImageUrl(image);
        wizardAcademy.setDescription("Enroll in the Wizard Academy, where aspiring sorcerers learn the ancient arts of magic and spellcasting. Master the elements and unlock your true potential.");
        wizardAcademy.setLatitude(28.4202);
        wizardAcademy.setLongitude(81.5832);
        wizardAcademy.setPark(enchantedRealm);
        attractionRepository.save(wizardAcademy);


        AttractionAccessibility wizardAcademyA11y = new AttractionAccessibility();
        wizardAcademyA11y.setMustTransfer(mustTransfer);
        wizardAcademyA11y.setTransferAssistance(transferAssistance);
        wizardAcademyA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        wizardAcademyA11y.setAssistiveDevices(assistiveDevices);
        wizardAcademyA11y.setSensoryExperience(sensoryExperience);
        wizardAcademyA11y.setAttraction(wizardAcademy);
        attractionAccessibilityRepository.save(wizardAcademyA11y);




        Park expeditionIsle = new Park();
        expeditionIsle.setName("Expedition Isle");
        expeditionIsle.setImageUrl("https://img.freepik.com/photos-premium/cascade-dans-jungle_737761-2192.jpg");
        expeditionIsle.setDescription("Step into the adventure at Malt Fizzby's Expedition Isle, where the magic of exploring the unknown comes to life.");
        expeditionIsle.setLatitude(28.3581);
        expeditionIsle.setLongitude(-81.5591);
        parkRepository.save(expeditionIsle);

        ParkAccessibility expeditionIsleA11y = new ParkAccessibility();
        expeditionIsleA11y.setRentalLocations(randomList);
        expeditionIsleA11y.setWheelchairReplacementLocations(randomList);
        expeditionIsleA11y.setBreakLocations(randomList);
        expeditionIsleA11y.setStationaryBrailleMapLocations(randomList);
        expeditionIsleA11y.setSignLanguageSchedule(schedule);
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
        lostLagoon.setImageUrl("https://drive.google.com/thumbnail?id=1iMSg-KWxZswRAGXZ8TtGs_5T3Ja_ewhb&sz=w200-h200");
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


        Attraction treasureHunt = new Attraction();
        treasureHunt.setName("Treasure Hunt");
        treasureHunt.setImageUrl(image);
        treasureHunt.setDescription("Embark on an exciting Treasure Hunt through ancient ruins and dense jungles. Follow the clues, solve the puzzles, and uncover hidden riches.");
        treasureHunt.setLatitude(28.3583);
        treasureHunt.setLongitude(-81.5593);
        treasureHunt.setPark(expeditionIsle);
        attractionRepository.save(treasureHunt);

        AttractionAccessibility treasureHuntA11y = new AttractionAccessibility();
        treasureHuntA11y.setMustTransfer(mustTransfer);
        treasureHuntA11y.setTransferAssistance(transferAssistance);
        treasureHuntA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        treasureHuntA11y.setAssistiveDevices(assistiveDevices);
        treasureHuntA11y.setSensoryExperience(sensoryExperience);
        treasureHuntA11y.setAttraction(treasureHunt);
        attractionAccessibilityRepository.save(treasureHuntA11y);


        Attraction ancientRuins = new Attraction();
        ancientRuins.setName("Ancient Ruins");
        ancientRuins.setImageUrl(image);
        ancientRuins.setDescription("Explore the Ancient Ruins, a mysterious site filled with secrets of a long-lost civilization. Discover hidden chambers, ancient artifacts, and unravel the mysteries of the past.");
        ancientRuins.setLatitude(28.3585);
        ancientRuins.setLongitude(-81.5595);
        ancientRuins.setPark(expeditionIsle);
        attractionRepository.save(ancientRuins);

        AttractionAccessibility ancientRuinsA11y = new AttractionAccessibility();
        ancientRuinsA11y.setMustTransfer(mustTransfer);
        ancientRuinsA11y.setTransferAssistance(transferAssistance);
        ancientRuinsA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        ancientRuinsA11y.setAssistiveDevices(assistiveDevices);
        ancientRuinsA11y.setSensoryExperience(sensoryExperience);
        ancientRuinsA11y.setAttraction(ancientRuins);
        attractionAccessibilityRepository.save(ancientRuinsA11y);


        Attraction hiddenTemple = new Attraction();
        hiddenTemple.setName("Hidden Temple");
        hiddenTemple.setImageUrl(image);
        hiddenTemple.setDescription("Uncover the secrets of the Hidden Temple, an ancient sanctuary hidden deep within the jungle. Beware of traps and puzzles.");
        hiddenTemple.setLatitude(28.3586);
        hiddenTemple.setLongitude(-81.5596);
        hiddenTemple.setPark(expeditionIsle);
        attractionRepository.save(hiddenTemple);

        AttractionAccessibility hiddenTempleA11y = new AttractionAccessibility();
        hiddenTempleA11y.setMustTransfer(mustTransfer);
        hiddenTempleA11y.setTransferAssistance(transferAssistance);
        hiddenTempleA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        hiddenTempleA11y.setAssistiveDevices(assistiveDevices);
        hiddenTempleA11y.setSensoryExperience(sensoryExperience);
        hiddenTempleA11y.setAttraction(hiddenTemple);
        attractionAccessibilityRepository.save(hiddenTempleA11y);


        Attraction wildSafari = new Attraction();
        wildSafari.setName("Wild Safari");
        wildSafari.setImageUrl(image);
        wildSafari.setDescription("Embark on a thrilling Wild Safari through untamed wilderness, where lions roar and elephants roam. Experience the wonders of the savannah.");
        wildSafari.setLatitude(28.3587);
        wildSafari.setLongitude(-81.5597);
        wildSafari.setPark(expeditionIsle);
        attractionRepository.save(wildSafari);

        AttractionAccessibility wildSafariA11y = new AttractionAccessibility();
        wildSafariA11y.setMustTransfer(mustTransfer);
        wildSafariA11y.setTransferAssistance(transferAssistance);
        wildSafariA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        wildSafariA11y.setAssistiveDevices(assistiveDevices);
        wildSafariA11y.setSensoryExperience(sensoryExperience);
        wildSafariA11y.setAttraction(wildSafari);
        attractionAccessibilityRepository.save(wildSafariA11y);


        Attraction jungleExplorer = new Attraction();
        jungleExplorer.setName("Jungle Explorer");
        jungleExplorer.setImageUrl(image);
        jungleExplorer.setDescription("Embark on a Jungle Explorer adventure, trekking through dense foliage and discovering hidden wonders deep within the heart of Expedition Isle.");
        jungleExplorer.setLatitude(28.3582);
        jungleExplorer.setLongitude(-81.5592);
        jungleExplorer.setPark(expeditionIsle);
        attractionRepository.save(jungleExplorer);

        AttractionAccessibility jungleExplorerA11y = new AttractionAccessibility();
        jungleExplorerA11y.setMustTransfer(mustTransfer);
        jungleExplorerA11y.setTransferAssistance(transferAssistance);
        jungleExplorerA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        jungleExplorerA11y.setAssistiveDevices(assistiveDevices);
        jungleExplorerA11y.setSensoryExperience(sensoryExperience);
        jungleExplorerA11y.setAttraction(jungleExplorer);
        attractionAccessibilityRepository.save(jungleExplorerA11y);


        Attraction lostCivilization = new Attraction();
        lostCivilization.setName("Lost Civilization");
        lostCivilization.setImageUrl(image);
        lostCivilization.setDescription("Unravel the mysteries of the Lost Civilization, exploring ancient temples and deciphering hieroglyphics to unlock the secrets of a forgotten society.");
        lostCivilization.setLatitude(28.3583);
        lostCivilization.setLongitude(-81.5593);
        lostCivilization.setPark(expeditionIsle);
        attractionRepository.save(lostCivilization);

        AttractionAccessibility lostCivilizationA11y = new AttractionAccessibility();
        lostCivilizationA11y.setMustTransfer(mustTransfer);
        lostCivilizationA11y.setTransferAssistance(transferAssistance);
        lostCivilizationA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        lostCivilizationA11y.setAssistiveDevices(assistiveDevices);
        lostCivilizationA11y.setSensoryExperience(sensoryExperience);
        lostCivilizationA11y.setAttraction(lostCivilization);
        attractionAccessibilityRepository.save(lostCivilizationA11y);


        Attraction amazonAdventure = new Attraction();
        amazonAdventure.setName("Amazon Adventure");
        amazonAdventure.setImageUrl(image);
        amazonAdventure.setDescription("Embark on an Amazon Adventure, navigating through dense rainforests and encountering exotic wildlife native to the Amazon basin.");
        amazonAdventure.setLatitude(28.3584);
        amazonAdventure.setLongitude(-81.5594);
        amazonAdventure.setPark(expeditionIsle);
        attractionRepository.save(amazonAdventure);

        AttractionAccessibility amazonAdventureA11y = new AttractionAccessibility();
        amazonAdventureA11y.setMustTransfer(mustTransfer);
        amazonAdventureA11y.setTransferAssistance(transferAssistance);
        amazonAdventureA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        amazonAdventureA11y.setAssistiveDevices(assistiveDevices);
        amazonAdventureA11y.setSensoryExperience(sensoryExperience);
        amazonAdventureA11y.setAttraction(amazonAdventure);
        attractionAccessibilityRepository.save(amazonAdventureA11y);


        Attraction volcanoExpedition = new Attraction();
        volcanoExpedition.setName("Volcano Expedition");
        volcanoExpedition.setImageUrl(image);
        volcanoExpedition.setDescription("Embark on a Volcano Expedition, venturing into the heart of an active volcano to witness the raw power of nature's fury.");
        volcanoExpedition.setLatitude(28.3585);
        volcanoExpedition.setLongitude(-81.5595);
        volcanoExpedition.setPark(expeditionIsle);
        attractionRepository.save(volcanoExpedition);

        AttractionAccessibility volcanoExpeditionA11y = new AttractionAccessibility();
        volcanoExpeditionA11y.setMustTransfer(mustTransfer);
        volcanoExpeditionA11y.setTransferAssistance(transferAssistance);
        volcanoExpeditionA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        volcanoExpeditionA11y.setAssistiveDevices(assistiveDevices);
        volcanoExpeditionA11y.setSensoryExperience(sensoryExperience);
        volcanoExpeditionA11y.setAttraction(volcanoExpedition);
        attractionAccessibilityRepository.save(volcanoExpeditionA11y);


        Attraction ancientTempleRun = new Attraction();
        ancientTempleRun.setName("Ancient Temple Run");
        ancientTempleRun.setImageUrl(image);
        ancientTempleRun.setDescription("Embark on an Ancient Temple Run, racing through ancient ruins and dodging traps in search of hidden treasures. Can you escape the temple's curse?");
        ancientTempleRun.setLatitude(28.3587);
        ancientTempleRun.setLongitude(-81.5597);
        ancientTempleRun.setPark(expeditionIsle);
        attractionRepository.save(ancientTempleRun);

        AttractionAccessibility ancientTempleRunA11y = new AttractionAccessibility();
        ancientTempleRunA11y.setMustTransfer(mustTransfer);
        ancientTempleRunA11y.setTransferAssistance(transferAssistance);
        ancientTempleRunA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        ancientTempleRunA11y.setAssistiveDevices(assistiveDevices);
        ancientTempleRunA11y.setSensoryExperience(sensoryExperience);
        ancientTempleRunA11y.setAttraction(ancientTempleRun);
        attractionAccessibilityRepository.save(ancientTempleRunA11y);


        Attraction piratePlunder = new Attraction();
        piratePlunder.setName("Pirate's Plunder");
        piratePlunder.setImageUrl(image);
        piratePlunder.setDescription("Join a crew of swashbuckling pirates on an epic quest for treasure! Battle rival pirates, navigate treacherous waters, and uncover hidden riches in Pirate's Plunder.");
        piratePlunder.setLatitude(28.3589);
        piratePlunder.setLongitude(-81.5599);
        piratePlunder.setPark(expeditionIsle);
        attractionRepository.save(piratePlunder);

        AttractionAccessibility piratePlunderA11y = new AttractionAccessibility();
        piratePlunderA11y.setMustTransfer(mustTransfer);
        piratePlunderA11y.setTransferAssistance(transferAssistance);
        piratePlunderA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        piratePlunderA11y.setAssistiveDevices(assistiveDevices);
        piratePlunderA11y.setSensoryExperience(sensoryExperience);
        piratePlunderA11y.setAttraction(piratePlunder);
        attractionAccessibilityRepository.save(piratePlunderA11y);


        Attraction volcanoVenture = new Attraction();
        volcanoVenture.setName("Volcano Venture");
        volcanoVenture.setImageUrl(image);
        volcanoVenture.setDescription("Embark on a Volcano Venture, where you'll journey to the heart of a smoldering volcano. Experience the heat and thrill of molten lava as you explore its fiery depths.");
        volcanoVenture.setLatitude(28.3592);
        volcanoVenture.setLongitude(-81.5602);
        volcanoVenture.setPark(expeditionIsle);
        attractionRepository.save(volcanoVenture);

        AttractionAccessibility volcanoVentureA11y = new AttractionAccessibility();
        volcanoVentureA11y.setMustTransfer(mustTransfer);
        volcanoVentureA11y.setTransferAssistance(transferAssistance);
        volcanoVentureA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        volcanoVentureA11y.setAssistiveDevices(assistiveDevices);
        volcanoVentureA11y.setSensoryExperience(sensoryExperience);
        volcanoVentureA11y.setAttraction(volcanoVenture);
        attractionAccessibilityRepository.save(volcanoVentureA11y);


        Attraction lostTribesTrail = new Attraction();
        lostTribesTrail.setName("Lost Tribes Trail");
        lostTribesTrail.setImageUrl(image);
        lostTribesTrail.setDescription("Navigate the Lost Tribes Trail, a rugged path through dense jungles and ancient ruins. Encounter remote tribes and uncover the secrets of their lost civilization.");
        lostTribesTrail.setLatitude(28.3593);
        lostTribesTrail.setLongitude(-81.5603);
        lostTribesTrail.setPark(expeditionIsle);
        attractionRepository.save(lostTribesTrail);

        AttractionAccessibility lostTribesTrailA11y = new AttractionAccessibility();
        lostTribesTrailA11y.setMustTransfer(mustTransfer);
        lostTribesTrailA11y.setTransferAssistance(transferAssistance);
        lostTribesTrailA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        lostTribesTrailA11y.setAssistiveDevices(assistiveDevices);
        lostTribesTrailA11y.setSensoryExperience(sensoryExperience);
        lostTribesTrailA11y.setAttraction(lostTribesTrail);
        attractionAccessibilityRepository.save(lostTribesTrailA11y);




        Park mysticalForest = new Park();
        mysticalForest.setName("Mystical Forest");
        mysticalForest.setImageUrl("https://t3.ftcdn.net/jpg/06/10/66/24/360_F_610662465_iflFvBuFDazEDvnLSwMiElTI4jDIdpdK.jpg");
        mysticalForest.setDescription("Embark on a wild expedition at Malt Fizzby's Mystical Forest. Encounter exotic animals, enjoy thrilling rides, and connect with nature in immersive and educational experiences that inspire a deeper appreciation for our planet's wildlife and ecosystems.");
        mysticalForest.setLatitude(28.3574);
        mysticalForest.setLongitude(81.5906);
        parkRepository.save(mysticalForest);

        ParkAccessibility mysticalForestA11y = new ParkAccessibility();
        mysticalForestA11y.setRentalLocations(randomList);
        mysticalForestA11y.setWheelchairReplacementLocations(randomList);
        mysticalForestA11y.setBreakLocations(randomList);
        mysticalForestA11y.setStationaryBrailleMapLocations(randomList);
        mysticalForestA11y.setSignLanguageSchedule(schedule);
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
        etherealGardens.setImageUrl("https://drive.google.com/thumbnail?id=12xb4AxNSIDkE6Qbw5KcjSytQyjuwPmo4&sz=w200-h200");
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


        Attraction enchantedFalls = new Attraction();
        enchantedFalls.setName("Enchanted Falls");
        enchantedFalls.setImageUrl(image);
        enchantedFalls.setDescription("Discover the Enchanted Falls, a magical waterfall hidden within the heart of the forest. Feel the rejuvenating mist and marvel at its beauty.");
        enchantedFalls.setLatitude(28.3577);
        enchantedFalls.setLongitude(81.5909);
        enchantedFalls.setPark(mysticalForest);
        attractionRepository.save(enchantedFalls);

        AttractionAccessibility enchantedFallsA11y = new AttractionAccessibility();
        enchantedFallsA11y.setMustTransfer(mustTransfer);
        enchantedFallsA11y.setTransferAssistance(transferAssistance);
        enchantedFallsA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        enchantedFallsA11y.setAssistiveDevices(assistiveDevices);
        enchantedFallsA11y.setSensoryExperience(sensoryExperience);
        enchantedFallsA11y.setAttraction(enchantedFalls);
        attractionAccessibilityRepository.save(enchantedFallsA11y);


        Attraction enchantedGlade = new Attraction();
        enchantedGlade.setName("Enchanted Glade");
        enchantedGlade.setImageUrl(image);
        enchantedGlade.setDescription("Enter the Enchanted Glade, where mystical creatures frolic and ancient trees whisper secrets. Experience the magic of nature.");
        enchantedGlade.setLatitude(28.3576);
        enchantedGlade.setLongitude(81.5908);
        enchantedGlade.setPark(mysticalForest);
        attractionRepository.save(enchantedGlade);

        AttractionAccessibility enchantedGladeA11y = new AttractionAccessibility();
        enchantedGladeA11y.setMustTransfer(mustTransfer);
        enchantedGladeA11y.setTransferAssistance(transferAssistance);
        enchantedGladeA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        enchantedGladeA11y.setAssistiveDevices(assistiveDevices);
        enchantedGladeA11y.setSensoryExperience(sensoryExperience);
        enchantedGladeA11y.setAttraction(enchantedGlade);
        attractionAccessibilityRepository.save(enchantedGladeA11y);


        Attraction mysticalMaze = new Attraction();
        mysticalMaze.setName("Mystical Maze");
        mysticalMaze.setImageUrl(image);
        mysticalMaze.setDescription("Navigate through the Mystical Maze, a labyrinth of twists and turns filled with magical illusions and hidden passages.");
        mysticalMaze.setLatitude(28.3577);
        mysticalMaze.setLongitude(81.5909);
        mysticalMaze.setPark(mysticalForest);
        attractionRepository.save(mysticalMaze);

        AttractionAccessibility mysticalMazeA11y = new AttractionAccessibility();
        mysticalMazeA11y.setMustTransfer(mustTransfer);
        mysticalMazeA11y.setTransferAssistance(transferAssistance);
        mysticalMazeA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        mysticalMazeA11y.setAssistiveDevices(assistiveDevices);
        mysticalMazeA11y.setSensoryExperience(sensoryExperience);
        mysticalMazeA11y.setAttraction(mysticalMaze);
        attractionAccessibilityRepository.save(mysticalMazeA11y);


        Attraction whisperingWillows = new Attraction();
        whisperingWillows.setName("Whispering Willows");
        whisperingWillows.setImageUrl(image);
        whisperingWillows.setDescription("Walk among the Whispering Willows, where where ancient trees hold secrets, leaves rustle with ancient tales, and mystical creatures dwell. Listen closely to hear the whispers of the forest.");
        whisperingWillows.setLatitude(28.3575);
        whisperingWillows.setLongitude(81.5907);
        whisperingWillows.setPark(mysticalForest);
        attractionRepository.save(whisperingWillows);

        AttractionAccessibility whisperingWillowsA11y = new AttractionAccessibility();
        whisperingWillowsA11y.setMustTransfer(mustTransfer);
        whisperingWillowsA11y.setTransferAssistance(transferAssistance);
        whisperingWillowsA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        whisperingWillowsA11y.setAssistiveDevices(assistiveDevices);
        whisperingWillowsA11y.setSensoryExperience(sensoryExperience);
        whisperingWillowsA11y.setAttraction(whisperingWillows);
        attractionAccessibilityRepository.save(whisperingWillowsA11y);


        Attraction mysticalMenagerie = new Attraction();
        mysticalMenagerie.setName("Mystical Menagerie");
        mysticalMenagerie.setImageUrl(image);
        mysticalMenagerie.setDescription("Discover the Mystical Menagerie, home to mythical creatures from all corners of the world. Witness unicorns, dragons, and phoenixes in their natural habitat.");
        mysticalMenagerie.setLatitude(28.3574);
        mysticalMenagerie.setLongitude(81.5906);
        mysticalMenagerie.setPark(mysticalForest);
        attractionRepository.save(mysticalMenagerie);

        AttractionAccessibility mysticalMenagerieA11y = new AttractionAccessibility();
        mysticalMenagerieA11y.setMustTransfer(mustTransfer);
        mysticalMenagerieA11y.setTransferAssistance(transferAssistance);
        mysticalMenagerieA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        mysticalMenagerieA11y.setAssistiveDevices(assistiveDevices);
        mysticalMenagerieA11y.setSensoryExperience(sensoryExperience);
        mysticalMenagerieA11y.setAttraction(mysticalMenagerie);
        attractionAccessibilityRepository.save(mysticalMenagerieA11y);


        Attraction fairyGrove = new Attraction();
        fairyGrove.setName("Fairy Grove");
        fairyGrove.setImageUrl(image);
        fairyGrove.setDescription("Discover the Fairy Grove, a hidden sanctuary where mystical creatures dwell. Encounter fairies, sprites, and other fantastical beings in this whimsical forest realm.");
        fairyGrove.setLatitude(28.3576);
        fairyGrove.setLongitude(81.5908);
        fairyGrove.setPark(mysticalForest);
        attractionRepository.save(fairyGrove);

        AttractionAccessibility fairyGroveA11y = new AttractionAccessibility();
        fairyGroveA11y.setMustTransfer(mustTransfer);
        fairyGroveA11y.setTransferAssistance(transferAssistance);
        fairyGroveA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        fairyGroveA11y.setAssistiveDevices(assistiveDevices);
        fairyGroveA11y.setSensoryExperience(sensoryExperience);
        fairyGroveA11y.setAttraction(fairyGrove);
        attractionAccessibilityRepository.save(fairyGroveA11y);


        Attraction twilightTreetops = new Attraction();
        twilightTreetops.setName("Twilight Treetops");
        twilightTreetops.setImageUrl(image);
        twilightTreetops.setDescription("Ascend to the Twilight Treetops, where the forest canopy comes alive with magic under the shimmering light of the moon. Glide through the treetops on a mystical journey of wonder and enchantment.");
        twilightTreetops.setLatitude(28.3579);
        twilightTreetops.setLongitude(81.5911);
        twilightTreetops.setPark(mysticalForest);
        attractionRepository.save(twilightTreetops);

        AttractionAccessibility twilightTreetopsA11y = new AttractionAccessibility();
        twilightTreetopsA11y.setMustTransfer(mustTransfer);
        twilightTreetopsA11y.setTransferAssistance(transferAssistance);
        twilightTreetopsA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        twilightTreetopsA11y.setAssistiveDevices(assistiveDevices);
        twilightTreetopsA11y.setSensoryExperience(sensoryExperience);
        twilightTreetopsA11y.setAttraction(twilightTreetops);
        attractionAccessibilityRepository.save(twilightTreetopsA11y);


        Attraction celestialCaverns = new Attraction();
        celestialCaverns.setName("Celestial Caverns");
        celestialCaverns.setImageUrl(image);
        celestialCaverns.setDescription("Explore the Celestial Caverns, a subterranean wonderland illuminated by glowing crystals and ancient starlight. Journey through caverns filled with mystery and awe as you uncover the secrets of the earth.");
        celestialCaverns.setLatitude(28.3580);
        celestialCaverns.setLongitude(81.5912);
        celestialCaverns.setPark(mysticalForest);
        attractionRepository.save(celestialCaverns);

        AttractionAccessibility celestialCavernsA11y = new AttractionAccessibility();
        celestialCavernsA11y.setMustTransfer(mustTransfer);
        celestialCavernsA11y.setTransferAssistance(transferAssistance);
        celestialCavernsA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        celestialCavernsA11y.setAssistiveDevices(assistiveDevices);
        celestialCavernsA11y.setSensoryExperience(sensoryExperience);
        celestialCavernsA11y.setAttraction(celestialCaverns);
        attractionAccessibilityRepository.save(celestialCavernsA11y);


        Attraction emeraldFalls = new Attraction();
        emeraldFalls.setName("Emerald Falls");
        emeraldFalls.setImageUrl(image);
        emeraldFalls.setDescription("Marvel at the beauty of Emerald Falls, where sparkling waters cascade down emerald-hued cliffs. Experience the tranquility of this hidden oasis as you bask in its serene atmosphere.");
        emeraldFalls.setLatitude(28.3581);
        emeraldFalls.setLongitude(81.5913);
        emeraldFalls.setPark(mysticalForest);
        attractionRepository.save(emeraldFalls);

        AttractionAccessibility emeraldFallsA11y = new AttractionAccessibility();
        emeraldFallsA11y.setMustTransfer(mustTransfer);
        emeraldFallsA11y.setTransferAssistance(transferAssistance);
        emeraldFallsA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        emeraldFallsA11y.setAssistiveDevices(assistiveDevices);
        emeraldFallsA11y.setSensoryExperience(sensoryExperience);
        emeraldFallsA11y.setAttraction(emeraldFalls);
        attractionAccessibilityRepository.save(emeraldFallsA11y);
        

        Attraction arcaneArboretum = new Attraction();
        arcaneArboretum.setName("Arcane Arboretum");
        arcaneArboretum.setImageUrl(image);
        arcaneArboretum.setDescription("Enter the Arcane Arboretum, where ancient trees hold the secrets of centuries past. Wander among rare flora and fauna as you uncover the mysteries of this enchanted forest.");
        arcaneArboretum.setLatitude(28.3582);
        arcaneArboretum.setLongitude(81.5914);
        arcaneArboretum.setPark(mysticalForest);
        attractionRepository.save(arcaneArboretum);

        AttractionAccessibility arcaneArboretumA11y = new AttractionAccessibility();
        arcaneArboretumA11y.setMustTransfer(mustTransfer);
        arcaneArboretumA11y.setTransferAssistance(transferAssistance);
        arcaneArboretumA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        arcaneArboretumA11y.setAssistiveDevices(assistiveDevices);
        arcaneArboretumA11y.setSensoryExperience(sensoryExperience);
        arcaneArboretumA11y.setAttraction(arcaneArboretum);
        attractionAccessibilityRepository.save(arcaneArboretumA11y);


        Attraction crystalCove = new Attraction();
        crystalCove.setName("Crystal Cove");
        crystalCove.setImageUrl(image);
        crystalCove.setDescription("Embark on an adventure to Crystal Cove, a hidden gem nestled within the heart of the forest. Discover shimmering pools, crystal formations, and mystical caves as you journey through this enchanting landscape.");
        crystalCove.setLatitude(28.3583);
        crystalCove.setLongitude(81.5915);
        crystalCove.setPark(mysticalForest);
        attractionRepository.save(crystalCove);

        AttractionAccessibility crystalCoveA11y = new AttractionAccessibility();
        crystalCoveA11y.setMustTransfer(mustTransfer);
        crystalCoveA11y.setTransferAssistance(transferAssistance);
        crystalCoveA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        crystalCoveA11y.setAssistiveDevices(assistiveDevices);
        crystalCoveA11y.setSensoryExperience(sensoryExperience);
        crystalCoveA11y.setAttraction(crystalCove);
        attractionAccessibilityRepository.save(crystalCoveA11y);
        

        Attraction nymphsNook = new Attraction();
        nymphsNook.setName("Nymph's Nook");
        nymphsNook.setImageUrl(image);
        nymphsNook.setDescription("Find solace in Nymph's Nook, a tranquil sanctuary where the spirits of the forest dwell. Connect with nature and experience the serenity of this magical glade.");
        nymphsNook.setLatitude(28.3584);
        nymphsNook.setLongitude(81.5916);
        nymphsNook.setPark(mysticalForest);
        attractionRepository.save(nymphsNook);
        
        AttractionAccessibility nymphsNookA11y = new AttractionAccessibility();
        nymphsNookA11y.setMustTransfer(mustTransfer);
        nymphsNookA11y.setTransferAssistance(transferAssistance);
        nymphsNookA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        nymphsNookA11y.setAssistiveDevices(assistiveDevices);
        nymphsNookA11y.setSensoryExperience(sensoryExperience);
        nymphsNookA11y.setAttraction(nymphsNook);
        attractionAccessibilityRepository.save(nymphsNookA11y);




        Park fantasyGalaxy = new Park();
        fantasyGalaxy.setName("Fantasy Galaxy");
        fantasyGalaxy.setImageUrl("https://cdn.dribbble.com/userupload/12230049/file/original-79264f668db395868455ca1f0ee14cd2.png?resize=400x300&vertical=center");
        fantasyGalaxy.setDescription("Explore the wonders of the past, present, and future at Fantasy Galaxy, where innovation meets imagination. Discover technological innovations and international cuisine as you journey through this celebration of human achievement and global diversity.");
        fantasyGalaxy.setLatitude(28.3765);
        fantasyGalaxy.setLongitude(81.5494);
        parkRepository.save(fantasyGalaxy);

        ParkAccessibility fantasyGalaxyA11y = new ParkAccessibility();
        fantasyGalaxyA11y.setRentalLocations(randomList);
        fantasyGalaxyA11y.setWheelchairReplacementLocations(randomList);
        fantasyGalaxyA11y.setBreakLocations(randomList);
        fantasyGalaxyA11y.setStationaryBrailleMapLocations(randomList);
        fantasyGalaxyA11y.setSignLanguageSchedule(schedule);
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
        starfallObservatory.setImageUrl("https://drive.google.com/thumbnail?id=1XMW-XZY-lBTD340mUjrPwhAEXI2Jr1cW&sz=w200-h200");
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


        Attraction cosmicCafe = new Attraction();
        cosmicCafe.setName("Cosmic Cafe");
        cosmicCafe.setImageUrl(image);
        cosmicCafe.setDescription("Dine at the Cosmic Cafe, a futuristic eatery offering intergalactic cuisine from across the galaxy. Experience flavors beyond imagination.");
        cosmicCafe.setLatitude(28.3767);
        cosmicCafe.setLongitude(81.5496);
        cosmicCafe.setPark(fantasyGalaxy);
        attractionRepository.save(cosmicCafe);

        AttractionAccessibility cosmicCafeA11y = new AttractionAccessibility();
        cosmicCafeA11y.setMustTransfer(mustTransfer);
        cosmicCafeA11y.setTransferAssistance(transferAssistance);
        cosmicCafeA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        cosmicCafeA11y.setAssistiveDevices(assistiveDevices);
        cosmicCafeA11y.setSensoryExperience(sensoryExperience);
        cosmicCafeA11y.setAttraction(cosmicCafe);
        attractionAccessibilityRepository.save(cosmicCafeA11y);


        Attraction spaceExplorers = new Attraction();
        spaceExplorers.setName("Space Explorers");
        spaceExplorers.setImageUrl(image);
        spaceExplorers.setDescription("Join the Space Explorers on a thrilling journey to the outer reaches of the galaxy. Blast off into space and explore distant worlds.");
        spaceExplorers.setLatitude(28.3768);
        spaceExplorers.setLongitude(81.5497);
        spaceExplorers.setPark(fantasyGalaxy);
        attractionRepository.save(spaceExplorers);

        AttractionAccessibility spaceExplorersA11y = new AttractionAccessibility();
        spaceExplorersA11y.setMustTransfer(mustTransfer);
        spaceExplorersA11y.setTransferAssistance(transferAssistance);
        spaceExplorersA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        spaceExplorersA11y.setAssistiveDevices(assistiveDevices);
        spaceExplorersA11y.setSensoryExperience(sensoryExperience);
        spaceExplorersA11y.setAttraction(spaceExplorers);
        attractionAccessibilityRepository.save(spaceExplorersA11y);


        Attraction spaceStationAlpha = new Attraction();
        spaceStationAlpha.setName("Space Station Alpha");
        spaceStationAlpha.setImageUrl(image);
        spaceStationAlpha.setDescription("Visit Space Station Alpha, a futuristic outpost orbiting distant planets. Experience zero-gravity simulations and spacewalk adventures.");
        spaceStationAlpha.setLatitude(28.3767);
        spaceStationAlpha.setLongitude(81.5496);
        spaceStationAlpha.setPark(fantasyGalaxy);
        attractionRepository.save(spaceStationAlpha);

        AttractionAccessibility spaceStationAlphaA11y = new AttractionAccessibility();
        spaceStationAlphaA11y.setMustTransfer(mustTransfer);
        spaceStationAlphaA11y.setTransferAssistance(transferAssistance);
        spaceStationAlphaA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        spaceStationAlphaA11y.setAssistiveDevices(assistiveDevices);
        spaceStationAlphaA11y.setSensoryExperience(sensoryExperience);
        spaceStationAlphaA11y.setAttraction(spaceStationAlpha);
        attractionAccessibilityRepository.save(spaceStationAlphaA11y);


        Attraction cosmicCarousel = new Attraction();
        cosmicCarousel.setName("Cosmic Carousel");
        cosmicCarousel.setImageUrl(image);
        cosmicCarousel.setDescription("Ride the Cosmic Carousel, a space-themed merry-go-round featuring intergalactic creatures and cosmic wonders.");
        cosmicCarousel.setLatitude(28.3768);
        cosmicCarousel.setLongitude(81.5497);
        cosmicCarousel.setPark(fantasyGalaxy);
        attractionRepository.save(cosmicCarousel);

        AttractionAccessibility cosmicCarouselA11y = new AttractionAccessibility();
        cosmicCarouselA11y.setMustTransfer(mustTransfer);
        cosmicCarouselA11y.setTransferAssistance(transferAssistance);
        cosmicCarouselA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        cosmicCarouselA11y.setAssistiveDevices(assistiveDevices);
        cosmicCarouselA11y.setSensoryExperience(sensoryExperience);
        cosmicCarouselA11y.setAttraction(cosmicCarousel);
        attractionAccessibilityRepository.save(cosmicCarouselA11y);


        Attraction interstellarMarket = new Attraction();
        interstellarMarket.setName("Interstellar Market");
        interstellarMarket.setImageUrl(image);
        interstellarMarket.setDescription("Explore the Interstellar Market, a bustling hub of commerce from across the galaxy. Purchase exotic goods, sample alien cuisine, and barter with traders from distant planets.");
        interstellarMarket.setLatitude(28.3766);
        interstellarMarket.setLongitude(81.5495);
        interstellarMarket.setPark(fantasyGalaxy);
        attractionRepository.save(interstellarMarket);

        AttractionAccessibility interstellarMarketA11y = new AttractionAccessibility();
        interstellarMarketA11y.setMustTransfer(mustTransfer);
        interstellarMarketA11y.setTransferAssistance(transferAssistance);
        interstellarMarketA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        interstellarMarketA11y.setAssistiveDevices(assistiveDevices);
        interstellarMarketA11y.setSensoryExperience(sensoryExperience);
        interstellarMarketA11y.setAttraction(interstellarMarket);
        attractionAccessibilityRepository.save(interstellarMarketA11y);
        

        Attraction warpDriveAdventure = new Attraction();
        warpDriveAdventure.setName("Warp Drive Adventure");
        warpDriveAdventure.setImageUrl(image);
        warpDriveAdventure.setDescription("Embark on the Warp Drive Adventure, a thrilling journey through hyperspace. Brace yourself for warp speed and intergalactic encounters.");
        warpDriveAdventure.setLatitude(28.3769);
        warpDriveAdventure.setLongitude(81.5498);
        warpDriveAdventure.setPark(fantasyGalaxy);
        attractionRepository.save(warpDriveAdventure);

        AttractionAccessibility warpDriveAdventureA11y = new AttractionAccessibility();
        warpDriveAdventureA11y.setMustTransfer(mustTransfer);
        warpDriveAdventureA11y.setTransferAssistance(transferAssistance);
        warpDriveAdventureA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        warpDriveAdventureA11y.setAssistiveDevices(assistiveDevices);
        warpDriveAdventureA11y.setSensoryExperience(sensoryExperience);
        warpDriveAdventureA11y.setAttraction(warpDriveAdventure);
        attractionAccessibilityRepository.save(warpDriveAdventureA11y);


        Attraction cosmicCarnival = new Attraction();
        cosmicCarnival.setName("Cosmic Carnival");
        cosmicCarnival.setImageUrl(image);
        cosmicCarnival.setDescription("Step right up to the Cosmic Carnival, where the wonders of the universe come to life in a dazzling spectacle of lights and excitement. Experience thrilling rides, cosmic treats, and out-of-this-world entertainment.");
        cosmicCarnival.setLatitude(28.3766);
        cosmicCarnival.setLongitude(81.5495);
        cosmicCarnival.setPark(fantasyGalaxy);
        attractionRepository.save(cosmicCarnival);

        AttractionAccessibility cosmicCarnivalA11y = new AttractionAccessibility();
        cosmicCarnivalA11y.setMustTransfer(mustTransfer);
        cosmicCarnivalA11y.setTransferAssistance(transferAssistance);
        cosmicCarnivalA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        cosmicCarnivalA11y.setAssistiveDevices(assistiveDevices);
        cosmicCarnivalA11y.setSensoryExperience(sensoryExperience);
        cosmicCarnivalA11y.setAttraction(cosmicCarnival);
        attractionAccessibilityRepository.save(cosmicCarnivalA11y);


        Attraction galacticGardens = new Attraction();
        galacticGardens.setName("Galactic Gardens");
        galacticGardens.setImageUrl(image);
        galacticGardens.setDescription("Explore the wonders of the galaxy at Galactic Gardens, where celestial flora and fauna thrive in an otherworldly oasis. Wander among alien landscapes and discover the beauty of interstellar horticulture.");
        galacticGardens.setLatitude(28.3767);
        galacticGardens.setLongitude(81.5496);
        galacticGardens.setPark(fantasyGalaxy);
        attractionRepository.save(galacticGardens);

        AttractionAccessibility galacticGardensA11y = new AttractionAccessibility();
        galacticGardensA11y.setMustTransfer(mustTransfer);
        galacticGardensA11y.setTransferAssistance(transferAssistance);
        galacticGardensA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        galacticGardensA11y.setAssistiveDevices(assistiveDevices);
        galacticGardensA11y.setSensoryExperience(sensoryExperience);
        galacticGardensA11y.setAttraction(galacticGardens);
        attractionAccessibilityRepository.save(galacticGardensA11y);


        Attraction stellarSpire = new Attraction();
        stellarSpire.setName("Stellar Spire");
        stellarSpire.setImageUrl(image);
        stellarSpire.setDescription("Ascend the Stellar Spire and gaze upon the breathtaking vistas of the galaxy. Marvel at distant stars, nebulae, and cosmic phenomena as you journey to the edge of the universe.");
        stellarSpire.setLatitude(28.3768);
        stellarSpire.setLongitude(81.5497);
        stellarSpire.setPark(fantasyGalaxy);
        attractionRepository.save(stellarSpire);

        AttractionAccessibility stellarSpireA11y = new AttractionAccessibility();
        stellarSpireA11y.setMustTransfer(mustTransfer);
        stellarSpireA11y.setTransferAssistance(transferAssistance);
        stellarSpireA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        stellarSpireA11y.setAssistiveDevices(assistiveDevices);
        stellarSpireA11y.setSensoryExperience(sensoryExperience);
        stellarSpireA11y.setAttraction(stellarSpire);
        attractionAccessibilityRepository.save(stellarSpireA11y);


        Attraction nebulaNebulae = new Attraction();
        nebulaNebulae.setName("Nebula Nebulae");
        nebulaNebulae.setImageUrl(image);
        nebulaNebulae.setDescription("Immerse yourself in the swirling mists of Nebula Nebulae, where clouds of cosmic dust give birth to new stars and planets. Witness the birth of galaxies and the dance of celestial bodies in this mesmerizing journey through space.");
        nebulaNebulae.setLatitude(28.3769);
        nebulaNebulae.setLongitude(81.5498);
        nebulaNebulae.setPark(fantasyGalaxy);
        attractionRepository.save(nebulaNebulae);

        AttractionAccessibility nebulaNebulaeA11y = new AttractionAccessibility();
        nebulaNebulaeA11y.setMustTransfer(mustTransfer);
        nebulaNebulaeA11y.setTransferAssistance(transferAssistance);
        nebulaNebulaeA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        nebulaNebulaeA11y.setAssistiveDevices(assistiveDevices);
        nebulaNebulaeA11y.setSensoryExperience(sensoryExperience);
        nebulaNebulaeA11y.setAttraction(nebulaNebulae);
        attractionAccessibilityRepository.save(nebulaNebulaeA11y);


        Attraction galacticExplorer = new Attraction();
        galacticExplorer.setName("Galactic Explorer");
        galacticExplorer.setImageUrl(image);
        galacticExplorer.setDescription("Embark on an exhilarating journey aboard the Galactic Explorer spaceship. Traverse distant galaxies, encounter alien civilizations, and unlock the mysteries of the cosmos in this thrilling space adventure.");
        galacticExplorer.setLatitude(28.3770);
        galacticExplorer.setLongitude(81.5499);
        galacticExplorer.setPark(fantasyGalaxy);
        attractionRepository.save(galacticExplorer);

        AttractionAccessibility galacticExplorerA11y = new AttractionAccessibility();
        galacticExplorerA11y.setMustTransfer(mustTransfer);
        galacticExplorerA11y.setTransferAssistance(transferAssistance);
        galacticExplorerA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        galacticExplorerA11y.setAssistiveDevices(assistiveDevices);
        galacticExplorerA11y.setSensoryExperience(sensoryExperience);
        galacticExplorerA11y.setAttraction(galacticExplorer);
        attractionAccessibilityRepository.save(galacticExplorerA11y);


        Attraction interstellarArcade = new Attraction();
        interstellarArcade.setName("Interstellar Arcade");
        interstellarArcade.setImageUrl(image);
        interstellarArcade.setDescription("Step into the Interstellar Arcade and journey through a galaxy of gaming. Test your skills on futuristic arcade machines, virtual reality simulations, and interactive challenges that are out of this world.");
        interstellarArcade.setLatitude(28.3772);
        interstellarArcade.setLongitude(81.5501);
        interstellarArcade.setPark(fantasyGalaxy);
        attractionRepository.save(interstellarArcade);

        AttractionAccessibility interstellarArcadeA11y = new AttractionAccessibility();
        interstellarArcadeA11y.setMustTransfer(mustTransfer);
        interstellarArcadeA11y.setTransferAssistance(transferAssistance);
        interstellarArcadeA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        interstellarArcadeA11y.setAssistiveDevices(assistiveDevices);
        interstellarArcadeA11y.setSensoryExperience(sensoryExperience);
        interstellarArcadeA11y.setAttraction(interstellarArcade);
        attractionAccessibilityRepository.save(interstellarArcadeA11y);

        Attraction stellarStage = new Attraction();
        stellarStage.setName("Stellar Stage");
        stellarStage.setImageUrl(image);
        stellarStage.setDescription("Be dazzled by the performances at the Stellar Stage, where cosmic talent takes center stage. From intergalactic musicians to futuristic dancers, experience entertainment like never before in this celestial theater.");
        stellarStage.setLatitude(28.3773);
        stellarStage.setLongitude(81.5502);
        stellarStage.setPark(fantasyGalaxy);
        attractionRepository.save(stellarStage);

        AttractionAccessibility stellarStageA11y = new AttractionAccessibility();
        stellarStageA11y.setMustTransfer(mustTransfer);
        stellarStageA11y.setTransferAssistance(transferAssistance);
        stellarStageA11y.setServiceAnimalRestrictions(serviceAnimalRestrictions);
        stellarStageA11y.setAssistiveDevices(assistiveDevices);
        stellarStageA11y.setSensoryExperience(sensoryExperience);
        stellarStageA11y.setAttraction(stellarStage);
        attractionAccessibilityRepository.save(stellarStageA11y);


    }
}
