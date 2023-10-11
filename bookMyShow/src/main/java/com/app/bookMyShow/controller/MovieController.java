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

    /**
     * Method to get movie by name
     * @param movieName {@link String}
     * @return {@link Movie}
     */
    public Movie getMovieByName(String movieName) {
        for(Movie movie : allMovies) {
            if((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Method to add movie details
     * @param movie {@link Movie}
     * @param city {@link City}
     */
    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    /**
     * Method to get movies by city
     * @param city {@link City}
     * @return {@link List<Movie>}
     */
    public List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.get(city);
    }
}
