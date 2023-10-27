package com.lld.elevator.controller;

import com.lld.elevator.entities.ElevatorCar;
import lombok.Getter;

import java.util.List;

@Getter
public class ElevatorCreator {

    public static List<ElevatorController> elevatorControllerList;

    static {
        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.setId(1);
        ElevatorController controller1 = new ElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar1.setId(2);
        ElevatorController controller2 = new ElevatorController(elevatorCar2);

        elevatorControllerList.add(controller1);
        elevatorControllerList.add(controller2);
    }

}