package com.example.javafx_foodrecommandation.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node; // Import Node from JavaFX
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UI_Controller {

    @FXML
    private void handleViewMealsClick(ActionEvent event) {
        try {
            // Load the personalize.fxml file
            Parent personalizeParent = FXMLLoader.load(getClass().getResource("/com/example/javafx_foodrecommandation/personalize.fxml"));
            Scene personalizeScene = new Scene(personalizeParent);

            // Get the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            window.setScene(personalizeScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception accordingly
        }
    }

    // Other methods and variables for your controller
}
