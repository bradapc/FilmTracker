package com.example.filmtracker;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Recommend {
    public static void display() {
        Stage recommendWindow = new Stage();
        recommendWindow.setResizable(false);
        recommendWindow.initModality(Modality.APPLICATION_MODAL);
        recommendWindow.setTitle("Recommend");

        VBox layout = new VBox();

        Scene scene = new Scene(layout, 300, 400);
        recommendWindow.setScene(scene);
        recommendWindow.showAndWait();
    }
}
