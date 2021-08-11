package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.ArrayList;
import javafx.scene.text.TextAlignment;

public class Main extends Application {
    private boolean turn = true;
    private ArrayList<ArrayList<String>> win = new ArrayList<ArrayList<String>>(8);
    private ArrayList<String> posx = new ArrayList<String>();
    private ArrayList<String> poso = new ArrayList<String>();
    Alert winer = new Alert(AlertType.INFORMATION);
    TextField user = new TextField();

    private Parent createContent(){
        ArrayList<String> col1 = new ArrayList<String>(3);
        col1.add("00");
        col1.add("11");
        col1.add("22");
        ArrayList<String> col2 = new ArrayList<String>(3);
        col2.add("02");
        col2.add("11");
        col2.add("20");
        ArrayList<String> col3 = new ArrayList<String>(3);
        col3.add("00");
        col3.add("10");
        col3.add("20");
        ArrayList<String> col4 = new ArrayList<String>(3);
        col4.add("01");
        col4.add("11");
        col4.add("21");
        ArrayList<String> col5 = new ArrayList<String>(3);
        col5.add("02");
        col5.add("12");
        col5.add("22");
        ArrayList<String> col6 = new ArrayList<String>(3);
        col6.add("00");
        col6.add("01");
        col6.add("02");
        ArrayList<String> col7 = new ArrayList<String>(3);
        col7.add("10");
        col7.add("11");
        col7.add("12");
        ArrayList<String> col8 = new ArrayList<String>(3);
        col8.add("20");
        col8.add("21");
        col8.add("22");

        this.win.add(col1);
        this.win.add(col2);
        this.win.add(col3);
        this.win.add(col4);
        this.win.add(col5);
        this.win.add(col6);
        this.win.add(col7);
        this.win.add(col8);

        int width = 600;
        int height = 700;
        Pane root = new Pane();
        root.setPrefSize(width, height);

        for (int x=0; x<3; x++){
            for (int i=0; i<3; i++){
                Box box = new Box();
                box.setTranslateX(x*200);
                box.setTranslateY(i*200);
                box.setId(i+""+x);

                root.getChildren().addAll(box);
            }
        }
        user.setText("Tic Tac Toe");
        user.setPrefWidth(600);
        user.setPrefHeight(100);
        user.setEditable(false);
        user.setDisable(true);
        user.setAlignment(Pos.CENTER);
        user.setStyle("-fx-font: 48 Arial; -fx-padding: 620px 0 0 0;");
        root.getChildren().addAll(user);
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(createContent()));

        primaryStage.show();
    }

    public boolean checkStatus(ArrayList<String> array){
        boolean status = false;
        for (int x=0; x<this.win.size();x++){
            int count=0;
            for (int a=0; a<array.size(); a++){
                if (this.win.get(x).contains(array.get(a))){
                    count++;
                }
                if (count==3){
                    status=true;
                    return status;
                }
            }
        }
        return status;
    }

    public class Box extends StackPane{
        private Text text = new Text();
        public Box(){
            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            text.setFont(Font.font(78));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY){
                    if (turn && text.getText() != "O") {
                        posx.add(event.getTarget().toString().substring(12,14));
                        setX();
                        turn=false;
                        if (checkStatus(posx)){
                            dialog("Selamat", "The Winner Is X");
                            user.setText("Pemenangnya user X");
                        }
                        user.setText("User O Turn");
                    } else if ( turn == false && text.getText() != "X"){
                        setO();
                        poso.add(event.getTarget().toString().toString().substring(12,14));
                        turn=true;
                        if (checkStatus(poso)){
                            dialog("Selamat", "The Winner Is O");
                            user.setText("Pemenangnya user O");
                        }
                        user.setText("User X Turn");
                    }
                    if (posx.size()==4 && poso.size() == 5 || posx.size()==5 && poso.size() == 4){
                        dialog("Draw", "Tidak Ada Yang Menang");
                        user.setText("Tidak Ada Pemenangnya");
                    }
                }
            });
        }
        private void setX(){
            text.setText("X");
        }
        private void setO(){
            text.setText("O");
        }
        public void setTurn(String n){
            Rectangle border = new Rectangle(600, 700);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            user.setFont(Font.font(78));
            user.setText(n);

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);
        }

        public void dialog(String title, String content){
            winer.setTitle(title);
            winer.setContentText(content);
            winer.show();
            winer.setOnCloseRequest(e -> {
                Platform.exit();
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
