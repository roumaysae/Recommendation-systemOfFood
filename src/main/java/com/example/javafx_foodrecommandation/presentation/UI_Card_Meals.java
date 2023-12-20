package com.example.javafx_foodrecommandation.presentation;

import com.example.javafx_foodrecommandation.dao.Meal;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
public class UI_Card_Meals {

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
    private ImageView imageMeal;

    @FXML
    private Label nameMeal;

    @FXML
    private ScrollPane scrollPan;

    private Meal meal;

    public void setData(Meal meal) {
        this.meal = meal;
        nameMeal.setText(meal.getTitle());
        Image image = new Image(getClass().getResourceAsStream(meal.getImageMeal()));
        imageMeal.setImage(image);


    }
}