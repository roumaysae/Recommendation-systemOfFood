package com.example.javafx_foodrecommandation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//public class HelloApplication extends Application {
//
//
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene( fxmlLoader.load(), 1315, 890);
//        stage.setTitle("Meals");
//        stage.setScene(scene);
//        stage.setFullScreen(true);
//        stage.setResizable(false);
//        stage.show();
//
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}
public class HelloApplication extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        switchScene("hello-view.fxml");
    }

    public static void switchScene(String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1315, 890);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
}
}


