package com.example.filmtracker;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Add {

    public static void display() {
        Stage addWindow = new Stage();
        addWindow.setResizable(false);
        addWindow.initModality(Modality.APPLICATION_MODAL);
        addWindow.setTitle("Add Listing");

        Label listingNameLabel = new Label("Name");
        TextField listingNameField = new TextField();
        Label authorNameLabel = new Label("Author");
        TextField authorNameField = new TextField();
        Label yearLabel = new Label("Year");
        TextField yearField = new TextField();
        final GenreBox genreBox = new GenreBox();
        final RatingBox ratingBox = new RatingBox();

        TextArea commentsField = new TextArea();
        commentsField.setPromptText("what did you think?");
        commentsField.setWrapText(true);

        Button addButton = new Button("Add");
        addButton.setMinWidth(80);
        addButton.setOnAction(e -> {
            //To add: Validate input
            String name = listingNameField.getText();
            String author = authorNameField.getText();
            int year = Integer.parseInt(yearField.getText());
            Movie newMovie = new Movie(name, author, year, genreBox.getValue(), ratingBox.getIntRating(), commentsField.getText());
            Collection.addToCollection(newMovie);
            addWindow.close();
        });

        HBox comboBoxLayout = new HBox();
        comboBoxLayout.getChildren().addAll(genreBox, ratingBox);
        VBox layout = new VBox();
        layout.getChildren().addAll(listingNameLabel, listingNameField, authorNameLabel, authorNameField,
                yearLabel, yearField, comboBoxLayout, commentsField, addButton);

        Scene scene = new Scene(layout, 250, 250);
        addWindow.setScene(scene);
        addWindow.showAndWait();

    }
}