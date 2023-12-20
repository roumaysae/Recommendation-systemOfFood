package com.example.javafx_foodrecommandation.presentation;

import com.example.javafx_foodrecommandation.dao.Meal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UI_Consulting_Meals_Controller implements Initializable {

    @FXML
    private BorderPane Container;

    @FXML
    private Text IngredientMeal;

    @FXML
    private Text InstructionsMeal;

    @FXML
    private VBox chosenmealCard;

    @FXML
    private GridPane gridpane;

    @FXML
    private ScrollPane scrollPan;

    private List<Meal> mealList = new ArrayList<>();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mealList.addAll(getData());
        int column = 0;
        int row =0;
        try {
            for (int i = 0; i < mealList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/resources/com/example/javafx_foodrecommandation/UI_Card_Meals.fxml"));

                UI_Card_Meals_Controller ui_card_meals = fxmlLoader.getController();
                ui_card_meals.setData(mealList.get(i));

                AnchorPane anchorPane = fxmlLoader.load();

                    if(column==3){
                        column=0;
                        row++;
                    }
                gridpane.add(anchorPane,column++,row);//child + col + row
                GridPane.setMargin(anchorPane,new Insets(10));
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
        }

    @FXML
    private void controllerMealsCategory(ActionEvent event) {


        }
}

