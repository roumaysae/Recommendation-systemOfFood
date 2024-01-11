package com.example.javafx_foodrecommandation.presentation;

import com.example.javafx_foodrecommandation.HelloApplication;
import com.example.javafx_foodrecommandation.Listener;
import com.example.javafx_foodrecommandation.dao.Meal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class UI_Consulting_Meals_Controller implements Initializable {

    @FXML
    private Button idCategoryOne;
    @FXML
    private Text IngredientMeal;

    @FXML
    private Text InstructionsMeal;
    @FXML
    private VBox chosenmealCard;

    @FXML
    private ImageView imageMeal;

    @FXML
    private Label mealCountry;

    @FXML
    private Label nameMeal;

    @FXML
    private GridPane gridpane;

    @FXML
    private ScrollPane scrollPan;
    private Listener listener;
    private List<Meal> mealList = new ArrayList<>();
    private Image image ;


    private List<Meal> getData() {
        List<Meal> meals = new ArrayList<>();
        Meal meal;
        for (int i = 0; i <meals.size(); i++) {
            meal = new Meal();
            meal.setTitle("Lamb Pilaf ");
            meal.setImageMeal("../../resources/com/example/javafx_foodrecommandation/public/meal1Consulting.jpg");
            meals.add(meal);
        }
        return meals;
    }


    private void setChosenMeal(Meal meal){
        nameMeal.setText(meal.getTitle());
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(meal.getImageMeal())));
        imageMeal.setImage(image);
        mealCountry.setText(meal.getCountry());
        IngredientMeal.setText(String.valueOf(meal.getIngredient()));
        InstructionsMeal.setText(meal.getInstructions());
    }


    @FXML
    private void HandleBackToFirstPage(ActionEvent event) {
        try {
            HelloApplication.switchScene("hello-view.fxml");

//            // Load the personalize.fxml file
//            Parent personalizeParent = FXMLLoader.load(getClass().getResource("/com/example/javafx_foodrecommandation/hello-view.fxml"));
//            Scene personalizeScene = new Scene(personalizeParent);
//
//            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            // Set the stage to full-screen mode and disable resizing
//            window.setFullScreen(true);
//            window.setResizable(false);
//
//            // Set the new scene
//            window.setScene(personalizeScene);
//            window.show();
        } catch (IOException ex) {
        throw new RuntimeException(ex);
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mealList.addAll(getData());
        if (!mealList.isEmpty()) {
            setChosenMeal(mealList.get(0));
            listener = new Listener() {
                @Override
                public void onclikListener(Meal meal) {
                    setChosenMeal(meal);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < mealList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/resources/com/example/javafx_foodrecommandation/UI_Card_Meals.fxml"));

                UI_Card_Meals_Controller ui_card_meals = fxmlLoader.getController();
                ui_card_meals.setData(mealList.get(i), listener);

                AnchorPane anchorPane = fxmlLoader.load();

                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridpane.add(anchorPane, column++, row); // child + col + row
                // set card grid with

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

