package com.example.javafx_foodrecommandation.presentation;

import com.example.javafx_foodrecommandation.Listener;
import com.example.javafx_foodrecommandation.dao.Ingredient;
import com.example.javafx_foodrecommandation.dao.Meal;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class mealDetails_Controller {
    @FXML

    public Text InstructionsMeal;
    @FXML

    public Label chosenNameMeal;
    @FXML
    public Text IngredientMeal;
    @FXML

    public ImageView imageMeal;
    @FXML

    public Label mealCountry;

    private Meal meal ;
    private Listener listener;

    public void showMealDetails(Meal meal) {
        chosenNameMeal.setText(meal.getTitle());
        InstructionsMeal.setText(meal.getInstructions());

        // Display ingredients
        StringBuilder ingredientsText = new StringBuilder();
        for (Ingredient ingredient : meal.getIngredients()) {
            ingredientsText.append(ingredient.getName()).append(": ").append(ingredient.getMesure()).append("\n");
        }
        IngredientMeal.setText(ingredientsText.toString());

        // Display meal image
        Image mealImage = new Image(meal.getImageMeal());
        imageMeal.setImage(mealImage);

        // Update other UI elements as needed
        mealCountry.setText("Country: " + meal.getCountry());

        // Update the chosenmealCard VBox with the selected meal details
        // (Note: You need to have access to chosenmealCard from this class or pass it as a parameter)
        // chosenmealCard.getChildren().clear();
        // chosenmealCard.getChildren().addAll(chosenNameMeal, instructionsMeal, ingredientMeal, imageMeal, mealCountry);
        // chosenmealCard.setVisible(true);
    }
}
