package com.lld.elevator.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Building {

    private List<Floor> floorList;

    /**
     * Method to add floors
     * @param newFloor {@link Floor}
     */
    public void addFloors(Floor newFloor) {
        floorList.add(newFloor);
    }

    /**
     * Method to remove floors
     * @param removeFloor {@link Floor}
     */
    public void removeFloors(Floor removeFloor) {
        floorList.remove(removeFloor);
    }

    /**
     * Method to get Floor list
     * @return {@link List<Floor>}
     */
    List<Floor> getAllFloorList() {
        return floorList;
    }

}
