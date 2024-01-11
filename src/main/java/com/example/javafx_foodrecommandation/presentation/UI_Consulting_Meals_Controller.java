package com.example.javafx_foodrecommandation.presentation;

import com.example.javafx_foodrecommandation.HelloApplication;
import com.example.javafx_foodrecommandation.Listener;
import com.example.javafx_foodrecommandation.dao.Ingredient;
import com.example.javafx_foodrecommandation.dao.Meal;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.bson.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UI_Consulting_Meals_Controller implements Initializable {

    @FXML
    private VBox categoryButtonsContainer;

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
    private Image image;
    private MongoDatabase database;

    @FXML
    private void HandleBackToFirstPage(ActionEvent event) {
        try {
            HelloApplication.switchScene("hello-view.fxml");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MongoClient mongoClient = MongoClients.create(System.getProperty("mongodb.uri"));
        database = mongoClient.getDatabase("MealsByCategory");

        List<String> categories = List.of("Beef", "Chicken", "Dessert", "Lamb", "Miscellaneous", "Pasta", "Seafood", "Side", "Starter", "Vegan", "Vegetarian", "Breakfast");

        // Populate UI with category buttons
        for (String category : categories) {
            Button categoryButton = new Button(category);
            categoryButton.setOnAction(e -> handleCategoryButtonClick(category));
            categoryButtonsContainer.getChildren().add(categoryButton);
        }

        // Initialize UI with the first category
        handleCategoryButtonClick(categories.get(0));
    }

    private void handleCategoryButtonClick(String categoryName) {
        MongoCollection<Document> categoriesCollection = database.getCollection("categories");
        Document categoryDocument = categoriesCollection.find(new Document("strCategory", categoryName)).first();

        if (categoryDocument != null) {
            List<Document> mealsDocuments = categoryDocument.getList("meals", Document.class);
            mealList.clear();
            for (Document mealDocument : mealsDocuments) {
                Meal meal = convertDocumentToMeal(mealDocument);
                mealList.add(meal);
            }
            //refreshUI();
        }
    }

    private Meal convertDocumentToMeal(Document mealDocument) {
        Meal meal = new Meal();
        meal.setTitle(mealDocument.getString("strMeal"));
        meal.setImageMeal(mealDocument.getString("strMealThumb"));
        meal.setCountry(mealDocument.getString("country"));
        meal.setInstructions(mealDocument.getString("instructions"));

        List<Document> ingredientsDocuments = mealDocument.getList("ingredients", Document.class);
        List<Ingredient> ingredients = new ArrayList<>();

        for (Document ingredientDocument : ingredientsDocuments) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientDocument.getString("ingredient1_name"));
            ingredient.setMeasure(ingredientDocument.getString("ingredient1_mesure"));
            ingredients.add(ingredient);
        }

        meal.setIngredients((ArrayList<Ingredient>) ingredients);

        return meal;
    }

    // Refreshes the UI with updated mealList
    private void refreshUI() {
        // Clear existing UI elements
        gridpane.getChildren().clear();

        // Add new meal cards to the UI
        int column = 0;
        int row = 1;

        try {
            for (int i = 0; i < mealList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("UI_Card_Meals.fxml"));

                UI_Card_Meals_Controller ui_card_meals = new UI_Card_Meals_Controller();
                ui_card_meals.setData(mealList.get(i), listener);

                AnchorPane anchorPane = fxmlLoader.load();

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridpane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
