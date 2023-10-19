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

    public void addFloors(Floor newFloor) {
        floorList.add(newFloor);
    }

    public void removeFloors(Floor removeFloor) {
        floorList.remove(removeFloor);
    }

    List<Floor> getAllFloorList() {
        return floorList;
    }

}
