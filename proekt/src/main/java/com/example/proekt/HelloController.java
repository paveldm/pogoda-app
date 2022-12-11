package com.example.proekt;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelloController {
    @FXML
    private Text gorod;
    @FXML
    private AnchorPane background_img;
    @FXML
    private Text real_time;
    @FXML
    private TextField search_str;
    @FXML
    protected void onHelloButtonClick() {
        Date date = new Date();
        if(date.getHours()<10){
            if ((date.getMinutes()<10)){
                real_time.setText("0" + String.valueOf(date.getHours()) + " : 0" + String.valueOf(date.getMinutes()));
            } else if (date.getMinutes()>=10) {
                real_time.setText("0" + String.valueOf(date.getHours()) + " : " + String.valueOf(date.getMinutes()));
            }
        }
        else if (date.getMinutes()<10) {
            real_time.setText(String.valueOf(date.getHours()) + " : 0" + String.valueOf(date.getMinutes()));
        }
        else {
            real_time.setText(String.valueOf(date.getHours()) + " : " + String.valueOf(date.getMinutes()));
        }
        real_time.setStyle("-fx-font-size: 18px;");
        if (date.getHours()>5 && date.getHours()<18){
            background_img.setStyle("-fx-background-image: url('file:C:/javaproekt/proekt/src/main/resources/com/example/proekt/images/day.jpg');");
        } else if (date.getHours()>=18) {
            background_img.setStyle("-fx-background-image: url('file:C:/javaproekt/proekt/src/main/resources/com/example/proekt/images/evening.jpg');");
        }
        else {
            background_img.setStyle("-fx-background-image: url('file:C:/javaproekt/proekt/src/main/resources/com/example/proekt/images/night.jpg');");
        }
    }

    public void onSearch() {
        String searchText = search_str.getText(); //ВОЗВРАТ ВВЕДЕННОГО ГОРОДА
        onHelloButtonClick();
    }
}