package com.lld.elevator.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElevatorCar {
    private Integer id;
    private ElevatorDisplay display;
    private InternalButtons internalButtons;
    private ElevatorState elevatorState;
    private int currentFloor;
    private Direction elevatorDirection;
    private ElevatorDoor elevatorDoor;
}
