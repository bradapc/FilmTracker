package com.example.filmtracker;

import javafx.scene.control.ListView;

import java.util.ArrayList;

public class RecommendView extends ListView<String> {
    public RecommendView() {
        filterCollection();
        updateView();
    }
    int rating = 5;
    String genre = "All";
    ArrayList<Movie> currentCollection;

    public void filterCollection() {
        ArrayList<Movie> filteredCollection = new ArrayList<Movie>();
        for (int i = 0; i < Collection.collection.size(); i++) {
            if (!Collection.collection.get(i).getRecommendToFriend()) {
                continue;
            }
            if (Collection.collection.get(i).getRating() < getRating()) {
                continue;
            }
            if (!(Collection.collection.get(i).getGenre().equals(getGenre()) || getGenre().equals("All"))) {
                continue;
            }
            filteredCollection.add(Collection.collection.get(i));
        }
        currentCollection = filteredCollection;
        updateView();
    }

    public void setGenre(String g) {
        genre = g;
        filterCollection();
    }

    public String getGenre() {
        return genre;
    }

    public void setRating(int r) {
        rating = r;
        filterCollection();
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
