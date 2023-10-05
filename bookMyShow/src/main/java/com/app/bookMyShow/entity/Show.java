package com.app.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Show {
    Long showId;
    Movie movie;
    Screen screen;
    Long showStartTime;
    List<Integer> bookedSeatIds = new ArrayList<>();

}
