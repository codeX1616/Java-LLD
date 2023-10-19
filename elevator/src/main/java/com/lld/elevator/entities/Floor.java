package com.lld.elevator.entities;

public class Floor {

    private Integer floorNumber;
    private ExternalDispatcher externalDispatcher;

    public Floor(Integer floorNumber) {
        this.floorNumber = floorNumber;
        this.externalDispatcher = new ExternalDispatcher();
    }

    public void pressButton(Direction direction) {
        externalDispatcher.submitExternalRequest(floorNumber, direction);
    }

}
