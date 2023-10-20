package com.lld.elevator.entities;

import com.lld.elevator.controller.ElevatorController;

import java.util.List;

public class ExternalDispatcher {

    private List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(Integer floor, Direction direction) {
        for(ElevatorController elevatorController : elevatorControllerList) {

            int elevatorID = elevatorController.getElevatorCar().getId();
            if (elevatorID%2==1 && floor%2==1){
                elevatorController.submitExternalRequest(floor,direction);
            } else if(elevatorID%2==0 && floor%2==0){
                elevatorController.submitExternalRequest(floor,direction);

            }
        }

    }

}
