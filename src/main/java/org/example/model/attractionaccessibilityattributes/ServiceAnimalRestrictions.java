package org.example.model.attractionaccessibilityattributes;

import jakarta.persistence.Embeddable;


@Embeddable
public class ServiceAnimalRestrictions {
    private boolean rideRestrictions;
    private boolean boardRestrictions;


    public ServiceAnimalRestrictions() {
    }

    public ServiceAnimalRestrictions(boolean rideRestrictions, boolean boardRestrictions) {
        this.rideRestrictions = rideRestrictions;
        this.boardRestrictions = boardRestrictions;
    }

    public boolean getRideRestrictions() {
        return rideRestrictions;
    }

    public void setRideRestrictions(boolean rideRestrictions) {
        this.rideRestrictions = rideRestrictions;
    }

    public boolean getBoardRestrictions() {
        return boardRestrictions;
    }

    public void setBoardRestrictions(boolean boardRestrictions) {
        this.boardRestrictions = boardRestrictions;
    }

    @Override
    public String toString() {
        return "ServiceAnimalRestrictions{" +
                "rideRestrictions=" + rideRestrictions +
                ", boardRestrictions=" + boardRestrictions +
                '}';
    }
}
