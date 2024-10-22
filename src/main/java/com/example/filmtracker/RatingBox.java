package com.example.filmtracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class RatingBox extends ComboBox<String> {
    private final static ObservableList<String> ratings =
            FXCollections.observableArrayList(
                    "★",
                    "★★",
                    "★★★",
                    "★★★★",
                    "★★★★★");
    public RatingBox() {
        super(ratings);
    }

    public int getIntRating() {
        return getValue().length();
    }

    public void setCurrentRating(int rating) {
        String s = "";
        for (int i = 0; i < rating; i++) {
            s += "★";
        }
        setValue(s);
    }
    public String getCurrentRating(int rating) {
        String s = "";
        for (int i = 0; i < rating; i++) {
            s += "★";
        }
        return s;
    }
}
