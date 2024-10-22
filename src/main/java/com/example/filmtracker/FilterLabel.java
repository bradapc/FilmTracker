package com.example.filmtracker;

import javafx.scene.control.Label;

public class FilterLabel extends Label {

    public void update(String genre, String rating) {
        setText("Showing " + genre + " movies with " + rating + " or more stars");
    }
}
