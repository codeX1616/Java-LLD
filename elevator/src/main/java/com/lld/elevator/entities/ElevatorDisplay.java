package com.lld.elevator.entities;

public class ElevatorDisplay {
    int floor;
    Direction direction;

    /**
     * Method to set display
     * @param floor {@link Floor}
     * @param direction {@link Direction}
     */
    public void setDisplay(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public void showDisplay(){
        System.out.println(floor);
        System.out.println(direction);
    }
}
