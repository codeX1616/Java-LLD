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

    ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b) -> b-a);
    }

    /**
     * Method to submit external request
     * @param floor {@link Integer}
     * @param direction {@link Direction}
     */
    public void submitExternalRequest(Integer floor, Direction direction) {
        if(direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
    }

    /**
     * Method to submit internal request
     * @param floor {@link Integer}
     */
    public void submitInternalRequest(Integer floor){
        // Submit internal request
    }

    /**
     * Method to control elevator
     */
    public void controlElevator(){
        Boolean condition = true;
        while(condition) {
            if(elevatorCar.getElevatorDirection() == Direction.UP){
                // Logic to move elevator up, break the loop once the floor is reached!
                condition = false;
            }
        }
    }

}
