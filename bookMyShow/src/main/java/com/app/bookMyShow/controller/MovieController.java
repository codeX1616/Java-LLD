package com.app.bookMyShow.controller;

import com.app.bookMyShow.entity.Movie;
import com.app.bookMyShow.entity.enums.City;

import java.util.ArrayList;
import java.util.List;

public class MovieController {

    public Movie getMovieByName(String movieName) {
        // TODO - add logic to get movie by name
        return null;
    }

    public void addMovie(Movie movie, City city) {
        // TODO - Add logic to add movie
    }

    public List<Movie> getMoviesByCity(City userCity) {
        // TODO - Add logic to get movies by city
        return new ArrayList<>();
    }
}
