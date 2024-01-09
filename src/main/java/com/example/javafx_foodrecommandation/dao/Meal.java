package com.example.javafx_foodrecommandation.dao;

import java.util.ArrayList;

public class Meal {
        private String title;
        private String instructions;
        private String country;
        private String imageMeal;
        private Categorie categorie;
        private ArrayList<String> ingredients;

    public Meal() {
    }

    public Meal(String title, String instructions, String country, String imageMeal, Categorie categorie, ArrayList<String> ingredients) {
        this.title = title;
        this.instructions = instructions;
        this.country = country;
        this.imageMeal = imageMeal;
        this.categorie = categorie;
        this.ingredients = ingredients;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getIngredient() {
        return ingredients;
    }

    public void setIngredient(String ingredient) {
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageMeal() {
        return imageMeal;
    }

    public void setImageMeal(String imageMeal) {
        this.imageMeal = imageMeal;
    }
}
