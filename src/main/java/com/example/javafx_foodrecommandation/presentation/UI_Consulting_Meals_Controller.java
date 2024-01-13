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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    @FXML
    public BorderPane Container;

    @FXML
    public VBox chosenmealCard;

    @FXML
    public VBox categoryButtonsContainer;
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
    private MongoDatabase database;

    public VBox Meal_container;

    private Meal meal;


    @FXML
    void click(MouseEvent mouseEvent) {
        listener.onclikListener(meal);
    }

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
        int i = 0;
        for (Document ingredientDocument : ingredientsDocuments) {
            i++;
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientDocument.getString("ingredient" + i + "_name"));
            ingredient.setMesure(ingredientDocument.getString("ingredient" + i + "_mesure"));
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

                UI_Card_Meals_Controller ui_card_controller = fxmlLoader.getController();
                // Set data for each meal card
                ui_card_controller.setData(meal, listener);
                categoryContent.getChildren().add(mealCard);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

       /* // Load meal details card for the first meal (assuming mealList is not empty)
        if (!mealList.isEmpty()) {
            try {
                // Load the FXML directly with the controller
                FXMLLoader detailsLoader = new FXMLLoader(HelloApplication.class.getResource("mealDetails.fxml"));
                VBox mealDetailsCard = detailsLoader.load();

                mealDetails_Controller mealDetailsController = detailsLoader.getController();
                mealDetailsController.showMealDetails(meal);

                // Clear existing meal details cards and add the new one
                chosenmealCard.getChildren().clear();
                chosenmealCard.getChildren().add(mealDetailsCard);
                chosenmealCard.setVisible(true);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/
    }

}

        /*// Update the action for ButtonCard
        ButtonCard.setOnAction(UI_Card_Meals_Controller.handleMealButtonClick(meal));*/



   /* public static void showMealDetails(Meal meal) {
        chosenmealCard.setVisible(false);
        chosenNameMeal.setText(meal.getTitle());
        InstructionsMeal.setText(meal.getInstructions());

        // Display ingredients
        StringBuilder ingredientsText = new StringBuilder();
        for (Ingredient ingredient : meal.getIngredients()) {
            ingredientsText.append(ingredient.getName()).append(": ").append(ingredient.getMeasure()).append("\n");
        }
        IngredientMeal.setText(ingredientsText.toString());

        // Display meal image
        Image mealImage = new Image(meal.getImageMeal());
        imageMeal.setImage(mealImage);

        // Update other UI elements as needed
        mealCountry.setText("Country: " + meal.getCountry());


        //Update the chosenmealCard VBox with the selected meal details
        chosenmealCard.getChildren().clear();
        chosenmealCard.getChildren().addAll(chosenNameMeal, InstructionsMeal, IngredientMeal, imageMeal, mealCountry);
        chosenmealCard.setVisible(true);
    }*/

