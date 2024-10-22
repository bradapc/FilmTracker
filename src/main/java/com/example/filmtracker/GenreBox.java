package com.example.filmtracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class GenreBox extends ComboBox<String> {
    private static final ObservableList<String> genres =
            FXCollections.observableArrayList(
                    "Horror",
                    "Thriller",
                    "Comedy",
                    "Drama",
                    "Fantasy",
                    "Action",
                    "Adventure",
                    "All");
    public GenreBox() {
        super(genres);
    }

    public void setCurrentGenre(String genre) {
        this.setValue(genre);
    }
}
