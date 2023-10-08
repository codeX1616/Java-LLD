package com.app.bookMyShow.entity;

import com.app.bookMyShow.entity.enums.SeatCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    Long seatId;
    int row;
    SeatCategory seatCategory;
}
