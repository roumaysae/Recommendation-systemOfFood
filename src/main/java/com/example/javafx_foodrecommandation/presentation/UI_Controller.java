package com.example.javafx_foodrecommandation.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node; // Import Node from JavaFX
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.javafx_foodrecommandation.HelloApplication.*;

public class UI_Controller {

    @FXML
    private void handleViewMealsClick(ActionEvent event) {
        try {
            switchScene("personalize.fxml");
            /*// Load the personalize.fxml file
           Parent personalizeParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("personalize.fxml")));
           Scene personalizeScene = new Scene(personalizeParent);

           // Get the Stage information
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
           window.setScene(personalizeScene);

           window.show();*/
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception accordingly
        }
    }

    @FXML
    private void handleMealsbyCategorie(ActionEvent event) {
        try {
            switchScene("UI_Consulting_Meals.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private CheckBox otherAllergiesCheckbox;

    @FXML
    private CheckBox otherDietaryCheckbox;

    @FXML
    private TextField otherAllergiesTextField;

    @FXML
    private TextField otherDietaryTextField;

    @FXML
    private void handleOtherAllergies() {
        if (otherAllergiesCheckbox.isSelected()) {
            otherAllergiesTextField.setVisible(true);
        } else {
            otherAllergiesTextField.setVisible(false);
            otherAllergiesTextField.clear();
        }
    }

    @FXML
    private void handleOtherDietary() {
        if (otherDietaryCheckbox.isSelected()) {
            otherDietaryTextField.setVisible(true);
        } else {
            otherDietaryTextField.setVisible(false);
            otherDietaryTextField.clear();
        }
    }
    @FXML
    private void HandleGeneratePage(ActionEvent event) {
        try {
            // Load the regenerate_page.fxml file
            Parent regenerateParent = FXMLLoader.load(getClass().getResource("/com/example/javafx_foodrecommandation/UI_Regenerate_Page.fxml"));
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


    @FXML
    private void HandleBackToFirstPage(ActionEvent event) {
        try {
            switchScene("hello-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}