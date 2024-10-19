package com.example.filmtracker;

import javafx.scene.control.TextField;
import java.util.ArrayList;

public class FilterBox extends TextField {
    String currentSearch = "";
    FilterBox() {
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            currentSearch = newValue.toLowerCase();
            updateCollectionBuffer(currentSearch);
        });
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
