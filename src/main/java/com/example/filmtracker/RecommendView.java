package com.example.filmtracker;

import javafx.scene.control.ListView;

import java.util.ArrayList;

public class RecommendView extends ListView<String> {
    public RecommendView() {
        currentCollection = filterCollection(Collection.collection);
        updateView();
    }
    int rating = 1;
    String genre = "";
    ArrayList<Movie> currentCollection;

    public ArrayList<Movie> filterCollection(ArrayList<Movie> collection) {
        ArrayList<Movie> filteredCollection = new ArrayList<Movie>();
        for (int i = 0; i < collection.size(); i++) {
            if (!collection.get(i).getRecommendToFriend()) {
                continue;
            }
            if (collection.get(i).getRating() < getRating()) {
                continue;
            }
            if (!(collection.get(i).getGenre().equals(getGenre()) || getGenre().isEmpty())) {
                continue;
            }
            filteredCollection.add(collection.get(i));
        }
        return filteredCollection;
    }

    public void setGenre(String g) {
        genre = g;
    }

    public String getGenre() {
        return genre;
    }

    public void setRating(int r) {
        rating = r;
    }

    public int getRating() {
        return rating;
    }

    public void updateView() {
        getItems().clear();
        if (currentCollection.isEmpty()) {
            return;
        }
        for (int i = 0; i < currentCollection.size(); i++) {
            String movieEntry = currentCollection.get(i).getID() + ": " + currentCollection.get(i).getName()
                    + " (" + currentCollection.get(i).getYear() + ")";
            getItems().add(movieEntry);
        }
    }
}
