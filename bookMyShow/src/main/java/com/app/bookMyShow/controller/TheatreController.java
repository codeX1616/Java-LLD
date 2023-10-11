package com.app.bookMyShow.controller;

import com.app.bookMyShow.entity.Movie;
import com.app.bookMyShow.entity.Show;
import com.app.bookMyShow.entity.Theatre;
import com.app.bookMyShow.entity.enums.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatre;

    public void addTheatre(Theatre theatre, City city) {
        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);

    }

    public Map<Theatre, List<Show>> getAllShow(Movie interestedMovie, City userCity) {
        // TODO - Add logic to get all show details
        return null;
    }
}
