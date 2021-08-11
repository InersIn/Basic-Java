package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private Text nim;

    @FXML
    private Text name;

    @FXML
    private Text text;

    @FXML
    private ImageView flashlisght;

    @FXML
    private AnchorPane Pane;

    public void setUp(String n, String m){
        name.setText(n);
        nim.setText(m);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double halfSizeX=flashlisght.getFitWidth()/2;
        double halfSizeY=flashlisght.getFitHeight()/2;
        System.out.println(flashlisght.getX()+" "+flashlisght.getY());
        Pane.setOnMouseMoved(e -> {
            flashlisght.setX(e.getX()-(halfSizeX/3.02));
            flashlisght.setY(e.getY()-(halfSizeY/5.02));
        });
    }
}