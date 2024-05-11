package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "mayRemainInWheelchairEcv", column = @Column(name = "may_remain_in_wheelchair_ecv")),
            @AttributeOverride(name = "mustBeAmbulatory", column = @Column(name = "must_be_ambulatory")),
            @AttributeOverride(name = "mustTransferFromWheelchairEcv", column = @Column(name = "must_transfer_from_wheelchair_ecv")),
            @AttributeOverride(name = "mustTransferToWheelchair", column = @Column(name = "must_transfer_to_wheelchair")),
            @AttributeOverride(name = "mustTransferToWheelchairThenToRide", column = @Column(name = "must_transfer_to_wheelchair_then_to_ride"))
    })
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "scentSmell", column = @Column(name = "scent_smell")),
            @AttributeOverride(name = "lightingEffects", column = @Column(name = "lighting_effects")),
            @AttributeOverride(name = "loudNoises", column = @Column(name = "loud_noises")),
            @AttributeOverride(name = "periodsOfDarkness", column = @Column(name = "periods_of_darkness")),
            @AttributeOverride(name = "bumpy", column = @Column(name = "bumpy")),
            @AttributeOverride(name = "fast", column = @Column(name = "fast")),
            @AttributeOverride(name = "liftsOffGround", column = @Column(name = "lifts_off_ground")),
            @AttributeOverride(name = "wet", column = @Column(name = "wet")),
            @AttributeOverride(name = "elementOfSurprise", column = @Column(name = "element_of_surprise")),
            @AttributeOverride(name = "typeOfRestraint", column = @Column(name = "type_of_restraint")),
            @AttributeOverride(name = "tripTime", column = @Column(name = "trip_time"))
    })
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

    public boolean hasLoadUnloadAreas() {
        return loadUnloadAreas;
    }

    public void setLoadUnloadAreas(boolean loadUnloadAreas) {
        this.loadUnloadAreas = loadUnloadAreas;
    }

    public boolean hasWheelchairAccessVehicles() {
        return wheelchairAccessVehicles;
    }

    public void setWheelchairAccessVehicles(boolean wheelchairAccessVehicles) {
        this.wheelchairAccessVehicles = wheelchairAccessVehicles;
    }

    public boolean hasTransferAccessVehicle() {
        return transferAccessVehicle;
    }

    public void setTransferAccessVehicle(boolean transferAccessVehicle) {
        this.transferAccessVehicle = transferAccessVehicle;
    }

    public boolean hasTransferDevices() {
        return transferDevices;
    }

    public void setTransferDevices(boolean transferDevices) {
        this.transferDevices = transferDevices;
    }

    public boolean hasServiceAnimalRestrictions_Ride() {
        return serviceAnimalRestrictions_Ride;
    }

    public void setServiceAnimalRestrictions_Ride(boolean serviceAnimalRestrictions_Ride) {
        this.serviceAnimalRestrictions_Ride = serviceAnimalRestrictions_Ride;
    }

    public boolean hasServiceAnimalRestrictions_Board() {
        return serviceAnimalRestrictions_Board;
    }

    public void setServiceAnimalRestrictions_Board(boolean serviceAnimalRestrictions_Board) {
        this.serviceAnimalRestrictions_Board = serviceAnimalRestrictions_Board;
    }

    public boolean hasAssistiveListening() {
        return assistiveListening;
    }

    public void setAssistiveListening(boolean assistiveListening) {
        this.assistiveListening = assistiveListening;
    }

    public boolean hasAudioDescription() {
        return audioDescription;
    }

    public void setAudioDescription(boolean audioDescription) {
        this.audioDescription = audioDescription;
    }

    public boolean hasHandheldCaptioning() {
        return handheldCaptioning;
    }

    public void setHandheldCaptioning(boolean handheldCaptioning) {
        this.handheldCaptioning = handheldCaptioning;
    }

    public boolean hasSignLanguage() {
        return signLanguage;
    }

    public void setSignLanguage(boolean signLanguage) {
        this.signLanguage = signLanguage;
    }

    public boolean hasVideoCaptioning() {
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
