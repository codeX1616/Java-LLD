package com.lld.elevator.dispatcher;

import com.lld.elevator.controller.ElevatorController;
import com.lld.elevator.controller.ElevatorCreator;
import com.lld.elevator.entities.Direction;

import java.util.List;

public class ExternalDispatcher {

    private final List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(Integer floor, Direction direction) {
        for(ElevatorController elevatorController : elevatorControllerList) {

            Integer elevatorID = elevatorController.getElevatorCar().getId();
            if (elevatorID % 2 == 1 && floor % 2 == 1){
                elevatorController.submitExternalRequest(floor,direction);
            } else if(elevatorID % 2 == 0 && floor % 2 == 0){
                elevatorController.submitExternalRequest(floor,direction);

            }
        }   

    }

}
