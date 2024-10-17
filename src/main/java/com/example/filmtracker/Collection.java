package com.example.filmtracker;

import javafx.scene.control.ListView;

import java.util.ArrayList;

public class Collection {

    static ArrayList<Movie> collection = new ArrayList<Movie>();

    public static ListView<String> collectionListView;

    public static void updateListView() {
        collectionListView.getItems().clear();
        for (int i = 0; i < collection.size(); i++) {
            String movieEntry = collection.get(i).getID() + ": " + collection.get(i).getName()
                    + " (" + collection.get(i).getYear() + ")";
            collectionListView.getItems().add(movieEntry);
        }
    }

    public static void addToCollection(Movie m) {
        collection.add(m);
    }

    public static ArrayList<Movie> getCollection() {
        return collection;
    }

}