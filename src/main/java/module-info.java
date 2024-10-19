module com.example.filmtracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.filmtracker to javafx.fxml;
    exports com.example.filmtracker;
}