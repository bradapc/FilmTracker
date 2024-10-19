package com.example.filmtracker;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox mainViewBox = new HBox();
        VBox listingsVBox = new VBox();
        VBox controlsVBox = new VBox();

        primaryStage.setOnCloseRequest(e -> {
            handleApplicationClose();
        });

        Label collectionTitle = new Label();
        FilterBox filterListingsText = new FilterBox();
        filterListingsText.setPromptText("filter film listings");
        ListView<String> listingsDisplay = new ListView<String>();
        Collection.collectionListView = listingsDisplay;
        Collection.collectionListLabel = collectionTitle;
        Collection.loadCollection();
        listingsVBox.getChildren().addAll(collectionTitle, filterListingsText, listingsDisplay);


        Button viewListingButton = new Button("View");
        viewListingButton.setOnAction(e -> {
            if (!listingsDisplay.getSelectionModel().isEmpty()) {
                View.display(getCurrentListingID(listingsDisplay));
            }
        });
        Button addListingButton = new Button("Add");
        addListingButton.setOnAction(e -> {
            Add.display();
        });
        Button removeListingButton = new Button("Remove");
        removeListingButton.setOnAction(e -> {
            if (!listingsDisplay.getSelectionModel().isEmpty()) {
                Collection.removeMovieByID(getCurrentListingID(listingsDisplay));
            }
        });
        viewListingButton.setMinWidth(80);
        addListingButton.setMinWidth(80);
        removeListingButton.setMinWidth(80);
        controlsVBox.getChildren().addAll(viewListingButton, addListingButton, removeListingButton);

        mainViewBox.getChildren().addAll(listingsVBox, controlsVBox);
        Scene mainScene = new Scene(mainViewBox, 350, 350);

        primaryStage.setTitle("Film Tracker");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void handleApplicationClose() {
        Collection.saveCollection();
    }

    int getCurrentListingID(ListView<String> lv) {
        String listing = lv.getSelectionModel().getSelectedItem();
        return Integer.parseInt(listing.substring(0,listing.indexOf(":")));
    }

    public static void main(String[] args) {
        launch(args);
    }
}