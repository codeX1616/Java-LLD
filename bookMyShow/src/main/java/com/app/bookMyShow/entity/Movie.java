package com.app.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    int movieId;
    String movieName;
    int movieDurationInMinutes;

    public void setMovieDuration(int i) {

    }
}
