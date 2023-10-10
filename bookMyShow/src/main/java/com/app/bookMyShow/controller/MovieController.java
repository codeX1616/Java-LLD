package com.app.bookMyShow.controller;

import com.app.bookMyShow.entity.Movie;
import com.app.bookMyShow.entity.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;

    MovieController(){
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }


    public Movie getMovieByName(String movieName) {
        for(Movie movie : allMovies) {
            if((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;

    }

    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    public List<Movie> getMoviesByCity(City userCity) {
        // TODO - Add logic to get movies by city
        return new ArrayList<>();
    }
}
