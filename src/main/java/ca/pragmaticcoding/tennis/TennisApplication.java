package ca.pragmaticcoding.tennis;

import ca.pragmaticcoding.widgetsfx.text.Labels;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class TennisApplication extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Tennis Bookings");
        stage.setScene(new Scene(new MainController().getView()));
        stage.show();
    }

}