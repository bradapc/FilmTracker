package com.example.filmtracker;

import javafx.scene.control.Button;

public class FilterButton extends Button {
    private static String filterMode = "ID";
    private static String direction = "descending";
    private String filterClass = "";
    private String filterDir = "descending";

    public FilterButton(String filterClass) {
        this.filterClass = filterClass;
    }

    public static String getFilterMode() {
        return filterMode;
    }

    public static String getDirection() {
        return direction;
    }

    public void updateFilterMode() {
        if (filterDir.equals("descending")) {
            filterDir = "ascending";
        } else {
            filterDir = "descending";
        }
        filterMode = filterClass;
        direction = filterDir;
        Collection.updateCollectionDisplay(Collection.collection);
    }
}
