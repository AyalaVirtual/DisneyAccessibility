package org.example.model.attractionaccessibilityattributes;

import jakarta.persistence.Embeddable;


@Embeddable
public class SensoryExperience {
    private boolean scentSmell;
    private boolean lightingEffects;
    private boolean loudNoises;
    private boolean periodsOfDarkness;
    private boolean bumpy;
    private boolean fast;
    private boolean liftsOffGround;
    private boolean wet;
    private String elementOfSurprise;
    private String typeOfRestraint;
    private String tripTime;


    public SensoryExperience(boolean scentSmell, boolean lightingEffects, boolean loudNoises, boolean periodsOfDarkness, boolean bumpy, boolean fast, boolean liftsOffGround, boolean wet, String elementOfSurprise, String typeOfRestraint, String tripTime) {
        this.scentSmell = scentSmell;
        this.lightingEffects = lightingEffects;
        this.loudNoises = loudNoises;
        this.periodsOfDarkness = periodsOfDarkness;
        this.bumpy = bumpy;
        this.fast = fast;
        this.liftsOffGround = liftsOffGround;
        this.wet = wet;
        this.elementOfSurprise = elementOfSurprise;
        this.typeOfRestraint = typeOfRestraint;
        this.tripTime = tripTime;
    }


    public boolean isScentSmell() {
        return scentSmell;
    }

    public void setScentSmell(boolean scentSmell) {
        this.scentSmell = scentSmell;
    }

    public boolean isLightingEffects() {
        return lightingEffects;
    }

    public void setLightingEffects(boolean lightingEffects) {
        this.lightingEffects = lightingEffects;
    }

    public boolean isLoudNoises() {
        return loudNoises;
    }

    public void setLoudNoises(boolean loudNoises) {
        this.loudNoises = loudNoises;
    }

    public boolean isPeriodsOfDarkness() {
        return periodsOfDarkness;
    }

    public void setPeriodsOfDarkness(boolean periodsOfDarkness) {
        this.periodsOfDarkness = periodsOfDarkness;
    }

    public boolean isBumpy() {
        return bumpy;
    }

    public void setBumpy(boolean bumpy) {
        this.bumpy = bumpy;
    }

    public boolean isFast() {
        return fast;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }

    public boolean isLiftsOffGround() {
        return liftsOffGround;
    }

    public void setLiftsOffGround(boolean liftsOffGround) {
        this.liftsOffGround = liftsOffGround;
    }

    public boolean isWet() {
        return wet;
    }

    public void setWet(boolean wet) {
        this.wet = wet;
    }

    public String getElementOfSurprise() {
        return elementOfSurprise;
    }

    public void setElementOfSurprise(String elementOfSurprise) {
        this.elementOfSurprise = elementOfSurprise;
    }

    public String getTypeOfRestraint() {
        return typeOfRestraint;
    }

    public void setTypeOfRestraint(String typeOfRestraint) {
        this.typeOfRestraint = typeOfRestraint;
    }

    public String getTripTime() {
        return tripTime;
    }

    public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }


    @Override
    public String toString() {
        return "SensoryExperience{" +
                "scentSmell=" + scentSmell +
                ", lightingEffects=" + lightingEffects +
                ", loudNoises=" + loudNoises +
                ", periodsOfDarkness=" + periodsOfDarkness +
                ", bumpy=" + bumpy +
                ", fast=" + fast +
                ", liftsOffGround=" + liftsOffGround +
                ", wet=" + wet +
                ", elementOfSurprise='" + elementOfSurprise + '\'' +
                ", typeOfRestraint='" + typeOfRestraint + '\'' +
                ", tripTime='" + tripTime + '\'' +
                '}';
    }
}
