package com.example.day11.ex.movie;

import java.util.Comparator;

public class ReleaseYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getYear() - o2.getYear();
    }
}
