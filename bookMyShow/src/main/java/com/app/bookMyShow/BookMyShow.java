package com.app.bookMyShow;

import com.app.bookMyShow.entity.City;

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

}
