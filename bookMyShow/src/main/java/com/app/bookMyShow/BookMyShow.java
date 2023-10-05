package com.app.bookMyShow;

import com.app.bookMyShow.controller.MovieController;
import com.app.bookMyShow.controller.TheatreController;
import com.app.bookMyShow.entity.Movie;
import com.app.bookMyShow.entity.Screen;
import com.app.bookMyShow.entity.Seat;
import com.app.bookMyShow.entity.Show;
import com.app.bookMyShow.entity.Theatre;
import com.app.bookMyShow.entity.enums.City;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {

    private MovieController movieController;
    private TheatreController theatreController;

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

    private void createTheatre() {
        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubali = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreen(createScreen());
        inoxTheatre.setCity(City.Bangalore);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1L, inoxTheatre.getScreen().get(0), avengerMovie, 8L);
        Show inoxEveningShow = createShows(2L, inoxTheatre.getScreen().get(0), baahubali, 16L);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreen(createScreen());
        pvrTheatre.setCity(City.Delhi);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3L, pvrTheatre.getScreen().get(0), avengerMovie, 13L);
        Show pvrEveningShow = createShows(4L, pvrTheatre.getScreen().get(0), baahubali, 20L);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.Bangalore);
        theatreController.addTheatre(pvrTheatre, City.Delhi);

    }

    private Show createShows(Long showId, Screen screen, Movie movie, Long showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;

    }

    private void createMovies() {
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setMovieDuration(128);

        //create Movies2
        Movie baahubali = new Movie();
        baahubali.setMovieId(2);
        baahubali.setMovieName("BAAHUBALI");
        baahubali.setMovieDuration(180);


        //add movies against the cities
        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(avengers, City.Delhi);
        movieController.addMovie(baahubali, City.Bangalore);
        movieController.addMovie(baahubali, City.Delhi);

    }

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
