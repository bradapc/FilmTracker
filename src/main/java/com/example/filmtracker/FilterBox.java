package com.example.filmtracker;

import javafx.scene.control.TextField;
import java.util.ArrayList;

/*
TO ADD:
-Allow filtering based on certain parameters. If no parameter specified, search by name.
If prefixing filter with d:, search by date
If prefixing filter with a:, search by author
etc.
 */

public class FilterBox extends TextField {
    String currentSearch = "";
    FilterBox() {
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            currentSearch = newValue.toLowerCase();
            updateCollectionBuffer(currentSearch);
        });
        this.getStyleClass().add("filter-box");
    }
    ArrayList<Movie> collectionBuffer = new ArrayList<Movie>();

    void updateCollectionBuffer(String currentSearch) {
        collectionBuffer.clear();
        for (int i = 0; i < Collection.collection.size(); i++) {
            if (Collection.collection.get(i).getName().toLowerCase().contains(currentSearch)) {
                collectionBuffer.add(Collection.collection.get(i));
            }
        }
        handleListView();
    }

    void handleListView() {
        if (currentSearch.isEmpty()) {
            Collection.updateCollectionDisplay(Collection.collection);
        } else {
            Collection.updateCollectionDisplay(collectionBuffer);
        }
    }
}
