package com.lld.elevator.dispatcher;

import com.lld.elevator.controller.ElevatorController;
import com.lld.elevator.controller.ElevatorCreator;
import com.lld.elevator.entities.ElevatorCar;

import java.util.List;

public class InternalDispatcher {

    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitInternalRequest(Integer destination, ElevatorCar elevatorCar) {
        // Add logic for submitting internal request
    }

}
