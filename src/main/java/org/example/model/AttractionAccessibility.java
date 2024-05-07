package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.model.attractionaccessibilityattributes.MustTransfer;
import org.example.model.attractionaccessibilityattributes.SensoryExperience;


@Entity
@Table(name="attractionaccessibility")
public class AttractionAccessibility {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private MustTransfer mustTransfer;

    @Column
    private boolean loadUnloadAreas;

    @Column
    private boolean wheelchairAccessVehicles;

    @Column
    private boolean transferAccessVehicle;

    @Column
    private boolean transferDevices;

    @Column
    private boolean serviceAnimalRestrictions_Ride;

    @Column
    private boolean serviceAnimalRestrictions_Board;

    @Column
    private boolean assistiveListening;

    @Column
    private boolean audioDescription;

    @Column
    private boolean handheldCaptioning;

    @Column
    private boolean signLanguage;

    @Column
    private boolean videoCaptioning;

    @Column
    private SensoryExperience sensoryExperience;

    // This links the table representing the AttractionAccessibility model to the table representing the Attraction model
    @JsonIgnore // This prevents a stack overflow from Attractions and AttractionAccessibility calling each other back and forth
    @OneToOne(optional = false) // This means that a AttractionAccessibility record must always be associated with an Attraction record. An Attraction can exist without AttractionAccessibility, but every AttractionAccessibility must have a corresponding Attraction.
    @JoinColumn(name = "attraction_id") // This means that the AttractionAccessibility entity will have a foreign key column named attraction_id referring to the primary attribute id of our Attraction entity. This foreign key in SQL joins the columns to connect the 2 tables
    private Attraction attraction;


    public AttractionAccessibility() {
    }

    public AttractionAccessibility(Long id, MustTransfer mustTransfer, boolean loadUnloadAreas, boolean wheelchairAccessVehicles, boolean transferAccessVehicle, boolean transferDevices, boolean serviceAnimalRestrictions_Ride, boolean serviceAnimalRestrictions_Board, boolean assistiveListening, boolean audioDescription, boolean handheldCaptioning, boolean signLanguage, boolean videoCaptioning, SensoryExperience sensoryExperience, Attraction attraction) {
        this.id = id;
        this.mustTransfer = mustTransfer;
        this.loadUnloadAreas = loadUnloadAreas;
        this.wheelchairAccessVehicles = wheelchairAccessVehicles;
        this.transferAccessVehicle = transferAccessVehicle;
        this.transferDevices = transferDevices;
        this.serviceAnimalRestrictions_Ride = serviceAnimalRestrictions_Ride;
        this.serviceAnimalRestrictions_Board = serviceAnimalRestrictions_Board;
        this.assistiveListening = assistiveListening;
        this.audioDescription = audioDescription;
        this.handheldCaptioning = handheldCaptioning;
        this.signLanguage = signLanguage;
        this.videoCaptioning = videoCaptioning;
        this.sensoryExperience = sensoryExperience;
        this.attraction = attraction;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MustTransfer getMustTransfer() {
        return mustTransfer;
    }

    public void setMustTransfer(MustTransfer mustTransfer) {
        this.mustTransfer = mustTransfer;
    }

    public boolean isLoadUnloadAreas() {
        return loadUnloadAreas;
    }

    public void setLoadUnloadAreas(boolean loadUnloadAreas) {
        this.loadUnloadAreas = loadUnloadAreas;
    }

    public boolean isWheelchairAccessVehicles() {
        return wheelchairAccessVehicles;
    }

    public void setWheelchairAccessVehicles(boolean wheelchairAccessVehicles) {
        this.wheelchairAccessVehicles = wheelchairAccessVehicles;
    }

    public boolean isTransferAccessVehicle() {
        return transferAccessVehicle;
    }

    public void setTransferAccessVehicle(boolean transferAccessVehicle) {
        this.transferAccessVehicle = transferAccessVehicle;
    }

    public boolean isTransferDevices() {
        return transferDevices;
    }

    public void setTransferDevices(boolean transferDevices) {
        this.transferDevices = transferDevices;
    }

    public boolean isServiceAnimalRestrictions_Ride() {
        return serviceAnimalRestrictions_Ride;
    }

    public void setServiceAnimalRestrictions_Ride(boolean serviceAnimalRestrictions_Ride) {
        this.serviceAnimalRestrictions_Ride = serviceAnimalRestrictions_Ride;
    }

    public boolean isServiceAnimalRestrictions_Board() {
        return serviceAnimalRestrictions_Board;
    }

    public void setServiceAnimalRestrictions_Board(boolean serviceAnimalRestrictions_Board) {
        this.serviceAnimalRestrictions_Board = serviceAnimalRestrictions_Board;
    }

    public boolean isAssistiveListening() {
        return assistiveListening;
    }

    public void setAssistiveListening(boolean assistiveListening) {
        this.assistiveListening = assistiveListening;
    }

    public boolean isAudioDescription() {
        return audioDescription;
    }

    public void setAudioDescription(boolean audioDescription) {
        this.audioDescription = audioDescription;
    }

    public boolean isHandheldCaptioning() {
        return handheldCaptioning;
    }

    public void setHandheldCaptioning(boolean handheldCaptioning) {
        this.handheldCaptioning = handheldCaptioning;
    }

    public boolean isSignLanguage() {
        return signLanguage;
    }

    public void setSignLanguage(boolean signLanguage) {
        this.signLanguage = signLanguage;
    }

    public boolean isVideoCaptioning() {
        return videoCaptioning;
    }

    public void setVideoCaptioning(boolean videoCaptioning) {
        this.videoCaptioning = videoCaptioning;
    }

    public SensoryExperience getSensoryExperience() {
        return sensoryExperience;
    }

    public void setSensoryExperience(SensoryExperience sensoryExperience) {
        this.sensoryExperience = sensoryExperience;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }


    @Override
    public String toString() {
        return "AttractionAccessibility{" +
                "id=" + id +
                ", mustTransfer=" + mustTransfer +
                ", loadUnloadAreas=" + loadUnloadAreas +
                ", wheelchairAccessVehicles=" + wheelchairAccessVehicles +
                ", transferAccessVehicle=" + transferAccessVehicle +
                ", transferDevices=" + transferDevices +
                ", serviceAnimalRestrictions_Ride=" + serviceAnimalRestrictions_Ride +
                ", serviceAnimalRestrictions_Board=" + serviceAnimalRestrictions_Board +
                ", assistiveListening=" + assistiveListening +
                ", audioDescription=" + audioDescription +
                ", handheldCaptioning=" + handheldCaptioning +
                ", signLanguage=" + signLanguage +
                ", videoCaptioning=" + videoCaptioning +
                ", sensoryExperience=" + sensoryExperience +
                ", attraction=" + attraction +
                '}';
    }
}
