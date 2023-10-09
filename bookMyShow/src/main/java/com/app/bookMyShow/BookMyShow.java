package com.app.bookMyShow;

import com.app.bookMyShow.controller.MovieController;
import com.app.bookMyShow.controller.TheatreController;
import com.app.bookMyShow.entity.*;
import com.app.bookMyShow.entity.enums.City;
import com.app.bookMyShow.entity.enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    private MovieController movieController;
    private TheatreController theatreController;

    public static void main(String args[]) {
        BookMyShow bms = new BookMyShow();
        bms.initialize();

        bms.createBooking(City.Bangalore, "Bahubali");
        bms.createBooking(City.Delhi, "OMG2");
    }

    /**
     * Method to create booking
     * @param userCity {@link City}
     * @param movieName {@link String}
     */
    private void createBooking(City userCity, String movieName) {
        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        //2. select the movie to watch.
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

    /**
     * Method to initialize book my show application
     */
    private void initialize() {
        createMovies();
        createTheatre();
    }

    /**
     * Method to create a theatre
     */
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

    /**
     * Method to create movie shows
     * @param showId {@link Long}
     * @param screen {@link Screen}
     * @param movie {@link Movie}
     * @param showStartTime {@link Long}
     * @return
     */
    private Show createShows(Long showId, Screen screen, Movie movie, Long showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;

    }

    /**
     * Method to create movies
     */
    private void createMovies() {
        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieName("AVENGERS");
        movie.setMovieDurationInMinutes(128);

        Movie baahubali = new Movie();
        baahubali.setMovieId(2);
        baahubali.setMovieName("BAAHUBALI");
        baahubali.setMovieDurationInMinutes(180);

        movieController.addMovie(movie, City.Bangalore);
        movieController.addMovie(movie, City.Delhi);
        movieController.addMovie(baahubali, City.Bangalore);
        movieController.addMovie(baahubali, City.Delhi);

    }

    /**
     * Method to create screen
     * @return {@link List<Screen>}
     */
    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    /**
     * Method to create seats
     * @return {@link List<Seat>}
     */
    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId((long) i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId((long) i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId((long) i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;

    }


}
