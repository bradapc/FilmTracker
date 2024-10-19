package com.example.filmtracker;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
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
        AuthorCheckbox unknownAuthorBox = new AuthorCheckbox("?");
        unknownAuthorBox.setAuthorField(authorNameField);
        Label yearLabel = new Label("Year");
        TextField yearField = new TextField();
        final GenreBox genreBox = new GenreBox();
        final RatingBox ratingBox = new RatingBox();

        TextArea commentsField = new TextArea();
        commentsField.setPromptText("what did you think?");
        commentsField.setWrapText(true);
        CheckBox recommendedBox = new CheckBox("Recommendation?");
        //Convert recommendedbox to new class that changes its text to Recommended or Not Recommended based on if selected

        Button addButton = new Button("Add");
        addButton.setMinWidth(80);
        addButton.setOnAction(e -> {
            //To add: Validate input
            String name = listingNameField.getText();
            String author = authorNameField.getText();
            int year = Integer.parseInt(yearField.getText());
            boolean isRecommended = recommendedBox.isSelected();
            Movie newMovie = new Movie(name, author, year, genreBox.getValue(), ratingBox.getIntRating(), commentsField.getText(), isRecommended);
            Collection.addToCollection(newMovie);
            addWindow.close();
        });

        HBox authorControls = new HBox();
        authorControls.getChildren().addAll(authorNameField, unknownAuthorBox);

        HBox comboBoxLayout = new HBox();
        comboBoxLayout.getChildren().addAll(genreBox, ratingBox);

        HBox buttonLayout = new HBox();
        buttonLayout.getChildren().addAll(addButton, recommendedBox);

        VBox layout = new VBox();
        layout.getChildren().addAll(listingNameLabel, listingNameField, authorNameLabel, authorControls,
                yearLabel, yearField, comboBoxLayout, commentsField, buttonLayout);

        Scene scene = new Scene(layout, 250, 250);
        addWindow.setScene(scene);
        addWindow.showAndWait();

    }
}