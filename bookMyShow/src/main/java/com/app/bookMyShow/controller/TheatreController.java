package com.app.bookMyShow.controller;

import com.app.bookMyShow.entity.Movie;
import com.app.bookMyShow.entity.Show;
import com.app.bookMyShow.entity.Theatre;
import com.app.bookMyShow.entity.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatre;

    /**
     * Method to add theatre details
     * @param theatre {@link Theatre}
     * @param city {@link City}
     */
    public void addTheatre(Theatre theatre, City city) {
        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    /**
     * Method to get all show details
     * @param movie {@link Movie}
     * @param city {@link City}
     * @return {@link Map}
     */
    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityVsTheatre.get(city);

        for(Theatre theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for(Show show : shows) {
                if(show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;

    }
}
