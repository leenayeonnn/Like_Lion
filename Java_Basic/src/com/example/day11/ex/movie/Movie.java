package com.example.day11.ex.movie;

public class Movie implements Comparable<Movie> {
    private String name;
    private int year;
    private double rate;

    public Movie(String name, int year, double rate) {
        this.name = name;
        this.year = year;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", year=" + year +
                ", rate=" + rate;
    }

    @Override
    public int compareTo(Movie o) {
        return this.name.compareTo(o.name);
    }
}
