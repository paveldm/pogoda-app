package com.example.proekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 650);

        stage.setTitle("Clothes&Weather");
        stage.setScene(scene);
        stage.getIcons().add(new Image("C:/javaproekt/final/proekt/src/main/java/com/example/proekt/images/cloudsun.png"));
        scene.getStylesheets().add("file:styles/styles.css");
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}