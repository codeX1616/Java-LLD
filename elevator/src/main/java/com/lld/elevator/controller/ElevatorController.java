package com.lld.elevator.controller;

import com.lld.elevator.entities.Direction;
import com.lld.elevator.entities.ElevatorCar;
import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;

@Getter
@Setter
public class ElevatorController {

    private PriorityQueue<Integer> upMinPQ;
    private PriorityQueue<Integer> downMaxPQ;
    private ElevatorCar elevatorCar;

    public void submitExternalRequest(Integer floor, Direction direction) {
        if(direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
    }

    public void submitInternalRequest(int floor){
        // Submit internal request
    }

    public void controlElevator(){
        while(true) {
            if(elevatorCar.getElevatorDirection() == Direction.UP){
                // Logic to move elevator up, break the loop once the floor is reached!
            }
        }
    }

}
