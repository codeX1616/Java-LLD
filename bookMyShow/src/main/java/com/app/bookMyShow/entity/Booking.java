package com.app.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Booking {
    private Show show;
    private List<Seat> bookedSeats = new ArrayList<>();
    private Payment payment;
}
