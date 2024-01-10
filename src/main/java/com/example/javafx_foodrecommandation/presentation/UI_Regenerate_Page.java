package com.example.javafx_foodrecommandation.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class UI_Regenerate_Page {

        @FXML
        private VBox centertoresult;

        @FXML
        private VBox recommendationmeal;

        @FXML
        private VBox sidetohome;

        @FXML
        private VBox sidetoregenerate;

        @FXML
        private void HandleBackToFirstPage(ActionEvent event) {
                try {
                        // Load the personalize.fxml file
                        Parent regenerateParent = FXMLLoader.load(getClass().getResource("/com/example/javafx_foodrecommandation/personalize.fxml"));
                        Scene regenerateScene = new Scene(regenerateParent);

                        // Get the Stage information
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        // Set the new scene
                        window.setScene(regenerateScene);
                        // Set the stage to full-screen mode and disable resizing
                        window.setFullScreen(true);
                        window.setResizable(false);
                        window.show();
                } catch (IOException e) {
                        e.printStackTrace(); // Handle the exception accordingly
                }
        }
        // You can add methods here to handle actions or interactions with these VBox elements
        // For instance, a method to update the recommendationmeal VBox content
        public void updateRecommendation(String recommendation) {
                // Clear previous content if needed
                recommendationmeal.getChildren().clear();

                // Create new content (e.g., labels, buttons, etc.) based on the recommendation
                // Add the new content to the recommendationmeal VBox
        }

        // Another method to handle some action when a button is clicked
        @FXML
        private void handleRegenerateClick() {
                // Logic to handle the regenerate action
        }

        // Additional methods for other functionalities related to this UI
}
