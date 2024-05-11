package org.example.model.attractionaccessibilityattributes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class TransferAssistance {
    private boolean loadUnloadAreas;
    private boolean wheelchairAccessVehicles;
    private boolean transferAccessVehicle;
    private boolean transferDevices;


    public TransferAssistance() {
    }

    public TransferAssistance(boolean loadUnloadAreas, boolean wheelchairAccessVehicles, boolean transferAccessVehicle, boolean transferDevices) {
        this.loadUnloadAreas = loadUnloadAreas;
        this.wheelchairAccessVehicles = wheelchairAccessVehicles;
        this.transferAccessVehicle = transferAccessVehicle;
        this.transferDevices = transferDevices;
    }


    public boolean getLoadUnloadAreas() {
        return loadUnloadAreas;
    }

    public void setLoadUnloadAreas(boolean loadUnloadAreas) {
        this.loadUnloadAreas = loadUnloadAreas;
    }

    public boolean getWheelchairAccessVehicles() {
        return wheelchairAccessVehicles;
    }

    public void setWheelchairAccessVehicles(boolean wheelchairAccessVehicles) {
        this.wheelchairAccessVehicles = wheelchairAccessVehicles;
    }

    public boolean getTransferAccessVehicle() {
        return transferAccessVehicle;
    }

    public void setTransferAccessVehicle(boolean transferAccessVehicle) {
        this.transferAccessVehicle = transferAccessVehicle;
    }

    public boolean getTransferDevices() {
        return transferDevices;
    }

    public void setTransferDevices(boolean transferDevices) {
        this.transferDevices = transferDevices;
    }


    @Override
    public String toString() {
        return "TransferAssistance{" +
                "loadUnloadAreas=" + loadUnloadAreas +
                ", wheelchairAccessVehicles=" + wheelchairAccessVehicles +
                ", transferAccessVehicle=" + transferAccessVehicle +
                ", transferDevices=" + transferDevices +
                '}';
    }
}
