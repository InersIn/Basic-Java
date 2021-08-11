package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    boolean s1=true;
    boolean s2=true;
    boolean s3=true;
    double c1=1;
    double c2=1;
    double c3=1;
    @FXML
    private Circle circle2;

    @FXML
    private Circle circle3;

    @FXML
    private Circle circle1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            setRotate(1, 180,2.7);
            setRotate(2, 145,2);
            setRotate(3, 140,1.5);

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setRotate(int id, int derajat, double rotate) {
        if (id == 1) {
            circle1.setRotate(c1);
            if (s1 && c1 <= derajat) {
                c1 += rotate;
                if (c1 >= derajat) s1 = false;
            } else if (!s1 && c1 >= 0) {
                c1 -= rotate;
                if (c1 <= 0) s1 = true;
            }
        }else if (id == 2) {
            circle2.setRotate(c2);
            if (s2 && c2 <= derajat) {
                c2 += rotate;
                if (c2 >= derajat) s2 = false;
            } else if (!s2 && c2 >= 0) {
                c2 -= rotate;
                if (c2 <= 0) s2 = true;
            }
        }else if (id == 3) {
            circle3.setRotate(c3);
            if (s3 && c3 <= derajat) {
                c3 += rotate;
                if (c3 >= derajat) s3 = false;
            } else if (!s3 && c3 >= 0) {
                c3 -= rotate;
                if (c3 <= 0) s3 = true;
            }
        }
    }
}