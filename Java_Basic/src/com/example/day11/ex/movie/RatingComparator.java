package com.example.day11.ex.movie;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return (int) (o1.getRate() * 10 - o2.getRate() * 10);
    }
}
