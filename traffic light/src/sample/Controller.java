package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable {
    int red;
    int yellow;
    int green;
    int status = 0;
    @FXML
    private Circle lampg;

    @FXML
    private Circle lampr;

    @FXML
    private TextField counter;

    @FXML
    private Circle lampy;

    @FXML
    void fffd1f(ActionEvent event) {

    }

    @FXML
    void fff541(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setter();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (red>=0){
                lampr.setFill(Color.RED);
                counter.setStyle("-fx-text-fill: red; -fx-background-color: grey");
                counter.setText(String.valueOf(red--));
            } else if (yellow>=0){
                lampy.setFill(Color.YELLOW);
                counter.setStyle("-fx-text-fill: yellow; -fx-background-color: grey");
                counter.setText(String.valueOf(yellow--));
            }  else if (green>=0){
                lampr.setFill(Color.BLACK);
                lampy.setFill(Color.BLACK);
                lampg.setFill(Color.GREEN);
                counter.setStyle("-fx-text-fill: green; -fx-background-color: grey");
                counter.setText(String.valueOf(green--));
            } else{

                setter();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    private void setter(){
        red = 8;
        yellow = 3;
        green = 5;
        lampg.setFill(Color.BLACK);
        lampy.setFill(Color.BLACK);
    }
}
