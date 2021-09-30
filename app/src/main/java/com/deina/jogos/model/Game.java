package com.deina.jogos.model;

public class Game {

    private String name;
    private String publisher;
    private String genre;
    private int year;

    public Game() {
    }

    public Game(String name, String publisher, String genre, int year) {
        this.name = name;
        this.publisher = publisher;
        this.genre = genre;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
