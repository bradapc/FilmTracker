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

public class View {

    public static void display(int movieID) {
        Stage addWindow = new Stage();
        addWindow.setResizable(false);
        addWindow.initModality(Modality.APPLICATION_MODAL);
        addWindow.setTitle("Sawit - View Listing");
        Movie selectedMovie = Collection.getMovieByID(movieID);
        Label movieName = new Label(selectedMovie.getName());
        Label movieAuthor = new Label(selectedMovie.getAuthor());
        Label movieYear = new Label(selectedMovie.getYear() + "");
        Label movieGenre = new Label(selectedMovie.getGenre());
        Label movieRating = new Label(selectedMovie.getRating() + "");

        VBox layout = new VBox();
        layout.getChildren().addAll(movieName, movieAuthor, movieYear, movieGenre, movieRating);

        Scene scene = new Scene(layout, 250, 250);
        addWindow.setScene(scene);
        addWindow.showAndWait();

    }
}