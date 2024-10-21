package com.example.filmtracker;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Recommend {
    public static void display() {
        Stage recommendWindow = new Stage();
        recommendWindow.setResizable(false);
        recommendWindow.initModality(Modality.APPLICATION_MODAL);
        recommendWindow.setTitle("Recommend");

        RecommendView recommendView = new RecommendView();

        RatingBox ratingBox = new RatingBox();
        ratingBox.setCurrentRating(recommendView.getRating());
        GenreBox genreBox = new GenreBox();
        genreBox.setCurrentGenre(recommendView.getGenre());
        genreBox.setOnAction(e -> recommendView.setGenre(genreBox.getValue()));

        VBox layout = new VBox();
        HBox filterWrapper = new HBox(ratingBox, genreBox);
        VBox rvWrapper = new VBox(recommendView);
        layout.getChildren().addAll(filterWrapper, rvWrapper);

        Scene scene = new Scene(layout, 300, 400);
        recommendWindow.setScene(scene);
        recommendWindow.showAndWait();
    }
}
