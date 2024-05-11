package org.example.model.attractionaccessibilityattributes;

import jakarta.persistence.Embeddable;


@Embeddable
public class MustTransfer {
    private boolean mayRemainInWheelchairEcv;
    private boolean mustBeAmbulatory;
    private boolean mustTransferFromWheelchairEcv;
    private boolean mustTransferToWheelchair;
    private boolean mustTransferToWheelchairThenToRide;


    public MustTransfer() {
    }

    public MustTransfer(boolean mayRemainInWheelchairEcv, boolean mustBeAmbulatory, boolean mustTransferFromWheelchairEcv, boolean mustTransferToWheelchair, boolean mustTransferToWheelchairThenToRide) {
        this.mayRemainInWheelchairEcv = mayRemainInWheelchairEcv;
        this.mustBeAmbulatory = mustBeAmbulatory;
        this.mustTransferFromWheelchairEcv = mustTransferFromWheelchairEcv;
        this.mustTransferToWheelchair = mustTransferToWheelchair;
        this.mustTransferToWheelchairThenToRide = mustTransferToWheelchairThenToRide;
    }


    public boolean getMayRemainInWheelchairEcv() {
        return mayRemainInWheelchairEcv;
    }

    public void setMayRemainInWheelchairEcv(boolean mayRemainInWheelchairEcv) {
        this.mayRemainInWheelchairEcv = mayRemainInWheelchairEcv;
    }

    public boolean getMustBeAmbulatory() {
        return mustBeAmbulatory;
    }

    public void setMustBeAmbulatory(boolean mustBeAmbulatory) {
        this.mustBeAmbulatory = mustBeAmbulatory;
    }

    public boolean getMustTransferFromWheelchairEcv() {
        return mustTransferFromWheelchairEcv;
    }

    public void setMustTransferFromWheelchairEcv(boolean mustTransferFromWheelchairEcv) {
        this.mustTransferFromWheelchairEcv = mustTransferFromWheelchairEcv;
    }

    public boolean getMustTransferToWheelchair() {
        return mustTransferToWheelchair;
    }

    public void setMustTransferToWheelchair(boolean mustTransferToWheelchair) {
        this.mustTransferToWheelchair = mustTransferToWheelchair;
    }

    public boolean getMustTransferToWheelchairThenToRide() {
        return mustTransferToWheelchairThenToRide;
    }

    public void setMustTransferToWheelchairThenToRide(boolean mustTransferToWheelchairThenToRide) {
        this.mustTransferToWheelchairThenToRide = mustTransferToWheelchairThenToRide;
    }


    @Override
    public String toString() {
        return "MustTransfer{" +
                "mayRemainInWheelchairEcv=" + mayRemainInWheelchairEcv +
                ", mustBeAmbulatory=" + mustBeAmbulatory +
                ", mustTransferFromWheelchairEcv=" + mustTransferFromWheelchairEcv +
                ", mustTransferToWheelchair=" + mustTransferToWheelchair +
                ", mustTransferToWheelchairThenToRide=" + mustTransferToWheelchairThenToRide +
                '}';
    }
}
