package com.lld.elevator.entities;

import com.lld.elevator.dispatcher.ExternalDispatcher;

public class Floor {

    private final Integer floorNumber;
    private final ExternalDispatcher externalDispatcher;

    public Floor(Integer floorNumber) {
        this.floorNumber = floorNumber;
        this.externalDispatcher = new ExternalDispatcher();
    }

    /**
     * Method to perform action on pressing floor button
     * @param direction {@link Direction}
     */
    public void pressButton(Direction direction) {
        externalDispatcher.submitExternalRequest(floorNumber, direction);
    }

}
