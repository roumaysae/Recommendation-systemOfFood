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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.bson.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class UI_Consulting_Meals_Controller implements Initializable {

    public BorderPane Container;
    @FXML
    private Button buttonBeef;
    @FXML
    private Button buttonChicken;
    @FXML
    private Button buttonDessert;
    @FXML
    private Button buttonLamb;
    @FXML
    private Button buttonMiscellaneous;
    @FXML
    private Button buttonPasta;
    @FXML
    private Button buttonSeafood;
    @FXML
    private Button buttonSide;
    @FXML
    private Button buttonStarter;
    @FXML
    private Button buttonVegan;
    @FXML
    private Button buttonVegetarian;
    @FXML
    private Button buttonBreakfast;
    @FXML
    private VBox mealDetails;
    @FXML
    private VBox categoryContent;



    private Listener listener;
    private final List<Meal> mealList = new ArrayList<>();
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
        String mongoUri = System.getProperty("mongodb.uri", "mongodb://localhost:27017");
        MongoClient mongoClient = MongoClients.create(mongoUri);
        database = mongoClient.getDatabase("MealsByCategory");

        List<String> categories = List.of("Beef", "Chicken", "Dessert", "Lamb", "Miscellaneous", "Pasta", "Seafood", "Side", "Starter", "Vegan", "Vegetarian", "Breakfast");

        for (int i = 0; i < categories.size(); i++) {
            int index = i;  // Store the current index in a local variable

            switch (categories.get(i)) {
                case "Beef":
                    buttonBeef.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Chicken":
                    buttonChicken.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Dessert":
                    buttonDessert.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Lamb":
                    buttonLamb.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Miscellaneous":
                    buttonMiscellaneous.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Pasta":
                    buttonPasta.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Seafood":
                    buttonSeafood.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Side":
                    buttonSide.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Starter":
                    buttonStarter.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Vegan":
                    buttonVegan.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Vegetarian":
                    buttonVegetarian.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                case "Breakfast":
                    buttonBreakfast.setOnAction(e -> handleCategoryButtonClick(categories.get(index)));
                    break;
                default:
                    break;
            }
        }
    }

    private void handleCategoryButtonClick(String categoryName) {
        System.out.println("Clicked Category: " + categoryName);

        MongoCollection<Document> categoriesCollection = database.getCollection("Categories");
        Document query = new Document("categories.strCategory", categoryName);
        Document categoryDocument = categoriesCollection.find(query).first();

        if (categoryDocument != null) {
            List<Document> categories = categoryDocument.getList("categories", Document.class);

            if (categories != null && !categories.isEmpty()) {
                Document categoryObject = categories.stream()
                        .filter(category -> categoryName.equals(category.getString("strCategory")))
                        .findFirst()
                        .orElse(null);

                if (categoryObject != null) {
                    List<Document> mealsDocuments = categoryObject.getList("meals", Document.class);

                    if (mealsDocuments != null) {
                        mealList.clear();
                        for (Document mealDocument : mealsDocuments) {
                            Meal meal = convertDocumentToMeal(mealDocument);
                            mealList.add(meal);
                        }
                        refreshUI();
                    } else {
                        System.out.println("Meals Documents is null for: " + categoryName);
                    }
                } else {
                    System.out.println("No category found for: " + categoryName);
                }
            } else {
                System.out.println("No categories found for: " + categoryName);
            }
        } else {
            System.out.println("Category document not found for: " + categoryName);
        }
    }

    private Meal convertDocumentToMeal(Document mealDocument) {
        Meal meal = new Meal();
        meal.setTitle(mealDocument.getString("strMeal"));
        meal.setImageMeal(mealDocument.getString("strMealThumb"));
        meal.setCountry(mealDocument.getString("country"));
        meal.setInstructions(mealDocument.getString("instructions"));

        List<Document> ingredientsDocuments = mealDocument.getList("ingredients", Document.class);
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        for (Document ingredientDocument : ingredientsDocuments) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientDocument.getString("ingredient1_name"));
            ingredient.setMeasure(ingredientDocument.getString("ingredient1_mesure"));
            ingredients.add(ingredient);
        }

        meal.setIngredients(ingredients);

        return meal;
    }

    // Refreshes the UI with updated mealList
    private void refreshUI() {
        // Clear existing meal cards
        categoryContent.getChildren().clear();

        // Add new meal cards to the categoryContent VBox
        for (Meal meal : mealList) {
            try {

                // Load the FXML directly with the controller
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UI_Card_Meals.fxml"));
                VBox mealCard = fxmlLoader.load();

                // Get the controller associated with the loaded FXML
                UI_Card_Meals_Controller ui_card_meals = fxmlLoader.getController();

                // Set data for each meal card
                ui_card_meals.setData(meal, listener);

                categoryContent.getChildren().add(mealCard);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
