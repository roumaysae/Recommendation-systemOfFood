
package com.example.javafx_foodrecommandation.presentation;

import com.example.javafx_foodrecommandation.HelloApplication;
import com.example.javafx_foodrecommandation.Listener;
import com.example.javafx_foodrecommandation.dao.Ingredient;
import com.example.javafx_foodrecommandation.dao.Meal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class UI_Card_Meals_Controller {

    public VBox Meal_container;
    @FXML
    public Text InstructionsMeal;
    @FXML
    public Label mealCountry;
    @FXML
    public Text IngredientMeal;
    @FXML
    private ImageView ImageCard;
    @FXML
    private Label nameMeal;
    private Meal meal;
    private Listener listener;

    @FXML
    void click(MouseEvent mouseEvent){
        listener.onclikListener(meal);
    }

    public void setData(Meal meal, Listener listener) {
        this.meal = meal;
        this.listener = listener;
        nameMeal.setText(meal.getTitle());
        InstructionsMeal.setText(meal.getInstructions());
        IngredientMeal.setText(getIngredientsText(meal.getIngredients()));
        mealCountry.setText(meal.getCountry());
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream(meal.getImageMeal())));
        ImageCard.setImage(image);
    }

    private String getIngredientsText(ArrayList<Ingredient> ingredients) {
        StringBuilder ingredientsText = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            ingredientsText.append(ingredient.getName()).append(": ").append(ingredient.getMesure()).append("\n");
        }
        return ingredientsText.toString();
    }


    /*public static EventHandler<ActionEvent> handleMealButtonClick(Meal meal) {
        return event -> {

            // Implement the logic to handle the meal button click
            System.out.println("Clicked Meal: " + meal.getTitle());

            // Display meal details
            UI_Consulting_Meals_Controller.showMealDetails(meal);
        };
    }*/


    public void setVisible(ActionEvent actionEvent) {
    }
}
