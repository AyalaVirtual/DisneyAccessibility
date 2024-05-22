package org.example.model.attractionaccessibilityattributes;

import jakarta.persistence.Embeddable;


@Embeddable
public class ServiceAnimalRestrictions {
    private boolean serviceAnimalRideRestrictions;
    private boolean serviceAnimalBoardingRestrictions;


    public ServiceAnimalRestrictions() {
    }

    public ServiceAnimalRestrictions(boolean rideRestrictions, boolean boardRestrictions) {
        this.serviceAnimalRideRestrictions = rideRestrictions;
        this.serviceAnimalBoardingRestrictions = boardRestrictions;
    }

    public boolean getServiceAnimalRideRestrictions() {
        return serviceAnimalRideRestrictions;
    }

    public void setServiceAnimalRideRestrictions(boolean serviceAnimalRideRestrictions) {
        this.serviceAnimalRideRestrictions = serviceAnimalRideRestrictions;
    }

    public boolean getServiceAnimalBoardingRestrictions() {
        return serviceAnimalBoardingRestrictions;
    }

    public void setServiceAnimalBoardingRestrictions(boolean serviceAnimalBoardingRestrictions) {
        this.serviceAnimalBoardingRestrictions = serviceAnimalBoardingRestrictions;
    }

    @Override
    public String toString() {
        return "ServiceAnimalRestrictions{" +
                "rideRestrictions=" + serviceAnimalRideRestrictions +
                ", boardRestrictions=" + serviceAnimalBoardingRestrictions +
                '}';
    }
}
