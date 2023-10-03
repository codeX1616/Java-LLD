package com.app.bookMyShow;

import com.app.bookMyShow.entity.enums.City;
import com.app.bookMyShow.entity.Screen;
import com.app.bookMyShow.entity.Seat;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
    
    public static void main(String args[]) {
        BookMyShow bms = new BookMyShow();
        bms.initialize();

        bms.createBooking(City.Bangalore, "Bahubali");
        bms.createBooking(City.Delhi, "OMG2");
    }

    private void createBooking(City city, String movie) {
        // TODO - add logic to create movie booking for a city
    }

    private void initialize() {
        createMovies();
        createTheatre();
    }

    private void createTheatre() {}

    private void createMovies() {}

    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    private List<Seat> createSeats() {
        // TODO - Add logic to create seats
        return null;
    }


}
