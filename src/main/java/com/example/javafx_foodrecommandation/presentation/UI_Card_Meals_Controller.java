package com.example.javafx_foodrecommandation.presentation;

import com.example.javafx_foodrecommandation.HelloApplication;
import com.example.javafx_foodrecommandation.Listener;
import com.example.javafx_foodrecommandation.dao.Meal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Objects;

public class UI_Card_Meals_Controller {
    public VBox Meal_container;
    @FXML
    private Button ButtonCard;
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
    public void setData(Meal meal,Listener listener) {
        this.meal = meal;
        this.listener=listener;
        nameMeal.setText(meal.getTitle());

        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream(meal.getImageMeal())));
        ImageCard.setImage(image);

    }
}
