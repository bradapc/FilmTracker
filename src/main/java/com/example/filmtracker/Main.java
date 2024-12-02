package com.example.filmtracker;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//Add filter options --> sort main by title, stars, year, id etc.

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox mainViewBox = new HBox();
        mainViewBox.setId("main-viewbox");
        VBox listingsVBox = new VBox();
        VBox controlsVBox = new VBox();

        primaryStage.setOnCloseRequest(e -> {
            handleApplicationClose();
        });

        Label collectionTitle = new Label();
        collectionTitle.setId("collection-title");
        FilterBox filterListingsText = new FilterBox();
        filterListingsText.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
        filterListingsText.setPromptText("filter film listings");
        filterListingsText.setFocusTraversable(false);
        ListView<String> listingsDisplay = new ListView<String>();
        //Fix this mess...
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
        Button recommendationButton = new Button("Recommend");
        recommendationButton.setOnAction(e -> {
            Recommend.display();
        });
        viewListingButton.setMinWidth(100);
        addListingButton.setMinWidth(100);
        removeListingButton.setMinWidth(100);
        recommendationButton.setMinWidth(100);
        controlsVBox.getChildren().addAll(viewListingButton, addListingButton, removeListingButton, recommendationButton);
        Label filterLabel = new Label("Filters");
        Button filterByTitle = new Button("Title");
        Button filterByYear = new Button("Year");
        Button filterByAuthor = new Button("Author");
        filterByTitle.setMinWidth(100);
        filterByYear.setMinWidth(100);
        filterByAuthor.setMinWidth(100);
        controlsVBox.getChildren().addAll(filterLabel, filterByTitle, filterByYear, filterByAuthor);
        controlsVBox.setId("controls-vbox");
        mainViewBox.getChildren().addAll(listingsVBox, controlsVBox);
        Scene mainScene = new Scene(mainViewBox, 350, 350);
        mainScene.getStylesheets().add("Main.css");
        primaryStage.setTitle("Film Tracker");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
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