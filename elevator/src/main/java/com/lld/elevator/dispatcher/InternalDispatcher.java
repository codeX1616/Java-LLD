package com.lld.elevator.dispatcher;

import com.lld.elevator.controller.ElevatorController;
import com.lld.elevator.controller.ElevatorCreator;
import com.lld.elevator.entities.ElevatorCar;

import java.util.List;

public class InternalDispatcher {

    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    /**
     * Method to submit internal request
     * @param destination {@link Integer}
     * @param elevatorCar {@link ElevatorCar}
     */
    public void submitInternalRequest(Integer destination, ElevatorCar elevatorCar) {
        // Add logic for submitting internal request
    }

}
