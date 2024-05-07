package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="parkaccessibility")
public class ParkAccessibility {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private List<String> rentalLocations;

    @Column
    private List<String> wheelchairReplacementLocations;

    @Column
    private List<String> breakLocations;

    @Column
    private List<String> stationaryBrailleMapLocations;

    @Column
    private String signLanguageSchedule;

    @Column
    private List<String> guestRelationsLocations;

    @Column
    private List<String> serviceAnimalRestrictions_Ride;

    @Column
    private List<String> serviceAnimalRestrictions_Board;

    @Column
    private List<String> serviceAnimalReliefAreas;

    @Column
    private List<String> companionRestroomLocations;

    private String firstAidLocations;

    // This links the table representing the ParkAccessibility model to the table representing the Park model
    @JsonIgnore // This prevents a stack overflow/API crashing from parks and parkAccessibility calling each other back and forth
    @OneToOne(mappedBy = "parkAccessibility", cascade = CascadeType.ALL) // This means there is a one-to-one relationship between ParkAccessibility and Park that is mapped by the 'parkAccessibility' variable in the Park class. It also specifies that when you perform operations on a Park (like save or delete), the same operation should be cascaded to its associated ParkAccessibility. This ensures that the accessibility information is managed along with the park.
    @JoinColumn(name = "park_id") // This represents the foreign key in SQL joining the columns to connect the 2 tables
    private Park park;


    public ParkAccessibility() {
    }



}
