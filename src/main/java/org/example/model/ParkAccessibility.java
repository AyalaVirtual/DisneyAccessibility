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
    @OneToOne(mappedBy = "park", cascade = CascadeType.ALL) // This means there is a one-to-one relationship between ParkAccessibility and Park that is mapped by the 'park' variable. It also specifies that when you perform operations on a Park (like save or delete), the same operation should be cascaded to its associated ParkAccessibility. This ensures that the accessibility information is managed along with the park.
    @JoinColumn(name = "park_id") // This represents the foreign key in SQL joining the columns to connect the 2 tables
    private Park park;


    public ParkAccessibility() {
    }

    public ParkAccessibility(Long id, List<String> rentalLocations, List<String> wheelchairReplacementLocations, List<String> breakLocations, List<String> stationaryBrailleMapLocations, String signLanguageSchedule, List<String> guestRelationsLocations, List<String> serviceAnimalRestrictions_Ride, List<String> serviceAnimalRestrictions_Board, List<String> serviceAnimalReliefAreas, List<String> companionRestroomLocations, String firstAidLocations, Park park) {
        this.id = id;
        this.rentalLocations = rentalLocations;
        this.wheelchairReplacementLocations = wheelchairReplacementLocations;
        this.breakLocations = breakLocations;
        this.stationaryBrailleMapLocations = stationaryBrailleMapLocations;
        this.signLanguageSchedule = signLanguageSchedule;
        this.guestRelationsLocations = guestRelationsLocations;
        this.serviceAnimalRestrictions_Ride = serviceAnimalRestrictions_Ride;
        this.serviceAnimalRestrictions_Board = serviceAnimalRestrictions_Board;
        this.serviceAnimalReliefAreas = serviceAnimalReliefAreas;
        this.companionRestroomLocations = companionRestroomLocations;
        this.firstAidLocations = firstAidLocations;
        this.park = park;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getRentalLocations() {
        return rentalLocations;
    }

    public void setRentalLocations(List<String> rentalLocations) {
        this.rentalLocations = rentalLocations;
    }

    public List<String> getWheelchairReplacementLocations() {
        return wheelchairReplacementLocations;
    }

    public void setWheelchairReplacementLocations(List<String> wheelchairReplacementLocations) {
        this.wheelchairReplacementLocations = wheelchairReplacementLocations;
    }

    public List<String> getBreakLocations() {
        return breakLocations;
    }

    public void setBreakLocations(List<String> breakLocations) {
        this.breakLocations = breakLocations;
    }

    public List<String> getStationaryBrailleMapLocations() {
        return stationaryBrailleMapLocations;
    }

    public void setStationaryBrailleMapLocations(List<String> stationaryBrailleMapLocations) {
        this.stationaryBrailleMapLocations = stationaryBrailleMapLocations;
    }

    public String getSignLanguageSchedule() {
        return signLanguageSchedule;
    }

    public void setSignLanguageSchedule(String signLanguageSchedule) {
        this.signLanguageSchedule = signLanguageSchedule;
    }

    public List<String> getGuestRelationsLocations() {
        return guestRelationsLocations;
    }

    public void setGuestRelationsLocations(List<String> guestRelationsLocations) {
        this.guestRelationsLocations = guestRelationsLocations;
    }

    public List<String> getServiceAnimalRestrictions_Ride() {
        return serviceAnimalRestrictions_Ride;
    }

    public void setServiceAnimalRestrictions_Ride(List<String> serviceAnimalRestrictions_Ride) {
        this.serviceAnimalRestrictions_Ride = serviceAnimalRestrictions_Ride;
    }

    public List<String> getServiceAnimalRestrictions_Board() {
        return serviceAnimalRestrictions_Board;
    }

    public void setServiceAnimalRestrictions_Board(List<String> serviceAnimalRestrictions_Board) {
        this.serviceAnimalRestrictions_Board = serviceAnimalRestrictions_Board;
    }

    public List<String> getServiceAnimalReliefAreas() {
        return serviceAnimalReliefAreas;
    }

    public void setServiceAnimalReliefAreas(List<String> serviceAnimalReliefAreas) {
        this.serviceAnimalReliefAreas = serviceAnimalReliefAreas;
    }

    public List<String> getCompanionRestroomLocations() {
        return companionRestroomLocations;
    }

    public void setCompanionRestroomLocations(List<String> companionRestroomLocations) {
        this.companionRestroomLocations = companionRestroomLocations;
    }

    public String getFirstAidLocations() {
        return firstAidLocations;
    }

    public void setFirstAidLocations(String firstAidLocations) {
        this.firstAidLocations = firstAidLocations;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }


    @Override
    public String toString() {
        return "ParkAccessibility{" +
                "id=" + id +
                ", rentalLocations=" + rentalLocations +
                ", wheelchairReplacementLocations=" + wheelchairReplacementLocations +
                ", breakLocations=" + breakLocations +
                ", stationaryBrailleMapLocations=" + stationaryBrailleMapLocations +
                ", signLanguageSchedule='" + signLanguageSchedule + '\'' +
                ", guestRelationsLocations=" + guestRelationsLocations +
                ", serviceAnimalRestrictions_Ride=" + serviceAnimalRestrictions_Ride +
                ", serviceAnimalRestrictions_Board=" + serviceAnimalRestrictions_Board +
                ", serviceAnimalReliefAreas=" + serviceAnimalReliefAreas +
                ", companionRestroomLocations=" + companionRestroomLocations +
                ", firstAidLocations='" + firstAidLocations + '\'' +
                ", park=" + park +
                '}';
    }
}
