package com.example.filmtracker;

public class Movie {
    private int ID = -1;
    private String name;
    private String author;
    private int year;
    private String genre;
    private int rating;
    private String comments;

    public Movie(String name, String author, int year, String genre, int rating, String comments) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.comments = comments;
    }

    public int getID() {
        return ID;
    }

    public void setID(int newID) {
        ID = newID;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public void setYear(int newYear) {
        year = newYear;
    }

    public void setGenre(String newGenre) {
        genre = newGenre;
    }

    public void setRating(int newRating) {
        rating = newRating;
    }
}