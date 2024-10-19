package com.example.filmtracker;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class Collection {

    static ArrayList<Movie> collection = new ArrayList<Movie>();

    public static ListView<String> collectionListView;
    public static Label collectionListLabel;

    public static void updateCollectionDisplay() {
        collectionListView.getItems().clear();
        for (int i = 0; i < collection.size(); i++) {
            String movieEntry = collection.get(i).getID() + ": " + collection.get(i).getName()
                    + " (" + collection.get(i).getYear() + ")";
            collectionListView.getItems().add(movieEntry);
        }
        collectionListLabel.setText("Film Collection (" + Collection.getCollectionSize() + " films)");
    }

    public static Movie getMovieByID(int id) {
        Movie movie = null;
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getID() == id) {
                movie = collection.get(i);
            }
        }
        return movie;
    }

    public static boolean isValidMovieEntries(String name, String author, int year, String genre, int rating) {
        if (name.length() < 3) return false;
        if (author.length() < 3) return false;
        if (year < 1900) return false;
        //add genre validation
        if (rating < 0 || rating > 5) return false;
        return true;
    }

    public static void updateMovieInfo(int movieID, String name, String author, int year, String genre, int rating) {
        Movie m = getMovieByID(movieID);
        m.setName(name);
        m.setAuthor(author);
        m.setYear(year);
        m.setGenre(genre);
        m.setRating(rating);
        updateCollectionDisplay();
    }

    static void updateMovieIDs() {
        for (int i = 0; i < collection.size(); i++) {
            collection.get(i).setID(i);
        }
    }

    public static void removeMovieByID(int id) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getID() == id) {
                collection.remove(i);
            }
        }
        updateMovieIDs();
        updateCollectionDisplay();
    }

    public static void addToCollection(Movie m)
    {
        m.setID(collection.size());
        collection.add(m);
        updateCollectionDisplay();
    }

    public static int getCollectionSize() {
        return collection.size();
    }

    public static ArrayList<Movie> getCollection() {
        return collection;
    }

}