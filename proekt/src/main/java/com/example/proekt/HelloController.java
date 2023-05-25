package com.example.proekt;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class HelloController {
    public Button btn_search;
    public ImageView headdress;
    public ImageView cloth;
    public ImageView trousers;
    public ImageView shoes;
    private Parser parser;
    @FXML
    private Text gorod;
    @FXML
    private Text vlaga;
    @FXML
    private Text wet;
    @FXML
    private Text tempa;
    @FXML
    private AnchorPane background_img;
    @FXML
    private Text real_time;
    @FXML
    private TextField search_str;
    @FXML
    private ImageView tempaView;

    public void initialize() {
        String imagePath = "C:/javaproekt/final/proekt/src/main/java/com/example/proekt/images/search.png";
        Image image = new Image(new File(imagePath).toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        btn_search.getStyleClass().add("btn_search");
        btn_search.setGraphic(imageView);
    }

    @FXML
    protected void onHelloButtonClick() throws IOException {
        if(parser==null){
            parser = new Parser();
            search_str.setText("Москва");
            onSearch();
        }
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

    public void onSearch() throws IOException {
        String searchText = search_str.getText(); //ВОЗВРАТ ВВЕДЕННОГО ГОРОДА
        onHelloButtonClick();
        CityInfo ci = parser.getInfo(searchText);
        if(ci!=null) {
            gorod.setText(ci.getCity());
            int hum = ci.getHumidity();
            int win = ci.getWind();
            int temp = ci.getTemperature();
            String res;
            vlaga.setText(String.valueOf(hum)+"%");
            wet.setText(String.valueOf(win)+" м/c");
            tempa.setText(String.valueOf(temp)+"°");
            if(temp>10 || hum<50){
                res="sun";
                if(hum>50)
                    res="cloudsun";
            }
            else
                res="cloudsun";
            if(hum>75 || temp<-10)
                res="rain";
            tempaView.setImage(new Image("C:/javaproekt/proekt/src/main/resources/com/example/proekt/images/"+res+".png"));

            String head = "";
            String body = "";
            String legs = "";
            String ankles = "";
            if(temp>10 && temp<=19){
                head="cap";
                body="hoodie";
                legs="jeans";
                ankles="sneakers";
            }
            if(temp>19){
                head="cap";
                body="tshirt";
                legs="shorts";
                ankles="slippers";
            }
            if(temp>0 && temp<=10){
                head="cap";
                body="jacket";
                legs="jeans";
                ankles="sneakers";
            }
            if(temp<=0){
                head="warm_hat";
                body="warm_jacket";
                legs="jeans";
                ankles="boots";
            }
            headdress.setImage(new Image("C:/javaproekt/final/proekt/src/main/java/com/example/proekt/images/"+head+".png"));
            cloth.setImage(new Image("C:/javaproekt/final/proekt/src/main/java/com/example/proekt/images/"+body+".png"));
            trousers.setImage(new Image("C:/javaproekt/final/proekt/src/main/java/com/example/proekt/images/"+legs+".png"));
            shoes.setImage(new Image("C:/javaproekt/final/proekt/src/main/java/com/example/proekt/images/"+ankles+".png"));
        }
    }
}