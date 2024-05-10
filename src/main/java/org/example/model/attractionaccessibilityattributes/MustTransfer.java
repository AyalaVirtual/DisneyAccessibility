package org.example.model.attractionaccessibilityattributes;

import jakarta.persistence.Embeddable;


@Embeddable
public class MustTransfer {
    private boolean mayRemainInWheelChairEcv;
    private boolean mustBeAmbulatory;
    private boolean mustTransferFromWheelchairEcv;
    private boolean mustTransferToWheelchair;
    private boolean mustTransferToWheelchairThenToRide;


    public MustTransfer() {
    }

    public MustTransfer(boolean mayRemainInWheelChairEcv, boolean mustBeAmbulatory, boolean mustTransferFromWheelchairEcv, boolean mustTransferToWheelchair, boolean mustTransferToWheelchairThenToRide) {
        this.mayRemainInWheelChairEcv = mayRemainInWheelChairEcv;
        this.mustBeAmbulatory = mustBeAmbulatory;
        this.mustTransferFromWheelchairEcv = mustTransferFromWheelchairEcv;
        this.mustTransferToWheelchair = mustTransferToWheelchair;
        this.mustTransferToWheelchairThenToRide = mustTransferToWheelchairThenToRide;
    }


    public boolean isMayRemainInWheelChairEcv() {
        return mayRemainInWheelChairEcv;
    }

    public void setMayRemainInWheelChairEcv(boolean mayRemainInWheelChairEcv) {
        this.mayRemainInWheelChairEcv = mayRemainInWheelChairEcv;
    }

    public boolean isMustBeAmbulatory() {
        return mustBeAmbulatory;
    }

    public void setMustBeAmbulatory(boolean mustBeAmbulatory) {
        this.mustBeAmbulatory = mustBeAmbulatory;
    }

    public boolean isMustTransferFromWheelchairEcv() {
        return mustTransferFromWheelchairEcv;
    }

    public void setMustTransferFromWheelchairEcv(boolean mustTransferFromWheelchairEcv) {
        this.mustTransferFromWheelchairEcv = mustTransferFromWheelchairEcv;
    }

    public boolean isMustTransferToWheelchair() {
        return mustTransferToWheelchair;
    }

    public void setMustTransferToWheelchair(boolean mustTransferToWheelchair) {
        this.mustTransferToWheelchair = mustTransferToWheelchair;
    }

    public boolean isMustTransferToWheelchairThenToRide() {
        return mustTransferToWheelchairThenToRide;
    }

    public void setMustTransferToWheelchairThenToRide(boolean mustTransferToWheelchairThenToRide) {
        this.mustTransferToWheelchairThenToRide = mustTransferToWheelchairThenToRide;
    }


    @Override
    public String toString() {
        return "MustTransfer{" +
                "mayRemainInWheelChairEcv=" + mayRemainInWheelChairEcv +
                ", mustBeAmbulatory=" + mustBeAmbulatory +
                ", mustTransferFromWheelchairEcv=" + mustTransferFromWheelchairEcv +
                ", mustTransferToWheelchair=" + mustTransferToWheelchair +
                ", mustTransferToWheelchairThenToRide=" + mustTransferToWheelchairThenToRide +
                '}';
    }
}
