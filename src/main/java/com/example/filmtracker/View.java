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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class View {

    public static void display(int movieID) {
        Stage viewWindow = new Stage();
        viewWindow.setResizable(false);
        viewWindow.initModality(Modality.APPLICATION_MODAL);
        viewWindow.setTitle("View Listing");
        Movie selectedMovie = Collection.getMovieByID(movieID);
        Label movieNameLabel = new Label("Movie Name");
        Label movieAuthorLabel = new Label("Author");
        Label movieYearLabel = new Label("Year");
        Label movieGenreLabel = new Label("Genre");
        Label movieRatingLabel = new Label("Rating");
        TextField movieName = new TextField(selectedMovie.getName());
        TextField movieAuthor = new TextField(selectedMovie.getAuthor());
        TextField movieYear = new TextField(selectedMovie.getYear() + "");
        final GenreBox movieGenre = new GenreBox();
        movieGenre.setCurrentGenre(selectedMovie.getGenre());
        RatingBox movieRating = new RatingBox();
        movieRating.setCurrentRating(selectedMovie.getRating());

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            String newName = movieName.getText();
            String newAuthor = movieAuthor.getText();
            int newYear = Integer.parseInt(movieYear.getText());
            String newGenre = movieGenre.getValue();
            int newRating = movieRating.getIntRating();
            if (Collection.isValidMovieEntries(newName, newAuthor, newYear, newGenre, newRating)) {
                Collection.updateMovieInfo(movieID, newName, newAuthor, newYear, newGenre, newRating);
                viewWindow.close();
            }

        });
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> viewWindow.close());

        HBox buttonLayout = new HBox();
        buttonLayout.getChildren().addAll(saveButton, closeButton);

        VBox viewLayout = new VBox();
        viewLayout.getChildren().addAll(movieNameLabel, movieName, movieAuthorLabel,
                movieAuthor, movieYearLabel, movieYear, movieGenreLabel, movieGenre, movieRatingLabel, movieRating);

        VBox layout = new VBox();
        layout.getChildren().addAll(viewLayout, buttonLayout);

        Scene scene = new Scene(layout, 250, 250);
        viewWindow.setScene(scene);
        viewWindow.showAndWait();

    }
}